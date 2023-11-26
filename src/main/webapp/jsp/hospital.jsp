<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="ko">
	<head>
		<meta charset="UTF-8" />
		<meta name="viewport" content="width=device-width, initial-scale=1.0" />
		<title>Hospital Description</title>
		<link rel="stylesheet" href="../css/reset.css" />
		<link rel="stylesheet" href="../css/hospital.css" />
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

			<div id="desc">
				<div class="container">
					<div class="desc-container">
						<div class="hospital-info">
							<img src="../img/maltese.jpg" />
							<div>사랑 동물 병원</div>
							<div>02 111 1111</div>
							<div>위치: 서울특별시 영등포구</div>
						</div>

						<div class="name-price">
							<div>
								<span class="name">슬개골 탈구</span>
								<span class="price">600,000원</span>
							</div>

							<div>
								<span class="name">중성화</span>
								<span class="price">100,000원</span>
							</div>
						</div>
					</div>
				</div>

				<div id="review">
					<div class="container">
						<div class="review-container">
							<div class="title">리뷰</div>

							<div class="review-content">
								<div>
									<span class="user-name">a 님</span>
									<span class="user-review">친절하고 가격이 착합니다.</span>
								</div>

								<div>
									<span class="user-name">b 님</span>
									<span class="user-review">집에서 조금 멀었는데 그래도 괜찮았어요.</span>
								</div>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
	</body>
</html>
