package com.longjun.cto.framework.sm.sys.web;

import java.util.Set;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.eims.cto.framework.common.base.ret.ApiResult;
import com.eims.cto.framework.standard.base.StandardBaseController;

/**
 * 系统缓存管理
 * 
 * @author yangxuan
 * @date Jun 9, 2019 - 10:35:36 AM
 */
@RequestMapping("/mgn/sys/cache")
@Controller
public class CacheConsoleController extends StandardBaseController {

	@Resource(name = "redisTemplate")
	private RedisTemplate<String, String> redis;

	/**
	 * 缓存管理初始化页面
	 * 
	 * @param request
	 * @return
	 */
	@GetMapping("/cacheInit")
	public ModelAndView cacheInit(HttpServletRequest request) {
		ModelAndView model = getModelAndView("/mgn/sys/cache/cacheInit");
		return model;
	}

	/**
	 * 缓存清除
	 * 
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "/clear", method = { RequestMethod.GET, RequestMethod.POST })
	public ApiResult clear() {
		String key = "buz-cache-standard";
		doClear(key);
		key = "buz-cache-ext";
		doClear(key);
		return ApiResult.instance().ok("ret", "清除成功");
	}

	/**
	 * 删除缓存操作
	 * 
	 * @param keyStr
	 */
	private void doClear(String keyStr) {
		final String key = "*" + keyStr + "*";
		Set<String> stringSet = redis.keys(key);
		redis.delete(stringSet);// 删除缓存
		log.info("清除 " + key + " 缓存");
	}

}
