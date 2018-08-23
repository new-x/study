function checkLogin() {
    var login = document.getElementById("login").value;
    var password = document.getElementById("password").value;
    var result = true;
    if (login == '') {
        alert("Please input Login.");
        result = false;
    } else if (password == '') {
        alert("Please input Password.");
        result = false;
    }
    return result;
}

function checkAddUser() {
    var name = document.getElementById("name").value;
    var login = document.getElementById("login").value;
    var city = document.getElementById("city").value;
    var country = document.getElementById("country").value;
    var password = document.getElementById("password").value;
    var email = document.getElementById("email").value;
    var result = true;
    if (name == '') {
        alert("Please input Name.");
        result = false;
    } else if (login == '') {
        alert("Please input Login.");
        result = false;
    } else if (password == '') {
        alert("Please input Password.");
        result = false;
    } else if (city == '') {
        alert("Please input Citry.");
        result = false;
    } else if (country == '') {
        alert("Please input Country.");
        result = false;
    } else if(email == '') {
        alert("Please input Email.");
        result = false;
    }
    return result;
}