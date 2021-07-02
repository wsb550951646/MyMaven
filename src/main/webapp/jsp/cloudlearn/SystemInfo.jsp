<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>

    <style type="text/css">
        .info-container{
            padding: 24px 58px;
        }

        .container-with-border{
            position: absolute;
            left: 0px;
            top :0px;
            bottom: 0px;
            right: 0px;
            border:1px solid #ccccd1;
        }

        .info-title{
            color: #00a9e6;
        }

        .tbl-info-container{
            padding:10px 50px;
        }

        .tbl-info{
            margin:10px;
        }

        .version_view_label{
            width: 100px;
            padding:0px 5px;
            text-align: right;
        }

        .version_view_data{
            padding:0px 5px;
        }

        td{
            height: 30px;
        }

        *{
            font-size: 9pt;
            font-style: normal;
        }

    </style>

</head>
<body>
    <div class="info-container container-with-border">
        <div id="sw-info">
            <div class="info-title">
                设备信息
            </div>
            <div class="tbl-info-container">
                <table class="tbl-info">
                    <tr>
                        <td class="version_view_label">应用类型:</td>
                        <td class="version_view_data">集群</td>
                    </tr>

                    <tr>
                        <td class="version_view_label">应用描述:</td>
                        <td class="version_view_data">提供统一转码调度及管理服务</td>
                    </tr>

                    <tr>
                        <td class="version_view_label">WEB版本号:</td>
                        <td class="version_view_data">2.7.0.1</td>
                    </tr>

                    <tr>
                        <td class="version_view_label">设备序列号:</td>
                        <td class="version_view_data">468dc06b-18d4-05c9-9291-2a4228194b1f</td>
                    </tr>

                    <tr>
                        <td class="version_view_label">设备UUID:</td>
                        <td class="version_view_data">468DC06B-18D4-05C9-9291-2A4228194B1F</td>
                    </tr>
                </table>
            </div>
        </div>
    </div>
</body>
</html>
