<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
    "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link href="${pageContext.request.contextPath}/resources/style.css" rel="stylesheet">
<title>New/Edit Employee</title>
</head>
<body>
    <div align="center">
    	<h1>Classic Models</h1>
        <h2>New/Edit Employee</h2>
        <form:form action="saveEmployee" method="post" modelAttribute="employee">
        <table>
            <form:hidden path="employeeId"/>
            <tr>
                <td>Employee Number:</td>
                <td><form:input path="employeeNumber" /></td>
            </tr>
            <tr>
                <td>First Name:</td>
                <td><form:input path="firstName" /></td>
            </tr>
            <tr>
                <td>Last Name:</td>
                <td><form:input path="lastName" /></td>
            </tr>
            <tr>
                <td>Email:</td>
                <td><form:input path="email" /></td>
            </tr>
            <tr>
                <td>extension:</td>
                <td><form:input path="extension" /></td>
            </tr>
            <tr>
                <td>jobTitle:</td>
                <td><form:input path="jobTitle" /></td>
            </tr>
            <tr>
                <td>reportsTo:</td>
                <td><form:input path="reportsTo" /></td>
            </tr>
            <tr>
                <td>officeCode:</td>
                <td><form:input path="officeCode" /></td>
            </tr>
            <tr>
                <td colspan="2" align="center"><input type="submit" value="Save"></td>
            </tr>
        </table>
        </form:form>
    </div>
</body>
</html>