<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <script type="text/javascript" src="../../jquery/jquery-3.1.1.js"></script>
    <script type="text/javascript" src="../../jquery/jquery-3.1.1.min.js"></script>
    <script>

    </script>
    <style type="text/css" >
        .top{width:160px; height:50px; background:green;}

        .middle{width:160px; background:yellow;}

        .middle .firstChild{margin-top:20px;}

        body{ padding:0; margin:0; color:#f00;}
        .container{ margin:0 auto; width:600px; border:3px solid black;
            overflow:hidden; /*这个超出隐藏的声明在IE6里不写也是可以的*/
        }
        .left{ float:left; width:150px;
            padding-bottom:2000px;
            margin-bottom:-2000px;
        }
        .right{ float:right; width:450px;
            padding-bottom:2000px;
            margin-bottom:-2000px;
        }
    </style>
</head>
<body>

<div class="top"></div>

<div class="middle">

    <div class="firstChild">我其实只是想和我的父元素隔开点距离。</div>


    <div class="secondChild"></div>

</div>

<div class="container">
    <div class="left">
        我是left
        我是left
        我是left
        我是left
        我是left
        我是left

    </div>
    <div class="right">我是right<br><br><br>现在我的高度比left高，但left用它的padding-bottom补偿了这部分高度</div>
    <div style="clear:both"></div>
</div>



</body>
</html>
