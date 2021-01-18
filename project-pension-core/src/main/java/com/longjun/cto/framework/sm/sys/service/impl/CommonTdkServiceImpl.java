package com.longjun.cto.framework.sm.sys.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.eims.cto.framework.common.base.enums.ErrorTableEnum;
import com.eims.cto.framework.common.base.exception.BusinessException;
import com.eims.cto.framework.common.base.page.PageUtils;
import com.eims.cto.framework.module.base.service.BaseServiceImpl;
import com.longjun.cto.framework.sm.sys.entity.dto.CommonTdkDto;
import com.longjun.cto.framework.sm.sys.entity.model.CommonTdkModel;
import com.longjun.cto.framework.sm.sys.entity.view.CommonTdkView;
import com.longjun.cto.framework.sm.sys.mapper.CommonTdkMapper;
import com.longjun.cto.framework.sm.sys.service.ICommonTdkService;

/**
 * Service Impl
 * @author yangxuan
 * @date 2018-11-26 10:56:04
 */
 @Service
public class CommonTdkServiceImpl extends BaseServiceImpl<CommonTdkMapper,CommonTdkModel> 
	implements ICommonTdkService {

	@Autowired
	CommonTdkMapper mapper;
	
	@Override
	public boolean setStatusById(long id, int status) throws BusinessException {
		try{
			CommonTdkModel model = this.selectById(id);
			model.setId(id);
			model.setStatus(status);
			this.updateById(model);
		}catch(Exception e){
			e.printStackTrace();
			throw new BusinessException(ErrorTableEnum.G0000500);
		}
		return false;
	}
	
	void saveModelBefore(CommonTdkModel model) throws BusinessException {
		//TOOD 校验等操作
	}
	
	void saveModelAfter(CommonTdkModel model) throws BusinessException {
		//TOOD 校验等操作
	}

	@Override
	public Long saveModel(CommonTdkModel model) throws BusinessException {
		try{
			this.saveModelBefore(model);
			this.insert(model);
			this.saveModelAfter(model);
			return model.getId();
		}catch(Exception e){
			e.printStackTrace();
			throw new BusinessException(ErrorTableEnum.G0000500);
		}
	}

	@Override
	public boolean start(long id) throws BusinessException {
		return this.setStatusById(id, USE);
	}

	@Override
	public boolean stop(long id) throws BusinessException {
		return this.setStatusById(id, UNUSE);
	}

	@Override
	public PageUtils<CommonTdkView> getByPage(CommonTdkDto dto) throws BusinessException {
		try{
			startPage(dto);
			List<CommonTdkView> ret = this.mapper.getByPage(dto);
			return new PageUtils<CommonTdkView>(ret);
		}catch(Exception e){
			e.printStackTrace();
			throw new BusinessException(ErrorTableEnum.G0000500);
		}
	}

	@Override
	public CommonTdkView getById(long id) throws BusinessException {
		try{
			CommonTdkModel model = this.selectById(id);
			return new CommonTdkView(model);
		}catch(Exception e){
			e.printStackTrace();
			throw new BusinessException(ErrorTableEnum.G0000500);
		}
	}
	
	@Override
	public boolean saveModel(
		java.util.Date time,  
		java.util.Date lastupdate,  
		int status,  
		String title,  
		String keyword,  
		String uri,  
		String description,  
		String helptis,  
		String crumbs 
		) throws BusinessException {
		try{
			CommonTdkModel model = new CommonTdkModel();
			model.setTime(time);
			model.setLastupdate(lastupdate);
			model.setStatus(status);
			model.setTitle(title);
			model.setKeyword(keyword);
			model.setUri(uri);
			model.setDescription(description);
			model.setHelptis(helptis);
			model.setCrumbs(crumbs);
			this.insert(model);
			return true;
		}catch(Exception e){
			e.printStackTrace();
			throw new BusinessException(ErrorTableEnum.G0000500);
		}
	}
	
	@Override
	public boolean modify(
		long id,  
		java.util.Date time,  
		java.util.Date lastupdate,  
		int status,  
		String title,  
		String keyword,  
		String uri,  
		String description,  
		String helptis,  
		String crumbs 
		) throws BusinessException {
		try{
			CommonTdkModel model = this.selectById(id);
			model.setTime(time);
			model.setLastupdate(lastupdate);
			model.setStatus(status);
			model.setTitle(title);
			model.setKeyword(keyword);
			model.setUri(uri);
			model.setDescription(description);
			model.setHelptis(helptis);
			model.setCrumbs(crumbs);
			this.updateById(model);
			return true;
		}catch(Exception e){
			e.printStackTrace();
			throw new BusinessException(ErrorTableEnum.G0000500);
		}
	}

	
	@Cacheable(value = "buz-cache-standard-com.eims.cto.framework.standard.common.service.impl.CommonTdkServiceImpl",
			keyGenerator = "keyGenerator",unless = "#result == null")
	@Override
	public CommonTdkView getByUri(String uri) throws BusinessException {
		EntityWrapper wrapper = new EntityWrapper<>();
		wrapper.eq("uri", uri).eq("status", USE);
		CommonTdkModel model = this.selectOne(wrapper);
		if(model == null) {
			return null;
		}
		return new CommonTdkView(model);
	}

}
