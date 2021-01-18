//JavaScript代码区域
//同申请人1
function tsqr1(){
	$("[name='manufacturer']").val($("[name='applicantUni']").val());
	$("[name='manufacturerEnglishName']").val($("[name='applicantUniEnglishName']").val());
	$("[name='manufacturerChApplicantAddress']").val($("[name='applicantUniChApplicantAddress']").val());
	$("[name='manufacturerEnglishApplicantAddress']").val($("[name='applicantUniEnglishApplicantAddress']").val());
	$("[name='manufacturerUnifiedSocialCreditCode']").val($("[name='applicantUniUnifiedSocialCreditCode']").val());
	$("[name='manufacturerLegalRepresentative']").val($("[name='applicantUniLegalRepresentative']").val());
	$("[name='manufacturerContacts']").val($("[name='applicantUniContacts']").val());
	$("[name='manufacturerContactsPost']").val($("[name='applicantUniContactsPost']").val());
	$("[name='manufacturerContactsTelephone']").val($("[name='applicantUniContactsTelephone']").val());
	$("[name='manufacturerContactsFax']").val($("[name='applicantUniContactsFax']").val());
	$("[name='manufacturerContactsEmail']").val($("[name='applicantUniContactsEmail']").val());
	$("[name='manufacturerContactsMobile']").val($("[name='applicantUniContactsMobile']").val());
	form.render('select');
}
//同申请人1
function tsqr2(){
	$("[name='production']").val($("[name='applicantUni']").val());
	$("[name='productionEnglishName']").val($("[name='applicantUniEnglishName']").val());
	$("[name='productionChApplicantAddress']").val($("[name='applicantUniChApplicantAddress']").val());
	$("[name='productionEnglishApplicantAddress']").val($("[name='applicantUniEnglishApplicantAddress']").val());
	$("[name='productionUnifiedSocialCreditCode']").val($("[name='applicantUniUnifiedSocialCreditCode']").val());
	$("[name='productionLegalRepresentative']").val($("[name='applicantUniLegalRepresentative']").val());
	$("[name='productionContacts']").val($("[name='applicantUniContacts']").val());
	$("[name='productionContactsPost']").val($("[name='applicantUniContactsPost']").val());
	$("[name='productionContactsTelephone']").val($("[name='applicantUniContactsTelephone']").val());
	$("[name='productionContactsFax']").val($("[name='applicantUniContactsFax']").val());
	$("[name='productionContactsEmail']").val($("[name='applicantUniContactsEmail']").val());
	$("[name='productionContactsMobile']").val($("[name='applicantUniContactsMobile']").val());
	form.render('select');
}

//同制造商
function tzzs(){
	$("[name='production']").val($("[name='manufacturer']").val());
	$("[name='productionEnglishName']").val($("[name='manufacturerEnglishName']").val());
	$("[name='productionChApplicantAddress']").val($("[name='manufacturerChApplicantAddress']").val());
	$("[name='productionEnglishApplicantAddress']").val($("[name='manufacturerEnglishApplicantAddress']").val());
	$("[name='productionUnifiedSocialCreditCode']").val($("[name='manufacturerUnifiedSocialCreditCode']").val());
	$("[name='productionLegalRepresentative']").val($("[name='manufacturerLegalRepresentative']").val());
	$("[name='productionContacts']").val($("[name='manufacturerContacts']").val());
	$("[name='productionContactsPost']").val($("[name='manufacturerContactsPost']").val());
	$("[name='productionContactsTelephone']").val($("[name='manufacturerContactsTelephone']").val());
	$("[name='productionContactsFax']").val($("[name='manufacturerContactsFax']").val());
	$("[name='productionContactsEmail']").val($("[name='manufacturerContactsEmail']").val());
	$("[name='productionContactsMobile']").val($("[name='manufacturerContactsMobile']").val());
	form.render('select');
}
function getTime(){
	var myDate = new Date;
    var year = myDate.getFullYear(); //获取当前年
    var mon = myDate.getMonth() + 1; //获取当前月
    var date = myDate.getDate(); //获取当前日
     var h = myDate.getHours();//获取当前小时数(0-23)
     var m = myDate.getMinutes();//获取当前分钟数(0-59)
     var s = myDate.getSeconds();//获取当前秒
	var now=year+'-'+mon+"-"+date+" "+h+':'+m+":"+s;
	return now;
}
//删除上传内容
function shanchu(i,b){
	$("#fileName"+i).empty();
    $("#fileTime"+i).empty();
    $("#fileSize"+i).empty();
    $("#filesName"+i).val("");
    $("#filesTime"+i).val("");
    $("#filesSize"+i).val("");
    $("#filesUrl"+i).val("");
    $(b).remove();
}