<@override name="body">
  <div class="box-container-fluid header-wrapper">
  <@extends name="//common/top_menu.ftl"/>
  <!-- banner start -->
  <div class="page-banner-wrapepr">
    <img src="${PubStaticServer}/static/jw/images/20200730102037555.jpeg" alt class="banner">
  </div>

  <!-- 二级栏目 start -->
  <div class="box-container-fluid page-nav-wrapper">
    <div class="box">
      <div class="title-box">
        <div class="title">智能装备</div>
        <p>EQUIPMENT</p>
      </div>
      <div class="page-nav-box">
        <div class="intruction-caption" onclick="itemToggle(this)" data-status="0">环境监测</div>
        <div class="nav">

          <a class href="${serverPath}/jw/intelligentEquipment/sanitation">环卫装备</a>

          <a class  href="${serverPath}/jw/intelligentEquipment/robot">环卫机器人</a>

          <a class href="${serverPath}/jw/intelligentEquipment/science">环境装备</a>

          <a class="on"  href="${serverPath}/jw/intelligentEquipment/testing">环境监测</a>

        </div>
      </div>
      <div class="breadcrumb">
        <a href="/" class="home"><img src="${PubStaticServer}/static/jw/images/home.png" alt></a>
        <img src="${PubStaticServer}/static/jw/images/icon.png" alt class="icon">
        <a href="/about/">智能装备</a>
        <img src="${PubStaticServer}/static/jw/images/icon.png" alt class="icon">
        <span>环境监测</span>
      </div>
    </div>
  </div>
  <!-- 二级栏目 end -->
  <!-- 项目展示 start -->
  <div class="box-container-fluid page-box equipment-wrapper">
    <div class="container">
      <div class="mini-container">
        <div class="page-title-box wow fadeInUp50">
          <div class="title">环境监测</div>
          <p>ENVIRONMENTAL MONITORING</p>
        </div>
        <div class="page-category-box wow fadeInUp50">
          <div class="inner">

            <a class="on" href="/equipment/emproducts.html">主要产品</a>

            <a class href="/equipment/emsolution.html">解决方案</a>

            <a class href="/equipment/emproject.html">项目展示</a>

          </div>
        </div>
        <div class="page-cat-box wow fadeInUp50">
          <ul id="seriesConditionType">
            <li>
              <span class="cat">产品分类：</span>
              <a href="javascript:;" data-da="0" class="on" onclick="gettypeData(0,1,this)">全部</a>

              <a href="javascript:;" onclick="gettypeData(91,1,this)" data-da="91">污染源在线监测系列</a>

              <a href="javascript:;" onclick="gettypeData(23,1,this)" data-da="23">水质在线监测系列</a>

              <a href="javascript:;" onclick="gettypeData(24,1,this)" data-da="24">气体在线监测系列</a>

              <a href="javascript:;" onclick="gettypeData(25,1,this)" data-da="25">水利在线监测系列</a>

            </li>
          </ul>
        </div>
        <div class="list">

          <ul id="DivList">

            <li>
              <a href="/equipment/emproducts18.html">
                <div class="pic"><img src="${PubStaticServer}/static/jw/images/20200722063859097.png" alt="YF-WQMS-||小型水质自动监测系统"></div>
                <div class="info">
                  <div class="name">YF-WQMS-||小型水质自动监测系统</div>
                  <div class="desc">YF-WQMS-||小型水质自动监测系统是一款由监测因子、冷暖空调、质量控制模块、试剂冰箱、简易废液收集和处理模块组成的一体式机柜水站，机柜分为前后及侧边三开门设计，以户外机柜作为监测站房，满足国家水站建设的所有功能。</div>
                  <div class="a-more"></div>
                </div>
              </a>
            </li>

            <li>
              <a href="/equipment/emproducts21.html">
                <div class="pic"><img src="${PubStaticServer}/static/jw/images/20200722064225926.png" alt="YF系列水质在线自动监测仪"></div>
                <div class="info">
                  <div class="name">YF系列水质在线自动监测仪</div>
                  <div class="desc">YF系列水质在线自动监测仪是基于分光光度法，符合中华人民共和国国家标准的规定。仪表整体结构设计合理、运行稳定可靠、维护简便。监测的水质指标包括CODcr、氨氮、CODMn、总磷、总氮、硝氮、酚类、氰化物、氟化物、氯化物和重金属等监测因子。</div>
                  <div class="a-more"></div>
                </div>
              </a>
            </li>

            <li>
              <a href="/equipment/emproducts20.html">
                <div class="pic"><img src="${PubStaticServer}/static/jw/images/20200722063331455.png" alt="YF系列壁挂式水质在线自动监测仪"></div>
                <div class="info">
                  <div class="name">YF系列壁挂式水质在线自动监测仪</div>
                  <div class="desc">YF系列壁挂式水质在线自动监测仪是盈峰科技全新开发、具有完全自主知识产权的水质在线监测仪器。该系列产品基于比色法原理，采用模块化设计，可按需求进行参数切换，操作简单。监测的水质指标包括CODCr、氨氮、CODMn、总磷、总氮和重金属等28项监测因子。</div>
                  <div class="a-more"></div>
                </div>
              </a>
            </li>

            <li>
              <a href="/equipment/emproducts22.html">
                <div class="pic"><img src="${PubStaticServer}/static/jw/images/20200722064418191.png" alt="YF-TOX生物毒性在线自动监测仪"></div>
                <div class="info">
                  <div class="name">YF-TOX生物毒性在线自动监测仪</div>
                  <div class="desc">YF-TOX生物毒性在线自动监测仪是一款可联机的水质综合毒性连续监测仪，利用自然非致病性发光细菌（费氏弧菌）作为活性传感器，毒谱范围涵盖5000多种毒性物质，可安装在不同饮用水源监控点，实现毒性监测的有效覆盖，精确定位污染范围并跟踪污染源。可实现与其他监控仪、传感器等无缝集成，适用于水源地（如水库、河流、湖泊等）、供水公司、环境与健康监管和监控机构、医院、军事基地等领域。能有效预警化学污染事件，并向有关监管部门和相关机构实时警报，减少因毒物泄露带来的人身安全事故和财产损失，有效预警安全破坏和恐怖袭击等事件。</div>
                  <div class="a-more"></div>
                </div>
              </a>
            </li>

            <li>
              <a href="/equipment/emproducts23.html">
                <div class="pic"><img src="${PubStaticServer}/static/jw/images/20200722070042428.png" alt="YF-CYQ系列水质采样器"></div>
                <div class="info">
                  <div class="name">YF-CYQ系列水质采样器</div>
                  <div class="desc">YX-CYQ系列水质采样器是一款功能完备的智能型采样器，内置独特的水样暂存装置，实现排污口污水的连续混合采集，提供无间断的混合水样，与在线监测仪联机使用，实现排放口污水混合样的监测功能。</div>
                  <div class="a-more"></div>
                </div>
              </a>
            </li>

            <li>
              <a href="/equipment/emproducts24.html">
                <div class="pic"><img src="${PubStaticServer}/static/jw/images/2020072207051137.png" alt="YF-TPMS刷卡排污总量控制系统"></div>
                <div class="info">
                  <div class="name">YF-TPMS刷卡排污总量控制系统</div>
                  <div class="desc">YF-TPMS刷卡排污总量控制系统是针对有效控制污染物排放总量而设计，系统是采用先进自动控制技术、智能IC卡技术、无线通讯技术、远程反控技术、数据库技术，结合在线监测数据而研发的一套智能IC卡控制排污总量监控系统。排污企业通过预充值方式，将企业所获排污配额量录入IC卡内，企业需排污时，只有通过刷卡才能排放，当剩余配额量不足时，系统报警提示充值；配额量用完时，系统通过智能阀门关闭企业排污口。同时企业可根据自身排污情况进行排污配额量交易。该系统为有效监督企业排污行为提供强有力的科学依据，使排污总量控制真正进入刷卡实时计量、减排效果可见的轨道。</div>
                  <div class="a-more"></div>
                </div>
              </a>
            </li>

            <li>
              <a href="/equipment/emproducts26.html">
                <div class="pic"><img src="${PubStaticServer}/static/jw/images/2020072207096541.png" alt="YF-CNP多参数水质在线自动监测仪"></div>
                <div class="info">
                  <div class="name">YF-CNP多参数水质在线自动监测仪</div>
                  <div class="desc">YF-CNP多参数水质在线自动监测仪是以pH、温度、浊度、溶解氧和电导率等电极为核心而组成的综合性在线自动监测系统，实现对江河、湖泊、水源地、水库、污水处理厂排放口、地下水、近海水域、自来水管网、工业废水、市政污水等水质的实时连续在线监测和远程监控。</div>
                  <div class="a-more"></div>
                </div>
              </a>
            </li>

            <li>
              <a href="/equipment/emproducts27.html">
                <div class="pic"><img src="${PubStaticServer}/static/jw/images/20200722071032845.png" alt="YF-JLWZ数据采集仪"></div>
                <div class="info">
                  <div class="name">YF-JLWZ数据采集仪</div>
                  <div class="desc">YF-JLWZ数据采集仪采用工业级ARM芯片，400M主频，运行高速、稳定可靠，自带512MB NAND Flash，128M内存；通过RS232、RS485、4~20mA电流、0~5V电压信号，对污染源参数进行采集、存储；内置 DI/DO 接口，可以对污染物治理设备的运行状态进行监控（过程监控）；通过以太网、DTU与远程监控服务器通讯，并符合HJ/T212-2017数据传输标准；同时也支持Modbus TCP 远程读取污染物的参数。</div>
                  <div class="a-more"></div>
                </div>
              </a>
            </li>

            <li>
              <a href="/equipment/emproducts25.html">
                <div class="pic"><img src="${PubStaticServer}/static/jw/images/20200722070759689.png" alt="YF-AMWQMS移动式应急监测系统"></div>
                <div class="info">
                  <div class="name">YF-AMWQMS移动式应急监测系统</div>
                  <div class="desc">YF-AMWQMS移动式应急监测系统包括监测设备、采水系统、预处理系统、供电系统、传输系统、车辆主体等，可对湖泊、水库、江河、自来水饮用水源水质在线监测，实现水质监测参数数据在线采集、传输、分析、仿真模拟和专家决策等。</div>
                  <div class="a-more"></div>
                </div>
              </a>
            </li>

          </ul>

          <a href="javascript:getData();" id="btnJZL" class="page-more wow fadeInUp50"><i></i>加载更多</a>

        </div>
      </div>
    </div>
  </div>
  <!-- 项目展示 end -->
  <@extends name="//common/end_menu.ftl"/>

  <script>
    function getUrlParam(name) {
      var reg = new RegExp("(^|&)" + name + "=([^&]*)(&|$)");
      var r = window.location.search.substr(1).match(reg);
      if (r != null) return decodeURI(r[2]); return "";
    }
    $(function () {
      var bl = 0;
      if (getUrlParam('cs1') != "" && typeof (getUrlParam('cs1')) != "undefined") {
        var cs1_A = $("#seriesConditionType").find("li").eq(0).find("a");
        for (var i = 0; i < cs1_A.length; i++) {
          cs1_A.eq(i).removeClass("on");
          if (cs1_A.eq(i).attr("data-da") == getUrlParam('cs1')) {
            cs1_A.eq(i).addClass("on");
            bl = 1;
          }
        }
      }
      if (bl == 1) {
        gettypeData();
      }
    })
  </script>
  <script>
    function gettypeData(da, cs, obj) {
      $(obj).toggleClass("on").siblings().removeClass("on")
      //var index = $(obj).index()
      //if (index == 1) {
      //    $(obj).toggleClass("on").siblings().removeClass("on")
      //} else {
      //    $(obj).parent("li").find("a").eq(0).removeClass("on")
      //    $(obj).toggleClass("on")
      //}
      //var total_len = $(obj).parent("li").find("a").length
      //var on_len = $(obj).parent("li").find("a.on").length
      //if (on_len == 0) {
      //    $(obj).parent("li").find("a").eq(0).addClass("on")
      //}

      var Product = "";
      if (cs == "1") {
        Product = da;
        //var cls2_A = $("#seriesConditionType").find("li").eq(0).find("a");
        //for (var i = 0; i < cls2_A.length; i++) {
        //    if (cls2_A.eq(i).hasClass('on')) {
        //        Product += cls2_A.eq(i).attr("data-da") + ",";
        //    }
        //}
        //Product = Product.substring(0, Product.length - 1);
      } else {
        Product = $("#seriesConditionType").find("li").eq(0).find(".on").attr("data-da");
      }

      $.ajax({
        url: "/AjaxAction/ajaxload.ashx?action=environmenttype&m=126" + "&c=003004001&cs1=" + Product,
        type: "get",
        data: "",
        dataType: "json",
        success: function (data) {
          $("#btnJZL").show();
          if (data.code == "0") {
            if (data.c == 0) {
              $("#btnJZL").hide();
            } else {
              $("#btnJZL").show();
            }
            $('#DivList').html(data.datastr)
          } else if (data.code == "1") {
            $("#btnJZL").hide();
            $('#DivList').html("");
          } else {
            Salert("", "查询失败！");
          }
        },
        error: function (xhr, type) {
          Salert("", "数据操作异常！");
        }
      });

    }
  </script>

  <script>
    function getData() {
      var Product = $("#seriesConditionType").find("li").eq(0).find(".on").attr("data-da");
      $("#btnJZL").hide();
      var size = $('#DivList').children('li').length;
      $.ajax({
        url: "/AjaxAction/ajaxload.ashx?action=environment&m=126" + "&size=" + size + "&c=003004001&cs=" + Product,
        type: "get",
        data: "",
        dataType: "json",
        success: function (data) {
          $("#btnJZL").show();
          if (data.code == "0") {
            if (data.c == 0) {
              $("#btnJZL").hide();
            }
            $('#DivList').append(data.datastr)
          } else if (data.code == "1") {
            $("#btnJZL").hide();
          } else {
            $('#btnJZL').text("数据加载失败！");
          }
        },
        error: function (xhr, type) {
          Salert("", "数据操作异常！");
        }
      });
    }
  </script>

  </body>
  </html>




  <script type="text/javascript" src="${PubStaticServer}/static/jw/js/jquery.waypoints.min.js"></script>
  <script type="text/javascript" src="${PubStaticServer}/static/jw/js/countUp.js"></script>
  <script type="text/javascript" src="${PubStaticServer}/static/jw/js/swiper-4.3.5.min.js"></script>
  <script type="text/javascript" src="${PubStaticServer}/static/jw/js/wow.min.js"></script>
  <script type="text/javascript" src="${PubStaticServer}/static/jw/js/smooth.js"></script>
  <script type="text/javascript" src="${PubStaticServer}/static/jw/js/common.js"></script>

  <link href="${PubStaticServer}/static/jw/css/Sdialog.css" rel="stylesheet">
  <script src="${PubStaticServer}/static/jw/js/message.js"></script>

</@override>
<@extends name="//common/iframe_templates.ftl"/>