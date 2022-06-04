<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

<form action="editOfficeByCountry?id=id">
  <label for="id">Country:</label><br>
  <input type="text" id="id" name="id" value="USA"><br>
  <input type="submit" value="Submit">
</form> 

<p>If you click the "Submit" button, the will call editOfficeByCountry which opens form with just one record.</p>

 

<form action="officeListByCountry?id=id">
  <label for="id">Country:</label><br>
  <input type="text" id="id" name="id" value="USA"><br>
  <input type="submit" value="Submit">
</form> 

<p>If you click the "Submit" button, the will call officeListByCountry which shows all records matching search value.</p>


</body>
</html>