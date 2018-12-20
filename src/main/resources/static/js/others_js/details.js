/*****************************************患者数据表构建*************************************************************/
	
	var totalRecord;
	$(function() {
		to_page(1);
	});
	function to_page(pn) {
		$.ajax({
			url : "${path}/patients.asp",
			data : "pn=" + pn,
			type : "GET",
			success : function(result) {
				//1.解析并显示患者数据
				build_patients_table(result);
				//2.显示分页信息
				build_page_info(result);
				//3.解析并显示导航信息
				build_page_nav(result);
			}
		});
	}
	//跳转到指定过的页面
	
	
	//构建患者表数据
	function build_patients_table(result) {
		//构建之前对数据表清空处理
		$("#patients_table tbody").empty();
		var patients = result.extend.PageInfo.list;
		$.each(patients,function(index, item) {
			var checkboxTd = $("<td><input type='checkbox' class='check_item'/></td>");
			var patientsIdTd = $("<td></td>").append(						item.pinfoId);
			var pinfoNameTd = $("<td></td>").append(
					item.pinfoName);
			var pinfoGenderTd = $("<td></td>").append(item.pinfoGender);
			var ppinfoIllnameTd = $("<td></td>").append(item.ppinfoIllname);
			var pinfoInfoTd = $("<td></td>").append(item.pinfoInfo);
			var deptNameTd = $("<td></td>").append(item.department.deptName);
			var editBtn = $("<button></button>").addClass("btn btn-primary btn-sm edit_btn").append(
			$("<span></span>").addClass("glyphicon glyphicon-pencil")).append("编辑");
			editBtn.attr("edit_id", item.pinfoId);
			var delBtn = $("<button></button>").addClass("btn btn-danger btn-sm delete_btn").append(
			$("<span></span>").addClass("glyphicon glyphicon-trash")).append("删除");
			delBtn.attr("del_id", item.pinfoId);
			var btnTd = $("<td></td>").append(editBtn).append(" ").append(delBtn);
			$("<tr></tr>").append(checkboxTd).append(
				patientsIdTd).append(pinfoNameTd).append(
				pinfoGenderTd).append(ppinfoIllnameTd)
				.append(pinfoInfoTd).append(deptNameTd)
				.append(btnTd).appendTo("#patients_table tbody");
		});
	}
	//解析分页信息
	function build_page_info(result) {
		$("#page_info_area").empty();
		$("#page_info_area").append(
				"当前第" + result.extend.PageInfo.pageNum + "页,总共"
						+ result.extend.PageInfo.pages + "页,总共"
						+ result.extend.PageInfo.total + "条数据");
		totalRecord = result.extend.PageInfo.total;
	}
	//构建分页导航信息
	function build_page_nav(result) {
		$("#page_nav_area").empty();
		var ul = $("<ul></ul>").addClass("pagination");
		var firstPageLi = $("<li></li>").append(
				$("<a></a>").append("首页").attr("href", "#"));
		var prePageLi = $("<li></li>").append($("<a></a>").append("&laquo;"));
		if (result.extend.PageInfo.hasPreviousPage == false) {
			firstPageLi.addClass("disabled");
			prePageLi.addClass("disabled");
		} else {
			firstPageLi.click(function() {
				to_page(1);
			});
			prePageLi.click(function() {
				to_page(result.extend.PageInfo.pageNum - 1);
			});
		}
		var nextPageLi = $("<li></li>").append($("<a></a>").append("&raquo;"));
		var lastPageLi = $("<li></li>").append(
				$("<a></a>").append("末页").attr("href", "#"));
		if (result.extend.PageInfo.hasNextPage == false) {
			nextPageLi.addClass("disabled");
			lastPageLi.addClass("disabled");
		} else {
			nextPageLi.click(function() {
				to_page(result.extend.PageInfo.pageNum + 1);
			});
			lastPageLi.click(function() {
				to_page(result.extend.PageInfo.pages);
			});
		}
		ul.append(firstPageLi).append(prePageLi);
		$.each(result.extend.PageInfo.navigatepageNums, function(index, item) {
			var numLi = $("<li></li>").append($("<a></a>").append(item));
			if (result.extend.PageInfo.pageNum == item) {
				numLi.addClass("active");
			}
			numLi.click(function() {
				to_page(item);
			});
			ul.append(numLi);
		});
		ul.append(nextPageLi).append(lastPageLi);
		var navEle = $("<nav></nav>").append(ul);
		navEle.appendTo("#page_nav_area");
	}
	/*****************************************患者添加*************************************************************/
	//打开模态框前清除模态框全部数据及样式
	function reset_form(ele) {
		$(ele)[0].reset();
		$(ele).find("*").removeClass("has-error has-success");
		$(ele).find(".help-block").text("");
		$(ele).find("*").addClass("autocomplete").attr("off")
	}

	//打开模态框
	$("#emp_add_modal_btn").click(function() {
		//打开模态框前清除模态框全部数据及样式
		reset_form("#patientAddModal form");
		getDept("#patientAddModal select");
		$("#patientAddModal").modal({
			backdrop : "static"
		});
	});
	//打开模态框立即查出部门信息
	function getDept(ele) {
		$(ele).empty();
		$.ajax({
			url : "${path}/depts.asp",
			type : "GET",
			success : function(result) {
				//departments是查出部门的键,值list封装在result.extend中
				$.each(result.extend.departments, function() {
					var options = $("<option></option>").append(this.deptName)
							.attr("value", this.deptId);
					options.appendTo(ele);
				})
			},
		});
	}
	//jQuery前端校验
	function validate_add_form() {
		var pinfoName = $("#pinfoName_add_input").val();
		var reg1 = /(^[a-zA-Z0-9_-]{4,16}$)|(^[\u2E80-\u9FFF]{2,5})/;
		if (!reg1.test(pinfoName) || pinfoName == null) {
			show_validate_msg("#pinfoName_add_input", "error",
					"患者名必须是2-5位中文或4-16位英文数字的组合");
			return false;
		} else {
			show_validate_msg("#pinfoName_add_input", "success", "");
		}
		var ppinfoIllname = $("#ppinfoIllname_add_input").val();
		var pinfoInfo = $("#pinfoInfo_add_input").val();
		var reg2 = /[\u4e00-\u9fa5]/;
		if (ppinfoIllname == null || !reg2.test(ppinfoIllname)) {
			show_validate_msg("#ppinfoIllname_add_input", "error",
					"确诊不能为空并且必须为中文");
			return false;
		} else {
			show_validate_msg("#ppinfoIllname_add_input", "success", "");
		}
		if (pinfoInfo == null || !reg2.test(pinfoInfo)) {
			show_validate_msg("#pinfoInfo_add_input", "error",
					"病症情况不能为空并且必须为中文");
			return false;
		} else {
			show_validate_msg("#pinfoInfo_add_input", "success", "");
		}
		return true;
	}
	//校验的提示信息
	function show_validate_msg(ele, status, msg) {
		//清空当前检验状态
		$(ele).parent().removeClass("has-error has-success");
		$(ele).next().text("");
		if (status == "success") {
			$(ele).parent().addClass("has-success");
			$(ele).next().text(msg);
		} else if (status == "error") {
			$(ele).parent().addClass("has-error");
			$(ele).next().text(msg);
		}
	}
	//文本内容发生改变立即校验患者名字是否重复
	$("#pinfoName_add_input").change(function() {
		var pinfoName = $("#pinfoName_add_input").val();
		var reg1 = /(^[a-zA-Z0-9_-]{4,16}$)|(^[\u2E80-\u9FFF]{2,5})/;
		if (!reg1.test(pinfoName) || pinfoName == null) {
		show_validate_msg("#pinfoName_add_input", "error","患者名必须是2-5位中文或4-16位英文数字的组合");
		$("#patients_save_btn").attr("ajax-va", "error");
			return false;
		} else {
			show_validate_msg("#pinfoName_add_input", "success", "");
			$("#patients_save_btn").attr("ajax-va", "success");
		}
		var pinfoName = this.value;
		$.ajax({
			url : "${path}/checkpatients.asp",
			type : "POST",
			data : "pinfoName=" + pinfoName,
			success : function(result) {
				if (result.code == 200) {
					show_validate_msg("#pinfoName_add_input","success", result.extend.va_msg);
				} else {
					show_validate_msg("#pinfoName_add_input", "error",result.extend.va_msg);
				}
			}
		});
	});
	//鼠标移出元素立即校验
	$("#ppinfoIllname_add_input").change(
		function() {
			var ppinfoIllname = $("#ppinfoIllname_add_input").val();
			var reg2 = /[\u4e00-\u9fa5]/;
			if (ppinfoIllname == null || !reg2.test(ppinfoIllname)) {
				show_validate_msg("#ppinfoIllname_add_input","error", "确诊不能为空并且必须为中文");
				$("#patients_save_btn").attr("ajax-va", "error");
				return false;
			} else {
				show_validate_msg("#ppinfoIllname_add_input","success", "");
				$("#patients_save_btn").attr("ajax-va", "success");
			}
	});
	$("#pinfoInfo_add_input").change(
			function() {
				var pinfoInfo = $("#pinfoInfo_add_input").val();
				var reg2 = /[\u4e00-\u9fa5]/;
				if (pinfoInfo == null || !reg2.test(pinfoInfo)) {
					show_validate_msg("#pinfoInfo_add_input", "error",
							"病症情况不能为空并且必须为中文");
					$("#patients_save_btn").attr("ajax-va", "error");
					return false;
				} else {
					show_validate_msg("#pinfoInfo_add_input", "success", "");
					$("#patients_save_btn").attr("ajax-va", "success");
				}
			});
	$("#patients_save_btn").click(function() {
		if (!validate_add_form()) {
			return false;
		}
		if ($(this).attr("ajax-va") == "error") {
			return false;
		}
		$.ajax({
			url : "${path}/savepatients.asp",
			type : "POST",
			data : $("#patientAddModal form").serialize(),
			success : function(result) {
				$("#patientAddModal").modal("hide");
				to_page(totalRecord);
			}
		});
	});

	/*****************************************患者更新*************************************************************/
	$(document).on("click", ".edit_btn", function() {
		reset_form("#patientAddModal form");
		getPatient($(this).attr("edit_id"));
		getDept("#patientUpdateModal select");
		$("#patients_update_btn").attr("edit_id", $(this).attr("edit_id"));
		$("#patientUpdateModal").modal({
			backdrop : "static"
		});
	});

	//查出患者信息的方法
	function getPatient(id) {
		$
				.ajax({
					url : "${path}/patients.asp/" + id,
					type : "GET",
					success : function(result) {
						var patientData = result.extend.info;
						$("#pinfoName_update_static").text(
								patientData.pinfoName);
						$("#patientUpdateModal input[name=pinfoGender]").val(
								[ patientData.pinfoGender ]);
						$("#ppinfoIllname_update_input").val(
								patientData.ppinfoIllname);
						$("#pinfoInfo_update_input").val(patientData.pinfoInfo);
						$("#patientUpdateModal select").val(
								[ patientData.piId ]);
					}
				});
	}
	//更新模态框弹出校验文本
	if ($("#ppinfoIllname_update_input").val() == null) {
		show_validate_msg("#ppinfoIllname_update_input", "error",
				"确诊不能为空并且必须为中文");
		$("#patients_update_btn").attr("ajax-va", "error");
	}
	$("#ppinfoIllname_update_input").change(
			function() {
				var ppinfoIllname = $("#ppinfoIllname_update_input").val();
				var reg2 = /[\u4e00-\u9fa5]/;
				if (ppinfoIllname == null || !reg2.test(ppinfoIllname)) {
					show_validate_msg("#ppinfoIllname_update_input", "error",
							"确诊不能为空并且必须为中文");
					$("#patients_update_btn").attr("ajax-va", "error");
					return false;
				} else {
					show_validate_msg("#ppinfoIllname_update_input", "success",
							"");
					$("#patients_update_btn").attr("ajax-va", "success");
				}
			});
	if ($("#pinfoInfo_update_input").val() == null) {
		show_validate_msg("#pinfoInfo_update_input", "error", "病症情况不能为空并且必须为中文");
		$("#patients_update_btn").attr("ajax-va", "error");
	}
	$("#pinfoInfo_update_input")
			.change(
					function() {
						var pinfoInfo = $("#pinfoInfo_update_input").val();
						var reg2 = /[\u4e00-\u9fa5]/;
						if (pinfoInfo == null || !reg2.test(pinfoInfo)) {
							show_validate_msg("#pinfoInfo_update_input",
									"error", "病症情况不能为空并且必须为中文");
							$("#patients_update_btn").attr("ajax-va", "error");
							return false;
						} else {
							show_validate_msg("#pinfoInfo_update_input",
									"success", "");
							$("#patients_update_btn")
									.attr("ajax-va", "success");
						}
					});
	$("#patients_update_btn").click(function() {
				var ppinfoIllname = $("#ppinfoIllname_update_input").val();
				var pinfoInfo = $("#pinfoInfo_update_input").val();
				var reg2 = /[\u4e00-\u9fa5]/;
				if (ppinfoIllname == null || !reg2.test(ppinfoIllname)) {
				show_validate_msg("#ppinfoIllname_update_input","error", "确诊不能为空并且必须为中文");
					return false;
				} else {
				show_validate_msg("#ppinfoIllname_update_input","success", "");
				}
				if (pinfoInfo == null || !reg2.test(pinfoInfo)) {
					show_validate_msg("#pinfoInfo_update_input","error", "病症情况不能为空并且必须为中文");
					return false;
				} else {
					show_validate_msg("#pinfoInfo_update_input","success", "");
				}
				if ($(this).attr("ajax-va") == "error") {
					return false;
				}
				$.ajax({
				url : "${path}/updatepatients.asp/"+ $(this).attr("edit_id"),
				type : "POST",
				data : $("#patientUpdateModal form").serialize()+ "&_method=PUT",
				success : function(result) {
				$("#patientUpdateModal").modal("hide");
				window.location.reload();
			}
		});
	});
	$(document).on("click", ".delete_btn", function() {
		var pinfoName = $(this).parents("tr").find("td:eq(2)").text();
		var pinfoId = $(this).attr("del_id");
		if (confirm("确定删除姓名为" + pinfoName + "的患者信息吗？")) {
			$.ajax({
				url : "${path}/delpatients.asp/" + pinfoId,
				type : "DELETE",
				success : function(result) {
					alert("患者信息已删除！");
					window.location.reload();
				}
			});
		}
	})
	$("#check_all").click(
			function() {
			//自定义对象可以用attr获取属性,原生DOM对象用prop获取属性的值
			$(".check_item").prop("checked",
			$(this).prop("checked"));
			$(document).on("click",
			".check_item",function() {
			var flag = $(".check_item:checked").length == $(".check_item").length;
			$("#check_all").prop("checked",flag);
		});
	});
	$("#patient_delete_all_btn").click(function() {
		var pinfoNames = "";
		var del_idstr = "";
		$.each($(".check_item:checked"), function() {
			pinfoNames += $(this).parents("tr").find("td:eq(2)").text() + ",";
			del_idstr += $(this).parents("tr").find("td:eq(1)").text() + "-";
		});
		pinfoNames = pinfoNames.substring(0, pinfoNames.length - 1);
		del_idstr = del_idstr.substring(0, del_idstr.length - 1);
		if (confirm("确定删除姓名为[" + pinfoNames + "]的患者信息吗？")) {
			$.ajax({
				url : "${path}/delpatients.asp/" + del_idstr,
				type : "DELETE",
				success : function(result) {
					alert("患者信息已删除！");
					window.location.reload();
				}
			});
		}
	});
	function build_patients_searchtable(result) {
		//构建之前对数据表清空处理
		$("#patients_table tbody").empty();
		var patients = result.extend.data;
		$.each(patients,function(index, item) {
		var checkboxTd = $("<td><input type='checkbox' class='check_item'/></td>");
		var patientsIdTd = $("<td></td>").append(item.pinfoId);
		var pinfoNameTd = $("<td></td>").append(item.pinfoName);
		var pinfoGenderTd = $("<td></td>").append(item.pinfoGender);
		var ppinfoIllnameTd = $("<td></td>").append(item.ppinfoIllname);
		var pinfoInfoTd = $("<td></td>").append(item.pinfoInfo);
		var deptNameTd = $("<td></td>").append(item.department.deptName);

		var editBtn = $("<button></button>")
		.addClass("btn btn-primary btn-sm edit_btn")
		.append($("<span></span>")
		.addClass("glyphicon glyphicon-pencil"))
		.append("编辑");
	editBtn.attr("edit_id", item.pinfoId);
	var delBtn = $("<button></button>")
		.addClass("btn btn-danger btn-sm delete_btn")
		.append($("<span></span>")
		.addClass("glyphicon glyphicon-trash"))
		.append("删除");
	delBtn.attr("del_id", item.pinfoId);

	var btnTd = $("<td></td>").append(editBtn).append(" ").append(delBtn);
	$("<tr></tr>").append(checkboxTd)
	.append(patientsIdTd)
	.append(pinfoNameTd)
	.append(pinfoGenderTd)
	.append(ppinfoIllnameTd)
	.append(pinfoInfoTd)
	.append(deptNameTd)
	.append(btnTd)
	.appendTo("#patients_table tbody");})
	}
	//搜索栏
	$("#search_patients_btn").click(function() {
		var search = $("#search_input").val();
		$.ajax({
			url : "${path}/search.asp/" + search,
			type : "POST",
			success : function(result) {
				console.log(result)
				$("#patients_table tbody").empty();
				build_patients_table(result);
				build_page_info(result);
				build_page_nav(result);
			}
		});
	});
	$("#loginout").click(function(){
		$.ajax({
			url:"${path}/loginout.asp",
			type:"POST",
		});
	});
	
	//通知公告
	function notice(){
		$.ajax({
			url:"${path}/notice.asp",
			type:"POST",
			success:function(result){
				console.log(result);
			}
		});
	}