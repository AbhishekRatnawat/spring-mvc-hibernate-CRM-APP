<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<html>
<head>
	<title> Save Customer </title>
	
	<link type="text/css"
		  rel="styleSheet"
		   href="${pageContext.request.contextPath}/resources/css/style.css"/>
		   
		   <link type="text/css"
		  rel="styleSheet"
		   href="${pageContext.request.contextPath}/resources/css/add-customer-style.css"/>
</head>

<body>
	<div id="wrapper">
	<div id="header">
		<h2> CRM Add customer</h2>
	
	</div>
	</div>

	
	<div id="container">
	
		<h3>Save Customer</h3>
		
		<form:form action="saveCustomer" modelAttribute="customer" method="POST">
		
		<!-- need to asso this data with customer id -->
		
		<form:hidden path="id" />
		
	<table>
		<tbody>
			<tr>
				<td><label>FirstName</label></td>
				<td><form:input path="firstName"></form:input></td>
			</tr>
			
			<tr>
				<td><label>LastName</label></td>
				<td><form:input path="lastName"></form:input></td>
			</tr>
			
			<tr>
				<td><label>email</label></td>
				<td><form:input path="email"></form:input></td>
			</tr>
			
			<tr>
				<td><label></label></td>
				<td><input type="submit" value="Save" class="save"></td>
			</tr>
			
		</tbody>
	</table>
</form:form>

<div style="clear; both;"></div>
<p>
<a href="${pageContext.request.contextPath}/customer/list"> Back to the list</a>
</p>

</div>
</body>


</html>