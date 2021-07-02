<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <script type="text/javascript" src="../../jquery/jquery-3.1.1.js"></script>
    <script type="text/javascript" src="../../jquery/jquery-3.1.1.min.js"></script>
    <script>

    </script>
    <style type="text/css" >
        body{
            margin:0;
            padding:0;
            min-width:600px;
        }
        .main{
            float:left;
            width:100%;
        }
        .main_body{
            margin:0 210px;
            background:#888;
            height:200px;
        }
        .left,.right{
            float:left;
            width:200px;
            height:200px;
            background:#F60;
        }
        .left{
            margin-left:-100%;
        }
        .right{
            margin-left:-200px;
        }
        #test{
            width:200px;
            height:200px;
            background:#F60;
            position:absolute;
            left:50%;
            top:50%;
            margin-left:-100px;
            margin-top:-100px;
        }

        #box {
            width: 50%;
            margin-bottom: -25px;
            background-color: rgba(90, 243, 151, 0.8);
            height: 50px;
        }

        h1{font-size:16px;font-family:Arial;}
        .separate{border-collapse:separate;border-spacing:10px 20px}
        .collapse{border-collapse:collapse;border-spacing:10px 20px}
    </style>
</head>
<body>


<div class="main">
    <div class="main_body">Main</div>
</div>
<div class="left">Left</div>
<div class="right">Right</div>

<div id="test"></div>

<div id="box">
    box
</div>


<h1>separate: 边框独立</h1>
<table border="1" class="separate">
    <tbody>
    <tr>
        <td>独立边框</td>
        <td>独立边框</td>
        <td>独立边框</td>
    </tr>
    <tr>
        <td>独立边框</td>
        <td>独立边框</td>
        <td>独立边框</td>
    </tr>
    </tbody>
</table>

<h1>collapse: 相邻边被合并</h1>
<table border="1" class="collapse">
    <tbody>
    <tr>
        <td>合并边框</td>
        <td>合并边框</td>
        <td>合并边框</td>
    </tr>
    <tr>
        <td>合并边框</td>
        <td>合并边框</td>
        <td>合并边框</td>
    </tr>
    </tbody>
</table>



</body>
</html>
