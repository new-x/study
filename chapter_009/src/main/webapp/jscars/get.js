$(
    getTypes('filterBrand','brand'),
    getAllAds()
);

function getAllAds() {
        $.ajax({
            url: "./general",
            type: "GET",
            complete: function (data) {
                var list = JSON.parse(data.responseText);
                var result = "<div class=\"card\">";
                for (var index = 0; index < list.length; index++) {
                    var jsonObject = JSON.stringify(list[index]);
                    result += "     <div class=\"card-header\">\n" +
                        "            The announcement of the sale: " + list[index].car.brand.name + " \n" +
                        "        </div>\n" +
                        "        <div class=\"card-body\">\n" +
                        "            <h5 class=\"list-group-item\">Status: " + checkDone(list[index].done) + "</h5>\n" +
                        "            <h5 class=\"card-title\">Brand: " + list[index].car.brand.name + "</h5>\n" +
                        "            <h5 class=\"card-title\">Price: " + list[index].price + "$</h5>\n" +
                        "        <div class=\"card-body\">\n" +
                        "            <button type=\"button\" class=\"btn btn-primary\" data-toggle=\"modal\" data-target=\"#moreInfo\" value='" + jsonObject + "' onclick='getMoreInfo(this.value)'>More detailed</button>\n" +
                        "        </div>\n" +
                        "        </div>"
                }
                var itemList = document.getElementById('allCars');
                result += "</div>";
                itemList.innerHTML = result;
            }
        })
}

function getWithFiltres() {
    $.ajax({
        url: "./filter",
        type: "POST",
        dataType: 'json',
        contentType: 'application/json',
        data: JSON.stringify(
            {
                brand: {id: document.getElementById('filterBrand').value},
                withPhoto: document.getElementById('checkFilter').checked,
                calendarFirst: document.getElementById('filterFirstData').value,
                calendarSecond: document.getElementById('filterSecondData').value
            }
        ),
        complete: function (data) {
            var list = JSON.parse(data.responseText);
            var result = "<div class=\"card\">";
            for (var index = 0; index < list.length; index++) {
                var jsonObject = JSON.stringify(list[index]);
                result += "     <div class=\"card-header\">\n" +
                    "            The announcement of the sale: " + list[index].car.brand.name + " \n" +
                    "        </div>\n" +
                    "        <div class=\"card-body\">\n" +
                    "            <h5 class=\"list-group-item\">Status: " + checkDone(list[index].done) + "</h5>\n" +
                    "            <h5 class=\"card-title\">Brand: " + list[index].car.brand.name + "</h5>\n" +
                    "            <h5 class=\"card-title\">Price: " + list[index].price + "$</h5>\n" +
                    "        <div class=\"card-body\">\n" +
                    "            <button type=\"button\" class=\"btn btn-primary\" data-toggle=\"modal\" data-target=\"#moreInfo\" value='" + jsonObject + "' onclick='getMoreInfo(this.value)'>More detailed</button>\n" +
                    "        </div>\n" +
                    "        </div>"
            }
            var itemList = document.getElementById('allCars');
            result += "</div>";
            itemList.innerHTML = result;
        }
    })
}

function getAllTypes() {
    getTypes('selectBrand','brand');
    getTypes('selectBody','body');
    getTypes('selectColor','color');
    getTypes('selectEngine','engine');
    getTypes('selectTransmissions','transmission');
    getAllAds()
}

function getTypes(button, type) {
    $.ajax({
        url: "./general",
        type: "GET",
        data: {action: type},
        complete: function (data) {
            var list = JSON.parse(data.responseText);
            var result;
            for (var index = 0; index < list.length; index++) {
                result+= "<option value=\"" + list[index].id + "\">" + list[index].name + "</option>"
            }
            document.getElementById(button).innerHTML = result;
        }
    })
}