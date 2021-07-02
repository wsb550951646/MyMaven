function MainStorage() {
    this.contentNode = $("#main_storage");
}

MainStorage.prototype.init = function () {

    var $this = this;
    $("div[id^=storageMenu]").click(function () {

        var url = $(this).attr("href");
        $(this).siblings(".secondClassNavActive").removeClass("secondClassNavActive");
        $(this).addClass("secondClassNavActive");
        $.post(url,function (data) {
            $this.contentNode.html(data);
        });
    });

    $("div[id=storageMenu1]").click();

}

