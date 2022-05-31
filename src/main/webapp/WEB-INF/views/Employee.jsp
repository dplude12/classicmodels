<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
   "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
 
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Employee Manager Home</title>
    </head>
    <body>
        <div align="center">
            <h1>Employee List</h1>
            <h3><a href="newEmployee">New Employee</a></h3>
            <table border="1">
            	<tr>
                <th>No</th>
                <th>EmpNo</th>
                <th>Job Title</th>
                <th>LastName</th>
                <th>FirstName</th>
                <th>Email</th>
                <th>Extension</th>
                <th>OfficeCode</th>
                <th>ReportsTo</th>
                </tr>
                 
                <c:forEach var="emp" items="${listEmployee}" varStatus="status">
                <tr>
                    <td>${status.index + 1}</td>
                    <td>${emp.employeeNumber}</td>
                    <td>${emp.jobTitle}</td>
                    <td>${emp.lastName}</td>
                    <td>${emp.firstName}</td>
                    <td>${emp.email}</td>
                    <td>${emp.extension}</td>
                    <td>${emp.officeCode}</td>
                    <td>${emp.reportsTo}</td>
                    <td>
                        <a href="editEmployee?id=${emp.employeeId}">Edit</a>
                        &nbsp;&nbsp;&nbsp;&nbsp;
                        <a href="deleteEmployee?id=${emp.employeeId}">Delete</a>
                    </td>
                             
                </tr>
                </c:forEach>             
            </table>
        </div>
    </body>
</html>
