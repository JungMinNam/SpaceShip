<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!doctype html>
<html>
<head>
	<meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>login</title>
    <link href="<c:url value="/resources/css/bootstrap.min.css" />" rel="stylesheet">
    <!-- <link href="//fonts.googleapis.com/earlyaccess/nanumgothic.css" rel="stylesheet"> -->
    <link href="<c:url value="/resources/css/style.css" />" rel="stylesheet">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
    <script src="<c:url value="/resources/js/bootstrap.min.js" />"></script>
    <script src="<c:url value="/resources/js/user.js" />"></script>
</head>

<body>
    <div class="wrap-main">
        <div class="container">
            <form class="form-signin" action="/spaceship/user/loginPost" method="post">
                <h2 style="text-align:center;"><img src="<c:url value="/resources/images/logo.png"/>"></h2>
                <input type="text" name="uid" id="inputId" class="form-control" placeholder="ID" required="" autofocus>
                <input type="password" name="upw" id="inputPassword" class="form-control" placeholder="Password" required="">
                <button id="btn-signin" class="btn btn-lg btn-primary btn-block" type="submit">로그인</button>
                <button id="btn-register" class="btn btn-lg btn-primary btn-block" type="button"  data-toggle="modal" data-target="#myModal">회원가입</button>
            </form>
        </div>
    </div>
    
    <div class="modal fade wrap-register" id="myModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
        <div class="modal-dialog">
            <div class="modal-content">
                <div class="modal-header">
                	<button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
                	<h4 class="modal-title" id="myModalLabel">회원가입</h4>
                </div>
                <div class="modal-body">
                	<form name="formJoin" id="register-form">
                    	<input type="email" name="uid" id="registerId" class="form-control" placeholder="아이디(Email)" required="" autofocus>
                        <button type="button" id="btn-duplCheck" class="btn btn-primary">중복확인</button>
                        <input type="password" name="upw" id="registerPassword" class="form-control" placeholder="비밀번호" required="">
                        <input type="password" id="registerPassword2" class="form-control" placeholder="비밀번호 확인" required="">
                        <input type="text" name="unick" id="registerNick" class="form-control" placeholder="닉네임" required="">
                        <button type="button" id="btn-join" class="btn btn-primary">가입하기</button>
                        <button type="button" class="btn btn-default" data-dismiss="modal">취소</button>
                    </form>
                </div>
                <div class="modal-footer">
                </div>
            </div>
        </div>
    </div>
</body>
</html>