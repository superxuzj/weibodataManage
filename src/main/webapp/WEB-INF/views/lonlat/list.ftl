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
			<li>获取经纬度</li>
			<!-- <li>Dashboard</li>
						<li>Dashb省道oard</li> -->
		</ol>
	</div>
</div>
<div class="row">
	<div class="col-lg-12">
		<section class="panel">
			<div class="panel-body">
				<form class="form-horizontal" action="/lonlat/uploadfile" role="form" enctype="multipart/form-data" method="post" >
					<div class="form-group col-lg-4">
						<label for="exampleInputFile"></label>
						<div class="col-lg-9">
								<div class="input-append">  
                                      <input type="file" name="file" id="exampleInputFile">
								</div> 
						</div>
					</div>
					
					
					<div class="form-group col-lg-3">
						<div class="col-lg-offset-2 col-lg-10">
							 <input type="submit" class="btn btn-primary submittijioa" value="提交">
						</div>
					</div>
				</form>
			</div>
		</section>

	</div>
	
	
	<div class="col-lg-12">
		<section class="panel">
			<table class="table table-striped table-advance table-hover">
				<tbody  id="list">
					<tr>
						<th><input type="button" id="checkall" name="checkall" value="全选" /> </th>
						<th>ID</th>
						<th>UID</th>
						<th>地址</th>
						<th>城市</th>
						<th>经度</th>
						<th>维度</th>
						<th>操作</th>
					</tr>
					<#list page.list as weiboLonlat>
					<tr>
						<td><input name="checkboxlonlat" type="checkbox" value="${weiboLonlat.id }" /></td>
						<td>${weiboLonlat.id }</td>
						<td>${weiboLonlat.uid }</td>
						<td>${weiboLonlat.coordinate }</td>
						<td><input name="city" type="input" id="id${weiboLonlat.id }"/></td>
						<td>${weiboLonlat.longitude }</td>
						<td>${weiboLonlat.latitude }</td>
						
						<td>
							<div class="btn-group">
								<a class="btn btn-info dropdown-toggle" 
									href="#" onclick="getLatlon('${weiboLonlat.id }')" title="获取经纬度">获取经纬度
								</a>
							</div></td>
					</tr>
					</#list>
				</tbody>

			</table>
			<a class="btn btn-info dropdown-toggle" 
									href="#" onclick="addAllLatlon()" title="批量获取经纬度">批量获取经纬度
								</a>
		</section>
		共${page.total }条记录&nbsp;&nbsp;共${page.pages }页&nbsp;&nbsp;当前第${page.pageNum }页&nbsp;&nbsp;
			<a href="#" onclick="firstPage('${page.pageNum}','${page.pages }');">首页</a>&nbsp;&nbsp; 
			<a href="#" onclick="previousPage('${page.pageNum}','${page.pages }');">上一页</a>&nbsp;&nbsp;
			<a href="#" onclick="nextPage('${page.pageNum}','${page.pages }');">下一页</a>&nbsp;&nbsp; 
			<a href="#" onclick="lastPage('${page.pageNum}','${page.pages }');">尾页</a>

	</div>
</div>

<script>
$(document).ready(function(){ 
	 $("#checkall").click(function() {  
	        $("input[name='checkboxlonlat']").each(function() {  
	        	if(this.checked){ 
	        		 $(this).attr("checked", false); 
	            }else{ 
	            	 $(this).attr("checked", true); 
	            } 
	        }); 
	    }); 
}); 
function addAllLatlon(){
	var valArr = new Array;
	$("#list :checkbox[checked]").each(function(i){
		valArr[i] = $(this).val();
	});
	var vals = valArr.join(',');//转换为逗号隔开的字符串 join 拼合
	
	if(vals==""){
		alert("请选择转换数据！");
		return;
	}
	window.location.href="/lonlat/getAllLatlon?ids="+vals;
	
}
function getLatlon(id){
	var city = $("#id"+id).val();
	if(city==""){
		window.location.href="/lonlat/getLatlon?id="+id;
	}else{
		window.location.href="/lonlat/getLatlon?id="+id+"&city="+city;
	}
	//window.location.href="/lonlat/getLatlon?id="+id;
}
function getLatlon1(id){
	 $.ajax({  
         type : "POST",  //提交方式  
         url : "/lonlat/add",//路径  
         data : {  
             "id" : id  
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
</script>
</@override> <@extends name="/base/base.ftl"/>
