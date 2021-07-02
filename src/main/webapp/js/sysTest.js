function SysTest() {

}

SysTest.prototype.init = function () {

    $(".check_button").click(SysTest.prototype.test);

};

SysTest.prototype.test = function () {
    var testid = $(this).attr("id");
    var sessionid = new Date().getTime();
    if(testid == "testAll")
        SysTest.prototype.checkAll(sessionid);
    else
        //这里的this是check_button,所以获取的id也是 id_test,要去除掉
        SysTest.prototype.checkItem(sessionid,testid.substring(0,testid.length-5));


};

SysTest.prototype.checkItem = function(sessionId,testid){
    $(".check_button").prop('disabled',true);

    SysTest.prototype.check(sessionId,testid,null,null);
};


SysTest.prototype.checkAll = function (sessionId) {

    var testids = new Array();
    //这里获取的是tr，然后取的是tr的id。
    $("#tbl").find("tr").each(function () {
        var testid = $(this).attr("id");
        if(testid != null && testid != undefined){
            testids.push(testid);
        }
    });

    if(testids.length == 0)
        return;

    $(".check_button").prop("disabled",true);

    $(".systest_result").removeClass().addClass("systest_result icon_wait");
    
    SysTest.prototype.check(sessionId,testids[0],testids,0);

};

SysTest.prototype.checkEnd = function(){
    $(".check_button").prop('disabled',false);
};

SysTest.prototype.check = function (sessionid,testid,testids,index) {
    var tr = $("#"+testid);
    $(tr).find(".systest_result").removeClass().addClass("systest_result icon_doing");

    //process param
    var params = {};
    params["id"] = id;
    params["Local"] = isLocal;
    params["sessionId"] = sessionid;
    params["testId"] = testid;
    params["clientTime"] = Math.floor(new Date().getTime()/1000);
    $.post("updateSysTest.action",params,function (data) {
       if(data.actionErrors && data.actionErrors.length > 0){
            alert(data.actionErrors[0]);
       }
       else if (data.fieldErrors) {
           var strFieldErrors = "";
           //   因为fieldError是 Map<String,List<String>> 类型的，所以p遍历出来的是Key值
           for( var p in data.fieldErrors){
               strFieldErrors += data.fieldErrors[p];
           }
            alert(strFieldErrors);
       }else {
           var result = data.result;
           var info = data.info;

           if(result == true){
               $(tr).find(".systest_result").removeClass().addClass("systest_result icon_ok");
           }else {
               $(tr).find(".systest_result").removeClass().addClass("systest_result icon_failed");
           }

           if(info != null && info != undefined && info != '' && $.trim(info) != ''){
                if(info.length > 15 || info.split(/\n/).length > 1){
                    $(tr).find(".systest_info").text("...");
                    $(tr).find(".systest_info").attr("title",info);
                }else {
                    $(tr).find(".systest_info").text(info);
                }
           }

        //递归循环
           if( testids != null && index != null){
               index++;
               if( index < testids.length){
                   SysTest.prototype.check(sessionid,testids[index],testids,index);
               }else{
                   SysTest.prototype.checkEnd();
               }
           }else{
               SysTest.prototype.checkEnd();
           }


       }



    });














}

