
<div class="box-container-fluid footer-wrapper">
    <div class="box-container">
        <!-- 底部导航 phone显示 start-->
        <div class="phone-footer-nav">
            <ul>
                <#list oneWebList as oneWebList>
                    <li>
                        <a href="javascript:;" class="cat">${oneWebList.name!}</a>
                        <div class="nav">
                            <#list oneWebList.twoList as  twoList>
                                <a class href="${serverPath}/jw/news?oneId=${oneWebList.id!}&twoId=${twoList.id!}&threeId=0&fourId=0&newId=0">${twoList.name!}</a>
                            </#list>
                        </div>
                    </li>
                </#list>

            </ul>
        </div>
        <!-- 底部导航 phone显示 end-->

        <div class="footer-nav-box">
            <#list oneWebList as oneWebList>
                 <dl>
                     <dt><a href="${serverPath}/jw/news?oneId=${oneWebList.id!}&twoId=0&threeId=0&fourId=0&newId=0">${oneWebList.name!}</a></dt>
                    <div class="nav">
                        <#list oneWebList.twoList as  twoList>
                        <dd><a href="${serverPath}/jw/news?oneId=${oneWebList.id!}&twoId=${twoList.id!}&threeId=0&fourId=0&newId=0">${twoList.name!}</a></dd>
                        </#list>
                    </div>
                 </dl>
            </#list>
        </div>
        <div class="other-box">
            <!-- 二维码 -->
            <div class="qrcode"><img src="${GlobalMap['SUDAN_FOOTER_EWM']}" alt></div>

            <div class="friend-link">
                <div class="title">友情链接</div>
                <div class="list">

                </div>
            </div>
            <div class="copy">Copyright © 2021 <br>${GlobalMap['COMPANY_NAME']} <br><a href="http://beian.miit.gov.cn/" target="_blank">粤ICP备2021015056号-1
                </a></div>
        </div>
    </div>
</div>
