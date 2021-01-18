package com.longjun.cto.framework.project.pension.userManagement.entity.dto;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.io.Serializable;
import java.util.Date;


/**
 * @author carson deng
 * @date 2019/10/20 17:53
 */
public class UsersExamineDto implements Serializable {

    private static final long serialVersionUID = 5383859542636850766L;


    /**
     * 主键ID
     */
    private Long id;
    /**
     * 用户等级ID
     */
    private Long userGradeId;

    /**
     * 审核状态（0 待审核 1 审核通过 2 审核不通过）
     */
    private Integer auditStatus;

    /**
     * 审核备注
     */
    private String auditRemarks;

    /**
     * 审核时间
     */
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date auditTime = new Date();

    /**
     * 审核人
     */
    private Long adminId;


    public Long getAdminId() {
        return adminId;
    }

    public void setAdminId(Long adminId) {
        this.adminId = adminId;
    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getUserGradeId() {
        return userGradeId;
    }

    public void setUserGradeId(Long userGradeId) {
        this.userGradeId = userGradeId;
    }

    public Integer getAuditStatus() {
        return auditStatus;
    }

    public void setAuditStatus(Integer auditStatus) {
        this.auditStatus = auditStatus;
    }

    public String getAuditRemarks() {
        return auditRemarks;
    }

    public void setAuditRemarks(String auditRemarks) {
        this.auditRemarks = auditRemarks;
    }

    public Date getAuditTime() {
        return auditTime;
    }

    public void setAuditTime(Date auditTime) {
        this.auditTime = auditTime;
    }
}
