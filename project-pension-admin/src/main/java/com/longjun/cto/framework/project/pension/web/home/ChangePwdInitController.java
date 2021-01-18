package com.longjun.cto.framework.project.pension.web.home;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.longjun.cto.framework.project.pension.base.CqcAdminBaseController;

/**
 * @author carson deng
 * @date 2019/11/16 13:36
 */
@RequestMapping("/mgn/home/changePwd")
@Controller
public class ChangePwdInitController extends CqcAdminBaseController {

    /**
     * 修改密码染页面
     *
     * @return
     */
    @RequestMapping(value = "/changePwdInit", method = {RequestMethod.POST, RequestMethod.GET})
    public ModelAndView changePwdInit() {
        ModelAndView model = getModelAndView("/mgn/home/home/changePwdInit");
        return model;
    }
}
