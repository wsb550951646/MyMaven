<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <script type="text/javascript" src="../../jquery/jquery-3.1.1.js"></script>
    <script type="text/javascript" src="../../jquery/jquery-3.1.1.min.js"></script>
    <script>

    </script>
    <style type="text/css" >

        .testclear1{
            float: right;
            width:400px;
            height:400px;
            background:#eee;
        }

        .testclear2{
            float: left;
            width:400px;
            height:400px;
            background: #eecfd0;
        }


        .testclear3{
            width:200px;
            height:200px;
            background: #232fee;
        }

        .testoverflow{
            overflow:scroll;
            width:400px;
            height:400px;
            background:#eee;
        }

        .testfloat{
            float:right;
            width: 400px;
            height:400px;
            background:#eee;
        }

    </style>
</head>
<body>

<div class="testclear">
    <div class="testclear2">
        我是float：left 出现在左边
    </div>
    <div class="testclear3">我是 clear 注意我出现的位置</div>

    <div class="testclear1">
        我是float：right 出现在右边
    </div>



</div>

<div class="testfloat">
    <table>
        <tr>
            <td>
                布局Layout：float （浮动）
            </td>
        </tr>
        <tr>
            <td>
                left：会出现在做左边，写在下面的div会出现在右边
            </td>
        </tr>
        <tr>
            <td>
                right: 会出现在右边
            </td>
        </tr>
        <tr>
            <td>
                none: 没有浮动布局，对象不浮动。下面div还是出现下面。
            </td>
        </tr>
    </table>
</div>

<div class="testoverflow">
    <table>
        <tr>
           <td>
               <p>overflow布局</p>
           </td>
        </tr>

        <tr>
            <td>
                <p>visible：不处理超出的内容</p>
            </td>
        </tr>

        <tr>
            <td>
                <p>hidden：隐藏超出内容</p>
            </td>
        </tr>

        <tr>
            <td>
                <p>scroll：超出内容变成滚动条</p>
            </td>
        </tr>
        <tr>
            <td>
                auto：在需要时剪切内容并添加滚动条，此为body对象和textarea的默认值。 1111111111111111111111111111
            </td>
        </tr>

        <tr>
            <td>
                <p>拓展</p>
            </td>
        </tr>

        <tr>
            <td>
                <p>overflow-x：则是只针对横向</p>
            </td>
        </tr>

        <tr>
            <td>
                <p>overflow-y：则针对纵向</p>
            </td>
        </tr>
    </table>
</div>

</body>
</html>
