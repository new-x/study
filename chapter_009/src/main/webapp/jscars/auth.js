function authUser() {
    $.ajax({
        method : 'POST',
        url: './auth',
        dataType: 'json',
        contentType: 'application/json',
        data: JSON.stringify({
            'login': document.getElementById("userLogin").value,
            'password': document.getElementById("userPassword").value,
            'message' : 'authUser'
        }),
        complete: function (data) {
            var user = JSON.parse(data.responseText);
            if (user.login != null) {
                alert(user.message)
            } else {
                alert(user.message)
            }
        }
    });
    location.reload();
}

function authClose() {
    $.ajax({
        method : 'POST',
        url: './auth',
        dataType: 'json',
        contentType: 'application/json',
        data: JSON.stringify({
            'message' : 'authClose'
        }),
        complete: function (data) {
            var user = JSON.parse(data.responseText);
                alert(user.message)
        }
    });
    location.reload();
}