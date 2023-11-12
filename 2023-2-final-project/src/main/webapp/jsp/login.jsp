<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="ko">
	<head>
		<meta charset="UTF-8" />
		<meta name="viewport" content="width=device-width, initial-scale=1.0" />
		<title>Login</title>
		<link rel="stylesheet" href="../css/reset.css" />
		<link rel="stylesheet" href="../css/login.css" />
	</head>
	<body>
		<div id="wrap">
			<div id="header">
				<div class="container">
					<div class="header-container">
						<a href="./main.jsp">
							<img class="logo" src="../img/logo.png" alt="logo" />
						</a>

						<div class="menu">
							<a href="./login.jsp">로그인</a>
							<a href="./signup.jsp">회원가입</a>
							<a href="./mypage.jsp">마이페이지</a>
						</div>
					</div>
				</div>
			</div>

			<div id="contents">
				<div class="container">
					<div class="login-container">
						<form action="#" method="post">
							<input class="text-field" type="text" name="userName" placeholder="Email" />
							<input class="text-field" type="password" name="userPassword" placeholder="Password" />
							<input class="submit-btn" type="submit" value="Login" />
						</form>
					</div>
				</div>
			</div>
		</div>
	</body>
</html>
