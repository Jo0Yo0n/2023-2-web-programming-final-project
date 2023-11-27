<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="ko">
	<head>
		<meta charset="UTF-8" />
		<meta name="viewport" content="width=device-width, initial-scale=1.0" />
		<title>Sign In</title>
		<link rel="stylesheet" href="<%= request.getContextPath() %>/css/reset.css" />
		<link rel="stylesheet" href="<%= request.getContextPath() %>/css/signup.css" />
	</head>
	<body>
		<div id="wrap">
			<div id="header">
				<div class="container">
					<div class="header-container">
						<a href="<%= request.getContextPath() %>/main">
							<img class="logo" src="<%= request.getContextPath() %>/img/logo.png" alt="logo" />
						</a>

						<div class="menu">
							<a href="<%= request.getContextPath() %>/login">로그인</a>
							<a href="<%= request.getContextPath() %>/signup">회원가입</a>
							<a href="<%= request.getContextPath() %>/mypage">마이페이지</a>
						</div>
					</div>
				</div>
			</div>

			<div id="contents">
				<div class="container">
					<div class="signup-container">
						<form action="#" method="post" name="signUpForm" onsubmit="return sendit()">
							<input class="text-field" type="text" name="userNickName" placeholder="Nick Name"> 
							
							<input class="text-field" type="text" name="userEmail" placeholder="Email" />

							<input class="text-field" type="password" name="userPassword" placeholder="Password" />

							<input
								class="text-field"
								type="password"
								name="userPasswordCheck"
								placeholder="Password Again"
							/>

							<input class="submit-btn" type="submit" value="Sign Up" />
						</form>
					</div>
				</div>
			</div>
		</div>
		<script src="<%= request.getContextPath() %>/js/signup.js"></script>
	</body>
</html>
