<@override name="body">
  <div class="box-container-fluid header-wrapper">
  <@extends name="//common/top_menu.ftl"/>
  <!-- banner start -->
  <div class="page-banner-wrapepr">
    <img src="${one.imageBanner!}" alt class="banner">
  </div>

  <!-- 二级栏目 start -->
  <div class="box-container-fluid page-nav-wrapper">
    <div class="box">
      <div class="title-box">
        <div class="title">${one.name!}</div>
        <p>${one.nameEn!}</p>
      </div>
      <div class="page-nav-box">
        <div class="intruction-caption" onclick="itemToggle(this)" data-status="0">${two.name!}</div>
        <div class="nav">
          <#list twoList as twoList>
          <a <#if twoList.id==twoId> class="on" </#if> href="${serverPath}/jw/aboutUs/companyProfile?oneId=${one.id!}&twoId=${twoList.id!}&threeId=0&fourId=0&newId=0">${twoList.name!}</a>
          </#list>

        </div>
      </div>
      <div class="breadcrumb">
        <a href="/" class="home"><img src="${PubStaticServer}/static/jw/images/home.png" alt></a>
        <img src="${PubStaticServer}/static/jw/images/icon.png" alt class="icon">
        <a href="${serverPath}/jw/aboutUs/companyProfile?oneId=${one.id!}&twoId=0&threeId=0&fourId=0&newId=0">${one.name!}</a>
        <img src="${PubStaticServer}/static/jw/images/icon.png" alt class="icon">
        <span>${two.name!}</span>
      </div>
    </div>
  </div>
  <!-- 二级栏目 end -->
  <!-- 项目展示 start -->
  <div class="box-container-fluid page-box equipment-wrapper  caseinfo-wrapper  ">
    <div class="container">
      <div class="mini-container">
        <div class="page-title-box wow fadeInUp50">
          <div class="title">${two.name!}</div>
          <p>${two.nameEn!}</p>
        </div>
        <div class="page-category-box wow fadeInUp50">
          <div class="inner">
            <#list  threeList as threeList>
            <a  <#if threeList.id=threeId>class="on"</#if> href="${serverPath}/jw/aboutUs/companyProfile?oneId=${threeList.oneParentId!}&twoId=${threeList.twoParentId!}&threeId=${threeList.id!}&fourId=0&newId=0" >${threeList.name!}</a>
            </#list>
          </div>
        </div>
        <#if fourSize&gt;0>
          <div class="page-cat-box wow fadeInUp50">
            <ul id="seriesConditionType">
              <li>
                <span class="cat">分类：</span>
                <a href="${serverPath}/jw/aboutUs/companyProfile?oneId=${oneId!}&twoId=${twoId!}&threeId=${threeId!}&fourId=0&newId=0" data-da="0" <#if fourId==0> class="on"</#if> >全部</a>
                <#list  fourList as fourList>
                  <a <#if newId &gt;= 0> <#if fourId==fourList.id> class="on"</#if></#if> href="${serverPath}/jw/aboutUs/companyProfile?oneId=${fourList.oneParentId!}&twoId=${fourList.twoParentId!}&threeId=${fourList.threeParentId!}&fourId=${fourList.id}&newId=0" data-da="23" >${fourList.name!}</a>
                </#list>
              </li>
            </ul>
          </div>
        </#if>
        <#if newId &lt;=  0 >
        <#if newsSize&gt;1 >
        <div class="list">
          <ul id="DivList">
                <#list newsList as newsList>
                  <li>
                    <a href="${serverPath}/jw/aboutUs/companyProfile?oneId=${newsList.typeOneId!}&twoId=${newsList.typeTwoId!}&threeId=${newsList.typeThreeId!}&fourId=${newsList.typeFourId!}&newId=${newsList.id!}">
                      <div class="pic"><img src="${newsList.images!}" alt="${newsList.name!}" width="684px" height="370px"></div>
                      <div class="info">
                        <div class="name">${newsList.name!}</div>
                        <div class="desc">
                          ${newsList.describes!}
                        </div>
                        <div class="a-more"></div>
                      </div>
                    </a>
                  </li>
                </#list>

          </ul>
        </div>
        <#else>
          <#if news.video?? && news.video!=''>
            <div class="first-box">
              <!-- 封面图 -->
              <!-- 视频 -->
              <div class="video"style="display:flex;align-items:center;justify-content:center;">
                <video src="${news.video!}" controls="" video-src="${news.video!}"></video>
              </div>
            </div></br>
          </#if>
          <#if imagesListSize &gt;0>
            <div class="base-box wow fadeInUp50">
              <div class="bigImg">
                <div class="swiper-container goodspic-swiper">
                  <div class="swiper-wrapper">

                    <div class="swiper-slide"><img src="${serverPath}/common/image?id=${images1!}" alt=""></div>

                  </div>
                  <div class="swiper-pagination"></div>
                </div>
              </div>
              <!-- 缩略图 -->
              <div class="thumbs">
                <div class="swiper-container thumbs-swiper">
                  <div class="swiper-wrapper">
                    <#list imagesList as imagesList>
                      <div class="swiper-slide"><img  id="imagess" src="${serverPath}/common/image?id=${imagesList!}" alt="" onclick="onImg(this)"></div>
                    </#list>
                  </div>
                </div>
                <a href="javascript:;" class="swiper-btn prev"></a>
                <a href="javascript:;" class="swiper-btn next"></a>
              </div>

            </div></br>
         </#if>
        <div class="detail-box">
          ${news.conten!}
        </div>
        </#if>
        <#else>
          <#if news.video?? && news.video!=''>
            <div class="first-box">
              <!-- 封面图 -->
              <!-- 视频 -->
              <div class="video" style="display:flex;align-items:center;justify-content:center;">
                <video src="${news.video!}" controls="" video-src="${news.video!}"></video>
              </div>
            </div></br>
          </#if>
          <#if imagesListSize &gt;0>
            <div class="base-box wow fadeInUp50">
              <div class="bigImg">
                <div class="swiper-container goodspic-swiper">
                  <div class="swiper-wrapper">

                    <div class="swiper-slide"><img id="imagess" src="${serverPath}/common/image?id=${images1!}" alt=""></div>

                  </div>
                  <div class="swiper-pagination"></div>
                </div>
              </div>
              <!-- 缩略图 -->
              <div class="thumbs">
                <div class="swiper-container thumbs-swiper">
                  <div class="swiper-wrapper">
                    <#list imagesList as imagesList>
                      <div class="swiper-slide"><img src="${serverPath}/common/image?id=${imagesList!}" alt="" onclick="onImg(this)"></div>
                    </#list>
                  </div>
                </div>
                <a href="javascript:;" class="swiper-btn prev"></a>
                <a href="javascript:;" class="swiper-btn next"></a>
              </div>

            </div></br>
          </#if>
        <div class="detail-box">
          ${news.conten!}
        </div>
        </#if>

        <!-- 新闻详情-->
      </div>
    </div>
  </div>
  <!-- 项目展示 end -->


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
    var swiper = new Swiper('.thumbs-swiper', {
      navigation: {
        nextEl: '.thumbs .next',
        prevEl: '.thumbs .prev',
      },
      direction: 'vertical',
      slidesPerView: "auto",
      spaceBetween: 20,
      slideToClickedSlide: true,
      on: {
        init: function () {
          var i = this.activeIndex;
          $('.thumbs .swiper-slide').eq(i).addClass('active');
          $(".bigImg .swiper-slide").eq(i).fadeIn(500)
        },
        slideChangeTransitionStart: function () {
          var index = this.activeIndex
          $('.thumbs .swiper-slide').eq(index).addClass('active').siblings().removeClass("active");
          $(".bigImg .swiper-slide").eq(index).fadeIn(300).siblings().hide()
        },
        click: function () {
          var index = this.clickedIndex
          $('.thumbs .swiper-slide').eq(index).addClass('active').siblings().removeClass("active");
          $(".bigImg .swiper-slide").eq(index).fadeIn(300).siblings().hide()
        },
      }
    })
    if (wid <= 1024) {
      var goods_swiper = new Swiper('.goodspic-swiper', {
        pagination: {
          el: '.goodspic-swiper .swiper-pagination',
          clickable: true,
        },
      });
    }

    for (var i = 0; i < $(".params ul li").length; i++) {
      $(".params ul li").eq(i).addClass("wow fadeInUp50").attr("data-wow-delay", i * 150 + "ms")
    }
    function onImg(img){
      $("#imagess").attr("src",$(img).attr("src"))
    }
  </script>
  <script>
    for (var i = 0; i < $(".list ul li").length; i++) {
      $(".list ul li").eq(i).addClass("wow fadeInUp50").attr("data-wow-delay", i * 200 + "ms")
    }
  </script>
</@override>
<@extends name="//common/iframe_templates.ftl"/>