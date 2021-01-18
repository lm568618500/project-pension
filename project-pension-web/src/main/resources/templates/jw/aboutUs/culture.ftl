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

          <a class="on" href="${serverPath}/jw/aboutUs/culture">企业文化</a>

          <a class href="${serverPath}/jw/aboutUs/course">发展历程</a>

          <a class href="${serverPath}/jw/aboutUs/responsibility">社会责任</a>

          <a class href="${serverPath}/jw/aboutUs/honor">企业荣誉</a>

        </div>
      </div>
      <div class="breadcrumb">
        <a href="/" class="home"><img src="${PubStaticServer}/static/jw/images/home.png" alt></a>
        <img src="${PubStaticServer}/static/jw/images/icon.png" alt class="icon">
        <a href="/about/">关于我们</a>
        <img src="${PubStaticServer}/static/jw/images/icon.png" alt class="icon">
        <span>企业文化</span>
      </div>
    </div>
  </div>
  <!-- 二级栏目 end -->

  <!-- 企业文化 start -->
  <div class="box-container-fluid page-box culture-wrapper">
    <div class="container">
      <div class="mini-container">
        <div class="page-title-box wow fadeInUp50">
          <div class="title">企业文化</div>
          <p>ENTERPRISE CULTURE</p>
        </div>
        <div class="ad-box">
          <img src="${PubStaticServer}/static/jw/images/20200711112240214.jpeg" alt="让世界更清洁  让未来更美好">
          <div class="info wow fadeInUp50">
            <div class="name">让世界更清洁  让未来更美好</div>
            <div class="en">INFORE ENVIRO</div>
          </div>
        </div>

        <div class="list">
          <ul>

            <li>
              <div class="icon"><img src="${PubStaticServer}/static/jw/images/20200711112449197.png" alt="企业使命"></div>
              <div class="name">企业使命</div>
              <div class="desc">让世界更清洁  让未来更美好</div>
            </li>

            <li>
              <div class="icon"><img src="${PubStaticServer}/static/jw/images/20200711112432303.png" alt="企业愿景"></div>
              <div class="name">企业愿景</div>
              <div class="desc">致力于成为受人尊敬和信赖的<br>
                以环卫机器人为龙头的<br>
                智能环境装备及服务的行业引领者
              </div>
            </li>

            <li>
              <div class="icon"><img src="${PubStaticServer}/static/jw/images/2020071111246295.png" alt="核心价值观"></div>
              <div class="name">核心价值观</div>
              <div class="desc">客户是我们的衣食父母<br>
                员工是我们的事业合伙人<br>
                业绩导向，能者上、庸者下<br>
                科技创新是我们发展的根本
              </div>
            </li>

            <li>
              <div class="icon"><img src="${PubStaticServer}/static/jw/images/20200711112331352.png" alt="企业文化理念"></div>
              <div class="name">企业文化理念</div>
              <div class="desc">简单、专业、快执行</div>
            </li>

          </ul>
        </div>

      </div>
    </div>
  </div>
  <!-- 企业文化 end -->
  <@extends name="//common/end_menu.ftl"/>


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

</@override>
<@extends name="//common/iframe_templates.ftl"/>