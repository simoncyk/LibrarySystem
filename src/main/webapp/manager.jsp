<%@ page contentType="text/html; charset=utf-8" language="java" import="java.sql.*" errorPage=""  isELIgnored="false"%>
<%@ taglib prefix="c" uri ="http://java.sun.com/jsp/jstl/core"%>
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
        <td height="22" valign="top" class="word_orange">当前位置：系统设置 &gt; 管理员设置 &gt;&gt;&gt;</td>
      </tr>
      <tr>
        <td align="center" valign="top">

    <c:choose>
      <c:when test="${empty applicationScope.manger}">

                <table width="100%" height="30"  border="0" cellpadding="0" cellspacing="0">
                  <tr>
                    <td height="36" align="center">暂无管理员信息！</td>
                  </tr>
                </table>
                <table width="100%"  border="0" cellspacing="0" cellpadding="0">
        <tr>
          <td>
            <a href="#" onClick="window.open('manager_add.jsp','','width=292,height=175')">添加管理员信息</a> </td>
        </tr>
      </table>

      </c:when>
      <c:otherwise>

 <table width="100%"  border="0" cellspacing="0" cellpadding="0">
  <tr>
    <td width="84%">&nbsp;      </td>
<td width="16%">
      <a href="#" onClick="window.open('manager_add.jsp','','width=292,height=175')">添加管理员信息</a> </td>	  
  </tr>
</table>  
  <table width="91%"  border="1" cellpadding="0" cellspacing="0" bordercolor="#FFFFFF" bordercolordark="#F6B83B" bordercolorlight="#FFFFFF">

  <tr align="center" bgcolor="#e3F4F7">
    <td width="26%" bgcolor="#F9D16B">管理员名称</td>
    <td width="12%" bgcolor="#F9D16B">系统设置 </td>
    <td width="12%" bgcolor="#F9D16B">读者管理 </td>
    <td width="12%" bgcolor="#F9D16B">图书管理</td>
    <td width="11%" bgcolor="#F9D16B">图书借还</td>
    <td width="10%" bgcolor="#F9D16B">系统查询</td>
    <td width="9%" bgcolor="#F9D16B">权限设置</td>
    <td width="8%" bgcolor="#F9D16B">删除</td>
  </tr>
    <c:set var="limits" value="1"></c:set>
    <c:forEach items="${applicationScope.manger}" var="manger">
      <tr>
        <td style="padding:5px;">${manger.name}</td>
        <td align="center"><input name="checkbox" type="checkbox" class="noborder" value="checkbox" disabled="disabled" <c:if test="${manger.sysset eq 1}">checked="checked"</c:if> ></td>
        <td align="center"><input name="checkbox" type="checkbox" class="noborder" value="checkbox" disabled="disabled" <c:if test="${manger.readerset eq 1}">checked="checked"</c:if>></td>
        <td align="center"><input name="checkbox" type="checkbox" class="noborder" value="checkbox" disabled ="disabled"<c:if test="${manger.bookset eq 1}">checked="checked"</c:if>></td>
        <td align="center"><input name="checkbox" type="checkbox" class="noborder" value="checkbox" disabled="disabled" <c:if test="${manger.borrowback eq 1}">checked="checked"</c:if>></td>
        <td align="center"><input name="checkbox" type="checkbox" class="noborder" value="checkbox" disabled ="disabled"<c:if test="${manger.sysquery eq 1}">checked="checked"</c:if>></td>
        <td align="center"> <c:if test="${manger.name ne sessionScope.manger.name}"><a href="#" onClick="window.open('Servlet?method=managermodquery&id=${manger.id}','','width=292,height=175')">权限设置</a></c:if></td>
        <td align="center">
          <c:if test="${manger.name ne sessionScope.manger.name}"><a href="Servlet?method=managerDel&id=${manger.id}">删除</a></c:if></td>
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
