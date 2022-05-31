<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
   "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
 
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="${pageContext.request.contextPath}/resources/style.css" rel="stylesheet">
        <title>Customer Manager Home</title>
    </head>
    <body>
        <div align="center">
        	<h1>Classic Models</h1>        
            <h2>Customer List</h2>
            <h3><a href="newCustomer">New Customer</a></h3>
            <h3><a href="homePage">Home</a></h3>
            <table id="customers">
            	<tr>
            	<th>dbID</th>
            	<th>customerID</th>
				<th>customerNumber</th>
				<th>customerName</th>
				<th>contactLastName</th>
				<th>contactFirstName</th>
				<th>phone</th>
				<th>addressLine1</th>
				<th>addressLine2</th>
				<th>city</th>
				<th>state</th>
				<th>postalCode</th>
				<th>country</th>
				<th>salesRepEmployeeNumber</th>
				<th>creditLimit</th>
				<th>Update</th>
                </tr>
                 
                <c:forEach var="cust" items="${listCustomer}" varStatus="status">
                <tr>
                    <td>${status.index + 1}</td>
					<td>${cust.customerID}</td>
					<td>${cust.customerNumber}</td>
					<td>${cust.customerName}</td>
					<td>${cust.contactLastName}</td>
					<td>${cust.contactFirstName}</td>
					<td>${cust.phone}</td>
					<td>${cust.addressLine1}</td>
					<td>${cust.addressLine2}</td>
					<td>${cust.city}</td>
					<td>${cust.state}</td>
					<td>${cust.postalCode}</td>
					<td>${cust.country}</td>
					<td>${cust.salesRepEmployeeNumber}</td>
					<td>${cust.creditLimit}</td>
                    <td>
                        <a href="editCustomer?id=${cust.customerID}">Edit</a>
                        &nbsp;&nbsp;&nbsp;&nbsp;
                        <a href="deleteCustomer?id=${cust.customerID}">Delete</a>
                    </td>
                             
                </tr>
                </c:forEach>             
            </table>
        </div>
    </body>
</html>
