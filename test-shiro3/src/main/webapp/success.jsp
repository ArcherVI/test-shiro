<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="shiro" uri="http://shiro.apache.org/tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	${info } 欢迎你!
	
	<shiro:hasPermission name="sys:t">
	欢迎有sys:t的用户！<shiro:principal />
	</shiro:hasPermission>
	
	
	<shiro:hasPermission name="sys:s">
	欢迎有sys:s权限的用户！<shiro:principal />
	</shiro:hasPermission>
</body>
</html>