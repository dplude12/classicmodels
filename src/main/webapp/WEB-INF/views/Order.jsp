<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
   "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
 
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="${pageContext.request.contextPath}/resources/style.css" rel="stylesheet">
        <title>Order Manager Home</title>
    </head>
    <body>
        <div align="center">
        	<h1>Classic Models</h1>        
            <h2>Orders</h2>
            <h3><a href="newOrder">New Order</a></h3>
            <h3><a href="homePage">Home</a></h3>
            <table id="customers">
            	<tr>
            	<th>Order Number</th>
            	<th>Order Date</th>
            	<th>Required Date</th>
            	<th>Shipped Date</th>
            	<th>Status</th>
            	<th>Comments</th>
            	<th>Customer Number</th>
				<th>Update</th>
                </tr>
                 
                <c:forEach var="rec" items="${listOrders}" varStatus="status">
                <tr>
					<td>${rec.orderNumber}</td>
					<td>${rec.orderDate}</td>
					<td>${rec.requiredDate}</td>
					<td>${rec.shippedDate}</td>
					<td>${rec.status}</td>
					<td>${rec.comments}</td>
					<td>${rec.customerNumber}</td>
                    <td>
                        <a href="orderDetailListByOrder?orderNumber=${rec.orderNumber}">Order Details</a>
                        &nbsp;&nbsp;&nbsp;&nbsp;
                    
                    </td>
                </tr>
                </c:forEach>             
            </table>
        </div>
    </body>
</html>
