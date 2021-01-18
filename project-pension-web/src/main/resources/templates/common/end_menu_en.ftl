
<div class="box-container-fluid footer-wrapper">
    <div class="box-container">
        <!-- 底部导航 phone显示 start-->
        <div class="phone-footer-nav">
            <ul>
                <#list oneWebList as oneWebList>
                    <li>
                        <a href="javascript:;" class="cat"${oneWebList.nameEn!}</a>
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
                     <dt><a href="${serverPath}/jw/newsEn?oneId=${oneWebList.id!}&twoId=0&threeId=0&fourId=0&newId=0">${oneWebList.nameEn!}</a></dt>
                    <div class="nav">
                        <#list oneWebList.twoList as  twoList>
                        <dd><a href="${serverPath}/jw/newsEn?oneId=${oneWebList.id!}&twoId=${twoList.id!}&threeId=0&fourId=0&newId=0">${twoList.nameEn!}</a></dd>
                        </#list>
                    </div>
                 </dl>
            </#list>
        </div>
        <div class="other-box">
            <!-- 二维码 -->
            <div class="qrcode"><img src="${GlobalMap['SUDAN_FOOTER_EWM']}" alt></div>

            <div class="friend-link">
                <div class="title">Links</div>
                <div class="list">

                </div>
            </div>
            <div class="copy">Copyright © 2020 <br>${GlobalMap['COMPANY_NAME']} <br><a href="http://beian.miit.gov.cn/">粤ICP备号</a></div>
        </div>
    </div>
</div>
