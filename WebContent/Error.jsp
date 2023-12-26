<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
 <h1> 登入失敗囉囉囉</h1>
 <p> <%=request.getServletContext().getInitParameter("ERROR") %>. </p>
<!--  <form action="home">
	<input name="button" type="submit" id="button" value="Home">
 </form> -->
</body>
</html>