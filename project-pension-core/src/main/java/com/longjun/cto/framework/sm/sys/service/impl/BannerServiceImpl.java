package com.longjun.cto.framework.sm.sys.service.impl;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.eims.cto.framework.common.base.enums.ErrorTableEnum;
import com.eims.cto.framework.common.base.exception.BusinessException;
import com.eims.cto.framework.common.base.page.PageUtils;
import com.eims.cto.framework.module.base.service.BaseServiceImpl;
import com.longjun.cto.framework.sm.sys.entity.dto.BannerDto;
import com.longjun.cto.framework.sm.sys.entity.model.BannerModel;
import com.longjun.cto.framework.sm.sys.entity.view.BannerView;
import com.longjun.cto.framework.sm.sys.entity.view.NewBannerView;
import com.longjun.cto.framework.sm.sys.mapper.BannerMapper;
import com.longjun.cto.framework.sm.sys.service.IBannerService;

/**
 * 广告条信息表Service Impl
 * 
 * @author heqiang
 * @date 2018-12-08 08:44:03
 */
@Service
public class BannerServiceImpl extends BaseServiceImpl<BannerMapper, BannerModel> implements IBannerService {

	@Autowired
	BannerMapper mapper;

	@Override
	public boolean setStatusById(long id, int status) throws BusinessException {
		try {
			BannerModel model = this.selectById(id);
			model.setId(id);
			model.setStatus(status);
			this.updateById(model);
		} catch (Exception e) {
			e.printStackTrace();
			throw new BusinessException(ErrorTableEnum.G0000500);
		}
		return false;
	}

	void saveModelBefore(BannerModel model) throws BusinessException {
		// TOOD 校验等操作
	}

	void saveModelAfter(BannerModel model) throws BusinessException {
		// TOOD 校验等操作
	}

	@Override
	public Long saveModel(BannerModel model) throws BusinessException {
		try {
			this.saveModelBefore(model);
			this.insert(model);
			this.saveModelAfter(model);
			return model.getId();
		} catch (Exception e) {
			e.printStackTrace();
			throw new BusinessException(ErrorTableEnum.G0000500);
		}
	}


	@Override
	public PageUtils<BannerView> getByPage(BannerDto dto) throws BusinessException {
		try {
			startPage(dto);
			List<BannerView> ret = this.mapper.getByPage(dto);
			return new PageUtils<BannerView>(ret);
		} catch (Exception e) {
			e.printStackTrace();
			throw new BusinessException(ErrorTableEnum.G0000500);
		}
	}

	@Override
	public BannerView getById(long id) throws BusinessException {
		try {
			BannerModel model = this.selectById(id);
			return new BannerView(model);
		} catch (Exception e) {
			e.printStackTrace();
			throw new BusinessException(ErrorTableEnum.G0000500);
		}
	}

	@Override
	public boolean saveModel(int type,String name, String location, long plateId, String fileSize,
			String fileFormat, String imgUrl, int target, int sort, long jumpId, int jumpType, String jumpUrl,
			java.util.Date startTime, java.util.Date endTime, String content,long parent_id,int status,int client_type,String description) throws BusinessException {
		if(name==""||name.length()==0){
			throw new BusinessException("图片名称不能为空");
		}
		if(location==""||location.length()==0){
			throw new BusinessException("图片位置不能为空");
		}
		if(imgUrl==""||imgUrl.length()==0){
			throw new BusinessException("上传图片不能为空");
		}
		if(startTime == null){
			throw new BusinessException("开始时间不能为空");
		}
		if(endTime == null){
			throw new BusinessException("结束时间不能为空");
		}
		if(jumpType < 0){
			throw new BusinessException("跳转类型不能为空");
		}
		if(plateId < 0){
			throw new BusinessException("板块类别不能为空");
		}
		BannerModel model = new BannerModel();
		model.setType(type);
		model.setTime(new Date());
		model.setLocation(location);
		model.setName(name);
		model.setPlateId(plateId);
		model.setFileSize(fileSize);
		model.setFileFormat(fileFormat);
		model.setImgUrl(imgUrl);
		model.setTarget(target);
		model.setSort(sort);
		model.setStatus(status);
		model.setJumpId(jumpId);
		model.setJumpType(jumpType);
		model.setJumpUrl(jumpUrl);
		model.setStartTime(startTime);
		model.setEndTime(endTime);
		model.setContent(content);
		model.setParentId(parent_id);
		model.setIsDel(0);
		model.setClientType(client_type);
		model.setDescription(description);
		this.insert(model);
		return true;
	}

	@Override
	public boolean modify(int id, int type, String name,String location, long plateId, String fileSize, String fileFormat,
			String imgUrl, int target, int sort, long jumpId, int jumpType,String jumpUrl, Date startTime, Date endTime,
			String content,long parent_id,int status,int client_type,String description) throws BusinessException {
		if(id<0){
			throw new BusinessException("数据错误!");
		}
		if(isBlank(name)){
			throw new BusinessException("图片名称不能为空");
		}
		if(isBlank(location)){
			throw new BusinessException("图片位置不能为空");
		}
		if(isBlank(imgUrl)){
			throw new BusinessException("上传图片不能为空");
		}
		if(startTime == null){
			throw new BusinessException("开始时间不能为空");
		}
		if(endTime == null){
			throw new BusinessException("结束时间不能为空");
		}
		if(jumpType < 0){
			throw new BusinessException("跳转类型不能为空");
		}
		if(plateId < 0){
			throw new BusinessException("板块类别不能为空");
		}
		BannerModel model = this.selectById(id);
		model.setType(type);
		model.setLocation(location);
		model.setName(name);
		model.setPlateId(plateId);
		model.setFileSize(fileSize);
		model.setFileFormat(fileFormat);
		model.setImgUrl(imgUrl);
		model.setTarget(target);
		model.setSort(sort);
		model.setJumpId(jumpId);
		model.setJumpType(jumpType);
		model.setJumpUrl(jumpUrl);
		model.setStartTime(startTime);
		model.setEndTime(endTime);
		model.setContent(content);
		model.setLastupdate(new Date());
		model.setIsDel(0);
		model.setParentId(parent_id);
		model.setStatus(status);
		model.setClientType(client_type);
		model.setDescription(description);
		this.updateById(model);
		return true;
	}

	
	@Override
	public Boolean delete(long id) throws BusinessException {
		try{
			BannerModel model = this.selectById(id);
			model.setId(id);
			model.setIsDel(1);
			this.mapper.delete(model);
		}catch(Exception e){
			e.printStackTrace();
			throw new BusinessException(ErrorTableEnum.G0000500);
		}
		return false;
	}
	
	@Override
	public BannerView getBannerById(long id) throws BusinessException {
		try {
			BannerModel model = this.selectById(id);
			model.setId(id);
			model.setJumpType(model.getJumpType());
			return this.mapper.selectBannerById(model);
		} catch (Exception e) {
			e.printStackTrace();
			throw new BusinessException(ErrorTableEnum.G0000500);
		}
	}

	@Override
	public List<BannerView> selectByParentId(long parent_id) throws BusinessException {
		try {
			return this.mapper.selectByParentId(parent_id);
		} catch (Exception e) {
			e.printStackTrace();
			throw new BusinessException(ErrorTableEnum.G0000500);
		}
	}

	@Override
	public List<BannerView> selectByType(int type) throws BusinessException {
		try {
			return this.mapper.selectByType(type);
		} catch (Exception e) {
			e.printStackTrace();
			throw new BusinessException(ErrorTableEnum.G0000500);
		}
	}

	@Override
	public List<NewBannerView> selectListByPlateId(Long plateId) throws BusinessException {
		try {
			return this.mapper.selectListByPlateId(plateId);
		} catch (Exception e) {
			e.printStackTrace();
			throw new BusinessException(ErrorTableEnum.G0000500);
		}
	}
	
}


