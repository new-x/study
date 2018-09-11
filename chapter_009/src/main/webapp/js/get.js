$(
    getTodo()
);

function getTodo() {
    $.ajax({
        url: "./general",
        type: "GET",
        complete: function (data) {
            var list = JSON.parse(data.responseText);
            var result = "<thead class=\"thead-dark\">\n" +
                "        <tr>\n" +
                "            <th scope=\"col\">#</th>\n" +
                "            <th scope=\"col\">Description</th>\n" +
                "            <th scope=\"col\">Done</th>\n" +
                "            <th scope=\"col\">Date</th>\n" +
                "        </tr>\n" +
                "        </thead>\n" +
                "        <tbody>";
            for (var index = 0; index < list.length; ++index) {
                result += " <tr>\n" +
                    "        <th scope=\"row\">" + index + "</th>\n" +
                    "        <td>" + list[index].description + "</td>\n" +
                    "        <td>" + checkBox(list[index].done, list[index].id) + "</td>\n" +
                    "        <td>" + moment(list[index].creatdata).locale('ru').format('MMMM Do YYYY, HH:mm') + "</td>\n" +
                    "    </tr>"
            }
            var itemList = document.getElementById('todo-table');
            result += "</tbody>"
            itemList.innerHTML = result;
        }
    })
}

function checkBox(done, itemId) {
    if (done == false) {
        return "<form onclick='sendDone(" + itemId + ")'>" +
            "<button type='button' class='btn btn-outline-dark'>Complete</button>" +
            "</form>"
    } else {
        return "<button type='button' class='btn btn-outline-dark' disabled>Done</button>"
    }
}