<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
    "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link href="${pageContext.request.contextPath}/resources/style.css" rel="stylesheet">
<title>New/Edit Product</title>
</head>
<body>
    <div align="center">
        <h1>Classic Models</h1>
        <h2>New/Edit Product</h2>
        <form:form action="saveProduct" method="post" modelAttribute="product">
        <table>
            <tr>
                <td>Product Code:</td>
                <td><form:input path="productCode" /></td>
            </tr>
            <tr>
                <td>Product Name:</td>
                <td><form:input path="productName" /></td>
            </tr>
            <tr>
                <td>Product Line:</td>
                <td><form:input path="productLine" /></td>
            </tr>
            <tr>
                <td>Product Scale:</td>
                <td><form:input path="productScale" /></td>
            </tr>
            <tr>
                <td>Product Vendor:</td>
                <td><form:input path="productVendor" /></td>
            </tr>
            <tr>
                <td>Product Description:</td>
                <td><form:input path="productDescription" /></td>
            </tr>
            <tr>
                <td>Quantity In Stock:</td>
                <td><form:input path="quantityInStock" /></td>
            </tr>
            <tr>
                <td>Buy Price:</td>
                <td><form:input path="buyPrice" /></td>
            </tr>
            <tr>
                <td>MSRP:</td>
                <td><form:input path="MSRP" /></td>
            </tr>
            <tr>
                <td colspan="2" align="center"><input type="submit" value="Save"></td>
            </tr>
        </table>
        </form:form>
    </div>
</body>
</html>