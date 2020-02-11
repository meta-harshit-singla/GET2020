<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" type="text/css" href="Assignment.css">

<title>Insert title here</title>
<script>
	
<%int id = (int) session.getAttribute("idFriend");
			String name = (String) session.getAttribute("nameFriend");
			String gender = (String) session.getAttribute("genderFriend");
			String email = (String) session.getAttribute("emailFriend");
			String contactNo = (String) session.getAttribute("contactNoFriend");%>
	
</script>
</head>
<body>
	<form>
		<div>

			<form action="registration" method="post">
				<fieldset>
					<legend>Registration Form</legend>

					<span id="msg" style="color: red;"></span><br> <label>Full
						Name<input type="text" id="name" name="fullname" value="<%=name%>"
						readonly><br />
					</label> <label>Gender <label><input type="text"
							id="gender" value="<%=gender%>" name="gender" readonly></label><br />
						<label>E-Mail<input type="email" id="email" name="email"
							value="<%=email%>" readonly></label><br /> <label>Contact
							Number<input type="tel" id="mobNo" name="contactno"
							value="<%=contactNo%>" readonly>
					</label><br />
				</fieldset>
			</form>
		</div>
	</form>
</body>
</html>