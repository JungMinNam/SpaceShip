<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!doctype html>
<html>
<head>
<meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>board</title>
    <link href="<c:url value="/resources/css/jquery-ui.min.css" />" rel="stylesheet">
    <link href="<c:url value="/resources/css/bootstrap.min.css" />" rel="stylesheet">
    <!-- <link href="//fonts.googleapis.com/earlyaccess/nanumgothic.css" rel="stylesheet"> -->
    <link href="<c:url value="/resources/css/style.css" />" rel="stylesheet">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/handlebars.js/4.0.5/handlebars.js"></script>
    <script src="<c:url value="/resources/js/bootstrap.min.js" />"></script>
    <script src="<c:url value="/resources/js/jquery-ui.min.js" />"></script>
    <script src="<c:url value="/resources/js/board.js" />"></script>
    <script src="<c:url value="/resources/js/card.js" />"></script>
    <script src="<c:url value="/resources/js/upload.js" />"></script>
    <script src="<c:url value="/resources/js/user.js" />"></script>
</head>

<body>
    <nav class="navbar navbar-default">
        <div class="container-fluid">
            <!-- Brand and toggle get grouped for better mobile display -->
            <div class="navbar-header">
                <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#bs-example-navbar-collapse-1" aria-expanded="false">
                    <span class="sr-only">Toggle navigation</span>
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                </button>
                <a class="navbar-brand" href="/spaceship/board/list?uid=${login.uid}"><img src="<c:url value="/resources/images/logo.png" />" alt="logo"></a>
            </div>
            
            <!-- Collect the nav links, forms, and other content for toggling -->
            <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
                <form class="navbar-form navbar-left">
                    <!-- <div class="form-group">
                    	<span class="glyphicon glyphicon-search" aria-hidden="true"></span>
                    	<input type="text" class="form-control" placeholder="Search">
                    </div> -->
                </form>
                <ul class="nav navbar-nav navbar-right">
                    <li class="dropdown">
                        <a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true" aria-expanded="false">
                        	<img src="<c:url value="/resources/images/ic-avatar.png" />" alt="ic-avatar"> ${login.unick} <span class="caret"></span>
                        </a>
                        <ul class="dropdown-menu">
                            <li><a href="#" data-toggle="modal" data-target="#modifyModal">계정 설정</a></li>
                            <li role="separator" class="divider"></li>
                            <li><a href="/spaceship/user/logout">로그아웃</a></li>
                        </ul>
                    </li>
                </ul>
            </div><!-- /.navbar-collapse -->
        </div><!-- /.container-fluid -->
    </nav>
    
    <div class="modal fade wrap-register" id="modifyModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
        <div class="modal-dialog">
            <div class="modal-content">
                <div class="modal-header">
                	<button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
                	<h4 class="modal-title" id="myModalLabel">계정설정</h4>
                </div>
                <div class="modal-body">
                	<form name="formJoin" class="modify-form">
                    	<input type="email" name="uid" id="modifyId" class="form-control" placeholder="아이디(Email)" required="" autofocus value="${login.uid}">
                        <input type="password" name="upw" id="modifyPassword" class="form-control" placeholder="비밀번호" required="">
                        <input type="text" name="unick" id="modifyNick" class="form-control" placeholder="닉네임" required="" value="${login.unick}">
                        <button type="button" id="btn-user-modify" class="btn btn-primary">수정</button>
                        <button type="button" class="btn btn-default" data-dismiss="modal">취소</button>
                    </form>
                </div>
                <div class="modal-footer">
                </div>
            </div>
        </div>
    </div>