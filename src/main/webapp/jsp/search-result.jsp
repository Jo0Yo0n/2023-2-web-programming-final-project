<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="ko">
	<head>
		<meta charset="UTF-8" />
		<meta name="viewport" content="width=device-width, initial-scale=1.0" />
		<title>Search Result</title>
		<link rel="stylesheet" href="../css/reset.css" />
		<link rel="stylesheet" href="../css/search-result.css" />
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
			</div>

			<div id="search">
				<div class="container">
					<div class="search-container">
						<form action="#" method="get">
							<input class="search" type="text" name="search" placeholder="검색어 입력" />
							<input class="submit" type="submit" value="검색" />
						</form>
					</div>
				</div>
			</div>

			<div id="contents">
				<div class="container">
					<div class="contents-container">
						<div class="hospital-info">
							<div class="hospital-pic">
								<a href="./hospital.jsp">
									<img src="../img/maltese.jpg" />
								</a>
							</div>

							<div class="hospital-desc">
								<div class="name">
									<a href="./hospital.jsp">슬개골 탈구, 중성화 수술</a>
								</div>
								<div class="review">
									<a href="./hospital.jsp">친절하고 가격이 착합니다.</a>
								</div>
							</div>
						</div>

						<div class="hospital-info">
							<div class="hospital-pic">
								<a href="./hospital.jsp">
									<img src="../img/maltese.jpg" />
								</a>
							</div>

							<div class="hospital-desc">
								<div class="name">
									<a href="./hospital.jsp">슬개골 탈구, 건강검진</a>
								</div>
								<div class="review">
									<a href="./hospital.jsp">덕분에 슬개골 탈구 치료를 잘 할 수 있었어요.</a>
								</div>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
	</body>
</html>
