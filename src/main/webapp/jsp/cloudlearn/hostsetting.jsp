<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>

    <style type="text/css">
        #secondNavigation{
            width: 100%;
        }

        #secondNavigationPanel{
            height: 66px;
        }

        #secondNavigationPanel div.secondClassNav{
            float: left;
            display: inline-block;
            border-right: 1px solid #ccccd1;
            border-left: 1px solid #ccccd1;
            border-top: 1px solid #ccccd1;

            background-color: #f7f7f7;
            width: auto;
            padding:0px 25px ;
            cursor: pointer;
            height: 30px;
            line-height: 30px;
            text-align: center;
            font-size:9pt;
        }

        #secondNavigationPanel div.last{
            border: 1px solid #FFFFFF;
            background-color: #FFFFFF;
        }

        #secondNavigationPanel .secondClassNavActive{
            color: #00a9e6;
        }

        #main{
            position: absolute;
            border: 1px solid #ccccd1;
            top: 30px;
            left:0px;
            right:0px;
            bottom:0px;
        }


    </style>

</head>
<body>

    <div id="secondNavigation">
        <div id="secondNavigationPanel">
            <div href="" class="secondClassNav secondClassNavActive">网口设置</div>
            <div href="" class="secondClassNav">路由表</div>
            <div href="" class="secondClassNav">DNS</div>
            <div href="" class="secondClassNav">防火墙设置</div>
            <div href="" class="secondClassNav">时间设置</div>
            <div href="" class="secondClassNav">主机操作</div>
            <div href="" class="secondClassNav">系统检测</div>
            <div href="" class="secondClassNav last"></div>
            <div class="clear"></div>
        </div>
    </div>

    <div id="main">
        <%@include file="hostsetting-router.jsp"%>
    </div>
</body>
</html>
