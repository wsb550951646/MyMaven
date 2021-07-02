<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>

    <style type="text/css">
        #secondNavigation{
            width: 100%;
        }

        #secondNavigationPanel{

        }

        #secondNavigationPanel div.secondClassNav{
            float: left;
            background: #f7f7f7;
            height: 30px;
            padding:0px 25px;
            line-height: 30px;
            width: auto;
            text-align: center;
            cursor: pointer;
            border-left: 1px solid #ccccd1;
            border-top: 1px solid #ccccd1;
        }

        #secondNavigationpanel div.secondClassNavActive{
            color: #02bcff;
        }

        #secondNavigationPanel div.last {
           border-top: 0px solid #FFFFFF;
           border-right: 0px solid #FFFFFF;
           background-color: #FFFFFF;
        }

        #main{
            border: 1px solid #ccccd1;
            position: absolute;
            top: 30px;
            left: 0px;
            right: 0px;
            bottom: 0px;
            padding-top: 20px;
        }


    </style>

</head>
<body>
    <div id="secondNavigation">
        <div id="secondNavigationPanel">
            <div href="" class="secondClassNav secondClassNavActive">集群授权</div>
            <div href="" class="secondClassNav">DTS授权</div>
            <div href="" class="secondClassNav">加载第三方插件</div>
            <div href="" class="secondClassNav last"></div>
            <div class="clear"></div>
        </div>
    </div>


    <div id="main">
        <%@include file="licenseInfo-coordinator.jsp"%>
    </div>

</body>
</html>
