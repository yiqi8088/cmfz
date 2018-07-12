<%@ page language="java" pageEncoding="utf-8" isELIgnored="false" %>

<script type="text/javascript">
	$(function () {
		$("#ttPicture").datagrid({
					url:"${pageContext.request.contextPath}/picture/showPictureByPage",
					columns : [ [{
						title : "标识编号",
						field : "pictureId",
						width:100,
					}, {
						title : "文件名",
						field : "pictureName",
						width:100,
					}, {
						title : "描述信息",
						field : "pictureDescription",
						width:100,
					},{
						title:"轮播图状态",
						field:"pictureStatus",
						width:100,
					} ,{
						title:"轮播图创建时间",
						field:"pictureTime",
						width:100,
					},]],
					pagination:true,
					pageList : [5,10],
					pageSize : 5,
					toolbar: "#tbPicture",
					singleSelect:true,
					fitColumns:true,
					view:detailview,
					detailFormatter: function (rowIndex, rowData) {
						return '<table><tr>' +
							'<td rowspan=2 style="border:0"><img src="${pageContext.request.contextPath}/cmfz-admin/upload/' + rowData.pictureName+ '" style="height:50px;"></td>' +
							'<td style="border:0">' +
							'<p>轮播图状态: ' + rowData.pictureStatus+ '</p>' +
							'<p>轮播图描述: ' + rowData.pictureDescription + '</p>' +
							'</td>' +
							'</tr></table>';
					},
            	toolbar: [{
                iconCls: 'icon-add',
                text: "添加轮播图",
                handler: function () {
                    $("#ddPicture").dialog({
                        title: "添加轮播图",
                        width: 400,
                        height: 260,
                        modal: true,
                        collapsible: true,
                        minimizable: true,
                        maximizable: true,
                        href: "${pageContext.request.contextPath}/addPicture.jsp",
                        buttons: [ {
                            text: '添加',
                            iconCls: "icon-disk",
                            handler: function () {
                                $("#uploadForm").form("submit", {
                                    url: "${pageContext.request.contextPath}/picture/addPicture",
                                    onSubmit: function () {
                                        return $(this).form("validate");
                                    },
                                    success: function (data) {
                                        if (data == "success") {
                                            $("#ttPicture").datagrid("reload", {});
                                            $.messager.show({
                                                title: "提示消息",
                                                msg: "上传成功",
                                                timeout: 3000,
                                            });
                                            $("#ddPicture").window("close", {});
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
                                $("#ddPicture").window("close", {});
                            }
                        },],
                    });
                }
            }, {
                iconCls: 'icon-edit',
                text: "修改轮播图",
                handler: function () {
                    var rows = $("#ttPicture").datagrid("getSelected");
                    if (rows == null) {
                        alert("您还没选择要修改的行");
                    } else {
                        $("#ddPicture").dialog({
                            title: "修改轮播图",
                            width: 400,
                            height: 260,
                            modal: true,
                            collapsible: true,
                            minimizable: true,
                            maximizable: true,
                            href: "${pageContext.request.contextPath}/modifyPicture.jsp",
                            buttons: [ {
                                text: '修改',
                                iconCls: "icon-edit",
                                handler: function () {
                                    $("#uploadForm").form("submit", {
                                        url: "${pageContext.request.contextPath}/picture/modifyPicture",
                                        onSubmit: function () {
                                            return $(this).form("validate");
                                        },
                                        success: function (data) {
                                            if (data == "success") {
                                                $("#ttPicture").datagrid("reload", {});
                                                $.messager.show({
                                                    title: "提示消息",
                                                    msg: "修改成功",
                                                    timeout: 3000,
                                                });
                                                $("#ddPicture").window("close", {});
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
                                    $("#ddPicture").window("close", {});
                                }
                            },],
                            onLoad: function () {
                                $("#uploadForm").form("load", rows);
                            }
                        });

                    }
                }
            	}, {
                    iconCls: 'icon-user_b',
                    text: "帮助",
                }],
			});

        });


</script>
	<table id="ttPicture"></table>

	<div id="ddPicture"></div>
