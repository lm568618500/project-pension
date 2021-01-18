package com.longjun.cto.framework.sm.sys.web;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.eims.cto.framework.common.base.ret.ApiResult;
import com.eims.cto.framework.standard.base.StandardBaseController;

import cn.hutool.core.io.FileUtil;
import cn.hutool.system.HostInfo;
import cn.hutool.system.JavaInfo;
import cn.hutool.system.JavaRuntimeInfo;
import cn.hutool.system.JavaSpecInfo;
import cn.hutool.system.JvmInfo;
import cn.hutool.system.JvmSpecInfo;
import cn.hutool.system.OsInfo;
import cn.hutool.system.RuntimeInfo;
import cn.hutool.system.SystemUtil;
import cn.hutool.system.UserInfo;

/**
 * Server监控
 * @author yangxuan
 * @date 2019年4月2日 下午2:50:41
 */
@RequestMapping("/mgn/sys/servermonitor")
@Controller
public class ServerMonitroController extends StandardBaseController {

	@ResponseBody
	@GetMapping("/serverJson")
	public ApiResult serverJson() throws Exception {
		ModelAndView model = getModelAndView("");
		OsInfo osInfo = SystemUtil.getOsInfo();
		UserInfo userInfo = SystemUtil.getUserInfo();
		JvmSpecInfo jvmSpecInfo = SystemUtil.getJvmSpecInfo();
		JvmInfo jvmInfo = SystemUtil.getJvmInfo();
		JavaSpecInfo javaSpecInfo = SystemUtil.getJavaSpecInfo();
		JavaInfo javaInfo = SystemUtil.getJavaInfo();
		JavaRuntimeInfo javaRuntimeInfo = SystemUtil.getJavaRuntimeInfo();
		HostInfo hostInfo = SystemUtil.getHostInfo();
		RuntimeInfo runtimeInfo = SystemUtil.getRuntimeInfo();
		Map<String , String> runtimeInfoMap = new HashMap<>();
		runtimeInfoMap.put("MaxMemory", FileUtil.readableFileSize(runtimeInfo.getMaxMemory()));
		runtimeInfoMap.put("TotalMemory", FileUtil.readableFileSize(runtimeInfo.getTotalMemory()));
		runtimeInfoMap.put("FreeMemory", FileUtil.readableFileSize(runtimeInfo.getFreeMemory()));
		runtimeInfoMap.put("UsableMemory", FileUtil.readableFileSize(runtimeInfo.getUsableMemory()));
		Map<String , String> javaRuntimeInfoMap = new HashMap<>();
		javaRuntimeInfoMap.put("JavaRuntimeName", javaRuntimeInfo.getName());
		javaRuntimeInfoMap.put("JavaRuntimeVersion", javaRuntimeInfo.getVersion());
		javaRuntimeInfoMap.put("JavaHomeDir", javaRuntimeInfo.getHomeDir());
		javaRuntimeInfoMap.put("JavaExtensionDirs", javaRuntimeInfo.getEndorsedDirs());
		javaRuntimeInfoMap.put("JavaEndorsedDirs", javaRuntimeInfo.getEndorsedDirs());
		javaRuntimeInfoMap.put("JavaClassPath", javaRuntimeInfo.getClassPath());
		javaRuntimeInfoMap.put("JavaClassVersion", javaRuntimeInfo.getClassVersion());
		javaRuntimeInfoMap.put("JavaLibraryPath", javaRuntimeInfo.getLibraryPath());
		javaRuntimeInfoMap.put("JavaProtocolPackages",javaRuntimeInfo.getProtocolPackages());
		return ApiResult.instance().ok("osInfo" , osInfo)
				.ok("userInfo",userInfo)
				.ok("jvmSpecInfo",jvmSpecInfo)
				.ok("javaSpecInfo",javaSpecInfo)
				.ok("javaInfo",javaInfo)
				.ok("javaRuntimeInfo",javaRuntimeInfoMap)
				.ok("hostInfo",hostInfo)
				.ok("runtimeInfo",runtimeInfoMap)
				.ok("jvmInfo",jvmInfo);
	}
	
	@ResponseBody
	@GetMapping("/server")
	public ModelAndView server() throws Exception {
		ModelAndView model = getModelAndView("/mgn/sys/monitor/server");
		OsInfo osInfo = SystemUtil.getOsInfo();
		UserInfo userInfo = SystemUtil.getUserInfo();
		JvmSpecInfo jvmSpecInfo = SystemUtil.getJvmSpecInfo();
		JvmInfo jvmInfo = SystemUtil.getJvmInfo();
		JavaSpecInfo javaSpecInfo = SystemUtil.getJavaSpecInfo();
		JavaInfo javaInfo = SystemUtil.getJavaInfo();
		JavaRuntimeInfo javaRuntimeInfo = SystemUtil.getJavaRuntimeInfo();
		HostInfo hostInfo = SystemUtil.getHostInfo();
		RuntimeInfo runtimeInfo = SystemUtil.getRuntimeInfo();
		Map<String , String> runtimeInfoMap = new HashMap<>();
		runtimeInfoMap.put("MaxMemory", FileUtil.readableFileSize(runtimeInfo.getMaxMemory()));
		runtimeInfoMap.put("TotalMemory", FileUtil.readableFileSize(runtimeInfo.getTotalMemory()));
		runtimeInfoMap.put("FreeMemory", FileUtil.readableFileSize(runtimeInfo.getFreeMemory()));
		runtimeInfoMap.put("UsableMemory", FileUtil.readableFileSize(runtimeInfo.getUsableMemory()));
		Map<String , String> javaRuntimeInfoMap = new HashMap<>();
		javaRuntimeInfoMap.put("JavaRuntimeName", javaRuntimeInfo.getName());
		javaRuntimeInfoMap.put("JavaRuntimeVersion", javaRuntimeInfo.getVersion());
		javaRuntimeInfoMap.put("JavaHomeDir", javaRuntimeInfo.getHomeDir());
		javaRuntimeInfoMap.put("JavaExtensionDirs", javaRuntimeInfo.getEndorsedDirs());
		javaRuntimeInfoMap.put("JavaEndorsedDirs", javaRuntimeInfo.getEndorsedDirs());
		javaRuntimeInfoMap.put("JavaClassPath", javaRuntimeInfo.getClassPath());
		javaRuntimeInfoMap.put("JavaClassVersion", javaRuntimeInfo.getClassVersion());
		javaRuntimeInfoMap.put("JavaLibraryPath", javaRuntimeInfo.getLibraryPath());
		javaRuntimeInfoMap.put("JavaProtocolPackages",javaRuntimeInfo.getProtocolPackages());
		
		
		model.addObject("osInfo", osInfo);
		model.addObject("userInfo", userInfo);
		model.addObject("jvmSpecInfo", jvmSpecInfo);
		model.addObject("javaSpecInfo", javaSpecInfo);
		model.addObject("javaInfo", javaInfo);
		model.addObject("javaRuntimeInfo", javaRuntimeInfoMap);
		model.addObject("hostInfo", hostInfo);
		model.addObject("runtimeInfo", runtimeInfoMap);
		model.addObject("jvmInfo", jvmInfo);
		return model;
	}
	
	

}
