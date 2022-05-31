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
        <h2>New/Edit Product Lines</h2>
        <form:form action="saveProductLines" method="post" modelAttribute="productLines">
        <table>
            <form:hidden path="productLineId"/>
            <tr>
                <td>Product Line:</td>
                <td><form:input path="productLine" /></td>
            </tr>
            <tr>
                <td>Description:</td>
                <td><form:input path="textDescription" /></td>
            </tr>
            <tr>
                <td>HTML Description:</td>
                <td><form:input path="htmlDescription" /></td>
            </tr>
            <tr>
                <td colspan="2" align="center"><input type="submit" value="Save"></td>
            </tr>
        </table>
        </form:form>
    </div>
</body>
</html>