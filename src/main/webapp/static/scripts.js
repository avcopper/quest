function reload() {
    $.ajax({
        url: '/start',
        type: 'GET',
        contentType: 'application/json;charset=UTF-8',
        async: false,
        success: function () {
            location.reload();
        }
    });
}

function restart() {
    $.ajax({
        url: '/restart',
        type: 'POST',
        contentType: 'application/json;charset=UTF-8',
        async: false,
        success: function () {
            location.reload();
        }
    });
}

function setName() {
    $.ajax({
        url: '/name?name=' + $('input[name=name]').val(),
        type: 'POST',
        contentType: 'application/json;charset=UTF-8',
        async: false,
        success: function () {
            location.reload();
        }
    });
}
