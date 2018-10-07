function checkDone(data) {
    if (data == false) {
        return "<button type=\"button\" class=\"btn btn-success btn-sm\">Sale</button>"
    } else if(data == true) {
        return "<button type=\"button\" class=\"btn btn-danger btn-sm\">Sold</button>\n"
    }
}
