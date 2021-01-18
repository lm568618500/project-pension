package com.longjun.cto.framework.project.pension.userManagement.entity.dto;

import com.eims.cto.framework.module.base.model.BaseDTO;

/**
 * UsersGradeModel
 *
 * @author carson
 * @date 2019-10-19 11:55:54
 */
public class UsersGradeDto extends BaseDTO {

    private static final long serialVersionUID = 1571500559994L;

    /**
     * 等级名称
     */
    private String c_grade_name;

    public String getC_grade_name() {
        return c_grade_name;
    }

    public void setC_grade_name(String c_grade_name) {
        this.c_grade_name = c_grade_name;
    }


}
