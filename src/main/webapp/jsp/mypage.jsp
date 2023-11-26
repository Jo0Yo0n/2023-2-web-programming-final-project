<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="ko">
	<head>
		<meta charset="UTF-8" />
		<meta name="viewport" content="width=device-width, initial-scale=1.0" />
		<title>My Page</title>
		<link rel="stylesheet" href="../css/reset.css" />
		<link rel="stylesheet" href="../css/mypage.css" />
		<!-- 폰트 -->
		<link rel="preconnect" href="https://fonts.googleapis.com" />
		<link rel="preconnect" href="https://fonts.gstatic.com" crossorigin />
		<link href="https://fonts.googleapis.com/css2?family=Nanum+Gothic&display=swap" rel="stylesheet" />
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

				<div id="contents">
					<div class="container">
						<div class="contents-container">
							<div class="user-name">
								<h1>{회원이름}님</h1>
							</div>

							<div class="list">
								<a href="#">
									<div>작성한 리뷰</div>
								</a>

								<a href="#">
									<div>찜한 병원</div>
								</a>

								<a href="#">
									<div>로그아웃</div>
								</a>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
	</body>
</html>
