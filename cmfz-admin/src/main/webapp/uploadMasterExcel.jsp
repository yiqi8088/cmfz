<%--
  Created by IntelliJ IDEA.
  User: mjli
  Date: 2018/7/9
  Time: 20:04
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" isELIgnored="false" language="java" %>
<script type="text/javascript">
    $(function(){
        $('#fb').filebox({
            buttonText: '选择文件',
            buttonAlign: 'left',
            required:true,
        });

    });
</script>
<form id="uploadMasterExcel" method="post" enctype="multipart/form-data">
    <table style="padding-left: 70px;padding-top: 50px;">
        <tr>
            <td>请选择Excel：</td>
            <td><input id="fb" name="myFile" type="text"></td>
        </tr>
    </table>
</form>

