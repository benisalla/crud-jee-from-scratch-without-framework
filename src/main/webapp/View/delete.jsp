<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="ISO-8859-1">
	<title>delete user</title>
	<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.0.0/dist/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
</head>
<body>
	<div class="container">
		<div class="card" style="width: 30rem; margin:3rem auto;">
		  <div class="card-body">
		    <h5 class="card-title text-danger">Delete User</h5>
		    <h6 class="card-subtitle mb-2">ID : ${user.getId() }</h6>
		    <h6 class="card-subtitle mb-2">Name : ${user.getName() }</h6>
		    <h6 class="card-subtitle mb-2">Gender : ${user.getGender() }</h6>
		    <h6 class="card-subtitle mb-2">Email : ${user.getEmail() }</h6>
		    <h6 class="card-subtitle mb-2">Profession : ${user.getProfession() }</h6>
		    <div style="display: flex;justify-content: space-between;width:100%;">
			    <form action="delete" method="post">
			    	<button type="submit" class="btn btn-outline btn-danger" name="user_id" value="${user.getId() }">Delete</button>
			    </form>
			    <form action="index" method="get">
			    	 <button type="submit" class="btn btn-outline btn-success">Back</button>
			    </form>
			   
		    </div>
		  </div>
		</div>
	</div>
</body>
</html>