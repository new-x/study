$(
    getButtons()
)

function getButtons() {
    $.ajax({
        method: 'GET',
        url: './auth',
        dataType: 'json',
        contentType: 'application/json',
        complete: function (data) {
            var user = JSON.parse(data.responseText);
            var containerId = document.getElementById('menuButton');
            var button = "";
            if (user.login != null) {
                button += "<button type=\"button\" class=\"btn btn-primary\" data-toggle=\"modal\" data-target=\"#addNewAd\">Add Ad</button>\n";
                button += "<button type=\"button\" class=\"btn btn-primary\" data-toggle=\"modal\" onclick='authClose()'>Sign Out</button>\n";
                getAllTypes();
            } else {
                button += "<button type=\"button\" class=\"btn btn-primary\" data-toggle=\"modal\" data-target=\"#authUser\">Sign In</button>\n";
            }
            containerId.innerHTML += button;
        }
    })
}
