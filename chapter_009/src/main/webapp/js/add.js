function addTodo() {
    $.ajax({
        method: 'POST',
        url: './general',
        dataType: 'json',
        contentType: 'application/json',
        data: JSON.stringify({
            'description': document.getElementById("description").value,
            'done': false
        }),
        complete: function () {
            getTodo();
        }
    })
}