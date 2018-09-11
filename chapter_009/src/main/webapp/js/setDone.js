function sendDone(itemId) {
    $.ajax({
        method: 'POST',
        url: './update',
        dataType: 'json',
        contentType: 'application/json',
        data: JSON.stringify({
            'id': itemId
        }),
        complete: function () {
            getTodo();
        }
    })
}