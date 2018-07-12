<%--
  Created by IntelliJ IDEA.
  User: mjli
  Date: 2018/7/6
  Time: 14:20
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" pageEncoding="utf-8" isELIgnored="false" %>
<script type="text/javascript">
    $(function(){
        $("#pStatus").combobox({
            required:true,
            panelHeight:50,
            width:100,
        });
        $('#pDescription').textbox({
            prompt:"图片描述",
            iconAlign:'left',
            required:true,
        });
        $('#pFile').filebox({
            buttonText: '选择文件',
            buttonAlign: 'left',
            required:true,
        });

    });
</script>
    <form id="uploadForm" method="post" enctype="multipart/form-data" >
        <table style="text-align: center">
            <tr>
                <td>轮播图描述:</td>
                <td><input id="pDescription" name="pictureDescription" type="text"></td>
            </tr>
            <tr>
                <td>轮播图状态:</td>
                <td>
                    <select id="pStatus" name="pictureStatus">
                        <option  value="展示中">展示</option>
                        <option  value="不展示">不展示</option>
                    </select>
                </td>
            </tr>
            <tr>
                <td>请选择图片：</td>
                <td><input id="pFile" name="myFile" type="text"></td>
            </tr>
        </table>

    </form>