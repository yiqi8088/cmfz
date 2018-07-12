<%@ page language="java" pageEncoding="utf-8" isELIgnored="false" %>

<script type="text/javascript">
	$(function () {
		$("#ttMaster").datagrid({
					url:"${pageContext.request.contextPath}/master/showAllMaster",
					columns : [ [{
						title : "上师编号",
						field : "masterId",
						width:100,
					}, {
						title : "上师法名",
						field : "masterName",
						width:100,
					}, {
						title : "上师头像",
						field : "masterPhoto",
						width:100,
					},{
						title:"上师简介",
						field:"masterSummary",
						width:100,
					}]],
					pagination:true,
					pageList : [5,10],
					pageSize : 5,
					singleSelect:true,
					fitColumns:true,
					view:detailview,
					detailFormatter: function (rowIndex, rowData) {
						return '<table><tr>' +
							'<td rowspan=2 style="border:0"><img src="${pageContext.request.contextPath}/cmfz-admin/upload/' + rowData.masterPhoto+ '" style="height:50px;"></td>' +
							'<td style="border:0">' +
							'<p>上师法号: ' + rowData.masterName+ '</p>' +
							'<p>上师简介: ' + rowData.masterSummary + '</p>' +
							'</td>' +
							'</tr></table>';
					},
            	toolbar: [{
                iconCls: 'icon-add',
                text: "添加上师",
                handler: function () {
                    $("#ddMaster").dialog({
                        title: "添加上师",
                        width: 400,
                        height: 260,
                        modal: true,
                        collapsible: true,
                        minimizable: true,
                        maximizable: true,
                        href: "${pageContext.request.contextPath}/addMaster.jsp",
                        buttons: [ {
                            text: '添加',
                            iconCls: "icon-disk",
                            handler: function () {
                                $("#uploadMaster").form("submit", {
                                    url: "${pageContext.request.contextPath}/master/addMaster",
                                    onSubmit: function () {
                                        return $(this).form("validate");
                                    },
                                    success: function (data) {
                                        if (data == "success") {
                                            $("#ttMaster").datagrid("reload", {});
                                            $.messager.show({
                                                title: "提示消息",
                                                msg: "上传成功",
                                                timeout: 3000,
                                            });
                                            $("#ddMaster").dialog("close", {});
                                        } else {
                                            $.messager.show({
                                                title: "提示消息",
                                                msg: "上传失败",
                                                timeout: 3000,
                                            });
                                        }
                                    },
                                });
                            }
                        },{
                            text: '取消',
                            iconCls: "icon-cross",
                            handler: function () {
                                $.messager.show({
                                    title: "取消",
                                    msg: "您已经取消添加，窗口3秒后消失",
                                    timeout: 3000,
                                });
                                $("#ddMaster").dialog("close", {});
                            }
                        },],
                    });
                }
            }, {
                iconCls: 'icon-edit',
                text: "修改上师信息",
                handler: function () {
                    var rows = $("#ttMaster").datagrid("getSelected");
                    if (rows == null) {
                        alert("您还没选择要修改的行");
                    } else {
                        $("#ddMaster").dialog({
                            title: "修改上师信息",
                            width: 400,
                            height: 260,
                            modal: true,
                            collapsible: true,
                            minimizable: true,
                            maximizable: true,
                            href: "${pageContext.request.contextPath}/addMaster.jsp",
                            buttons: [ {
                                text: '修改',
                                iconCls: "icon-edit",
                                handler: function () {
                                    $("#uploadMaster").form("submit", {
                                        url: "${pageContext.request.contextPath}/master/modifyMaster",
                                        onSubmit: function () {
                                            return $(this).form("validate");
                                        },
                                        success: function (data) {
                                            if (data == "success") {
                                                $("#ttMaster").datagrid("reload", {});
                                                $.messager.show({
                                                    title: "提示消息",
                                                    msg: "修改成功",
                                                    timeout: 3000,
                                                });
                                                $("#ddMaster").dialog("close", {});
                                            } else {
                                                $.messager.show({
                                                    title: "提示消息",
                                                    msg: "修改失败",
                                                    timeout: 3000,
                                                });
                                            }
                                        },
                                    });
                                }
                            },{
                                text: '取消',
                                iconCls: "icon-cross",
                                handler: function () {
                                    $.messager.show({
                                        title: "取消",
                                        msg: "您已经取消修改",
                                        timeout: 3000,
                                    });
                                    $("#ddMaster").dialog("close", {});
                                }
                            },],
                            onLoad: function () {
                                $("#uploadMaster").form("load", rows);
                            }
                        });

                    }
                }
            	},{
                    iconCls:'icon-add',
                    text:"上传Excel添加",
                    handler:function(){
                        $("#ddMaster").dialog({
                            title: "Excel添加上师",
                            width: 400,
                            height: 260,
                            modal: true,
                            collapsible: true,
                            minimizable: true,
                            maximizable: true,
                            href: "${pageContext.request.contextPath}/uploadMasterExcel.jsp",
                            buttons: [{
                                text: '上传',
                                iconCls: "icon-disk",
                                handler: function () {
                                    $("#uploadMasterExcel").form("submit", {
                                        url: "${pageContext.request.contextPath}/master/excelUpload",
                                        onSubmit: function () {
                                            return $(this).form("validate");
                                        },
                                        success: function (data) {
                                            if (data == "success") {
                                                $("#ttMaster").datagrid("reload", {});
                                                $.messager.show({
                                                    title: "提示消息",
                                                    msg: "上传Excel成功",
                                                    timeout: 3000,
                                                });
                                                $("#ddMaster").dialog("close", {});
                                            } else {
                                                $.messager.show({
                                                    title: "提示消息",
                                                    msg: "上传失败",
                                                    timeout: 3000,
                                                });
                                            }
                                        },
                                    });
                                }
                            },{
                            text: '取消',
                                iconCls: "icon-cross",
                                handler: function () {
                                $.messager.show({
                                    title: "取消",
                                    msg: "您已经取消添加Excel",
                                    timeout: 3000,
                                });
                                $("#ddMaster").dialog("close", {});
                            }
                        }],
                        });
                    }
                }, {
                    //下载Excel表====================================================
                    iconCls: 'icon-20130406125519344_easyicon_net_16',
                    text: "下载Excel格式",
                    handler:function(){
                        window.location.href="${pageContext.request.contextPath}/master/export";
                    }
                }, {
                    iconCls: 'icon-user_b',
                    text: "帮助",
                }],
			});
        $("#search").css("display","block");
        $('#sss').searchbox({
            menu : '#mm',
            prompt : '请输入要搜索的信息',
            searcher : function(value, name) {
                $("#ttMaster").datagrid("load",{
                    key : name,
                    value : value,
                });
                $('#ttMaster').datagrid({
                    url:"${pageContext.request.contextPath}/master/showMasterByKey",
                });
            },
        });
        $('#search').prependTo('.datagrid-toolbar');

    });


</script>
	<table id="ttMaster"></table>

	<div id="ddMaster"></div>
	<div id="search">  <!--   若想调整搜索框位置，加一个div层 -->
		<input id="sss">
		<div id="mm" style="width:100px">
			<!-- 搜索选项，若上面的初始化中有相关内容则不需要下面的内容 -->
			<div data-options="name:'master_Name'">上师法名</div>
			<div data-options="name:'master_ID'">上师编号</div>
			<%--<div data-options="name:'departmentName'">部门</div>
			<div data-options="name:'majorName'">专业</div>--%>
		</div>
	</div>