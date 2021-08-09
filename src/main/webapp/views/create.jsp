<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 8/9/2021
  Time: 4:00 PM
  To change this template use File | Settings | File Templates.
--%>
<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 8/9/2021
  Time: 3:27 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
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
  <h2>Create New Product</h2>
  <p></p>
  <table class="table">
    <thead>
    <tr>
      <th>Name Product</th>
      <th>Price</th>
      <th>Quantity</th>
      <th>Color</th>
      <th>About</th>
      <th>Category</th>
    </tr>
    </thead>
    <tbody>
    <form action="/?action=create" method="post">
      <tr>
        <td><input type="text" name="name"></td>
        <td><input type="text" name="price"></td>
        <td><input type="text" name="soluong"></td>
        <td><input type="text" name="color"></td>
        <td><input type="text" name="about"></td>
        <td><input type="text" name="category"></td>
        <input type="submit" value="submit">
      </tr>
    </form>
    </tbody>
  </table>
</div>

</body>
</html>
