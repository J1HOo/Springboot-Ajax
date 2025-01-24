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
    $("#ratingCount").val(data.ratingRate);
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
})
})