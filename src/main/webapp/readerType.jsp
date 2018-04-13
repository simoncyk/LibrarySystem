<%@ page contentType="text/html; charset=utf-8" language="java"  errorPage="" isELIgnored="false" %>
<%@ taglib prefix="c" uri ="http://java.sun.com/jsp/jstl/core"%>
<%@ page import="java.util.*"%>
<html>

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
        <td height="22" valign="top" class="word_orange">当前位置：读者管理 &gt; 读者类型管理 &gt;&gt;&gt;</td>
      </tr>
      <tr>
        <td align="center" valign="top">

   <c:choose>
       <c:when test="${empty applicationScope.readerType}">

          <table width="100%" height="30"  border="0" cellpadding="0" cellspacing="0">
            <tr>
              <td height="36" align="center">暂无读者类型信息！</td>
            </tr>
          </table>
          <table width="100%"  border="0" cellspacing="0" cellpadding="0">
          <tr>
            <td>
              <a href="#" onClick="window.open('readerType_add.jsp','','width=292,height=175')">添加读者类型信息</a> </td>
          </tr>
        </table>
        </c:when>
    <c:otherwise>
     <table width="91%"  border="0" cellspacing="0" cellpadding="0">
      <tr>
        <td align="right">
          <a href="#" onClick="window.open('readerType_add.jsp','','width=292,height=175')">添加读者类型信息</a> </td>
    </tr>
    </table>
      <table width="91%"  border="1" cellpadding="0" cellspacing="0" bordercolor="#FFFFFF" bordercolordark="#F6b83B" bordercolorlight="#FFFFFF">
      <tr align="center" bgcolor="#e3F4F7">
        <td width="35%" bgcolor="#F9D16B">读者类型名称</td>
        <td width="35%" bgcolor="#F9D16B">可借数量</td>
        <td width="16%" bgcolor="#F9D16B">修改</td>
        <td width="14%" bgcolor="#F9D16B">删除</td>
      </tr>

         <c:forEach items="${applicationScope.readerType}" var="readerType">
        <tr>
          <td style="padding:5px;">&nbsp;${readerType.name}</td>
          <td style="padding:5px;">&nbsp;${readerType.number}</td>
          <td align="center"><a href="#" onClick="window.open('Servlet?method=VreaderTypeModify&ID=${readerType.id}','','width=292,height=175')">修改</a></td>
          <td align="center"><a href="Servlet?method=readerTypeDel&ID=${readerType.id}">删除</a></td>
        </tr>
        </c:forEach>
      </c:otherwise>
</c:choose>
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
