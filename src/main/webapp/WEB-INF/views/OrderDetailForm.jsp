<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
    "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link href="${pageContext.request.contextPath}/resources/style.css" rel="stylesheet">
<title>New/Edit Order Detail</title>
</head>
<body>
    <div align="center">
        <h1>Classic Models</h1>
        <h2>New/Edit Order Detail</h2>
        <form:form action="saveOrderDetail" method="post" modelAttribute="orderDetail">
        <table>
            <tr>
                <td>Order Number:</td>
                <td><form:input path="orderNumber" /></td>
            </tr>
            <tr>
                <td>Product Code:</td>
                <td><form:input path="productCode" /></td>
            </tr>
            <tr>
                <td>Quantity Ordered:</td>
                <td><form:input path="quantityOrdered" /></td>
            </tr>
            <tr>
                <td>Price Each:</td>
                <td><form:input path="priceEach" /></td>
            </tr>
            <tr>
                <td>Order Line Number:</td>
                <td><form:input path="orderLineNumber" /></td>
            </tr>
            <tr>
                <td colspan="2" align="center"><input type="submit" value="Save"></td>
            </tr>
        </table>
        </form:form>
    </div>
</body>
</html>