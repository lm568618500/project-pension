<@override name="body">

<fieldset class="layui-elem-field layui-field-title"  >
  <legend>服务器信息监控</legend>
</fieldset>
<div class="layui-collapse" lay-accordion="">
  <div class="layui-colla-item">
    <h2 class="layui-colla-title">OsInfo</h2>
    <div class="layui-colla-content">
      <p>name : ${osInfo.name}
      <p>version : ${osInfo.version}
      <p>pathSeparator : ${osInfo.pathSeparator}
      <p>windows : ${osInfo.windows?c}
      <p>lineSeparator : ${osInfo.lineSeparator}
      <p>aix : ${osInfo.aix?c}
      <p>windows95 : ${osInfo.windows95?c}
      <p>windows98 : ${osInfo.windows98?c}
      <p>windows7 : ${osInfo.windows7?c}
      <p>sunOS : ${osInfo.sunOS?c}
      <p>windowsXP : ${osInfo.windowsXP?c}
      <p>windowsNT : ${osInfo.windowsNT?c}
      <p>windows2000 : ${osInfo.windows2000?c}
      <p>hpUx : ${osInfo.hpUx?c}
      <p>macOsX : ${osInfo.macOsX?c}
      <p>os2 : ${osInfo.os2?c}
      <p>irix : ${osInfo.irix?c}
      <p>windowsME : ${osInfo.windowsME?c}
      <p>windoows8 : ${osInfo.windoows8?c}
      <p>windows8_1 : ${osInfo.windows8_1?c}
      <p>windows10 : ${osInfo.windows10?c}
      <p>fileSeparator : ${osInfo.fileSeparator}
      <p>mac : ${osInfo.mac?c}
      <p>linux : ${osInfo.linux?c}
      <p>solaris : ${osInfo.solaris?c}
      <p>arch : ${osInfo.arch}
      <br>
    </div>
  </div>
  
  <div class="layui-colla-item">
    <h2 class="layui-colla-title">JvmInfo</h2>
    <div class="layui-colla-content">
      <p>name : ${jvmInfo.name}
      <p>version : ${jvmInfo.version}
      <p>vendor : ${jvmInfo.vendor}
      <p>info : ${jvmInfo.info}
    </div>
  </div>
  
  <div class="layui-colla-item">
    <h2 class="layui-colla-title">JavaInfo</h2>
    <div class="layui-colla-content">
      <p>version : ${javaInfo.version}
      <p>versionFloat : ${javaInfo.versionFloat}
      <p>vendorURL : ${javaInfo.vendorURL}
      <p>java11 : ${javaInfo.java11?c}
      <p>java12 : ${javaInfo.java12?c}
      <p>java13 : ${javaInfo.java13?c}
      <p>java14 : ${javaInfo.java14?c}
      <p>java15 : ${javaInfo.java15?c}
      <p>java16 : ${javaInfo.java16?c}
      <p>java17 : ${javaInfo.java17?c}
      <p>java19 : ${javaInfo.java18?c}
    </div>
  </div>
  
  <div class="layui-colla-item">
    <h2 class="layui-colla-title">JvmSpecInfo</h2>
    <div class="layui-colla-content">
      <p>name : ${jvmSpecInfo.name}
      <p>version : ${jvmSpecInfo.version}
      <p>vendor : ${jvmSpecInfo.vendor}
    </div>
  </div>
  
   <div class="layui-colla-item">
    <h2 class="layui-colla-title">HostInfo</h2>
    <div class="layui-colla-content">
      <p>address : ${hostInfo.address}
      <p>name : ${hostInfo.name}
    </div>
  </div>
  
   <div class="layui-colla-item">
    <h2 class="layui-colla-title">RuntimeInfo</h2>
    <div class="layui-colla-content">
      <p>UsableMemory : ${runtimeInfo.UsableMemory}
      <p>TotalMemory : ${runtimeInfo.TotalMemory}
      <p>MaxMemory : ${runtimeInfo.MaxMemory}
      <p>FreeMemory : ${runtimeInfo.FreeMemory}
    </div>
  </div>
  
   <div class="layui-colla-item">
    <h2 class="layui-colla-title">RuntimeInfo</h2>
    <div class="layui-colla-content">
      <p>UsableMemory : ${runtimeInfo.UsableMemory}
      <p>TotalMemory : ${runtimeInfo.TotalMemory}
      <p>MaxMemory : ${runtimeInfo.MaxMemory}
      <p>FreeMemory : ${runtimeInfo.FreeMemory}
    </div>
  </div>
  
   <div class="layui-colla-item">
    <h2 class="layui-colla-title">JavaSpecInfo</h2>
    <div class="layui-colla-content">
      <p>name : ${javaSpecInfo.name}
      <p>version : ${javaSpecInfo.version}
      <p>vendor : ${javaSpecInfo.vendor}
    </div>
  </div>
  
   <div class="layui-colla-item">
    <h2 class="layui-colla-title">JavaRuntimeInfo</h2>
    <div class="layui-colla-content">
      <p>JavaExtensionDirs : ${javaRuntimeInfo.JavaExtensionDirs}
      <p>JavaEndorsedDirs : ${javaRuntimeInfo.JavaEndorsedDirs}
      <p>JavaClassPath : ${javaRuntimeInfo.JavaClassPath}
      <p>JavaRuntimeVersion : ${javaRuntimeInfo.JavaRuntimeVersion}
      <p>JavaLibraryPath : ${javaRuntimeInfo.JavaLibraryPath}
      <p>JavaProtocolPackages : ${javaRuntimeInfo.JavaProtocolPackages!''}
      <p>JavaHomeDir : ${javaRuntimeInfo.JavaHomeDir}
      <p>JavaClassVersion : ${javaRuntimeInfo.JavaClassVersion}
      <p>JavaRuntimeName : ${javaRuntimeInfo.JavaRuntimeName}
    </div>
  </div>
  
</div>



<!-- 注意：如果你直接复制所有代码到本地，上述js路径需要改成你本地的 -->
<script>
layui.use(['element', 'layer'], function(){
  var element = layui.element;
  var layer = layui.layer;
  
  //监听折叠
  element.on('collapse(test)', function(data){
    layer.msg('展开状态：'+ data.show);
  });
});
</script>
 
</@override>

<@extends name="//common/admin/iframe_templates.ftl"/>