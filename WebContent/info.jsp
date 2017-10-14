<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix="s" uri="/struts-tags"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>图书具体信息</title>
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
	<div class="col-md-4 col-md-offset-1">
	<p>图书信息</p>
	<div class="thumbnail">
	<table class="table table-hover">
	        <tr>
	            <td>图书ISBN</td>
	            <td><s:property value="isbn" /></td>
	        </tr>
	        <tr>
	            <td>图书题目</td>
	            <td><s:property value="title" /></td>
	        </tr>
	        <tr>
	            <td>图书作者id</td>
	            <td><s:property value="authorid" /></td>
	        </tr>
	        <tr>
	            <td>图书出版商</td>
	            <td><s:property value="publisher" /></td>
	        </tr>
	        <tr>
	            <td>图书出版日期</td>
	            <td><s:property value="publishdate" /></td>
	        </tr>
	        <tr>
	            <td>图书价格</td>
	            <td><s:property value="price" /></td>
	        </tr>
	</table>
	</div>
	</div>

	<div class="col-md-4 col-md-offset-1">
	<p>作者信息</p>
	<div class="thumbnail">
	<table class="table table-hover">
	        <tr>
	            <td>作者名字</td>
	            <td><s:property value="name" /></td>
	        </tr>
	        <tr>
	            <td>作者id</td>
	            <td><s:property value="authorid" /></td>
	        </tr>
	        <tr>
	            <td>作者年龄</td>
	            <td><s:property value="age" /></td>
	        </tr>
	        <tr>
	            <td>作者国籍</td>
	            <td><s:property value="country" /></td>
	        </tr>
	</table>
	</div>
	</div>
	</div>
	
</body>
</html>