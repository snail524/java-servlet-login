<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
  <h1>Login System in login.jsp</h1>
  <form action="LoginServlet" method="post">
    <label for="fname">帳號:</label>
    <input type="text" id="fname" name="name"><br><br>
    <label for="lname">密碼:</label>
    <input type="text" id="lname" name="password"><br><br>
    <a href="register.jsp">到註冊頁</a>
    <input type="submit" value="送出">
  </form>

</body>
</html>