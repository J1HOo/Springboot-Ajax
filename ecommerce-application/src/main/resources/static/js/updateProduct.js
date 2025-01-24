 // 1. 제품 상세보기에 작성한 제품 불러오기 api
    // js URL SEARCH PARAMETERS
    const params = new URLSearchParams(window.location.search);
    const id = params.get("id");
    $.ajax({
    url: `/api/product/${id}`,
    method: "GET",
    success:
    function (data) {
    if(data) {
    $("#title").val(data.title);
    $("#price").val(data.price);
    $("#description").val(data.description);
    $("#category").val(data.category);
    $("#image").val(data.image);
    $("#ratingRate").val(data.ratingRate);
    $("#ratingCount").val(data.ratingCount);
}
},
    error:
    function () {
    $("#productDetail").html("<p>백엔드 api 에서 데이터를 가져오는데 문제가 발생했습니다.</p>");
}
})
    // 2. 제품 수정하기 put api 사용
    $("#product-form").on("submit", function (event) {
    event.preventDefault();
    $.ajax({
        url: `/api/update/${id}`,
        method: "PUT",
        contentType: "application/json",
        data: JSON.stringify({
            title: $("#title").val(),
            price: $("#price").val(),
            description: $("#description").val(),
            category: $("#category").val(),
            image: $("#image").val(),
            ratingRate: $("#ratingRate").val(), // 만약에 숫자값으로 들어가지 않을경우 input 형변환 parseInt
            ratingCount: $("#ratingCount").val()
        }),
        success:
            function (data) {
                alert("상품 수정 성공~!");
                window.location.href = "/";
            },
        error:
            function () {
                alert("데이터를 수정할 수 없습니다. 다시 시도해주세요.");
            }
})
})