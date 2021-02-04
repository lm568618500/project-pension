<div class="box">
    <!-- logo -->
    <div class="logo-box">
        <a href="/">
            <img src="${PubStaticServer}/static/jw/images/logo.png" alt class="original">
            <img src="${PubStaticServer}/static/jw/images/20200707172133564.png" alt class="on">
        </a>
    </div>
    <div class="pc-nav-box">
        <ul>
            <#list oneWebList as oneWebList>
                <li><a href="${serverPath}/jw/news?oneId=${oneWebList.id!}&twoId=0&threeId=0&fourId=0&newId=0">${oneWebList.name!}</a></li>
            </#list>
        </ul>
        <div class="child-box">
            <#list oneWebList as oneWebList>
                <div class="hide-box">
                    <div class="w1200">
                        <div class="info">
                            <img src="${oneWebList.image!}" alt="${oneWebList.name!}" width="580" height="210">
                            <div class="caption-box">
                            </div>
                        </div>
                        <div class="nav">
                            <#list oneWebList.twoList as  twoList>
                            <a class href="${serverPath}/jw/news?oneId=${oneWebList.id!}&twoId=${twoList.id!}&threeId=0&fourId=0&newId=0">${twoList.name!}</a>
                            </#list>
                        </div>
                    </div>
                </div>
            </#list>
            <div class="hide-box">
                <div class="w1200">
                    <div class="info">
                        <img src="${PubStaticServer}/static/jw/images/20201009152331093.jpeg" alt="联系我们">
                        <div class="caption-box">

                        </div>
                    </div>
                </div>
            </div>

        </div>
    </div>
    <div class="other-box">
        <!-- 搜索框 start -->
        <div class="pc-search-box">
            <a href="JavaScript:;" class="search" onclick="searchToggle()">
            </a>
        </div>
        <div class="search-form">
            <div class="w1200">
                <a href="javascript:;"  class="search-btn"><img src="${PubStaticServer}/static/jw/images/search3.png" alt></a>
                <input type="text" class="keywords" id="searchval" placeholder="请输入关键词">
                <a href="javascript:;" class="iconfont icon-close" onclick="searchToggle()"></a>
            </div>
        </div>
        <!-- 搜索框 end -->
        <!-- 语言切换 -->
        <div class="language-box">
            <div class="icon"></div>
            <div class="list">
                <a href="/">中</a>
                <a href="/indexEn">英</a>
            </div>
        </div>
        <!-- tel -->
        <div class="tel-box">${GlobalMap['COMPANY_TEL']}</div>

        <!-- 手机导航菜单按钮 start-->
        <div class="nav-icon" onclick="phoneNavToggle(this)"><span></span></div>
        <!-- 手机导航菜单按钮 start-->
    </div>
</div>
<div class="mask"></div>
<!-- 撑开头部 -->
</div>
<!-- 隐藏导航 start-->
<div class="phone-nav" id="phone-nav">
    <ul>
        <!-- 高亮li.on -->
        <li><a href="/index.html">首页</a></li>

        <#list oneWebList as oneWebList>
            <li>
                <!-- 有二级样式 a.cat-->
                <a href="javascript:;">${oneWebList.name!}</a>
                <div class="nav">
                    <#list oneWebList.twoList as  twoList>
                        <a class href="${serverPath}/jw/news?oneId=${oneWebList.id!}&twoId=${twoList.id!}&threeId=0&fourId=0&newId=0">${twoList.name!}</a>
                    </#list>
                </div>
            </li>
        </#list>
    </ul>
</div>
<!-- 隐藏导航 end-->
