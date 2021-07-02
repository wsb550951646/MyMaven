function Storage() {

}

Storage.prototype.init = function () {

    $("#add_button").click(Storage.prototype.add);
    $("a.mount").click(Storage.prototype.mount);
    $("a.unmount").click(Storage.prototype.unmount);
    $("a.edit_button").click(Storage.prototype.edit);
    $("a.del_button").click(Storage.prototype.delete);

}

Storage.prototype.delete = function(){

    var id = $(this).attr("index");
    var isMount = $(this).attr("isMount") == 'true';

    if(isMount){
        alert("请先卸载存储")
        return;
    }
    
    var param = {};
    param["storage.id"] = id; 
    
    $.post("deleteCommanderStorage.action",param,function (data) {
        if(data.actionErrors &&  data.actionErrors.length > 0){
            alert(isNullOrEmpty(data.actionErrors[0]) ? msg_mountFail : data.actionErrors[0]);
        }else {
           $.post("setCommanderStorage.action",function (data) {
               $("#main_storage").html(data);
           })

        }
    });
    


}

Storage.prototype.edit = function(){

    var id = $(this).attr("index");
    var isMount = $(this).attr("isMount") == 'true';

    if(isMount){
        alert("请先卸载存储")
        return;
    }

    var $edit_table = $(".editor_storage_tab");

    if($edit_table.hasClass("Hide")){
        $edit_table.removeClass("Hide");
    }else {
        $edit_table.addClass("Hide");
    }


    var path = $edit_table.find("input[name='storage.path']");
    var name = $edit_table.find("input[name='storage.name']");
    var user = $edit_table.find("input[name='storage.user']");
    var pwd  = $edit_table.find("input[name='storage.pwd']");
    var opt  = $edit_table.find("input[name='storage.options']");

    path.val($("#"+id+"_path").text());
    name.val($("#"+id+"_name").text());
    user.val($("#"+id+"_usr").text());
    pwd.val($("#"+id+"_pwd").text());
    opt.val($("#"+id+"_opts").text());

    var type = $edit_table.find("select[name='storage.type']");
    var count = type.find("options").length;
    var select_type = $("#"+id+"_type").text();
    for(var i = 0 ; i < count ; i++){
        if(type.get(0).options[i].value == select_type){
            type.get(0).options[i].selected = true;
            break;
        }
    }

    $("#editor_btnCancel").click(function () {
        $(".editor_storage_tab").addClass("Hide");
    })

    $("#editor_btnOk").click(function () {
        var param = {};
        param["storage.id"]   = id;
        param["storage.type"] = type.find("option:selected").val();
        param["storage.path"] = path.val();
        param["storage.name"] = name.val();
        param["storage.user"] = user.val();
        param["storage.pwd"]  = pwd.val();
        param["storage.options"] = opt.val();
        
        $.post("updateCommanderStorage.action",param,function (data) {

            if(data.actionErrors &&  data.actionErrors.length > 0){
                alert(isNullOrEmpty(data.actionErrors[0]) ? msg_mountFail : data.actionErrors[0]);
            }else if(data.fieldErrors){
                for(var p in data.fieldErrors){
                    $edit_table.find("td[name='"+p+"']").text(data.fieldErrors[p]);
                }
            }else {
                    param["storage.id"] = id;
                    $.post("mountCommanderStorage.action",param,function (data) {
                        if(data.actionErrors &&  data.actionErrors.length > 0) {
                            alert(isNullOrEmpty(data.actionErrors[0]) ? msg_mountFail : data.actionErrors[0]);
                        }else if(data.fieldErrors){
                            for(var p in data.fieldErrors){
                                $edit_table.find("td[name='"+p+"']").text(data.fieldErrors[p]);
                            }
                        }else {
                            $.post("setCommanderStorage.action",function (data) {
                                $("#main_storage").html(data);
                            });
                        }
                });
            }
        });
    });

}

Storage.prototype.unmount = function(){

    var index = $(this).attr("index");
    var params = {};
    params["storage.id"] = index;
    $.post("unmountCommanderStorage.action",params,function (data) {

        if(data.actionErrors && data.actionErrors.length > 0){
            alert(isNullOrEmpty(data.actionErrors[0]) ? msg_mountFail : data.actionErrors[0]);
        } else {
            $.post("setCommanderStorage.action",function (data) {
                $("#main_storage").html(data);
            });
        }

    });

}


Storage.prototype.mount = function(){

    var $this = $(this);
    var index = $this.attr("index");

    var params = {};
    params["storage.id"] = index;
    $.post("mountCommanderStorage.action",params,function (data) {
        if (data.actionErrors && data.actionErrors.length > 0) {
            alert(isNullOrEmpty(data.actionErrors[0]) ? msg_mountFail : data.actionErrors[0]);
        }else {
            $.post("setCommanderStorage.action",function (data) {
                $("#main_storage").html(data);
            });
        }

    });


}

Storage.prototype.add = function () {

    var $storage_tab = $(".add_storage_tab");

    if($storage_tab.hasClass("Hide")){
        $(".add_storage_tab").removeClass("Hide");
    }else {
        $(".add_storage_tab").addClass("Hide");
    }

    var path = $storage_tab.find("input[name='storage.path']");
    var name = $storage_tab.find("input[name='storage.name']");
    var user = $storage_tab.find("input[name='storage.user']");
    var pwd = $storage_tab.find("input[name='storage.pwd']");
    var options = $storage_tab.find("input[name='storage.options']");
    var type = $storage_tab.find("select[name='storage.type'] option:selected");

    $("#btnCancel").click(function () {
        $(".add_storage_tab").addClass("Hide");
    })

    $("#btnOk").click(function () {

        var params = {};
        params["storage.path"] = path.val();
        params["storage.name"] = name.val();
        params["storage.user"] = user.val();
        params["storage.pwd"] = pwd.val();
        params["storage.options"] = options.val();
        params["storage.type"] = type.val();

        $.post("addCommanderStorage.action",params,function (data) {
            if(data.actionErrors && data.actionErrors.length >0){
                alert("actions error");
            } else if(data.fieldErrors){
                for(var p in data.fieldErrors){
                    $storage_tab.find("td[name='"+p+"']").text(data.fieldErrors[p]);
                }
            } else {
                var index = data.storage.id;
                var params = {};
                params["storage.id"] = index;
                $.post("mountCommanderStorage.action",params,function (data) {
                    if (data.actionErrors && data.actionErrors.length > 0) {
                        alert(isNullOrEmpty(data.actionErrors[0]) ? msg_mountFail : data.actionErrors[0]);
                    }else {
                        $.post("setCommanderStorage.action",function (data) {
                            $("#main_storage").html(data);
                        });
                    }

                });
            }
        });

    });

}

function isNullOrEmpty(strVal) {
    if (strVal == '' || strVal == null || strVal == undefined) {
        return true;
    } else {
        return false;
    }
}