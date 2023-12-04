<%@ page language="java" contentType="text/html; charset=EUC-KR" pageEncoding="EUC-KR"%>
<%@ page import="com.kh.model.vo.DTO" %>
<%@ page import="java.util.List" %>
<%
    List<DTO> userList = (List<DTO>) request.getAttribute("userList");
    String userId = request.getParameter("userId").toLowerCase(); // 입력된 아이디를 소문자로 변환
%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="EUC-KR">
    <title>검색결과</title>
</head>
<body>
    <h1>검색결과</h1>
    <table border="1">
        <thead>
            <tr>
                <th>사용자 번호</th>
                <th>사용자 ID</th>
                <th>사용자 이름</th>
                <th>사용자 나이</th>
            </tr>
        </thead>
        <tbody>
            <% for (DTO user : userList) { %>
                <% if (user.hasUserId(userId)) { %> <!-- 입력된 아이디와 일치하는 경우만 출력 -->
                    <tr>
                        <td><%= user.getUser_number() %></td>
                        <td><%= user.getUser_id() %></td>
                        <td><%= user.getUser_name() %></td>
                        <td><%= user.getUser_age() %></td>
                    </tr>
                <% } %>
            <% } %>
        </tbody>
    </table>
</body>
</html>
