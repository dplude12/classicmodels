<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
   "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
 
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="${pageContext.request.contextPath}/resources/style.css" rel="stylesheet">
        <title>Order Detail Manager Home</title>
    </head>
    <body>
        <div align="center">
        	<h1>Classic Models</h1>        
            <h2>Order Detail</h2>
            <h3><a href="newOrderDetail">New Order Detail</a></h3>
            <h3><a href="homePage">Home</a></h3>
            <table id="customers">
            	<tr>
            	<th>Order Number</th>
            	<th>Product Code</th>
            	<th>Quantity Ordered</th>
            	<th>Price Each</th>
            	<th>Order Line Number</th>
            	<th>Update</th>
                </tr>
                 
                <c:forEach var="rec" items="${listOrderDetail}" varStatus="status">
                <tr>
					<td>${rec.orderNumber}</td>
					<td>${rec.productCode}</td>
					<td>${rec.quantityOrdered}</td>
					<td>${rec.priceEach}</td>
					<td>${rec.orderLineNumber}</td>
                    <td>
                    </td>
                             
                </tr>
                </c:forEach>             
            </table>
        </div>
    </body>
</html>
