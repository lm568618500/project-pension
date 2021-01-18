package com.longjun.cto.framework.sm.users.service;

import java.util.List;

import com.eims.cto.framework.common.base.exception.BusinessException;
import com.eims.cto.framework.common.base.page.PageUtils;
import com.eims.cto.framework.module.base.service.BaseService;
import com.longjun.cto.framework.sm.users.entity.dto.FindPasswordInputDto;
import com.longjun.cto.framework.sm.users.entity.dto.RegisterInputDto;
import com.longjun.cto.framework.sm.users.entity.dto.UserDto;
import com.longjun.cto.framework.sm.users.entity.dto.UserModifyDto;
import com.longjun.cto.framework.sm.users.entity.dto.UserModifyInputDto;
import com.longjun.cto.framework.sm.users.entity.es.ScoreIncomeEnums;
import com.longjun.cto.framework.sm.users.entity.model.UserModel;
import com.longjun.cto.framework.sm.users.entity.view.UserView;

/**
 * UserModel
 * 
 * @author yangxuan
 * @date 2019-06-19 02:29:35
 */
public interface IUserService extends BaseService<UserModel> {

	/**
	 * 通过ID查询
	 * 
	 * @param id
	 * @return
	 * @throws BusinessException
	 */
	public UserView findViewById(long id) throws BusinessException;

	/**
	 * 通过ID查询
	 * 
	 * @param id
	 * @return
	 * @throws BusinessException
	 */
	public UserModel findModelById(long id) throws BusinessException;

	/**
	 * 保存
	 * 
	 * @param model
	 * @return
	 * @throws BusinessException
	 */
	public void saveModel(UserModel model) throws BusinessException;

	/**
	 * 启动/开始
	 * 
	 * @param id
	 * @return
	 * @throws BusinessException
	 */
	public boolean start(long id) throws BusinessException;

	/**
	 * 停止/关闭
	 * 
	 * @param id
	 * @return
	 * @throws BusinessException
	 */
	public boolean stop(long id) throws BusinessException;

	/**
	 * 删除
	 * 
	 * @param id
	 * @return
	 * @throws BusinessException
	 */
	public boolean del(long id) throws BusinessException;

	/**
	 * 分页查询
	 * 
	 * @param dto
	 * @return
	 * @throws BusinessException
	 */
	public PageUtils<UserView> getByPage(UserDto dto) throws BusinessException;

	/**
	 * limit , status查询
	 * 
	 * @param status
	 * @param limit
	 * @return
	 * @throws BusinessException
	 */
	public List<UserView> listByLimitStatus(int status, int limit) throws BusinessException;

	/**
	 * 查询总数
	 * 
	 * @return
	 * @throws BusinessException
	 */
	public int countAll() throws BusinessException;

	/**
	 * 全部记录
	 * 
	 * @return
	 * @throws BusinessException
	 */
	public List<UserView> listAll() throws BusinessException;

	/**
	 * 修改数据
	 * 
	 * @param dto
	 * @return
	 * @throws BusinessException
	 */
	public boolean modify(UserModifyDto dto) throws BusinessException;

	/**
	 * 注册操作
	 * 
	 * @param registerInputDto
	 * @return
	 * @throws BusinessException
	 */
	public boolean regAction(RegisterInputDto registerInputDto) throws BusinessException;

	/**
	 * 找回密码操作
	 * 
	 * @param findPasswordInputDtos
	 * @return
	 * @throws BusinessException
	 */
	public boolean findPasspordAction(FindPasswordInputDto findPasswordInputDtos) throws BusinessException;

	/**
	 * 通过手机号用户身份查询
	 * 
	 * @param mobile
	 * @param userType
	 * @return
	 * @throws BusinessException
	 */
	public UserModel findByMobileUserType(String mobile, int userType) throws BusinessException;

	/**
	 * 密码加密
	 * 
	 * @param password
	 * @return
	 * @throws BusinessException
	 */
	public String encryPassword(String password) throws BusinessException;

	/**
	 * 修改头像信息
	 * 
	 * @param userId
	 * @param photo
	 * @return
	 * @throws BusinessException
	 */
	public boolean modifyPhoto(long userId, String photo) throws BusinessException;

	/**
	 * 修改密码
	 * 
	 * @param userId
	 * @param password
	 * @return
	 * @throws BusinessException
	 */
	public boolean modifyPassword(long userId, String password) throws BusinessException;

	/**
	 * 个人信息修改
	 * 
	 * @param UserModifyInputDto
	 * @return
	 * @throws BusinessException
	 */
	public boolean modifyUserInfo(UserModifyInputDto userModifyInputDto) throws BusinessException;

	/**
	 * 通过用户名查询
	 * 
	 * @param userName
	 * @return
	 * @throws BusinessException
	 */
	public UserView findViewByUserName(String userName) throws BusinessException;

	/**
	 * 用户积分变动
	 * 
	 * @param userId
	 * @param score
	 * @param scoreSenceNo t_user_score_sence中获取sence_no
	 * @return
	 * @throws BusinessException
	 */
	public boolean changeScore(Long userId, Long score, Long scoreSenceNo) throws BusinessException;

	/**
	 * 修改手机号码
	 * @param userId
	 * @param mobile
	 * @return
	 * @throws BusinessException
	 */
	public boolean modifyPhone(long userId, String mobile) throws BusinessException;

	/**
	 * 通过手机号码查询对象
	 * 
	 * @param mobile
	 * @return
	 * @throws BusinessException
	 */
	public UserModel findModelByMobile(long mobile) throws BusinessException;

}
