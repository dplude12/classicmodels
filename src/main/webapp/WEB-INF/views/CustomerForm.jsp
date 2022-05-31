<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
    "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link href="${pageContext.request.contextPath}/resources/style.css" rel="stylesheet">
<title>New/Edit Customer</title>
</head>
<body>
    <div align="center">
        <h1>Classic Models</h1>
        <h2>New/Edit Customer</h2>
        <form:form action="saveCustomer" method="post" modelAttribute="customer">
        <table>
            <form:hidden path="customerID"/>
            <tr>
                <td>Customer Number:</td>
                <td><form:input path="customerNumber" /></td>
            </tr>
            <tr>
                <td>Customer Name:</td>
                <td><form:input path="customerName" /></td>
            </tr>
            <tr>
                <td>Contact Last Name:</td>
                <td><form:input path="contactLastName" /></td>
            </tr>
            <tr>
                <td>Contact First Name:</td>
                <td><form:input path="contactFirstName" /></td>
            </tr>
            <tr>
                <td>Phone:</td>
                <td><form:input path="phone" /></td>
            </tr>
            <tr>
                <td>Address Line1:</td>
                <td><form:input path="addressLine1" /></td>
            </tr>
            <tr>
                <td>Address Line2:</td>
                <td><form:input path="addressLine2" /></td>
            </tr>
            <tr>
                <td>City:</td>
                <td><form:input path="city" /></td>
            </tr>
            <tr>
                <td>State:</td>
                <td><form:input path="state" /></td>
            </tr>
            <tr>
                <td>Postal Code</td>
                <td><form:input path="postalCode" /></td>
            </tr>
            <tr>
                <td>Country:</td>
                <td><form:input path="country" /></td>
            </tr>
            <tr>
                <td>Sales Rep Employee Number:</td>
                <td><form:input path="salesRepEmployeeNumber" /></td>
            </tr>
            <tr>
                <td>Credit Limit:</td>
                <td><form:input path="creditLimit" /></td>
            </tr>
            <tr>
                <td colspan="2" align="center"><input type="submit" value="Save"></td>
            </tr>
        </table>
        </form:form>
    </div>
</body>
</html>