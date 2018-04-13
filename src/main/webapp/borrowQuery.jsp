<%@ page contentType="text/html; charset=utf-8" language="java"  errorPage="" isELIgnored="false" %>
<%@ taglib prefix="c" uri ="http://java.sun.com/jsp/jstl/core"%>
<%@ page import="java.util.*"%>
<html>
<%
Collection coll=(Collection)request.getAttribute("borrowQuery");
%>
<head>
<title>图书馆管理系统</title>
<link href="CSS/style.css" rel="stylesheet">
<script src="JS/function.js"></script>
<script language="javascript">
function check(myform){
	if(myform.flag[0].checked==false && myform.flag[1].checked==false){
		alert("请选择查询方式!");return false;
	}
	if (myform.flag[1].checked){
		if(myform.sdate.value==""){
			alert("请输入开始日期");myform.sdate.focus();return false;
		}		
		if(CheckDate(myform.sdate.value)){
			alert("您输入的开始日期不正确（如：2006-07-05）\n 请注意闰年!");myform.sDate.focus();return false;
		}
		if(myform.edate.value==""){
			alert("请输入结束日期");myform.edate.focus();return false;
		}		
		if(CheckDate(myform.edate.value)){
			alert("您输入的结束日期不正确（如：2006-07-05）\n 请注意闰年!");myform.edate.focus();return false;
		}
	}
}
</script>
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
        <td height="22" valign="top" class="word_orange">当前位置：系统查询 &gt; 图书借阅查询 &gt;&gt;&gt;</td>
      </tr>
      <tr>
        <td align="center" valign="top">
		<form name="myform" method="post" action="Servlet">
            <input name="method" type="hidden" id="id" value="borrowQuery">
          <table width="98%" height="67"  border="0" cellpadding="0" cellspacing="0" bgcolor="#E3F4F7" class="tableBorder_gray">
            <tr>
              <td rowspan="2" align="center" bgcolor="#F9D16B">&nbsp;<img src="Images/search.gif" width="45" height="28"></td>
              <td height="29" bgcolor="#F9D16B"><input name="flag" type="checkbox" class="noborder" value="a" checked>
                请选择查询依据：
                <select name="f" class="wenbenkuang" id="f">
                  <option value="bookbarcode">图书条形码</option>
                  <option value="bookname">图书名称</option>
                  <option value="readerbarcode">读者条形码</option>
                  <option value="name">读者名称</option>
                  </select>
                  <input name="key" type="text" id="key" size="50">
                  <input name="Submit" type="submit" class="btn_grey" value="查询" onClick="return check(myform)"></td>
            </tr>
            <tr>
              <td height="26" bgcolor="#F9D16B">
                <input name="flag" type="checkbox" class="noborder" value="b">
                借阅时间：                从
                <input name="sdate" type="text" id="sdate">
                到
                <input name="edate" type="text" id="edate">
                (日期格式为：2006-07-05)</td>
            </tr>
          </table>		
		</form>
 <c:choose>
    <c:when test="${empty applicationScope.borrowQuery}">
          <table width="100%" height="30"  border="0" cellpadding="0" cellspacing="0">
            <tr>
              <td height="36" align="center">暂无图书借阅信息！</td>
            </tr>
          </table>
    </c:when>
    <c:otherwise>
          <table width="98%"  border="1" cellpadding="0" cellspacing="0" bordercolor="#FFFFFF" bordercolordark="#F6B83B" bordercolorlight="#FFFFFF">
            <tr align="center" bgcolor="#e3F4F7">
              <td width="11%" bgcolor="#F9D16B">图书条形码</td>
              <td width="29%" bgcolor="#F9D16B">图书名称</td>
              <td width="15%" bgcolor="#F9D16B">读者条形码</td>
              <td width="13%" bgcolor="#F9D16B">读者名称</td>
              <td width="12%" bgcolor="#F9D16B">借阅时间</td>
              <td width="12%" bgcolor="#F9D16B">应还时间</td>
              <td width="8%" bgcolor="#F9D16B">是否归还</td>
            </tr>

            <c:forEach items="${applicationScope.borrowQuery}" var="borrowQuery">
              <tr>
                <td style="padding:5px;">&nbsp;${borrowQuery.bookbarcode}</td>
                <td style="padding:5px;">${borrowQuery.bookname}</td>
                <td style="padding:5px;">&nbsp;${borrowQuery.readerbarcode}</td>
                <td style="padding:5px;">&nbsp;${borrowQuery.name}</td>
                <td style="padding:5px;">&nbsp;${borrowQuery.borrowTime}</td>
                <td style="padding:5px;">&nbsp;${borrowQuery.backTime}</td>
                <td align="center" style="padding:5px;">&nbsp;${borrowQuery.ifback eq 0 ? "未归还":"已归还"}</td>
              </tr>
            </c:forEach>

      </c:otherwise>
</c:choose>

    </table>
          </td>
      </tr>
    </table>
</td>
  </tr>
</table><%@ include file="copyright.jsp"%></td>
  </tr>
</table>
</body>
</html>
