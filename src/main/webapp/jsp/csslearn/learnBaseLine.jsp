<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <script type="text/javascript" src="../../jquery/jquery-3.1.1.js"></script>
    <script type="text/javascript" src="../../jquery/jquery-3.1.1.min.js"></script>
    <script>

    </script>
    <style type="text/css" >


        .align{
            margin-bottom: 100px;

        }

        .ctn-block{
            display: block;
            background-color: #bbb;
            line-height: 200px;
            font-size: 50px;
        }

        .ctn-block .child1{
            display: inline-block;
            width: 100px;
            height: 100px;
            margin:10px 0;
            vertical-align: baseline;
            background-color: aliceblue;
        }

        ul{
            background-color: bisque;
        }

        .letter{
            display: inline-block;
        }

        .box{
            display: inline-block;
            width: 100px;
            height: 100px;
            background-color: aliceblue;
        }

        .ctn-block1{
            background-color: #bbb;
        }

        .ctn-block1 .child{
            display: inline-block;
            width: 100px;
            background-color: aliceblue;
        }

        .child-1{
            height: 100px;
        }

        .child-2{
            height: 200px;
        }

        .child-3{
            height: 300px;
        }


    </style>

</head>
<body>

    <div></div>

    <div class="align" >
        维护森马
    </div>

    <div class="ctn-block">
        <div class="child1"></div>
        <span>Gg</span>
    </div>

    <ul>
        <li class="letter">x</li>
        <li class="box"></li>
        <li class="box"></li>
        <li class="box"></li>
    </ul>

    <div class="ctn-block1">
        <div class="child child-1"></div>
        <div class="child child-2"></div>
        <div class="child child-3"></div>
    </div>

</body>
</html>
