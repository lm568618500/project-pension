package com.longjun.cto.framework.sm.sys.web;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.apache.shiro.subject.Subject;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSONObject;

@RequestMapping("/shiroTest")
@Controller
public class ShiroTestController {

	@ResponseBody
	@GetMapping("/anno")
	public String anno() {
		
		return "anno";
	}
	
	@ResponseBody
	@RequiresPermissions("sys:config:list")
	@GetMapping("/oauth2")
	public String oauth2() {
		
		return "oauth2";
	}
	
	@ResponseBody
	@RequiresPermissions("sys:config:subject")
	@GetMapping("/subject")
	public String subject() {
		Subject subject = SecurityUtils.getSubject();
		return JSONObject.toJSONString(subject.getPrincipal());
	}
	
	@ResponseBody
	@RequiresPermissions("sys:config:sss")
	@GetMapping("/subjectsss")
	public String subjectsss() {
		return "subjectsss";
	}
	
}
