<%@ page contentType="text/html; charset=utf-8" language="java"  errorPage="" isELIgnored="false" %>
<%@ taglib prefix="c" uri ="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
<title>操作成功!</title>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
</head>

<body>
<script language="javascript">
alert("口令更改成功!");
window.location.href="Servlet?method=vmodifypwd&id=${sessionScope.manger.id}";
</script>		
</body>
</html>