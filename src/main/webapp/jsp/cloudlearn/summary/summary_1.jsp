<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Css 各种布局样式 表格样式总结—1</title>

    <style type="text/css">

        #container1{
            width: 100%;
            height: 50px;
            display: block;
        }

        *{
            font-size: 9pt;
            font-style: normal;
        }

        div#second-nav-menu-bar{

        }

        div.second-nav-menu{
            float: left;
            display: inline-block;
            width: 110px;
            height: 30px;
            line-height: 30px;
            text-align: center;
            border-left: 1px solid #ccccd1;
            border-top: 1px solid #ccccd1;
            border-bottom: 1px solid #ccccd1;
            background-color: #f7f7f7;
            cursor: pointer;
        }

        div#second-nav-menu-bar div.last{
            background-color: #FFFFFF;
            border-top: #FFFFFF;
            border-bottom: #FFFFFF;
        }

        div#second-nav-menu-bar div.active{
            border-bottom: 1px solid #FFFFFF;
            background-color: #FFFFFF;
            color: #00bbff;
        }

        .clear{
            clear: both;
        }

        .second-nav-bar-hr{
            border-top: 1px solid #ccccd1;
            margin-top: -1px;
        }

        div#container2{
            width: 100%;
            height: 40px;
        }

        div.firstNavigation{
            display: block;

        }

        div.firstNavigationPanel{

        }

        div.firstNavigationPanel div.firstClassNav{
            height: 24px;
            line-height: 24px;
            width: auto;
            float: left;
            text-align: center;
            padding: 0px 10px;
            display: inline-block;
            font-size: 11pt;
        }

        div.firstNavigationPanel div.active{
            background-color: #00bbff;
            color: white;
        }

        div#container3{
            position: absolute;
            top:100px;
            left: 20px;
            right: 0px;
            bottom: 0px;
            width: 100%;
        }


        div.secondNavigation{
            display: block;

        }

        div.secondNavigationPanel{

        }

        div.secondNavigationPanel div.secondClassNav{
            float: left;
            display: inline-block;
            width: 110px;
            height: 30px;
            line-height: 30px;
            text-align: center;
            border-left: 1px solid #ccccd1;
            border-top: 1px solid #ccccd1;
            border-bottom: 1px solid #ccccd1;
            background-color: #f7f7f7;
            cursor: pointer;
        }

        div.secondNavigationPanel div.last{
            background-color: #FFFFFF;
            border-top: #FFFFFF;
            border-bottom: #FFFFFF;
        }

        div.secondNavigationPanel div.active{
            border-bottom: 1px solid #FFFFFF;
            background-color: #FFFFFF;
            color: #00bbff;
        }

        div#main-content{
            position: absolute;
            width: 80%;
            height: 50%;
            top:30px;
            left: 0px;
            right: 18px;
            bottom: 20px;
            border:1px solid #e2e2e5;
            overflow: auto;
        }

        .tbl-header-list{
            table-layout: fixed;
            border-collapse: collapse;
            width: 100%;
        }

        .td_name1,.td_name2{
            width: 300px;
        }

        .td_name3{
            width: 100px;
        }


        .td_button{
            width: 250px;
        }


        td{
            height: 35px;
        }

        tr.setting-tbl-header{
            background-color: #f5f6fa;
        }

        tr.tbl-header,.tbl-header td,.tbl-content td,.tbl-content2 td {
            border-top: 1px solid #e2e2e5;
            border-right:1px solid #e2e2e5;
            border-bottom:1px solid #e2e2e5;
            padding:0px 10px;
        }

        .tbl-list{
            width: 100%;
            border-collapse: collapse;
        }

        div#container4{
            position: absolute;
            top:65%;
            left: 20px;
            right: 0px;
            bottom: 0px;
            width: 100%;
        }

        div.main-content2{
            position: absolute;
            top: 30px;
            left: 0px;
            right: 0px;
            bottom: 0px;
            width:80%;
        }

        div.tbl-static-header{

            position: absolute;
            top: 0px;
            left: 0px;
            right: 0px;
            bottom: 0px;
            border-top:1px solid #e2e2e5;
            border-left: 1px solid #E2E2E5;
            border-bottom: 1px solid #E2E2E5;
        }

        div.tbl-list2{
            position: absolute;
            top: 35px;
            left: 0px;
            right: 0px;
            bottom: 0px;
            width: 100%;
            overflow: auto;

        }

        .tbl-content2{
            width: 100%;
            border-collapse: collapse;
            table-layout: fixed;
        }



    </style>

</head>
<body>
    <!-- 导航头 -->
    <div id="container1">
        <div id="second-nav-menu-bar">
            <div class="second-nav-menu active">导航标签头1</div>
            <div class="second-nav-menu">导航标签头2</div>
            <div class="second-nav-menu">导航标签头3</div>
            <div class="second-nav-menu">导航标签头4</div>
            <div class="second-nav-menu last"></div>
            <div class="clear"></div>
            <hr class="second-nav-bar-hr">
        </div>
    </div>

    <!-- 选择列表 -->
    <div id="container2">
        <div class="firstNavigation">
            <div class="firstNavigationPanel">
                <div class="firstClassNav active">选择列表1</div>
                <div class="firstClassNav ">选择列表2</div>
                <div class="firstClassNav ">选择列表3</div>
                <div class="firstClassNav ">选择列表4</div>
                <div class="firstClassNav ">选择列表5</div>
                <div class="firstClassNav ">选择列表6</div>
                <div class="firstClassNav ">选择列表6</div>
            </div>
        </div>
    </div>

    <!-- 带导航的Table表格 -->
    <div id="container3">
        <div class="secondNavigation">
            <div class="secondNavigationPanel">
                <div class="secondClassNav active">导航栏选择1</div>
                <div class="secondClassNav">导航栏选择2</div>
                <div class="secondClassNav last"></div>
                <div class="clear"></div>
            </div>
        </div>

        <div id="main-content">
            <table class="tbl-header-list">
                <tbody>
                    <tr class="tbl-header setting-tbl-header">
                        <td class="td_name1">表头1</td>
                        <td class="td_name2">表头2</td>
                        <td class="td_name3">表头3</td>
                        <td class="td_name4">表头4</td>
                        <td class="td_button"></td>
                    </tr>
                </tbody>
            </table>

            <div class="">
                <table class="tbl-list">
                    <tbody>
                        <tr class="tbl-content">
                            <td class="td_name1">内容1</td>
                            <td class="td_name2">内容2</td>
                            <td class="td_name3">内容3</td>
                            <td class="td_name4">内容4</td>
                            <td class="td_button">
                                <a href="">delete</a>
                                <a href="">edit</a>
                            </td>
                        </tr>
                    </tbody>
                </table>
            </div>

            <div class="">
                <table class="tbl-list">
                    <tbody>
                    <tr class="tbl-content">
                        <td class="td_name1">内容1</td>
                        <td class="td_name2">内容2</td>
                        <td class="td_name3">内容3</td>
                        <td class="td_name4">内容4</td>
                        <td class="td_button">
                            <a href="">delete</a>
                            <a href="">edit</a>
                        </td>
                    </tr>
                    </tbody>
                </table>
            </div>

            <div class="">
                <table class="tbl-list">
                    <tbody>
                    <tr class="tbl-content">
                        <td class="td_name1">内容1</td>
                        <td class="td_name2">内容2</td>
                        <td class="td_name3">内容3</td>
                        <td class="td_name4">内容4</td>
                        <td class="td_button">
                            <a href="">delete</a>
                            <a href="">edit</a>
                        </td>
                    </tr>
                    </tbody>
                </table>
            </div>

            <div class="">
                <table class="tbl-list">
                    <tbody>
                    <tr class="tbl-content">
                        <td class="td_name1">内容1</td>
                        <td class="td_name2">内容2</td>
                        <td class="td_name3">内容3</td>
                        <td class="td_name4">内容4</td>
                        <td class="td_button">
                            <a href="">delete</a>
                            <a href="">edit</a>
                        </td>
                    </tr>
                    </tbody>
                </table>
            </div>

            <div class="">
                <table class="tbl-list">
                    <tbody>
                    <tr class="tbl-content">
                        <td class="td_name1">内容1</td>
                        <td class="td_name2">内容2</td>
                        <td class="td_name3">内容3</td>
                        <td class="td_name4">内容4</td>
                        <td class="td_button">
                            <a href="">delete</a>
                            <a href="">edit</a>
                        </td>
                    </tr>
                    </tbody>
                </table>
            </div>

            <div class="">
                <table class="tbl-list">
                    <tbody>
                    <tr class="tbl-content">
                        <td class="td_name1">内容1</td>
                        <td class="td_name2">内容2</td>
                        <td class="td_name3">内容3</td>
                        <td class="td_name4">内容4</td>
                        <td class="td_button">
                            <a href="">delete</a>
                            <a href="">edit</a>
                        </td>
                    </tr>
                    </tbody>
                </table>
            </div>

            <div class="">
                <table class="tbl-list">
                    <tbody>
                    <tr class="tbl-content">
                        <td class="td_name1">内容1</td>
                        <td class="td_name2">内容2</td>
                        <td class="td_name3">内容3</td>
                        <td class="td_name4">内容4</td>
                        <td class="td_button">
                            <a href="">delete</a>
                            <a href="">edit</a>
                        </td>
                    </tr>
                    </tbody>
                </table>
            </div>

            <div class="">
                <table class="tbl-list">
                    <tbody>
                    <tr class="tbl-content">
                        <td class="td_name1">内容1</td>
                        <td class="td_name2">内容2</td>
                        <td class="td_name3">内容3</td>
                        <td class="td_name4">内容4</td>
                        <td class="td_button">
                            <a href="">delete</a>
                            <a href="">edit</a>
                        </td>
                    </tr>
                    </tbody>
                </table>
            </div>


        </div>

    </div>

    <!-- 带导航的Table表格 表头固定-->
    <div id="container4">
        <div class="secondNavigation">
            <div class="secondNavigationPanel">
                <div class="secondClassNav active">导航栏目1</div>
                <div class="secondClassNav">导航栏目2</div>
                <div class="secondClassNav last"></div>
                <div class="clear"></div>
            </div>
        </div>

        <div class="main-content2">
            <div class="tbl-static-header">
                <table class="tbl-header-list">
                    <tbody>
                    <tr class="tbl-header setting-tbl-header">
                        <td class="td_name1">表头1</td>
                        <td class="td_name2">表头2</td>
                        <td class="td_name3">表头3</td>
                        <td class="td_name4">表头4</td>
                    </tr>
                    </tbody>
                </table>
            </div>

            <div class="tbl-list2">
            <table class="tbl-content2">
                <tbody>

                <tr>
                    <td class="td_name1">内容1</td>
                    <td class="td_name2">内容2</td>
                    <td class="td_name3">内容3</td>
                    <td class="td_name4">内容4</td>
                    <td class="td_button">
                        <a href="">delete</a>
                        <a href="">edit</a>
                    </td>
                </tr>

                <tr>
                    <td class="td_name1">内容1</td>
                    <td class="td_name2">内容2</td>
                    <td class="td_name3">内容3</td>
                    <td class="td_name4">内容4</td>
                    <td class="td_button">
                        <a href="">delete</a>
                        <a href="">edit</a>
                    </td>
                </tr>

                <tr>
                    <td class="td_name1">内容1</td>
                    <td class="td_name2">内容2</td>
                    <td class="td_name3">内容3</td>
                    <td class="td_name4">内容4</td>
                    <td class="td_button">
                        <a href="">delete</a>
                        <a href="">edit</a>
                    </td>
                </tr>

                <tr>
                    <td class="td_name1">内容1</td>
                    <td class="td_name2">内容2</td>
                    <td class="td_name3">内容3</td>
                    <td class="td_name4">内容4</td>
                    <td class="td_button">
                        <a href="">delete</a>
                        <a href="">edit</a>
                    </td>
                </tr>



                <tr>
                    <td class="td_name1">内容1</td>
                    <td class="td_name2">内容2</td>
                    <td class="td_name3">内容3</td>
                    <td class="td_name4">内容4</td>
                    <td class="td_button">
                        <a href="">delete</a>
                        <a href="">edit</a>
                    </td>
                </tr>




                </tbody>
            </table>
            </div>

        </div>

    </div>


</body>
</html>
