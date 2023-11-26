<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="ko">
	<head>
		<meta charset="UTF-8" />
		<meta name="viewport" content="width=device-width, initial-scale=1.0" />
		<title>Search Result</title>
		<link rel="stylesheet" href="<%= request.getContextPath() %>/css/reset.css" />
		<link rel="stylesheet" href="<%= request.getContextPath() %>/css/search-result.css" />
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
						<a href="<%= request.getContextPath() %>/main.jsp">
							<img class="logo" src="<%= request.getContextPath() %>/img/logo.png" alt="logo" />
						</a>

						<div class="menu">
							<a href="<%= request.getContextPath() %>/login.jsp">로그인</a>
							<a href="<%= request.getContextPath() %>/signup.jsp">회원가입</a>
							<a href="<%= request.getContextPath() %>/mypage.jsp">마이페이지</a>
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
								<a href="<%= request.getContextPath() %>/hospital.jsp">
									<img src="<%= request.getContextPath() %>/img/maltese.jpg" />
								</a>
							</div>

							<div class="hospital-desc">
								<div class="name">
									<a href="<%= request.getContextPath() %>/hospital.jsp">슬개골 탈구, 중성화 수술</a>
								</div>
								<div class="review">
									<a href="<%= request.getContextPath() %>/hospital.jsp">친절하고 가격이 착합니다.</a>
								</div>
							</div>
						</div>

						<div class="hospital-info">
							<div class="hospital-pic">
								<a href="<%= request.getContextPath() %>/hospital.jsp">
									<img src="<%= request.getContextPath() %>/img/maltese.jpg" />
								</a>
							</div>

							<div class="hospital-desc">
								<div class="name">
									<a href="<%= request.getContextPath() %>/hospital.jsp">슬개골 탈구, 건강검진</a>
								</div>
								<div class="review">
									<a href="<%= request.getContextPath() %>/hospital.jsp">덕분에 슬개골 탈구 치료를 잘 할 수 있었어요.</a>
								</div>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
	</body>
</html>
