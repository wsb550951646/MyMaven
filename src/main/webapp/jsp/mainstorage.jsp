<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<head>
    <title>Title</title>
    <script type="text/javascript" src="<%=request.getContextPath()%>/jquery/jquery-3.1.1.js"></script>
    <script type="text/javascript" src="<%=request.getContextPath()%>/jquery/jquery-3.1.1.min.js"></script>
    <script type="text/javascript" src="<%=request.getContextPath()%>/js/mainstorage.js"></script>
    <link rel="sytlesheet" type="text/css" href="<%=request.getContextPath()%>/css/cloud.css" />
    <link rel="sytlesheet" type="text/css" href="<%=request.getContextPath()%>/css/dialog.css" />

    <style type="text/css">

        *{
            font-size: 9pt;
            font-style: normal;
        }

        textarea{
            resize: none;
            width:214px;
            height:64px;
        }

        table{
            border-collapse: collapse;
            border-spacing: 0px;
            border:0px;
        }


        table{width:auto;}
        *{
            font-size: 9pt;
            font-style: normal;
        }

        th{
            height:30px;
            font-weight: normal;
        }

        td{
            height:30px;
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

        #secondNavigationPanel {
            height: 66px;
        }

        /* network setting tab page */
        div#secondNavigationPanel .secondClassNav{
            float: left;
            display: inline-block;
            cursor: pointer;
            width:100px;
            height:30px;
            line-height:30px;

            text-align:center;
            font-size:9pt;
            background: #f7f7f7;
            border-top: 1px solid #ccccd1;
            /*border-bottom: 1px solid #ccccd1;*/
            border-left: 1px solid #ccccd1;
        }

        div#secondNavigationPanel .secondClassNavActive{
            color: #02bcff;
        }

        div#secondNavigationPanel div.last {
            border-top: 1px solid #fff;
            border-bottom: 0px;
            background: transparent;
        }

        div#secondNavigationPanel hr.second-nav-bar-hr {
            margin-top: -1px;
            height: 1px;
            border: none;
            border-top: 1px solid #ccccd1;
        }

        .secondClassNavActive .tab_name {
            text-align: center;
            color:#ffffff;
        }

        tr {
            font-size:10pt;
        }


        /*time setting*/
        div#timePanel button{
            font-size:9pt;
            width:102px;
        }

        div#btnPanel{
            margin-top:50px;
            width:700px;
            text-align:center;
        }

        #timezonePanel select{
            width:200px;
        }

        #zoneSelector option{
            padding-left:20px;
        }

        div#timePanel input[type=text]{
            width:180px;
        }


        button{
            width:85px;
            height:23px
        }

        select.port_type{
            width:108px;
            height:23px;
        }

        #main_storage{
            border:1px solid #ccccd1;
            position:absolute;
            left:0px;top:30px;right:0px;bottom:0px;
            padding-top:0px;
            overflow: auto;
        }

    </style>

    <script type="text/javascript">
        $(function () {
            var mainstorage = new MainStorage();
            mainstorage.init();
        });

    </script>

</head>
<body>

<div id="content" class="commander-sub-container">
<div id="secondNavigation">
    <div id="secondNavigationPanel">
        <div href="<%=request.getContextPath()%>/setCommanderStorage.action" id="storageMenu1" class="secondClassNav secondClassNavActive">远程存储空间</div>
        <div href="<%=request.getContextPath()%>/groupStorage.action" id="storageMenu2" class="secondClassNav secondClassNavActive">存储挂载管理</div>
        <div class="secondClassNav last"></div>
        <div style="clear: both"></div>
    </div>
</div>

    <div id="main_storage">

    </div>

</div>
</body>

