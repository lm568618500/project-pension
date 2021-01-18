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
        <div class="title">关于我们</div>
        <p>ABOUT US</p>
      </div>
      <div class="page-nav-box">
        <div class="intruction-caption" onclick="itemToggle(this)" data-status="0">企业文化</div>
        <div class="nav">

          <a class href="${serverPath}/jw/aboutUs/companyProfile">公司概况</a>

          <a class href="${serverPath}/jw/aboutUs/video">视频中心</a>

          <a classhref="${serverPath}/jw/aboutUs/culture">企业文化</a>

          <a class href="${serverPath}/jw/aboutUs/course">发展历程</a>

          <a class href="${serverPath}/jw/aboutUs/responsibility">社会责任</a>

          <a class="on"  href="${serverPath}/jw/aboutUs/honor">企业荣誉</a>

        </div>
      </div>
      <div class="breadcrumb">
        <a href="/" class="home"><img src="${PubStaticServer}/static/jw/images/home.png" alt></a>
        <img src="${PubStaticServer}/static/jw/images/icon.png" alt class="icon">
        <a href="/about/">关于我们</a>
        <img src="${PubStaticServer}/static/jw/images/icon.png" alt class="icon">
        <span>企业荣誉</span>
      </div>
    </div>
  </div>
  <!-- 二级栏目 end -->

  <!-- 企业荣誉 start -->
  <div class="box-container-fluid page-box honor-wrapper">
    <div class="container">
      <div class="mini-container">
        <div class="page-title-box wow fadeInUp50">
          <div class="title">企业荣誉</div>
          <p>ENTERPRISE HONOR</p>
        </div>
        <div class="box">
          <div class="list">
            <ul id="DivList">

              <li onclick="picModalBox(this)">
                <div class="pic"><img src="${PubStaticServer}/static/jw/images/20200724011719149.png" alt="揭榜挂帅国家工业和信息化部发布中国新一代人工智能产业创新重点任务企业榜单（盈峰中联）"></div>
                <div class="name">揭榜挂帅国家工业和信息化部发布中国新一代人工智能产业创新重点任务企业榜单（盈峰中联）</div>
              </li>

              <li onclick="picModalBox(this)">
                <div class="pic"><img src="${PubStaticServer}/static/jw/images/20200724005518240.jpeg" alt="湖南省十大知识产权领军企业（盈峰中联）"></div>
                <div class="name">湖南省十大知识产权领军企业（盈峰中联）</div>
              </li>

              <li onclick="picModalBox(this)">
                <div class="pic"><img src="${PubStaticServer}/static/jw/images/20200724005321422.jpeg" alt="中国专利优秀奖"></div>
                <div class="name">中国专利优秀奖</div>
              </li>

              <li onclick="picModalBox(this)">
                <div class="pic"><img src="${PubStaticServer}/static/jw/images/20200724005232742.jpeg" alt="中国清洁清洗行业等级资质 国家一级（盈峰中联）"></div>
                <div class="name">中国清洁清洗行业等级资质 国家一级（盈峰中联）</div>
              </li>

              <li onclick="picModalBox(this)">
                <div class="pic"><img src="${PubStaticServer}/static/jw/images/20200724005147137.jpeg" alt="高新技术企业（盈峰科技）"></div>
                <div class="name">高新技术企业（盈峰科技）</div>
              </li>

              <li onclick="picModalBox(this)">
                <div class="pic"><img src="${PubStaticServer}/static/jw/images/20200724004618891.jpeg" alt="2019年中国环境企业50强"></div>
                <div class="name">2019年中国环境企业50强</div>
              </li>

              <li onclick="picModalBox(this)">
                <div class="pic"><img src="${PubStaticServer}/static/jw/images/20200724005730224.jpeg" alt="橘子洲项目获2018年设备与技术解决方案示范案例"></div>
                <div class="name">橘子洲项目获2018年设备与技术解决方案示范案例</div>
              </li>

              <li onclick="picModalBox(this)">
                <div class="pic"><img src="${PubStaticServer}/static/jw/images/20200724005857549.jpeg" alt="2018年中国专用汽车领军企业（盈峰中联）"></div>
                <div class="name">2018年中国专用汽车领军企业（盈峰中联）</div>
              </li>

              <li onclick="picModalBox(this)">
                <div class="pic"><img src="${PubStaticServer}/static/jw/images/20200724004811569.jpeg" alt="2018年度固废最具社会责任投资运营企业"></div>
                <div class="name">2018年度固废最具社会责任投资运营企业</div>
              </li>

            </ul>
            <a href="javascript:getData();" id="btnJZL" class="page-more wow fadeInUp50"><i></i>加载更多</a>
          </div>

          <div class="other">

            <div class="inner-1" style="background: url(${PubStaticServer}/static/jw/images/20200711143941169.jpeg) no-repeat;">
              <div class="title wow fadeInUp50">让世界更清洁  让未来更美好</div>
              <div class="en wow fadeInUp50">INFORE ENVIRO</div>
              <ul>

                <li>
                  <div class="num"><span>10</span></div>
                  <div class="name">个研发平台</div>
                </li>

                <li>
                  <div class="num"><span>40</span><em>+</em></div>
                  <div class="name">个实验室</div>
                </li>

                <li>
                  <div class="num"><span>1000</span><em>+</em></div>
                  <div class="name">项资质专利</div>
                </li>

              </ul>
            </div>

            <div class="inner-2">
              <div class="content wow fadeInUp50">
                中国新一代人工智能产业创新重点任务企业<br>
                建设部给排水重点实验室联合研发中心<br>
                国家鼓励发展的重大环保技术装备依托单位<br>
                环保优秀品牌企业<br>
                城乡环卫优秀设备奖<br>
                中国清洁行业百强品牌<br>
                中国环卫行业影响力企业<br>
                中国垃圾焚烧发电杰出贡献企业<br>
                中国城市环境卫生协会特别贡献金奖<br>
                第九届中国清洁行业推优特别贡献奖<br>
                工程设计甲级资质<br>
                环保专业承包一级<br>
                环保、机电、智能化一级<br>
                建筑机电安装专业承包一级<br>
                市政公用工程施工总承包一级<br>
                中国清洁清洗行业国家一级资质<br>
                ...

              </div>
            </div>
          </div>

        </div>

      </div>

    </div>
  </div>
  <!-- 企业荣誉 end -->
  <@extends name="//common/end_menu.ftl"/>
  <div class="box-container-fluid pic-modal-box">
    <div class="box">
      <div class="w1200">
        <div class="top">
          <a href="javascript:;" class="close" onclick="picModalBox()">&times;</a>
          <div class="name"></div>
        </div>
        <div class="pic-box"><img src alt></div>
      </div>
    </div>
  </div>

  <script>
    (function(){
      var bp = document.createElement('script');
      var curProtocol = window.location.protocol.split(':')[0];
      if (curProtocol === 'https') {
        bp.src = 'https://zz.bdstatic.com/linksubmit/push.js';
      }
      else {
        bp.src = 'http://push.zhanzhang.baidu.com/push.js';
      }
      var s = document.getElementsByTagName("script")[0];
      s.parentNode.insertBefore(bp, s);
    })();
  </script>

  <div class="bdsharebuttonbox" style="display: none;">
    <a href="#" class="bds_copy" data-cmd="copy" id="copy" title="分享到复制网址"></a>
    <a href="#" class="bds_mail" data-cmd="mail" id="mail" title="分享到邮箱"></a>
    <a href="#" class="bds_tsina" data-cmd="tsina" id="tsina" title="分享到新浪微博"></a>
    <a href="#" class="bds_bdhome" data-cmd="bdhome" id="bdhome" title="分享到百度"></a>
    <a href="#" class="bds_douban" data-cmd="douban" id="douban" title="分享到豆瓣"></a>
    <a href="#" class="bds_weixin" data-cmd="weixin" id="weixin" title="分享到微信"></a>
    <a href="#" class="bds_sqq" data-cmd="sqq" id="sqq" title="分享到QQ好友"></a>
    <a href="#" class="bds_more" data-cmd="more" id="more" title="更多"></a>
    <a href="#" class="bds_tqq" data-cmd="tqq" id="tqq" title="分享到腾讯微博"></a>
    <a href="#" class="bds_qzone" data-cmd="qzone" id="qzone" title="分享到QQ空间"></a>
    <a href="#" class="bds_linkedin" data-cmd="linkedin" id="linkedin" title="分享到linkedin"></a>
    <a href="#" class="bds_print" data-cmd="print" id="print1" title="分享到打印"></a>
    <a href="#" class="bds_renren" data-cmd="renren" id="renren" title="分享到人人网"></a>
    <a href="#" class="bds_tsohu" data-cmd="tsohu" id="tsohu" title="分享到搜狐微博"></a>
    <a href="#" class="bds_kaixin001" data-cmd="kaixin001" id="kaixin001" title="分享到开心网"></a>
    <a href="#" class="bds_fx" data-cmd="fx" id="fx" title="分享到飞信"></a>
    <a href="#" class="bds_mshare" data-cmd="mshare" id="mshare" title="一键分享"></a>
    <a href="#" class="bds_neteasemb" data-cmd="neteasemb" id="neteasemb" title="分享到网易微博"></a>
    <a href="#" class="bds_fbook" data-cmd="fbook" id="fbook" title="分享到脸书"></a>
    <a href="#" class="bds_twi" data-cmd="twi" id="twi" title="分享到twi"></a>
    <a href="#" class="bds_google" data-cmd="google" id="google" title="分享到谷歌"></a>
  </div>


  <script>
    window._bd_share_config = { "common": { "bdSnsKey": {}, "bdText": "", "bdMini": "2", "bdMiniList": false, "bdPic": "", "bdStyle": "0", "bdSize": "16" }, "share": {} }; with (document) 0[(getElementsByTagName('head')[0] || body).appendChild(createElement('script')).src = 'http://bdimg.share.baidu.com/static/api/js/share.js?v=89860593.js?cdnversion=' + ~(-new Date() / 36e5)];
  </script>
  <script type="text/javascript">
    function tsina() { document.getElementById("tsina").click(); }
    function weixin() { document.getElementById("weixin").click(); }
    function sqq() { document.getElementById("sqq").click(); }
    function douban() { document.getElementById("douban").click(); }
    function tqq() { document.getElementById("tqq").click(); }
    function qzone() { document.getElementById("qzone").click(); }
    function bdhome() { document.getElementById("bdhome").click(); }
    function mshare() { document.getElementById("mshare").click(); }
    function more() { document.getElementById("more").click(); }
    function print1() { document.getElementById("print1").click(); }
    function renren() { document.getElementById("renren").click(); }
    function neteasemb() { document.getElementById("neteasemb").click(); }
    function copy() { document.getElementById("copy").click(); }
    function mail() { document.getElementById("mail").click(); }
    function tsohu() { document.getElementById("tsohu").click(); }
    function kaixin001() { document.getElementById("kaixin001").click(); }
    function fx() { document.getElementById("fx").click(); }
    function fbook() { document.getElementById("fbook").click(); }
    function twi() { document.getElementById("twi").click(); }
    function google() { document.getElementById("google").click(); }
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
  <script>
    function getData() {
      $("#btnJZL").hide();
      var size = $('#DivList').children('li').length;
      $.ajax({
        url: "/AjaxAction/ajaxload.ashx?action=honor&c=002006001&m=126&Size=" + size,
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
  <script>
    for (var i = 0; i < $(".list ul li").length; i++) {
      $(".list ul li").eq(i).addClass("wow fadeInUp50").attr("data-wow-delay", i * 200 + "ms")
    }
    for (var i = 0; i < $(".inner-1 ul li").length; i++) {
      $(".inner-1 ul li").eq(i).addClass("wow fadeInUp50").attr("data-wow-delay", i * 200 + "ms")
    }
    function picModalBox(obj) {
      if (obj) {
        var src = $(obj).find("img").attr("src")
        $(".pic-modal-box .name").text($(obj).find(".name").text())
        $(".pic-modal-box img").attr("src", src)
        $(".mask").show()
        $(".pic-modal-box").fadeIn(300)
      } else {
        $(".pic-modal-box").fadeOut(300)
        setTimeout(function () {
          $(".mask").fadeOut(600)
        }, 500)
      }
    }
  </script>
</@override>
<@extends name="//common/iframe_templates.ftl"/>