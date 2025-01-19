$(document).ready(function () {
    $.ajax({
        url: '/api/products',
        method: 'GET',
        success:
            function (products) {


            },
        error: function () {

        }
    });
});