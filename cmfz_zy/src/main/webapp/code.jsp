<%@page pageEncoding="utf-8" %>
<html>
<head lang="en">
    <meta charset="UTF-8" />
    <title>hello</title>
</head>
<body>
<h1 th:text="${info}" />
<div>
    <!-- <img alt="这是图片" src="/img/001.png"/> -->
    <img alt="验证码" onclick = "this.src='${pageContext.request.contextPath}/securityCode/defaultKaptcha?d='+new Date()*1" src="${pageContext.request.contextPath}/securityCode/defaultKaptcha" />
</div>
<form action="${pageContext.request.contextPath}/securityCode/imgvrifyControllerDefaultKaptcha">
    <input type="text" name="vrifyCode" />
    <input type="submit" value="提交"/>
</form>
</body>
</html>