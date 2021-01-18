package com.longjun.cto.framework.sm.sys.service.impl;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.eims.cto.framework.common.base.annotation.CacheEvictBatch;
import com.eims.cto.framework.common.base.enums.ErrorTableEnum;
import com.eims.cto.framework.common.base.exception.BusinessException;
import com.eims.cto.framework.common.base.page.PageUtils;
import com.eims.cto.framework.module.base.service.BaseServiceImpl;
import com.longjun.cto.framework.sm.sys.entity.dto.CommonDictDto;
import com.longjun.cto.framework.sm.sys.entity.model.CommonDictModel;
import com.longjun.cto.framework.sm.sys.entity.view.CommonDictView;
import com.longjun.cto.framework.sm.sys.mapper.CommonDictMapper;
import com.longjun.cto.framework.sm.sys.service.ICommonDictService;

/**
 * 通用字典表Service Impl
 * 
 * @author jerry
 * @date 2018-11-29 21:59:28
 */
@Service
public class CommonDictServiceImpl extends BaseServiceImpl<CommonDictMapper, CommonDictModel>
		implements ICommonDictService {

	@Autowired
	CommonDictMapper mapper;

	@Override
	public boolean setStatusById(long id, int status) throws BusinessException {
		try {
			CommonDictModel model = this.selectById(id);
			model.setId(id);
			model.setStatus(status);
			this.updateById(model);
		} catch (Exception e) {
			e.printStackTrace();
			throw new BusinessException(ErrorTableEnum.G0000500);
		}
		return true;
	}

	void saveModelBefore(CommonDictModel model) throws BusinessException {
		// TOOD 校验等操作
	}

	void saveModelAfter(CommonDictModel model) throws BusinessException {
		// TOOD 校验等操作
	}

	@Override
	public Long saveModel(CommonDictModel model) throws BusinessException {
		try {
			this.saveModelBefore(model);
			model.setUseId(super.sequenceId());
			this.insert(model);
			this.saveModelAfter(model);
			return model.getId();
		} catch (Exception e) {
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
	public PageUtils<CommonDictView> getByPage(CommonDictDto dto) throws BusinessException {
		try {
			startPage(dto);
			List<CommonDictView> ret = this.mapper.getByPage(dto);
			return new PageUtils<CommonDictView>(ret);
		} catch (Exception e) {
			e.printStackTrace();
			throw new BusinessException(ErrorTableEnum.G0000500);
		}
	}

	@Override
	public CommonDictView getById(long id) throws BusinessException {
		try {
			CommonDictModel model = this.selectById(id);
			return new CommonDictView(model);
		} catch (Exception e) {
			e.printStackTrace();
			throw new BusinessException(ErrorTableEnum.G0000500);
		}
	}

	@CacheEvictBatch
	@Override
	public boolean saveModel(long typeId, long useId, String showName, int useSort, int isUse, String description,
			java.util.Date time, java.util.Date lastupdate, int status) throws BusinessException {
		try {
			CommonDictModel model = new CommonDictModel();
			model.setTypeId(typeId);
			model.setUseId(useId);
			model.setShowName(showName);
			model.setUseSort(useSort);
			model.setIsUse(isUse);
			model.setDescription(description);
			model.setTime(time);
			model.setLastupdate(lastupdate);
			model.setStatus(status);
			this.insert(model);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			throw new BusinessException(ErrorTableEnum.G0000500);
		}
	}

	@CacheEvictBatch
	@Override
	public boolean modify(CommonDictModel commonDictModel) throws BusinessException {
		CommonDictModel db = super.selectById(commonDictModel.getId());
		db.setLastupdate(new Date());
		db.setShowName(commonDictModel.getShowName());
		super.updateById(db);
		return true;
	}

	@Cacheable(value = "buz-cache-standard-com.eims.cto.framework.sm.sys.service.impl.CommonDictServiceImpl",
			keyGenerator = "keyGenerator",unless = "#result == null")
	@Override
	public List<CommonDictView> selectListByTypeId(long tyepId) throws BusinessException {
		try {
			EntityWrapper<CommonDictModel> ew = new EntityWrapper<CommonDictModel>();
			ew.eq("type_id", tyepId);
			List<CommonDictView> list = this.selectListCondition(ew, CommonDictView.class);
			return list;
		} catch (Exception e) {
			e.printStackTrace();
			throw new BusinessException(ErrorTableEnum.G0000500);
		}
	}

	@Cacheable(value = "buz-cache-standard-com.eims.cto.framework.sm.sys.service.impl.CommonDictServiceImpl",
	keyGenerator = "keyGenerator",unless = "#result == null")
	@Override
	public List<CommonDictModel> selectListByParentUseId(long parentUseId) throws BusinessException {
		EntityWrapper<CommonDictModel> ew = new EntityWrapper<CommonDictModel>();
		ew.eq("parent_use_id", parentUseId).eq("status", 1).eq("is_del", 0);
		List<CommonDictModel> list = super.selectList(ew);
		return list;
	}

	@Cacheable(value = "buz-cache-standard-com.eims.cto.framework.sm.sys.service.impl.CommonDictServiceImpl",
			keyGenerator = "keyGenerator",unless = "#result == null")
	@Override
	public CommonDictModel findByTypeId2ShowName(long typeId, String showName) throws BusinessException {
		EntityWrapper<CommonDictModel> ew = new EntityWrapper<CommonDictModel>();
		ew.eq("type_id", typeId).eq("status", 1).eq("is_del", 0).eq("show_name", showName);
		CommonDictModel ret = super.selectOne(ew);
		return ret;

	}
}
