<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>

    <%@include file="../include/header.jsp" %>
	
	<div class="wrap-board">
        <div class="container-fluid">
            <h2 style="font-family: 'Nanum Gothic';">${board.btitle} <a href="#" class="btn-delete-board" bidx="${board.bidx}"><span class="glyphicon glyphicon-trash" aria-hidden="true"></span></a></h2>
            <div class="row">
            	<c:forEach items="${list}" var="listVO">
            		<div class="list" lidx="${listVO.lidx}">
            			<c:set var="lidx">${listVO.lidx}</c:set>
            			<h3 style="font-family: 'Nanum Gothic';">${listVO.ltitle}</h3>
            			<c:forEach items="${cardList}" var="cardVO">
            				<c:set var="cardlidx">${cardVO.lidx}</c:set>
            				<c:if test="${lidx eq cardlidx}">
            					<div class="card priority-${cardVO.grade}">
			                        <a href="#" data-toggle="modal" data-target="#cardModal${cardVO.cidx}" class="read-card" cidx="${cardVO.cidx}">
			                            <h4 style="font-family: 'Nanum Gothic';">${cardVO.ctitle}</h4>
			                            <p style="font-family: 'Nanum Gothic';">추가 내용은 여기로</p>
			                        </a>
			                    </div>
            				</c:if>
            			</c:forEach>
            			<button type="button" class="btn btn-card-add" data-toggle="modal" data-target="#myModal" style="font-family: 'Nanum Gothic';"><span class="glyphicon glyphicon-plus" aria-hidden="true"></span> 카드 추가</button>
            			<a href="#" class="btn-delete-list" lidx="${listVO.lidx}"><span class="glyphicon glyphicon-trash" aria-hidden="true"></span></a>
            		</div>
            	</c:forEach>
                <div class="list-add">
                    <a href="#" data-toggle="modal" data-target="#myModal1" style="font-family: 'Nanum Gothic';"><span class="glyphicon glyphicon-plus" aria-hidden="true"></span> 리스트 추가</a>
                </div>
                <div class="btn-menu-open">
                	<a href="#"><span class="glyphicon glyphicon-backward" aria-hidden="true"></span></a>
                </div>
            </div>
        </div>
    </div>
    
    <div class="wrap-board-right">
        <div class="wrap-member">
            <div class="wrap-title">
                <h5>멤버</h5>
                <c:if test="${login.uid eq board.uid}">
                <button type="button" class="btn btn-member-add" data-toggle="modal" data-target="#myModal3" style="font-family: 'Nanum Gothic';"><span class="glyphicon glyphicon-plus" aria-hidden="true"></span> 관리</button>
                </c:if>
                <div class="clear"></div>
            </div>
            <div class="list-member">
            	<c:forEach items="${member}" var="userVO">
            		<div class="member">
	                    <a href="#">
	                        <img src="<c:url value="/resources/images/ic-avatar.png" />" alt="ic-avatar">
	                        <p>${userVO.unick}</p>
	                    </a>
                	</div>
            	</c:forEach>
                <div class="clear"></div>
            </div>
        </div>
        <div class="wrap-activity">
            <h5>최근 보드 댓글</h5>
            <div class="activity">
            	<c:forEach items="${recentReply}" var="replyVO">
            		<c:set var="credate" value="${replyVO.credate}" />
	                <div class="wrap-con-activity">
	                    <div class="activity-left">
	                        <a href="#"><img src="<c:url value="/resources/images/ic-avatar.png" />" alt="ic-avatar"></a>
	                    </div>
	                    <div class="activity-right">
	                        <p class="con-name-time"><a href="#">${replyVO.ruid}</a> 의 댓글 
	                        	<a class="card-name" href="#" data-toggle="modal" data-target="#cardModal${replyVO.cidx}">${replyVO.ctitle}</a></p>
	                        <a class="con-activity" href="#" data-toggle="modal" data-target="#cardModal${replyVO.cidx}">${replyVO.rcontent}</a>
	                        <p><span class="con-time"><fmt:formatDate value="${credate}" pattern="MM월 dd일 hh:mm:ss" /></span></p>
	                    </div>
	                    <div class="clear"></div>
	                </div>
                </c:forEach>
                <div class="btn-menu-close">
                	<a href="#"><span class="glyphicon glyphicon-forward" aria-hidden="true"></span></a>
                </div>
            </div>
        </div>
    </div>
    
    <div class="wrap-modal">
        <div class="modal fade" id="myModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel">
            <div class="modal-dialog modal-sm" role="document">
                <div class="modal-content">
                    <div class="modal-header">
                        <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
                        <h4 class="modal-title" id="myModalLabel" style="font-family: 'Nanum Gothic';">카드 추가</h4>
                    </div>
                    <form>
                        <div class="modal-body">
                        	<input type="text" id="ctitle" class="form-control" placeholder="Card title">
                        	<textarea rows="3" id="card-content" class="form-control" placeholder="Card contents"></textarea>
                        	<input id="card-lidx" type="hidden">
                        	<input type="hidden" id="card-bidx" value="${board.bidx}">
                        	<input type="hidden" id="card-uid" value="${login.uid}">
                        </div>
                        <div class="modal-footer">
                            <button type="button" id="btn-card" class="btn btn-primary btn-add" style="font-family: 'Nanum Gothic';">추가</button>
                        </div>
                    </form>
                </div>
            </div>
        </div>
    </div>
    
    <div class="wrap-modal">
        <div class="modal fade" id="myModal1" tabindex="-1" role="dialog" aria-labelledby="myModalLabel">
            <div class="modal-dialog modal-sm" role="document">
                <div class="modal-content">
                    <div class="modal-header">
                        <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
                        <h4 class="modal-title" id="myModalLabel1" style="font-family: 'Nanum Gothic';">리스트 추가</h4>
                    </div>
                    <form>
                        <div class="modal-body">
                        	<input type="text" id="ltitle"class="form-control" placeholder="List title">
                        	<input type="hidden" id="list-bidx" value="${board.bidx}">
                        </div>
                        <div class="modal-footer">
                            <button type="button" id="btn-list-add" class="btn btn-primary btn-add" style="font-family: 'Nanum Gothic';">추가</button>
                        </div>
                    </form>
                </div>
            </div>
        </div>
    </div>
    
    <div class="wrap-modal">
        <div class="modal fade" id="myModal3" tabindex="-1" role="dialog" aria-labelledby="myModalLabel">
            <div class="modal-dialog modal-sm" role="document">
                <div class="modal-content">
                    <div class="modal-header">
                        <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
                        <h4 class="modal-title" id="myModalLabel3" style="font-family: 'Nanum Gothic';">보드 멤버 관리</h4>
                    </div>
                    <form>
                        <div class="modal-body">
                        	<input type="text" id="uid-add" class="form-control" placeholder="멤버 ID(Email)">
                        	<input type="hidden" id="bidx-add" value="${board.bidx}">
                        </div>
                        <div class="modal-footer">
                            <button type="button" id="submit-member-add" class="btn btn-primary btn-add" style="font-family: 'Nanum Gothic';">추가</button>
                            <button type="button" id="submit-member-delete" class="btn btn-primary btn-add" style="font-family: 'Nanum Gothic';">제외</button>
                        </div>
                    </form>
                </div>
            </div>
        </div>
    </div>
    
    <c:forEach items="${cardList}" var="cardVO">
    	<c:set var="cidx">${cardVO.cidx}</c:set>
	    <div class="wrap-card-modal">
	    	<div class="modal fade bs-example-modal-lg" id="cardModal${cardVO.cidx}" tabindex="-1" role="dialog" aria-labelledby="myModalLabel">
	            <div class="modal-dialog modal-lg" role="document">
	                <div class="modal-content">
	                    <div class="modal-header">
	                        <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
	                        <h4 class="modal-title" id="myModalLabel2" style="font-family: 'Nanum Gothic';"><img src="<c:url value="/resources/images/ic-spaceship.png" />" alt="ic-spaceship"> ${cardVO.ctitle}</h4>
	                        <h5>${cardVO.ltitle}</h5>
	                    </div>
	                    <div class="modal-body">
	                    	<div class="row">
	                            <div class="col-md-9">
	                            	<div class="wrap-con-card">
	                                    <h6>설명</h6>
	                                    <p>${cardVO.content}</p>
	                                </div>
	                                <div class="wrap-attach">
	                                    <h6><span class="glyphicon glyphicon-paperclip" aria-hidden="true"></span> 첨부파일</h6>
	                                    <div class="area-attach" cidx="${cardVO.cidx}">
		                                    <span class="glyphicon glyphicon-folder-open" aria-hidden="true"></span>
		                                    <p>여기에 파일을 올려주세요.</p>
	                                    </div>
	                                    <div class="attach">
	                                    	<c:forEach items="${attach}" var="attach">
	                                    		<c:set var="attachcidx">${attach.cidx}</c:set>
            									<c:if test="${cidx eq attachcidx}">
			                                       	<p><a href="/spaceship/card/displayFile?fileName=${attach.attachname}">${attach.originalname} <span class="glyphicon glyphicon-download-alt" aria-hidden="true"></span></a>
			                                       		<span class="glyphicon glyphicon-trash delbtn" aria-hidden="true" data-src="${attach.attachname}"></span></p>
			                                       	<p class="date">${attach.credate}</p>
		                                       	</c:if>
                                        	</c:forEach>
	                                    </div>
	                                </div>
	                                <div class="wrap-comment">
	                                	<h6><span class="glyphicon glyphicon-comment" aria-hidden="true"></span> 댓글달기</h6>
	                                    <div class="wrap-left-comment">
	                                        <img src="<c:url value="/resources/images/ic-avatar.png" />" alt="ic-avatar">
	                                        <p>${login.unick}</p>
	                                    </div>
	                                    <div class="wrap-right-comment">
	                                        <form>
	                                        	<input type="hidden" class="reply-cidx" value="${cardVO.cidx}">
	                                        	<input type="hidden" class="reply-bidx" value="${board.bidx}">
	                                        	<input type="hidden" class="reply-uid" value="${login.unick}">
	                                        	<textarea rows="4" class="form-control reply-content" placeholder="메세지를 여기에 쓰세요"></textarea>
	                                            <button type="button" class="btn btn-comment">보내기</button>
	                                        </form>
	                                    </div>
	                                    <div class="clear"></div>
	                                </div>
	                                <div class="wrap-activity">
	                                	<h6><span class="glyphicon glyphicon-comment" aria-hidden="true"></span> 댓글</h6>
	                                	<c:forEach items="${reply}" var="replyVO">
	                                		<c:set var="replycidx">${replyVO.cidx}</c:set>
            								<c:if test="${cidx eq replycidx}">
			                                    <div class="comment">
			                                    	<img src="<c:url value="/resources/images/ic-avatar.png" />" alt="ic-avatar">
			                                        <div class="wrap-con-comment">
			                                            <p><a href="#">${replyVO.ruid}</a> <span>${replyVO.credate}</span> 
			                                            <c:if test="${login.unick eq replyVO.ruid}">
			                                            	<span class="glyphicon glyphicon-trash reply-delbtn" aria-hidden="true" ridx="${replyVO.ridx}"></span>
			                                            </c:if>
			                                            </p>
			                                            <p>${replyVO.rcontent}</p>
			                                        </div>
			                                        <div class="clear"></div>
			                                    </div>
		                                    </c:if>
	                                    </c:forEach>
	                                </div>
	                            </div>
	                            <div class="col-md-3">
	                            	<h6>추가</h6>
	                                <div class="btn-card btn-add-member" data-toggle="modal" data-target="#cardMemberModal${cardVO.cidx}">
	                                	<a href="#">멤버</a>
	                                </div>
	                                <div class="btn-card btn-label" data-toggle="modal" data-target="#cardLabelModal${cardVO.cidx}">
	                                	<a href="#">라벨</a>
	                                </div>
	                                <div class="btn-card btn-attach">
	                                	
	                                	<a href="#">첨부</a>
	                                </div>
	                                
	                                <div class="btn-card btn-finish" cidx="${cardVO.cidx}">
	                                	<a href="#">완료</a>
	                                </div>
	                                <div class="btn-card btn-delete" cidx="${cardVO.cidx}">
	                                	<a href="#">삭제</a>
	                                </div>
	                            </div>
	                        </div>
	                    </div>
	                    <div class="modal-footer">
	                    </div>
	                </div>
	            </div>
	        </div>
	    </div>
	    
        <div class="wrap-modal">
	        <div class="modal fade" id="cardMemberModal${cardVO.cidx}" tabindex="-1" role="dialog" aria-labelledby="myModalLabel">
	            <div class="modal-dialog modal-sm" role="document">
	                <div class="modal-content">
	                    <div class="modal-header">
	                        <button type="button" class="close close-card-member" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
	                        <h4 class="modal-title" id="myModalLabel3" style="font-family: 'Nanum Gothic';">카드멤버 추가</h4>
	                    </div>
	                    <form>
	                        <div class="modal-body">
	                        </div>
	                        <div class="modal-footer">
	                        	<input type="text" class="form-control uid-add" placeholder="추가할 멤버 ID(Email)">
	                            <button type="button" class="btn btn-primary btn-add card-member-add" cidx="${cardVO.cidx}" style="font-family: 'Nanum Gothic';">추가</button>
	                        </div>
	                    </form>
	                </div>
	            </div>
	        </div>
	    </div>
	    
	    <div class="wrap-modal">
	        <div class="modal fade" id="cardLabelModal${cardVO.cidx}" tabindex="-1" role="dialog" aria-labelledby="myModalLabel">
	            <div class="modal-dialog modal-sm" role="document">
	                <div class="modal-content">
	                    <div class="modal-header">
	                        <button type="button" class="close close-card-member" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
	                        <h4 class="modal-title" id="myModalLabel3" style="font-family: 'Nanum Gothic';">카드라벨 설정</h4>
	                    </div>
	                    <form>
	                        <div class="modal-body">
	                        </div>
	                        <div class="label-modify">
	                        	<input type="radio" name="label-select" value="1"> <span class="input-label label-1"></span>
	                        	<input type="radio" name="label-select" value="2"> <span class="input-label label-2"></span>
	                        	<input type="radio" name="label-select" value="3"> <span class="input-label label-3"></span>
	                        	<input type="radio" name="label-select" value="4"> <span class="input-label label-4"></span>
	                        	<input type="radio" name="label-select" value="5"> <span class="input-label label-5"></span>
	                            <button type="button" class="btn btn-primary btn-add modify-card-label" cidx="${cardVO.cidx}" style="font-family: 'Nanum Gothic';">선택</button>
	                        </div>
	                    </form>
	                </div>
	            </div>
	        </div>
	    </div>
	    
    </c:forEach>
    
</body>
</html>