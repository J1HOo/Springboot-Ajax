$.ajax({
    url: "/api/products/insert",
    method: "POST",
    contentType: "application/json",
    data: JSON.stringify({
        title: $("#title").val(),
        price: $("#price").val(),
        description: $("#description").val(),
        category: $("#category").val(),
        image: $("#image").val(),
        ratingRate: $("#ratingRate").val(),
        ratingCount: $("#ratingCount").val()
    }),
    success: function (data) {
        alert("제품 등록 성공입니다.");
        window.location.href = "/"; //홈페이지 메인으로 이동하기
    },
    error: function () {
        alert("데이터베이스에 저장을 실패했습니다. 다시 진행해주세요.");
    }
});