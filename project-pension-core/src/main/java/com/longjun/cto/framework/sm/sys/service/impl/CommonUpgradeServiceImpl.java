package com.longjun.cto.framework.sm.sys.service.impl;

import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.imageio.ImageIO;

import org.apache.commons.beanutils.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.alibaba.fastjson.JSONObject;
import com.eims.cto.framework.common.base.exception.BusinessException;
import com.eims.cto.framework.common.base.page.PageUtils;
import com.eims.cto.framework.module.base.service.BaseServiceImpl;
import com.longjun.cto.framework.sm.sys.entity.dto.CommonUpgradeDto;
import com.longjun.cto.framework.sm.sys.entity.dto.CommonUpgradeModifyDto;
import com.longjun.cto.framework.sm.sys.entity.dto.CommonUpgradeSaveDto;
import com.longjun.cto.framework.sm.sys.entity.model.CommonUpgradeModel;
import com.longjun.cto.framework.sm.sys.entity.view.CommonUpgradeView;
import com.longjun.cto.framework.sm.sys.mapper.CommonUpgradeMapper;
import com.longjun.cto.framework.sm.sys.service.ICommonUpgradeService;
import com.longjun.cto.framework.sm.sys.service.OssService;

import cn.hutool.core.bean.BeanUtil;
import cn.hutool.core.util.StrUtil;
import cn.hutool.extra.qrcode.QrCodeUtil;

/**
 * CommonUpgradeServiceImpl
 * @author yangxuan
 * @date 2019-04-04 07:49:24
 */
 @Service
public class CommonUpgradeServiceImpl  extends 
					BaseServiceImpl<CommonUpgradeMapper , CommonUpgradeModel> 
						implements ICommonUpgradeService {

	@Autowired
	CommonUpgradeMapper mapper;
	
	@Autowired
	OssService ossService;
	
	@Override
	public CommonUpgradeView findViewById(long id) throws BusinessException {
		CommonUpgradeView ret = this.mapper.findViewById(id);
		return ret;
	}

	@Override
	public CommonUpgradeModel findModelById(long id) throws BusinessException {
		CommonUpgradeModel model = this.selectById(id);
		if(model == null) {
			log.warn("CommonUpgrade 通过ID查询结果为空");
			return null;
		}
		return model;
	}

	@Override
	public void saveModel(CommonUpgradeSaveDto dto) throws BusinessException {
		log.info("CommonUpgrade 数据新增 -> [{}]" , JSONObject.toJSONString(dto));
		CommonUpgradeModel model = new CommonUpgradeModel();
		BeanUtil.copyProperties(dto, model);
		if(StrUtil.isBlank(dto.getDownUrl())) {
			model.setDownUrl(dto.getLocalUrl());
		}else {
			model.setDownUrl(dto.getDownUrl());
		}
//		// 生成指定url对应的二维码到文件，宽和高都是300像素
//		BufferedImage bufferedImage = QrCodeUtil.generate(model.getDownUrl(), 300, 300);
//		ByteArrayOutputStream os = new ByteArrayOutputStream();
//		try {
//			ImageIO.write(bufferedImage, "png", os);
//		} catch (IOException e) {
//			e.printStackTrace();
//		}
//		InputStream is = new ByteArrayInputStream(os.toByteArray());
//		ossService.save(is, dto.getFileName() + ".png");
		model.setLastupdate(new Date());
		model.setIsDel(0); //不删除
		model.setAdminId(1L);  //默认给超管
		model.setStatus(1);
		model.setPubTime(new Date());
		model.setPlatForm(1); //平台， 1安卓 2IOS     
		model.setDownType(1); //下载类型， 1、本地 2、第三方
		model.setFileName(model.getDownUrl());
		super.insert(model);	
	}
	
	@Override
	public boolean start(long id) throws BusinessException {
		CommonUpgradeModel model = super.selectById(id);
		if(model == null) {
			log.error("CommonUpgrade 开启操作,ID[{}]未查询到数据信息" , id);
			return false;
		}
		if(model.getStatus() == USE){
			return true;
		}
		model.setStatus(USE);
		boolean ret = super.updateById(model);
		return ret;
	}
	
	@Override
	public boolean del(long id) throws BusinessException {
		int ret = this.mapper.del(id);
		return ret > 0 ? true : false;
	}

	@Override
	public boolean stop(long id) throws BusinessException {
		CommonUpgradeModel model = super.selectById(id);
		if(model == null) {
			log.error("CommonUpgrade 停止操作,ID[{}]未查询到数据信息" , id);
			return false;
		}
		if(model.getStatus() == UNUSE){
			return true;
		}
		model.setStatus(UNUSE);
		boolean ret = super.updateById(model);
		return ret;
	}
	
	@Override
	public PageUtils<CommonUpgradeView> getByPage(CommonUpgradeDto dto) throws BusinessException {
		startPage(dto);
		List<CommonUpgradeView> ret = this.mapper.getByPage(dto);
		PageUtils<CommonUpgradeView> pages =  new PageUtils<CommonUpgradeView>(ret);
		return pages;
	}
	
	@Override
	public List<CommonUpgradeModel> listByLimitStatus(int status, int limit) throws BusinessException {
		Map<String , Object> params = new HashMap<String , Object>();
		params.put("c_status", status);
		params.put("c_limit", limit);
		List<CommonUpgradeModel> rets = this.mapper.listModelMap(params);
		if(rets == null) {
			return new ArrayList<CommonUpgradeModel>();
		}
		return rets;
	}
	
	@Override
	public int countAll() throws BusinessException {
		int count = this.mapper.countMap(new HashMap<>());
		return count;
	}

	@Override
	public List<CommonUpgradeModel> listAll() throws BusinessException {
		List<CommonUpgradeModel> rets = this.mapper.listModelMap(new HashMap<>());
		if(rets == null) {
			return new ArrayList<CommonUpgradeModel>();
		}
		return rets;
	}
	
	@Override
	public boolean modify(CommonUpgradeModifyDto dto) throws BusinessException {
		if(dto == null) {
			log.error("CommonUpgrade 修改失败;传入对象为空");
			return false;
		}
		CommonUpgradeModel model = super.selectById(dto.getId());
		if(model == null) {
			log.error("CommonUpgrade 修改失败;通过ID[{}]未查询到数据", dto.getId());
			return false;
		}
		CommonUpgradeModel uModel = new CommonUpgradeModel();
		try {
			BeanUtils.copyProperties(uModel, dto);
			boolean ret = super.updateById(uModel);
			return ret;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		} 
	}
	
}
