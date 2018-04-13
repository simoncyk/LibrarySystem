<%@ page contentType="text/html; charset=utf-8" language="java" import="java.sql.*" errorPage="" isELIgnored="false" %>
<%@ taglib prefix="c" uri ="http://java.sun.com/jsp/jstl/core"%>
<%@ page import="java.util.*"%>
<html>

<script language="jscript">
function check(form){
	if(form.name.value==""){
		alert("请输入读者姓名!");form.name.focus();return false;
	}
	if(form.paperNO.value==""){
		alert("请输入证件号码!");form.paperNO.focus();return false;
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
        <td height="22" valign="top" class="word_orange">当前位置：读者管理 &gt; 读者档案管理 &gt; 修改读者信息 &gt;&gt;&gt;</td>
      </tr>
      <tr>
        <td align="center" valign="top"><table width="100%" height="493"  border="0" cellpadding="0" cellspacing="0">
  <tr>

    <td align="center" valign="top">
	<form name="form1" method="post" action="<%=request.getContextPath()%>/Servlet">
	<table width="600" height="432"  border="0" cellpadding="0" cellspacing="0" bgcolor="#FFFFFF">
        <input name="method" type="hidden" id="method" value="readerModify">
      <tr>
        <td width="173" align="center">姓&nbsp;&nbsp;&nbsp;&nbsp;名：</td>
        <td width="427" height="39">
          <input name="name" type="text" value="${readermsg.name}" readonly="yes">
          *         
          <input name="id" type="hidden" id="id" value="${readermsg.id}"></td>
      </tr>
      <tr>
        <td width="173" align="center">性&nbsp;&nbsp;&nbsp;&nbsp;别：</td>
          <td height="35"><input name="sex" type="radio" class="noborder" id="radiobutton" value="男" <c:if test="${readermsg.sex eq '男'}"> checked</c:if>>
          <label for="radiobutton">男 </label>
          <label>
          <input name="sex" type="radio" class="noborder" value="女" <c:if test="${readermsg.sex eq '女'}"> checked</c:if>>
          女</label></td>
      </tr>
      <tr>
        <td align="center">条&nbsp;形&nbsp;码：</td>
        <td><input name="barcode" type="text" id="barcode" value="${readermsg.barcode}" readonly="yes"></td>
      </tr>
      <tr>
        <td align="center">读者类型：</td>
        <td>
		<select name="typeid" class="wenbenkuang" id="typeid">

            <c:forEach items="${applicationScope.readerType}" var="readerType">
            <option value="${readerType.id}" <c:if test="${readerType.id eq readermsg.typeid}"> selected ="selected" </c:if>>${readerType.name}</option>
            </c:forEach>

        </select>        </td>
      </tr>
      <tr>
        <td align="center">职&nbsp;&nbsp;&nbsp;&nbsp;业：</td>
        <td><input name="vocation" type="text" id="vocation" value="${readermsg.vocation}"></td>
      </tr>
      <tr>
        <td align="center">出生日期：</td>
        <td><input name="birthday" type="text" id="birthday" value="${readermsg.birthday}"></td>
      </tr>
      <tr>
        <td align="center">有效证件：</td>
        <td><select name="paperType" class="wenbenkuang" id="paperType">
          <option value="身份证"<c:if test="${readermsg.paperType eq '身份证'} "> selected ="selected" </c:if>>身份证</option>
          <option value="学生证"<c:if test="${readermsg.paperType eq '学生证'} "> selected ="selected" </c:if>>学生证</option>
          <option value="军官证"<c:if test="${readermsg.paperType eq '军官证'} "> selected ="selected" </c:if> >军官证</option>
          <option value="工作证"<c:if test="${readermsg.paperType eq '工作证'} "> selected ="selected" </c:if>>工作证</option>
                        </select></td>
      </tr>
      <tr>
        <td align="center">证件号码：</td>
        <td><input name="paperNO" type="text" id="paperNO" value="${readermsg.paperNO}">
          * </td>
      </tr>
      <tr>
        <td align="center">电&nbsp;&nbsp;&nbsp;&nbsp;话：</td>
        <td><input name="tel" type="text" id="tel" value="${readermsg.tel}"></td>
      </tr>
      <tr>
        <td align="center">Email：</td>
        <td><input name="email" type="text" id="email" value="${readermsg.email}" size="50">
          <%--<input name="operator" type="hidden" id="operator" value="${sessionScope.manger.name}"></td>--%>
      </tr>
      <tr>
        <td height="30" align="center">操&nbsp;作&nbsp;员：</td>
        <td><input name="operator" type="text" id="operator" value="${sessionScope.manger.name}" readonly="yes">
        </td>
      </tr>
      <tr>
        <td align="center">备&nbsp;&nbsp;&nbsp;&nbsp;注：</td>
        <td><textarea name="remark" cols="50" rows="5" class="wenbenkuang" id="remark">${readermsg.remark}</textarea></td>
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
