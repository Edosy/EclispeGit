<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<script src="res/js/jquery-3.2.1.js" type="text/javascript"></script>
<script type="text/javascript" language="JavaScript" src="res/js/checkForm.js"></script>
<style> 
#container {
	text-align: left;
}

table {
	border-color: antiquewhite;
}

#t_div_name, #t_div_pwd, #t_div_pwd_two, #t_div_email {
	border-left: hidden;
}

#t_text_name, #t_text_pwd, #t_text_pwd_two, #t_email {
	border-right: hidden;
}
</style>
<body>
	<div id="container">
		<form action="RegisterServlet" method="post" >
			<table align="center" border="1" cellpadding="5" cellspacing="0"
				bordercolor="">
				<tr align="center">
					<td colspan="3"><h1>注册页面</h1></td>
				</tr>
				<tr>
					<td>用户名：</td>
					<td id="t_text_name"><input type="text" name="u_name"
						id="username" placeholder="请输入用户名：" onblur="check_name()" /></td>
					<td id="t_div_name"><div id="check_name_img"></div></td>
				</tr>
				<tr>
					<td>密码：</td>
					<td id="t_text_pwd"><input type="password" name="u_pwd"
						id="pwd" placeholder="请输入密码：" onblur="check_pwd()" /></td>
					<td id="t_div_pwd"><div id="check_pwd_img"></div></td>
				</tr>
				<tr>
					<td>确认密码：</td>
					<td id="t_text_pwd_two"><input type="password" name="u_pwd_2"
						placeholder="请输入密码：" onblur="check_pwd_two()" /></td>
					<td id="t_div_pwd_two"><div id="check_pwd_two_img"></div></td>
				</tr>
				<tr>
					<td>性别：</td>
					<td><input type="radio" name="sex" value="1" />男&nbsp;&nbsp;&nbsp;&nbsp;
						<input type="radio" name="sex" value="0" />女</td>
				</tr>
				<tr>
					<td>Email:</td>
					<td id="t_email"><input type="text" name="email" id="email"
						placeholder="请输入邮箱：" onblur="check_email()" /></td>
					<td id="t_div_email"><div id="check_email_img"></div></td>
				</tr>
				<tr>
					<td colspan="3" style="text-align: center;"><input
						type="checkbox" name="u_xieyi" id="xieyi" /> 我已同意</td>
				</tr>
				<tr>
					<td align="center" colspan="3"><input type="submit"
						id="denglu" value="注册"
						style="font-size: 15px; margin-right: 40px;" disabled="disabled" /><input
						type="reset" value="重置" style="font-size: 15px;" /></td>
				</tr>
			</table>
		</form>
	</div>
</body>
</html>