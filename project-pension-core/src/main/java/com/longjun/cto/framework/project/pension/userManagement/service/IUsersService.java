package com.longjun.cto.framework.project.pension.userManagement.service;

import com.eims.cto.framework.module.base.model.BaseDTO;
import com.eims.cto.framework.common.base.exception.BusinessException;
import com.eims.cto.framework.common.base.page.PageUtils;
import com.eims.cto.framework.module.base.service.BaseService;
import com.longjun.cto.framework.project.pension.userManagement.entity.dto.EnterpriseRegistrationDto;
import com.longjun.cto.framework.project.pension.userManagement.entity.dto.ForgetPasswordDto;
import com.longjun.cto.framework.project.pension.userManagement.entity.dto.PersonalRegistrationDto;
import com.longjun.cto.framework.project.pension.userManagement.entity.dto.UsersDto;
import com.longjun.cto.framework.project.pension.userManagement.entity.dto.UsersExamineDto;
import com.longjun.cto.framework.project.pension.userManagement.entity.dto.UsersModifyDto;
import com.longjun.cto.framework.project.pension.userManagement.entity.dto.UsersRestPassWordDto;
import com.longjun.cto.framework.project.pension.userManagement.entity.model.UsersModel;
import com.longjun.cto.framework.project.pension.userManagement.entity.view.UsersView;

import java.util.List;

/**
 * UsersModel
 *
 * @author carson
 * @date 2019-10-19 07:48:34
 */
public interface IUsersService extends BaseService<UsersModel> {

    /**
     * 通过ID查询
     *
     * @param id
     * @return
     * @throws BusinessException
     */
    public UsersView findViewById(long id) throws BusinessException;

    /**
     * 通过ID查询
     *
     * @param id
     * @return
     * @throws BusinessException
     */
    public UsersModel findModelById(long id) throws BusinessException;

    /**
     * 保存
     *
     * @param model
     * @return
     * @throws BusinessException
     */
    public void saveModel(UsersModel model) throws BusinessException;

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
    public PageUtils<UsersView> getByPage(UsersDto dto) throws BusinessException;

    /**
     * limit , status查询
     *
     * @param status
     * @param limit
     * @return
     * @throws BusinessException
     */
    public List<UsersView> listByLimitStatus(int status, int limit) throws BusinessException;

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
    public List<UsersView> listAll() throws BusinessException;

    /**
     * 修改数据
     *
     * @param dto
     * @return
     * @throws BusinessException
     */
    public boolean modify(UsersModifyDto dto) throws BusinessException;

    /**
     * 审核
     *
     * @param dto
     * @return
     * @throws BusinessException
     */
    boolean examine(UsersExamineDto dto) throws BusinessException;

    /**
     * 重置密码
     *
     * @param dto
     * @return
     * @throws BusinessException
     */
    boolean restPassWord(UsersRestPassWordDto dto) throws BusinessException;


    /**
     * 个人注册
     *
     * @param dto
     * @return
     * @throws BusinessException
     */
    boolean register(PersonalRegistrationDto dto) throws BusinessException;

    /**
     * 企业注册
     *
     * @param dto
     * @return
     * @throws BusinessException
     */
    boolean register(EnterpriseRegistrationDto dto) throws BusinessException;


    /**
     * 忘记密码
     * @param dto
     * @return
     * @throws BusinessException
     */
    boolean forgetPassword(ForgetPasswordDto dto) throws BusinessException;


}
