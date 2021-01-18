package com.longjun.cto.framework.project.pension.userManagement.service.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.beanutils.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import com.alibaba.fastjson.JSONObject;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.eims.cto.framework.common.base.exception.BusinessException;
import com.eims.cto.framework.common.base.page.PageUtils;
import com.eims.cto.framework.module.base.service.BaseServiceImpl;
import com.longjun.cto.framework.common.utils.security.AESUtil;
import com.longjun.cto.framework.project.pension.userManagement.entity.dto.EnterpriseRegistrationDto;
import com.longjun.cto.framework.project.pension.userManagement.entity.dto.ForgetPasswordDto;
import com.longjun.cto.framework.project.pension.userManagement.entity.dto.PersonalRegistrationDto;
import com.longjun.cto.framework.project.pension.userManagement.entity.dto.UsersDto;
import com.longjun.cto.framework.project.pension.userManagement.entity.dto.UsersExamineDto;
import com.longjun.cto.framework.project.pension.userManagement.entity.dto.UsersModifyDto;
import com.longjun.cto.framework.project.pension.userManagement.entity.dto.UsersRestPassWordDto;
import com.longjun.cto.framework.project.pension.userManagement.entity.model.UsersModel;
import com.longjun.cto.framework.project.pension.userManagement.entity.view.UsersView;
import com.longjun.cto.framework.project.pension.userManagement.mapper.UsersMapper;
import com.longjun.cto.framework.project.pension.userManagement.service.IUsersService;
import com.longjun.cto.framework.sm.sys.entity.model.CommonAreaModel;
import com.longjun.cto.framework.sm.sys.entity.model.CommonWorldMapModel;
import com.longjun.cto.framework.sm.sys.service.ICommonAreaService;
import com.longjun.cto.framework.sm.sys.service.ICommonWorldMapService;

/**
 * UsersServiceImpl
 *
 * @author carson
 * @date 2019-10-19 07:48:34
 */
@Service
public class UsersServiceImpl extends
        BaseServiceImpl<UsersMapper, UsersModel>
        implements IUsersService {

    @Autowired
    UsersMapper mapper;
    @Autowired
    ICommonWorldMapService iCommonWorldMapService;
    @Autowired
    ICommonAreaService iCommonAreaService;

    @Override
    public UsersView findViewById(long id) throws BusinessException {
        UsersView ret = this.mapper.findViewById(id);
        ret.setPassword(AESUtil.decrypt(ret.getPassword()));

        if(!StringUtils.isEmpty(ret.getCountry()))
        {
            EntityWrapper<CommonWorldMapModel> wrapper = new EntityWrapper<>();
            wrapper.eq("status", 1);
            wrapper.eq("code", ret.getCountry());
            CommonWorldMapModel commonWorldMapModel = this.iCommonWorldMapService.selectOne(wrapper);
            ret.setCountry(commonWorldMapModel.getName());
        }
        if(!StringUtils.isEmpty(ret.getDistrict()))
        {
            EntityWrapper<CommonAreaModel> wrapper = new EntityWrapper<>();
            wrapper.eq("status", 1);
            wrapper.eq("use_id", ret.getDistrict());
            CommonAreaModel commonAreaModel = this.iCommonAreaService.selectOne(wrapper);
            ret.setDistrict(commonAreaModel.getName());
        }

        return ret;
    }

    @Override
    public UsersModel findModelById(long id) throws BusinessException {
        UsersModel model = this.selectById(id);
        if (model == null) {
            log.warn("Users 通过ID查询结果为空");
            return null;
        }
        return model;
    }

    @Override
    public void saveModel(UsersModel model) throws BusinessException {
        log.info("Users 数据新增 -> [{}]", JSONObject.toJSONString(model));
        super.insert(model);
    }

    @Override
    public boolean start(long id) throws BusinessException {
        UsersModel model = super.selectById(id);
        if (model == null) {
            log.error("Users 开启操作,ID[{}]未查询到数据信息", id);
            return false;
        }
        if (model.getStatus() == USE) {
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
        UsersModel model = super.selectById(id);
        if (model == null) {
            log.error("Users 停止操作,ID[{}]未查询到数据信息", id);
            return false;
        }
        if (model.getStatus() == FAIL) {
            return true;
        }
        model.setStatus(FAIL);
        model.setLastupdate(new Date());
        boolean ret = super.updateById(model);
        return ret;
    }

    @Override
    public PageUtils<UsersView> getByPage(UsersDto dto) throws BusinessException {
        startPage(dto);
        List<UsersView> ret = this.mapper.getByPage(dto);
        PageUtils<UsersView> pages = new PageUtils<UsersView>(ret);
        return pages;
    }

    @Override
    public List<UsersView> listByLimitStatus(int status, int limit) throws BusinessException {
        Map<String, Object> params = new HashMap<String, Object>();
        params.put("c_status", status);
        params.put("c_limit", limit);
        List<UsersView> rets = this.mapper.listModelMap(params);
        if (rets == null) {
            return new ArrayList<UsersView>();
        }
        return rets;
    }

    @Override
    public int countAll() throws BusinessException {
        int count = this.mapper.countMap(new HashMap<>());
        return count;
    }

    @Override
    public List<UsersView> listAll() throws BusinessException {
        List<UsersView> rets = this.mapper.listModelMap(new HashMap<>());
        if (rets == null) {
            return new ArrayList<UsersView>();
        }
        return rets;
    }

    @Override
    public boolean modify(UsersModifyDto dto) throws BusinessException {
        if (dto == null) {
            log.error("Users 修改失败;传入对象为空");
            return false;
        }
        UsersModel model = super.selectById(dto.getId());
        if (model == null) {
            log.error("Users 修改失败;通过ID[{}]未查询到数据", dto.getId());
            return false;
        }
        UsersModel uModel = new UsersModel();
        try {
            BeanUtils.copyProperties(uModel, dto);
            boolean ret = super.updateById(uModel);
            return ret;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    /**
     * 审核
     *
     * @param dto
     * @return
     * @throws BusinessException
     */
    @Override
    public boolean examine(UsersExamineDto dto) throws BusinessException {

        if (dto == null) {
            log.error("Users 修改失败;传入对象为空");
            return false;
        }
        UsersModel model = super.selectById(dto.getId());
        if (model == null) {
            log.error("Users 修改失败;通过ID[{}]未查询到数据", dto.getId());
            return false;
        }
        UsersModel uModel = new UsersModel();
        uModel.setId(dto.getId());
        uModel.setAdminId(dto.getAdminId());
        uModel.setAuditTime(dto.getAuditTime());
        uModel.setAuditRemarks(dto.getAuditRemarks());
        uModel.setAuditStatus(dto.getAuditStatus());
        uModel.setUserGradeId(dto.getUserGradeId());

        boolean ret = super.updateById(uModel);
        return ret;

    }

    /**
     * 重置密码
     *
     * @param dto
     * @return
     * @throws BusinessException
     */
    @Override
    public boolean restPassWord(UsersRestPassWordDto dto) throws BusinessException {

        if (dto == null) {
            log.error("Users 修改失败;传入对象为空");
            return false;
        }

        if (!dto.getPassword().equals(dto.getConfirmPassword())) {
            log.error("Users 修改失败;密码和确认密码不一致");
            return false;
        }
        UsersModel model = super.selectById(dto.getId());
        if (model == null) {
            log.error("Users 修改失败;通过ID[{}]未查询到数据", dto.getId());
            return false;
        }
        UsersModel uModel = new UsersModel();
        uModel.setId(dto.getId());
        uModel.setPassword(AESUtil.encrypt(dto.getPassword()));

        boolean ret = super.updateById(uModel);
        return ret;
    }

    /**
     * 个人注册
     *
     * @param dto
     * @return
     * @throws BusinessException
     */
    @Override
    public boolean register(PersonalRegistrationDto dto) throws BusinessException {

        if (dto == null) {
            log.error("PersonalRegistrationDto 个人注册;传入对象为空");
            return false;
        }

        if (!dto.getPassword().equals(dto.getConfirmPassword())) {
            log.error("PersonalRegistrationDto 个人注册;密码和确认密码不一致");
            return false;
        }

        EntityWrapper ew = new EntityWrapper<>();
        ew.eq("is_del", 0);
        ew.eq("login_name", dto.getLoginName());
        UsersModel ret = super.selectOne(ew);

        if (ret != null) {
            log.error("个人注册,帐号已存在 -> {}", dto);
            throw new BusinessException("个人注册,帐号已存在");
        }



        UsersModel uModel = new UsersModel();
        try {
            BeanUtils.copyProperties(uModel, dto);

            uModel.setUserType(1);
            uModel.setPassword(AESUtil.encrypt(uModel.getPassword()));

            this.saveModel(uModel);

            return true;

        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }

    }

    /**
     * 企业注册
     *
     * @param dto
     * @return
     * @throws BusinessException
     */
    @Override
    public boolean register(EnterpriseRegistrationDto dto) throws BusinessException {

        if (dto == null) {
            log.error("PersonalRegistrationDto 个人注册;传入对象为空");
            return false;
        }

        if (!dto.getPassword().equals(dto.getConfirmPassword())) {
            log.error("PersonalRegistrationDto 个人注册;密码和确认密码不一致");
            return false;
        }

        EntityWrapper ew = new EntityWrapper<>();
        ew.eq("is_del", 0);
        ew.eq("login_name", dto.getLoginName());
        UsersModel ret = super.selectOne(ew);

        if (ret != null) {
            log.error("企业注册,帐号已存在 -> {}", dto);
            throw new BusinessException("企业注册,帐号已存在");
        }


        UsersModel uModel = new UsersModel();
        try {
            BeanUtils.copyProperties(uModel, dto);

            uModel.setUserType(0);
            uModel.setPassword(AESUtil.encrypt(uModel.getPassword()));
            uModel.setDistrict(dto.getArea());

            this.saveModel(uModel);

            return true;

        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    /**
     * 忘记密码
     *
     * @param dto
     * @return
     * @throws BusinessException
     */
    @Override
    public boolean forgetPassword(ForgetPasswordDto dto) throws BusinessException {
        if (dto == null) {
            log.error("PersonalRegistrationDto 个人注册;传入对象为空");
            return false;
        }

        if (!dto.getPassword().equals(dto.getConfirmPassword())) {
            log.error("PersonalRegistrationDto 个人注册;密码和确认密码不一致");
            return false;
        }

        EntityWrapper ew = new EntityWrapper<>();
        ew.eq("is_del", 0);
        ew.eq("mobile", dto.getMobile());
        UsersModel ret = super.selectOne(ew);

        if (ret == null) {
            log.error("忘记密码,帐号不存在 -> {}", dto);
            throw new BusinessException("忘记密码,手机不存在");
        }


        UsersModel uModel = new UsersModel();
        uModel.setId(ret.getId());
        uModel.setPassword(AESUtil.encrypt(dto.getPassword()));
        return super.updateById(uModel);

    }

}
