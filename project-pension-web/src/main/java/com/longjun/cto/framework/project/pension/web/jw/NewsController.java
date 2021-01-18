package com.longjun.cto.framework.project.pension.web.jw;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.egzosn.pay.common.util.str.StringUtils;
import com.longjun.cto.framework.project.pension.base.CqcWebBaseController;
import com.longjun.cto.framework.project.pension.finance.entity.model.*;
import com.longjun.cto.framework.project.pension.finance.service.*;
import org.apache.commons.lang.StringEscapeUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.List;

/**
 * 关于我们
 * @author liuming
 */
@RequestMapping("/jw")
@Controller
public class NewsController extends CqcWebBaseController {
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
     * 公司概况
     *
     * @return
     */
    @RequestMapping(value = "/news", method = {RequestMethod.POST, RequestMethod.GET})
    public ModelAndView news(long oneId,long twoId,long threeId,long fourId,long newId) {
        //新闻
        List<NewsModel> newsList=new ArrayList<>();
        NewsModel news =new NewsModel();
        //一级分类
        NewTypeOneModel one=this.iNewTypeOneService.findModelById(oneId);
        //二级分类
        EntityWrapper<NewTypeTwoModel> twoWrapper=new EntityWrapper<NewTypeTwoModel>();
        twoWrapper.eq("parent_one_id",oneId).eq("status",1).eq("is_del",0).orderBy("sort");
        List<NewTypeTwoModel> twoList=this.iNewTypeTwoService.selectList(twoWrapper);
        NewTypeTwoModel two=new NewTypeTwoModel();
        //三级分类
        List<NewTypeThreeModel> threeList=new ArrayList<NewTypeThreeModel>();
        if(twoId==0){
            two=twoList.get(0);
            twoId=twoList.get(0).getId();
            EntityWrapper<NewTypeThreeModel> threeWrapper=new EntityWrapper<NewTypeThreeModel>();
            threeWrapper.eq("two_parent_id",twoId).eq("status",1).eq("is_del",0).orderBy("sort");
            threeList=this.iNewTypeThreeService.selectList(threeWrapper);
            if(threeList.isEmpty()){
                EntityWrapper<NewsModel> newsWrapper=new EntityWrapper<NewsModel>();
                newsWrapper.eq("type_two_id",twoId).eq("status",1).eq("is_del",0).orderBy("sort");
                newsList=this.iNewsService.selectList(newsWrapper);
            }
        }else{
            two=this.iNewTypeTwoService.findModelById(twoId);
            EntityWrapper<NewTypeThreeModel> threeWrapper=new EntityWrapper<NewTypeThreeModel>();
            threeWrapper.eq("two_parent_id",twoId).eq("status",1).eq("is_del",0).orderBy("sort");
            threeList=this.iNewTypeThreeService.selectList(threeWrapper);
            if(threeList.isEmpty()){
                EntityWrapper<NewsModel> newsWrapper=new EntityWrapper<NewsModel>();
                newsWrapper.eq("type_two_id",twoId).eq("status",1).eq("is_del",0).orderBy("sort");
                newsList=this.iNewsService.selectList(newsWrapper);
            }
        }
        //四级分类
        List<NewTypeFourModel> fourList=new ArrayList<NewTypeFourModel>();
        if(!threeList.isEmpty()){
            if(threeId<=0) {
                threeId = threeList.get(0).getId();
            }
            EntityWrapper<NewTypeFourModel> fourWrapper=new EntityWrapper<NewTypeFourModel>();
            fourWrapper.eq("three_parent_id",threeId).eq("status",1).eq("is_del",0).orderBy("sort");
            fourList=this.iNewTypeFourService.selectList(fourWrapper);
            if(fourList.isEmpty()){
                EntityWrapper<NewsModel> newsWrapper=new EntityWrapper<NewsModel>();
                newsWrapper.eq("type_three_id",threeId).eq("status",1).eq("is_del",0).orderBy("sort");
                newsList=this.iNewsService.selectList(newsWrapper);
            }else{
                if(fourId<=0) {
                    //fourId = fourList.get(0).getId();
                    //全部新闻
                    EntityWrapper<NewsModel> newsWrapper=new EntityWrapper<NewsModel>();
                    newsWrapper.eq("type_three_id",threeId).eq("status",1).eq("is_del",0).orderBy("sort");
                    newsList=this.iNewsService.selectList(newsWrapper);
                }else {
                    EntityWrapper<NewsModel> newsWrapper = new EntityWrapper<NewsModel>();
                    newsWrapper.eq("type_four_id", fourId).eq("status", 1).eq("is_del", 0).orderBy("sort");
                    newsList = this.iNewsService.selectList(newsWrapper);
                }
            }
        }
        if(newId>0){
            news=this.iNewsService.findModelById(newId);
        }else {
            if(!newsList.isEmpty()) {
                news = newsList.get(0);
            }
        }
        List<String> imagesList= new ArrayList<>();
        String images1="";
        if(StringUtils.isNotEmpty(news.getImagesList())){
            String[] images=news.getImagesList().split(",");
            for (int i=0;i<images.length;i++){
                imagesList.add(images[i]);
            }
            images1=imagesList.get(0);
        }
        news.setConten(StringEscapeUtils.unescapeHtml(news.getConten()));
        ModelAndView model = getModelAndView("/jw/news/news");
        model.addObject("one", one);
        model.addObject("two", two);
        model.addObject("twoList", twoList);
        model.addObject("threeList", threeList);
        model.addObject("fourList", fourList);
        model.addObject("fourSize", fourList.size());
        model.addObject("newsList", newsList);
        model.addObject("newsSize", newsList.size());
        model.addObject("news", news);
        model.addObject("oneId", oneId);
        model.addObject("twoId", twoId);
        model.addObject("threeId", threeId);
        model.addObject("fourId", fourId);
        model.addObject("newId", newId);
        model.addObject("imagesList", imagesList);
        model.addObject("imagesListSize", imagesList.size());
        model.addObject("images1", images1);
        return model;
    }
    /**
     * 视频中心
     *
     * @return
     */
    @RequestMapping(value = "/video", method = {RequestMethod.POST, RequestMethod.GET})
    public ModelAndView video() {

        //UsersView usersView = currentUser();


        ModelAndView model = getModelAndView("/jw/aboutUs/video");

        // model.addObject("users", usersView);
        return model;
    }
    /**
     * 企业文化
     *
     * @return
     */
    @RequestMapping(value = "/culture", method = {RequestMethod.POST, RequestMethod.GET})
    public ModelAndView culture() {

        //UsersView usersView = currentUser();


        ModelAndView model = getModelAndView("/jw/aboutUs/culture");

        // model.addObject("users", usersView);
        return model;
    }
    /**
     * 发展历程
     *
     * @return
     */
    @RequestMapping(value = "/course", method = {RequestMethod.POST, RequestMethod.GET})
    public ModelAndView course() {

        //UsersView usersView = currentUser();


        ModelAndView model = getModelAndView("/jw/aboutUs/course");

        // model.addObject("users", usersView);
        return model;
    }
    /**
     * 社会责任
     *
     * @return
     */
    @RequestMapping(value = "/responsibility", method = {RequestMethod.POST, RequestMethod.GET})
    public ModelAndView responsibility() {

        //UsersView usersView = currentUser();


        ModelAndView model = getModelAndView("/jw/aboutUs/responsibility");

        // model.addObject("users", usersView);
        return model;
    }
    /**
     * 企业荣誉
     *
     * @return
     */
    @RequestMapping(value = "/honor", method = {RequestMethod.POST, RequestMethod.GET})
    public ModelAndView honor() {

        //UsersView usersView = currentUser();


        ModelAndView model = getModelAndView("/jw/aboutUs/honor");

        // model.addObject("users", usersView);
        return model;
    }

}
