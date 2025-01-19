$(document).ready(function () {
    $.ajax({
        url: '/api/user',
        method: 'GET',
        success:
            function (user) {


            },
        error: function () {

        }
    });
});