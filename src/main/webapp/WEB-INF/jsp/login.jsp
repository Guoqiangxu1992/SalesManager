<%@ page contentType="text/html; charset=UTF-8"%>
<%@ include file="/WEB-INF/jsp/common.jsp"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<meta http-equiv="content-type" content="text/html; charset=UTF-8" />
<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<title>销售数据处理平台</title>




<script type="text/javascript">
var lastTabs = new Array(); 
var currentTabTitle = "Home";
$(document).ready(function () {
	 $(".easyui-accordion li").mouseover(function(){
		 if($(this).hasClass("clicked")) {
			 return;
		 } else {
			 $(this).addClass("menuHover");
		 }
	 });
	 $(".easyui-accordion li").mouseout(function(){
		 if($(this).hasClass("clicked")) {
			 return;
		 } else {
			 $(this).removeClass("menuHover");
		 }
	 });
	 $(".easyui-accordion li").click(function(){
		 //退出登录
		 if($(this).attr("href").indexOf("/ajaxLogout.do")>0){
			 $.ajax({
					url : $(this).attr("href"),
					data : null,
					method: 'POST',
					dataType : 'text',
					success : function(r) {
						window.location="${ctx}/login/tologin.do";
					}
				});
		 } else
		 if($(this).hasClass("clicked")) {
			 refreshTab({tabTitle:$(this).attr("title"),url:$(this).attr("href")});
		 } else {
			 $(".easyui-accordion .clicked").removeClass("clicked");
			 $(this).removeClass("menuHover");
			 $(this).addClass("clicked");
			 addTab($(this).attr("title"),$(this).attr("href"),null);
	
		 }
	 });
	 
	 $("#forword").click(function(){
		 //退出登录
		 if($(this).attr("href").indexOf("/ajaxLogout.do")>0){
			 $.ajax({
					url : $(this).attr("href"),
					data : null,
					method: 'POST',
					dataType : 'text',
					success : function(r) {
						window.location="${ctx}/login/tologin.do";
					}
				});
		 } else
		 if($(this).hasClass("clicked")) {
			 refreshTab({tabTitle:$(this).attr("title"),url:$(this).attr("href")});
		 } else {
			 $(".easyui-accordion .clicked").removeClass("clicked");
			 $(this).removeClass("menuHover");
			 $(this).addClass("clicked");
			 addTab($(this).attr("title"),$(this).attr("href"),null);
	
		 }
	 });
	 
	 $('.easyui-tabs').tabs({
		 onSelect: function(title) { 
			//移除 tt 
			lastTabs = $.grep(lastTabs, function(n, i) { return n != title; }); 
			//重新压入，保证 最新的在最上面 
			lastTabs.push(title); 
			//更新当前 
			currentTabTitle = title; 
			var clickedMenu =  $(".easyui-accordion .clicked");
			 if(clickedMenu) {
				 clickedMenu.removeClass("clicked");
				 $(".easyui-accordion li[title='"+title+"']").addClass("clicked");
				 
				 //展开tab所属的一级菜单
				var menuGroupTitle = $(".easyui-accordion li[title='"+title+"']").parent().parent().attr("atitle");
				  if(clickedMenu.parent().parent().attr("atitle") !=menuGroupTitle  ) {
					  $("#aa").accordion('select', menuGroupTitle);
				 }
				 
			 }
			 
			 
			}, 
		 onClose:function(title){   
			 var tt = $('.easyui-tabs');
			//移除 tt 
			 lastTabs = $.grep(lastTabs, function(n, i) { return n != title; }); 
			 //重新选择 
			 tt.tabs('select', lastTabs[lastTabs.length - 1]); 
			 
			 
			 var clickedMenu =  $(".easyui-accordion .clicked");
			 if(clickedMenu) {
				 if(clickedMenu.attr("title") == title) {
					 clickedMenu.removeClass("clicked");
				 }
			 }
	      }   
	  });
});

function removePanel(){
	 var tt = $('.easyui-tabs');
    var tab = tt.tabs('getSelected');
    if(tab){
        var index = tt.tabs('getTabIndex',tab);
        alert(index);
        tt.tabs('close',index);
    }
}

function addTab(title, href,icon){
	var tt = $('.easyui-tabs');
	if (tt.tabs('exists', title)){//如果tab已经存在,则选中并刷新该tab    	
        tt.tabs('select', title);
        refreshTab({tabTitle:title,url:href});
	} else {
		var content = '未实现';
    	if (href){
	    	 content = '<iframe scrolling="no" frameborder="0"  src="'+href+'" style="width:100%;height:100%;"></iframe>';
    	} else {
    	}
    	tt.tabs('add',{
	    	title:title,
	    	closable:true,
	    	content:content,
	    	iconCls:icon||'icon-default'
    	});
	}
}
/**    
 * 刷新tab
 * @cfg 
 *example: {tabTitle:'tabTitle',url:'refreshUrl'}
 *如果tabTitle为空，则默认刷新当前选中的tab
 *如果url为空，则默认以原来的url进行reload
 */
function refreshTab(cfg){
	var refresh_tab = cfg.tabTitle?$('.easyui-tabs').tabs('getTab',cfg.tabTitle):$('.easyui-tabs').tabs('getSelected');
	if(refresh_tab && refresh_tab.find('iframe').length > 0){
	var _refresh_ifram = refresh_tab.find('iframe')[0];
	var refresh_url = cfg.url?cfg.url:_refresh_ifram.src;
	//_refresh_ifram.src = refresh_url;
	_refresh_ifram.contentWindow.location.href=refresh_url;
	}
}


</script>
<style type="text/css">
.easyui-accordion li {
	width: 100%;
	height: 30px;
	line-height: 30px;
	cursor: pointer;
}

.clicked {
	background: #99cdff;
}

.menuHover {
	background: #eaeac4;
}

.footer {
	width: 100%;
	text-align: center;
	line-height: 35px;
}

.top-bg {
	background-color: #d8e4fe;
	height: 80px;
}

.panel-title {
	font-size: 12px;
	font-weight: bold;
	color: #0E2D5F;
	height: 16px;
	padding: 0 10px 5px 20px;
}

.tb_title {
	font-size: 26px;
	color: #0E2D5F;
	float: left;
	line-height: 80px;
	padding-left: 20px;
}

.user_name {
	font-size: 20px;
	color: #fa3438;
	padding: 0 10px;
}

.main_r_title {
	font-size: 16px;
	font-weight: bold;
	color: #333;
	line-height: 30px;
	width: 100%;
	display: inline-block;
	text-align: left;
}

.main_rule {
	font-size: 12px;
	color: #333;
	line-height: 24px;
	width: 100%;
	margin: 10px 0;
	text-align: left;
}

.main_detail {
	text-align: left;
	margin: 10px 0;
}
</style>
</head>
<body class="easyui-layout" data-options="fit:true">
	<div region="north" border="true" split="true"
		style="overflow: hidden; height: 80px;">
		<div class="top-bg">
			<p class="tb_title">销售数据处理平台</p>
			<div
				style="height: 35px; float: right; margin-top: 40px; font-size: 18px; padding-right: 20px;">
				<p>
					<span class="user_name">${SESSION_LOGIN_USER.fullName }</span> <span
						style="font-size: 14px; color: #333;">欢迎您！</span> <span
						style="color: #999; font-size: 12px;">登录时间：${currentDate }</span>
				</p>
			</div>
		</div>
	</div>
	<div region="south" border="true" split="true"
		style="overflow: hidden; height: 40px;">
		<div class="footer">
			版权所有：<a href="#"></a>
		</div>
	</div>
	<div region="west" split="true" title="导航菜单" style="width: 200px;">
		<div id="aa" class="easyui-accordion">
			<c:forEach items="${treeList}" var="m">
				<div title="${m.menuName }" iconcls=""
					style="overflow: auto; padding: 4px 0px;">
					<ul
						style="list-style: none; margin: 0; width: 100%; padding: 0; text-align: center; vertical-align: middle;">
						<c:forEach items="${m.children}" var="child">
							<li href="${ctx }${child.menuAction }" title="${child.menuName }">${child.menuName }
						</c:forEach>
					</ul>
				</div>
			</c:forEach>
		</div>
	</div>
	<div id="mainPanle" region="center" style="overflow: hidden;">
		<div class="easyui-tabs"
			data-options="tabWidth:112,tools:'#tab-tools', fit:true"
			style="width: 100%; height: 100%;">
			<div title="主界面" style="padding: 10px"
				style="width:100%; height:100%;">
				<div id="p"
					style="width: 90%; height: 90%; padding: 10px; text-align: center; margin: 0 auto;">

				</div>
			</div>
		</div>
	</div>
</body>
</html>
