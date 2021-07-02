<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Css 各种布局样式 表格样式总结—1</title>

    <style type="text/css">

        #container1{
            position:absolute;
            top:0px;
            left: 0px;
            right: 0px;
            bottom: 0px;

            width: 100%;
            height: 90%;
            margin: 20px 50px ;
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

        div#main{
            position: absolute;
            overflow: hidden;
            border: 1px solid #ccccd1;
            top: 30px;
            left: 0px;
            bottom: 0px;
            right: 0px;
            width: 80%;
        }

        div.contentTabList{
            float:left;
            background:#e8e8e8;
            width: 240px;
            height: 100%;
        }

        div.contentTabList div.Tab{
            border-bottom: 1px solid #ccccd1;
            padding: 10px 20px;
        }

        div.contentTabList div.Tabactive{
            background: #FFFFFF;
        }

        div.Tab img{
            float: left;
        }

        div.main-content{
            float:left;
            margin-top: 30px;
            margin-left: 50px;
            margin-right:50px;
            margin-bottom: -1000px;
            padding-bottom: 1000px;

        }

        .tab_table td.tab_label{
            text-align: right;
            width: 110px;
            pading:10px;
        }

        .tab_table td.tab_val{
            width: 200px;
            padding:0px 5px;
        }

        td.tab_val > select{
            width: 150px;
            padding:0px 5px;
        }

        td.tab_val > input{
            width: 150px;
            padding:0px 5px;
        }

        .submitBtn{

            width: 100px;
            margin: 20px;
        }

    </style>



</head>
<body>

    <!-- 带导航标签的左右布局 -->
    <div id="container1">
        <div class="secondNavigation">
            <div class="secondNavigationPanel">
                <div class="secondClassNav ">标签1</div>
                <div class="secondClassNav ">标签2</div>
                <div class="secondClassNav ">标签3</div>
                <div class="secondClassNav ">标签4</div>
                <div class="secondClassNav last"></div>
            </div>
        </div>

        <div id="main">

            <div class="contentTabList">
                <div class="Tab Tabactive">
                    <img src="../../../png/Network_port.png">
                    <div>eth0</div>
                    <div>
                        <span class="useRate">0.01%</span>
                    </div>
                </div>

                <div class="Tab">
                    <img src="../../../png/Network_port_disconnect.png">
                    <div>eth1</div>
                    <div>
                        <span class="useRate">0.11%</span>
                    </div>
                </div>

                <div class="Tab">
                    <img src="../../../png/Network_port_disconnect.png">
                    <div>eth2</div>
                    <div>
                        <span class="useRate">0.31%</span>
                    </div>
                </div>

                <div class="Tab">
                    <img src="../../../png/Network_port.png">
                    <div>eth3</div>
                    <div>
                        <span class="useRate">0.21%</span>
                    </div>
                </div>

            </div>

            <div class="main-content">
                <table class="tab_table">
                    <tr>
                        <td class="tab_label">名称1:</td>
                        <td class="tab_val">
                            <input type="text" value="">
                        </td>
                    </tr>
                    <tr>
                        <td class="tab_label">名称2:</td>
                        <td class="tab_val">
                            <select>
                                <option>1</option>
                                <option>2</option>
                                <option>3</option>
                            </select>
                        </td>
                    </tr>
                    <tr>
                        <td class="tab_label">名称3:</td>
                        <td class="tab_val">
                            <input type="text" value="">
                        </td>
                    </tr>
                    <tr>
                        <td class="tab_label">名称4:</td>
                        <td class="tab_val">
                            <select>
                                <option>1</option>
                                <option>2</option>
                                <option>3</option>
                            </select>
                        </td>
                    </tr>
                </table>

                <div style="width: 400px; text-align: center">
                    <input type="button" class="submitBtn" value="提交">
                </div>
            </div>

            <div class="main-content">
                <table class="tab_table">
                    <tr>
                        <td class="tab_label">名称1:</td>
                        <td class="tab_val">
                            <input type="text" value="">
                        </td>
                    </tr>
                    <tr>
                        <td class="tab_label">名称2:</td>
                        <td class="tab_val">
                            <select>
                                <option>1</option>
                                <option>2</option>
                                <option>3</option>
                            </select>
                        </td>
                    </tr>
                    <tr>
                        <td class="tab_label">名称3:</td>
                        <td class="tab_val">
                            <input type="text" value="">
                        </td>
                    </tr>
                    <tr>
                        <td class="tab_label">名称4:</td>
                        <td class="tab_val">
                            <select>
                                <option>1</option>
                                <option>2</option>
                                <option>3</option>
                            </select>
                        </td>
                    </tr>
                </table>

                <div style="width: 400px; text-align: center">
                    <input type="button" class="submitBtn" value="提交">
                </div>

            </div>

            <div class="main-content">
                <table class="tab_table">
                    <tr>
                        <td class="tab_label">名称1:</td>
                        <td class="tab_val">
                            <input type="text" value="">
                        </td>
                    </tr>
                    <tr>
                        <td class="tab_label">名称2:</td>
                        <td class="tab_val">
                            <select>
                                <option>1</option>
                                <option>2</option>
                                <option>3</option>
                            </select>
                        </td>
                    </tr>
                    <tr>
                        <td class="tab_label">名称3:</td>
                        <td class="tab_val">
                            <input type="text" value="">
                        </td>
                    </tr>
                    <tr>
                        <td class="tab_label">名称4:</td>
                        <td class="tab_val">
                            <select>
                                <option>1</option>
                                <option>2</option>
                                <option>3</option>
                            </select>
                        </td>
                    </tr>
                </table>

                <div style="width: 400px; text-align: center">
                    <input type="button" class="submitBtn" value="提交">
                </div>

            </div>

            <div class="main-content">
                <table class="tab_table">
                    <tr>
                        <td class="tab_label">名称1:</td>
                        <td class="tab_val">
                            <input type="text" value="">
                        </td>
                    </tr>
                    <tr>
                        <td class="tab_label">名称2:</td>
                        <td class="tab_val">
                            <select>
                                <option>1</option>
                                <option>2</option>
                                <option>3</option>
                            </select>
                        </td>
                    </tr>
                    <tr>
                        <td class="tab_label">名称3:</td>
                        <td class="tab_val">
                            <input type="text" value="">
                        </td>
                    </tr>
                    <tr>
                        <td class="tab_label">名称4:</td>
                        <td class="tab_val">
                            <select>
                                <option>1</option>
                                <option>2</option>
                                <option>3</option>
                            </select>
                        </td>
                    </tr>
                </table>

                <div style="width: 400px; text-align: center">
                    <input type="button" class="submitBtn" value="提交">
                </div>

            </div>

            <div class="main-content">
                <table class="tab_table">
                    <tr>
                        <td class="tab_label">名称1:</td>
                        <td class="tab_val">
                            <input type="text" value="">
                        </td>
                    </tr>
                    <tr>
                        <td class="tab_label">名称2:</td>
                        <td class="tab_val">
                            <select>
                                <option>1</option>
                                <option>2</option>
                                <option>3</option>
                            </select>
                        </td>
                    </tr>
                    <tr>
                        <td class="tab_label">名称3:</td>
                        <td class="tab_val">
                            <input type="text" value="">
                        </td>
                    </tr>
                    <tr>
                        <td class="tab_label">名称4:</td>
                        <td class="tab_val">
                            <select>
                                <option>1</option>
                                <option>2</option>
                                <option>3</option>
                            </select>
                        </td>
                    </tr>
                </table>

                <div style="width: 400px; text-align: center">
                    <input type="button" class="submitBtn" value="提交">
                </div>

            </div>

            <div class="main-content">
                <table class="tab_table">
                    <tr>
                        <td class="tab_label">名称1:</td>
                        <td class="tab_val">
                            <input type="text" value="">
                        </td>
                    </tr>
                    <tr>
                        <td class="tab_label">名称2:</td>
                        <td class="tab_val">
                            <select>
                                <option>1</option>
                                <option>2</option>
                                <option>3</option>
                            </select>
                        </td>
                    </tr>
                    <tr>
                        <td class="tab_label">名称3:</td>
                        <td class="tab_val">
                            <input type="text" value="">
                        </td>
                    </tr>
                    <tr>
                        <td class="tab_label">名称4:</td>
                        <td class="tab_val">
                            <select>
                                <option>1</option>
                                <option>2</option>
                                <option>3</option>
                            </select>
                        </td>
                    </tr>
                </table>

                <div style="width: 400px; text-align: center">
                    <input type="button" class="submitBtn" value="提交">
                </div>

            </div>

            <div class="main-content">
                <table class="tab_table">
                    <tr>
                        <td class="tab_label">名称1:</td>
                        <td class="tab_val">
                            <input type="text" value="">
                        </td>
                    </tr>
                    <tr>
                        <td class="tab_label">名称2:</td>
                        <td class="tab_val">
                            <select>
                                <option>1</option>
                                <option>2</option>
                                <option>3</option>
                            </select>
                        </td>
                    </tr>
                    <tr>
                        <td class="tab_label">名称3:</td>
                        <td class="tab_val">
                            <input type="text" value="">
                        </td>
                    </tr>
                    <tr>
                        <td class="tab_label">名称4:</td>
                        <td class="tab_val">
                            <select>
                                <option>1</option>
                                <option>2</option>
                                <option>3</option>
                            </select>
                        </td>
                    </tr>
                </table>

                <div style="width: 400px; text-align: center">
                    <input type="button" class="submitBtn" value="提交">
                </div>

            </div>

            <div class="main-content">
                <table class="tab_table">
                    <tr>
                        <td class="tab_label">名称1:</td>
                        <td class="tab_val">
                            <input type="text" value="">
                        </td>
                    </tr>
                    <tr>
                        <td class="tab_label">名称2:</td>
                        <td class="tab_val">
                            <select>
                                <option>1</option>
                                <option>2</option>
                                <option>3</option>
                            </select>
                        </td>
                    </tr>
                    <tr>
                        <td class="tab_label">名称3:</td>
                        <td class="tab_val">
                            <input type="text" value="">
                        </td>
                    </tr>
                    <tr>
                        <td class="tab_label">名称4:</td>
                        <td class="tab_val">
                            <select>
                                <option>1</option>
                                <option>2</option>
                                <option>3</option>
                            </select>
                        </td>
                    </tr>
                </table>

                <div style="width: 400px; text-align: center">
                    <input type="button" class="submitBtn" value="提交">
                </div>

            </div>



        </div>

    </div>


</body>
</html>
