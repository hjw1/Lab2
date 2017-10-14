<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix="s" uri="/struts-tags"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>输入要更新的图书的名字</title>
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
	<div class="col-md-6 col-md-offset-4">
	<form class="form-inline"  action="updatebook" method="post">
		<div class="form-group">
			<label>更新图书的名字:</label> 
			<input  name="updatebookname" type="text" class="form-control" required="required">
		</div>
		<button type="submit" class="btn btn-default">Submit</button>
	</form>
	</div>
	</div>

</body>
</html>