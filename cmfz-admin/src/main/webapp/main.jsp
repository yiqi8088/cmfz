<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8" isELIgnored="false" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>持名法州主页</title>
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/themes/default/easyui.css">
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/themes/IconExtension.css">
<script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery.min.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery.easyui.min.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/easyui-lang-zh_CN.js"></script>
	<script type="text/javascript" src="${pageContext.request.contextPath}/js/datagrid-detailview.js"></script>
<script type="text/javascript">
    function addTab(menuName) {
        var f = $("#tt").tabs("exists",menuName);
        if(f){
            $("#tt").tabs("select",menuName);
        }else{
			if(menuName == "轮播图1"){
				$("#tt").tabs("add",{
					title:menuName,
					href:"${pageContext.request.contextPath}/picture.jsp",
					closable:true,
                    fit:true,
				})
			}else if(menuName == "上师管理1"){
                $("#tt").tabs("add",{
                    title:menuName,
                    href:"${pageContext.request.contextPath}/master.jsp",
                    closable:true,
                    fit:true,
                })
            }else if(menuName == "文章管理"){
                $("#tt").tabs("add",{
                    title:menuName,
                    href:"${pageContext.request.contextPath}/article.jsp",
                    closable:true,
                    fit:true,
                })
            }else if(menuName == "添加文章"){
                $("#tt").tabs("add",{
                    title:menuName,
                    href:"${pageContext.request.contextPath}/addArticle.jsp",
                    closable:true,
                    fit:true,
                })
            }else{
                $("#tt").tabs("add",{
                    title:menuName,
                    closable:true,
                    fit:true,
                })
            }
        }
    }
	$(function () {
		$.ajax({
			url:"${pageContext.request.contextPath}/menu/menuAll",
			dataType:"json",
			success:function (res) {
				console.log(res);
				//遍历响应集合
				//参数res 当前遍历的集合，index当前遍历的下标，obj 遍历过程中的临时变量
				$.each(res,function (index,obj) {
					console.log(obj);
					var content = "";
					$.each(obj.menus,function (index1,obj1){
						content += "<p style=\"text-align: center;\"><a class=\"easyui-linkbutton\" data-options=\"iconCls:'icon-reload'\" onclick=\"addTab('"+obj1.menuName+"')\"+>"+obj1.menuName+"</a></p>";
                    })
					$("#aa").accordion("add",{
						title:obj.menuName,
						iconCls:'icon-reload',
						content:content,
					})
                })
            }
		})
    })

</script>

</head>
<body class="easyui-layout">   
    <div data-options="region:'north',split:true" style="height:60px;background-color:  #5C160C">
    	<div style="font-size: 24px;color: #FAF7F7;font-family: 楷体;font-weight: 900;width: 500px;float:left;padding-left: 20px;padding-top: 10px" >持名法州后台管理系统</div>
    	<div style="font-size: 16px;color: #FAF7F7;font-family: 楷体;width: 300px;float:right;padding-top:15px">欢迎您:xxxxx &nbsp;<a href="#" class="easyui-linkbutton" data-options="iconCls:'icon-edit'">修改密码</a>&nbsp;&nbsp;<a href="#" class="easyui-linkbutton" data-options="iconCls:'icon-01'">退出系统</a></div>
    </div>   
    <div data-options="region:'south',split:true" style="height: 40px;background: #5C160C">
    	<div style="text-align: center;font-size:15px; color: #FAF7F7;font-family: 楷体" >&copy;百知教育 gaozhy@zparkhr.com.cn</div>
    </div>   
       
    <div data-options="region:'west',title:'导航菜单',split:true" style="width:220px;">
    	<div id="aa" class="easyui-accordion" data-options="fit:true">
    		
		</div>  
    </div>   
    <div data-options="region:'center'">
    	<div id="tt" class="easyui-tabs" data-options="fit:true,narrow:true,pill:true">   
		    <div title="主页" data-options="iconCls:'icon-neighbourhood',"  style="background-image:url(${pageContext.request.contextPath}/image/shouye.jpg);background-repeat: no-repeat;background-size:100% 100%;"></div>
		</div>  
    </div>   
</body> 
</html>