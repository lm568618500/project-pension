package ${codeParentPakage}.${codePakage}.service.impl;

import com.eims.cto.framework.module.base.model.BaseDTO;
import com.eims.cto.framework.common.base.exception.BusinessException;
import com.eims.cto.framework.common.base.page.PageUtils;
import com.eims.cto.framework.module.base.service.BaseService;
import com.eims.cto.framework.module.base.service.BaseServiceImpl;
import java.util.List;
import java.util.Date;
import  ${codeParentPakage}.${codePakage}.service.I${className}Service;
import  ${codeParentPakage}.${codePakage}.mapper.${className}Mapper;
import  ${codeParentPakage}.${codePakage}.entity.model.${className}Model;
import  ${codeParentPakage}.${codePakage}.entity.view.${className}View;
import  ${codeParentPakage}.${codePakage}.entity.dto.${className}Dto;
import  ${codeParentPakage}.${codePakage}.entity.dto.${className}ModifyDto;
import org.springframework.beans.factory.annotation.Autowired;
import com.alibaba.fastjson.JSONObject;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import org.springframework.stereotype.Service;
import org.apache.commons.beanutils.BeanUtils;

/**
 * ${className}ServiceImpl
 * @author ${author}
 * @date ${crateDate}
 */
 @Service
public class ${className}ServiceImpl  extends 
					BaseServiceImpl<${className}Mapper , ${className}Model> 
						implements I${className}Service {

	@Autowired
	${className}Mapper mapper;
	
	@Override
	public ${className}View findViewById(long id) throws BusinessException {
		${className}View ret = this.mapper.findViewById(id);
		return ret;
	}

	@Override
	public ${className}Model findModelById(long id) throws BusinessException {
		${className}Model model = this.selectById(id);
		if(model == null) {
			log.warn("${className} 通过ID查询结果为空");
			return null;
		}
		return model;
	}

	@Override
	public void saveModel(${className}Model model) throws BusinessException {
		log.info("${className} 数据新增 -> [{}]" , JSONObject.toJSONString(model));
		super.insert(model);	
	}
	
	@Override
	public boolean start(long id) throws BusinessException {
		${className}Model model = super.selectById(id);
		if(model == null) {
			log.error("${className} 开启操作,ID[{}]未查询到数据信息" , id);
			return false;
		}
		if(model.getStatus() == USE){
			return true;
		}
		model.setStatus(USE);
		model.setLastupdate(new Date());
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
		${className}Model model = super.selectById(id);
		if(model == null) {
			log.error("${className} 停止操作,ID[{}]未查询到数据信息" , id);
			return false;
		}
		if(model.getStatus() == UNUSE){
			return true;
		}
		model.setStatus(UNUSE);
		model.setLastupdate(new Date());
		boolean ret = super.updateById(model);
		return ret;
	}
	
	@Override
	public PageUtils<${className}View> getByPage(${className}Dto dto) throws BusinessException {
		startPage(dto);
		List<${className}View> ret = this.mapper.getByPage(dto);
		PageUtils<${className}View> pages =  new PageUtils<${className}View>(ret);
		return pages;
	}
	
	@Override
	public List<${className}View> listByLimitStatus(int status, int limit) throws BusinessException {
		Map<String , Object> params = new HashMap<String , Object>();
		params.put("c_status", status);
		params.put("c_limit", limit);
		List<${className}View> rets = this.mapper.listModelMap(params);
		if(rets == null) {
			return new ArrayList<${className}View>();
		}
		return rets;
	}
	
	@Override
	public int countAll() throws BusinessException {
		int count = this.mapper.countMap(new HashMap<>());
		return count;
	}

	@Override
	public List<${className}View> listAll() throws BusinessException {
		List<${className}View> rets = this.mapper.listModelMap(new HashMap<>());
		if(rets == null) {
			return new ArrayList<${className}View>();
		}
		return rets;
	}
	
	@Override
	public boolean modify(${className}ModifyDto dto) throws BusinessException {
		if(dto == null) {
			log.error("${className} 修改失败;传入对象为空");
			return false;
		}
		${className}Model model = super.selectById(dto.getId());
		if(model == null) {
			log.error("${className} 修改失败;通过ID[{}]未查询到数据", dto.getId());
			return false;
		}
		${className}Model uModel = new ${className}Model();
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
