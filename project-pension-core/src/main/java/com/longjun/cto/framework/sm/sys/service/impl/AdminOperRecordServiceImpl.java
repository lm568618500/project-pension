package com.longjun.cto.framework.sm.sys.service.impl;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.eims.cto.framework.common.base.enums.ErrorTableEnum;
import com.eims.cto.framework.common.base.exception.BusinessException;
import com.eims.cto.framework.common.base.page.PageUtils;
import com.eims.cto.framework.module.base.service.BaseServiceImpl;
import com.longjun.cto.framework.sm.sys.entity.dto.AdminOperRecordDto;
import com.longjun.cto.framework.sm.sys.entity.model.AdminOperRecordModel;
import com.longjun.cto.framework.sm.sys.entity.view.AdminOperRecordView;
import com.longjun.cto.framework.sm.sys.mapper.AdminOperRecordMapper;
import com.longjun.cto.framework.sm.sys.service.IAdminOperRecordService;

/**
 * 操作日志Service Impl
 * @author lp
 * @date 2018-12-13 15:54:41
 */
 @Service
public class AdminOperRecordServiceImpl extends BaseServiceImpl<AdminOperRecordMapper,AdminOperRecordModel> 
	implements IAdminOperRecordService {

	@Autowired
	AdminOperRecordMapper mapper;
	
	@Override
	public boolean setStatusById(long id, int status) throws BusinessException {
		try{
			AdminOperRecordModel model = this.selectById(id);
			model.setId(id);
			model.setStatus(status);
			this.updateById(model);
		}catch(Exception e){
			e.printStackTrace();
			throw new BusinessException(ErrorTableEnum.G0000500);
		}
		return false;
	}
	
	void saveModelBefore(AdminOperRecordModel model) throws BusinessException {
		//TOOD 校验等操作
	}
	
	void saveModelAfter(AdminOperRecordModel model) throws BusinessException {
		//TOOD 校验等操作
	}

	@Override
	public Long saveModel(AdminOperRecordModel model) throws BusinessException {
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
	public PageUtils<AdminOperRecordView> getByPage(AdminOperRecordDto dto) throws BusinessException {
		try{
			startPage(dto);
			List<AdminOperRecordView> ret = this.mapper.getByPage(dto);
			return new PageUtils<AdminOperRecordView>(ret);
		}catch(Exception e){
			e.printStackTrace();
			throw new BusinessException(ErrorTableEnum.G0000500);
		}
	}

	@Override
	public AdminOperRecordView getById(long id) throws BusinessException {
		try{
			AdminOperRecordModel model = this.selectById(id);
			return new AdminOperRecordView(model);
		}catch(Exception e){
			e.printStackTrace();
			throw new BusinessException(ErrorTableEnum.G0000500);
		}
	}
	/**
	 * @param adminId 操作人id
	 * @param mainModelName 主模块  例如：内容
	 * @param subModelName	子模块   例如：文章列表
	 * @param operationDesc	操作内容	例如：添加标题为：测试  的文章
	 * @param operType	操作类型 （1、管理员操作日志；2、用户操作日志）
	 */
	@Override
	public boolean saveModel(
		long adminId,  
		String mainModelName,  
		String subModelName,
		String operationDesc,  
		int operType
		) throws BusinessException {
		
		//字段校验
		
//		try{
			AdminOperRecordModel model = new AdminOperRecordModel();
			model.setTime(new Date());
			model.setAdminId(adminId);//操作人
			model.setOperDate(new Date());
			model.setToRelationStr(mainModelName+" -> "+subModelName);//模块名称
			model.setOperRecord(operationDesc);//操作记录
			model.setOperType(operType);//'操作日志类型：1、管理员；2、用户',
			model.setIp(webKit.getIp());
			model.setStatus(1);
			this.insert(model);
			return true;
//		}catch(Exception e){
//			e.printStackTrace();
//			throw new BusinessException(ErrorTableEnum.G0000500);
//		}
	}
	
	@Override
	public boolean modify(
		long id,  
		java.util.Date time,  
		long adminId,  
		java.util.Date operDate,  
		String toRelationStr,  
		long toRelationId,  
		int toRelationType,  
		String operRecord,  
		int operType,  
		String ip,  
		int status,  
		java.util.Date lastupdate 
		) throws BusinessException {
		
		//字段校验
		
//		try{
			AdminOperRecordModel model = this.selectById(id);
			model.setTime(time);
			model.setAdminId(adminId);
			model.setOperDate(operDate);
			model.setToRelationStr(toRelationStr);
			model.setToRelationId(toRelationId);
			model.setToRelationType(toRelationType);
			model.setOperRecord(operRecord);
			model.setOperType(operType);
			model.setIp(ip);
			model.setStatus(status);
			model.setLastupdate(lastupdate);
			this.updateById(model);
			return true;
//		}catch(Exception e){
//			e.printStackTrace();
//			throw new BusinessException(ErrorTableEnum.G0000500);
//		}
	}
	
	/* (non-Javadoc)
	 * @see com.eims.cto.framework.ext.shundian.article.service.IArticleService#deletes(long[])
	 */
	@Override
	public Integer deletes(long[] id) throws BusinessException {
		
		try {
			return this.mapper.updates(id);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return UNUSE;
	}
}
