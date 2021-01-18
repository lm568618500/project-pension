<@override name="body">
<style>
    .layui-form-item{
       margin-left: 40px;
    }
    .layui-form-item .layui-form-label {
      width: 160px;
    }
</style>
<form class="layui-form" id="form">
       <blockquote class="layui-elem-quote"><@i18N key='sys.setting.SheZhiJianYanChaoShiTiXing' /></blockquote>
       <div class="layui-form-item">
		    <label class="layui-form-label"><span style="color:red;">*</span><@i18N key='sys.setting.SheZhiJianYanChaoShiTiXing' />：</label>
		    <div class="layui-form-mid layui-word-aux">&nbsp;&nbsp;&nbsp;<@i18N key='sys.setting.GongChangJieShouShouLiHou' />，<@i18N key='sys.setting.ChaoChu' /></div>
		    <div class="layui-input-inline">
		         <input type="text" name="FACTORY_CHECK_TIME_V" lay-verify="required|number" value='${settingData["FACTORY_CHECK_TIME"].v}'  autocomplete="off"  class="layui-input">
		    </div>
		    <div class="layui-form-mid layui-word-aux"><@i18N key='sys.setting.TianHou' />，</div>
		    <div class="layui-input-inline">
		        <select name="FACTORY_CHECK_TIME_SELECT" lay-verify="required" lay-search="">
		          <option value=""><@i18N key='qxz' /></option>
		          <option value="1" <#if settingData["FACTORY_CHECK_TIME"].vtype == 1> selected</#if>><@i18N key='sys.setting.YouXiang' /></option>
		          <option value="2" <#if settingData["FACTORY_CHECK_TIME"].vtype == 2> selected</#if>><@i18N key='sys.setting.DuanXin' /></option>
		          <option value="3" <#if settingData["FACTORY_CHECK_TIME"].vtype == 3> selected</#if>><@i18N key='sys.setting.YouXiang' />+<@i18N key='sys.setting.DuanXin' /></option>
		        </select>
		    </div>
		    <div class="layui-form-mid layui-word-aux"><@i18N key='sys.setting.YuJingTiXing' />。</div>
		    <div class="layui-input-item">
		      <input type="radio" name="FACTORY_CHECK_TIME_R" value="1" title="<@i18N key='sys.setting.KaiQi' />" <#if settingData["FACTORY_CHECK_TIME"].status == 1> checked=""</#if>>
		      <input type="radio" name="FACTORY_CHECK_TIME_R" value="0" title="<@i18N key='sys.setting.GuanBi' />" <#if settingData["FACTORY_CHECK_TIME"].status == 0> checked=""</#if>>
            </div>
		</div>
        <div class="layui-form-item">
		    <label class="layui-form-label"><span style="color:red;">*</span><@i18N key='sys.setting.ShiYanShiJianCeChaoShiTiXing' />：</label>
		    <div class="layui-form-mid layui-word-aux"><@i18N key='sys.setting.ShiYanShiJieShouShouLiHou' />，超出</div>
		    <div class="layui-input-inline">
		         <input type="text" name="SYS_CHECK_TIME_V" lay-verify="required|number" value='${settingData["SYS_CHECK_TIME"].v}'  autocomplete="off"  class="layui-input">
		    </div>
		    <div class="layui-form-mid layui-word-aux"><@i18N key='sys.setting.TianHou' />，</div>
		    <div class="layui-input-inline">
		        <select name="SYS_CHECK_TIME_SELECT" lay-verify="required" lay-search="">
		          <option value=""><@i18N key='qxz' /></option>
		          <option value="1" <#if settingData["SYS_CHECK_TIME"].vtype == 1> selected</#if>><@i18N key='sys.setting.YouXiang' /></option>
		          <option value="2" <#if settingData["SYS_CHECK_TIME"].vtype == 2> selected</#if>><@i18N key='sys.setting.DuanXin' /></option>
		          <option value="3" <#if settingData["SYS_CHECK_TIME"].vtype == 3> selected</#if>><@i18N key='sys.setting.YouXiang' />+<@i18N key='sys.setting.DuanXin' /></option>
		        </select>
		    </div>
		    <div class="layui-form-mid layui-word-aux"><@i18N key='sys.setting.YuJingTiXing' />。</div>
		    <div class="layui-input-item">
		      <input type="radio" name="SYS_CHECK_TIME_R" value="1" title="<@i18N key='sys.setting.KaiQi' />" <#if settingData["SYS_CHECK_TIME"].status == 1> checked=""</#if>>
		      <input type="radio" name="SYS_CHECK_TIME_R" value="0" title="<@i18N key='sys.setting.GuanBi' />" <#if settingData["SYS_CHECK_TIME"].status == 0> checked=""</#if>>
            </div>
		</div>
		<blockquote class="layui-elem-quote"><@i18N key='sys.setting.SheZhiZhengShuZiZhiDaoQiTiXing' /></blockquote>.
		<div class="layui-form-item">
		    <label class="layui-form-label"><span style="color:red;">*</span><@i18N key='sys.setting.ZhengShuZiZhiDaoQiTiXing' />：</label>
		    <div class="layui-form-mid layui-word-aux"><@i18N key='sys.setting.JuLiDaoQiShiJian' /></div>
		    <div class="layui-input-inline">
		         <input type="text" name="RZZZ_CHECK_TIME_HOUR_V" lay-verify="required|number" value='${settingData["RZZZ_CHECK_TIME_HOUR"].v}'  autocomplete="off"  class="layui-input">
		    </div>
		    <div class="layui-form-mid layui-word-aux"><@i18N key='sys.setting.XiaoShiTiXing' />；</div>
		    <div class="layui-input-item">
		      <input type="radio" name="RZZZ_CHECK_TIME_HOUR_R" value="1" title="<@i18N key='sys.setting.KaiQi' />" <#if settingData["RZZZ_CHECK_TIME_HOUR"].status == 1> checked=""</#if>>
		      <input type="radio" name="RZZZ_CHECK_TIME_HOUR_R" value="0" title="<@i18N key='sys.setting.GuanBi' />" <#if settingData["RZZZ_CHECK_TIME_HOUR"].status == 0> checked=""</#if>>
            </div>
		</div>
		
		<div class="layui-form-item">
		    <label class="layui-form-label"></label>
		    <div class="layui-form-mid layui-word-aux"><@i18N key='sys.setting.JuLiDaoQiShiJian' /></div>
		    <div class="layui-input-inline">
		         <input type="text" name="RZZZ_CHECK_TIME_DAY_V" lay-verify="required|number" value='${settingData["RZZZ_CHECK_TIME_DAY"].v}'  autocomplete="off"  class="layui-input">
		    </div>
		    <div class="layui-form-mid layui-word-aux"><@i18N key='sys.setting.RiTiXing' />；&nbsp;&nbsp;&nbsp;</div>
		    <div class="layui-input-item">
		      <input type="radio" name="RZZZ_CHECK_TIME_DAY_R" value="1" title="<@i18N key='sys.setting.KaiQi' />" <#if settingData["RZZZ_CHECK_TIME_DAY"].status == 1> checked=""</#if>>
		      <input type="radio" name="RZZZ_CHECK_TIME_DAY_R" value="0" title="<@i18N key='sys.setting.GuanBi' />" <#if settingData["RZZZ_CHECK_TIME_DAY"].status == 0> checked=""</#if>>
            </div>
		</div>
		
		<div class="layui-form-item">
		    <label class="layui-form-label"></label>
		    <div class="layui-form-mid layui-word-aux"><@i18N key='sys.setting.JuLiDaoQiShiJian' /></div>
		    <div class="layui-input-inline">
		         <input type="text" name="RZZZ_CHECK_TIME_MONTH_K" lay-verify="required|number" value='${settingData["RZZZ_CHECK_TIME_MONTH"].v}'  autocomplete="off"  class="layui-input">
		    </div>
		    <div class="layui-form-mid layui-word-aux"><@i18N key='sys.setting.YueTiXing' />；&nbsp;&nbsp;&nbsp;</div>
		    <div class="layui-input-item">
		      <input type="radio" name="RZZZ_CHECK_TIME_MONTH_R" value="1" title="<@i18N key='sys.setting.KaiQi' />" <#if settingData["RZZZ_CHECK_TIME_MONTH"].status == 1> checked=""</#if>>
		      <input type="radio" name="RZZZ_CHECK_TIME_MONTH_R" value="0" title="<@i18N key='sys.setting.GuanBi' />" <#if settingData["RZZZ_CHECK_TIME_MONTH"].status == 0> checked=""</#if>>
            </div>
		</div>
		
		<div class="layui-form-item">
		    <label class="layui-form-label"><span style="color:red;">*</span><@i18N key='sys.setting.JianChaYuanZiZhiDaoQiTiXing' />：</label>
		    <div class="layui-form-mid layui-word-aux"><@i18N key='sys.setting.JuLiDaoQiShiJian' /></div>
		    <div class="layui-input-inline">
		         <input type="text" name="JCYZZ_CHECK_TIME_HOUR_K" lay-verify="required|number" value='${settingData["JCYZZ_CHECK_TIME_HOUR"].v}'  autocomplete="off"  class="layui-input">
		    </div>
		    <div class="layui-form-mid layui-word-aux"><@i18N key='sys.setting.XiaoShiTiXing' />；</div>
		    <div class="layui-input-item">
		      <input type="radio" name="JCYZZ_CHECK_TIME_HOUR_R" value="1" title="<@i18N key='sys.setting.KaiQi' />" <#if settingData["RZZZ_CHECK_TIME_MONTH"].status == 1> checked=""</#if>>
		      <input type="radio" name="JCYZZ_CHECK_TIME_HOUR_R" value="0" title="<@i18N key='sys.setting.GuanBi' />" <#if settingData["RZZZ_CHECK_TIME_MONTH"].status == 0> checked=""</#if>>
            </div>
		</div>
		
		<div class="layui-form-item">
		    <label class="layui-form-label"></label>
		    <div class="layui-form-mid layui-word-aux"><@i18N key='sys.setting.JuLiDaoQiShiJian' /></div>
		    <div class="layui-input-inline">
		         <input type="text" name="JCYZZ_CHECK_TIME_DAY_K" lay-verify="required|number" value='${settingData["JCYZZ_CHECK_TIME_DAY"].v}'  autocomplete="off"  class="layui-input">
		    </div>
		    <div class="layui-form-mid layui-word-aux"><@i18N key='sys.setting.RiTiXing' />；&nbsp;&nbsp;&nbsp;</div>
		    <div class="layui-input-item">
		      <input type="radio" name="JCYZZ_CHECK_TIME_DAY_R" value="1" title="<@i18N key='sys.setting.KaiQi' />" <#if settingData["JCYZZ_CHECK_TIME_DAY"].status == 1> checked=""</#if>>
		      <input type="radio" name="JCYZZ_CHECK_TIME_DAY_R" value="0" title="<@i18N key='sys.setting.GuanBi' />" <#if settingData["JCYZZ_CHECK_TIME_DAY"].status == 0> checked=""</#if>>
            </div>
		</div>
		
		<div class="layui-form-item">
		    <label class="layui-form-label"></label>
		    <div class="layui-form-mid layui-word-aux"><@i18N key='sys.setting.JuLiDaoQiShiJian' /></div>
		    <div class="layui-input-inline">
		         <input type="text" name="JCYZZ_CHECK_TIME_MONTH_K" lay-verify="required|number" value='${settingData["JCYZZ_CHECK_TIME_MONTH"].v}'  autocomplete="off"  class="layui-input">
		    </div>
		    <div class="layui-form-mid layui-word-aux"><@i18N key='sys.setting.YueTiXing' />；&nbsp;&nbsp;&nbsp;</div>
		    <div class="layui-input-item">
		      <input type="radio" name="JCYZZ_CHECK_TIME_MONTH_R" value="1" title="<@i18N key='sys.setting.KaiQi' />" <#if settingData["JCYZZ_CHECK_TIME_MONTH"].status == 1> checked=""</#if>>
		      <input type="radio" name="JCYZZ_CHECK_TIME_MONTH_R" value="0" title="<@i18N key='sys.setting.GuanBi' />" <#if settingData["JCYZZ_CHECK_TIME_MONTH"].status == 0> checked=""</#if>>
            </div>
		</div>
		
		<blockquote class="layui-elem-quote"><@i18N key='sys.setting.SheZhiTongZhiXiaoXiTiXing' /></blockquote>
		<div class="layui-form-item">
		    <label class="layui-form-label"><span style="color:red;">*</span><@i18N key='sys.setting.XiaoXiBiaoZhi' />：</label>
		    <div class="layui-input-item">
		        <div style="float: left;margin-right: 10px">
					<img id="LAY_upload" width="120px" height="120px" src="${settingData["MSG_SIGN_REMIND"].v!}">
				</div>
				<div style="float: left;line-height: 120px;">
				   	<input type="hidden" id="MSG_SIGN_REMIND_V" name="MSG_SIGN_REMIND_V"  value='${settingData["MSG_SIGN_REMIND"].v!}'  autocomplete="off"  class="layui-input">
					<button type="button" class="layui-btn" id="upload"><i class="layui-icon"></i><@i18N key='sys.setting.ShangChuanBiaoZhi' /></button>
				</div>
		    </div>
		</div>
		<div class="layui-form-item">
		    <label class="layui-form-label"><span style="color:red;">*</span><@i18N key='sys.setting.FaSongTongZhiXiaoXiDaiBiaoZhi' />：</label>
		    <div class="layui-input-item">
		      <input type="radio" name="MSG_SIGN_REMIND_R" value="1" title="<@i18N key='sys.setting.DaiBiaoZhi' />" <#if settingData["MSG_SIGN_REMIND"].status == 1> checked=""</#if>>
		      <input type="radio" name="MSG_SIGN_REMIND_R" value="0" title="<@i18N key='sys.setting.BuDaiBiaoZhi' />" <#if settingData["MSG_SIGN_REMIND"].status == 0> checked=""</#if>>
            </div>
		</div>
		
		<blockquote class="layui-elem-quote"><@i18N key='sys.setting.BiaoZhiDanJiaGuanLi' /></blockquote>
		<table class="layui-table" style="width:80%;">
		    <colgroup>
		      <col width="100">
		      <col width="200">
		      <col width="200">
		      <col width="200">
		    </colgroup>
		    <tbody>
		      <#list settingPrices as settingPrice>
		      <#if settingPrice.unitType == 1>
		      <tr>
		        <td>
		            <#if settingPrice.type == 1>8mm</#if>
		            <#if settingPrice.type == 2>15mm</#if>
		            <#if settingPrice.type == 3>30mm</#if>
		            <#if settingPrice.type == 4>45mm</#if>
		            <#if settingPrice.type == 5>60mm<@i18N key='sys.setting.ZhengTieHeFanTie' /></#if>
		        </td>
		        <td>
		          <div class="layui-input-inline">
		             <input type="hidden" name="id"   value='${settingPrice.id}'  autocomplete="off"  class="layui-input">
		             <input type="hidden" name="type"   value='${settingPrice.type}'  autocomplete="off"  class="layui-input">
		             <input type="hidden" name="unitType"   value='${settingPrice.unitType}'  autocomplete="off"  class="layui-input">
		             <input type="text" name="edition" lay-verify="required|number"  value='${settingPrice.edition}'  autocomplete="off"  class="layui-input">
		          </div>
		          <@i18N key='sys.setting.Yuan' />/<@i18N key='sys.setting.Ban' />
		        </td>
		        <td>
		          <div class="layui-input-inline">
		             <input type="text" name="wrap" lay-verify="required|number" value="${settingPrice.wrap}"  autocomplete="off"  class="layui-input">
		          </div>
		          <@i18N key='sys.setting.Yuan' />/<@i18N key='sys.setting.Bao' />
		        </td>
		        <td>
		           <div class="layui-input-inline">
		             <input type="text" name="box" lay-verify="required|number" value='${settingPrice.box}'   autocomplete="off"  class="layui-input">
		           </div>
		           <@i18N key='sys.setting.Yuan' />/<@i18N key='sys.setting.Xiang' />
		        </td>
		      </tr>
		      </#if>
		      </#list>
		    </tbody>
		  </table>
		  
		  <table class="layui-table" style="width:80%;margin-top: 30px">
		    <colgroup>
		      <col width="100">
		      <col width="200">
		      <col width="200">
		      <col width="200">
		    </colgroup>
		    <tbody>
		      <#list settingPrices as settingPrice>
		      <#if settingPrice.unitType == 2>
		      <tr>
		        <td>
		            <#if settingPrice.type == 1>8mm</#if>
		            <#if settingPrice.type == 2>15mm</#if>
		            <#if settingPrice.type == 3>30mm</#if>
		            <#if settingPrice.type == 4>45mm</#if>
		            <#if settingPrice.type == 5>60mm<@i18N key='sys.setting.ZhengTieHeFanTie' /></#if>
		        </td>
		        <td>
		          <div class="layui-input-inline">
		             <input type="hidden" name="id"   value='${settingPrice.id}'  autocomplete="off"  class="layui-input">
		             <input type="hidden" name="type"   value='${settingPrice.type}'  autocomplete="off"  class="layui-input">
		             <input type="hidden" name="unitType"   value='${settingPrice.unitType}'  autocomplete="off"  class="layui-input">
		             <input type="text" name="edition" lay-verify="required|number"  value='${settingPrice.edition}'  autocomplete="off"  class="layui-input">
		          </div>
		          <@i18N key='sys.setting.Mei' />/<@i18N key='sys.setting.Ban' />
		        </td>
		        <td>
		          <div class="layui-input-inline">
		             <input type="text" name="wrap" lay-verify="required|number" value="${settingPrice.wrap}"  autocomplete="off"  class="layui-input">
		          </div>
		          <@i18N key='sys.setting.Mei' />/<@i18N key='sys.setting.Bao' />
		        </td>
		        <td>
		           <div class="layui-input-inline">
		             <input type="text" name="box" lay-verify="required|number" value='${settingPrice.box}'   autocomplete="off"  class="layui-input">
		           </div>
		           <@i18N key='sys.setting.Mei' />/<@i18N key='sys.setting.Xiang' />
		        </td>
		      </tr>
		      </#if>
		      </#list>
		    </tbody>
		  </table>
		
		<div class="layui-form-item">
           <div class="layui-input-block">
              <button class="layui-btn" lay-submit="" lay-filter="modify"><@i18N key='logo.bc' /></button>
           </div>
        </div>
</form>
<script>
    layui.use(['form','jquery','layer','upload'],function(){
       var form = layui.form,
           $    = layui.jquery,
           layer = layui.layer,
           upload = layui.upload;
         //指定允许上传的文件类型
		  upload.render({
		    elem: '#upload'
		    ,url: '${serverPath}/mgn/sys/upload/'
		    ,done: function(res){
		      if(res.code == 200){
                   layer.msg("<@i18N key='ShangChuanChengGong' />!",{time:200},function(){
                       $("#LAY_upload").attr('src',res.result.attachment);
                       $("#MSG_SIGN_REMIND_V").val(res.result.attachment);
                   });
               }else{
                   layer.msg(res.message);
               }
		    }
		  });
		//表单数据提交
        form.on("submit(modify)",function(data){
            var loadIndex = layer.load(2, {
                shade: [0.3, '#333']
            });
            //富文本框取值需要注意前面需要在方法体内进行赋值
            //data.field.taskDesc = layedit.getContent(taskDescIndex);
            $.post("${serverPath}/mgn/sys/editSetting",$("#form").serialize(),function(res){
               layer.close(loadIndex);
               if(res.result){
                   layer.msg("<@i18N key='czcg' />!",{time:1000},function(){
                       //刷新父页面
                       location.reload();
                   });
               }else{
                   layer.msg(res.message);
               }
            });
            return false;
        });
		
    }); 
</script>

</@override>
<@extends name="//common/admin/iframe_templates.ftl"/>