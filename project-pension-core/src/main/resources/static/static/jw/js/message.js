
function Salert(title, content) {
    var tmp = '<div class="ui-dialog show"><div class="ui-dialog-cnt"><div class="ui-dialog-bd"><div><h4>' + title + '</h4><div>' + content + '</div></div></div><div class="ui-dialog-ft ui-btn-group"><button type="button" class="select" onclick="closemsgs();">确 认</button></div></div></div>';
    $("body").append(tmp);
}
function closemsgs() {
    $(".ui-dialog").each(function (i, item) {
        if ($(item).hasClass("show")) {
            $(item).removeClass("show").addClass("hide");
        }
    });
}
