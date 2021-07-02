<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>

    <style type="text/css">
        div.container-with-border{
            position: absolute;
            top: 0px;
            left: 0px;
            right: 0px;
            bottom: 0px;
        }

        div.info-container{

        }

        div#eth{
            height: 100%;

        }

        div#ethTabList{
            float: left;
            background: #e8e8e8;
            width: 187px;
            height: 100%;
        }

        div#ethTabList div.ethTab{
            border-bottom:1px solid #ccccd1;
            height: 32px;
            padding:8px 10px;
        }

        div#ethTabList div.ethTabActive{
            background-color: #FFFFFF;
        }

        div#ethTabList::after{
            content: "";
            visibility: hidden;
            clear:both;
            display: block;
        }

        div.ethContent{
            float:left;
            padding-top: 10px;
            padding-left:50px;

        }

        td.ethLabel{
            width: 100px;
            text-align: right;

        }

        td.ethVal{
            padding: 0px 10px;
            width: 100px;
            text-align: left;
        }

        div.ethTab img{
            float: left;
        }

    </style>

</head>
<body>
    <div class="container-with-border info-container">
        <div id="eth">
            <div id="ethTabList">
                <div class="ethTab ethTabActive">
                    <img src="../../png/Network_port.png">
                    <div>eht0</div>
                    <div>
                        <span class="">1.00%(1Mbps)</span>
                    </div>
                </div>

                <div class="ethTab">
                    <img src="../../png/Network_port.png">
                    <div>eht1</div>
                    <div>
                        <span class="">0.00%(0Mbps)</span>
                    </div>
                </div>

                <div class="ethTab">
                    <img src="../../png/Network_port_disconnect.png">
                    <div>eht3</div>
                    <div>
                        <span class="">4.00%(4Mbps)</span>
                    </div>
                </div>

            </div>

            <div class="ethContent" id="eth-0" index="0">
                <form id="saveEth" name="saveEth" action="/saveEth.action" method="post">
                    <input type="hidden" name="isLocal" value="true" id="saveEth_isLocal">
                    <input type="hidden" name="index" value="0" id="saveEth_index">
                    <input type="hidden" name="eths[0].id" value="eth0" id="saveEth_eths_0__id">

                    <table>
                            <tr>
                                <td class="ethLabel"><label>名称:</label></td>
                                <td class="ethVal">
                                    eth0
                                </td>
                            </tr>

                            <tr>
                                <td class="ethLabel"><label>网口绑定方式:</label></td>
                                <td class="ethVal">
                                    <select>
                                        <option>无</option>
                                        <option>主备冗余</option>
                                        <option>负载均衡</option>
                                        <option>链路聚合</option>
                                    </select>
                                </td>
                            </tr>

                            <tr>
                                <td class="ethLabel"><label>绑定网口:</label></td>
                                <td class="ethVal">
                                    <select>
                                        <option>无</option>
                                        <option>eth2</option>
                                        <option>eth3</option>
                                    </select>
                                </td>
                            </tr>
                    </table>

                    <table class="primary">

                    </table>

                    <table class="ipv4">
                                <tr>
                                    <td class="ethLabel">
                                        <label>IP设定方式:</label>
                                    </td>
                                    <td class="ethVal">
                                        <select>
                                            <option>DHCP动态分配</option>
                                            <option>手动设置</option>
                                            <option>禁用</option>
                                        </select>
                                    </td>
                                </tr>

                                <tr>
                                    <td class="ethLabel"><label>IP地址:</label></td>
                                    <td class="ethVal">
                                        <input name="" type="text" id=""  value="172.17.230.89">
                                    </td>
                                </tr>

                                <tr>
                                    <td class="ethLabel"><label>子网掩码:</label></td>
                                    <td class="ethVal">
                                        <input name="" type="text" id=""  value="255.255.0.0">
                                    </td>
                                </tr>

                                <tr>
                                    <td class="ethLabel"><label>网关:</label></td>
                                    <td class="ethVal">
                                        <input name="" type="text" id=""  value="172.17.228.1">
                                    </td>
                                </tr>
                    </table>

                    <table class="ipv6">
                        <tr>
                            <td class="ethLabel"><label>IPv6设定方式:</label></td>
                            <td class="ethVal">
                                <select>
                                    <option>SLAAC动态分配</option>
                                    <option>DHCP动态分配</option>
                                    <option>手动设置</option>
                                    <option>禁用</option>
                                </select>
                            </td>
                        </tr>

                        <tr>
                            <td class="ethLabel"><label>IPv6地址:</label></td>
                            <td class="ethVal">
                                <input name="" type="text" id=""  value="3001::ae1f:6bff:fe97:1682">
                            </td>
                        </tr>

                        <tr>
                            <td class="ethLabel"><label>IPv6前缀长度:</label></td>
                            <td class="ethVal">
                                <input name="" type="text" id=""  value="64">
                            </td>
                        </tr>

                        <tr>
                            <td class="ethLabel"><label>IPv6下一跳:</label></td>
                            <td class="ethVal">
                                <input name="" type="text" id=""  value="">
                            </td>
                        </tr>
                    </table>

                </form>
            </div>

        </div>
    </div>
</body>
</html>
