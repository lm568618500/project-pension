package com.longjun.cto.framework.sm.message.web;

import org.springframework.beans.factory.annotation.Autowired;
import com.eims.cto.framework.standard.base.StandardBaseController;
import com.longjun.cto.framework.sm.message.entity.dto.MessageStationDto;
import com.longjun.cto.framework.sm.message.entity.dto.MessageStationModifyDto;
import com.longjun.cto.framework.sm.message.entity.model.MessageStationModel;
import com.longjun.cto.framework.sm.message.entity.view.MessageStationView;
import com.longjun.cto.framework.sm.message.entity.view.MessageTempView;
import com.longjun.cto.framework.sm.message.service.IMessageStationService;
import com.longjun.cto.framework.sm.message.service.IMessageTempService;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import com.eims.cto.framework.common.base.page.PageUtils;
import com.eims.cto.framework.common.base.ret.ActionResult;
import com.eims.cto.framework.common.base.ret.ApiResult;

import java.lang.Long;
import java.util.List;

/**
 * MessageStation Controller
 * 
 * @author yangxuan
 * @date 2019-07-04 07:33:46
 */
@RequestMapping("/mgn/sm/message/messageStation")
@Controller
public class MessageStationController extends StandardBaseController {

	@Autowired
	private IMessageStationService iMessageStationService;

	@Autowired
	private IMessageTempService iMessageTempService;

	/**
	 * 列表渲染页面
	 * 
	 * @return
	 */
	@RequestMapping(value = "/messageStationListInit", method = { RequestMethod.POST, RequestMethod.GET })
	public ModelAndView messageStationListInit() {
		ModelAndView model = getModelAndView("/mgn/sm/message/messageStation/messageStationListInit");
		List<MessageTempView> temps = this.iMessageTempService.listByLimitStatus(1, 10000);
		model.addObject("temps", temps);
		return model;
	}

	/**
	 * 新增渲染页面
	 * 
	 * @return
	 */
	@RequestMapping(value = "/messageStationAddInit", method = { RequestMethod.POST, RequestMethod.GET })
	public ModelAndView messageStationAddInit() {
		ModelAndView model = getModelAndView("/mgn/sm/message/messageStation/messageStationAddInit");
		return model;
	}

	/**
	 * 编辑渲染页面
	 * 
	 * @return
	 */
	@RequestMapping(value = "/messageStationEditInit", method = { RequestMethod.POST, RequestMethod.GET })
	public ModelAndView messageStationEditInit(Long id) {
		ModelAndView model = getModelAndView("/mgn/sm/message/messageStation/messageStationEditInit");
		MessageStationView ret = this.iMessageStationService.findViewById(id);
		model.addObject("view", ret);
		return model;
	}

	/**
	 * 编辑渲染页面
	 * 
	 * @return
	 */
	@RequestMapping(value = "/messageStationShowInit", method = { RequestMethod.POST, RequestMethod.GET })
	public ModelAndView messageStationShowInit(Long id) {
		ModelAndView model = getModelAndView("/mgn/sm/message/messageStation/messageStationShowInit");
		MessageStationView ret = this.iMessageStationService.findViewById(id);
		model.addObject("view", ret);
		return model;
	}

	/**
	 * 分页查询
	 * 
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "/getByPage", method = { RequestMethod.POST, RequestMethod.GET })
	public ActionResult<PageUtils<MessageStationView>> getByPage(MessageStationDto dto) {
		PageUtils<MessageStationView> ret = this.iMessageStationService.getByPage(dto);
		return ActionResult.ok(ret);
	}

	/**
	 * 查询View数据
	 * 
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "/getViewById", method = { RequestMethod.GET })
	public ActionResult<MessageStationView> getViewById(Long id) {
		MessageStationView ret = this.iMessageStationService.findViewById(id);
		return ActionResult.ok(ret);
	}

	/**
	 * 查询Model数据
	 * 
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "/getModelById", method = { RequestMethod.GET })
	public ActionResult<MessageStationModel> findModelById(Long id) {
		MessageStationModel ret = this.iMessageStationService.findModelById(id);
		return ActionResult.ok(ret);
	}

	/**
	 * 停用
	 * 
	 * @param id
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "/stop", method = { RequestMethod.POST })
	public ApiResult stop(Long id) {
		Boolean ret = this.iMessageStationService.stop(id);
		return ApiResult.instance().ok("ret", ret);
	}

	/**
	 * 开启
	 * 
	 * @param id
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "/start", method = { RequestMethod.POST })
	public ApiResult start(Long id) {
		Boolean ret = this.iMessageStationService.start(id);
		return ApiResult.instance().ok("ret", ret);
	}

	/**
	 * 保存
	 * 
	 * @param id
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "/saveModel", method = { RequestMethod.POST })
	public ApiResult saveModel(String userNos , String creator , String title , String content) {
		this.iMessageStationService.saveModel(userNos, creator, title, content);
		return ApiResult.instance().ok("ret", true);
	}

	/**
	 * 修改
	 * 
	 * @param id
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "/modify", method = { RequestMethod.POST })
	public ApiResult modify(MessageStationModifyDto model) {
		this.iMessageStationService.modify(model);
		return ApiResult.instance().ok("ret", true);
	}

	/**
	 * 删除
	 * 
	 * @param id
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "/del", method = { RequestMethod.POST })
	public ApiResult del(Long id) {
		Boolean ret = this.iMessageStationService.del(id);
		return ApiResult.instance().ok("ret", ret);
	}

}
