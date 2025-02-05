<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>로그인</title>
</head>
<body>
    <h2>로그인</h2>
    <form action="/login" method="post">
        <label for="username">아이디:</label>
        <input type="text" id="username" name="username" required>
        <br>
        <label for="password">비밀번호:</label>
        <input type="password" id="password" name="password" required>
        <br>
        <button type="submit">로그인</button>
    </form>

    <% if (request.getParameter("error") != null) { %>
        <p style="color:red;">로그인 실패: 아이디 또는 비밀번호가 틀렸습니다.</p>
    <% } %>

    <% if (request.getParameter("logout") != null) { %>
        <p style="color:green;">로그아웃 되었습니다.</p>
    <% } %>
</body>
</html>
