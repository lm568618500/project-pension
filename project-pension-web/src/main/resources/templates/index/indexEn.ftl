<@override name="body">
<div class="box-container-fluid header-wrapper index">
 <@extends name="//common/top_menu_en.ftl"/>
  <div class="box-container-fluid index-banner-wrapper">
    <div class="swiper-container index-banner-swiper">
      <div class="swiper-wrapper">


        <div class="swiper-slide">
          <a href>
            <div class="pic">
              <img src="${GlobalMap['SYS_BANNER1']}" alt="" class="pc"><img src="${GlobalMap['SYS_BANNER1']}" alt="" class="phone">
            </div>
            <div class="info info-5">
              <div class="box-container">
                <div class="name"></div>
                <div class="en"></div>
              </div>
            </div>
          </a>
        </div>



        <div class="swiper-slide">
          <a href>
            <div class="pic">
              <img src="${GlobalMap['SYS_BANNER2']}" alt="" class="pc"><img src="${GlobalMap['SYS_BANNER2']}" alt="" class="phone">
            </div>
            <div class="info info-3">
              <div class="box-container">
                <div class="name"></div>
                <div class="en"></div>
              </div>
            </div>
          </a>
        </div>



        <div class="swiper-slide">
          <a href>
            <div class="pic">
              <img src="${GlobalMap['SYS_BANNER3']}" alt="" class="pc"><img src="${GlobalMap['SYS_BANNER3']}" alt="" class="phone">
            </div>
            <div class="info info-4">
              <div class="box-container">
                <div class="name"></div>
                <div class="en"></div>
              </div>
            </div>
          </a>
        </div>


      </div>
      <!-- 轮播进度 -->
      <div class="swiper-pagination"></div>
      <!-- 轮播控制 -->
      <a href="javascript:;" class="swiper-btn prev"></a>
      <a href="javascript:;" class="swiper-btn next"></a>
    </div>
  </div>

  <div class="box-container-fluid index-box-1">
    <div class="box-container">
      <div class="info-box wow fadeInLeft50">
        <div class="name">公司简介</div>
        <div class="ename"></div>
        <div class="brief">MAKE A CLEANER WORLD BULID A BETTER FUTURE</div>
        <div class="caption">让世界更清洁 让未来更美好</div>
        <div class="content">
          地邦环境产业有限公司是一家集清洁设备研发、制造、销售、物业投资、服务为一体的公司！公司全新引进德国技术支持打造全新智能一体化高端清扫洗地设备，在国内拥有多个销售网点，畅销多个国家和地区。公司以质量求发展，创新为己任；并致力于打造清洁智能环保设备行业的著名品牌！
        </div>
      </div>
      <div class="video-box wow fadeInRight50">
        <!-- 封面图 -->
        <div class="pic">
          <img src="${GlobalMap['SYS_VIDEO_IMG']}" alt>
          <div class="info" onclick="videoPlay()">
          </div>

          <div class="video">
            <video src controls data-src="${GlobalMap['SYS_VIDEO']}"></video>
          </div>

        </div>
      </div>
    </div>
  </div>

  <div class="box-container-fluid index-box-2">
    <div class="index-title-box wow fadeInUp50">
      <div class="box-container">
        <div class="title">WISDOM SANITATION</div>
        <p>WISDOM SANITATION</p>
      </div>
    </div>
    <div class="imgs">
      <#list oneList as oneList>
      <div class="item">
        <img src="${GlobalMap['SYS_PRODUCT_IMG']}" alt="${oneList.nameEn!}" class="pc"><img src="${GlobalMap['SYS_PRODUCT_IMG']}" alt="${oneList.nameEn!}" class="phone">
        <div class="list">
          <div class="box-container">
            <ul>
              <#list oneList.twoList as twoList>
                <li><a href="${serverPath}/jw/newsEn?oneId=${twoList.parentOneId!}&twoId=${twoList.id!}&threeId=0&fourId=0&newId=0">${twoList.nameEn!}</a></li>
              </#list>
            </ul>
          </div>
        </div>
      </div>
      </#list>
    </div>
    <div class="index-cat-box">
      <div class="box-container wow fadeInUp50">
        <#list oneList as oneList>
        <a href="javascript:;" onmouseenter="boxToggle(this)">
          <div class="icon">
            <!-- 触发前 -->
            <img src="<#if oneList.id==1>${PubStaticServer}/static/jw/images/2020071416024267.png</#if><#if oneList.id==2>${PubStaticServer}/static/jw/images/20200714160250423.png</#if><#if oneList.id==3>${PubStaticServer}/static/jw/images/20200714160324265.png</#if>" alt="${oneList.nameEn!}" class="original">
            <!-- 触发后 -->
            <img src="<#if oneList.id==1>${PubStaticServer}/static/jw/images/20200714160132583.png</#if><#if oneList.id==2>${PubStaticServer}/static/jw/images/20200714160257384.png</#if><#if oneList.id==3>${PubStaticServer}/static/jw/images/20200714160331825.png</#if>" alt="${oneList.nameEn!}" class="on">
          </div>
          <div class="name">${oneList.nameEn!}</div>
        </a>
        </#list>

      </div>
    </div>
  </div>

  <div class="box-container-fluid index-box-4">
    <div class="box-container">
      <div class="index-title-box wow fadeInUp50">
        <div class="title">News Center</div>
        <p>NEWS</p>
      </div>
      <div class="swiper-box wow fadeInUp50">
        <div class="swiper-container news-swiper">
          <div class="swiper-wrapper">
            <#list newsList as newsList>
              <div class="swiper-slide">
                <a href="${serverPath}/jw/newsEn?oneId=${newsList.typeOneId!}&twoId=${newsList.typeTwoId!}&threeId=0&fourId=0&newId=${newsList.id}">
                  <div class="pic"><img src="${newsList.images}" alt="${newsList.nameEn}"></div>
                  <div class="info">
                    <div class="name">${newsList.nameEn!}</div>
                    <div class="desc">${newsList.describesEn!}</div>
                    <div class="more">more</div>
                  </div>
                </a>
              </div>
            </#list>

          </div>
        </div>
        <a href="javascript:;" class="swiper-btn prev"></a>
        <a href="javascript:;" class="swiper-btn next"></a>
      </div>
    </div>
  </div>

  <div class="box-container-fluid index-box-5">
    <div class="box-container">
      <div class="page-title-box wow fadeInUp50">
        <div class="title">Wisdom sanitation</div>
        <p>Wisdom sanitation</p>
      </div>
    </div>
    <div class="swiper-box wow fadeInUp50">
      <div class="ad-box">Project case</div>
      <div class="swiper-container case-swiper">
        <div class="swiper-wrapper">
          <#list newsList2 as newsList>
          <div class="swiper-slide">
            <a href="${serverPath}/jw/newsEn?oneId=${newsList.typeOneId!}&twoId=${newsList.typeTwoId!}&threeId=0&fourId=0&newId=${newsList.id}">
              <div class="info">
                <div class="name">${newsList.nameEn!}</div>
                <div class="desc">${newsList.describeEn!}</div>
                <div class="index-more-2">more<i></i><i></i><i></i><i></i></div>
              </div>
              <div class="pic"><img src="${newsList.images!}" alt="${newsList.images!}"></div>
            </a>
          </div>
          </#list>

        </div>
      </div>
      <div class="swiper-count">
        <span class="current"></span>
        <i>/</i>
        <span class="total"></span>
        <div class="btn-box">
          <a href="javascript:;" class="swiper-btn prev"></a>
          <a href="javascript:;" class="swiper-btn next"></a>
        </div>
      </div>
    </div>
  </div>
  <@extends name="//common/end_menu_en.ftl"/>


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
    // banner 轮播
    var index_banner = new Swiper('.index-banner-swiper', {
      navigation: {
        nextEl: '.index-banner-swiper .next',
        prevEl: '.index-banner-swiper .prev',
      },
      pagination: {
        el: '.index-banner-swiper .swiper-pagination',
        clickable: true,
      },
      on: {
        init: function () {
          setTimeout(function () {
            $('.index-banner-swiper').find('.swiper-pagination').find('.swiper-pagination-bullet').append('<div class="circlechart" data-percentage="100"></div>');
            var p = $('.index-banner-swiper').find('.swiper-pagination').find('.swiper-pagination-bullet .circlechart').attr('data-percentage');
            $('.index-banner-swiper').find('.swiper-pagination').find('.swiper-pagination-bullet .circlechart').html(makesvg(p))
            $('.index-banner-swiper').find('.swiper-pagination').find('.swiper-pagination-bullet').eq(0).addClass('one')
          }, 100)
        },
      },
      autoplay: {
        autoplay: 3000,
        disableOnInteraction: false,
      },
      loop: true,
      speed: 1200,
    })
    $(".index-banner-wrapper").hover(function () {
      index_banner.autoplay.stop()
    }, function () {
      index_banner.autoplay.start()
    })

    function videoPlay() {
      $(".video-box").addClass("on")
      $(".video-box video").attr("src", $(".video-box video").attr("data-src"))
      $(".video-box video").trigger("play")
    }

    //$(".index-cat-box a").eq(0).addClass("on")
    $(".index-box-2 .item").eq(0).addClass("on")
    function boxToggle(obj) {
      var index = $(obj).index()
      //$(".index-box-2 .item").eq(index).fadeIn(900).siblings().hide()
      $(".index-box-2 .item").eq(index).addClass("on").siblings().removeClass("on")
      $(obj).addClass("on").siblings().removeClass("on")
      var len = $(".index-box-2 .item").eq(index).find("li").length
      for (var j = 0; j < len; j++) {
        $(".index-box-2 .item").eq(index).find("ul li").eq(j).css("transition-delay", 0.2 * j + "s")
      }
    }

    $(".index-box-3 ul li").eq(0).addClass("on")
    $(".index-box-3 ul li").hover(function () {
      $(this).addClass("on").siblings().removeClass("on")
    })
    for (var k = 0; k < $(".index-box-3 ul li").length; k++) {
      $(".index-box-3 ul li").eq(k).addClass("wow fadeInLeft50").attr("data-wow-delay", k * 300 + "ms")
    }
    if (wid < 1024) {
      $(".index-box-3 ul li").removeClass("on")
    }


    var news_swiper = new Swiper('.news-swiper', {
      navigation: {
        nextEl: '.index-box-4 .next',
        prevEl: '.index-box-4 .prev',
      },
      slidesPerView: 3,
      spaceBetween: 80,
      slideToClickedSlide: true,
      breakpoints: {
        1600: {
          spaceBetween: 50,
        },
        1024: {
          slidesPerView: 1.3,
          spaceBetween: 20,
        }
      },
    });


    var swiper_len = $(".index-box-5").find(".swiper-slide").length
    swiper_len = swiper_len > 9 ? swiper_len : '0' + swiper_len
    $(".index-box-5 .total").html(swiper_len)
    var case_swiper = new Swiper('.case-swiper', {
      navigation: {
        nextEl: '.index-box-5 .next',
        prevEl: '.index-box-5 .prev',
      },
      slideToClickedSlide: true,
      loop: true,
      autoplay: {
        autoplay: 3000,
        disableOnInteraction: false,
      },
      speed: 1200,
      on: {
        init: function () {
          $('.progress .current').html('01')
        },
        slideChangeTransitionStart: function () {
          var i = this.activeIndex;
          var cur_i=0;
          cur_i = parseInt($('.index-box-5 .swiper-slide').eq(i).attr('data-swiper-slide-index'));
          if(isNaN(cur_i)){
            cur_i=-1;
          }
          cur_i += 1
          cur_i = cur_i > 9 ? cur_i : '0' + cur_i
          $(".index-box-5 .current").text(cur_i)
        }
      }
    });
  </script>
</@override>
<@extends name="//common/iframe_templates_en.ftl"/>