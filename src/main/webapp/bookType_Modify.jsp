<%@ page contentType="text/html; charset=utf-8" language="java"  errorPage="" isELIgnored="false" %>
<%@ taglib prefix="c" uri ="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
<title>修改图书类型信息</title>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<link rel="stylesheet" href="CSS/style.css">
</head>
<body>
<table width="292" height="175" border="0" cellpadding="0" cellspacing="0" background="Images/subBG.jpg">
  <tr>
    <td valign="top"><table width="100%" border="0" cellpadding="0" cellspacing="0">
      <tr>
        <td width="3%" height="25">&nbsp;</td>
        <td width="94%">&nbsp;</td>
        <td width="3%">&nbsp;</td>
      </tr>
      <tr>
        <td>&nbsp;</td>
        <td><table width="100%" height="131"  border="0" cellpadding="0" cellspacing="0">
          <tr>
            <td align="center" valign="top">
                <form name="form1" method="post" action="<%=request.getContextPath()%>/Servlet">
 <input name="id" type="hidden" size="50" value="${booktype.id}">
 <input name="method" type="hidden" size="50" value="bookTypeModify">
  <table width="100%" height="111" border="0" cellpadding="0" cellspacing="0">
  <tr>
    <td width="29%" align="center">类型名称：      </td>
    <td width="71%"><input name="typeName" type="text" size="30" value="${booktype.typename}">
      </td>
  </tr>
  <tr>
    <td align="center">可借天数：</td>
    <td><input name="days" type="text" size="25" value="${booktype.days}">
      (天)</td>
  </tr>
  <tr>
    <td>&nbsp;</td>
    <td><input name="Submit" type="submit" class="btn_grey" value="保存">
&nbsp;
<input name="Submit2" type="reset" class="btn_grey" value="重置">
&nbsp;
<input name="Submit3" type="button" class="btn_grey" onClick="window.close()" value="关闭"></td>
  </tr>
</table>
</form></td>
          </tr>
        </table></td>
        <td>&nbsp;</td>
      </tr>
      <tr>
        <td>&nbsp;</td>
        <td>&nbsp;</td>
        <td>&nbsp;</td>
      </tr>
    </table></td>
  </tr>
</table>
</body>
</html>
