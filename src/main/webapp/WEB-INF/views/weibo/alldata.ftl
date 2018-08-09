<@override name="head"> </@override> <@override name="body">
<style>
.form-group {
	border-bottom: 0px !important;
	padding-bottom:1px !important;
	margin-bottom:1px !important;
}
</style>
<div class="row">
	<div class="col-lg-12">
		<ol class="breadcrumb">
			您的位置：
			<li><a href="/">首页</a>
			</li>
			<li>全部数据</li>
			<!-- <li>Dashboard</li>
						<li>Dashb省道oard</li> -->
		</ol>
	</div>
</div>
<div class="row">
	<!--<div class="col-lg-12">
		<section class="panel">
			<div class="panel-body">
				<form class="form-horizontal" role="form">
					<div class="form-group col-lg-3">
						<label for="inputPassword1" class="col-lg-3 control-label">名称</label>
						<div class="col-lg-9">
							<input type="text" class="form-control" id="inputPassword1"
								placeholder="名称">
						</div>
					</div>
					<div class="form-group col-lg-3">
						<label for="inputPassword1" class="col-lg-3 control-label">单位</label>
						<div class="col-lg-9">
							<input type="text" class="form-control" id="inputPassword1"
								placeholder="单位">
						</div>
					</div>
					<div class="form-group col-lg-3">
						<label for="inputPassword1" class="col-lg-3 control-label">类型</label>
						<div class="col-lg-9">
							<select class="form-control m-bot15">
								<option>Option 1</option>
								<option>Option 2</option>
								<option>Option 3</option>
							</select>
						</div>
					</div>
					<div class="form-group col-lg-3">
						<div class="col-lg-offset-2 col-lg-10">
							<button type="submit" class="btn">搜索</button>
						</div>
					</div>
				</form>
			</div>
		</section>

	</div>-->
	<div class="col-lg-12">
		<section class="panel">
			<table class="table table-striped table-advance table-hover">
				<tbody>
					<tr>
						<th>UID</th>
						<th>地址</th>
						<th>操作</th>
					</tr>
					<#list page.list as weiboDataCoordinate>
					<tr>
						<td>${weiboDataCoordinate.uid }</td>
						<td>${weiboDataCoordinate.coordinate }</td>
						
						<td>
							<div class="btn-group">
								<a class="btn btn-info dropdown-toggle" 
									href="javascript:addLatlon('${weiboDataCoordinate.uid }','${weiboDataCoordinate.coordinate }')" title="转换经纬度">转换经纬度
								</a>
							</div></td>
					</tr>
					</#list>
				</tbody>

			</table>
		</section>
		共${page.total }条记录&nbsp;&nbsp;共${page.pages }页&nbsp;&nbsp;当前第${page.pageNum }页&nbsp;&nbsp;
			<a href="#" onclick="firstPage('${page.pageNum}','${page.pages }');">首页</a>&nbsp;&nbsp; 
			<a href="#" onclick="previousPage('${page.pageNum}','${page.pages }');">上一页</a>&nbsp;&nbsp;
			<a href="#" onclick="nextPage('${page.pageNum}','${page.pages }');">下一页</a>&nbsp;&nbsp; 
			<a href="#" onclick="lastPage('${page.pageNum}','${page.pages }');">尾页</a>

	</div>
</div>

<script>
function addLatlon(uid,coordinate){
	 $.ajax({  
         type : "POST",  //提交方式  
         url : "/lonlat/add",//路径  
         data : {  
             "uid" : uid ,
             'coordinate':coordinate
             
         },//数据，这里使用的是Json格式进行传输  
         success : function(result) {//返回数据根据结果进行相应的处理  
         	if(result=="success"){
         		alert("添加成功！");
         	}
         }  
     });  
}
//第一页
function firstPage(currentPage,totalPage){
	if(currentPage == 1){
		alert("已经是第一页数据");
		return false;
	}else{
		window.location.href="/weibo/alldata?pageNo=1";
		return true;
	}
}
//下一页
function nextPage(currentPage,totalPage){
	if(currentPage == totalPage){
		alert("已经是最后一页数据");
		return false;
	}else{
		window.location.href="/weibo/alldata?pageNo=" + (parseInt(currentPage)+1);
		return true;
	}
}
//上一页
function previousPage(currentPage,totalPage){
	if(currentPage == 1){
		alert("已经是第一页数据");
		return false;
	}else{
		window.location.href = "/weibo/alldata?pageNo=" + (currentPage-1);
		return true;
	}
}

// 尾页
function lastPage(currentPage,totalPage){
	
	if(currentPage == totalPage){
		alert("已经是最后一页数据");
		return false;
	}else{
		window.location.href = "/weibo/alldata?pageNo=" +totalPage;
		return true;
	}
}
$(function() {
});
</script>
</@override> <@extends name="/base/base.ftl"/>
