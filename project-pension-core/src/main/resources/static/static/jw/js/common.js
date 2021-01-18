
//手机导航toggle
function phoneNavToggle(obj) {
    $(obj).toggleClass("on")
    if ($("#phone-nav").hasClass("active")) {
        $("#phone-nav").animate({
            "right": '-100%'
        },1000);
        $("#phone-nav").removeClass("active")
    } else {
        $("#phone-nav").animate({
            "right": '0'
        },1000);
        $("#phone-nav").addClass("active")
    }
}

$(".phone-nav li > a").click(function(){
    $(this).parent("li").toggleClass("active").siblings().removeClass("active");
    $(this).next(".nav").slideToggle(500).parent().siblings().find(".nav").slideUp(500)
})
$(".num span").countUp()

function searchToggle(){
    $(".pc-search-box").toggleClass("on")
    $(".search-form").slideToggle(500)
    if($(".pc-search-box").hasClass("on")){
        $(".header-wrapper").addClass("on")

    }else{
        $(".header-wrapper").removeClass("on")
    }
}

$(".child-box .hide-box").each(function(i){
    var a_len = $(this).find(".nav a").length
    if(a_len > 4) {
         $(this).find(".nav").addClass("more")
    }
})
var wid = $("body,html").width()
var hide_h = 410
if(wid <= 1600) {
    hide_h = 370
}
if(wid <= 1440) {
    hide_h = 330
}
$('.pc-nav-box ul li').each(function(i){
    $(this).hover(
       function(){
            var li_wid = $(this).width()
            $('.child-box .hide-box').eq(i).height(hide_h).siblings().height(0)
            $('.child-box .hide-box').eq(i).addClass("on").siblings().removeClass("on")
        },
       function(){
           $('.child-box .hide-box').height(0)
           $('.child-box .hide-box').removeClass("on")
        }
    )
})  
$('.child-box .hide-box').each(function(i){
    $(this).hover(
       function(){
            var index = $(this).index()
            $(this).height(hide_h).siblings().height(0)
            $(this).addClass("on").siblings().removeClass("on")
        },
       function(){
           $('.child-box .hide-box').height(0)
           $('.child-box .hide-box').removeClass("on")
        }
    )
})




$(window).on("scroll", function(){
    var top = $(window).scrollTop();
    if(top > 100) {
        $(".fixed-right-box,.gotop").fadeIn(600)
    }else{
        $(".fixed-right-box,.gotop").fadeOut(600)
    }
    if(top > 20) {
        $(".child-box").addClass("scroll")
        $(".search-form").fadeOut(500)
        $(".header-wrapper").removeClass("on")
        $(".pc-search-box").removeClass("on")
    }else{
        $(".child-box").removeClass("scroll")
    }
})

function makesvg(percentage){
    var abs_percentage=Math.abs(percentage).toString();
    var percentage_str=percentage.toString();
    var svg = '<svg class="circle-chart" viewbox="0 0 33.83098862 33.83098862" xmlns="http://www.w3.org/2000/svg">'
        + '<circle class="circle-chart__background" cx="16.9" cy="16.9" r="15.9" />'
        + '<circle class="circle-chart__circle "'
        + 'stroke-dasharray="'+ abs_percentage+',100"    cx="16.9" cy="16.9" r="15.9" />'
        + '</svg>';
    return svg
}


$(".footer-wrapper .friend-link .title").click(function(){
    $(this).toggleClass("on")
    $(".footer-wrapper .friend-link .list").slideToggle(500)
})


// 手机底部导航toggle
$(".phone-footer-nav ul li > a").click(function(){
    $(this).parent().toggleClass("on").siblings("li").removeClass("on")
    $(this).next(".nav").slideToggle(500).parent().siblings().find(".nav").slideUp(500)
})

// 手机回到顶部
function gotop() {
    $("body,html").animate({
        scrollTop: 0
    }, 800);
}

function itemToggle(obj) {
	var status = $(obj).attr('data-status');
	if (status == 0) {
            $(obj).addClass("extend")
            $(obj).next(".nav").slideDown(500)
            $(obj).attr('data-status', 1)
    } else {
            $(obj).removeClass("extend")
			$(obj).next(".nav").slideUp(500)
            $(obj).attr('data-status', 0)
	}
}


$(function(){
    new WOW().init();
})

if(wid < 1024) {
    $(".phone-nav ul li").each(function(){
        var len = $(this).find(".nav-list a").length
        if(len > 0) {
        $(this).find(">a").attr("href","javascript:;")
        }
    })
    $(".friend-link .caption").click(function(){
        $(".friend-link").toggleClass("on")
    })
}