<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
    "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link href="${pageContext.request.contextPath}/resources/style.css" rel="stylesheet">
<title>New/Edit Order</title>
</head>
<body>
    <div align="center">
        <h1>Classic Models</h1>
        <h2>New/Edit Order</h2>
        <form:form action="savePayment" method="post" modelAttribute="order">
        <table>
            <tr>
                <td>Order Number:</td>
                <td><form:input path="orderNumber" /></td>
            </tr>
            <tr>
                <td>Order Date:</td>
                <td><form:input path="orderDate" /></td>
            </tr>
            <tr>
                <td>required Date:</td>
                <td><form:input path="requiredDate" /></td>
            </tr>
            <tr>
                <td>Shipped Date:</td>
                <td><form:input path="shippedDate" /></td>
            </tr>
            <tr>
                <td>Status:</td>
                <td><form:input path="status" /></td>
            </tr>
            <tr>
                <td>Comments:</td>
                <td><form:input path="comments" /></td>
            </tr>
            <tr>
                <td>Customer Number:</td>
                <td><form:input path="customerNumber" /></td>
            </tr>
            <tr>
                <td colspan="2" align="center"><input type="submit" value="Save"></td>
            </tr>
        </table>
        </form:form>
    </div>
</body>
</html>