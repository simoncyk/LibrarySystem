<%@ page contentType="text/html; charset=utf-8" language="java" import="java.sql.*" errorPage="" isELIgnored="false" %>
<%@ taglib prefix="c" uri ="http://java.sun.com/jsp/jstl/core"%>
<%@ page import="java.util.*"%>
<html>
<%
Collection coll=(Collection)request.getAttribute("Bremind");
%>
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
        <td height="22" valign="top" class="word_orange">当前位置：系统查询 &gt; 借阅到期提醒  &gt;&gt;&gt;</td>
      </tr>
      <tr>
        <td align="center" valign="top">
  <c:choose>
       <c:when test="${empty applicationScope.Bremind }">
          <table width="100%" height="30"  border="0" cellpadding="0" cellspacing="0">
            <tr>
              <td height="36" align="center">暂无到期提醒信息！</td>
            </tr>
          </table>
       </c:when>
       <c:otherwise>
        <table width="98%"  border="1" cellpadding="0" cellspacing="0" bordercolor="#FFFFFF" bordercolordark="#F6B83B" bordercolorlight="#FFFFFF">
        <tr align="center" bgcolor="#e3F4F7">
          <td width="15%" bgcolor="#F9D16B">图书条形码</td>
          <td width="28%" bgcolor="#F9D16B">图书名称</td>
          <td width="17%" bgcolor="#F9D16B">读者条形码</td>
          <td width="9%" bgcolor="#F9D16B">读者名称</td>
          <td width="15%" bgcolor="#F9D16B">借阅时间</td>
          <td width="16%" bgcolor="#F9D16B">应还时间</td>
          </tr>
       <c:forEach items="${applicationScope.Bremind}" var="Bremind">
          <tr>
            <td style="padding:5px;">&nbsp;${Bremind.bookbarcode}</td>
            <td style="padding:5px;">${Bremind.bookname}</td>
            <td style="padding:5px;">&nbsp;${Bremind.readerbarcode}</td>
            <td style="padding:5px;">&nbsp;${Bremind.name}</td>
            <td style="padding:5px;">&nbsp;${Bremind.borrowTime}</td>
            <td style="padding:5px;">&nbsp;${Bremind.backTime}</td>
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
