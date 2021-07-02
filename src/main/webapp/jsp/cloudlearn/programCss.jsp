<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <script type="text/javascript" src="<%=request.getContextPath()%>/js/programcss/programcss.js"></script>

    <style type="text/css">

        #container{
            margin: 10px;

        }

        div.line-wrapper::after{
            content:"";
            clear:both;
            display: block;
            visibility: hidden;
        }

        div.second-nav-bar div.second-nav-menu{
            float: left;
            cursor: pointer;
            border-top: 1px solid #ccccd1;
            border-left: 1px solid #ccccd1;
            border-bottom: 1px solid #ccccd1;
            background: #f7f7f7;
            padding: 0px 25px;
            display: inline-block;
            height: 38px;
            line-height: 35px;
            text-align: center;
        }

        div.second-nav-bar div.active{
            border-top:3px solid #5166ff;
            border-bottom: 1px solid white;
            background-color: #ffffff;
            height:28px;
            line-height:25px;
        }

        div.second-nav-bar div.last{
            border-top: 1px solid #FFFFFF;
            background-color: #FFFFFF;

        }

        .clear{
            clear:both;
        }

        hr.second-nav-bar-hr{
            margin-top:-1px;
            height:1px;
            border:none;
            border-top: 1px solid #ccccd1;
        }

        #commander-setting-container{
            margin: 10px;
        }

        #firstNavigation{
            height: 24px;
        }

        div.firstNavigationPanel::after{
            content: ".";
            visibility: hidden;
            display: block;
            clear:both;
        }

        div.firstClassNav{
            float: left;
            width: 90px;
            height: 24px;
            line-height: 24px;
            cursor:pointer;
            margin-right: 10px;
            vertical-align: bottom;

            text-align: center;
            font-size:10pt;
            font-style:normal;
            font-weight: normal;

        }

        .firstClassNavActive{
            color:#ffffff;
            background-color: #00bbff;
        }

        .commander-sub-container
        {
            position: absolute;
            left: 18px;
            right: 18px;
            top: 120px;
            bottom: 20px;
            overflow-y:auto;
        }

        *{
            font-size: 9pt;
            font-style: normal;
        }

        td{
            height: 30px;
        }
    </style>

    <script type="text/javascript">
        $(function () {
            var program = new Programe();
            program.init();
        });
    </script>

</head>
<body>

    <div id="container">
        <div class="line-wrapper second-nav-bar-wrapper">
            <div class="second-nav-bar">
                <div class="second-nav-menu active">集群管理</div>
                <div class="second-nav-menu ">节点管理</div>
                <div class="second-nav-menu ">Dock管理</div>
                <div class="second-nav-menu last"></div>
                <div class="clear"></div>
                <hr class="second-nav-bar-hr"/>
            </div>
        </div>
        <div class="line-wrapper"></div>
    </div>

    <div id="commander-setting-container">
        <div id="firstNavigation">
            <div class="firstNavigationPanel">
                <div class="firstClassNav" href="SystemInfo.action">设备信息 </div>
                <div class="firstClassNav" href="businessInfo.action">业务系统</div>
                <div class="firstClassNav" href="licenseInfo.action">许可证管理</div>
                <div class="firstClassNav firstClassNavActive" href="hostsetting.action">存储管理</div>
                <div class="firstClassNav" href="#">主机设置 </div>
                <div class="firstClassNav" href="#">主机性能</div>
                <div class="firstClassNav" href="#">资源池</div>
                <div class="firstClassNav" href="#">固件升级</div>
            </div>
        </div>
    </div>

    <div id="content" class="commander-sub-container">
        <%@include file="hostsetting.jsp"%>
    </div>
</body>
</html>
