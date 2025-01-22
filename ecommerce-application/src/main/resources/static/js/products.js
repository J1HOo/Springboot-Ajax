$(document).ready(function () {
    $.ajax({
        url: '/api/products',
        method: 'GET',
        success:
            function (products) {
                $.each(products, function (key, value) {
                    $('#product-container').append(
                        `<div class="card">
                                <img src="${value.image}" alt="${value.title}">
                                <h3>${value.title}</h3>
                                <p>${value.price}</p>

                            </div>`
                    )
                })

            },
        error: function () {
            alert('상품을 서버에서 가져올 수 없습니다.');
        }
    });
});