function changeDone(adId) {
    $.ajax({
        method : 'POST',
        url: './change',
        dataType: 'json',
        contentType: 'application/json',
        data: JSON.stringify({
            id: adId
        }),
        complete: function () {
            location.reload();
        }
    });
}