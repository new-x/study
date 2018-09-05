$(
    $.ajax({
        url: "./address",
        type: "GET",
        complete: function (data) {
            var countries = JSON.parse(data.responseText);
            var result = "<option value=\"\">" + "Select country" + "</option>";
            if (data.responseText !== undefined) {
                for (var index = 0; index < countries.length; ++index) {
                    result += "<option value=\"" + countries[index] + "\">" + countries[index] + "</option>"
                }
            }
            var selectCountrys = document.getElementById("selectCountry");
            selectCountrys.innerHTML = result;
        }

    })
);

function getCityByCountry() {
    $.ajax({
        url: "./address",
        type: "POST",
        dataType: 'json',
        data: {"country" : $('#selectCountry').val()},
        complete: function (data) {
            var cities = JSON.parse(data.responseText);
            var result = "<option value=\"\">" + "Select citry" + "</option>";
            if (data.responseText !== undefined) {
                for (var index = 0; index < cities.length; ++index) {
                    result += "<option value=\"" + cities[index] + "\">" + cities[index] + "</option>"
                }
            }
            var selectCities = document.getElementById("selectCity");
            selectCities.innerHTML = result;
        }
    })
}