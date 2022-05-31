<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
    "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link href="${pageContext.request.contextPath}/resources/style.css" rel="stylesheet">
<title>New/Edit Offices</title>
</head>
<body>
    <div align="center">
        <h1>Classic Models</h1>
        <h2>New/Edit Office</h2>
        <form:form action="saveOffice" method="post" modelAttribute="office">
        <table>
            <tr>
                <td>Office ID:</td>
                <td><form:input path="officeID" /></td>
            </tr>
            <tr>
                <td>Office Code:</td>
                <td><form:input path="officeCode" /></td>
            </tr>
            <tr>
                <td>City:</td>
                <td><form:input path="city" /></td>
            </tr>
            <tr>
                <td>Phone:</td>
                <td><form:input path="phone" /></td>
            </tr>
            <tr>
                <td>Address Line 1:</td>
                <td><form:input path="addressLine1" /></td>
            </tr>
            <tr>
                <td>Address Line 2:</td>
                <td><form:input path="addressLine2" /></td>
            </tr>
            <tr>
                <td>State:</td>
                <td><form:input path="state" /></td>
            </tr>
            <tr>
                <td>Postal Code:</td>
                <td><form:input path="postalCode" /></td>
            </tr>
            <tr>
                <td>Country:</td>
                <td><form:input path="country" /></td>
            </tr>
            <tr>
                <td>Territory:</td>
                <td><form:input path="territory" /></td>
            </tr>
            <tr>
                <td colspan="2" align="center"><input type="submit" value="Save"></td>
            </tr>
        </table>
        </form:form>
    </div>
</body>
</html>