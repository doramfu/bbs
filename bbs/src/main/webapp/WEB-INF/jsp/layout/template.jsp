<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles" %>	
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>첫페이지(template)</title>
<style>
	.menu>ul {
		list-style-type: none;
	}
	.menu li {
		display: inline-block;
		width: 90px;
		margin: 10px;
		
	}
</style>
</head>
<body>
	<div class="head">
	<tiles:insertAttribute name="head"></tiles:insertAttribute>
	</div>
	
	<div class="menu">
	<tiles:insertAttribute name="menu"></tiles:insertAttribute>
	</div>
	
	<div class="body">
	<tiles:insertAttribute name="body"></tiles:insertAttribute>
	</div>

	<div class="foot">
	<tiles:insertAttribute name="foot"></tiles:insertAttribute>
	</div>	
	
</body>
</html>