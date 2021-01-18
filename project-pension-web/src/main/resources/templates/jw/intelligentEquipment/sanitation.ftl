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
        <div class="intruction-caption" onclick="itemToggle(this)" data-status="0">环卫装备</div>
        <div class="nav">

          <a class="on" href="${serverPath}/jw/intelligentEquipment/sanitation">环卫装备</a>

          <a class href="${serverPath}/jw/intelligentEquipment/robot">环卫机器人</a>

          <a class href="${serverPath}/jw/intelligentEquipment/science">环境装备</a>

          <a class href="${serverPath}/jw/intelligentEquipment/testing">环境监测</a>

        </div>
      </div>
      <div class="breadcrumb">
        <a href="/" class="home"><img src="${PubStaticServer}/static/jw/images/home.png" alt></a>
        <img src="${PubStaticServer}/static/jw/images/icon.png" alt class="icon">
        <a href="/equipment/">智能装备</a>
        <img src="${PubStaticServer}/static/jw/images/icon.png" alt class="icon">
        <span>环卫装备</span>
      </div>
    </div>
  </div>
  <!-- 二级栏目 end -->

  <!-- 环卫装备 start -->
  <div class="box-container-fluid page-box equipmentclass-wrapper">
    <div class="container">
      <div class="mini-container">
        <div class="page-title-box wow fadeInUp50">
          <div class="title">环卫装备</div>
          <p>INTRODUCTION OF SUBSIDIARIES</p>
        </div>
        <div class="list">
          <div class="box" id="DivList">

            <div class="item item-0">
              <a href="/equipment/4seproduct.html?cs1=4" class="img"><img src="${PubStaticServer}/static/jw/images/20200924083442306.jpeg" alt="道路清扫保洁"></a>
              <div class="info">
                <div class="caption">道路清扫保洁</div>
                <div class="en">ROAD SWEEPING CLEANING</div>
                <div class="desc">二十多年的清扫车研制经验，销量独占全国清扫车市场半壁江山。立足行业难题，推出多款全球、全国首创清扫装备，填补了国内、外空白，始终引领行业发展。清洗车具有多种标准及选装功能配置，实现一车多用。
                </div>
                <div class="swiper-box wow fadeInUp50">
                  <div class="swiper-container">
                    <div class="swiper-wrapper">

                      <div class="swiper-slide">
                        <a href="/equipment/4seproduct.html?cs1=4&cs2=12">
                          <div class="pic"><img src="${PubStaticServer}/static/jw/images/20200924144645649.png" alt="扫路车"></div>
                          <div class="name">扫路车</div>
                        </a>
                      </div>

                      <div class="swiper-slide">
                        <a href="/equipment/4seproduct.html?cs1=4&cs2=10">
                          <div class="pic"><img src="${PubStaticServer}/static/jw/images/2020092416111161.png" alt="洗扫车"></div>
                          <div class="name">洗扫车</div>
                        </a>
                      </div>

                      <div class="swiper-slide">
                        <a href="/equipment/4seproduct.html?cs1=4&cs2=21">
                          <div class="pic"><img src="${PubStaticServer}/static/jw/images/20200927081751679.png" alt="多功能抑尘车"></div>
                          <div class="name">多功能抑尘车</div>
                        </a>
                      </div>

                      <div class="swiper-slide">
                        <a href="/equipment/4seproduct.html?cs1=4&cs2=24">
                          <div class="pic"><img src="${PubStaticServer}/static/jw/images/20200927083716535.png" alt="防撞环卫车"></div>
                          <div class="name">防撞环卫车</div>
                        </a>
                      </div>

                      <div class="swiper-slide">
                        <a href="/equipment/4seproduct.html?cs1=4&cs2=20">
                          <div class="pic"><img src="${PubStaticServer}/static/jw/images/20200924163512813.png" alt="清洗车"></div>
                          <div class="name">清洗车</div>
                        </a>
                      </div>

                      <div class="swiper-slide">
                        <a href="/equipment/4seproduct.html?cs1=4&cs2=18">
                          <div class="pic"><img src="${PubStaticServer}/static/jw/images/20200924161445045.png" alt="绿化综合养护车"></div>
                          <div class="name">绿化综合养护车</div>
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

            <div class="item item-1">
              <a href="/equipment/2seproduct.html?cs1=2" class="img"><img src="${PubStaticServer}/static/jw/images/20200924085911289.jpeg" alt="垃圾收转运"></a>
              <div class="info">
                <div class="caption">垃圾收转运</div>
                <div class="en">REFUSE COLLECTION TRANSFER</div>
                <div class="desc">拥有各种垃圾收集上料方式的全系列产品，广泛应用于城市街道、居民小区和大型企业等生活垃圾的密闭收集及转运。行业首创全系列无泄漏压缩式垃圾车，彻底解决污水滴漏问题。</div>
                <div class="swiper-box wow fadeInUp50">
                  <div class="swiper-container">
                    <div class="swiper-wrapper">

                      <div class="swiper-slide">
                        <a href="/equipment/2seproduct.html?cs1=2&cs2=6">
                          <div class="pic"><img src="${PubStaticServer}/static/jw/images/20200927090628843.png" alt="垃圾车"></div>
                          <div class="name">垃圾车</div>
                        </a>
                      </div>

                      <div class="swiper-slide">
                        <a href="/equipment/2seproduct.html?cs1=2&cs2=5">
                          <div class="pic"><img src="${PubStaticServer}/static/jw/images/20200927091547426.png" alt="小型垃圾站"></div>
                          <div class="name">小型垃圾站</div>
                        </a>
                      </div>

                      <div class="swiper-slide">
                        <a href="/equipment/2seproduct.html?cs1=2&cs2=4">
                          <div class="pic"><img src="${PubStaticServer}/static/jw/images/2020072906513542.png" alt="中大型垃圾站"></div>
                          <div class="name">中大型垃圾站</div>
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

            <div class="item item-2">
              <a href="/equipment/1seproduct.html?cs1=1" class="img"><img src="${PubStaticServer}/static/jw/images/20200924142318488.jpeg" alt="市政应急除雪"></a>
              <div class="info">
                <div class="caption">市政应急除雪</div>
                <div class="en">MUNICIPAL SNOW REMOVAL</div>
                <div class="desc">市政系列产品功能强大，产品类别齐全，可用于地下污水管网的疏通、 污水抽吸、 污水分离处理及公路涵洞、 沟渠的疏通清理。
                  除冰雪系列吸收国内外除冰雪行业先进经验， 自主研发了多款多吨位的专业除冰雪设备。可根据不同地区的降雪及气候情况，提供符合各地实际情况的专业除冰雪系统解决方案， 以最经济、最高效的方案确保道路的畅通，给通行安全带来最完善的保障。</div>
                <div class="swiper-box wow fadeInUp50">
                  <div class="swiper-container">
                    <div class="swiper-wrapper">

                      <div class="swiper-slide">
                        <a href="/equipment/1seproduct.html?cs1=1&cs2=2">
                          <div class="pic"><img src="${PubStaticServer}/static/jw/images/2020092708401856.png" alt="吸粪车"></div>
                          <div class="name">吸粪车</div>
                        </a>
                      </div>

                      <div class="swiper-slide">
                        <a href="/equipment/1seproduct.html?cs1=1&cs2=3">
                          <div class="pic"><img src="${PubStaticServer}/static/jw/images/20200927084559714.png" alt="下水道疏通清洗车"></div>
                          <div class="name">下水道疏通清洗车</div>
                        </a>
                      </div>

                      <div class="swiper-slide">
                        <a href="/equipment/1seproduct.html?cs1=1&cs2=25">
                          <div class="pic"><img src="${PubStaticServer}/static/jw/images/20200927084935353.png" alt="除雪车"></div>
                          <div class="name">除雪车</div>
                        </a>
                      </div>

                      <div class="swiper-slide">
                        <a href="/equipment/1seproduct.html?cs1=1&cs2=1">
                          <div class="pic"><img src="${PubStaticServer}/static/jw/images/20200927084157625.png" alt="吸污车"></div>
                          <div class="name">吸污车</div>
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

            <div class="item item-3">
              <a href="/equipment/3seproduct.html?cs1=3" class="img"><img src="${PubStaticServer}/static/jw/images/20200924142629695.jpeg" alt="新能源系列"></a>
              <div class="info">
                <div class="caption">新能源系列</div>
                <div class="en">NEW ENERGY VEHICLE</div>
                <div class="desc">行业内品类最齐全、型号最多，通过中联环境智慧云控平台的智能调度，精细化管理，综合运营及维护成本仅为同类型燃油车1/3。</div>
                <div class="swiper-box wow fadeInUp50">
                  <div class="swiper-container">
                    <div class="swiper-wrapper">

                      <div class="swiper-slide">
                        <a href="/equipment/3seproduct.html?cs1=3&cs2=29">
                          <div class="pic"><img src="${PubStaticServer}/static/jw/images/20200927091847158.png" alt="市政车"></div>
                          <div class="name">市政车</div>
                        </a>
                      </div>

                      <div class="swiper-slide">
                        <a href="/equipment/3seproduct.html?cs1=3&cs2=9">
                          <div class="pic"><img src="${PubStaticServer}/static/jw/images/20200927092059623.png" alt="清扫车"></div>
                          <div class="name">清扫车</div>
                        </a>
                      </div>

                      <div class="swiper-slide">
                        <a href="/equipment/3seproduct.html?cs1=3&cs2=8">
                          <div class="pic"><img src="${PubStaticServer}/static/jw/images/20200927092456150.png" alt="清洗车"></div>
                          <div class="name">清洗车</div>
                        </a>
                      </div>

                      <div class="swiper-slide">
                        <a href="/equipment/3seproduct.html?cs1=3&cs2=7">
                          <div class="pic"><img src="${PubStaticServer}/static/jw/images/20200927093041529.png" alt="垃圾车"></div>
                          <div class="name">垃圾车</div>
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

          <a href="javascript:getData();" id="btnJZL" class="page-more wow fadeInUp50"><i></i>加载更多</a>

        </div>
      </div>
    </div>
  </div>
  <!-- 环卫装备 end -->
  <@extends name="//common/end_menu.ftl"/>



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
      var size = $('#DivList').children('div').length;
      $.ajax({
        url: "/AjaxAction/ajaxload.ashx?action=series&c=003001001&m=126&Size=" + size,
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
</@override>
<@extends name="//common/iframe_templates.ftl"/>