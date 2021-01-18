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
        <div class="intruction-caption" onclick="itemToggle(this)" data-status="0">环卫机器人</div>
        <div class="nav">

          <a class href="${serverPath}/jw/intelligentEquipment/sanitation">环卫装备</a>

          <a class="on"  href="${serverPath}/jw/intelligentEquipment/robot">环卫机器人</a>

          <a class href="${serverPath}/jw/intelligentEquipment/science">环境装备</a>

          <a class href="${serverPath}/jw/intelligentEquipment/testing"">环境监测</a>

        </div>
      </div>
      <div class="breadcrumb">
        <a href="/" class="home"><img src="${PubStaticServer}/static/jw/images/home.png" alt></a>
        <img src="${PubStaticServer}/static/jw/images/icon.png" alt class="icon">
        <a href="/equipment/">智能装备</a>
        <img src="${PubStaticServer}/static/jw/images/icon.png" alt class="icon">
        <span>环卫机器人</span>
      </div>
    </div>
  </div>
  <!-- 二级栏目 end -->

  <!-- 环卫装备 start -->
  <div class="box-container-fluid page-box equipmentclass-wrapper">
    <div class="container">
      <div class="mini-container">
        <div class="page-title-box wow fadeInUp50">
          <div class="title">环卫机器人</div>
          <p>Sanitation robot</p>
        </div>
        <div class="list">
          <div class="box" id="DivList">

            <div class="item item-0">
              <a href="/equipment/5sanitationSeries.html?cs1=5" class="img"><img src="${PubStaticServer}/static/jw/images/20200927095122937.png" alt="环卫机器人"></a>
              <div class="info">
                <div class="caption">环卫机器人</div>
                <div class="en">ENVIRONMENTAL SANITATION ROBOT</div>
                <div class="desc">吸取国内外经验，全球首创智能纯电全线控一体式底盘，在环卫装备领域大力发展小型化、智能化、无人化环卫装备，现针对城市毛细血管清洁，推出智能小型环卫
                  机器人装备产品族群，融入了5G、人工智能技术、机器视觉技术、全场
                  景图像识别、绿色新能源动力等技术，打破了背街小巷等传统区域的
                  “以人为主，设备为辅”模式局限，精准解决行业痛点难点。</div>
                <div class="swiper-box wow fadeInUp50">
                  <div class="swiper-container">
                    <div class="swiper-wrapper">

                      <div class="swiper-slide">
                        <a href="/equipment/5sanitationSeries.html?cs1=5&cs2=16">
                          <div class="pic"><img src="${PubStaticServer}/static/jw/images/20200927093532971.png" alt="智能纯电动全线控一体式扫路机/机器人"></div>
                          <div class="name">智能纯电动全线控一体式扫路机/机器人</div>
                        </a>
                      </div>

                      <div class="swiper-slide">
                        <a href="/equipment/5sanitationSeries.html?cs1=5&cs2=15">
                          <div class="pic"><img src="${PubStaticServer}/static/jw/images/2020073012002461.png" alt="智能纯电动全线控一体式清洗机/机器人"></div>
                          <div class="name">智能纯电动全线控一体式清洗机/机器人</div>
                        </a>
                      </div>

                      <div class="swiper-slide">
                        <a href="/equipment/5sanitationSeries.html?cs1=5&cs2=30">
                          <div class="pic"><img src="${PubStaticServer}/static/jw/images/20200730134418906.png" alt="智能纯电动桶装铰接式扫路机"></div>
                          <div class="name">智能纯电动桶装铰接式扫路机</div>
                        </a>
                      </div>

                      <div class="swiper-slide">
                        <a href="/equipment/5sanitationSeries.html?cs1=5&cs2=31">
                          <div class="pic"><img src="${PubStaticServer}/static/jw/images/20200730134925624.png" alt="智能纯电动自跟随清吸机器人"></div>
                          <div class="name">智能纯电动自跟随清吸机器人</div>
                        </a>
                      </div>

                      <div class="swiper-slide">
                        <a href="/equipment/5sanitationSeries.html?cs1=5&cs2=32">
                          <div class="pic"><img src="${PubStaticServer}/static/jw/images/20200927093818264.png" alt="智能纯电动桶装一体式扫路机"></div>
                          <div class="name">智能纯电动桶装一体式扫路机</div>
                        </a>
                      </div>

                      <div class="swiper-slide">
                        <a href="/equipment/5sanitationSeries.html?cs1=5&cs2=33">
                          <div class="pic"><img src="${PubStaticServer}/static/jw/images/20200730140238567.png" alt="智能纯电动一体式清洗机"></div>
                          <div class="name">智能纯电动一体式清洗机</div>
                        </a>
                      </div>

                      <div class="swiper-slide">
                        <a href="/equipment/5sanitationSeries.html?cs1=5&cs2=34">
                          <div class="pic"><img src="${PubStaticServer}/static/jw/images/20200927094024488.png" alt="智能驾驶铰接式扫路机器人"></div>
                          <div class="name">智能驾驶铰接式扫路机器人</div>
                        </a>
                      </div>

                    </div>
                    <div class="swiper-pagination"></div>
                  </div>
                  <a href="javascript:;" class="swiper-btn prev"></a>
                  <a href="javascript:;" class="swiper-btn next"></a>
                </div>
              </div>
            </div>

          </div>

        </div>
      </div>
    </div>
  </div>
  <!-- 环卫装备 end -->
  <@extends name="//common/end_menu.ftl"/>


  <script>
    function getData() {

      $("#btnJZL").hide();
      var size = $('#DivList').children('div').length;
      $.ajax({
        url: "/AjaxAction/ajaxload.ashx?action=series&c=003002001&m=126&Size=" + size,
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
            $(".list .item").each(function (i) {
              $(this).addClass("wow fadeInUp50")
              createSwiper(i)
            })
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
    function createSwiper(index) {
      var swiper = new Swiper('.item-' + index + ' .swiper-container', {
        slidesPerView: 3,
        spaceBetween: 15,
        breakpoints: {
          1024: {
            slidesPerView: 2,
            spaceBetween: 15,
          }
        },
        navigation: {
          nextEl: '.item-' + index + ' .next',
          prevEl: '.item-' + index + ' .prev',
        },
        loop: true,
        pagination: {
          el: '.item-' + index + ' .swiper-pagination',
          clickable: true,
        },
      })
    }
    $(".list .item").each(function (i) {
      $(this).addClass("wow fadeInUp50")
      createSwiper(i)
    })
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