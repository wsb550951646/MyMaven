<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>

    <style type="text/css">
        div.router{
            margin:20px 20px;
        }

        div.main_router{
            position: absolute;
            overflow-y: auto;
            top:50px;
            left: 20px;
            right: 0px;
            bottom: 0px;
        }

        table{
            padding: 0px;
            margin: 0px;
            border: 0px;
            width: 100%;
            empty-cells: show;
            border-collapse: collapse;
        }

        table.tbl-header-list{
            width: 100%;
        }

        .setting-tbl-header{
            background-color: #f7f7f7;
        }


        tr.tbl-header > td, .tbl-content td{
            border: 1px solid #e2e2e5;
            padding:0px 10px;
        }

        div.main_router_contents{
            position: absolute;
            overflow-y: auto;
            top: 30px;
            left: 0px;
            right: 0px;
            bottom: 0px;
        }

        .tbl-list{
            width: 100%;
        }

        .td_dest,.td_gateway,.td_mask{
            width: 100px;
        }

        .td_flags,.td_metric,.td_ref,.td_use{
            width:50px;
        }

        .td_action{
            width: 40px;
        }

        a.deleteBtn {
            width:40px;
            height:40px;
            display: block;
            background: url(../../png/delet_n.png) no-repeat scroll 0px 0px;
        }

        div.line-placeholder{
            height: 43px;
        }

    </style>

</head>
<body>
    <div class="router">
        <div id="secondNavigation">
            <div id="secondNavigationPanel">
                <div href="" class="secondClassNav">
                    IPv4 路由表
                </div>
                <div href="" class="secondClassNav secondClassNavActive">
                    IPv6 路由表
                </div>
                <div href="" class="secondClassNav last">

                </div>
            </div>
        </div>
    </div>
    <!-- 固定表头的表格， 使用个absolute的div，分别嵌套表头和内容。 然后内容在使用overflow，达到下拉效果。 -->
    <div class="main_router">
        <div class="">
            <table class="tbl-header-list">
                <tbody>
                    <tr class="tbl-header setting-tbl-header">
                        <td class="td_dest">目标</td>
                        <td class="td_gateway">网关</td>
                        <td class="td_mask">子网掩码</td>
                        <td class="td_flags">Flags</td>
                        <td class="td_metric">Metric</td>
                        <td class="td_ref" >Ref</td>
                        <td class="td_use">Use</td>
                        <td class="td_iface">网口</td>
                    </tr>
                </tbody>
            </table>
        </div>

        <div class="main_router_contents">
            <table class="tbl-list">
                <tbody>
                    <tr class="tbl-content">
                        <td class="td_dest" id="dest_1">169.254.0.0</td>
                        <td class="td_gateway" id="gateway_1">0.0.0.0</td>
                        <td class="td_mask" id="mask_1">255.255.0.0</td>
                        <td class="td_flags" id="flags_1">U</td>
                        <td class="td_metric" id="metric_1">1002</td>
                        <td class="td_ref" id="use_1">0</td>
                        <td class="td_use" id="ref_1">0</td>
                        <td class="td_iface" id="iface_1">eth0</td>
                        <td class="td_action"><a class="deleteBtn tbl-action" index="1"></a></td>
                    </tr>

                    <tr class="tbl-content">
                        <td class="td_dest" >169.254.0.0</td>
                        <td class="td_gateway" >0.0.0.0</td>
                        <td class="td_mask" >255.255.0.0</td>
                        <td class="td_flags" >U</td>
                        <td class="td_metric" >1002</td>
                        <td class="td_ref" >0</td>
                        <td class="td_use" >0</td>
                        <td class="td_iface" >eth0</td>
                        <td class="td_action"><a class="deleteBtn tbl-action" index="1"></a></td>
                    </tr>

                    <tr class="tbl-content">
                        <td class="td_dest" >169.254.0.0</td>
                        <td class="td_gateway" >0.0.0.0</td>
                        <td class="td_mask" >255.255.0.0</td>
                        <td class="td_flags" >U</td>
                        <td class="td_metric" >1002</td>
                        <td class="td_ref" >0</td>
                        <td class="td_use" >0</td>
                        <td class="td_iface" >eth0</td>
                        <td class="td_action"><a class="deleteBtn tbl-action" index="1"></a></td>
                    </tr>

                    <tr class="tbl-content">
                        <td class="td_dest" >169.254.0.0</td>
                        <td class="td_gateway" >0.0.0.0</td>
                        <td class="td_mask" >255.255.0.0</td>
                        <td class="td_flags" >U</td>
                        <td class="td_metric" >1002</td>
                        <td class="td_ref" >0</td>
                        <td class="td_use" >0</td>
                        <td class="td_iface" >eth0</td>
                        <td class="td_action"><a class="deleteBtn tbl-action" index="1"></a></td>
                    </tr>

                    <tr class="tbl-content">
                        <td class="td_dest" >169.254.0.0</td>
                        <td class="td_gateway" >0.0.0.0</td>
                        <td class="td_mask" >255.255.0.0</td>
                        <td class="td_flags" >U</td>
                        <td class="td_metric" >1002</td>
                        <td class="td_ref" >0</td>
                        <td class="td_use" >0</td>
                        <td class="td_iface" >eth0</td>
                        <td class="td_action"><a class="deleteBtn tbl-action" index="1"></a></td>
                    </tr>

                    <tr class="tbl-content">
                        <td class="td_dest" >169.254.0.0</td>
                        <td class="td_gateway" >0.0.0.0</td>
                        <td class="td_mask" >255.255.0.0</td>
                        <td class="td_flags" >U</td>
                        <td class="td_metric" >1002</td>
                        <td class="td_ref" >0</td>
                        <td class="td_use" >0</td>
                        <td class="td_iface" >eth0</td>
                        <td class="td_action"><a class="deleteBtn tbl-action" index="1"></a></td>
                    </tr>

                    <tr class="tbl-content">
                        <td class="td_dest" >169.254.0.0</td>
                        <td class="td_gateway" >0.0.0.0</td>
                        <td class="td_mask" >255.255.0.0</td>
                        <td class="td_flags" >U</td>
                        <td class="td_metric" >1002</td>
                        <td class="td_ref" >0</td>
                        <td class="td_use" >0</td>
                        <td class="td_iface" >eth0</td>
                        <td class="td_action"><a class="deleteBtn tbl-action" index="1"></a></td>
                    </tr>
                    <tr class="tbl-content">
                        <td class="td_dest" >169.254.0.0</td>
                        <td class="td_gateway" >0.0.0.0</td>
                        <td class="td_mask" >255.255.0.0</td>
                        <td class="td_flags" >U</td>
                        <td class="td_metric" >1002</td>
                        <td class="td_ref" >0</td>
                        <td class="td_use" >0</td>
                        <td class="td_iface" >eth0</td>
                        <td class="td_action"><a class="deleteBtn tbl-action" index="1"></a></td>
                    </tr>
                    <tr class="tbl-content">
                        <td class="td_dest" >169.254.0.0</td>
                        <td class="td_gateway" >0.0.0.0</td>
                        <td class="td_mask" >255.255.0.0</td>
                        <td class="td_flags" >U</td>
                        <td class="td_metric" >1002</td>
                        <td class="td_ref" >0</td>
                        <td class="td_use" >0</td>
                        <td class="td_iface" >eth0</td>
                        <td class="td_action"><a class="deleteBtn tbl-action" index="1"></a></td>
                    </tr>
                </tbody>
            </table>

            <div class="line-placeholder">
            </div>

            <div>
                <table style="width:100%">
                    <tbody>
                    <tr>
                        <td>目标</td>
                        <td>网关</td>
                        <td>子网掩码</td>
                        <td>网口</td>
                    </tr>

                    <tr>
                        <td><input name="dest" type="text" value=""></td>
                        <td><input name="gate" type="text" value=""></td>
                        <td><input name="mask" type="text" value=""></td>
                        <td><input name="ipc" type="text" value=""></td>
                        <td><button type="button">添加</button></td>
                    </tr>
                    </tbody>
                </table>
            </div>

            <div class="line-placeholder">
            </div>

        </div>


    </div>
</body>
</html>
