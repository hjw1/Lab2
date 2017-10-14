<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix="s" uri="/struts-tags"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>全部图书</title>
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
	<p>全部图书</p>
	<div class="thumbnail">
	
	<table class="table table-hover">
	        <tr>
	            <td>图书详细信息</td>
	            <td>删除选项</td>
	        </tr>
		<s:iterator value="bookList">
			<tr>
				<td><a href="detailinfo?id=<s:property/>"><s:property /></a></td>
				<td><a href="deletebook?id=<s:property/>">删除</a></td>
			</tr>
		</s:iterator>
	</table>
	</div>
	</div>
	</div>
</body>

</html>