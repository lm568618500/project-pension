package com.longjun.cto.framework.project.pension.web.index;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.longjun.cto.framework.project.pension.base.CqcWebBaseController;
import com.longjun.cto.framework.project.pension.finance.entity.model.NewTypeOneModel;
import com.longjun.cto.framework.project.pension.finance.entity.model.NewTypeTwoModel;
import com.longjun.cto.framework.project.pension.finance.entity.model.NewsModel;
import com.longjun.cto.framework.project.pension.finance.service.*;
import com.longjun.cto.framework.project.pension.userManagement.service.IUsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import java.text.DateFormat;
import java.util.List;

/**
 * 登录注册
 *
 * @author meishunfa
 * @date 2019-10-19 07:48:34
 */
@RequestMapping("")
@Controller
public class IndexController extends CqcWebBaseController {

    @Autowired
    IUsersService iUsersService;

    @Autowired
    INewTypeFourService iNewTypeFourService;
    @Autowired
    INewTypeOneService iNewTypeOneService;

    @Autowired
    INewTypeTwoService iNewTypeTwoService;
    @Autowired
    INewTypeThreeService iNewTypeThreeService;
    @Autowired
    INewsService iNewsService;

    /**
     * 系统首页
     *
     * @return
     */
    @RequestMapping(value = "/", method = {RequestMethod.POST, RequestMethod.GET})
    public ModelAndView usersUpcomingListInit() {

        //UsersView usersView = currentUser();
        ModelAndView model = getModelAndView("/index/index");
        //一级分类
        EntityWrapper<NewTypeOneModel> oneWrapper=new EntityWrapper<NewTypeOneModel>();
        oneWrapper.in("id","1,2,3").eq("status",1).eq("is_del",0).orderBy("sort");
        List<NewTypeOneModel> oneList=this.iNewTypeOneService.selectList(oneWrapper);
        //二级分类
        for (NewTypeOneModel one:oneList){
            EntityWrapper<NewTypeTwoModel> twoWrapper=new EntityWrapper<NewTypeTwoModel>();
            twoWrapper.eq("status",1).eq("is_del",0).eq("parent_one_id",one.getId()).orderBy("sort");
            List<NewTypeTwoModel> twoList=this.iNewTypeTwoService.selectList(twoWrapper);
            one.setTwoList(twoList);
        }
        model.addObject("oneList", oneList);
        //公司新闻
        EntityWrapper<NewsModel> newsWrapper=new EntityWrapper<NewsModel>();
        newsWrapper.eq("status",1).eq("is_del",0).eq("type_one_id",4).eq("type_two_id",13).orderBy("id",false);
        List<NewsModel> newsList=this.iNewsService.selectList(newsWrapper);
        if(newsList.size()>6)
            model.addObject("newsList", newsList.subList(0,5));
        else
            model.addObject("newsList", newsList);
        //智慧环卫
        newsWrapper=new EntityWrapper<NewsModel>();
        newsWrapper.eq("status",1).eq("is_del",0).eq("type_one_id",2).eq("type_two_id",8).orderBy("id",false);
        newsList=this.iNewsService.selectList(newsWrapper);
        if(newsList.size()>6)
            model.addObject("newsList2", newsList.subList(0,5));
        else
            model.addObject("newsList2", newsList);
        return model;
    }


	private DateFormat SimpleDateFormat(String string) {
		// TODO Auto-generated method stub
		return null;
	}

}
