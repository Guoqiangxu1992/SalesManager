<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/jsp/common.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>

<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<style type="text/css">
.middle {
	width: 100%;
	margin: 0 auto;
	height: 100%;
	display: block;
}

h2.title {
	margin-top: 20px;
	margin-bottom: 20px;
	text-align: center;
	font-size: 35px;
	color: #0E2D5F;
	line-height: 30px;
}
</style>
</head>
<body>
	<h2>欢迎用户使用二手车交易平台</h2>
	<p>用户注册</p>
	<div class="middle">
		<div style="width: 400px; margin: 0 auto;"></div>
		<div class="easyui-panel" title="欢迎用户注册"
			style="width: 400px; margin: 0 auto;" class="middle">
			<div style="padding: 10px 60px 20px 60px">
				<form id="ff" class="easyui-form" method="post"
					action="${ctx}/user/buy/regist.do">
					<h2>欢迎用户使用二手车交易平台</h2>
					<table cellpadding="5">
						<tr>
							<td>姓名:</td>
							<td><input class="easyui-textbox" type="text" id="fullName"
								name="fullName" data-options="required:true" /></td>
						</tr>
						<tr>
							<td>用户名:</td>


							<td><input class="easyui-textbox" type="text" id="userName"
								name="userName" data-options="required:true" /></td>
						</tr>
						<tr>
							<td>性别:</td>
							<td><select style="width: 150px" class="easyui-combobox"
								id="sex" name="sex" data-options="required:true">
									<option value="1">男</option>
									<option value="2">女</option>
									<option selected="selected" value=""></option>
							</select></td>
						</tr>
						<tr>
							<td>出生日期:</td>
							<td><input class="easyui-datebox" type="text" id="birthday"
								name="birthday" data-options="required:true"></input></td>
						</tr>
						<tr>
							<td>用户ID</td>
							<td><input class="easyui-textbox" type="text" id="userId"
								name="userId" data-options="required:true" /></td>
						</tr>
						<tr>
							<td>电话:</td>
							<td><input class="easyui-textbox" type="text" id="mobile"
								name="mobile" data-options="required:true" /></td>
						</tr>
					</table>
				</form>
				<div style="text-align: center; padding: 5px">
					<a href="javascript:void(0)" class="easyui-linkbutton"
						onclick="submitForm()">Submit</a> <a href="javascript:void(0)"
						class="easyui-linkbutton" onclick="clearForm()">Clear</a>
				</div>
			</div>
		</div>
	</div>
	<script>
	function submitForm(){
		$('#ff').form('submit',{
			onSubmit:function(){
				return $(this).form('enableValidation').form('validate');
			},
		    success:function(r){
		    	if(r==1){ window.location = "${ctx}/login/tologin.do";
		    	alert("成功注册，跳转到登录界面！！");
		    	}
		    	else
		    		alert("注册失败，此账户已被注册！！");
		    	 
		       }
		    });
	
		    };
		function clearForm(){
			$('#ff').form('clear');
		}
	</script>
</body>
</html>