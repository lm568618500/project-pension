package com.longjun.cto.framework.sm.message.service;

import com.eims.cto.framework.module.base.model.BaseDTO;
import com.eims.cto.framework.common.base.exception.BusinessException;
import com.eims.cto.framework.common.base.page.PageUtils;
import com.eims.cto.framework.module.base.service.BaseService;
import com.longjun.cto.framework.sm.message.entity.dto.MessageStationDto;
import com.longjun.cto.framework.sm.message.entity.dto.MessageStationModifyDto;
import com.longjun.cto.framework.sm.message.entity.model.MessageStationModel;
import com.longjun.cto.framework.sm.message.entity.view.MessageStationView;

import java.util.List;

/**
 * MessageStationModel
 *
 * @author yangxuan
 * @date 2019-07-04 07:33:46
 */
public interface IMessageStationService extends BaseService<MessageStationModel> {


    /**
     * 通过ID查询
     *
     * @param id
     * @return
     * @throws BusinessException
     */
    public MessageStationView findViewById(long id) throws BusinessException;

    /**
     * 通过ID查询
     *
     * @param id
     * @return
     * @throws BusinessException
     */
    public MessageStationModel findModelById(long id) throws BusinessException;

    /**
     * 保存
     *
     * @param model
     * @return
     * @throws BusinessException
     */
    public void saveModel(String userNos, String creator, String title, String content) throws BusinessException;

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
    public PageUtils<MessageStationView> getByPage(MessageStationDto dto) throws BusinessException;

    /**
     * 分页查询
     *
     * @param dto
     * @return
     * @throws BusinessException
     */
    public PageUtils<MessageStationView> getMngByPage(MessageStationDto dto) throws BusinessException;


    /**
     * limit , status查询
     *
     * @param status
     * @param limit
     * @return
     * @throws BusinessException
     */
    public List<MessageStationView> listByLimitStatus(int status, int limit) throws BusinessException;

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
    public List<MessageStationView> listAll() throws BusinessException;

    /**
     * 修改数据
     *
     * @param dto
     * @return
     * @throws BusinessException
     */
    public boolean modify(MessageStationModifyDto dto) throws BusinessException;

    /**
     * 查询未读条数
     *
     * @param userNo
     * @return
     * @throws BusinessException
     */
    public int unReadNum(Long userNo) throws BusinessException;

    /**
     * 阅读消息
     *
     * @param userNo
     * @param msgId
     * @return
     * @throws BusinessException
     */
    public boolean readMsg(Long userNo, Long msgId) throws BusinessException;

    /**
     * 删除消息
     *
     * @param userNo
     * @param msgId
     * @return
     * @throws BusinessException
     */
    public boolean delMsg(Long userNo, Long msgId) throws BusinessException;

    /**
     * 前size条数据
     *
     * @param size
     * @return
     * @throws BusinessException
     */
    public List<MessageStationView> listTop(Long userNo, int size, boolean unRead) throws BusinessException;

    /**
     * 发送消息
     *
     * @param userNo
     * @param title
     * @param content
     * @param creator
     * @return
     * @throws BusinessException
     */
    public boolean sendMsg(Long userNo, String title, String content, String creator) throws BusinessException;


    /**
     * 标记全部已读
     *
     * @param userNo
     * @return
     * @throws BusinessException
     */
    public boolean allSignRead(Long userNo) throws BusinessException;

}
