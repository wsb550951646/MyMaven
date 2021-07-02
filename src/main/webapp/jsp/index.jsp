<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <script type="text/javascript" src="../jquery/jquery-3.1.1.js"></script>
    <script type="text/javascript" src="../jquery/jquery-3.1.1.min.js"></script>
    <script>

        $(function () {


        })

    </script>
    <style type="text/css">
        td.td_var{
            width: 100px;
        }

        td.td_var .td_div {
          width:120px;
        }

        td.td_var select{
            width: 240px;
        }

        td.td_var input{
            width: 400px;
        }

        .selected{
            color: #00a9e6;
        }
    </style>

</head>
<body>


    <div class="selected">???</div>
    <p class="selected">Hello Again</p>
    <div><span>Hello</span></div>
    <p>And Again</p>

    <div  href="setCommanderStorage.action" >远程存储</div>

    <div class="selected1"><span>111</span></div>
    <div class="selected2"><span>222</span></div>

    <table style="width: 300px;">
        <tr>
            <td class="td_var">
                <select>
                <option value="1">1</option>
                <option value="2">2</option>
                <option value="3">3</option>
                <option value="4">4</option>
                </select>
            </td>
        </tr>

        <tr>
            <td class="td_var">
                <div class="td_div">
                123
                </div>
            </td>
        </tr>

        <tr>
            <td class="td_var"><input type="text"></td>
        </tr>
    </table>


    <s:iterator value="profiles" var="profileList" status="st">
        <tr class="tab_content">
            <td class=""><s:property value="#profileList.name"/></td>
            <td class=""><s:property value="profiles[#st.index].name"/></td>
        </tr>
    </s:iterator>

</body>
</html>
