package com.longjun.cto.framework.sm.sys.service.impl;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.eims.cto.framework.common.base.annotation.CacheEvictBatch;
import com.eims.cto.framework.common.base.enums.ErrorTableEnum;
import com.eims.cto.framework.common.base.exception.BusinessException;
import com.eims.cto.framework.common.base.page.PageUtils;
import com.eims.cto.framework.module.base.service.BaseServiceImpl;
import com.longjun.cto.framework.sm.sys.entity.dto.CommonOptionDto;
import com.longjun.cto.framework.sm.sys.entity.model.CommonOptionModel;
import com.longjun.cto.framework.sm.sys.entity.view.CommonOptionView;
import com.longjun.cto.framework.sm.sys.mapper.CommonOptionMapper;
import com.longjun.cto.framework.sm.sys.service.ICommonOptionService;

import cn.hutool.core.convert.Convert;

/**
 * 通用-设置业务
 * 
 * @author yangxuan
 * @date 2018年11月7日 下午5:46:36
 */
@Service
public class CommonOptionServiceImpl extends BaseServiceImpl<CommonOptionMapper, CommonOptionModel>
		implements ICommonOptionService {

	@Autowired
	CommonOptionMapper commonOptionMapper;

	@Cacheable(value = "buz-cache-standard-com.eims.cto.framework.standard.common.service.impl.CommonTdkServiceImpl",
			keyGenerator = "keyGenerator",unless = "#result == null")
	@Override
	public CommonOptionView getById(long id) throws BusinessException {
		try {
			return this.commonOptionMapper.getById(id);
		} catch (Exception e) {
			e.printStackTrace();
			throw new BusinessException(ErrorTableEnum.G0000500);
		}
	}

	@Cacheable(value = "buz-cache-standard-com.eims.cto.framework.standard.common.service.impl.CommonTdkServiceImpl",
			keyGenerator = "keyGenerator",unless = "#result == null")
	@Override
	public CommonOptionView getByUseId(long useId) throws BusinessException {
		try {
			return this.commonOptionMapper.getByUseId(useId);
		} catch (Exception e) {
			e.printStackTrace();
			throw new BusinessException(ErrorTableEnum.G0000500);
		}
	}

	@CacheEvictBatch
	@Override
	public boolean setInfo(CommonOptionModel model) throws BusinessException {
		try {
			return this.commonOptionMapper.setInfo(model) > 0 ? true : false;
		} catch (Exception e) {
			e.printStackTrace();
			throw new BusinessException(ErrorTableEnum.G0000500);
		}
	}

	@Cacheable(value = "buz-cache-standard-com.eims.cto.framework.standard.common.service.impl.CommonTdkServiceImpl",
			keyGenerator = "keyGenerator",unless = "#result == null")
	@Override
	public List<CommonOptionView> getList() throws BusinessException {
		try {
			return this.commonOptionMapper.getList();
		} catch (Exception e) {
			e.printStackTrace();
			throw new BusinessException(ErrorTableEnum.G0000500);
		}
	}

	@Override
	public PageUtils<CommonOptionView> getByPage(CommonOptionDto dto) throws BusinessException {
		try {
			startPage(dto);
			List<CommonOptionView> ret = this.commonOptionMapper.getByPage(dto);
			return new PageUtils<>(ret);
		} catch (Exception e) {
			e.printStackTrace();
			throw new BusinessException(ErrorTableEnum.G0000500);
		}
	}

	@Cacheable(value = "buz-cache-standard-com.eims.cto.framework.standard.common.service.impl.CommonTdkServiceImpl",
			keyGenerator = "keyGenerator",unless = "#result == null")
	@Override
	public Map<String, Object> initMap() throws BusinessException {
		List<CommonOptionView> list = this.getList();
		Map<String, Object> map = new HashMap<String, Object>();
		for (CommonOptionView v : list) {
			map.put(v.getKey(), v.getValue());
		}
		return map;
	}

	@Override
	public boolean updateModelByKeyVal(String key, String value) throws BusinessException {
		return this.commonOptionMapper.updateModelByKeyVal(key, value) > 0 ? true : false;
	}

	@Override
	public CommonOptionView findByKey(String key) throws BusinessException {
		Map<String,Object> params = new HashMap<>();
		params.put("c_key", key);
		params.put("c_status", 1);
		List<CommonOptionView> rets = this.commonOptionMapper.listModelMap(params);
		if(rets != null && rets.size() > 0){
			return rets.get(0);
		}
		return null;
	}
}
