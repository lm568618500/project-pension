package com.longjun.cto.framework.sm.sys.service;

import java.util.List;
import java.util.Map;

import com.eims.cto.framework.common.base.exception.BusinessException;
import com.eims.cto.framework.common.base.page.PageUtils;
import com.eims.cto.framework.module.base.service.BaseService;
import com.longjun.cto.framework.sm.sys.entity.dto.AdminDto;
import com.longjun.cto.framework.sm.sys.entity.dto.AdminLoginDto;
import com.longjun.cto.framework.sm.sys.entity.dto.AdminModifyDto;
import com.longjun.cto.framework.sm.sys.entity.dto.AdminModifyPasswordDto;
import com.longjun.cto.framework.sm.sys.entity.dto.AdminMotifyDto;
import com.longjun.cto.framework.sm.sys.entity.model.AdminModel;
import com.longjun.cto.framework.sm.sys.entity.model.AdminTokenModel;
import com.longjun.cto.framework.sm.sys.entity.view.AdminView;

/**
 * 管理员Service
 * 
 * @author lp
 * @date 2018-12-20 20:10:49
 */
public interface IAdminService extends BaseService<AdminModel> {

	/**
	 * 通过ID查询
	 * @param id
	 * @return
	 * @throws BusinessException
	 */
	public AdminView findViewById(long id)throws BusinessException;
	/**
	 * 通过ID查询
	 * @param id
	 * @return
	 * @throws BusinessException
	 */
	public AdminModel findModelById(long id)throws BusinessException;
	/**
	 * 通过ID修改信息状态
	 * 
	 * @param id
	 * @param status
	 * @return
	 * @throws BusinessException
	 */
	boolean setStatusById(long id, int status) throws BusinessException;

	/**
	 * 保存数据
	 * 
	 * @param model
	 * @return
	 * @throws BusinessException
	 */
	Long saveModel(AdminModel model) throws BusinessException;

	/**
	 * 启动/开始
	 * 
	 * @param id
	 * @return
	 * @throws BusinessException
	 */
	boolean start(long id) throws BusinessException;

	/**
	 * 停止/关闭
	 * 
	 * @param id
	 * @return
	 * @throws BusinessException
	 */
	boolean stop(long id) throws BusinessException;

	/**
	 * 分页查询
	 * 
	 * @param dto
	 * @return
	 * @throws BusinessException
	 */
	PageUtils<AdminView> getByPage(AdminDto dto) throws BusinessException;
	/**
	 * 分页查询领域为纬度
	 * 
	 * @param dto
	 * @return
	 * @throws BusinessException
	 */
	PageUtils<AdminView> getOtherByPage(AdminDto dto) throws BusinessException;
	/**
	 * 分页查询专业人员
	 * 
	 * @param dto
	 * @return
	 * @throws BusinessException
	 */
	PageUtils<AdminView> getExpertByPage(AdminDto dto) throws BusinessException;
	/**
	 * 分页查询相关人员
	 * 
	 * @param dto
	 * @return
	 * @throws BusinessException
	 */
	PageUtils<AdminView> getPersonnelByPage(AdminDto dto) throws BusinessException;
	/**
	 * 通过ID查询View
	 * 
	 * @param id
	 * @return
	 * @throws BusinessException
	 */
	AdminView getById(long id) throws BusinessException;

	/**
	 * 获取权限角色列表
	 * 
	 * @return
	 * @throws BusinessException
	 */
	List<Map<String, Object>> getRolList() throws BusinessException;

	/**
	 * 保存数据
	 */
	boolean saveModel(String account, String realName, String jobNumber, long mobile, long roleid, int status,
			String password, int type) throws BusinessException;

	/**
	 * 保存数据
	 */
	boolean modify(long id, String account, String realName, String jobNumber, long mobile, long roleid, int status,
			String password, int type) throws BusinessException;
	
	/**
	 * 保存数据
	 */
	boolean modify(AdminMotifyDto adminMotifyDto) throws BusinessException;
	/**
	 * 修改数据
	 * @param dto
	 * @return
	 * @throws BusinessException
	 */
	public boolean modify(AdminModifyDto dto)throws BusinessException;
	/**
	 * （逻辑）删除/批量删除
	 * 
	 * @param id
	 * @return
	 * @throws BusinessException
	 */
	Integer deletes(long[] id) throws BusinessException;

	AdminModel loginAction(AdminLoginDto dto) throws BusinessException;

	void logOut(String key, long userId) throws BusinessException;
	
	/**
	 * 解锁
	 * @param adminId
	 * @return
	 * @throws BusinessException
	 */
	boolean unlock(long adminId)throws BusinessException;
	

	/**
	 * 锁定
	 * @param adminId
	 * @return
	 * @throws BusinessException
	 */
	boolean lock(long adminId)throws BusinessException;
	
	/**
	 * 删除
	 * @param adminId
	 * @return
	 * @throws BusinessException
	 */
	boolean del(long adminId)throws BusinessException;
	
	/**
	 * limit , status查询
	 * @param status
	 * @param limit
	 * @return
	 * @throws BusinessException
	 */
	List<AdminModel> listByLimitStatus(int status , int limit)throws BusinessException;
	
	/**
	 * 查询总数
	 * @return
	 * @throws BusinessException
	 */
	int countAll()throws BusinessException;
	
	/**
	 * 全部记录
	 * @return
	 * @throws BusinessException
	 */
	List<AdminModel> listAll()throws BusinessException;

	/**
	 * 修改密码
	 * @param dto
	 * @return
	 * @throws BusinessException
	 */
	boolean modifyPassword(AdminModifyPasswordDto dto) throws BusinessException;
	
	/**
	 * 添加管理员
	 * @param account
	 * @param realName
	 * @param password
	 * @param rePassword
	 * @param email
	 * @param mobile
	 * @param roleId
	 * @return
	 * @throws BusinessException
	 */
	public boolean addAdminAction(String account, String realName, String password, String rePassword,
			String email, String mobile, String roleId,String remarks)throws BusinessException;
	
}
