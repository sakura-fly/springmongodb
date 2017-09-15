<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title>sprign mongdb测试例子</title>
	<script type="text/javascript">window.QHDomain = {'cdn':'<%=basePath%>'  }</script>
	<spring:url value="/public/favicon.ico" var="app_shortCut" />
	<link href="${app_shortCut}"  type="image/x-icon"   rel="icon" id="favicon" />
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
	<meta http-equiv="X-UA-Compatible" content="IE=EmulateIE9" />
	<spring:url value="/app/css/layout.css" var="layoutCss" />
	<link href="${layoutCss}" rel="stylesheet" />
	<spring:url value="/libs/jQuery/jquery-min.js" var="jQueryJs" />
	<script src="${jQueryJs}"></script>
	<spring:url value="/libs/jQuery/jquery-common-min.js" var="jQueryCommonJs" />
	<script src="${jQueryCommonJs}"></script>
  </head>
  <body>
<div class="main-wrap" style="margin-bottom: 20px; background-color: rgb(204, 232, 207);">
	<ul class="jubao-navs">
            <li>
                <a href="javascript:void(0);" >
                    查询列表</a>
            </li>
            <li>
                <a href="javascript:void(0);" >
                    增加信息</a>
            </li>
            <li>
                <a id="del" href="javascript:void(0);">
                    删除信息</a>
            </li>
        </ul>
</div>
<div  class="containerWarp" id="bookContainmer">
<table class="table table-hover marginb5" style="margin-bottom:10px;">
		<thead>
				<tr style="background:#fff !important;">
					<th class="title-column">选择</th>
					<th class="title-column">编号</th>
					<th class="title-column">书籍名称</th>
					<th class="title-column">所属类型</th>
					<th class="title-column">剩余数量</th>
					<th class="title-column">作者</th>
					<th class="title-column">出版社</th>			
					<th class="title-column">出版时间</th>	
					<th class="title-column">操作</th>	
				</tr>
		</thead>
		<tbody></tbody>
</table>
<div class="layout-pager  pager-center"><div class="pager"><div class="pager-inner"></div></div></div>

<div style="margin-top:10px"></div>
</div>


<div class="popupwin"  data="new">
	<div class="titlebar"><div class="close"><a href="javascript:void(0);" data="close">X</a></div><div class="title">增加信息</div></div>
	<div class="f-tab-b">
			<div  class="winbody">
					<form id="bookform">
					<div class="l">
						<label class="label">书籍名称：</label>
						<input id="bookname"  name="bookname" class="input"  value="简约至上：交互式设计四策略"   autocomplete="off" >
					</div>
					<div class="l">
						<label class="label">书籍类型：</label>
						<input id="booktype"  name="booktype"  class="input"  value="程序设计"   autocomplete="off" >
					</div>
					<div class="l">
						<label class="label">剩余数量：</label>
						<input id="rescount"  name="rescount"  class="input"   value="30"   autocomplete="off" >
					</div>
					<div class="l">
						<label class="label">作者：</label>
						<input id="author" name="author" class="input" value="（英）科尔伯恩（Colborne,G.）"   autocomplete="off" >
					</div>
					<div class="l">
						<label class="label">出版社：</label>
						<input id="publisher"  name="publisher" class="input" value="人民邮电出版社"  autocomplete="off" >
					</div>
					<div class="l">
						<label class="label">出版时间：</label>
						<input id="publishdt" name="publishdt" class="input" value="2011-01-01"  autocomplete="off" >
					</div>
					<div class="l">
						<label class="label">借出人：</label>
						<input id="member" name="member"  value="高清源"  class="input" autocomplete="off" >
					</div>
					</form>
					<div  class="bottombar" >
						<div  class="body" ><a href="javascript:void(0);" class="btn"  data="newsave">保存信息</a>
					</div></div>
					<div class="message" data="message"></div>
			</div>
	</div>
</div>












<div class="popupwin"  data="update">
	<div class="titlebar"><div class="close"><a href="javascript:void(0);" data="close">X</a></div><div class="title">更新信息</div></div>
	<div class="f-tab-b">
			<div  class="winbody">
					<form id="bookuform">
					<input type="hidden"  id="_id"  name="_id">
					<div class="l" >
						<label class="label">书籍名称：</label>
						<input id="bookname"  name="bookname" class="input"  value=""   autocomplete="off" >
					</div>
					<div class="l">
						<label class="label">书籍类型：</label>
						<input id="booktype"  name="booktype"  class="input"  value=""   autocomplete="off" >
					</div>
					<div class="l">
						<label class="label">剩余数量：</label>
						<input id="rescount"  name="rescount"  class="input"   value=""   autocomplete="off" >
					</div>
					<div class="l">
						<label class="label">作者：</label>
						<input id="author" name="author" class="input" value=""   autocomplete="off" >
					</div>
					<div class="l">
						<label class="label">出版社：</label>
						<input id="publisher"  name="publisher" class="input" value=""  autocomplete="off" >
					</div>
					<div class="l">
						<label class="label">出版时间：</label>
						<input id="publishdt" name="publishdt" class="input" value=""  autocomplete="off" >
					</div>
					<div class="l">
						<label class="label">借出人：</label>
						<input id="member" name="member"  value=""  class="input" autocomplete="off" >
					</div>
					</form>
					<div  class="bottombar" >

						<div  class="body" ><a href="javascript:void(0);" class="btn"  data="updatesave">保存信息</a>
					</div></div>
					<div class="message" data="message"></div>
			</div>
	</div>
</div>



</body>
</html>
<script>
$(document).ready(function(){
	$('ul.jubao-navs li').eq(1).click(function(){
			$("div[data=new]").show();
	}).end().eq(0).click(function(){
			$("#bookContainmer").find("div.pager-inner").pagination({ colspan : 8 ,pager_rowcontainer : $("#bookContainmer_layout table tbody") ,  items_per_page:20,url: QHDomain.cdn + "service/bookquery.do" , "query": {} ,	callback: function( t, q , data ){	
						$("#bookContainmer table tbody").html("");
						$.each(data,function(pos , entity){  					
								$('<tr data="contentWrap_' + entity.id + '"> <td><span>' + '<input type="checkbox" tag="' + entity.id + '" >'  + '</span></td>  <td><span>' + entity.bookName + '</span></td><td><span>' + entity.bookName + '</span></td> <td><span>' + entity.bookType + '</span></td>   <td><span>' + entity.resCount + '</span></td> <td  ><span>' + entity.author + '</span></td><td  ><span>' + entity.publisher + '</span></td>  <td  ><span>' + entity.publishDate + '</span></td>  <td   nowrap="nowrap"><div class="opcontainer" ><a href="javascript:void(0);" style="float:left;"  ><span class="btn2 blue"  sid="update"  data-dt=\'' + JSON.stringify(entity)   + '\'>修改</span></a><a   href="javascript:void(0);" style="float:left;" ><span class="btn2 blue"   sid="delete"  data-id="' + entity.id   + '">删除</span></a></div></td>      </tr>').appendTo("#bookContainmer table tbody");
							});
							$("span[sid=update]").on("click", function(){
									var entity = $(this).data('dt');
									function change(){
										$('#bookContainmer tbody').find('tr[data=contentWrap_' + entity.id + ']').find('td').css('background' , '#cce8cf');
									}
									change();
									$("#bookuform input[id=_id]").val( entity.id );
									$("#bookuform input[id=bookname]").val( entity.bookName );
									$("#bookuform input[id=booktype]").val( entity.bookType );
									$("#bookuform input[id=rescount]").val( entity.resCount );
									$("#bookuform input[id=author]").val( entity.author );
									$("#bookuform input[id=publisher]").val( entity.publisher );
									$("#bookuform input[id=publishdt]").val( entity.publishDate); 
									$("#bookuform input[id=member]").val( entity.member.realName); 
									$("div[data=update]").show();
							});
							
							$("span[sid=delete]").on("click",function(){
									var _id = $(this).data("id");
									$.arp({ url : '<%=basePath%>service/bookdelete.do' , data: { "_id" : _id} , fn :function(data){
										if(data.result == '1'){
											$("ul.jubao-navs>li:eq(0)>a").trigger("click");
										}else{
											alert('数据操作失败');
										}
									} 
									});
							});
						
			}

			});

	});
	$("a[data=close]").click(function(){
		$("div[data=new]").hide();
		$("div[data=update]").hide();
	});
	$("a[data=newsave]").click(function(){
		$.arp({ url : '<%=basePath%>service/bookadd.do' , data: $("#bookform").so() , fn :function(data){
			if(data.result == '1'){
				$("ul.jubao-navs>li:eq(0)>a").trigger("click");
				var q = $("div[data=message]").html('数据增加成功').show();
					setTimeout(function() {
						q.hide();
					}, 1500);

			}else{
				alert('数据操作失败');
			}
		} 
		});
	});

	$("#del").click(function(event) {
			var h = $("input[type='checkbox']:checked");
			var l = [];
			for(var i = 0; i < h.length; i++){
				// alert(h[i].getAttribute('tag'))
				l[i] = h[i].getAttribute('tag');
			}
			var data = {
				idList:JSON.stringify(l)
			}
			if(l.length == 0){
				alert('请选择至少一个用户')
			} else {
				// alert(JSON.stringify(data))
				$.ajax({
					url: '<%=basePath%>service/bookdeletelist.do',
					type: 'POST',
					dataType: 'json',
					data: data,
				})
				.done(function(e) {
					if(e.result == 1){
						alert('成功')
					} else {
						alert('失败')
					}
					
				})
				.fail(function() {
					alert('失败')
					console.log("error");
				})
				.always(function() {
					console.log("complete");
				});
				
			}
	});

	

		$("a[data=updatesave]").click(function(){
			$.arp({ url : '<%=basePath%>service/bookupdate.do' , data: $("#bookuform").so() , fn :function(data){
				if(data.result == '1'){
					$("ul.jubao-navs>li:eq(0)>a").trigger("click");
					var q = $("div[data=message]").html('数据修改成功').show();
						setTimeout(function() {
							q.hide();
						}, 1500);
				}else{
					alert('数据操作失败');
				}
			} 
			});
	});


	
});
	

</script>
