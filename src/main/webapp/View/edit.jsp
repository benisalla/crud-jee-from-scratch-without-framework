<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="ISO-8859-1">
		<title>Insert title here</title>
		<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.0.0/dist/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
	</head>
	<body>
		<div class="container">
			<div class="card container" style="width: 44rem; margin:3rem auto;">
			
				<h1>Edit User with ID:${ user.getId() }</h1>
				
			
					<div style="display: flex;justify-content: flex-end;width:100%; margin: 1rem 0;">
					  <form action="index" method="get">
					   	<button type="submit" class="btn btn-outline btn-success">Back</button>   
					  </form>
			        </div>
			
				<form action="edit" method="post">
				  <input type="hidden" name="id" value="${user.getId()}"/>
				  <div class="form-group row">
				    <label for="name" class="col-sm-2 col-form-label">Name</label>
				    <div class="col-sm-10">
				      <input value="${ user.getName() }" type="text" name="name" class="form-control" id="name" placeholder="your name">
				    </div>
				  </div>
				  
				  <div class="form-group row">
				    <label for="email" class="col-sm-2 col-form-label">Email</label>
				    <div class="col-sm-10">
				      <input value="${ user.getEmail() }" type="email" name="email" class="form-control" id="email" placeholder="your email">
				    </div>
				  </div>
				  
				  <div class="form-group row">
				    <label for="profession" class="col-sm-2 col-form-label">Profession</label>
				    <div class="col-sm-10">
				      <input value="${ user.getProfession() }" name="profession" type="text" class="form-control" id="profession" placeholder="your profession">
				    </div>
				  </div>
				  
				  <div class="form-check">
					  <input class="form-check-input" type="radio" name="gender" id="Radios1" value="male" ${ user.getGender() == "male" ? "checked" : "" }>
					  <label class="form-check-label" for="Radios1">
					    Male
					  </label>
				  </div>
					  <div class="form-check">
					    <input class="form-check-input" type="radio" name="gender" id="Radios2" value="female" ${ user.getGender() == "female" ? "checked" : "" }>
					    <label class="form-check-label" for="Radios2">
					   		Female
					    </label>
				  </div>
				  
				  <div style="display: flex;justify-content: center;width:100%; margin: 1rem">
				   	<button type="submit" style="width: 100px;" class="btn btn-outline btn-danger" name="user_id" value="${user.getId() }">save</button>   
			      </div>
				  
				</form>
			
			</div>
				
		</div>
	</body>
</html>