function validateLogin() {
    const email = document.getElementById("email").value;
    const password = document.getElementById("password").value;
    const emailRegex = /^[^\s@]+@[^\s@]+\.[^\s@]+$/;

    if (!emailRegex.test(email)) {
        alert("Please enter a valid email address");
        return false;
    }
    if (password.length < 6) {
        alert("Password must be at least 6 characters long");
        return false;
    }
    return true;
}

function validateRegister() {
    return validateLogin();
}

function validateSearch() {
    const source = document.getElementById("source").value;
    const destination = document.getElementById("destination").value;
    const date = document.getElementById("date").value;

    if (source === destination) {
        alert("Source and destination cannot be the same");
        return false;
    }
    const today = new Date().toISOString().split("T")[0];
    if (date < today) {
        alert("Please select a future date");
        return false;
    }
    return true;
}

function validateFlightForm() {
    const flightNo = document.getElementById("flightNo").value;
    const source = document.getElementById("source").value;
    const destination = document.getElementById("destination").value;
    const flightDate = document.getElementById("flightDate").value;
    const flightTime = document.getElementById("flightTime").value;
    const price = document.getElementById("price").value;

    if (flightNo.trim() === "") {
        alert("Flight number cannot be empty");
        return false;
    }
    if (source === destination) {
        alert("Source and destination cannot be the same");
        return false;
    }
    const today = new Date().toISOString().split("T")[0];
    if (flightDate < today) {
        alert("Please select a future date");
        return false;
    }
    if (flightTime === "") {
        alert("Please select a valid time");
        return false;
    }
    if (price <= 0) {
        alert("Price must be greater than 0");
        return false;
    }
    return true;
}