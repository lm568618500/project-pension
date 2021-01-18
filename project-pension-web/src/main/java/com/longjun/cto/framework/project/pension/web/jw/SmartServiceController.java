package com.longjun.cto.framework.project.pension.web.jw;

import com.longjun.cto.framework.project.pension.base.CqcWebBaseController;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

/**
 * 智慧服务
 * @author liuming
 */
@RequestMapping("/jw/smartService")
@Controller
public class SmartServiceController extends CqcWebBaseController {


    /**
     * 环卫一体化
     *
     * @return
     */
    @RequestMapping(value = "/integrated", method = {RequestMethod.POST, RequestMethod.GET})
    public ModelAndView integrated() {

        //UsersView usersView = currentUser();


        ModelAndView model = getModelAndView("/jw/smartService/integrated");

        // model.addObject("users", usersView);
        return model;
    }
    /**
     * 固废处理
     *
     * @return
     */
    @RequestMapping(value = "/treatment", method = {RequestMethod.POST, RequestMethod.GET})
    public ModelAndView treatment() {

        //UsersView usersView = currentUser();


        ModelAndView model = getModelAndView("/jw/smartService/treatment");

        // model.addObject("users", usersView);
        return model;
    }
    /**
     * 餐厨垃圾处理
     *
     * @return
     */
    @RequestMapping(value = "/garbageDisposal", method = {RequestMethod.POST, RequestMethod.GET})
    public ModelAndView garbageDisposal() {

        //UsersView usersView = currentUser();


        ModelAndView model = getModelAndView("/jw/smartService/garbageDisposal");

        // model.addObject("users", usersView);
        return model;
    }


}
