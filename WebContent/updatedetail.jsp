<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix="s" uri="/struts-tags" %>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>更新图书具体信息</title>
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
	<form class="form"  action="updateresult" method="post">
	    <div class="form-group">
			<label>图书名字:</label> 
			<input  name="updatenewbookname" type="text" class="form-control" readonly="readonly"
			value='<s:property value="updatenewbookname"/>' >
		</div>
		<div class="form-group">
			<label>图书ISBN:</label> 
			<input  name="updatenewbookisbn" type="text" class="form-control" readonly="readonly"
			value='<s:property value="updatenewbookisbn"/>' >
		</div>
		<div class="form-group">
			<label>图书作者名字:</label> 
			<input  name="updatenewbookauthor" type="text" class="form-control" required="required"
			value='<s:property value="updatenewbookauthor"/>' >
		</div>
		<div class="form-group">
			<label>图书出版商:</label> 
			<input  name="updatenewbookpublisher" type="text" class="form-control" required="required"
			value='<s:property value="updatenewbookpublisher"/>' >
		</div>
		<div class="form-group">
			<label>图书出版年(10以内请输入0x的形式，eg:08):</label> 
			<input  name="updatenewbookpublishyear" type="text" class="form-control" required="required"
			value='<s:property value="updatenewbookpublishyear"/>' >
		</div>
		<div class="form-group">
			<label>图书出版月(10以内请输入0x的形式，eg:08):</label> 
			<input  name="updatenewbookpublishmonth" type="text" class="form-control" required="required"
			value='<s:property value="updatenewbookpublishmonth"/>' >
		</div>
		<div class="form-group">
			<label>图书出版日:</label> 
			<input  name="updatenewbookpublishday" type="text" class="form-control" required="required"
			value='<s:property value="updatenewbookpublishday"/>' >
		</div>
		<div class="form-group">
			<label>图书价格:</label> 
			<input  name="updatenewbookprice" type="text" class="form-control" required="required"
			value='<s:property value="updatenewbookprice"/>' >
		</div>
	<button type="submit" class="btn btn-default">Submit</button>
	</form>
	</div>
	</div>
</body>
</html>