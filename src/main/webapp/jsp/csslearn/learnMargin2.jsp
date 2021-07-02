<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <script type="text/javascript" src="../../jquery/jquery-3.1.1.js"></script>
    <script type="text/javascript" src="../../jquery/jquery-3.1.1.min.js"></script>

    <style type="text/css" >
        .margin1{
          margin-left: -10px;
        }

        .margin2{
            margin-left: 10px;
        }

        .margin3{

        }

        .margin4{

        }

        .div1{
            width: 200px;
            height: 200px;
            background-color: blue;
            float: left;
        }
        .div2{
            width: 200px;
            height: 200px;
            background-color: red;
            margin-left: 10px;
            float: left;
        }
        .div3{
            width: 200px;
            height: 200px;
            background-color: green;
            margin: -100px;
            float: left;
        }

        .div4{
            width: 200px;
            height: 200px;
            float: left;
            background-color: blue;

        }
        .div5{
            width: 200px;
            height: 200px;
            background-color: red;
            margin-left: 10px;
            float: left;
        }
        .div6{
            width: 200px;
            height: 200px;
            background-color: green;
            margin-left: 10px;
            float: left;
        }

        .div6-1{
            width: 200px;
            height: 200px;
            background-color: blue;
            float: left;
        }

        .container1{
            border :3px solid black ;
            margin: 20px;
        }

        .container2{
            border :3px solid black;
            margin: 20px;
        }


        .container1:after{
            clear: both;
            display:block;
            content: "";
        }

        .container2:after{
            clear: both;
            display:block;
            content: "";
        }

        .container4{
            background-color: #7b8693;
            display: inline-block;
            width: 400px;
            height: 400px;
        }

        .div7{

            background-color: black;
            display: inline-block;
            width: 200px;
            height: 200px;
        }

        ul,li{ padding:0; margin:0;}
        ul,li{ list-style:none;}
        .container3{ height:210px; width:460px; border:5px solid #000;}
        ul{ height:210px; overflow:hidden; margin-right:-20px;}/*一个负的margin-right,相当于把ul的宽度增加了20px*/
        li{ height:100px; width:100px; background:#09F; float:left; margin-right:20px; margin-bottom:10px;}

    </style>
</head>
<body>
    <p class="margin1">这是第一个段文字</p>
    <p class="margin2">这是第一个段文字</p>
    <p class="margin3">这是第一个段文字</p>
    <p class="margin4">这是第一个段文字</p>

<div class="container1">
    <div class="div1"></div>
    <div class="div2"></div>
    <div class="div3"></div>
</div>

    <div class="container2">
        <div class="div4"></div>
        <div class="div5"></div>
        <div class="div6"></div>
        <div class="div6-1"></div>
    </div>

<div class="container3">
    <ul>
        <li>子元素1</li>
        <li>子元素2</li>
        <li>子元素3</li>
        <li>子元素4</li>
        <li>子元素5</li>
        <li>子元素6</li>
        <li>子元素7</li>
        <li>子元素8</li>
    </ul>
</div>

<div class="container4">
    <div class="div7">
    </div>
</div>

</body>
</html>
