<%--
  Created by IntelliJ IDEA.
  User: hainv
  Date: 11/7/2023
  Time: 9:41 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!doctype html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>Document</title>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/css/bootstrap.min.css"
          integrity="sha384-xOolHFLEh07PJGoPkLv1IbcEPTNtaed2xpHsD9ESMhqIYd0nLMwNLD69Npy4HI+N" crossorigin="anonymous">
    <script src="https://cdn.jsdelivr.net/npm/jquery@3.5.1/dist/jquery.slim.min.js"
            integrity="sha384-DfXdz2htPH0lsSSs5nCTpuj/zy4C+OGpamoFVy38MVBnE+IbbVYUew+OrCXaRkfj"
            crossorigin="anonymous"></script>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/js/bootstrap.bundle.min.js"
            integrity="sha384-Fy6S3B9q64WdZWQUiU+q4/2Lc9npb8tCaSX9FK7E8HnRr0Jz8D6OP9dO5Vg3Q9ct"
            crossorigin="anonymous"></script>
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.4.2/css/all.min.css"
          integrity="sha512-z3gLpd7yknf1YoNbCzqRKc4qyor8gaKU1qmn+CShxbuBusANI9QpRohGBreCFkKxLhei6S9CQXFEbbKuqLg0DA=="
          crossorigin="anonymous" referrerpolicy="no-referrer"/>
    <style>
        th {
            text-align: center;
            background: lightblue;
        }
        td {
            text-align: center;
        }
        .container {
            margin-left: 190px;
        }
    </style>
</head>
<body>
<div class="container">
    <h2> List Student</h2>
    <div class="d-flex">
        <a  class="float-left" href="http://localhost:8080/students?action=create"><button class="btn btn-info">Add</button></a></th>
        <form class="form-inline float-right" action="http://localhost:8080/students?action=search" method="post">
            <input hidden="hidden" name="action" value="search">
            <div class="form-group mb-2">
                <label for="staticEmail2" class="sr-only">Search</label>
                <input type="text" class="form-control-plaintext" id="staticEmail2" name="search" placeholder="Search">
            </div>
            <button type="submit" class="btn btn-primary mb-2">Search</button>
        </form>
        <a  style="margin-left: 10px" class="float-left" href="http://localhost:8080/students?action=home"><button class="btn btn-info">Show All Students</button></a></th>
    </div>
    <table border>
        <thead>
        <tr>
            <th>STT</th>
            <th>Name</th>
            <th>DateOfBirth</th>
            <th>Email</th>
            <th>Address</th>
            <th>Phone</th>
            <th>ClassroomId</th>
            <th>Action</th>
        </tr>
        </thead>
        <tbody>
<c:forEach var="item" items="${studentList}">
    <tr>
        <td>${item.getId()}</td>
        <td>${item.getName()}</td>
        <td>${item.getDateOfBirth()}</td>
        <td>${item.getEmail()}</td>
        <td>${item.getAddress()}</td>
        <td>${item.getPhone()}</td>
        <td>${item.getClassRoomId()}</td>
        <td>
            <button><a href="http://localhost:8080/students?action=update&id=${item.id}">Edit</a></button>
            <button><a href="http://localhost:8080/students?action=delete&id=${item.id}">Delete</a></button>
        </td>
    </tr>
</c:forEach>
        </tbody>
    </table>
</div>
</body>
</html>
