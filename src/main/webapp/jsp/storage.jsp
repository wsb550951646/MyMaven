<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<head>
    <title>Title</title>
    <script type="text/javascript" src="<%=request.getContextPath()%>/jquery/jquery-3.1.1.js"></script>
    <script type="text/javascript" src="<%=request.getContextPath()%>/jquery/jquery-3.1.1.min.js"></script>
    <script type="text/javascript" src="<%=request.getContextPath()%>/js/storage.js"></script>
    <script type="text/javascript">

        $(function () {
            var storage = new Storage();
            storage.init();
        })


    </script>

    <style type="text/css">
        .a_warning{position: absolute;margin-top: -5px}
        table{
            padding:0px;
            margin:0px;
            border-collapse:collapse;
        }

        div{
            text-align: left;
        }

        .tbl-list,.tbl-task-list,.tbl-header-list{width: 100%;}
        .tbl-list {table-layout:fixed;}

        tr.tbl-header > td, tr.tbl-content > td, tr.tbl-content-docker > td {
            border: 1px solid #e2e2e5;
            padding: 0px 12px;
        }

        .setting-tbl-header{background:#f5f6fa;}

        .td_name{
            width:140px;
            padding-left:10px;
        }

        .td_path{
            width:233px;
        }

        .td_status{
            width:50px;
        }

        .td_buttons{
            width:138px;
            padding-right:13px;
        }

        a{
            color:#1F84CA;
            cursor:pointer;
        }

        button{
            width:108px;
            height:23px;
        }



        #storageTable tr td{
            text-align: center;
        }

        #storageTable1 tr td{
            border: none;
            padding: 1px;
        }

        .storageTab{
            height:32px;
            vertical-align:bottom;
            font-size:9pt;
            padding:8px 10px;
            cursor:pointer;
            border-bottom:1px solid #dddddd;
        }

        .storageTab:hover {
            background-color: #f4f4f4;
        }

        .storageTab img{
            float:left;

        }

        .storageTabActive{
            background:#ffffff !important;
        }

        .storageContent{
            float:left;
            padding-top:20px;
            padding-left:250px;
        }

        .Hide {
            display: none;
        }

        .noCursor{
            cursor: auto;
            color: gray;
        }
        .right{
            float: right;
        }




    </style>
</head>

<body>

<div>
    <table class="tbl-header-list" style="table-layout: fixed;" >
        <tr class="tbl-header setting-tbl-header">
            <td class="td_name">名称</td>
            <td class="td_path">路程</td>
            <td class="td_status">状态</td>
            <td class="td_buttons"></td>
        </tr>
    </table>

    <table class="tbl-list">
        <s:iterator value='remoteStorageList' var="var" status="st">
            <tr class="tbl-content">
                <td class="td_name" id="<s:property value='#var.id'/>_name"><s:property value='#var.name'/></td>
                <td class="td_path" id="<s:property value='#var.id'/>_path"><s:property value='#var.path'/></td>
                <td class="td_status">
                    <span>
                        <s:if test='statusList[#st.index] == @sweng.serviceImp.CommanderStorageService$StorageStatus@NORMAL_MOUNTED'>
                            <img src="../png/green.png">
                        </s:if>
                        <s:elseif test='statusList[#st.index] == @sweng.serviceImp.CommanderStorageService$StorageStatus@NORMAL_UNMOUNTED'>
                            <img src="../png/gray.png">
                        </s:elseif>
                        	<s:elseif test="statusList[#st.index] == @sweng.serviceImp.CommanderStorageService$StorageStatus@NOMRAL_SOME_GROUP_NOT_MOUNTED">
                                <img src="../png/green_grey.png" /></s:elseif>
                        <s:else>
                            <img src="../png/red.png">
                        </s:else>
                    </span>
                </td>

                <td style="display: none" id="<s:property value="#var.id"/>_usr"><s:property value='#var.user'/></td>
                <td style="display: none" id="<s:property value="#var.id"/>_pwd"><s:property value='#var.pwd'/></td>
                <td style="display: none" id="<s:property value="#var.id"/>_type"><s:property value='#var.type'/></td>
                <td style="display: none" id="<s:property value="#var.id"/>_opts"><s:property value='#var.options'/></td>

                <td class="td_buttons">
                    <s:if test='statusList[#st.index] != @sweng.serviceImp.CommanderStorageService$StorageStatus@NORMAL_MOUNTED'>
                        <a class="tbl-action mount" index="<s:property value='#var.id'/>">挂载</a>
                    </s:if>

                    <s:if test='statusList[#st.index] != @sweng.serviceImp.CommanderStorageService$StorageStatus@NORMAL_UNMOUNTED'>
                        <a class="tbl-action unmount" index="<s:property value="#var.id"/>">卸载</a>
                    </s:if>

                    <s:if test='statusList[#st.index] == @sweng.serviceImp.CommanderStorageService$StorageStatus@NORMAL_UNMOUNTED'>
                        <a index="<s:property value="#var.id"/>" isMount="false" class="tbl-action edit_button">编辑</a>
                        <a index="<s:property value="#var.id"/>" isMount="false" class="tbl-action del_button">删除</a>
                    </s:if>
                    <s:else>
                        <a index="<s:property value="#var.id"/>" isMount="true" class="tbl-action edit_button">编辑</a>
                        <a index="<s:property value="#var.id"/>" isMount="true" class="tbl-action del_button">删除</a>
                    </s:else>

                </td>
            </tr>
        </s:iterator>
    </table>


    <div class="commander-sub_actions" style="padding-top: 20px;padding-right: 25px;">
        <div class="right">
            <input type="button" id="add_button" value="添加存储">
        </div>
    </div>

   <%@include file="addStorage.jsp"%>
   <%@include file="editStorage.jsp"%>

</div>

</body>

