$("#joinForm").submit(function (event) {
    event.preventDefault();
    //  이메일 중복확인 /api/existEmail
    $.ajax({
        url: "/api/existEmail",
        method: "GET",
        success: function (data) {
            if (data) {
                alert("이미 사용중인 이메일입니다."); // count >0 이상이면 존재
            } else {
                alert("사용 가능한 이메일입니다.");
            }
        },
        error: function (data) {
            alert("데이터베이스 연결할 수 없습니다.");
        }
    })

    $.ajax({
        url: "/api/join",
        method: "POST",
        contentType: "application/json", // db에 글자 형식만 전송하겠다.
        // POST의 경우  contentType 과 data 가 추가됨
        // contentType : 글자형식만 DB에 전송해서 저장할 것인지, 미디어, 파일 등을 포함해서 전달할 것인지 미리 작성
        //      data   : DTO에 작성된 필드이름 : input id명칭에 해당하는 값(value())을 가져와서 전달
        //                  전달된 이름이 필드속성이름과 일치하다면 mapper에서 DB 로 insert
        data: JSON.stringify({
            email: $("#email").val(),
            username: $("#username").val(),
            password: $("#password").val(),
            firstname: $("#firstname").val(),
            lastname: $("#lastname").val(),
            phone: $("#phone").val(),
            city: $("#city").val(),
            street: $("#street").val(),
            streetNumber: $("#streetNumber").val(),
            zipcode: $("#zipcode").val()
        }),
        success: function () { // success에서 회원가입을 완료한 후 전달할게 없다면 data 작성 x
            alert("회원가입이 완료되었습니다.");
            window.location.href = "/"; //회원가입이 완료된 후 이동할 페이지 설정
        },
        error: function (error) {
            console.log(error);
            alert("회원가입을 할 수 없습니다.");
        }
    })
});