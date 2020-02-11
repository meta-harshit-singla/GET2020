<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Vehicle Registration Form</title>
<link rel="stylesheet" type="text/css" href="Assignment.css">
</head>
<body>
	<div>
		<form action="vehicledetail" method="post" id='vehicleDetails'>
			<fieldset>
				<legend>Vehicle Details</legend>
				<label>Vehicle Name<input type="text" id="vehicalName"
					name="vehiclename" placeholder="Vehicle Name Eg - Baleno" required><br /></label>
				<label>Type <label><select id="typeSelect"
						name="vehicletype">
							<option value="" style="color: rgb(134, 134, 134);" selected
								disabled>Type</option>
							<option value="cycle">Cycle</option>
							<option value="motorCycle">Motor Cycle</option>
							<option value="fourWheelers">Four Wheeler</option>
					</select><br /> <label>Vehicle Number<input type="text"
							name="vehicleno" id="vehicleNumber" placeholder="RJ14-SA-1234"
							required></label><br /> <label>Employee Email<input
							type="text" name="email"
							value="<%=session.getAttribute("email") %>" id="email"
							placeholder="RJ14-SA-1234" required></label><br /> <label>Identification</label><br>
					<textarea rows="4" name="vehicleidentification" cols="50"
							placeholder="Enter the Description of vehicle">
                </textarea><br>
					<br> <input type="submit"
						style="border: none; margin: 0; outline: 0; padding: 0; color: orange; background-color: #000; text-align: center; cursor: pointer; width: 8rem; height: 40px; font-size: 14px; border-radius: 2rem;"
						value="Go">
			</fieldset>
		</form>
	</div>
</body>
</html>