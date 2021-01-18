package com.longjun.cto.framework.sm.sys.filter;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.eims.cto.framework.common.conf.SysSetting;
import com.eims.cto.framework.common.core.utils.cache.ICache;
import com.longjun.cto.framework.project.pension.finance.entity.model.NewTypeOneModel;
import com.longjun.cto.framework.project.pension.finance.entity.model.NewTypeTwoModel;
import com.longjun.cto.framework.project.pension.finance.service.INewTypeOneService;
import com.longjun.cto.framework.project.pension.finance.service.INewTypeTwoService;
import com.longjun.cto.framework.sm.sys.service.ICommonOptionService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;
import java.util.Map;

/**
 * Cookie过滤器
 * 
 * @author yangxuan
 * @date 2019年4月8日 下午5:49:51
 */
@Component
public class SmSysFilter implements Filter {

	private static Logger LOG = LoggerFactory.getLogger(SmSysFilter.class);

	private FilterConfig filterConfig;

	@Autowired
	ICache iCache;

	@Autowired
	ICommonOptionService iCommonOptionService;
	@Autowired
	INewTypeOneService iNewTypeOneService;
	@Autowired
	INewTypeTwoService iNewTypeTwoService;

	public void init(FilterConfig config) {
		this.filterConfig = config;
	}

	/**
	 * 填充值
	 */
	private void fullValue(HttpServletRequest request, HttpServletResponse response) {
		Map<String, Object> initMap = iCommonOptionService.initMap();
			request.setAttribute("GlobalMap", initMap);
		request.setAttribute("serverUrl", SysSetting.STANDARD_SERVERURL);
		request.setAttribute("staticServer", SysSetting.STANDARD_STATICSERVER);
		request.setAttribute("pubStaticServer", SysSetting.STANDARD_PUBSTATICSERVER);
		EntityWrapper<NewTypeOneModel> oneWrapper=new EntityWrapper<NewTypeOneModel>();
		oneWrapper.eq("status",1).eq("is_del",0).orderBy("sort");
		List<NewTypeOneModel> oneList=this.iNewTypeOneService.selectList(oneWrapper);
		for (NewTypeOneModel one:oneList){
			EntityWrapper<NewTypeTwoModel> twoWrapper=new EntityWrapper<NewTypeTwoModel>();
			twoWrapper.eq("status",1).eq("is_del",0).eq("parent_one_id",one.getId()).orderBy("sort");
			List<NewTypeTwoModel> twoList=this.iNewTypeTwoService.selectList(twoWrapper);
			one.setTwoList(twoList);
		}
		request.setAttribute("oneWebList", oneList);


	}

	public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain)
			throws ServletException, IOException {
		HttpServletRequest request = (HttpServletRequest) req;
		HttpServletResponse response = (HttpServletResponse) resp;
		fullValue(request, response);
		chain.doFilter(req, resp);
	}

	public void destroy() {
		this.filterConfig = null;
	}

}