<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<h1>Customer Details</h1>
<link
	href="https://cdn.datatables.net/1.10.21/css/jquery.dataTables.min.css"
	rel="stylesheet" type="text/css">

<script src="https://code.jquery.com/jquery-3.5.1.js"></script>
<script
	src="https://cdn.datatables.net/1.10.21/js/jquery.dataTables.min.js"></script>
<script>
	$(document).ready(function() {
		$('#contactTbl').DataTable({
			"pagingType" : "full_numbers"
		});
	});
	
	function deleteConfirm(){
		return confirm("Are you sure, you want to delete?");
	}
</script>
</head>
<body>
	<a href="/PhoneBook/addcontact">+Add Contact</a>
	<table border="1" id="contactTbl">
		<thead>
			<tr>
				<th>S.No</th>
				<th>Name</th>
				<th>Email</th>
				<th>Phone Number</th>
				<th>Action</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach items="${contactList}" var="con" varStatus="index">
				<tr>
					<td>${index.count+1}</td>
					<td>${con.contactName}</td>
					<td>${con.contactEmail}</td>
					<td>${con.contactNumber}</td>
					<td><a href="/PhoneBook/editContact?cid=${con.contactId}">edit</a>
						| <a href="/PhoneBook/deleteContact?cid=${con.contactId}"
						onclick="return deleteConfirm()">Delete</a></td>
				</tr>
			</c:forEach>
		</tbody>

	</table>
</body>
</html>