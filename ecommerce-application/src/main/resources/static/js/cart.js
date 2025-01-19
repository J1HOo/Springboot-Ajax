$(document).ready(function () {
    const userId = new URLSearchParams(window.location.search).get('userId');

    $.ajax({
        url: `/api/carts?userId=${userId}`,
        method: 'GET',
        success: function (cart) {

        });
    },
    error: function () {
        alert('장바구니 데이터를 불러올 수 없습니다.');
        }
    });
});