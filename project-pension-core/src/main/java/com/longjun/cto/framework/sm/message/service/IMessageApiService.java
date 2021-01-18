package com.longjun.cto.framework.sm.message.service;

import java.util.Date;
import java.util.Map;

import com.eims.cto.framework.common.base.exception.BusinessException;
import com.longjun.cto.framework.sm.message.entity.model.MessageEmailModel;
import com.longjun.cto.framework.sm.message.entity.model.MessagePushModel;
import com.longjun.cto.framework.sm.message.entity.model.MessageSmsModel;
import com.longjun.cto.framework.sm.message.es.OsTypeEnums;

/**
 * 消息Api业务
 * 
 * @author yangxuan
 * @date 2019年4月6日 下午4:21:52
 */
public interface IMessageApiService {

	/**
	 * 短信发送-提供给业务调用。业务调用存入数据库，定时任务进行发送
	 * @param tempId 模板ID t_message_temp_sms 中temp_uid
	 * @param mobile 手机号码
	 * @param params 参数
	 * @return
	 * @throws BusinessException
	 */
	public boolean sendSmsByLoop(long tempId, String mobile, Map<String, String> params) throws BusinessException;

	/**
	 * 短信发送 - 定时任务使用
	 * 
	 * @param record
	 * @throws BusinessException
	 */
	public boolean sendSms(MessageSmsModel record) throws BusinessException;

	/**
	 * 邮件发送
	 * 
	 * @param record
	 * @return
	 * @throws BusinessException
	 */
	public boolean sendEmail(MessageEmailModel record) throws BusinessException;

	/**
	 * 保存数据;用于邮件发送;只是做数据存储;提供给业务使用;在实现类中;将会查询平台默认的商户信息;此方法只是针对单平台有效;也是最常见的;
	 * @param tempId 模板ID t_message_temp_email ID
	 * @param email 收件人
	 * @param params 参数
	 * @return
	 * @throws BusinessException
	 */
	public boolean sendEmailByLoop(long tempId, String email, Map<String, String> params) throws BusinessException;

	

	/**
	 * 保存数据;用于邮件发送;只是做数据存储;提供给业务使用;在实现类中;将会查询平台默认的商户信息;此方法只是针对单平台有效;也是最常见的;
	 * 
	 * @param email
	 * @param title
	 * @param content
	 * @return
	 * @throws BusinessException
	 */
	public boolean sendEmailByLoop(String email, String title, String content) throws BusinessException;
	
	/**
	 * 推送
	 * 
	 * @param record
	 * @return
	 * @throws BusinessException
	 */
	public boolean sendPush(MessagePushModel record) throws BusinessException;

	/**
	 * 队列发送
	 * 
	 * @param osTypeEnums   操作平台
	 * @param ticker        通知栏提示文字
	 * @param title         通知标题
	 * @param push_text     通知文字描述
	 * @param extrafield    JSON格式，用户自定义key-value。只对"通知"
	 * @param devicetoken   表示指定的单个设备
	 * @param customizedMap
	 * @param isPlain       是否计划发送
	 * @param plainTime     计划发送时间
	 * @return
	 * @throws BusinessException
	 */
	public boolean sendPushByLoop(OsTypeEnums osTypeEnums, String ticker, String title, String push_text,
			Map<String, Object> extrafield, String devicetoken, Map<String, Object> customizedMap, boolean isPlain,
			Date plainTime) throws BusinessException;

}
