<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script type="text/javascript" src="js/jquery.js"></script>
<title>dailyDemo登陆</title>
<script type="text/javascript">
		/* 敲击回车登陆 */
		$("body").keydown(function() {
			if (event.keyCode == "13") {//keyCode=13是回车键
				$('registerBtn').click();
			}
		});
		/* 登陆 */
		function registerUser() {
			/* 	获取用户名和密码，判断用户名和密码是否为空 */
			var account = $(":input[name='account']").val();
			var password = $(":input[name='password']").val();
			var nikename = $(":input[name='nikename']").val();
			if (account == "" || password == "" || nikename=="") {
				alert("请输入用户名或者密码或者昵称！！！");
				return;
			}
		/* 发送登陆请求 */
		$.ajax({
			url : 'user/addUser',
			data : {'account' : account,'password' : password,'nikename' : nikename},
			type : 'POST',
			success : function(data,textStatus) {
				alert(data.message);
				if (data.success) {
					$.messager.alert('提示',data.message,'info',function(){
						$.post('login','',function(){});
					});
				} else {
					$.messager.alert('提示',data.message,'info');
				}
			}
		});
	}
	function login(){
		location.href="${pageContext.request.contextPath}/login";
	}
</script>
</head>
<body>
	<form id="login">
		<table id="table">
			<tr>
				<td>账号：</td>
				<td><input type="text" name="account"></td>
			</tr>
			<tr>
				<td>密码：</td>
				<td><input type="password" name="password"></td>
			</tr>
			<tr>
				<td>昵称：</td>
				<td><input type="text" name="nikename"></td>
			</tr>
			<tr>
				<td colspan="2"><input id="registerBtn" type="button"
					value="注册" onclick="registerUser()"><input type="button"
					value="登陆" onclick="login()"></td>
			</tr>
		</table>
	</form>
	
</body>
</html>