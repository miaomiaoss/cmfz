<%@page isELIgnored="false" pageEncoding="UTF-8" contentType="text/html; UTF-8" %>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
	<title>持名法州后台管理中心</title>
			
    <meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
    <meta http-equiv="description" content="this is my page">
    <meta http-equiv="content-type" content="text/html; charset=UTF-8">
    
	<link rel="icon" href="img/favicon.ico" type="image/x-icon" />
	<link rel="stylesheet" href="${pageContext.request.contextPath}/css/common.css" type="text/css"/>
	<link rel="stylesheet" href="${pageContext.request.contextPath}/css/login.css" type="text/css"/>
	<script type="text/javascript" src="script/jquery.js"></script>
	<script type="text/javascript" src="script/common.js"></script>
	<script type="text/javascript">

		$(function(){
			//点击更换验证码：
			$("#captchaImage").click(function(){//点击更换验证码
                $("#captchaImage").prop("src","${pageContext.request.contextPath}/securityCode/defaultKaptcha?time=\"+new Date().getTime()");
			});

			//验证用户名是否为空
			$("#name").blur(function () {
				checkName();
            });

			//验证密码是否为空
			$("#pwd").blur(function () {
				checkPwd()
            });

			//验证验证码框是否为空
			$("#enCode").blur(function () {
				checkCode();
            });

			//  form 表单提交
			$("#submit").click(function () {
			    //console.log(checkCode());
				if(checkName() && checkPwd() && checkCode()){
					$.post(
					    "${pageContext.request.contextPath}/login",
                        $('#loginForm').serialize(),
						function (res) {
					        console.log(res);
							if (res == "0"){
							    alert("用户名或密码输入错误");
							}else{
                                console.log(res);
							    location.href = "${pageContext.request.contextPath}/main/main.jsp";
							    //location.replace();
							}
                        },
						"json"
					);
				}
            });

		});
		//检查用户名
        function checkName(){
            var name = $("#name").val();
            if(name == null || name === ""){
                $("#nameErr").text("请输入用户名");
                return false;
            }else{
                $("#nameErr").text("");
                return true;
            }

        }
		//检查密码
        function checkPwd(){
            var pwd = $("#pwd").val();
            if(pwd == null || pwd === ""){
                $("#pwdErr").text("请输入密码");
                return false;
            }else{
                $("#pwdErr").text("");
                return true;
            }
        }
		//检查验证码
        function checkCode(){
            var code = $("#enCode").val();
            if(code == null || code === ""){
                $("#codeErr").text("请输入验证码");
                return false;
            }else{
                $("#codeErr").text("");
                return true;
            }

        }


	</script>
</head>
<body>
		${sessionScope.vrifyCode}
		<div class="login">
			<form id="loginForm" action="${pageContext.request.contextPath}/login" method="post" >
				
				<table>
					<tbody>
						<tr>
							<td width="190" rowspan="2" align="center" valign="bottom">
								<img src="img/header_logo.gif" />
							</td>
							<th>
								用户名:
							</th>
							<td>
								<input id="name" type="text" name="name" class="text" maxlength="20"/>
								<span id="nameErr" style="color: red"></span>
							</td>
					  </tr>
					  <tr>
							<th>
								密&nbsp;&nbsp;&nbsp;码:
							</th>
							<td>
								<input id="pwd" type="password" name="password" class="text" maxlength="20" autocomplete="off"/>
								<span id="pwdErr" style="color: red"></span>
							</td>
					  </tr>
					
						<tr>
							<td>&nbsp;</td>
							<th>验证码:</th>
							<td>
								<input id="enCode" type="text" id="enCode" name="enCode" class="text captcha" maxlength="4" autocomplete="off"/>
								<img id="captchaImage" class="captchaImage" src="${pageContext.request.contextPath}/securityCode/defaultKaptcha" title="点击更换验证码"/>
								<span id="codeErr" style="color: red"></span>
							</td>
						</tr>					
					<tr>
						<td>
							&nbsp;
						</td>
						<th>
							&nbsp;
						</th>
					</tr>
					<tr>
						<td>&nbsp;</td>
						<th>&nbsp;</th>
						<td>
							<input type="button" class="homeButton" value="" onclick="location.href='/'"><input id="submit" type="button" class="loginButton" value="登录">
						</td>
					</tr>
				</tbody></table>
				<div class="powered">COPYRIGHT © 2008-2017.</div>
				<div class="link">
					<a href="http://www.chimingfowang.com/">持名佛网首页</a> |
					<a href="http://www.chimingbbs.com/">交流论坛</a> |
					<a href="">关于我们</a> |
					<a href="">联系我们</a> |
					<a href="">授权查询</a>
				</div>
			</form>
		</div>
</body>
</html>