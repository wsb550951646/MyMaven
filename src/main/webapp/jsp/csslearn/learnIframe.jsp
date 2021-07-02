<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <script type="text/javascript" src="../../jquery/jquery-3.1.1.js"></script>
    <script type="text/javascript" src="../../jquery/jquery-3.1.1.min.js"></script>
    <script type="text/javascript" src="<%=request.getContextPath()%>/js/programcss/learnIframe.js"></script>
    <script type="text/javascript">
        $(function () {

            var learniframe = new LearnIframe();
            learniframe.init();

        })
    </script>
    <style type="text/css" >
        div#headerContainer{
            position: fixed;
            left: 0px;
            top: 0px;
            width: 100%;
            height: 57px;
            background: #1d7ea1;
        }

        div#navTabPanel{
            position: fixed;
            left: 0px;
            top: 57px;
            height: 100%;
            width: 207px;
            background:#2d3744;
            padding-top: 10px;
        }

        div#mainFrameContainer{
            position: fixed;
            top: 57px;
            left: 207px;
            right: 0px;
            bottom: 0px;
            overflow-x:auto;
            overflow-y: auto;
            padding-top: 10px;
        }

        div.navTab{
            text-align: left;
            line-height: 43px;
            cursor: pointer;
            height: 43px;
            padding-top:2px;
            color: #FFFFFF;
        }

        div#navTabPanel div.active{
            background: url(../../png/hover_focus.png) repeat-x scroll 0px 0px;
            color: #FFFFFF !important;

        }

        iframe#mainFrame{
            width: 100%;
            height: 100%;
            min-width:1200px;
            min-height: 300px;
        }

        span.navBtnText{
            display: inline-block;
            vertical-align: middle;
            padding-left: 20px;
            font-size: 11pt;
            font-style: normal;
        }

        .navTab img{
            margin-left:20px;
            display: inline-block;
            vertical-align: middle;
        }

        .navTab>a{
            display: none;
            cursor:pointer;
        }

    </style>
</head>
<body>
    <div id="headerContainer">

    </div>

    <div id="navTabPanel">
        <div class="navTab active" id="navTab1">
            <a href="learnBaseLine.jsp"></a>
            <img src="../../png/renwu.png">
            <span class="navBtnText">BaseLine</span>
        </div>
        <div class="navTab" id="navTab2">
            <a href="learnCenter.jsp"></a>
            <img src="../../png/renwu.png">
            <span class="navBtnText">Center</span>
        </div>
        <div class="navTab" id="navTab3">
            <a href="learnfloat.jsp"></a>
            <img src="../../png/renwu.png">
            <span class="navBtnText">float</span>
        </div>
        <div class="navTab" id="navTab4">
            <a href="learnMargin.jsp"></a>
            <img src="../../png/renwu.png">
            <span class="navBtnText">Margin</span>
        </div>
        <div class="navTab" id="navTab5">
            <a href="learnMargin2.jsp"></a>
            <img src="../../png/renwu.png">
            <span class="navBtnText">Margin2</span>
        </div>
        <div class="navTab" id="navTab6">
            <a href="learnpostion.jsp"></a>
            <img src="../../png/renwu.png">
            <span class="navBtnText">Position</span>
        </div>
        <div class="navTab" id="navTab7">
            <a href="programCenter.jsp"></a>
            <img src="../../png/renwu.png">
            <span class="navBtnText">ProgramCenter</span>
        </div>
        <div class="navTab" id="navTab8">
            <a href="programMargin.jsp"></a>
            <img src="../../png/renwu.png">
            <span class="navBtnText">ProgramMargin</span>
        </div>
    </div>

    <div id="mainFrameContainer">
        <iframe id="mainFrame" name="mainFrame" frameborder="0"></iframe>
    </div>

</body>
</html>
