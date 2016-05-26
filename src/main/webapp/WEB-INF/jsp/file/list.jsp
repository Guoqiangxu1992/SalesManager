<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/jsp/common.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<style type="text/css">
.sp span.textbox {
	border-left: 0;
	border-right: 0;
	border-top: 0;
}
</style>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script src="${ctx}/js/plupload-2.1.0/js/plupload.full.min.js"
	type="text/javascript"></script>

<script type="text/javascript">
	var datagrid;
	var idcardFlag = "1";
	var rowEditor=undefined;
	$(function(){
		datagrid=$("#dg").datagrid({
			url:"${ctx}/list/list.do",//加载的URL
		    isField:"id",	
			pagination:true,//显示分页
			pageSize:10,//分页大小
			pageList:[10,15,20],//每页的个数
			fit:true,//自动补全
			fitColumns:true,
			singleSelect:true,
			iconCls:"icon-save",//图标
			columns:[[      //每个列具体内容
		              {field:'id', hidden:true },  
		              {field:'fileName', title:'文件名', width:100, align:'center' },
		              {field:'fileSize', title:'文件大小(KB)', width:100,align:'center' },
		              {field:'modifyTime', title:'更改时间', width:100,align:'center'},
		              {field:'hdfsPath', title:'文件路径', width:100,align:'center'},
		              {field:'fileDir', title:'文件夹', width:100, align:'center' },
		              {field:'btnId',title:'操作',width:80,align:'center',formatter: 
		            	  function(value,row){
		  	  			  if(row.status==1){ 
		  	  			  var html="";
		            	  html+= '<a href="${ctx}/buy/order.do?id='+row.id+'&status='+row.status+'"  style="width:80px; padding:10px;">购买</a>';
		            	  return html;
		  	  			  }
		  	  			  else{
		  	  			  }
		            	 
		                  }
		              }
		          	]],

		});
			});
    </script>
<style type="text/css">
</style>
</head>
<body style="padding: 0 4px; margin: 0; overflow: hidden;">
	<div class="easyui-layout" style="width: 100%; height: 100%;"
		data-options="fit:true">

		<div data-options="region:'center'">
			<table id="dg">
			</table>
		</div>










	</div>

</body>
</html>