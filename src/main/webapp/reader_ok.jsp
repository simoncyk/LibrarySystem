<%@ page contentType="text/html; charset=utf-8" language="java" errorPage="" isELIgnored="false" %>
<%@ taglib prefix="c" uri ="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
<title>操作成功!</title>
<meta http-equiv="Content-Type" content="text/html; charset=gb2312">
</head>

<body>

<c:choose>
	<c:when test="${requestScope.para eq 1}">
		<script language="javascript">
			alert("读者信息添加成功!");
			window.location.href="Servlet?method=readermsg";
		</script>

	</c:when>
	<c:when test="${requestScope.para eq 2}">
		<script language="javascript">
			alert("读者信息修改成功!");
			window.location.href="Servlet?method=readermsg";
		</script>
	</c:when>
	<c:when test="${requestScope.para eq 3}">
		<script language="javascript">
			alert("读者信息删除成功!");
			window.location.href="Servlet?method=readermsg";
		</script>

	</c:when>

</c:choose>

</body>
</html>