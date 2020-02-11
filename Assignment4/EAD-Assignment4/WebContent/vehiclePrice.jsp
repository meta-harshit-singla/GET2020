<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" type="text/css" href="Assignment.css">
<title>Vehicle price</title>
<script>
	var priceYearly, priceMonthly, priceDaily, res;
<%int priceyearly = (int) session.getAttribute("priceYearly");
			int pricemonthly = (int) session.getAttribute("priceMonthly");
			int pricedaily = (int) session.getAttribute("priceDaily");
			String vehicle = (String) session.getAttribute("vehicle");%>
	priceYearly =
<%=priceyearly%>
	priceMonthly =
<%=pricemonthly%>
	priceDaily =
<%=pricedaily%>
	function converter() {
		res = document.getElementById("selectConverter").value;
		if (res == "usd0") {
			passDaily = (priceDaily * 0.014).toFixed(2);
			document.getElementById("daypricecycle").innerHTML = "$"
					+ (priceDaily * 0.014).toFixed(2);
			passMonthly = (priceMonthly * 0.014).toFixed(2);
			document.getElementById("monthpricecycle").innerHTML = "$"
					+ (priceMonthly * 0.014).toFixed(2);
			passYearly = (priceYearly * 0.014).toFixed(2);
			document.getElementById("yearpricecycle").innerHTML = "$"
					+ (priceYearly * 0.014).toFixed(2);
		} else if (res == "yen0") {
			passDaily = (priceDaily * 1.52).toFixed(2);
			document.getElementById("daypricecycle").innerHTML = "YEN "
					+ (priceDaily * 1.52).toFixed(2);
			passMonthly = (priceMonthly * 1.52).toFixed(2);
			document.getElementById("monthpricecycle").innerHTML = "YEN "
					+ (priceMonthly * 1.52).toFixed(2);
			passYearly = (priceYearly * 1.52).toFixed(2);
			document.getElementById("yearpricecycle").innerHTML = "YEN "
					+ (priceYearly * 1.52).toFixed(2);
		} else if (res == "inr0") {
			passDaily = (priceDaily).toFixed(2);
			document.getElementById("daypricecycle").innerHTML = "INR "
					+ (priceDaily).toFixed(2);
			passMonthly = (priceMonthly).toFixed(2);
			document.getElementById("monthpricecycle").innerHTML = "INR "
					+ (priceMonthly).toFixed(2);
			passYearly = (priceYearly).toFixed(2);
			document.getElementById("yearpricecycle").innerHTML = "INR "
					+ (priceYearly).toFixed(2);
		}
	}
	function cyclePassDay() {
		document.getElementById("reciept").innerHTML = "You have charged- "
				+ res.slice(0, -1).toUpperCase() + passDaily;
		document.getElementById("btn").style.display = "block";
		document.getElementById("passform").style.display = "none";

	}
	function cyclePassMonth() {
		//res = res.substring(0,str.length-1);
		document.getElementById("reciept").innerHTML = "You have charged -"
				+ res.slice(0, -1).toUpperCase() + passMonthly;
		document.getElementById("btn").style.display = "block";

		document.getElementById("passform").style.display = "none";

	}
	function cyclePassYear() {
		//res = res.substring(0,str.length-1);
		document.getElementById("reciept").innerHTML = "You have charged- "
				+ res.slice(0, -1).toUpperCase() + passYearly;
		document.getElementById("btn").style.display = "block";
		document.getElementById("passform").style.display = "none";

	}
</script>
</head>
<body>
	<div>
		<form id="passform">
			<div id="passCycle">
				<fieldset>
					<legend>Select Pass Price</legend>
					<h1>
						<%
						    out.println(vehicle);
						%>
					</h1>
					<select id="selectConverter" onchange="converter()">
						<option value="type" style="color: rgb(134, 134, 134);" selected
							disabled>Currency</option>
						<option value="usd0">USD</option>
						<option value="yen0">YEN</option>
						<option value="inr0">INR</option>
					</select>
					<div class="flex-container">

						<div class="card">

							<h2 class="passhead">1 Day</h2>
							<p id="daypricecycle">
								<%
								    out.println("INR " + pricedaily);
								%>
							</p>

							<p>
								<input type="button" class="cardButton" value="Make Pass"
									onClick="cyclePassDay()">
							</p>
						</div>
						<div class="card">

							<h2 class="passhead">1 Month</h2>
							<p id="monthpricecycle">
								<%
								    out.println("INR " + pricemonthly);
								%>
							</p>

							<p>
								<input type="button" class="cardButton" value="Make Pass"
									onClick="cyclePassMonth()">
							</p>
						</div>
						<div class="card">

							<h2 class="passhead">1 Year</h2>
							<p id="yearpricecycle">
								<%
								    out.println("INR " + priceyearly);
								%>
							</p>

							<p>
								<input type="button" class="cardButton" value="Make Pass"
									onClick="cyclePassYear()">
							</p>
						</div>
					</div>
				</fieldset>
			</div>
		</form>
	</div>
	<div>
	<form  action="login.html" method="post">
		 <h1 id="reciept"></h1>
		<a id="btn"  method="post" style="display:none"><input type="submit"></button></a>
	</form>
	</div>
</body>

</html>