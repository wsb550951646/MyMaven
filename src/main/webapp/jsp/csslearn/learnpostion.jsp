<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <script type="text/javascript" src="../../jquery/jquery-3.1.1.js"></script>
    <script type="text/javascript" src="../../jquery/jquery-3.1.1.min.js"></script>
    <script>

    </script>
    <style type="text/css" >
        .container{
            background-color: yellow;
            width: 400px;
            height: 400px;
        }

        .content{
            background-color: blue;
            width: 200px;
            height: 200px;
            position: static;
            left: 100px;
        }

        .containerRelative{
            background-color: green;
            width: 400px;
            height: 400px;
        }

        .contentRelative{
            background-color: black;
            width: 200px;
            height: 200px;
            position: relative;
            top: 100px;
            right: 100px;
        }

        .containerAbsolute{
            background-color: green;
            position: relative;
            width: 400px;
            height: 400px;
        }

        .contentAbsolute{
            background-color: black;
            width: 200px;
            height: 200px;
            position: absolute;
            top:100px;
            left: 100px;
        }

        .containerFix{
            background-color: green;
            width: 400px;
            height: 400px;
        }

        .contentFix{
            background-color: black;
            width: 200px;
            height: 200px;
            position: fixed;
        }




    </style>
</head>
<body>

    <div class="container">
        <div class="content"></div>
    </div>

    <br><br>

    <div class="containerRelative">
        <div class="contentRelative"></div>
    </div>

    <br><br>

    <div class="containerAbsolute">
        <div class="contentAbsolute"/></div>
    </div>

    <br><br>

    <div class="containerFix">
        <div class="contentFix"></div>
    </div>



</body>
</html>
