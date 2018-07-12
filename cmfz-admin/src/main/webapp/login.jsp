<%@page pageEncoding="utf-8" contentType="text/html; utf-8" isELIgnored="false" %>
<%@taglib uri="http://java.sun.com/jstl/core" prefix="x"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
	<title>持名法州后台管理中心</title>

    <meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
    <meta http-equiv="description" content="this is my page">
    <meta http-equiv="content-type" content="text/html; charset=UTF-8">

	<link rel="icon" href="${pageContext.request.contextPath}/img/favicon.ico" type="image/x-icon"/>
	<link rel="stylesheet" href="${pageContext.request.contextPath}/css/common.css" type="text/css"></link>
	<link rel="stylesheet" href="${pageContext.request.contextPath}/css/login.css" type="text/css"></link>
	<link rel="stylesheet" type="text/css"
		  href="${pageContext.request.contextPath }/themes/default/easyui.css">
	<link rel="stylesheet" type="text/css"
		  href="${pageContext.request.contextPath }/themes/icon.css">
	<script type="text/javascript" src="${pageContext.request.contextPath}/script/jquery.js"></script>
	<script type="text/javascript" src="${pageContext.request.contextPath}/script/common.js"></script>
	<script type="text/javascript"
			src="${pageContext.request.contextPath }/js/jquery.easyui.min.js"></script>
	<script type="text/javascript"
			src="${pageContext.request.contextPath }/js/easyui-lang-zh_CN.js"></script>

        <script type="text/javascript">
	
		$(function(){
			//点击更换验证码：
			$("#captchaImage").click(function(){//点击更换验证码
                $("#captchaImage").attr("src", "${pageContext.request.contextPath}/admin/vCode");
			});

            $("#adminName").textbox({
                promote:"请输入用户名",
                iconCls: 'icon-man',
                iconAlign: "right",
                required: true,
            });
            $("#adminPwd").textbox({
				promote:"请输入密码",
                showEye: true,
                required: true,

            });
            $("#enCode").validatebox({
                required: true,
                message: "验证码不能为空"
            });
			//  form 表单提交

		});
	</script>
	<%-- 为coookie中的中文 解码  --%>
	<%
		String adminName = "";
		javax.servlet.http.Cookie cs[] = request.getCookies();
		for(javax.servlet.http.Cookie c:cs){
			if(c.getName().equals("adminName")){
				adminName = c.getValue();
				adminName = java.net.URLDecoder.decode(adminName,"utf-8");
			}
		}
	%>
</head>
<body>
	
		<div class="login">
			<form id="loginForm"  action="${pageContext.request.contextPath}/admin/verify" method="post" >
				
				<table>
					<tbody>
						<tr>
							<td width="190" rowspan="2" align="center" valign="bottom">
								<img src="/img/header_logo.gif" />
							</td>
							<th>
								用户名:
							</th>
							<td>
								<input id="adminName" type="text"  name="adminName" class="text" value="<%=adminName%>" maxlength="20"/>
							</td>
					  </tr>
					  <tr>
							<th>
								密&nbsp;&nbsp;&nbsp;码:
							</th>
							<td>
								<input id="adminPwd" type="password" name="adminPwd" class="text" value="" maxlength="20" autocomplete="off"/>
							</td>
					  </tr>
					
						<tr>
							<td>&nbsp;</td>
							<th>验证码:</th>
							<td>
								<input type="text" id="enCode" name="enCode" class="text captcha" maxlength="4" autocomplete="off"/>
								<img id="captchaImage" class="captchaImage" src="${pageContext.request.contextPath}/admin/vCode" title="点击更换验证码" />
							</td>
						</tr>					
					<tr>
						<td>
							&nbsp;
						</td>
						<th>
							&nbsp;
						</th>
						<td>
							<label>
								<input type="checkbox"name="checkbox" id="isRememberUsername" value="true"/> 记住用户名
							</label>
						</td>
					</tr>
						<tr>
							<td>
								&nbsp;
							</td>
							<th>
								&nbsp;
							</th>
							<td>
								<label>
									<input type="checkbox" name="checkbox" id="remeberMe"/> 七天免登陆
								</label>
							</td>
						</tr>
					<tr>
						<td>&nbsp;</td>
						<th>&nbsp;</th>
						<td>
							<input type="button" class="homeButton" value="" onclick="location.href='/'"><input type="submit" class="loginButton" value="登录">
						</td>
					</tr>
				</tbody></table>
				<div class="powered">COPYRIGHT © 2008-2017.</div>
				<div class="link">
					<a href="http://www.chimingfowang.com/">持名佛网首页</a> |
					<a href="http://www.chimingbbs.com/">交流论坛</a> |
					<a href="">关于我们</a> |
					<a href="">联系我们</a> |
					<a href="">授权查询</a>
				</div>
			</form>
		</div>
</body>
</html>