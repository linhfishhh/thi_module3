<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 8/9/2021
  Time: 2:42 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
<head>
  <title>Bootstrap Example</title>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
</head>
<body>

<div class="container">
  <h2>Basic Table</h2>
  <table>
    <th><a href="/views/create.jsp" type="button" class="btn btn-outline-primary">Create</a></th>
    <th></th>
  <th><form class="search-form" action="/?action=find" method="post"> <input class="form-control" placeholder="Tìm Kiếm" name="find" type="text">
    <button class="btn btn-link search-btn"> <i class="glyphicon glyphicon-search"></i>
    </button>
  </form></th>
  </table>
  <table class="table">
    <thead>
    <tr>
      <th>ID</th>
      <th>Name Product</th>
      <th>Price</th>
      <th>Quantity</th>
      <th>Color</th>
      <th>About</th>
      <th>Category</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach items="${requestScope.List}" var="Product">
    <tr>
      <td>${Product.id}</td>
      <td>${Product.name}</td>
      <td>${Product.price}</td>
      <td>${Product.quantity}</td>
      <td>${Product.color}</td>
      <td>${Product.about}</td>
      <td>${Product.category}</td>
      <td><a href="/?action=edit&productId=${Product.id}" type="button" class="btn btn-outline-primary">Edit</a></td>
      <td><a href="/?action=remove&productId=${Product.id}" type="button" class="btn btn-outline-primary">Remove</a></td>
    </tr>
    </c:forEach>
    </tbody>
  </table>
</div>

</body>
</html>

