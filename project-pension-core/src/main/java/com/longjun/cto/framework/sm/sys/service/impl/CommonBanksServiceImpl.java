package com.longjun.cto.framework.sm.sys.service.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.eims.cto.framework.common.base.enums.ErrorTableEnum;
import com.eims.cto.framework.common.base.exception.BusinessException;
import com.eims.cto.framework.common.base.page.PageUtils;
import com.eims.cto.framework.module.base.service.BaseServiceImpl;
import com.longjun.cto.framework.sm.sys.entity.dto.CommonBanksDto;
import com.longjun.cto.framework.sm.sys.entity.model.CommonBanksModel;
import com.longjun.cto.framework.sm.sys.entity.view.CommonBanksView;
import com.longjun.cto.framework.sm.sys.mapper.CommonBanksMapper;
import com.longjun.cto.framework.sm.sys.service.ICommonBanksService;

/**
 * 通用-银行表Service Impl
 * @author yangxuan
 * @date 2018-11-24 13:39:27
 */
 @Service
public class CommonBanksServiceImpl extends BaseServiceImpl<CommonBanksMapper,CommonBanksModel> 
	implements ICommonBanksService {

	@Autowired
	CommonBanksMapper mapper;
	
	@Override
	public boolean setStatusById(long id, int status) throws BusinessException {
		try{
			CommonBanksModel model = this.selectById(id);
			model.setId(id);
			model.setStatus(status);
			this.updateById(model);
		}catch(Exception e){
			e.printStackTrace();
			throw new BusinessException(ErrorTableEnum.G0000500);
		}
		return false;
	}
	
	void saveModelBefore(CommonBanksModel model) throws BusinessException {
		//TOOD 校验等操作
	}
	
	void saveModelAfter(CommonBanksModel model) throws BusinessException {
		//TOOD 校验等操作
	}

	@Override
	public Long saveModel(CommonBanksModel model) throws BusinessException {
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
	public PageUtils<CommonBanksView> getByPage(CommonBanksDto dto) throws BusinessException {
		try{
			startPage(dto);
			List<CommonBanksView> ret = this.mapper.getByPage(dto);
			return new PageUtils<CommonBanksView>(ret);
		}catch(Exception e){
			e.printStackTrace();
			throw new BusinessException(ErrorTableEnum.G0000500);
		}
	}

	@Override
	public CommonBanksView getById(long id) throws BusinessException {
		try{
			CommonBanksModel model = this.selectById(id);
			return new CommonBanksView(model);
		}catch(Exception e){
			e.printStackTrace();
			throw new BusinessException(ErrorTableEnum.G0000500);
		}
	}
	
	@Override
	public boolean saveModel(
		String bankCode,  
		String bankName,  
		String bankLogo,  
		int sort,  
		int status ,
		int cash , 
		int withdraw
		) throws BusinessException {
		if(StringUtils.isBlank(bankCode) || StringUtils.isBlank(bankName)){
			throw new BusinessException("银行代码/名称不能为空");
		}
		EntityWrapper wrapper = new EntityWrapper();
		wrapper.eq("bank_code", bankCode);
		CommonBanksModel codeRet = this.selectOne(wrapper);
		if(codeRet != null){
			throw new BusinessException("银行编码已存在.");
		}
		wrapper = new EntityWrapper();
		wrapper.eq("bank_name", bankName);
		CommonBanksModel nameRet = this.selectOne(wrapper);
		if(nameRet != null){
			throw new BusinessException("银行名称已存在.");
		}
		
		
		try{
			CommonBanksModel model = new CommonBanksModel();
			model.setTime(new Date());
			model.setBankCode(bankCode);
			model.setBankName(bankName);
			model.setBankLogo(bankLogo);
			model.setSort(sort);
			model.setLastupdate(new Date());
			model.setStatus(status);
			model.setCash(cash);
			model.setWithdraw(withdraw);
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
		String bankCode,  
		String bankName,  
		String bankLogo,  
		int sort,  
		int status ,
		int cash , 
		int withdraw
		) throws BusinessException {
		try{
			CommonBanksModel model = this.selectById(id);
			model.setBankCode(bankCode);
			model.setBankName(bankName);
			model.setBankLogo(bankLogo);
			model.setSort(sort);
			model.setLastupdate(new Date());
			model.setStatus(status);
			model.setCash(cash);
			model.setWithdraw(withdraw);
			this.updateById(model);
			return true;
		}catch(Exception e){
			e.printStackTrace();
			throw new BusinessException(ErrorTableEnum.G0000500);
		}
	}

	@Override
	public List<CommonBanksView> listByStatus(int status) throws BusinessException {
		EntityWrapper wrapper = new EntityWrapper();
		wrapper.eq("status", USE);
		List<CommonBanksModel> models = this.selectList(wrapper);
		List<CommonBanksView> ret = new ArrayList<CommonBanksView>();
		if(models == null) {
			return ret;
		}
		for(CommonBanksModel model : models) {
			ret.add(new CommonBanksView(model));
		}
		return ret;
	}

}
