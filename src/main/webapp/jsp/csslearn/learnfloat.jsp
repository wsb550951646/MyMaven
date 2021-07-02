<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <script type="text/javascript" src="../../jquery/jquery-3.1.1.js"></script>
    <script type="text/javascript" src="../../jquery/jquery-3.1.1.min.js"></script>
    <script>

    </script>
    <style type="text/css" >

        .Hide{
            width:100px;
            height: 100px;
            display: inline-block;
            background-color: #232fee;
        }

        .Hide2{
            width: 100px;
            height: 100px;
            display: inline-block;
            background-color: #eeb4ae;
        }

        .Hide3{
            width: 100px;
            height: 100px;
            display: inline-block;
            background-color: #c9bdee;
        }

        .parent{
            width: 100%;
            background-color: rgba(0,0,0,0.5)
        }
        .div1,.div2{
            width: 300px;
            height: 200px;
            border:2px solid red;
        }
        .div3{
            width: 600px;
            height:500px;
            border: 2px solid green;
            background-color: aqua;
        }
        .div1{
            float:left;
        }
        .div2{
            float:right;
        }
        /*解决父项塌陷核心代码*/
        .parent:after{
            content:"";
            display: block;
            clear:both;
        }

    </style>
</head>
<body>

<div class="parent">
    <div class="div1">div1</div>
    <div class="div2">div2</div>
</div>

<div class="">
    <div class="Hide">123</div>
    <div class="Hide2">456</div>
    <div class="Hide3">XXX</div>
</div>

<div>



</div>


</body>
</html>
