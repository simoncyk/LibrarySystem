<%@ page contentType="text/html; charset=utf-8" language="java" errorPage="" isELIgnored="false" %>
<%@ taglib prefix="c" uri ="http://java.sun.com/jsp/jstl/core"%>
<%@ page import="java.util.*"%>
<html>
<c:choose>
    <c:when test="${applicationScope.booktype eq null or empty applicationScope.booktype }"><script>alert('请先录入图书类型信息!');history.back(-1);</script></c:when>
    <c:when test="${applicationScope.bookcase eq null or empty applicationScope.bookcase }"><script>alert('请先录入书架信息!!');history.back(-1);</script></c:when>
    <c:when test="${applicationScope.publishing eq null or empty applicationScope.publishing }"><script>alert('请先录入出版社信息!');history.back(-1);</script></c:when>
</c:choose>

<script language="jscript">
function check(form){
	if(form.barcode.value==""){
		alert("请输入条形码!");form.barcode.focus();return false;
	}
	if(form.bookName.value==""){
		alert("请输入图书姓名!");form.bookName.focus();return false;
	}
	if(form.price.value==""){
		alert("请输入图书定价!");form.price.focus();return false;
	}
}
</script>
<head>
<title>图书馆管理系统</title>
<link href="CSS/style.css" rel="stylesheet">
</head>
<body onLoad="clockon(bgclock)">
<%@include file="banner.jsp"%>
<%@include file="navigation.jsp"%>
<table width="778"  border="0" cellspacing="0" cellpadding="0" align="center">
  <tr>
    <td valign="top" bgcolor="#FFFFFF"><table width="99%" height="510"  border="0" align="center" cellpadding="0" cellspacing="0" bgcolor="#FFFFFF" class="tableBorder_gray">
  <tr>
    <td height="510" valign="top" style="padding:5px;"><table width="98%" height="487"  border="0" cellpadding="0" cellspacing="0">
      <tr>
        <td height="22" valign="top" class="word_orange">当前位置：图书管理 &gt; 图书档案管理 &gt; 修改图书信息 &gt;&gt;&gt;</td>
      </tr>
      <tr>
        <td align="center" valign="top"><table width="100%" height="493"  border="0" cellpadding="0" cellspacing="0">
  <tr>
    <td align="center" valign="top">
	<form name="form1" method="post" action="<%=request.getContextPath()%>/Servlet">

	<table width="600" height="432"  border="0" cellpadding="0" cellspacing="0" bgcolor="#FFFFFF">
      <tr>
        <td width="173" align="center"><input name="ID" type="hidden" id="id" value="${bookModify.id}">
          条&nbsp;形&nbsp;码：</td>
        <td width="427" height="39">
          <input name="barcode" type="text" id="barcode" value="${bookModify.barcode}"></td>
      </tr>
      <tr>
        <td align="center">图书名称：</td>
        <td height="39"><input name="bookName" type="text" id="bookName" value="${bookModify.bookname}" size="60">
          * </td>
      </tr>
      <tr>
        <td align="center">图书类型：</td>
        <td>
		<select name="typeId" class="wenbenkuang" id="typeId">
           <c:forEach items="${applicationScope.booktype}" var="booktype">
              <option value="${booktype.id}" <c:if test="${booktype.id eq bookModify.id }" >selected= "selected"</c:if>  >${booktype.typename}</option>
           </c:forEach>
        </select>        </td>
      </tr>
      <tr>
        <td align="center">作者：</td>
        <td><input name="author" type="text" id="author" value="${bookModify.author}"></td>
      </tr>
      <tr>
        <td align="center">译者：</td>
        <td><input name="translator" type="text" id="translator" value="${bookModify.translator}"></td>
      </tr>
      <tr>
        <td align="center">出版社：</td>
        <td><select name="isbn" class="wenbenkuang">

            <c:forEach items="${applicationScope.publishing}" var="publishing">
                <option value="${publishing.ISBN}" <c:if test="${publishing.ISBN eq bookModify.ISBN }" >selected= "selected"</c:if>  >${publishing.pubname}</option>
            </c:forEach>

        </select> </td>
      </tr>
      <tr>
        <td align="center">价格：</td>
        <td><input name="price" type="text" id="price" value="${bookModify.price}">(元) * </td>
      </tr>
      <tr>
        <td align="center">页码：</td>
        <td><input name="page" type="text" id="page" value="${bookModify.page}"></td>
      </tr>
      <tr>
        <td align="center">书架：</td>
        <td><select name="bookcaseid" class="wenbenkuang" id="bookcaseid">

            <c:forEach items="${applicationScope.bookcase}" var="bookcase">
                <option value="${bookcase.id}" <c:if test="${bookcase.id eq bookModify.bookcase }" >selected= "selected"</c:if> >${bookcase.name}</option>
            </c:forEach>

        </select>
          <input name="operator" type="hidden" id="operator" value="${sessionScope.manger.name}">
          <input name="method" type="hidden"  value="bookModify">
        </td>
      </tr>
     
      <tr>
        <td align="center">&nbsp;</td>
        <td><input name="Submit" type="submit" class="btn_grey" value="保存" onClick="return check(form1)">
&nbsp;
<input name="Submit2" type="button" class="btn_grey" value="返回" onClick="history.back()"></td>
      </tr>
    </table>
	</form>
	</td>
  </tr>
</table></td>
      </tr>
    </table>
</td>
  </tr>
</table><%@ include file="copyright.jsp"%></td>
  </tr>
</table>
</body>
</html>
