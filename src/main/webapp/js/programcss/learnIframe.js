function LearnIframe() {

}

LearnIframe.prototype.init = function () {

    $(".navTab").click(function () {
        updateState(this);
    });

}

function updateState(obj) {
    var $this = $(obj);
    var href = $this.find("a").attr("href");
    if(href == undefined){
        return;
    }

    $("#mainFrame").remove();
    $("#mainFrameContainer").append("<iframe id=\"mainFrame\" name=\"mainFrame\" frameborder=\"0\"></iframe>");
    window.frames["mainFrame"].location.href = href;

    $("#navTabPanel .navTab").each(function (index,item) {
        if(item == obj){
            $(item).removeClass("active").addClass("active");
        }else {
            $(item).removeClass("active")
        }
    });
}