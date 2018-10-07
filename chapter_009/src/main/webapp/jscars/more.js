function getMoreInfo(data) {
    var ad = JSON.parse(data);
    checkSaleUser(ad.id);
    var itemList = document.getElementById('moreInfoDoc');
    var result = "        <div class=\"modal-content\">\n" +
        "            <div class=\"modal-header\">\n" +
        "                <h5 class=\"modal-title\" id=\"exampleModalLabel\">Sale: " + ad.car.brand.name + "</h5>\n" +
        "            </div>" +
        "<div class='modal-body'> " +
        "               <form>" +
        "                 <div class=\"text-center\">\n" +
        "                   <img src=\""+ ad.car.image +"\" class=\"rounded\" alt=\"Cinque Terre\" width='50%'>\n" +
        "                 </div>" +
        "           <ul class=\"list-group\">\n" +
        "                   <li class=\"list-group-item\">Status: " + checkDone(ad.done) + "</li>\n" +
        "                   <li class=\"list-group-item\">Color: " + ad.car.color.name + "</li>\n" +
        "                   <li class=\"list-group-item\">Body: " + ad.car.body.name + "</li>\n" +
        "                   <li class=\"list-group-item\">Engine: " + ad.car.engine.name + "</li>\n" +
        "                   <li class=\"list-group-item\">Transsmission: " + ad.car.transmission.name + "</li>\n" +
        "                   <li class=\"list-group-item\">Price: " + ad.price + "$</li>\n" +

        "           </ul>" +
        "</form>" +
        "</div>" +
        "            <div class=\"modal-body\">\n" +
        "                <p>" + ad.description + "</p>" +
        "            </div>" +
        "            <div class=\"modal-body\" id=\"buttonSale\">\n" +
        "            </div>"
    itemList.innerHTML = result;
}

function checkSaleUser(adId) {
    $.ajax({
        method: 'POST',
        url: './general',
        dataType: 'json',
        contentType: 'application/json',
        data: JSON.stringify({
            'id': adId
        }),
        complete: function (data) {
            var button = document.getElementById('buttonSale');
            if (data.responseText === 'true') {
                button.innerHTML = "<button type=\"button\" class=\"btn btn-danger\" value='" + adId + "' onclick='changeDone(this.value)'>Remove from sale</button>\n";
            }
        }
    });
}