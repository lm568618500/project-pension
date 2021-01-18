package com.longjun.cto.framework.project.pension.constant;

/**
 * 阶段状态
 *
 * @author carson deng
 * @date 2019/10/7 21:12
 */
public enum FactoryStatusEnum {

    /**
     * 现在只添加了工厂的状态 如果需其他阶段状态 自行添加
     */

    /**
     * 待接收任务
     */
    RECEIVED_TASKS(1, "待接收任务"),
    /**
     * 工厂检查计划
     */
    CHECK_PLAN(4, "工厂检查计划"),
    /**
     * 处理中任务
     */
    PROCESSING_TASKS(5, "处理中任务"),
    /**
     * 已完成任务
     */
    COMPLETE_TASKS(6, "已完成任务"),
    /**
     * 已拒绝任务
     */
    REJECTED_TASKS(7, "已拒绝任务"),
    /**
     * 中止任务
     */
    DISCONTINUE_TASKS(8, "中止任务");


    private Integer code;


    private String desc;


    FactoryStatusEnum(Integer code, String desc) {

        this.code = code;
        this.desc = desc;
    }

    /**
     * 根据code获取枚举类型
     *
     * @param code
     * @return
     */
    public static FactoryStatusEnum getValueByCode(Integer code) {
        for (FactoryStatusEnum item : FactoryStatusEnum.values()) {
            if (code.equals(item.getCode())) {
                return item;
            }
        }
        return null;
    }


    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

}
