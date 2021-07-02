<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<head>
    <title>Title</title>
    <script type="text/javascript" src="../jquery/jquery-3.1.1.js"></script>
    <script type="text/javascript" src="../jquery/jquery-3.1.1.min.js"></script>
    <script type="text/javascript" src="../js/sysTest.js"></script>
    <link rel="stylesheet" type="text/css" href="../css/common.css" />

    <link rel="stylesheet" type="text/css" href="../css/sysTest.css" />

    <script type="text/javascript">
        var id = 001;
        var isLocal=true;

        $(function () {
            alert(1);
            var systest = new SysTest();
            systest.init();
        })

    </script>

</head>
<body>
<s:debug></s:debug>

<div id="systestPanal" style="margin:20px;">
    <table id="tbl" class="appui_listview" style="width: inherit">
       <tr class="tab_header">
           <td class="systest_type_col">类型</td>
           <td class="systest_name_col">名称</td>
           <td class="systest_result_col">结果</td>
           <td class="systest_info_col">信息</td>
           <td class="systestBtn"><button type="button" id="testAll" class="systest_query_button check_button">检查全部</button></td>
       </tr>
        <s:if test="%{tests!=null }">
        <s:iterator value="tests" var="systest" status="st">
            <s:if test="%{!#systest.disable}">
                <s:if test="%{(isLocal && (#systest.node.indexOf('c')!=-1)) || (!isLocal && (#systest.node.indexOf('a') != -1))}">
                    <tr class="tab_content" id="<s:property value="#systest.id"/>">
                        <td class="systest_type_col"><s:property value="#systest.type"/></td>
                        <td class="systest_name_col"><s:property value="#systest.name"/></td>
                        <td class="systest_result_col">
                            <div class="systest_result icon_wait">
                            </div>
                        </td>
                        <td class="systest_info_col">
                            <div class="systest_info">
                            </div>
                        </td>
                        <td class="systest_btn_col"><button type="button" id="<s:property value="#systest.id"/>_test" class="systest_query_button check_button">检查</button></td>
                    </tr>
                </s:if>
            </s:if>
        </s:iterator>
        </s:if>
    </table>

</div>


</body>