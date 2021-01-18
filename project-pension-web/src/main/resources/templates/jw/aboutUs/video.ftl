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
        <div class="intruction-caption" onclick="itemToggle(this)" data-status="0">视频中心</div>
        <div class="nav">

          <a class href="${serverPath}/jw/aboutUs/companyProfile">公司概况</a>

          <a class="on" href="${serverPath}/jw/aboutUs/video">视频中心</a>

          <a class href="${serverPath}/jw/aboutUs/culture">企业文化</a>

          <a class href="${serverPath}/jw/aboutUs/course">发展历程</a>

          <a class href="${serverPath}/jw/aboutUs/responsibility">社会责任</a>

          <a class href="${serverPath}/jw/aboutUs/honor">企业荣誉</a>

        </div>
      </div>
      <div class="breadcrumb">
        <a href="/" class="home"><img src="images/home.png" alt></a>
        <img src="${PubStaticServer}/static/jw/images/icon.png" alt class="icon">
        <a href="/about/">关于我们</a>
        <img src="${PubStaticServer}/static/jw/images/icon.png" alt class="icon">
        <span>视频中心</span>
      </div>
    </div>
  </div>
  <!-- 二级栏目 end -->


  <!-- 视频中心 start -->
  <div class="box-container-fluid page-box video-wrapper">
    <div class="container">
      <div class="mini-container">
        <div class="page-title-box wow fadeInUp50">
          <div class="title">视频中心</div>
          <p>VIDEO CENTER</p>
        </div>

        <div class="first-box">
          <!-- 封面图 -->
          <div class="pic">
            <img src="${PubStaticServer}/static/jw/images/20200729065144273.jpeg" alt="盈峰环境科技集团专题片">
            <div class="info" onclick="videoPlay()">
              <img src="${PubStaticServer}/static/jw/images/play.png" alt class="icon">
              <div class="name">盈峰环境科技集团专题片</div>
            </div>
          </div>
          <!-- 视频 -->

          <div class="video">
            <video src controls video-src="http://www.inforeenviro.com/vancheerfile/files/2020/7/20200730180144774.mp4"></video>
          </div>

        </div>


        <!-- 视频分类 -->
        <div class="cat-box wow fadeInUp50">
          <div class="inner">

            <a href="javascript:;" onclick="tabBoxToggle(this)">产品视频</a>

            <a href="javascript:;" onclick="tabBoxToggle(this)">项目视频</a>

          </div>
        </div>
        <div class="list">

          <div class="box">
            <ul id="DivList13">

              <li video-src="http://www.inforeenviro.com/vancheerfile/files/2020/8/2020080216186217.mp4" onclick="videoModalBox(this)">
                <a href="javascript:;">
                  <!-- 封面图 -->
                  <div class="pic"><img src="${PubStaticServer}/static/jw/images/20200802161739786.jpeg" alt="新能源产品"></div>
                  <div class="name">新能源产品</div>
                </a>
              </li>

              <li video-src="http://www.inforeenviro.com/vancheerfile/files/2020/8/20200802160032213.mp4" onclick="videoModalBox(this)">
                <a href="javascript:;">
                  <!-- 封面图 -->
                  <div class="pic"><img src="${PubStaticServer}/static/jw/images/2020080216003414.jpeg" alt="次道洗扫车(ZBH5040TXSSHE6)"></div>
                  <div class="name">次道洗扫车(ZBH5040TXSSHE6)</div>
                </a>
              </li>

              <li video-src="http://www.inforeenviro.com/vancheerfile/files/2020/8/2020080215570870.mp4" onclick="videoModalBox(this)">
                <a href="javascript:;">
                  <!-- 封面图 -->
                  <div class="pic"><img src="${PubStaticServer}/static/jw/images/20200802155529755.jpeg" alt="落叶洗扫车(ZBH5180TXSDFE6)"></div>
                  <div class="name">落叶洗扫车(ZBH5180TXSDFE6)</div>
                </a>
              </li>

              <li video-src="http://www.inforeenviro.com/vancheerfile/files/2020/8/20200802155048188.mp4" onclick="videoModalBox(this)">
                <a href="javascript:;">
                  <!-- 封面图 -->
                  <div class="pic"><img src="${PubStaticServer}/static/jw/images/20200802155021300.jpeg" alt="绿篱修剪综合养护车(ZBH5081TYHJXE6)"></div>
                  <div class="name">绿篱修剪综合养护车(ZBH5081TYHJXE6)</div>
                </a>
              </li>

              <li video-src="http://www.inforeenviro.com/vancheerfile/files/2020/8/20200802153738756.mp4" onclick="videoModalBox(this)">
                <a href="javascript:;">
                  <!-- 封面图 -->
                  <div class="pic"><img src="${PubStaticServer}/static/jw/images/20200802154022251.jpeg" alt="隔音屏隧道立面清洗车(ZBH5181TXQDFE6)"></div>
                  <div class="name">隔音屏隧道立面清洗车(ZBH5181TXQDFE6)</div>
                </a>
              </li>

              <li video-src="http://www.inforeenviro.com/vancheerfile/files/2020/8/20200801141221784.mp4" onclick="videoModalBox(this)">
                <a href="javascript:;">
                  <!-- 封面图 -->
                  <div class="pic"><img src="${PubStaticServer}/static/jw/images/2020080114068055.jpeg" alt="城市公园解决方案"></div>
                  <div class="name">城市公园解决方案</div>
                </a>
              </li>

            </ul>
            <div class="clearfix"></div>

          </div>

          <div class="box">
            <ul id="DivList12">

              <li video-src="http://www.inforeenviro.com/vancheerfile/files/2020/7/20200731191740825.mp4" onclick="videoModalBox(this)">
                <a href="javascript:;">
                  <!-- 封面图 -->
                  <div class="pic"><img src="${PubStaticServer}/static/jw/images/20200731191518253.jpeg" alt="5G远程集群操控环卫机器人"></div>
                  <div class="name">5G远程集群操控环卫机器人</div>
                </a>
              </li>

              <li video-src="http://www.inforeenviro.com/vancheerfile/files/2020/7/20200730194024419.mp4" onclick="videoModalBox(this)">
                <a href="javascript:;">
                  <!-- 封面图 -->
                  <div class="pic"><img src="${PubStaticServer}/static/jw/images/20200730112255726.jpeg" alt="橘子洲智能洁净景区服务项目"></div>
                  <div class="name">橘子洲智能洁净景区服务项目</div>
                </a>
              </li>

              <li video-src="http://www.inforeenviro.com/vancheerfile/files/2020/7/20200730180144774.mp4" onclick="videoModalBox(this)">
                <a href="javascript:;">
                  <!-- 封面图 -->
                  <div class="pic"><img src="${PubStaticServer}/static/jw/images/20200729065144273.jpeg" alt="盈峰环境科技集团专题片"></div>
                  <div class="name">盈峰环境科技集团专题片</div>
                </a>
              </li>

            </ul>
            <div class="clearfix"></div>

          </div>

        </div>
      </div>

    </div>
  </div>
  <!-- 视频中心 end -->
  <!-- video 弹窗 start -->
  <div class="box-container-fluid video-modal-box">
    <div class="box">
      <div class="w1200">
        <div class="top">
          <a href="javascript:;" class="close" onclick="videoModalBox()">&times;</a>
          <div class="name"></div>
        </div>
        <div class="video-box"><video src controls></video></div>
      </div>
    </div>
  </div>
  <!-- video 弹窗 end -->

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

  <script>
    function getData(dt) {
      $("#btnJZL" + dt).hide();
      var size = $('#DivList' + dt).children('li').length;
      $.ajax({
        url: "/AjaxAction/ajaxload.ashx?action=video&c=002002001&m=126&Size=" + size + "&dt=" + dt,
        type: "get",
        data: "",
        dataType: "json",
        success: function (data) {
          $("#btnJZL" + dt).show();
          if (data.code == "0") {
            if (data.c == 0) {
              $("#btnJZL" + dt).hide();
            }
            $('#DivList' + dt).append(data.datastr)
          } else if (data.code == "1") {
            $("#btnJZL" + dt).hide();
          } else {
            $('#btnJZL' + dt).text("数据加载失败！");
          }
        },
        error: function (xhr, type) {
          Salert("", "数据操作异常！");
        }
      });
    }
  </script>
  <script>
    $(".list ul li").addClass("wow fadeInUp50")
    $(".list .box").eq(0).show()
    $(".cat-box a").eq(0).addClass("on")
    function videoPlay() {
      $(".first-box").addClass("on")
      $(".first-box video").attr("src", $(".first-box video").attr("video-src"))
      $(".first-box video").trigger("play");//播放
    }
    if (wid > 1024) {
      $(".cat-box a").hover(function () {
        $(this).addClass("on").siblings().removeClass("on")
        $(".list .box").eq($(this).index()).fadeIn(600).siblings().hide()
      })
    }

    function tabBoxToggle(obj) {
      $(obj).addClass("on").siblings().removeClass("on")
      $(".list .box").eq($(obj).index()).fadeIn(600).siblings().hide()
    }

    function videoModalBox(obj) {
      if (obj) {
        var src = $(obj).attr("video-src")
        $(".video-modal-box .name").text($(obj).find(".name").text())
        $(".video-modal-box video").attr("src", src)
        $(".mask").show()
        $(".video-modal-box").fadeIn(300)
        $(".video-modal-box video").trigger("play");//播放
      } else {
        $(".video-modal-box video").trigger("pause");//暂停
        $(".video-modal-box").fadeOut(300)
        setTimeout(function () {
          $(".mask").fadeOut(600)
        }, 500)
      }
    }
  </script>
</@override>
<@extends name="//common/iframe_templates.ftl"/>