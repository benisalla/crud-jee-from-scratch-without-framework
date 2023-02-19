<%@page import="Models.UserModel"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="TAG" %>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.0.0/dist/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">

</head>

<body>
	<div class="container">
	
		<h1 class="text-center">Crud App With jee</h1>
		
		<div style="display: flex;justify-content: space-between;width:100%; margin: 1rem 0;">
		
		<form class="row g-3" action="search" method="post">
		  <div class="col-auto">
		    <input type="text" class="form-control" name="hint" id="text" placeholder="Search ...">
		  </div>
		  <div class="col-auto">
		    <button type="submit" class="btn btn-primary mb-3">Search</button>
		  </div>
		</form>
		
		  <form action="add" method="get">
		   	<button type="submit" class="btn btn-outline btn-success">New User</button>   
		  </form>
        </div>
		
		
		<table class="table table-dark">
		  <thead>
		    <tr>
		      <th scope="col">ID</th>
		      <th scope="col">name</th>
		      <th scope="col">gender</th>
		      <th scope="col">email</th>
		      <th scope="col">profession</th>
		      <th scope="col">Edit</th>
		    </tr>
		  </thead>
		  <tbody>
		  <TAG:forEach items="${ userModel.users }" var="user">
			 	<tr>
			      <th scope="row">${ user.getId() }</th>
			      <td>${ user.getName() }</td>
			      <td>${ user.getGender() }</td>
			      <td>${ user.getEmail() }</td>
			      <td>${ user.getProfession() }</td>
			      <td>
			      	<a href="./delete?id=${user.getId()}">
			      		<button class="btn btn-ouline btn-danger">D</button>
			      	</a>
			      	<a href="./edit?id=${user.getId()}">
			      		<button class="btn btn-ouline btn-warning">E</button>
			      	</a>
			      </td>
			    </tr>
		  </TAG:forEach>
		  </tbody>
		</table>
	
	</div>
</body>
</html>