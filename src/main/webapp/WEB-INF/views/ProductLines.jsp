<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
   "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
 
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="${pageContext.request.contextPath}/resources/style.css" rel="stylesheet">
        <title>Product Lines Manager Home</title>
    </head>
    <body>
        <div align="center">
        	<h1>Classic Models</h1>        
            <h2>Product Lines</h2>
            <h3><a href="newProductLines">New Product Line</a></h3>
            <h3><a href="homePage">Home</a></h3>
            <table id="customers">
            	<tr>
            	<th>ProductLineId</th>
            	<th>productLine</th>
            	<th>textDescription</th>
            	<th>htmlDescription</th>
				<th>Update</th>
                </tr>
                 
                <c:forEach var="rec" items="${listProductLines}" varStatus="status">
                <tr>
                    <td>${status.index + 1}</td>
					<td>${rec.productLine}</td>
					<td>${rec.textDescription}</td>
					<td>${rec.htmlDescription}</td>
                    <td>                    
                        <a href="productListByProductLine?productLine=${rec.productLine}">ProductList</a>
                        &nbsp;&nbsp;&nbsp;&nbsp;
                        <a href="editProductLines?id=${rec.productLineId}">Edit</a>
                        &nbsp;&nbsp;&nbsp;&nbsp;
                        <a href="deleteProductLines?id=${rec.productLineId}">Delete</a>
                    </td>
                             
                </tr>
                </c:forEach>             
            </table>
        </div>
    </body>
</html>
