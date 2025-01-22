$(document).ready(function () {
    $.ajax({
        url: '/api/users',
        method: 'GET',
        success:
            function (data) {
                $.each(data, function (key, value) {
                    console.log("key : ", key, "value : ", value);
                    $('#user-container').append(
                        '<div class="card">' +
                        '<h3>' + value.lastname + value.firstname + '</h3>' +
                        '<p>' + value.phone + '</p>' +
                        '<a href="/cart?userId=' + value.userId + '"> 장바구니 확인하기</a>'  +
                        '</div>')
                })
            },
        error:
            function () {
                $('#user-container').append('<p>서버에서 데이터를 가져올 수 없습니다.</p>')
            }
    })
})