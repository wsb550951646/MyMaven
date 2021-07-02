<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <script type="text/javascript" src="../../jquery/jquery-3.1.1.js"></script>
    <script type="text/javascript" src="../../jquery/jquery-3.1.1.min.js"></script>
    <script>

    </script>
    <style type="text/css" >
        .wrapper{
            border: 1px solid black;
            text-align: center;
        }

        .btn{
            background: green;
            color: #FFFFFF;
            padding: 20px;
            margin: 20px;
            display: inline-block;
            cursor: pointer;
        }

        .wrapper2{
            width: 300px;
            margin: 0px auto;
            border:1px solid black;
            height: 150px;
            text-align: center;
        }

        .spanlist{
            margin: 60px 0px;
        }

        .span1{
            display: inline-block;
        }

        .wrapper3{
            width: 300px;
            line-height: 300px;
            border:1px solid black;
            text-align: center;
            margin: 0px auto;
            display: inline-block;
        }


        .wrapper3:before{
            content:"a";
            background-color: red;
            display:inline-block;
            vertical-align:middle;
        }

        .wrapper3 > img{
            vertical-align: middle;
            width: 200px;
            height: 200px;
        }

        .p1{
            background-color: #ccccd1;
            text-align: center;
        }

        .p1 > img{
            width: 400px;
            height: 400px;
        }




    </style>
</head>
<body>

<h4>1.水平居中：text-align  div父类设置text-align：center 子元素居中
    <br><br>
    2.a为行内元素，设置display：inline-block 才可以用padding margin去撑大父类</h4>

<div class="wrapper">
    <a class="btn">点我</a>
</div>

<h4>
    1.块级元素（独占一行）水平居中，设定宽度，在使用margin：0px auto;
    <br><br>
    2.text-align: center 可以使得里面的元素水平居中；
</h4>

<div class="wrapper2">
    <div class="spanlist">
        <span class="span1">想要水平居中</span>
    </div>
</div>

<h4>
    1.vertical-align:middle 实现单行图片居中
</h4>

<div style="text-align: center;">
    <div class="wrapper3">
        <img src="../../png/Network_port.png">
    </div>
</div>

<p class="p1">
    <img src="../../png/x1.png">
    <span>x</span>
</p>

</body>
</html>
