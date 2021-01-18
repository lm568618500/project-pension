package com.longjun.cto.framework.project.pension.web.home;

import com.eims.cto.framework.common.base.page.PageUtils;
import com.eims.cto.framework.common.base.ret.ActionResult;
import com.eims.cto.framework.common.base.ret.ApiResult;
import com.longjun.cto.framework.project.pension.base.CqcAdminBaseController;
import com.longjun.cto.framework.sm.message.entity.dto.MessageStationDto;
import com.longjun.cto.framework.sm.message.entity.view.MessageStationView;
import com.longjun.cto.framework.sm.message.service.IMessageStationService;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;

/**
 * @author carson deng
 * @date 2019/11/16 14:08
 */
@RequestMapping("/mgn/home/messageStation")
@Controller
public class MngMessageStationController extends CqcAdminBaseController {


    @Resource
    IMessageStationService iMessageStationService;


    /**
     * 站内消息染页面
     *
     * @return
     */
    @RequestMapping(value = "/messageStationInit", method = {RequestMethod.POST, RequestMethod.GET})
    public ModelAndView personalDataInit() {
        ModelAndView model = getModelAndView("/mgn/home/home/messageStationListInit");
        return model;
    }


    /**
     * 分页查询
     *
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/getByPage", method = {RequestMethod.POST, RequestMethod.GET})
    public ActionResult<PageUtils<MessageStationView>> getByPage(MessageStationDto dto) {

        dto.setC_userNo(super.currentAdmin().getId().toString());
        PageUtils<MessageStationView> ret = this.iMessageStationService.getMngByPage(dto);
        return ActionResult.ok(ret);
    }


    /**
     * 标记已读
     *
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/signRead", method = {RequestMethod.POST})
    public ApiResult signRead(Long msgId) {

        this.iMessageStationService.readMsg(super.currentAdmin().getId(),msgId);
        return ApiResult.instance().ok("ret", true);
    }

    /**
     * 标记全部已读
     *
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/allSignRead", method = {RequestMethod.POST})
    public ApiResult allSignRead() {

        this.iMessageStationService.allSignRead(super.currentAdmin().getId());
        return ApiResult.instance().ok("ret", true);
    }
}
