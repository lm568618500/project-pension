package com.longjun.cto.framework.sm.message.service.impl;

import java.util.Arrays;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.eims.cto.framework.common.base.exception.BusinessException;
import com.eims.cto.framework.plugins.msg.email.api.MsgEmailApi;
import com.eims.cto.framework.plugins.push.umeng.api.UmengPushApi;
import com.eims.cto.framework.plugins.sms.aliyun.api.AliyunSmsApi;
import com.eims.cto.framework.plugins.sms.aliyun.core.SmsTemplate;
import com.eims.cto.framework.plugins.sms.chuanglan.api.ChuanglanSmsApi;
import com.eims.cto.framework.plugins.sms.dxt.api.DxtSmsApi;
import com.eims.cto.framework.plugins.sms.tencent.api.TencentSmsApi;
import com.eims.cto.framework.plugins.sms.tencent.dto.BoolKvDto;
import com.longjun.cto.framework.sm.message.entity.model.MessageEmailModel;
import com.longjun.cto.framework.sm.message.entity.model.MessageMechModel;
import com.longjun.cto.framework.sm.message.entity.model.MessagePushModel;
import com.longjun.cto.framework.sm.message.entity.model.MessageSettingModel;
import com.longjun.cto.framework.sm.message.entity.model.MessageSmsModel;
import com.longjun.cto.framework.sm.message.entity.model.MessageTempEmailModel;
import com.longjun.cto.framework.sm.message.entity.model.MessageTempSmsModel;
import com.longjun.cto.framework.sm.message.entity.view.MessageSettingView;
import com.longjun.cto.framework.sm.message.es.OsTypeEnums;
import com.longjun.cto.framework.sm.message.es.PushChannelEnums;
import com.longjun.cto.framework.sm.message.es.SettingTypeEnums;
import com.longjun.cto.framework.sm.message.es.SmsChannelEnums;
import com.longjun.cto.framework.sm.message.service.IMessageApiService;
import com.longjun.cto.framework.sm.message.service.IMessageEmailService;
import com.longjun.cto.framework.sm.message.service.IMessageMechService;
import com.longjun.cto.framework.sm.message.service.IMessagePushService;
import com.longjun.cto.framework.sm.message.service.IMessageSettingService;
import com.longjun.cto.framework.sm.message.service.IMessageSmsService;
import com.longjun.cto.framework.sm.message.service.IMessageTempEmailService;
import com.longjun.cto.framework.sm.message.service.IMessageTempSmsService;
import com.longjun.cto.framework.sm.sys.service.ISysService;

import cn.hutool.core.convert.Convert;
import cn.hutool.core.lang.Validator;
import cn.hutool.core.util.StrUtil;

/**
 * 消息Api业务实现
 * 
 * @author yangxuan
 * @date 2019年4月6日 下午4:31:20
 */
@Service
public class MessageApiServiceImpl implements IMessageApiService {

	private Logger logger = LoggerFactory.getLogger(this.getClass());

	@Autowired
	private IMessageMechService iMessageMechService;

	@Autowired
	private IMessageSettingService iMessageSettingService;

	@Autowired
	private IMessageTempSmsService iMessageTempSmsService;

	@Autowired
	private IMessageTempEmailService iMessageTempEmailService;

	@Autowired
	private IMessageEmailService iMessageEmailService;

	@Autowired
	private IMessagePushService iMessagePushService;

	@Autowired
	private IMessageSmsService iMessageSmsService;

	@Autowired
	private ISysService iSysService;

	@Override
	public boolean sendSmsByLoop(long tempId, String mobile, Map<String, String> params) throws BusinessException {
		logger.info("消息发送-tempId[{}] , params - >[{}]", tempId, JSONObject.toJSONString(params));
		if (tempId < 0) {
			logger.error("短信发送;模板tempId异常");
			return false;
		}
		if (StrUtil.isBlank(mobile)) {
			logger.error("短信发送;手机号码为空");
			return false;
		}
		// 获取商户信息
		MessageMechModel model = this.iMessageMechService.getByOneUse();
		if (model.getStatus() == 0) {
			logger.error("短信发送失败,未查询到可用商户信息 ");
			return false;
		}
		if (model.getIsDel() == -1) {
			logger.error("短信发送失败,商户信息已删除 ");
			return false;
		}
		if (model.getSupportSms() != 1) {
			logger.error("短信发送失败;商户不支持短信发送;商户ID -> {}", model.getId());
			return false;
		}
		MessageSettingModel settingModel = this.iMessageSettingService.findByMchId2SettingType(model.getId(),
				SettingTypeEnums.SMS);
		if (settingModel == null) {
			logger.error("消息发送失败,未查询到商户接口设置信息-> [{}] ", JSONObject.toJSONString(model));
			return false;
		}
		EntityWrapper mtEw = new EntityWrapper<>();
		mtEw.eq("temp_uid", tempId).eq("status", 1).eq("is_del", 0);
		MessageTempSmsModel messageTempSmsModel = this.iMessageTempSmsService.selectOne(mtEw);
		if (messageTempSmsModel == null) {
			logger.error("短信发送失败;短信模板未查询到结果;tempId -> {}", tempId);
			return false;
		}
		String content = messageTempSmsModel.getSmsContent();
		try {
			if (params != null) {
				for (Entry<String, String> entry : params.entrySet()) {
					content = content.replaceAll("\\{" + entry.getKey() + "\\}", entry.getValue());
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
			logger.error("短信发送异常;异常信息: {}", e.getMessage());
			return false;
		}

		MessageSmsModel record = new MessageSmsModel();
		record.setTime(new Date());
		record.setMobile(mobile);
		record.setTempId(tempId);
		record.setContent(content);
		record.setTempContent(messageTempSmsModel.getSmsContent());
		record.setTempParamsBind(JSONObject.toJSONString(params));
		record.setMechId(model.getId());
		record.setSettingId(settingModel.getId());
		record.setStatus(0);
		record.setCreateTime(System.currentTimeMillis());
		record.setIsDel(0);
		this.iMessageSmsService.insert(record);
		return true;
	}

	@Override
	public boolean sendSms(MessageSmsModel record) throws BusinessException {
		if (record == null) {
			logger.error("短信发送失败,短信对象为空");
			return false;
		}
		if (!Validator.isMobile(record.getMobile())) {
			logger.error("短信发送失败;手机号码校验失败 mobile - > {}", record.getMobile());
			return false;
		}
		if (record.getIsDel() != 0) {
			logger.error("短信发送失败,数据删除状态异常 , is_del - > [{}]", record.getIsDel());
			return false;
		}
		if (record.getStatus() != 0) {
			logger.error("短信发送失败,数据Status状态异常 , status - > [{}]", record.getStatus());
			return false;
		}
		MessageMechModel mechModel = this.iMessageMechService.selectById(record.getMechId());
		if (mechModel == null) {
			logger.error("短信发送失败,未查询到mech_id商户信息, mech_id - > [{}]", record.getMechId());
			return false;
		}
		if (mechModel.getStatus() != 1) {
			logger.error("短信发送失败,mech_id商户信息状态异常, mech_id - > [{}]status[{}]", record.getMechId(),
					mechModel.getStatus());
			return false;
		}
		if (mechModel.getIsDel() != 0) {
			logger.error("短信发送失败,mech_id商户信息删除状态状态异常, mech_id - > [{}]is_del[{}]", record.getMechId(),
					mechModel.getIsDel());
			return false;
		}

		MessageSettingView settingView = this.iMessageSettingService.findViewById(record.getSettingId());
		if (settingView == null) {
			logger.error("短信发送失败,mech_id商户信息未查询到setting配置信息, mech_id - > [{}]setting_id[{}]", record.getMechId(),
					record.getSettingId());
			return false;
		}
		long gatwayId = settingView.getGatwayId();
		SmsChannelEnums e = SmsChannelEnums.match(gatwayId);
		if (e == null) {
			logger.error("短信发送失败;渠道中未获取到渠道网关ID[{}]短信枚举;SmsChannelEnums", gatwayId);
			return false;
		}
		boolean sendRet = false;
		// 获取配置文件;
		JSONObject smsProfile = null;
		try {
			smsProfile = JSONObject.parseObject(settingView.getProfile());
		} catch (Exception ex) {
			ex.printStackTrace();
			logger.error("短信发送失败,获取短信配置信息格式化JSON失败, setting id - > [{}]", settingView.getId());
			return false;
		}
		

//		MessageTempSmsModel tempSmsModel = iMessageTempSmsService.selectById(record.getTempId());
		MessageTempSmsModel tempSmsModel = this.iMessageTempSmsService.findModelByTempUid(record.getTempId() + "");
		if (tempSmsModel == null) {
			logger.error("短信发送失败,未查询到tempUid短信模板信息, tempid - > [{}]", record.getTempId());
			return false;
		}
		if (tempSmsModel.getStatus() != 1) {
			logger.error("短信发送失败,tempid[{}]短信模板信息状态非正常,Status - > [{}]", record.getTempId(), tempSmsModel.getStatus());
			return false;
		}

		JSONObject json = JSONObject.parseObject(record.getTempParamsBind());
		String[] arr = new String[json.entrySet().size()];
		int i = 0;
		for (Entry<String, Object> er : json.entrySet()) {
			arr[i] = er.getValue() + "";
			i++;
		}
		
		// 开发模式不进行短信发送
		if (iSysService.isDev()) {
			sendRet = true;
		} else {
			switch (e) {
			case ALISMS:
				int appId = smsProfile.getIntValue("appId");
				String appkey = smsProfile.getString("appkey");
				TencentSmsApi api = TencentSmsApi.getTencentSmsApi(appId, appkey);
				// Api调用
				BoolKvDto boolKvDto = api.send(Convert.toInt(tempSmsModel.getOtherTemplateId(), 0), record.getMobile(),
						arr);
				sendRet = boolKvDto.isSuccess();
				break;
			case TENCENT:

				String _appId = smsProfile.getString("appId");
				String domain = smsProfile.getString("domain");
				String endpointName = smsProfile.getString("endpointName");
				String product = smsProfile.getString("product");
				String region = smsProfile.getString("region");
				String accessKeyId = smsProfile.getString("accessKeyId");
				String accessKeySecret = smsProfile.getString("accessKeySecret");

				AliyunSmsApi aliSms = AliyunSmsApi.getAliyunSmsApi(_appId, domain, endpointName, product, region,
						accessKeyId, accessKeySecret);

				SmsTemplate smsTemplate = new SmsTemplate();
				smsTemplate.setSignName(null);
				smsTemplate.setTemplateCode(null);
				smsTemplate.setPhoneNumbers(Arrays.asList(record.getMobile()));
				Map<String, String> templateParam = new HashMap<>();
				JSONObject paramJson = JSONObject.parseObject(record.getTempParamsBind());
				if (paramJson != null) {
					for (Entry<String, Object> entry : paramJson.entrySet()) {
						templateParam.put(entry.getKey(), entry.getValue() + "");
					}
				}
				smsTemplate.setTemplateParam(templateParam);
				aliSms.send(smsTemplate);
				break;
			case DXT:
				String appKey = smsProfile.getString("appKey");
				String api_secret = smsProfile.getString("api_secret");
				String sendUrl = smsProfile.getString("sendUrl");
				String smsSign = smsProfile.getString("smsSign");
				DxtSmsApi dxtApi = DxtSmsApi.getDxtSmsApi(appKey, api_secret, sendUrl, smsSign);
				JSONObject dxtRet = dxtApi.send(tempSmsModel.getOtherTemplateId(), record.getMobile(), arr);
				if (dxtRet != null) {
					logger.info("短信通短信发送-> {}", dxtRet.toJSONString());
				}
				int code = dxtRet.getIntValue("code");
				sendRet = code == 200;
				break;
			case SMS253:
				String __appId = smsProfile.getString("appId");
				String user_name = smsProfile.getString("user_name");
				String password = smsProfile.getString("password");
				String send_url = smsProfile.getString("send_url");
				ChuanglanSmsApi chuanglanApi = ChuanglanSmsApi.getChuanglanSmsApi(__appId, user_name, password,
						send_url);
				JSONObject retJson = chuanglanApi.send(record.getMobile(), record.getContent());
				if (retJson == null) {
					sendRet = false;
				} else {
					String _code = retJson.getString("code");
					if ("0".equals(_code)) {
						sendRet = true;
					}
				}
				break;
			}
		}

		if (sendRet)

		{
			record.setLastupdate(new Date());
			record.setSendTime(new Date());
			record.setStatus(1);
			this.iMessageSmsService.updateById(record);
		} else {
			record.setLastupdate(new Date());
			record.setStatus(-1);
			this.iMessageSmsService.updateById(record);
		}
		return sendRet;
	}

	@Override
	public boolean sendEmail(MessageEmailModel record) throws BusinessException {
		if (record == null) {
			logger.error("邮件发送失败,邮件对象为空");
			return false;
		}
		if (StrUtil.isBlank(record.getEmail())) {
			logger.error("邮件发送;收件箱为空");
			return false;
		}
		if (!Validator.isEmail(record.getEmail())) {
			logger.error("邮件发送;收件箱格式错误;邮箱为[{}]", record.getEmail());
			return false;
		}
		if (record.getStatus() != 0) {
			logger.error("邮件发送失败,数据Status状态异常 , status - > [{}]", record.getStatus());
			return false;
		}
		MessageMechModel mechModel = this.iMessageMechService.selectById(record.getMechId());
		if (mechModel == null) {
			logger.error("邮件发送失败,未查询到mech_id商户信息, mech_id - > [{}]", record.getMechId());
			return false;
		}
		if (mechModel.getStatus() != 1) {
			logger.error("邮件发送失败,mech_id商户信息状态异常, mech_id - > [{}]status[{}]", record.getMechId(),
					mechModel.getStatus());
			return false;
		}
		if (mechModel.getIsDel() != 0) {
			logger.error("短信发送失败,mech_id商户信息删除状态状态异常, mech_id - > [{}]is_del[{}]", record.getMechId(),
					mechModel.getIsDel());
			return false;
		}

		MessageSettingView settingView = this.iMessageSettingService.findViewById(record.getSettingId());
		if (settingView == null) {
			logger.error("短信发送失败,mech_id商户信息未查询到setting配置信息, mech_id - > [{}]setting_id[{}]", record.getMechId(),
					record.getSettingId());
			return false;
		}

		JSONObject jsonProfile = null;
		try {
			jsonProfile = JSONObject.parseObject(settingView.getProfile());
		} catch (Exception e) {
			e.printStackTrace();
			logger.error("邮件发送失败;邮件配置格式异常");
			return false;
		}
		String appId = jsonProfile.getString("appId");
		if (StrUtil.isBlank(appId)) {
			logger.error("邮件发送失败;邮件配置缺少[appId]");
			return false;
		}
		String from = jsonProfile.getString("from");
		if (StrUtil.isBlank(from)) {
			logger.error("邮件发送失败;邮件配置缺少[from]");
			return false;
		}
		String user = jsonProfile.getString("user");
		if (StrUtil.isBlank(user)) {
			logger.error("邮件发送失败;邮件配置缺少[user]");
			return false;
		}
		String pass = jsonProfile.getString("pass");
		if (StrUtil.isBlank(pass)) {
			logger.error("邮件发送失败;邮件配置缺少[pass]");
			return false;
		}
		String host = jsonProfile.getString("host");
		if (StrUtil.isBlank(host)) {
			logger.error("邮件发送失败;邮件配置缺少[host]");
			return false;
		}
		int port = jsonProfile.getIntValue("port");
		boolean stop = jsonProfile.getBooleanValue("stop");
		// 暂停使用
		if (stop) {
			logger.error("短信发送失败;邮件配置[stop]为true");
			return false;
		}

		MsgEmailApi api = MsgEmailApi.getMsgEmailApi(appId, host, port, from, user, pass);
		if (api == null) {
			return false;
		}
		try {
			if (!iSysService.isDev()) {

				// 发送短信
				api.send(record.getEmail(), record.getTitle(), record.getContent(), false);
			}
		} catch (Exception e) {
			e.printStackTrace();
			logger.error("短信发送异常;[{}]", e.getMessage());
			return false;
		}
		return true;
	}

	@Override
	public boolean sendEmailByLoop(String email, String title, String content) throws BusinessException {
		if (StrUtil.isBlank(email)) {
			logger.error("邮件发送失败;收件箱为空;");
			return false;
		}
		if (StrUtil.isBlank(title)) {
			logger.error("邮件发送失败;邮件主题为空;");
			return false;
		}
		if (StrUtil.isBlank(content)) {
			logger.error("邮件发送失败;邮件内容为空;");
			return false;
		}
		// 获取默认商户信息
		MessageMechModel messageMechModel = iMessageMechService.getByOneUse();
		if (messageMechModel == null) {
			logger.error("邮件发送失败;未查询到默认商户信息");
			return false;
		}

		int support = messageMechModel.getSupportEmail();
		// 不支持邮件发送
		if (support != 1) {
			logger.error("邮件发送失败;默认商户不支持邮件发送;商户ID[{}]", messageMechModel.getId());
			return false;
		}
		MessageSettingModel messageSettingModel = this.iMessageSettingService
				.findByMchId2GatwayId(messageMechModel.getId(), 200000L);
		if (messageSettingModel == null) {
			logger.error("邮件发送失败;未查询到商户[{}]配置可用邮件渠道信息;", messageMechModel.getId());
			return false;
		}
		/*
		 * String profile = messageSettingModel.getProfile();
		 * if(StrUtil.isBlank(profile)) { logger.error("邮件发送失败;商户ID[{}]短信配置信息为空",
		 * messageMechModel.getId()); return false; }
		 */
		// 数据入库操作;等待定时任务执行
		MessageEmailModel messageEmailModel = new MessageEmailModel();
		messageEmailModel.setTime(new Date());
		messageEmailModel.setLastupdate(new Date());
		messageEmailModel.setEmail(email);
		messageEmailModel.setCc(null);
		messageEmailModel.setAttaments(null);
		messageEmailModel.setTempId(1L);
		messageEmailModel.setTitle(title);
		messageEmailModel.setContent(content);
		messageEmailModel.setSender(null);
		messageEmailModel.setSenderName(null);
		messageEmailModel.setSendTime(null);
		messageEmailModel.setStatus(0);
		messageEmailModel.setMechId(messageMechModel.getId());
		messageEmailModel.setSettingId(messageSettingModel.getId());
		messageEmailModel.setCreateTime(System.currentTimeMillis());
		this.iMessageEmailService.insert(messageEmailModel);
		return true;
	}

	@Override
	public boolean sendPush(MessagePushModel record) throws BusinessException {
		if (record == null) {
			logger.error("推送失败;传入对象为空");
			return false;
		}
		long settingId = record.getSettingId();
		if (settingId < 0) {
			logger.error("推送失败;渠道设置ID非法;settingId -> {}", settingId);
			return false;
		}
		long mchId = record.getMchId();
		if (mchId < 0) {
			logger.error("推送失败;商户ID非法;mchId -> {}", mchId);
			return false;
		}
		String ticker = record.getTicker();
		String title = record.getTitle();
		String devicetoken = record.getDevicetoken();
		if (StrUtil.isBlank(ticker) || StrUtil.isBlank(title) || StrUtil.isBlank(devicetoken)) {
			logger.error("推送失败;ticker、title、devicetoken存在未空 -> {}, {}, {}", ticker, title, devicetoken);
			return false;
		}

		MessageSettingModel messageSettingModel = this.iMessageSettingService.selectById(settingId);
		if (messageSettingModel == null) {
			logger.error("推送失败;未查询到配置t_message_setting 记录 ID -> {}", settingId);
			return false;
		}
		if (messageSettingModel.getSettingType() != SettingTypeEnums.PUSH.getType()) {
			logger.error("推送失败;配置t_message_setting 记录SettingType异常; ID -> {} SettingType-> {}", settingId,
					messageSettingModel.getSettingType());
			return false;
		}

		PushChannelEnums e = PushChannelEnums.match(messageSettingModel.getGatwayId());
		if (e == null) {
			logger.error("无效的推送渠道类型;渠道网关ID -> {} 未在代码配置;请参考PushChannelEnums枚举", messageSettingModel.getGatwayId());
			return false;
		}
		boolean ret = false;
		if (iSysService.isDev()) {
			ret = true;
		} else {
			switch (e) {
			case UMENG:
				ret = this.pushByUmeng(messageSettingModel, record);
				break;

			default:

				break;
			}
		}
		if (ret) {
			record.setLastupdate(new Date());
			record.setStatus(1);
			record.setSendTime(new Date());
			record.setSendTimestamp(System.currentTimeMillis());
			this.iMessagePushService.updateById(record);
		} else {
			record.setLastupdate(new Date());
			record.setStatus(-1);
			this.iMessagePushService.updateById(record);
		}
		return ret;
	}

	private boolean pushByUmeng(MessageSettingModel messageSettingModel, MessagePushModel record) {
		if (StrUtil.isBlank(messageSettingModel.getProfile())) {
			logger.error("友盟推送失败;渠道配置信息profile为空;t_message_setting ID -> {}", messageSettingModel.getId());
			return false;
		}
		JSONObject profile = null;
		try {
			profile = JSONObject.parseObject(messageSettingModel.getProfile());
		} catch (Exception e) {
			e.printStackTrace();
			logger.error("友盟推送失败;渠道配置信息profile格式非法;t_message_setting ID -> {} profile - > {}",
					messageSettingModel.getId(), messageSettingModel.getProfile());
			return false;
		}
		OsTypeEnums e = OsTypeEnums.match(record.getOsType());
		if (e == null) {
			logger.error("友盟推送失败;osType非法, 程序枚举未找到(OsTypeEnums); osType -> {} 请参考OsTypeEnums枚举;", record.getOsType());
			return false;
		}
		String appId = profile.getString("appId");
		String uPushAndroidAppKey = profile.getString("uPushAndroidAppKey");
		String uPushAndroidAppMasterSecret = profile.getString("uPushAndroidAppMasterSecret");
		String uPushIosAppKey = profile.getString("uPushIosAppKey");
		String uPushIosAppAppMasterSecret = profile.getString("uPushIosAppAppMasterSecret");
		UmengPushApi api = UmengPushApi.getUmengPushApi(appId, uPushAndroidAppKey, uPushAndroidAppMasterSecret,
				uPushIosAppKey, uPushIosAppAppMasterSecret);
		boolean ret = false;
		try {
			switch (e) {
			case Android:
				ret = api.sendAndroidUnicast(record.getDevicetoken(), record.getTicker(), record.getTitle(),
						record.getPushText(), JSONObject.parseObject(record.getExtrafield()));
				break;

			case iOS:
				ret = api.sendIOSUnicast(record.getDevicetoken(), record.getTicker(),
						JSONObject.parseObject(record.getExtrafield()));
				break;
			}
		} catch (Exception ex) {
			ex.printStackTrace();
			logger.error("友盟推送失败;接口调用异常; -> {}", ex.getMessage());
			return false;
		}

		return ret;
	}

	@Override
	public boolean sendPushByLoop(OsTypeEnums osTypeEnums, String ticker, String title, String push_text,
			Map<String, Object> extrafield, String devicetoken, Map<String, Object> customizedMap, boolean isPlain,
			Date plainTime) throws BusinessException {

		if (StrUtil.isBlank(ticker)) {
			logger.error("推送发送失败;ticker为空;");
			return false;
		}
		if (StrUtil.isBlank(title)) {
			logger.error("推送发送失败;title为空;");
			return false;
		}
		if (StrUtil.isBlank(push_text)) {
			logger.error("推送发送失败;push_text为空;");
			return false;
		}
		// 获取默认商户信息
		MessageMechModel messageMechModel = iMessageMechService.getByOneUse();
		if (messageMechModel == null) {
			logger.error("推送发送失败;未查询到默认商户信息");
			return false;
		}

		int support = messageMechModel.getSupportPush();
		// 不支持推送发送
		if (support != 1) {
			logger.error("推送发送失败;默认商户不支持推送发送;商户ID[{}]", messageMechModel.getId());
			return false;
		}
		MessageSettingModel messageSettingModel = this.iMessageSettingService
				.findByMchId2SettingType(messageMechModel.getId(), SettingTypeEnums.PUSH);
		if (messageSettingModel == null) {
			logger.error("推送发送失败;未查询到商户[{}]配置可用推送渠道信息;", messageMechModel.getId());
			return false;
		}
		MessagePushModel pushModel = new MessagePushModel();
		pushModel.setTime(new Date());
		pushModel.setLastupdate(new Date());
		pushModel.setStatus(0); // 待发送
		pushModel.setIsDel(0);
		pushModel.setMchId(messageMechModel.getId());
		pushModel.setSettingId(messageSettingModel.getId());
		pushModel.setOsType(osTypeEnums.getType());
		pushModel.setTicker(ticker);
		pushModel.setTitle(title);
		pushModel.setPushText(push_text);
		pushModel.setExtrafield(JSONObject.toJSONString(extrafield));
		pushModel.setDevicetoken(devicetoken);
		pushModel.setCustomizedMap(JSONObject.toJSONString(customizedMap));
		pushModel.setSendTime(null);
		pushModel.setSendTimestamp(0L);
		pushModel.setIsPlain(isPlain ? 1 : 0);
		pushModel.setPlainTime(isPlain ? plainTime : null);
		iMessagePushService.insert(pushModel);
		return true;
	}

	@Override
	public boolean sendEmailByLoop(long tempId, String email, Map<String, String> params) throws BusinessException {
		logger.info("消息发送-tempId[{}] , params - >[{}]", tempId, JSONObject.toJSONString(params));
		if (tempId < 0) {
			logger.error("邮件发送;模板tempId异常");
			return false;
		}
		if (StrUtil.isBlank(email)) {
			logger.error("邮件发送;邮箱为空");
			return false;
		}
		// 获取商户信息
		MessageMechModel model = this.iMessageMechService.getByOneUse();
		if (model.getStatus() == 0) {
			logger.error("邮件发送失败,未查询到可用商户信息 ");
			return false;
		}
		if (model.getIsDel() == -1) {
			logger.error("邮件发送失败,商户信息已删除 ");
			return false;
		}
		if (model.getSupportEmail() != 1) {
			logger.error("邮件发送失败;商户不支持邮件发送;商户ID -> {}", model.getId());
			return false;
		}
		MessageSettingModel settingModel = this.iMessageSettingService.findByMchId2SettingType(model.getId(),
				SettingTypeEnums.EMAIL);
		if (settingModel == null) {
			logger.error("邮件发送失败,未查询到商户接口设置信息-> [{}] ", JSONObject.toJSONString(model));
			return false;
		}
		EntityWrapper mtEw = new EntityWrapper<>();
		mtEw.eq("temp_uid", tempId).eq("status", 1).eq("is_del", 0);
		MessageTempEmailModel messageTempEmailModel = this.iMessageTempEmailService.selectOne(mtEw);
		if (messageTempEmailModel == null) {
			logger.error("邮件发送失败;邮件模板未查询到结果;tempId -> {}", tempId);
			return false;
		}
		String content = messageTempEmailModel.getEmailContent();
		try {
			if (params != null) {
				for (Entry<String, String> entry : params.entrySet()) {
					content = content.replaceAll("\\{" + entry.getKey() + "\\}", entry.getValue());
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
			logger.error("邮件发送异常;异常信息: {}", e.getMessage());
			return false;
		}
		MessageEmailModel record = new MessageEmailModel();
		record.setTime(new Date());
		record.setLastupdate(null);
		record.setEmail(email);
		record.setCc(null);
		record.setAttaments(null);
		record.setTempId(tempId);
		record.setContent(content);
		record.setMechId(model.getId());
		record.setSettingId(settingModel.getId());
		record.setStatus(0);
		record.setCreateTime(System.currentTimeMillis());
		this.iMessageEmailService.insert(record);
		return true;
	}

}
