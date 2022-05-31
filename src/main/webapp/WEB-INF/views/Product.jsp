<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
   "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
 
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="${pageContext.request.contextPath}/resources/style.css" rel="stylesheet">
        <title>Product Manager Home</title>
    </head>
    <body>
        <div align="center">
        	<h1>Classic Models</h1>        
            <h2>Products</h2>
            <h3><a href="newProduct">New Product</a></h3>
            <h3><a href="homePage">Home</a></h3>
            <table id="customers">
            	<tr>
            	<th>productCode</th>
            	<th>productName</th>
            	<th>productLine</th>
            	<th>productScale</th>
            	<th>productVendor</th>
            	<th>productDescription</th>
            	<th>quantityInStock</th>
            	<th>buyPrice decimal</th>
            	<th>MSRP</th>
				</tr>            	                 
                <c:forEach var="rec" items="${listProducts}" varStatus="status">
                <tr>
					<td>${rec.productCode}</td>
					<td>${rec.productName}</td>
					<td>${rec.productLine}</td>
					<td>${rec.productScale}</td>
					<td>${rec.productVendor}</td>
					<td>${rec.productDescription}</td>
					<td>${rec.quantityInStock}</td>
					<td>${rec.buyPrice}</td>
					<td>${rec.MSRP}</td>
                    <td>
                    </td>
                             
                </tr>
                </c:forEach>             
            </table>
        </div>
    </body>
</html>
