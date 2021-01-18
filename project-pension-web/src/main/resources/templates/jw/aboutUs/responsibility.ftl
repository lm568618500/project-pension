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

          <a class href="${serverPath}/jw/aboutUs/culture">企业文化</a>

          <a class href="${serverPath}/jw/aboutUs/course">发展历程</a>

          <a class="on" href="${serverPath}/jw/aboutUs/responsibility">社会责任</a>

          <a class href="${serverPath}/jw/aboutUs/honor">企业荣誉</a>

        </div>
      </div>
      <div class="breadcrumb">
        <a href="/" class="home"><img src="images/home.png" alt></a>
        <img src="images/icon.png" alt class="icon">
        <a href="/about/">关于我们</a>
        <img src="images/icon.png" alt class="icon">
        <span>社会责任</span>
      </div>
    </div>
  </div>
  <!-- 二级栏目 end -->

  <!-- 社会责任 start -->
  <div class="box-container-fluid page-box social-wrapper">
    <div class="container">
      <div class="mini-container">
        <div class="page-title-box wow fadeInUp50">
          <div class="title">社会责任</div>
          <p>SOCIAL RESPONSIBILITY</p>
        </div>
        <div class="brief">
          支援湖北武汉，向环卫工人送温暖，除冰雪大行动，充分发挥企业社会责任<br>
          救灾赈灾，爱心助学，我们总是第一时间伸出援手，支持慈善事业，担当家国责任
        </div>
        <div class="list">
          <ul>

            <li>
              <div class="pic"><img src="${PubStaticServer}/static/jw/images/20200711142046469.jpeg" alt="盈峰环境向武汉市城管委捐赠15辆清洁消毒车"></div>
              <div class="info">
                <div class="name">盈峰环境向武汉市城管委捐赠15辆清洁消毒车</div>
                <div class="desc">
                  2020年初，新型冠状病毒肺炎疫情向全国蔓延，针对全国各地户外环境消毒作业面临的巨大压力，盈峰环境紧急调配人力、设备和物资，将15台清洁消毒车全部装备完毕，赠与武汉市城管委，用于当地医疗机构、市场商超、居民小区及汉口方舱医院周边等重点区域的紧急清洁消毒。
                </div>
              </div>
            </li>

            <li>
              <div class="pic"><img src="${PubStaticServer}/static/jw/images/20200711142021605.jpeg" alt="除雪抗冰"></div>
              <div class="info">
                <div class="name">除雪抗冰</div>
                <div class="desc">
                  1月25日凌晨，长沙市2018年第一场雪如约而至，道路结冰打滑给车辆和市民的出行带来了极大的不便。1月26日一早，盈峰环境向长沙市城市管理行政执法局主动请缨，派出5台除雪车亮相长沙街头。在长沙市城市管理行政执法局领导的指挥下，坚守五天五夜，顺利完成了开福区、岳麓区、高新区、橘子洲头景区等区域的除雪抗冰任务。危难之际见智勇，大灾大难现真情。
                </div>
              </div>
            </li>

            <li>
              <div class="pic"><img src="${PubStaticServer}/static/jw/images/2020071114201341.jpeg" alt="环卫工人节"></div>
              <div class="info">
                <div class="name">环卫工人节</div>
                <div class="desc">
                  10月26日是环卫工人节。今天上午，在盈峰环境麓谷第二工业园，盈峰环境隆重举办 2017中联环境首届“看得见的城市 看不见的我们——致敬城市美容师”活动，对盈峰环境二十余个县域城乡环境治理PPP项目优秀环卫工人代表进行表彰，并呼吁社会大众关爱环卫工人，爱护城市环境。
                </div>
              </div>
            </li>

            <li>
              <div class="pic"><img src="${PubStaticServer}/static/jw/images/20200711141920458.jpeg" alt="抗击宁乡洪灾"></div>
              <div class="info">
                <div class="name">抗击宁乡洪灾</div>
                <div class="desc">
                  2017年6月下旬，湖南遭重大洪灾，宁乡县成为湖南受灾最严重的区域之一，停水、停电、通讯中断，城中居民生活处于半停滞状态。盈峰环境紧急调配87台设备，组织救援分队，连夜奔赴宁乡，支持灾后重建。其中，包括清洗车、洗扫车、垃圾转运车等环卫机械设备。主要用于清理宁乡路面的淤泥物和生活垃圾，助力宁乡县环境的恢复工作。
                </div>
              </div>
            </li>

            <li>
              <div class="pic"><img src="${PubStaticServer}/static/jw/images/20200711141941551.jpeg" alt="抗击厦门风灾"></div>
              <div class="info">
                <div class="name">抗击厦门风灾</div>
                <div class="desc">
                  2016年9月15日，闽南地区遭遇1949年来最强登录台风肆虐，厦门成为重灾区，台风侵袭后，厦门满地狼           藉。盈峰环境主动请缨，紧急调配4辆全新清洗车、4台压缩式垃圾车和6名售后服务工程师，组织救援小分队，连夜奔赴厦门，支持灾后重建，紧急解决市民饮水问题，并助力厦门市容环境的灾后重建。
                </div>
              </div>
            </li>

          </ul>
        </div>
      </div>
    </div>
  </div>
  <!-- 社会责任 end -->
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