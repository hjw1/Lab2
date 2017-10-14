<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix="s" uri="/struts-tags"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>添加作者</title>
<link href="css/bootstrap.min.css" rel="stylesheet">
<script src="jquery/jquery-3.2.1.min.js"></script>
<script src="js/bootstrap.min.js"></script>
</head>
<body>
     <div class="navbar navbar-default" role="navigation">
		<ul class="nav navbar-nav">
			<li><a href="hello"><strong>网站首页</strong><small>Homepage</small></a></li>
			<li><a href="authorbook"><strong>查询作者所有图书</strong><small>Search
						books of some author</small></a></li>
			<li><a href="increase"><strong>增添图书</strong><small>Add
						books</small></a></li>
			<li><a href="update"><strong>更新图书信息</strong><small>Update
						book information</small></a></li>
			<li><a href="contact"><strong>联系站长</strong><small>Contact
						with the stationmaster</small></a></li>
		</ul>
	</div>
	
	
	<div class="row">
	<div class="col-md-6 col-md-offset-3">
	<h3>更新图书信息</h3>
	<form class="form"  action="updateauthor" method="post">
	    <div class="form-group">
			<label>作者名:</label> 
			<input  name="updatebookauthor" type="text" class="form-control" readonly="readonly"
			value='<s:property value="updatebookauthor"/>' >
		</div>
		<div class="form-group">
			<label>作者ID:</label> 
			<input  name="updateauthorid" type="text" class="form-control" required="required">
		</div>
		<div class="form-group">
			<label>作者年龄:</label> 
			<input  name="updateage" type="text" class="form-control" required="required">
		</div>
		<div class="form-group">
			<label>作者国籍:</label> 
			<input  name="updatecountry" type="text" class="form-control" required="required">
		</div>
		<div class="form-group">
			<label>图书名字:</label> 
			<input  name="updatebookname" type="text" class="form-control" readonly="readonly"
			value='<s:property value="updatebookname"/>'>
		</div>
		<div class="form-group">
			<label>图书ISBN:</label> 
			<input  name="updatebookisbn" type="text" class="form-control" readonly="readonly"
			value='<s:property value="updatebookisbn"/>'>
		</div>
		<div class="form-group">
			<label>图书出版商:</label> 
			<input  name="updatebookpublisher" type="text" class="form-control" readonly="readonly"
			value='<s:property value="updatebookpublisher"/>'>
		</div>
		<div class="form-group">
			<label>图书出版年:</label> 
			<input  name="updatebookpublishyear" type="text" class="form-control" readonly="readonly"
			value='<s:property value="updatebookpublishyear"/>' >
		</div>
		<div class="form-group">
			<label>图书出版月(10以内请输入0x的形式，eg:08):</label> 
			<input  name="updatebookpublishmonth" type="text" class="form-control" readonly="readonly"
			value='<s:property value="updatebookpublishmonth"/>' >
		</div>
		<div class="form-group">
			<label>图书出版日(10以内请输入0x的形式，eg:08):</label> 
			<input  name="updatebookpublishday" type="text" class="form-control" readonly="readonly"
			value='<s:property value="updatebookpublishday"/>' >
		</div>
		<div class="form-group">
			<label>图书价格:</label> 
			<input  name="updatebookprice" type="text" class="form-control" readonly="readonly"
			value='<s:property value="updatebookprice"/>' >
		</div>
	<button type="submit" class="btn btn-default">Submit</button>
	</form>
	</div>
	</div>

	<a href="hello">返回首页</a>
</body>
</html>