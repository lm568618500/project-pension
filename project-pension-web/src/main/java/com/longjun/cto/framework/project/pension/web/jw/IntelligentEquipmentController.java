package com.longjun.cto.framework.project.pension.web.jw;

import com.longjun.cto.framework.project.pension.base.CqcWebBaseController;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

/**
 * 智能装备
 * @author liuming
 */
@RequestMapping("/jw/intelligentEquipment")
@Controller
public class IntelligentEquipmentController extends CqcWebBaseController {


    /**
     * 环卫装备
     *
     * @return
     */
    @RequestMapping(value = "/sanitation", method = {RequestMethod.POST, RequestMethod.GET})
    public ModelAndView sanitation() {

        //UsersView usersView = currentUser();


        ModelAndView model = getModelAndView("/jw/intelligentEquipment/sanitation");

        // model.addObject("users", usersView);
        return model;
    }
    /**
     * 机器人
     *
     * @return
     */
    @RequestMapping(value = "/robot", method = {RequestMethod.POST, RequestMethod.GET})
    public ModelAndView robot() {

        //UsersView usersView = currentUser();


        ModelAndView model = getModelAndView("/jw/intelligentEquipment/robot");

        // model.addObject("users", usersView);
        return model;
    }
    /**
     * 环境装备
     *
     * @return
     */
    @RequestMapping(value = "/science", method = {RequestMethod.POST, RequestMethod.GET})
    public ModelAndView science() {

        //UsersView usersView = currentUser();


        ModelAndView model = getModelAndView("/jw/intelligentEquipment/science");

        // model.addObject("users", usersView);
        return model;
    }
    /**
     * 环境检测
     *
     * @return
     */
    @RequestMapping(value = "/testing", method = {RequestMethod.POST, RequestMethod.GET})
    public ModelAndView testing() {

        //UsersView usersView = currentUser();


        ModelAndView model = getModelAndView("/jw/intelligentEquipment/testing");

        // model.addObject("users", usersView);
        return model;
    }

}
