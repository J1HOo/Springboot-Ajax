const userId = new URLSearchParams(window.location.search).get('userId');

$.ajax({
    url: `/api/carts?userId=${userId}`,
    method: 'GET',
    success: function (cart) {
        $.each(cart, function (item, index) {
            $('#cart-container').append(
                `<div class="card">
                            <h3>${index.title}</h3>
                            <h3>${index.price}</h3>
                            <h3>${index.quantity}</h3>
                                            </div>`)
        })
    },
    error: function () {
        alert('장바구니 데이터를 불러올 수 없습니다.');
    }
});
