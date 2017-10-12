$(document).ready(function() {
	$(".btn-menu-close").on("click", function() {
		$(".wrap-board-right").animate({
			width:"toggle",
		}, 200);
	});
	$(".btn-menu-open").on("click", function() {
		$(".wrap-board-right").animate({
			width:"toggle"
		}, 200);
	});
});

$(document).ready(function() {
	var target = $(event.target);
	
	$(".board").mouseenter(enterHandler);
	$(".board").mouseleave(leaveHandler);
});

function enterHandler(event) {
	var target = $(event.target);
	
	if(target.is("a")) {
		target.css("background-color", "#e6e6e6");
		target.children("a > span").removeClass("glyphicon-chevron-right").addClass("glyphicon-chevron-down");
		target.children("a > p").css("font-weight", "800");
	}
}

function leaveHandler(event) {
	var target = $(event.target);
	
	if(target.is("a")) {
		target.css("background-color", "#fff");
		target.children("a > span").removeClass("glyphicon-chevron-down").addClass("glyphicon-chevron-right");
		target.children("a > p").css("font-weight", "400");
	}
}

$(function() {
	var btitle = $("#bTitle");
	var uid = $("#uid");
	$("#btn-add").click(function() {
		$.ajax({
			method : "POST",
			url : "/spaceship/board/addBoard",
			contentType : "application/x-www-form-urlencoded; charset=UTF-8",
			data : {
				btitle : btitle.val(),
				uid : encodeURI(uid.val()),
			},
			success : function(result) {
				if (result == 1) {
					//alert("보드생성 완료");
					location.href="/spaceship/board/list?uid=" + uid.val();
				} else {
					alert("보드생성 실패");
					location.href="/spaceship/board/list?uid=" + uid.val();
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
	var uid = $("#uid-add");
	var bidx = $("#bidx-add");
	$("#submit-member-add").click(function() {
		$.ajax({
			method : "POST",
			url : "/spaceship/board/addMember",
			contentType : "application/x-www-form-urlencoded; charset=UTF-8",
			data : {
				bidx : bidx.val(),
				uid : encodeURI(uid.val()),
			},
			success : function(result) {
				if (result == 1) {
					//alert("멤버추가 완료");
					location.href="/spaceship/board/readBoard?bidx=" + bidx.val();
				} else {
					alert("멤버추가 실패");
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
	var bidx = $("#bidx-add").val();
	var uid = $("#uid-add");
	
	$("#submit-member-delete").click(function(event) {
		$.ajax({
			method : "GET",
			url : "/spaceship/board/removeMember/" + bidx,
			contentType : "application/x-www-form-urlencoded; charset=UTF-8",
			data : {
				bidx : bidx,
				uid : uid.val(),
			},
			success : function(result) {
				if (result == 1) {
					//alert("멤버제외 완료");
					location.href="/spaceship/board/readBoard?bidx=" + bidx;
				} else {
					alert("멤버제외 실패");
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
	var ltitle = $("#ltitle");
	var bidx = $("#list-bidx");
	$("#btn-list-add").click(function() {
		$.ajax({
			method : "POST",
			url : "/spaceship/board/addList",
			contentType : "application/x-www-form-urlencoded; charset=UTF-8",
			data : {
				bidx : bidx.val(),
				ltitle : ltitle.val(),
			},
			success : function(result) {
				if (result == 1) {
					//alert("리스트추가 완료");
					location.href="/spaceship/board/readBoard?bidx=" + bidx.val();
				} else {
					alert("리스트추가 실패");
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
	var bidx = $("#card-bidx").val();
	
	$(".btn-delete-list").click(function(event) {
		var lidx = $(this).attr("lidx");
		
		$.ajax({
			method : "DELETE",
			url : "/spaceship/board/removeList/" + lidx,
			contentType : "application/x-www-form-urlencoded; charset=UTF-8",
			dataType : "text",
			success : function(result) {
				if (result == 1) {
					//alert("리스트삭제 완료");
					location.href="/spaceship/board/readBoard?bidx=" + bidx;
				} else {
					alert("리스트삭제 실패");
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
	
	$(".btn-delete-board").click(function(event) {
		var bidx = $(this).attr("bidx");
		var uid = $("#card-uid").val();
		
		$.ajax({
			method : "DELETE",
			url : "/spaceship/board/removeBoard/" + bidx,
			contentType : "application/x-www-form-urlencoded; charset=UTF-8",
			dataType : "text",
			success : function(result) {
				if (result == 1) {
					//alert("보드삭제 완료");
					location.href="/spaceship/board/list?uid=" + uid;
				} else {
					alert("보드삭제 실패");
					location.href="/spaceship/board/list?uid=" + uid;
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