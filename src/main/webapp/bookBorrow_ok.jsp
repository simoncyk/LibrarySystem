<%@ page contentType="text/html; charset=utf-8" language="java"  errorPage="" isELIgnored="false"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<script language="javascript">


	window.location.href="borrow.do?action=bookborrow&barcode=<%=request.getAttribute("bar")%>";
</script>
<c:choose>
	<c:when test="${requestScope.para eq 1}">
		<script language="javascript">
			alert("添加借阅信息失败:所查找的书籍不存在");
			window.location.href="Servlet?method=bookborrow&readerbarcode="+${requestScope.readerbarcode};
			window.close();
		</script>
	</c:when>
</c:choose>