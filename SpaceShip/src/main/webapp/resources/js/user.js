var exp = /^[a-z0-9]{4,20}$/;
var mailExp = /^\w+@[a-zA-Z_]+?\.[a-zA-Z]{2,3}$/;
var space = /\s/g;

//메일 확인
function idCheck() {
	if (!mailExp.test($("#registerId").val())) {
		alert("메일 형식은 abc@abc.com입니다.");
		return false;
	} else {
		return true;
	}
}
// pw확인
function pwCheck() {
	if (!exp.test($("#registerPassword").val())) {	
		alert("비밀번호는 영문, 숫자를 이용하여 4~20자리로 입력해주세요.")
		return false;
	} else {
		return true;
	}
}
// 비밀번호와 비밀번호 확인 일치여부
function pwCheck2() {
	if ($("#registerPassword2").val() != formJoin.registerPassword.value) {
		alert("비밀번호가 일치하지 않습니다.");
		return false;
	} else {
		return true;
	}
}

$(function() {
	var uid = $("#registerId");
	var upw = $("#registerPassword");
	var unick = $("#registerNick");
	var duplch = false;
	$("#registerId").change(function() {
		duplch = false;
		idCheck();
	});
	$("#btn-duplCheck").click(function() {
		// 이 시점의 userId.val() 가져와서 함
		// alert("입력값 : "+userId.val());
		$.ajax({
			method : "GET",
			url : "/spaceship/user/duplCheck",
			data : {
				uid : encodeURI(uid.val())
			},
			success : function(result) {
				if (result == "") {
					duplch = true;
					alert("사용할 수 있는 ID입니다.")
				} else {
					alert("중복된 ID입니다.");
				}
			},
			error : function(request, status, error) {
				alert("code: " + request.status + "\n" + "error:" + error);
			}
		});
	});
	$("#registerPassword").change(function() {
		pwCheck();
	});
	$("#registerPassword2").change(function() {
		pwCheck2();
	});
	$("#btn-join").click(function() {
		// 아이디, Pw, pw확인 일치시 가입진행
		if (idCheck() && pwCheck() && pwCheck2()) {
			if (duplch) {
				$.ajax({
					method : "POST",
					url : "/spaceship/user/addUser",
					contentType : "application/x-www-form-urlencoded; charset=UTF-8",
					data : {
						uid : encodeURI(uid.val()),
						upw : encodeURI(upw.val()),
						unick : unick.val(),
					},
					success : function(result) {
						if (result == 1) {
							alert("회원가입 완료");
							location.href="/spaceship/user/login";
						} else {
							alert("회원가입 실패");
							location.href="/spaceship/user/login";
						}
					},
					error : function(request, status,
							error) {
						alert("code: " + request.status
								+ "\n" + "error:"
								+ error);
					}
				});
			} else if (!duplch) {
				alert("중복확인을 해주세요!")
			}
		}
	});
	
	$("#btn-user-modify").click(function() {
		var uid = $("#modifyId");
		uid = encodeURI(uid.val());
		var upw = $("#modifyPassword");
		var unick = $("#modifyNick");
		
		$.ajax({
			method : "PUT",
			url : "/spaceship/user/userModify/" + uid,
			headers: {
				"Content-Type" : "application/json;charset=UTF-8",
				"X-HTTP-Method-Override" : "PUT",
			},
			data : JSON.stringify({
				uid : uid,
				upw : encodeURI(upw.val()),
				unick : unick.val(),
			}),
			success : function(result) {
				if (result == 1) {
					alert("회원정보수정 완료");
					//location.href="/spaceship/user/login";
				} else {
					alert("회원정보수정 실패");
					//location.href="/spaceship/user/login";
				}
			},
			error : function(request, status,
					error) {
				alert("code: " + request.status
						+ "\n" + "error:"
						+ error);
			}
		});
	});
});