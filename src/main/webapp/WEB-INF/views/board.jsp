<%@ page language="java" contentType="text/html; charset=UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>게시판</title>
    <link rel="stylesheet" type="text/css" href="/css/style.css">
</head>
<body>
    <h1>게시판</h1>
    <table>
        <tr><th>제목</th><th>작성자</th></tr>
        <c:forEach var="post" items="${posts}">
            <tr>
                <td>${post.title}</td>
                <td>${post.user.username}</td>
            </tr>
        </c:forEach>
    </table>
</body>
</html>
