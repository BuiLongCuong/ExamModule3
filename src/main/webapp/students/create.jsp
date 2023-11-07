<%--
  Created by IntelliJ IDEA.
  User: hainv
  Date: 11/7/2023
  Time: 10:14 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!doctype html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>Document</title>
</head>
<body>

<form action="http://localhost:8080/students?action=create" method="post">
    <input type="text" name="name" placeholder="name">
    <input type="text" name="dateOfBirth" placeholder="dateOfBirth">
    <input type="text" name="address" placeholder="address">
    <input type="text" name="phone" placeholder="phone">
    <input type="text" name="email" placeholder="email">
    <input type="text" name="classRoomId" placeholder="classroomId">
    <button type="submit">Submit</button>
</form>

</body>
</html>
