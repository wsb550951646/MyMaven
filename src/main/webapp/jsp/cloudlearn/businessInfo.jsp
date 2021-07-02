<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>

    <style type="text/css">
        .right{
            float: right;
        }

        .tbl-header-list,.tbl-list{
            width: 100%;
            table-layout: fixed;
        }

        .commander-sub_actions{
            float: right;
            padding-bottom: 20px;
        }



        /*
            解决父类塌陷，display：block 独占一行，可以起到换行效果
             .commander-sub_actions::after{
            content: ".";
            clear:both;
            display: block;
            visibility: hidden;
        }
         */


        tr.tbl-header,tr.tbl-content,td {
            border: 1px solid #e2e2e5;
            padding: 0px 12px;
        }

        table{
            padding: 0px;
            margin: 0px;
            border: 0px;
            width: 100%;
            empty-cells: show;
            border-collapse: collapse;
        }

        td{
            height: 30px;
        }

        *{
            font-size: 9pt;
            font-style: normal;
        }


        .setting-tbl-header{background:#f5f6fa;}

    </style>

</head>
<body>
   <div>
       <div class="commander-sub_actions">
            <div class="right">
                <input type="button" id="btn-add" value="新增业务系统">
            </div>
       </div>

       <div>
           <table class="tbl-header-list setting-tbl-header">
                <tbody>
                    <tr class="tbl-header">
                        <td >业务系统代码</td>
                        <td>名称</td>
                        <td>绑定转码组</td>
                        <td>描述</td>
                        <td></td>
                    </tr>
                </tbody>
           </table>

           <table class="tbl-list">
               <tbody>
                    <tr class="tbl-content">
                        <td></td>
                        <td>默认</td>
                        <td>tx</td>
                        <td></td>
                        <td><a href="" >修改</a></td>
                    </tr>
               </tbody>
           </table>
       </div>

   </div>
</body>
</html>
