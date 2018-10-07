function addAd(data) {
        $.ajax({
            method : 'POST',
            url: './add',
            dataType: 'json',
            contentType: 'application/json',
            data: JSON.stringify({
                car:{
                    image: data,
                    brand:{id: $('#selectBrand').val()},
                    color:{id: $('#selectColor').val()},
                    body:{id: $('#selectBody').val()},
                    engine:{id: $('#selectEngine').val()},
                    transmission:{id: $('#selectTransmissions').val()}
                    },
                price: $('#adPrice').val(),
                done: false,
                description: $('#adDescritpion').val()
            }),
            complete: function () {
                location.reload();
            }
        });
}

function addImage() {
    var data = new FormData();
    jQuery.each(jQuery('#carImage')[0].files, function(i, file) {
        data.append('file-'+i, file);
    });
    $.ajax('./file', {
        data: data,
        cache: false,
        contentType: false,
        processData: false,
        method: 'POST',
        complete: function(data){
            addAd(data.responseText);
        }
    })
}