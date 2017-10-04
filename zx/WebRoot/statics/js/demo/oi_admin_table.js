'use strict';
jQuery(function() {
	/*企业列表*/
	$('#oi_admin_enter_list').bootstrapTable({
		url : "Admin/getcompanylist.do",
		search : true, //搜索框
		pagination : true, //分页
		showRefresh : true, //刷新按钮
		showToggle : true, //切换视图
		showColumns : true, //
		cache : false,
		iconSize : 'outline',
		pageList:"[3, 10, 25, ALL]",
		toolbar : '#exampleTableEventsToolbar',
		pagination:true,    //启动分页
		sidePagination:"client",//服务端分页 client 客户端分录页
		icons : {
			refresh : 'glyphicon-repeat',
			toggle : 'glyphicon-list-alt'
		},
		columns : [ //oi_type - 模块类型：例如企业列表模块
			{
				field : "company_id",
				title : "",
				visible : false
			},
			{
				field : "oi_type_id",
				title : "",
				visible : false
			},
			{
				field : "number",
				title : "序",
				formatter : function(value, row, index) {
					return index + 1;
				}
			},
			{
				field : "user_name",
				title : "管理员"
			},
			{
				field : "pro_name",
				title : "所属省"
			},
			{
				field : "city_name",
				title : "所属市"
			},
			{
				field : "area_name",
				title : "所属区"
			},
			{
				field : "address",
				title : "地址"
			},
			{
				field : "company_name",
				title : "名称"
			},
			{
				field : "type_name",
				title : "类型"
			},
			{
				field : "company_num",
				title : "人数"
			},
			{
				field : "corporate_rep",
				title : "法人"
			},
			{
				field : "phone",
				title : "电话"
			},
			{
				field : "license_id",
				title : "信用代码"
			},
			{
				field : "license_img",
				title : "营业执照",
				events : operateEvents,
				formatter : showButton
			},
			{
				field : "audit",
				title : "审核"
			},
			{
				field : "button",
				title : "操作",
				events : operateEvents,
				formatter : addFunction2
			}
		]
	});
	/*企业审核表*/
	$('#oiEnterCheck').bootstrapTable({
		url : "Admin/getcheckcompanylist.do",
		search : true, //搜索框
		pagination : true, //分页
		showRefresh : true, //刷新按钮
		showToggle : true, //切换视图
		showColumns : true, //
		cache : false,
		iconSize : 'outline',
		pageList:"[3, 10, 25, ALL]",
		toolbar : '#exampleTableEventsToolbar',
		pagination:true,    //启动分页
		sidePagination:"client",//服务端分页 client 客户端分录页
		icons : {
			refresh : 'glyphicon-repeat',
			toggle : 'glyphicon-list-alt'
		},
		columns : [
			{
				field : "oi_company",
				title : "",
				visible : false
			},
			{
				field : "oi_type_id",
				title : "",
				visible : false
			},
			{
				field : "number",
				title : "序",
				formatter : function(value, row, index) {
					return index + 1;
				}
			},
			{
				field : "license_id",
				title : "信用代码"
			},
			{
				field : "user_name",
				title : "管理员"
			},
			{
				field : "phone",
				title : "手机"
			},
			{
				field : "audit",
				title : "审核"
			},
			{
				field : "button",
				title : "操作",
				events : operateEvents,
				formatter : checkAlow
			}
		]
	});
	/*管理员管理表*/
	$('#oi_admin_mng_table').bootstrapTable({
		url : "Admin/getadminlist.do",
		search : true, //搜索框
		pagination : true, //分页
		showRefresh : true, //刷新按钮
		showToggle : true, //切换视图
		showColumns : true, //
		cache : false,
		iconSize : 'outline',
		pageList:"[3, 10, 25, ALL]",
		toolbar : '#exampleTableEventsToolbar',
		pagination:true,    //启动分页
		sidePagination:"client",//服务端分页 client 客户端分录页
		icons : {
			refresh : 'glyphicon-repeat',
			toggle : 'glyphicon-list-alt'
		},
		columns : [
			{
				field : "admin_id",
				title : "",
				visible : false
			},
			{
				field : "oi_type_id",
				title : "",
				visible : false
			},
			{
				field : "state",
				title : "",
			},
			{
				field : "user_name",
				title : "用户名"
			},
			{
				field : "email",
				title : "邮箱"
			},
			{
				field : "phone",
				title : "手机"
			},
			{
				field : "button",
				title : "操作",
				events : operateEvents,
				formatter : addFunction3
			}
		]
	});
	/*平台：角色管理*/
	$('#oi_admin_character_table').bootstrapTable({
		url : "Admin/getrolelist.do",
		search : true, //搜索框
		pagination : true, //分页
		showRefresh : true, //刷新按钮
		showToggle : true, //切换视图
		showColumns : true, //
		cache : false,
		iconSize : 'outline',
		pageList:"[3, 10, 25, ALL]",
		toolbar : '#exampleTableEventsToolbar',
		pagination:true,    //启动分页
		sidePagination:"client",//服务端分页 client 客户端分录页
		icons : {
			refresh : 'glyphicon-repeat',
			toggle : 'glyphicon-list-alt'
		},
		columns : [
			{
				field : "o_r_id",
				title : "",
				visible : false
			},
			{
				field : "oi_type_id",
				title : "",
				visible : false
			},
			{
				field : "name",
				title : "角色用户名"
			},
			{
				field : "button",
				title : "操作",
				events : operateEvents,
				formatter : addFunction4
			}
		]
	});
	/*
	 * 企业版：
	 *   微信模板：
	 * */
	/*管理员管理表*/
	$('#oi_enter_mng_table').bootstrapTable({
		url : "data/oi_enter_mng.json",
		search : true, //搜索框
		pagination : true, //分页
		showRefresh : true, //刷新按钮
		showToggle : true, //切换视图
		showColumns : true, //
		iconSize : 'outline',
		toolbar : '#exampleTableEventsToolbar',
		icons : {
			refresh : 'glyphicon-repeat',
			toggle : 'glyphicon-list-alt'
		},
		columns : [
			{
				field : "oi_type",
				title : "",
				visible : false
			},
			{
				field : "oi_type_id",
				title : "",
				visible : false
			},
			{
				field : "state",
				title : "",
			},
			{
				field : "username",
				title : "用户名"
			},
			{
				field : "email",
				title : "邮箱"
			},
			{
				field : "phone",
				title : "手机"
			},
			{
				field : "button",
				title : "操作",
				events : operateEvents,
				formatter : addFunction
			}
		]
	});
	//角色管理
	$('#oi_enter_character_table').bootstrapTable({
		url : "data/oi_enter_character.json",
		search : true, //搜索框
		pagination : true, //分页
		showRefresh : true, //刷新按钮
		showToggle : true, //切换视图
		showColumns : true, //
		iconSize : 'outline',
		toolbar : '#exampleTableEventsToolbar',
		icons : {
			refresh : 'glyphicon-repeat',
			toggle : 'glyphicon-list-alt'
		},
		columns : [
			{
				field : "oi_type",
				title : "",
				visible : false
			},
			{
				field : "oi_type_id",
				title : "",
				visible : false
			},
			{
				field : "state",
				title : ""
			},
			{
				field : "charName",
				title : "角色用户名"
			},
			{
				field : "button",
				title : "操作",
				events : operateEvents,
				formatter : addFunction
			}
		]
	});
	/*微信模板*/
	$('#oi_enter_weList').bootstrapTable({
		url : "data/oi_enter_webList.json",
		search : true, //搜索框
		pagination : true, //分页
		showRefresh : true, //刷新按钮
		showToggle : true, //切换视图
		showColumns : true, //
		iconSize : 'outline',
		toolbar : '#exampleTableEventsToolbar',
		icons : {
			refresh : 'glyphicon-repeat',
			toggle : 'glyphicon-list-alt'
		},
		columns : [
			{
				field : "oi_type",
				title : "",
				visible : false
			},
			{
				field : "oi_type_id",
				title : "",
				visible : false
			},
			{
				field : "state",
				title : ""
			},
			{
				field : "weType",
				title : "类型"
			},
			{
				field : "weTitle",
				title : "标题"
			},
			{
				field : "weNumber",
				title : "编号"
			},
			{
				field : "weID",
				title : "ID"
			},
			{
				field : "sortNumber",
				title : "排序"
			},
			{
				field : "button",
				title : "操作",
				events : operateEvents,
				formatter : addFunction
			}
		]
	});
	/*企业宣传*/
	$('#oi_enter_publicity').bootstrapTable({
		url : "data/oi_enter_publicity.json",
		search : true, //搜索框
		pagination : true, //分页
		showRefresh : true, //刷新按钮
		showToggle : true, //切换视图
		showColumns : true, //
		iconSize : 'outline',
		toolbar : '#exampleTableEventsToolbar',
		icons : {
			refresh : 'glyphicon-repeat',
			toggle : 'glyphicon-list-alt'
		},
		columns : [
			{
				field : "oi_type",
				title : "",
				visible : false
			},
			{
				field : "oi_type_id",
				title : "",
				visible : false
			},
			{
				field : "state",
				title : ""
			},
			{
				field : "pub_Title",
				title : "标题"
			},
			{
				field : "pub_pic",
				title : "图片地址"
			},
			{
				field : "startDate",
				title : "开始日期"
			},
			{
				field : "endDate",
				title : "结束日期"
			},
			{
				field : "pubStatus",
				title : "状态",
				formatter : showButton
			},
			{
				field : "pubSort",
				title : "排序"
			},
			{
				field : "button",
				title : "操作",
				events : operateEvents,
				formatter : addFunction
			}
		]
	});
	/*企业管理:职系管理*/
	$('#oi_enter_grade').bootstrapTable({
		url : "data/oi_enter_grade.json",
		search : true, //搜索框
		pagination : true, //分页
		showRefresh : true, //刷新按钮
		showToggle : true, //切换视图
		showColumns : true, //
		iconSize : 'outline',
		toolbar : '#exampleTableEventsToolbar',
		icons : {
			refresh : 'glyphicon-repeat',
			toggle : 'glyphicon-list-alt'
		},
		columns : [
			{
				field : "oi_type",
				title : "",
				visible : false
			},
			{
				field : "oi_type_id",
				title : "",
				visible : false
			},
			{
				field : "state",
				title : ""
			},
			{
				field : "grade_info",
				title : "职系说明"
			},
			{
				field : "grade_name",
				title : "职系名称"
			},
			{
				field : "grade_sort",
				title : "职系排序"
			},
			{
				field : "button",
				title : "操作",
				events : operateEvents,
				formatter : addFunction
			}
		]
	});
	/*企业管理:员工管理*/
	$('#oi_enter_staffMng').bootstrapTable({
		url : "data/oi_enter_staffMng.json",
		search : true, //搜索框
		pagination : true, //分页
		showRefresh : true, //刷新按钮
		showToggle : true, //切换视图
		showColumns : true, //
		iconSize : 'outline',
		toolbar : '#exampleTableEventsToolbar',
		icons : {
			refresh : 'glyphicon-repeat',
			toggle : 'glyphicon-list-alt'
		},
		columns : [
			{
				field : "oi_type",
				title : "",
				visible : false
			},
			{
				field : "oi_type_id",
				title : "",
				visible : false
			},
			{
				field : "state",
				title : ""
			},
			{
				field : "stuff_number",
				title : "序号"
			},
			{
				field : "stuff_name",
				title : "员工名称"
			},
			{
				field : "stuff_tel",
				title : "员工电话"
			},
			{
				field : "stuff_eta",
				title : "员工效率"
			},
			{
				field : "stuff_quality",
				title : "员工质量"
			},
			{
				field : "stuff_check",
				title : "审核"
			},
			{
				field : "button",
				title : "操作",
				events : operateEvents,
				formatter : addFunction
			}
		]
	});
	/*职级管理*/
	$('#oi_enter_rank').bootstrapTable({
		url : "data/oi_enter_rank.json",
		search : true, //搜索框
		pagination : true, //分页
		showRefresh : true, //刷新按钮
		showToggle : true, //切换视图
		showColumns : true, //
		iconSize : 'outline',
		toolbar : '#exampleTableEventsToolbar',
		icons : {
			refresh : 'glyphicon-repeat',
			toggle : 'glyphicon-list-alt'
		},
		columns : [
			{
				field : "oi_type",
				title : "",
				visible : false
			},
			{
				field : "oi_type_id",
				title : "",
				visible : false
			},
			{
				field : "state",
				title : ""
			},
			{
				field : "rank_to_grade",
				title : "所属职系"
			},
			{
				field : "rank_name",
				title : "职级名称"
			},
			{
				field : "rank_level",
				title : "级别"
			},
			{
				field : "rank_info",
				title : "职级说明"
			},
			{
				field : "rank_sort",
				title : "排序"
			},
			{
				field : "button",
				title : "操作",
				events : operateEvents,
				formatter : addFunction
			}
		]
	});
	/*企业新闻*/
	$('#oi_enter_news_01').bootstrapTable({
		url : "data/oi_enter_news.json",
		search : true, //搜索框
		pagination : true, //分页
		showRefresh : true, //刷新按钮
		showToggle : true, //切换视图
		showColumns : true, //
		iconSize : 'outline',
		toolbar : '#exampleTableEventsToolbar',
		icons : {
			refresh : 'glyphicon-repeat',
			toggle : 'glyphicon-list-alt'
		},
		columns : [
			{
				field : "oi_type",
				title : "",
				visible : false
			},
			{
				field : "oi_type_id",
				title : "",
				visible : false
			},
			{
				field : "state",
				title : ""
			},
			{
				field : "news_title",
				title : "标题"
			},
			{
				field : "news_post",
				title : "发布人"
			},
			{
				field : "news_content",
				title : "内容"
			},
			{
				field : "news_status",
				title : "状态"
			},
			{
				field : "news_time",
				title : "时间"
			},
			{
				field : "button",
				title : "操作",
				events : operateEvents,
				formatter : addFunction
			}
		]
	});
	/*企业：任务中心*/
	$('#oi_enter_task').bootstrapTable({
		url : "data/oi_enter_task.json",
		search : true, //搜索框
		pagination : true, //分页
		showRefresh : true, //刷新按钮
		showToggle : true, //切换视图
		showExport : true, //显示导出按钮
		hiddenColumn : "oi_type,oi_type_id",
		exportTypes : [ 'json', 'xml', 'csv', 'txt', 'sql', 'excel' ],
		exportDataType : "all", //导出数据类型 --basic基本 all全部 选中selected
		iconSize : 'outline',
		toolbar : '#exampleTableEventsToolbar',
		icons : {
			refresh : 'glyphicon-repeat',
			toggle : 'glyphicon-list-alt',
			export : 'glyphicon-export icon-share'
		},
		columns : [
			{
				field : "oi_type",
				title : "",
				visible : false
			},
			{
				field : "oi_type_id",
				title : "",
				visible : false
			},
			{
				field : "task_number",
				title : "序",
				formatter : function(v, r, i) {
					return i + 1;
				}
			},
			{
				field : "task_title",
				title : "任务标题"
			},
			{
				field : "task_content",
				title : "任务内容"
			},
			{
				field : "task_post",
				title : "发布人"
			},
			{
				field : "task_post_De",
				title : "发布部门"
			},
			{
				field : "task_get",
				title : "接收人"
			},
			{
				field : "task_get_De",
				title : "接收部门"
			},
			{
				field : "task_start_time",
				title : "发布时间"
			},
			{
				field : "task_end_time",
				title : "结束时间"
			},
			{
				field : "task_com_time",
				title : "完成时间"
			},
			{
				field : "task_progress",
				title : "任务进度"
			},
			{
				field : "task_status",
				title : "任务状态"
			},
			{
				field : "task_urgency",
				title : "是否紧急"
			},
			{
				field : "task_importance",
				title : "是否重要"
			} /*,
       {
       field:"button",
       title:"操作",
       events:operateEvents,
       formatter:addFunction
       }*/
		]
	});
});
/*监听添加/删除按钮*/
addDelete();
function layerContent(title, template) {
	layer.open({
		type : 2,
		title : title,
		shadeClose : true,
		shade : false,
		//maxmin: true, //开启最大化最小化按钮
		area : [ '800px', '450px' ],
		content : template
	});
}
function addDelete() {
	$("#exampleTableEventsToolbar").on("click", "button", function() {
		var _self = $(this);
		if (_self.hasClass("table_tool_add")) { //如果为添加按钮
			var tableType = _self.attr("data-target"); //表格种类
			switch (tableType) {
			case "oi_admin_mng_table": //平台：管理员表
				layerContent("管理员表", "Admin/oi_admin_mng_edite.html?type=add&dataType=" + tableType);
				break;
			case "oi_admin_enter_list": //平台：企业列表
				layerContent("企业列表", "Admin/oi_admin_enter_edite.html?dataType=" + tableType);
				break;
			case "oi_admin_character_table": //平台：角色管理
				layerContent("角色管理", "Admin/oi_admin_chara_add.html?dataType=" + tableType);
				break;
	        case "oi_enter_weList"://企业：微信模板管理
	            layerContent("微信模板","../weChatTpl/insert.html?dataType="+tableType);
	            break;
	          case "oi_enter_publicity"://企业：企业宣传
	            layerContent("企业宣传","../propaganda/insert.html?dataType="+tableType);
	            break;
	          case "oi_enter_grade"://企业：职系管理
	            layerContent("职系管理","../post/insert.html?dataType="+tableType);
	            break;
	          case "oi_enter_rank"://企业：职级管理
	            layerContent("职级管理","../postLevel/insert.html?dataType="+tableType);
	            break;
	          case "oi_enter_news_01"://企业：企业新闻
	            layerContent("企业新闻","../news/insert.html?dataType="+tableType);
	            break;
	          case "oi_enter_mng_table"://企业：管理设置
	            layerContent("管理设置","../admin/insert.html?dataType="+tableType);
	            break;
	          case "oi_enter_character_table"://企业：角色设置
	            layerContent("角色设置","../role/insert.html?dataType="+tableType);
	            break;
	        }
		} else if (_self.hasClass("table_tool_delete")) {
			var dataTarget = _self.attr("data-target");
			var $table = $('#' + dataTarget + '');
			var columnList = $table.bootstrapTable('getAllSelections');
			if (columnList.length <= 0) {
				layer.msg("没有选中的对象");
			} else {
				layer.confirm("确定删除吗？", function() {
					layer.closeAll();
					var arr = [];
					for (var i = 0; i < columnList.length; i++) {
						var obj = columnList[i];
						arr.push({
							"oi_type_id" : obj.oi_type_id
						});
					}
					console.log(arr);
					$.ajax({
						type : 'post',
						url : '',
						dataType : 'json',
						data : JSON.stringify(arr),
						success : function(msg) {
							window.location.href = "";
						},
						error : function() {
							alert("删除失败,请检查网络连接");
						}
					})
				})
			}
		}
	})
}
function addFunction(value, row, index) { //添加操作组按钮
	return [
		'<button id="TableEditor" class="btn btn-warning btn-sm" type="button">编辑</button>&nbsp;&nbsp;',
		'<button id="TableDelete" class="btn btn-danger btn-sm" type="button">删除</button>'
	].join('');
}
function addFunction2(value, row, index) { //添加操作组按钮
	return [
		'<button id="TableEditor" class="btn btn-warning btn-sm" type="button">编辑</button>&nbsp;&nbsp;',
		'<button id="TableDelete2" class="btn btn-danger btn-sm" type="button">删除</button>'
	].join('');
}
function addFunction3(value, row, index) { //平台管理员删除摁扭
	return [
		'<button id="TableEditor" class="btn btn-warning btn-sm" type="button">编辑</button>&nbsp;&nbsp;',
		'<button id="TableDelete3" class="btn btn-danger btn-sm" type="button">删除</button>'
	].join('');
}
function addFunction4(value, row, index) { //添加操作组按钮
	return [
		'<button id="TableEditor" class="btn btn-warning btn-sm" type="button">编辑</button>&nbsp;&nbsp;',
	].join('');
}
function checkAlow(value, row, index) { //审核操作组按钮
	return [
		'<button id="allowBtn" class="btn btn-warning btn-sm" type="button">通过</button>&nbsp;&nbsp;',
		'<button id="refuseBtn" class="btn btn-danger btn-sm" type="button">拒绝</button>'
	].join('');
}
function showButton(value, row, index) {
	//查看按钮
	if (row.busLis) {
		if (row.busLis != "未上传") {
			return [
				'<button id="showButton" class="btn btn-info btn-block">查看</button>'
			].join('');
		} else {
			return row.busLis;
		}
	} else if (row.pubStatus) {
		if (row.pubStatus == 0) {
			return [
				'<span class="btn btn-danger btn-xs">未审核</span>'
			].join("");
		}
	}
}
window.operateEvents = {
	"click #allowBtn" : function(e, value, row, index) {
		var self=$(this);
		parent.layer.msg("确定要通过吗？",{
			time: 0 //不自动关闭
			 ,btn: ['确定', '取消']
			,yes:function(){
				parent.layer.closeAll();
				$.ajax({
					type:"POST",
					data:{company_id:row.company_id,type:"pass"},
					url:"Admin/checkcompany.do",
					success:function(msg){
						self.parent().parent().remove();
					},
					error:function(msg){
						parent.alert("修改失败，请检查网络！")
					}
			})}
		})
	},
	"click #refuseBtn" : function(e, value, row, index) {
		var self=$(this);
		parent.layer.msg("确定要拒绝吗？",{
			time: 0 //不自动关闭
			 ,btn: ['确定', '取消']
			,yes:function(){
				parent.layer.closeAll();
				$.ajax({
					type:"POST",
					data:{company_id:row.company_id,type:"return"},
					url:"Admin/checkcompany.do",
					success:function(msg){
						self.parent().parent().remove();
					},
					error:function(msg){
						parent.alert("修改失败，请检查网络！")
					}
			})}
		})
	},
	"click #TableEditor" : function(e, value, row, index) {
		//编辑按钮事件
		console.log(row, index, value);
		var tableType = row.oi_type;
		var companyId = row.company_id;
		var adminId=row.admin_id;
		var roleId=row.o_r_id;
		var tableTypeid=row.oi_type_id;
		console.log(roleId);
		var self=$(this);
		var companyList=self.parent().parent().parent().parent().attr("id");
		console.log(companyList);
		switch (tableType || companyList) {
		case "ad_enter_list": //企业列表
			layerContent("企业信息", "Admin/oi_admin_enter_edite.html?companyId=" + companyId);
			break;
		case "oi_admin_enter_list": // 平台版：企业信息列表 ——需要共存，请误删除
			layerContent("企业信息", "Admin/oi_admin_enter_edite.html?companyId=" + companyId);
			break;
		case "oi_admin_mng_table": //管理员列表
			layerContent("管理员编辑", "Admin/oi_admin_mng_edite.html?adminId=" + adminId);
			break;
		case "oi_admin_character_table": //角色管理
			layerContent("角色编辑", "Admin/oi_admin_chara_edite.html?roleId=" + roleId);
			break;
		 case "oi_enter_publicity": //企业宣传
		        layerContent("企业宣传","../propaganda/update.html?dataType="+tableType+"&id="+tableTypeid);
		        break;
		      case "oi_enter_grade": //职系管理
		        layerContent("职系管理","../post/update.html?dataType="+tableType+"&id="+tableTypeid);
		        break;
		      case "oi_enter_rank": //职级管理
		        layerContent("职级管理","../postLevel/update.html?dataType="+tableType+"&id="+tableTypeid);
		        break;
		      case "oi_enter_staffMng": //员工管理
		        layerContent("员工管理","../staffer/update.html?dataType="+tableType+"&id="+tableTypeid);
		        break;
		      case "oi_enter_news_01": //企业新闻
		        layerContent("企业新闻","../news/update.html?dataType="+tableType+"&id="+tableTypeid);
		        break;
		      case "oi_enter_mng_table": //企业：管理员
		        layerContent("管理设置","../admin/update.html?dataType="+tableType+"&id="+tableTypeid);
		        break;
		      case "oi_enter_character_table": //企业：角色管理
		        layerContent("角色设置","../role/update.html?dataType="+tableType+"&id="+tableTypeid);
		        break;
		      case "oi_enter_weList"://企业：微信模板管理
		        layerContent("微信模板","../weChatTpl/update.html?dataType="+tableType+"&id="+tableTypeid);
		        break;
		    }
		  },
		  "click #TableDelete": function (e, value, row, index) {
			    //删除按钮事件
			    var dataTypeid = row.oi_type_id,  //获取当前行的ID
			        _self=$(this);
			    var type=row.oi_type;
			    layer.confirm("确定删除吗？",function(){
			      layer.closeAll();
			      $.ajax({
			        type:'post',
			        url:'../deleteInfo/delete.do',
			        data:{id:dataTypeid,dataType:type},
			        success:function(msg){
			          _self.parent().parent().remove();
			        },
			        error:function(){
			          alert("删除失败，检查网络");
			        }
			      })
			    });
			  },
	"click #TableDelete2" : function(e, value, row, index) {
		//删除按钮事件  第二个
		var dataType = row.oi_type_id, //获取当前行的ID
		 companyId = row.company_id, //获取当前行的ID
			_self = $(this);
		layer.confirm("确定删除吗？", function() {
			layer.closeAll();
			$.ajax({
				type : 'post',
				url : 'removecompany.do/'+companyId,
				success : function(msg) {
					if(msg.code==100){
						_self.parent().parent().remove();
					}
				},
				error : function() {
					alert("删除失败，检查网络");
				}
			})
		});
	},
	"click #TableDelete3" : function(e, value, row, index) {
		//删除按钮事件  第三个
		var dataType = row.oi_type_id, //获取当前行的ID
		 adminId = row.admin_id, //获取当前行的ID
			_self = $(this);
		layer.confirm("确定删除吗？", function() {
			layer.closeAll();
			$.ajax({
				type : 'post',
				url : 'Admin/removeadmin.do/'+adminId,
				success : function(msg) {
					if(msg.code==100){
						_self.parent().parent().remove();
					}
				},
				error : function() {
					alert("删除失败，检查网络");
				}
			})
		});
	},
	"click #showButton" : function(e, value, row, index) { //查看按钮
		//查看企业营业执照
		var imgSRC = row.busLis;
		layer.open({
			type : 1,
			title : "营业执照",
			shadeClose : false,
			shade : false,
			maxmin : true,
			area : [ '600px', '600px' ],
			content : '<div class="col-sm-12"><img style="display:block;width:100%;height:auto;" src="img/' + imgSRC + '"></div>'
		})
	}
};