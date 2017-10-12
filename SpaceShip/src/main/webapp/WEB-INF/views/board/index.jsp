<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

	<%@include file="../include/header.jsp" %>
    
	<div class="wrap-index">
        <div class="container-fluid">
        	<div class="wrap-title">
                <div class="row">
                    <div class="col-md-6">
                        <h2><span class="glyphicon glyphicon-list-alt"></span> My Board</h2>
                    </div>
                    <div class="col-md-6">
                        <button type="submit" id="btn-board-add" class="btn btn-primary" data-toggle="modal" data-target="#myModal" style="font-family: 'Nanum Gothic';">보드 추가 
                        	<span class="glyphicon glyphicon-plus" aria-hidden="true"></span></button>
                    </div>
                </div>
            </div>
            <c:forEach items="${list}" var="boardVO">
            	<div class="col-md-3">
	                <div class="board">
	                    <a href="/spaceship/board/readBoard?bidx=${boardVO.bidx}">
	                        <p style="font-family: 'Nanum Gothic';">${boardVO.btitle}</p>
	                        <span class="glyphicon glyphicon-chevron-right"></span>
	                    </a>
	                </div>
            	</div>
            </c:forEach>
        </div>
    </div>
    
    <div class="wrap-modal">
        <div class="modal fade" id="myModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel">
            <div class="modal-dialog modal-sm" role="document">
                <div class="modal-content">
                    <div class="modal-header">
                        <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
                        <h4 class="modal-title" id="myModalLabel" style="font-family: 'Nanum Gothic';">보드 추가</h4>
                    </div>
                    <form>
                        <div class="modal-body">
                        	<input type="text" id="bTitle" class="form-control" placeholder="Board title">
                        	<input type="hidden" id="uid" value="${login.uid}">
                        </div>
                        <div class="modal-footer">
                        	<button id="btn-add" type="button" class="btn btn-primary" style="font-family: 'Nanum Gothic';">추가</button>
                        </div>
                    </form>
                </div>
            </div>
        </div>
    </div>
    
</body>
</html>