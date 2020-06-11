<%@page import="java.util.ArrayList"%>
<%@page import="cn.com.dhc.bean.User" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%
		ArrayList<User> list = (ArrayList)(session.getAttribute("list"));
		if(request.getParameter("Message")!= null){ %>
		欢迎<%=request.getAttribute("name_dl")%>
	
	<% 
	}
	%>
	<form>
		<table border="1" >
		<tr>
				<td>编号</td>
				<td>姓名</td>
				<td>密码</td>
				<td>性别</td>
				<td>email</td>
				<td>权限</td>
				<td colspan="2">操作</td>
			</tr>
		<%for(User u : list) {%>
			<tr>
				<td><%=u.getId() %></td>
				<td><%=u.getName() %></td>
				<td><%=u.getPwd() %></td>
				<td><%=u.getSex()==1 ?  "男" : "女" %></td>
				<td><%=u.getEmail() %></td>
				<td><%=u.getPower()== 1 ? "管理员" : "普通用户" %>
				<td><a href="update.jsp ? name= <%=u.getName()%>">修改</a></td>
				<td><a href="DeleteServlet?name= <%=u.getName()%>">删除</a></td>
			</tr>
		<%} %>
		</table>
	</form>
</body>
</html>