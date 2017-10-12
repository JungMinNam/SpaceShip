$(document).ready(function() {
	$(".btn-card-add").click(clickHandler);
	
});

function clickHandler(event) {
	var target = $(event.target);
	
	if(target.is(".btn-card-add")) {
		$("#card-lidx").attr("value", target.parent().attr("lidx"));
	}
	
	if(target.is(".btn-deadline")) {
		$(".btn-deadline").datepicker();
	}
}

$(function() {
	var bidx = $("#card-bidx");
	var lidx = $("#card-lidx");
	var ctitle = $("#ctitle");
	var content = $("#card-content");
	var uid = $("#card-uid");
	$("#btn-card").click(function() {
		$.ajax({
			method : "POST",
			url : "/spaceship/card/addCard",
			contentType : "application/x-www-form-urlencoded; charset=UTF-8",
			data : {
				bidx : bidx.val(),
				lidx : lidx.val(),
				ctitle : ctitle.val(),
				content : content.val(),
				uid : uid.val(),
			},
			success : function(result) {
				if (result == 1) {
					//alert("카드생성 완료");
					location.href="/spaceship/board/readBoard?bidx=" + bidx.val();
				} else {
					alert("카드생성 실패");
					location.href="/spaceship/board/readBoard?bidx=" + bidx.val();
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

$(function() {
	var cidx = 13;
	$("#getTest").click(function() {
		$.ajax({
			method : "GET",
			url : "/spaceship/card/readCard",
			contentType : "application/x-www-form-urlencoded; charset=UTF-8",
			data : {
				cidx : cidx,
			},
			success : function(result) {
				alert(result);
				console.log(result);
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

$(function() {
	var bidx = $("#card-bidx").val();
	
	$(".btn-delete").click(function(event) {
		var cidx = $(this).attr("cidx");
		
		$.ajax({
			method : "DELETE",
			url : "/spaceship/card/deleteCard/" + cidx,
			contentType : "application/x-www-form-urlencoded; charset=UTF-8",
			dataType : "text",
			success : function(result) {
				if (result == 1) {
					//alert("카드삭제 완료");
					location.href="/spaceship/board/readBoard?bidx=" + bidx;
				} else {
					alert("카드삭제 실패");
					location.href="/spaceship/board/readBoard?bidx=" + bidx;
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

$(function() {
	var bidx = $("#card-bidx").val();
	
	$(".modify-card-label").click(function(event) {
		var cidx = $(this).attr("cidx");
		var grade = $(this).siblings("input:checked").val();
		
		$.ajax({
			method : "PUT",
			url : "/spaceship/card/updateCardLabel/" + cidx,
			headers: {
				"Content-Type" : "application/json;charset=UTF-8",
				"X-HTTP-Method-Override" : "PUT",
			},
			data : JSON.stringify({
				grade : grade,
			}),
			success : function(result) {
				if (result == 1) {
					//alert("카드라벨 수정 완료");
					location.href="/spaceship/board/readBoard?bidx=" + bidx;
				} else {
					alert("카드라벨 수정 실패");
					location.href="/spaceship/board/readBoard?bidx=" + bidx;
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

$(function() {
	var bidx = $("#card-bidx").val();
	
	$(".btn-finish").click(function(event) {
		var cidx = $(this).attr("cidx");
		
		$.ajax({
			method : "PUT",
			url : "/spaceship/card/updateCardFinish/" + cidx,
			contentType : "application/x-www-form-urlencoded; charset=UTF-8",
			dataType : "text",
			success : function(result) {
				if (result == 1) {
					//alert("카드상태 업데이트 완료");
					location.href="/spaceship/board/readBoard?bidx=" + bidx;
				} else {
					alert("카드상태 업데이트 실패");
					location.href="/spaceship/board/readBoard?bidx=" + bidx;
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

$(function() {
	$(".card-member-add").click(function(event) {
		var cidx = $(this).attr("cidx");
		var uid = $(this).siblings(".uid-add").val();
		var bidx = $("#card-bidx").val();
		
		$.ajax({
			method : "POST",
			url : "/spaceship/card/addCardMember",
			contentType : "application/x-www-form-urlencoded; charset=UTF-8",
			data : {
				uid : uid,
				cidx : cidx,	
			},
			success : function(result) {
				if (result == 1) {
					//alert("카드 멤버추가 완료");
					//location.href="/spaceship/board/readBoard?bidx=" + bidx;
				} else {
					alert("카드 멤버추가 실패");
					//location.href="/spaceship/board/readBoard?bidx=" + bidx;
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

function checkImageType(fileName) {
	var pattern = /jpg|gif|png|jpeg/i;
	
	return fileName.match(pattern);
}

function getOriginalName(fileName) {
	
	if(checkImageType(fileName)) {
		return;
	}
	
	var idx = fileName.indexOf("_") + 1;
	return fileName.substr(idx);
	
}

function getImageLink(fileName) {
	
	if(!checkImageType(fileName)) {
		return;
	}
	
	var front = fileName.substr(0,12);
	var end = fileName.substr(14);
	
	return front + end;
	
}

$(document).ready(function(){
	// var template = Handlebars.compile($("#template").html());
	
	$(".btn-attach").on("click", function() {
		$(".area-attach").slideToggle("fast");
	});
	
	$(".area-attach").on("dragenter dragover", function(event){
		event.preventDefault();
	});
	
	$(".area-attach").on("drop", function(event){
		event.preventDefault();
		
		var files = event.originalEvent.dataTransfer.files;
		
		var file = files[0];
		
		var cidx = $(this).attr("cidx");
		
		var bidx = $("#card-bidx").val();
		
		var formData = new FormData();
		
		formData.append("file", file);
		formData.append("cidx", cidx);
		formData.append("bidx", bidx);
		
		$.ajax({
			url: '/spaceship/card/uploadAjax',
			data: formData,
			dataType: 'text',
			processData: false,
			contentType: false,
			type: 'POST',
			success: function(data){
				//alert("첨부파일 추가 성공");
				
				/* var str = "";
				
				str = "<div id='"+file+"'><p><a href='/spaceship/card/displayFile?fileName=" + 123 + "'>"
						+ "<span class='glyphicon glyphicon-download-alt' aria-hidden='true'></span></a>"
						+ "<span class='glyphicon glyphicon-trash delbtn' aria-hidden='true' data-src='" 
						+ file +"'></span></p>"
		                + "<p class='date'>" + file + "</p>"
                        + "</div>";
				
				$(".uploadedList").append(str); */
				
				$(".area-attach").hide("fast");
				
				location.href="/spaceship/board/readBoard?bidx=" + bidx;
			}
		});
	});
	
	$(".delbtn").on("click", function(event){
		var that = $(event.target);
		var bidx = $("#card-bidx").val();
		
		$.ajax({
			url:"/spaceship/card/deleteFile",
			type:"POST",
			data: {fileName:$(this).attr("data-src")},
			dataType: "text",
			success: function(result) {
				if(result == 'deleted') {
					//alert("첨부파일 삭제 성공");	
				}
				//$("#"+$(this).attr("data-src")).remove();
				
				location.href="/spaceship/board/readBoard?bidx=" + bidx;
			}
		});
	});
	
	$(function() {
		var bidx = $(".reply-bidx").val();
		var ruid = $(".reply-uid").val();
		
		$(".btn-comment").click(function(event) {
			var target = $(event.target);
			var cidx = target.siblings(".reply-cidx");
			var rcontent = target.siblings(".reply-content");
			
			$.ajax({
				method : "POST",
				url : "/spaceship/card/addCardReply",
				contentType : "application/x-www-form-urlencoded; charset=UTF-8",
				data : {
					cidx : cidx.val(),
					bidx : bidx,
					ruid : ruid,
					rcontent : rcontent.val(),
				},
				success : function(result) {
					if (result == 1) {
						//alert("카드댓글 추가완료");
						location.href="/spaceship/board/readBoard?bidx=" + bidx;
					} else {
						alert("카드댓글 추가실패");
						location.href="/spaceship/board/readBoard?bidx=" + bidx;
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

});

$(function() {
	var bidx = $("#card-bidx").val();
	
	$(".reply-delbtn").click(function(event) {
		var ridx = $(this).attr("ridx");
		
		$.ajax({
			method : "DELETE",
			url : "/spaceship/card/deleteCardReply/" + ridx,
			contentType : "application/x-www-form-urlencoded; charset=UTF-8",
			dataType : "text",
			success : function(result) {
				if (result == 1) {
					//alert("댓글삭제 완료");
					location.href="/spaceship/board/readBoard?bidx=" + bidx;
				} else {
					alert("댓글삭제 실패");
					location.href="/spaceship/board/readBoard?bidx=" + bidx;
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