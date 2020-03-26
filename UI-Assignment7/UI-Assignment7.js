function isNameValidate() {
    var flag = true;
    var eName = document.getElementById('name').value;
    var nameStart = /^\s/;
    var numeric = (/\d/);
    if (numeric.test(eName)) {
        alert('Name cannot contain numbers');
        flag = false;
    }
    else if (nameStart.test(eName)) {
        alert('Name cannot contain spaces at the starting');
        flag = false;
    }
    else if (eName.length < 2) {
        alert('Name length should be greater than 2');
        flag = false;
    }
    if (flag) {
        document.getElementById('FullName').innerHTML = "<h1>Hey " + eName + " ! Can i know your gender"
        document.getElementById('gender').style.display = "";
    }
}
function nextDetails() {
    document.getElementById('FullName').innerHTML = "<h1>Now ! Can i know your email-id"
    document.getElementById('gender').style.display = "none";
    document.getElementById('email').style.display = "";
}
function isEmailValidate() {
    var emailValidate = /^[A-Za-z]+[A-Za-z0-9._%+-]+@[A-Za-z0-9.-]+\.[A-Za-z]{2,}$/;
    var email = document.getElementById('email-id').value;
    var flag = true;
    if (!(emailValidate.test(email))) {
        alert('Enter valid email-id');
        flag = false;
    }
    if (flag) {
        document.getElementById('FullName').innerHTML = "<h1>Now ! Can i know your password"
        document.getElementById('email').style.display = "none";
        document.getElementById('password').style.display = "";
    }
}
function isPasswordValidate() {
    var password = document.getElementById('employeePassword').value;
    var flag = true;
    if (password.length === 0) {
        alert("Minimum length of password does not match the criteria");
    }
    // Create an array and push all possible values that you want in password
    var matchedCase = new Array();
    matchedCase.push("[$@$!%*#?&]"); // Special Charector
    matchedCase.push("[A-Z]");      // Uppercase Alpabates
    matchedCase.push("[0-9]");      // Numbers
    matchedCase.push("[a-z]");     // Lowercase Alphabates

    // Check the conditions
    var ctr = 0;
    for (var i = 0; i < matchedCase.length; i++) {
        if (new RegExp(matchedCase[i]).test(password)) {
            ctr++;
        }
    }
    // Display it
    var color = "";
    var strength = "";
    switch (ctr) {
        case 0:
        case 1:
        case 2:
            strength = "Very Weak";
            color = "red";
            break;
        case 3:
            strength = "Medium";
            color = "orange";
            break;
        case 4:
            strength = "Strong";
            color = "green";
            break;
    }
    document.getElementById("employeePassword").innerHTML = strength;
    document.getElementById("employeePassword").style.color = color;
    if (strength != "Strong") {
        alert("Enter valid password");
        document.getElementById('employeeConfirmPassword').disabled = true;
    }
    else
        document.getElementById('employeeConfirmPassword').disabled = false;
}
function isConfirmPasswordMatchValidation() {
    if (document.getElementById('employeePassword').value ==
        document.getElementById('employeeConfirmPassword').value) {
        document.getElementById('employeeConfirmPassword').style.color = 'green';
        document.getElementById('next').disabled = false;
    } else {
        document.getElementById('employeeConfirmPassword').style.color = 'red';
        document.getElementById('next').disabled = true;
    }
}
function nextContactNumber() {
    var password = document.getElementById('employeePassword').value;
    var confirmPassword = document.getElementById('employeeConfirmPassword').value;
    if (password.length === 0 || confirmPassword.length === 0) {
        alert("Minimum length of password does not match the criteria");
    }
    else {
        document.getElementById('FullName').innerHTML = "<h1>Now ! Can i know your contact Number"
        document.getElementById('password').style.display = "none";
        document.getElementById('contact').style.display = "";
    }
}
function isContactNumberValidate() {
    var phoneno = /^\d$/;
    var contact = document.getElementById('employeeContact').value;
    var flag = true;
    if ((!(phoneno.test(contact))) && (contact.length < 9)) {
        alert('Enter valid number');
        flag = false;
    }
    if (flag) {
        registerEmployee();
    }
}
function registerEmployee() {
    var employeeId = Math.floor((Math.random() * 100) + 1);
    document.getElementById('FullName').innerHTML = "<h1>Thank you for registering and your ID is " + employeeId
    document.getElementById('contact').innerHTML = "<h1>Now please share your vehicle details"
    document.getElementById('EmployeeCarName').style.display = "";
}

function isFieldEmpty(val) {
    let flag = false;
    if (val == "") {
        flag = true;
    }
    return flag;
}

function isVehicleNameEntered() {
    let flag = isFieldEmpty(document.getElementById('carName').value);
    if (flag) {
        alert("Name cannot be empty");
    }
    else {
        document.getElementById('FullName').style.display = "none";
        document.getElementById('EmployeeCarName').innerHTML = "<h1>What is the type of the vehicle"
        document.getElementById('EmployeeCarType').style.display = ""
    }
}

function isVehicleTypeEntered() {
    console.log(document.getElementById("VehicleType").value);
    let eId = document.getElementById("VehicleType");
    let typeVal = eId.options[eId.selectedIndex].value;
    if (typeVal == "NoSelection") {
        alert("Select valid vehicle type");
    }
    else {
        document.getElementById('contact').style.display = "none";
        document.getElementById('EmployeeCarName').innerHTML = "<h1>What is the vehicle number of your vehicle"
        document.getElementById('EmployeeCarType').style.display = "none";
        document.getElementById('EmployeeCarNumber').style.display = "";
    }
}

function vehicleNumberValidate() {
    var validation = /^[A-Z]{2}\s[0-9]{2}\s[A-Z]{2}\s[0-9]{4}$/
    if (validation.test(document.getElementById('carNumber').value.toUpperCase())) {
        document.getElementById('carNumber').style.color = 'green';
        document.getElementById('nextNumber').disabled = false;
    }
    else {
        document.getElementById('carNumber').style.color = 'red';
        document.getElementById('nextNumber').disabled = true;
    }
}

function goToIdentification() {
    if (document.getElementById('carNumber').value == "") {
        alert("Please fill the details");
    }
    else {
        document.getElementById('EmployeeCarName').innerHTML = "<h1>How can your vehicle be identified"
        document.getElementById('EmployeeCarNumber').style.display = "none";
        document.getElementById('EmployeeCarIdentification').style.display = "";
    }
}

function registerVehicle() {
    var e = document.getElementById("VehicleType");
    var vehicle_Type = e.options[e.selectedIndex].value;
    var vehicle_Number = document.getElementById("carNumber").value;
    if (document.getElementById("vehicleDesc").value == "") {
        alert("Enter description");
    }
    else if (vehicle_Type == "Bicycle") {
        document.getElementById('EmployeeCarName').innerHTML = "<h1> Your " + vehicle_Type + ":" + vehicle_Number + " has successfully registered"
        document.getElementById('EmployeeCarIdentification').style.display = "none";
        document.getElementById("BicycleDivision").style.display = "";
        priceDaily = 5;
        priceMonthly = 100;
        priceYearly = 500;
    }
    else if (vehicle_Type == "Two-Wheeler") {
        document.getElementById('EmployeeCarName').innerHTML = "<h1> Your " + vehicle_Type + ":" + vehicle_Number + " has successfully registered"
        document.getElementById('EmployeeCarIdentification').style.display = "none";
        document.getElementById("TwoWheelerDivision").style.display = "";
        priceDaily = 10;
        priceMonthly = 200;
        priceYearly = 1000;
    }
    else if (vehicle_Type == "Four-Wheeler") {
        document.getElementById('EmployeeCarName').innerHTML = "<h1> Your " + vehicle_Type + ":" + vehicle_Number + " has successfully registered"
        document.getElementById('EmployeeCarIdentification').style.display = "none";
        document.getElementById("FourWheelerDivision").style.display = "";
        priceDaily = 20;
        priceMonthly = 500;
        priceYearly = 3500;
    }
}

function currencyConverter1() {
    var currencyType = document.getElementById("Currency1").options[document.getElementById("Currency1").selectedIndex].value;
    console.log(document.getElementById("Currency1").options[document.getElementById("Currency1").selectedIndex].value);
    if (currencyType == "USD") {
        document.getElementById("dailyBicycle").innerHTML = "$" + (priceDaily * 0.014).toFixed(2);
        document.getElementById("monthlyBicycle").innerHTML = "$" + (priceMonthly * 0.014).toFixed(2);
        document.getElementById("yearlyBicycle").innerHTML = "$" + (priceYearly * 0.014).toFixed(2);
    }
    else if (currencyType == "YEN") {
        document.getElementById("dailyBicycle").innerHTML = "YEN " + (priceDaily * 1.52).toFixed(2);
        document.getElementById("monthlyBicycle").innerHTML = "YEN " + (priceMonthly * 1.52).toFixed(2);
        document.getElementById("yearlyBicycle").innerHTML = "YEN " + (priceYearly * 1.52).toFixed(2);
    }
    else if (currencyType == "INR") {
        document.getElementById("dailyBicycle").innerHTML = "INR " + (priceDaily).toFixed(2);
        document.getElementById("monthlyBicycle").innerHTML = "INR " + (priceMonthly).toFixed(2);
        document.getElementById("yearlyBicycle").innerHTML = "INR " + (priceYearly).toFixed(2);
    }
}

function currencyConverter2() {
    var currencyType = document.getElementById("Currency2").options[document.getElementById("Currency2").selectedIndex].value;
    console.log(document.getElementById("Currency2").options[document.getElementById("Currency2").selectedIndex].value);
    if (currencyType == "USD") {
        document.getElementById("dailyCar").innerHTML = "$" + (priceDaily * 0.014).toFixed(2);
        document.getElementById("monthlyCar").innerHTML = "$" + (priceMonthly * 0.014).toFixed(2);
        document.getElementById("yearlyCar").innerHTML = "$" + (priceYearly * 0.014).toFixed(2);
    }
    else if (currencyType == "YEN") {
        document.getElementById("dailyCar").innerHTML = "YEN " + (priceDaily * 1.52).toFixed(2);
        document.getElementById("monthlyCar").innerHTML = "YEN " + (priceMonthly * 1.52).toFixed(2);
        document.getElementById("yearlyCar").innerHTML = "YEN " + (priceYearly * 1.52).toFixed(2);
    }
    else if (currencyType == "INR") {
        document.getElementById("dailyCar").innerHTML = "INR " + (priceDaily).toFixed(2);
        document.getElementById("monthlyCar").innerHTML = "INR " + (priceMonthly).toFixed(2);
        document.getElementById("yearlyCar").innerHTML = "INR " + (priceYearly).toFixed(2);
    }
}
function currencyConverter3() {
    var currencyType = document.getElementById("Currency3").options[document.getElementById("Currency3").selectedIndex].value;
    console.log(document.getElementById("Currency3").options[document.getElementById("Currency3").selectedIndex].value);
    if (currencyType == "USD") {
        document.getElementById("dailyTwoWheeler").innerHTML = "$" + (priceDaily * 0.014).toFixed(2);
        document.getElementById("monthlyTwoWheeler").innerHTML = "$" + (priceMonthly * 0.014).toFixed(2);
        document.getElementById("yearlyTwoWheeler").innerHTML = "$" + (priceYearly * 0.014).toFixed(2);
    }
    else if (currencyType == "YEN") {
        document.getElementById("dailyTwoWheeler").innerHTML = "YEN " + (priceDaily * 1.52).toFixed(2);
        document.getElementById("monthlyTwoWheeler").innerHTML = "YEN " + (priceMonthly * 1.52).toFixed(2);
        document.getElementById("yearlyTwoWheeler").innerHTML = "YEN " + (priceYearly * 1.52).toFixed(2);
    }
    else if (currencyType == "INR") {
        document.getElementById("dailyTwoWheeler").innerHTML = "INR " + (priceDaily).toFixed(2);
        document.getElementById("monthlyTwoWheeler").innerHTML = "INR " + (priceMonthly).toFixed(2);
        document.getElementById("yearlyTwoWheeler").innerHTML = "INR " + (priceYearly).toFixed(2);
    }
}

function finalPrice(priceId, divisionId) {
    document.getElementById('EmployeeCarName').innerHTML = "<h1> Your total price is" + document.getElementById(priceId).innerHTML;
    document.getElementById(divisionId).style.display = "none";
}