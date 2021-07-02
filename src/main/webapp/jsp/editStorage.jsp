<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<div class="editor_storage_tab Hide">
    <table class="tabl-list">
        <tr>
            <td>类型:</td>
            <td>
                <select name="storage.type">
                    <s:iterator value="SupportedMountTypes" var="var">
                        <option value="<s:property value='#var.value' />"><s:property value='#var.key'/></option>
                    </s:iterator>
                </select>
            </td>
        </tr>
        <tr>
            <td></td>
            <td class="error" name="storage.type"></td>
        </tr>

        <tr>
            <td>远程路径:</td>
            <td>
                <input value="" name="storage.path"/>
            </td>
        </tr>
        <tr>
            <td></td>
            <td class="error" name="storage.path">
        </tr>

        <tr>
            <td>名称:</td>
            <td>
                <input value="" name="storage.name" />
            </td>
        </tr>
        <tr>
            <td></td>
            <td class="error" name="storage.name"></td>
        </tr>

        <tr>
            <td>用户名称：</td>
            <td>
                <input value="" name="storage.user" />
            </td>
        </tr>
        <tr>
            <td></td>
            <td class="error" name="storage.user"></td>
        </tr>

        <tr>
            <td>密码：</td>
            <td>
                <input value="" type="password" name="storage.pwd"/>
            </td>
        </tr>
        <tr>
            <td></td>
            <td class="error" name="storage.pwd"></td>
        </tr>

        <tr>
            <td>挂载参数：</td>
            <td>
                <input value="" name="storage.options"/>
            </td>
        </tr>
        <tr>
            <td></td>
            <td class="error" name="storage.options"></td>
        </tr>

    </table>

    <div class="template_button">
        <div class="div_space"></div>
        <div class="div_buttons">
            <tr>
                <td> <input id="editor_btnOk" class="td_buttons" type="button" value="OK"> </td>
                <td class="td_space"></td>
                <td> <input id="editor_btnCancel" class="td_buttons" type="button" value="Cancel"></td>
            </tr>
        </div>
    </div>






</div>