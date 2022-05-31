<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
   "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
 
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="${pageContext.request.contextPath}/resources/style.css" rel="stylesheet">
        <title>Payments Manager Home</title>
    </head>
    <body>
        <div align="center">
        	<h1>Classic Models</h1>        
            <h2>Offices</h2>
            <h3><a href="newOffice">New Office</a></h3>
            <h3><a href="homePage">Home</a></h3>
            <table id="customers">
            	<tr>
            	<th>officeID</th>
            	<th>officeCode</th>
            	<th>city</th>
            	<th>phone</th>
            	<th>addressLine1</th>
            	<th>addressLine2</th>
            	<th>state</th>
            	<th>postalCode</th>
            	<th>country</th>
            	<th>territory</th>
				<th>Update</th>
				</tr>
                 
                <c:forEach var="rec" items="${listOffices}" varStatus="status">
                <tr>
					<td>${rec.officeID}</td>
					<td>${rec.officeCode}</td>
					<td>${rec.city}</td>
					<td>${rec.phone}</td>
					<td>${rec.addressLine1}</td>
					<td>${rec.addressLine2}</td>
					<td>${rec.state}</td>
					<td>${rec.postalCode}</td>
					<td>${rec.country}</td>
					<td>${rec.territory}</td>
                    <td>
                        <a href="empListByOffice?officeCode=${rec.officeCode}">List Employees</a>
                        &nbsp;&nbsp;&nbsp;&nbsp;
                        <a href="editOffice?id=${rec.officeID}">Edit</a>
                        &nbsp;&nbsp;&nbsp;&nbsp;
                        <a href="deleteOffice?id=${rec.officeID}">Delete</a>
                    </td>
                             
                </tr>
                </c:forEach>             
            </table>
        </div>
    </body>
</html>
