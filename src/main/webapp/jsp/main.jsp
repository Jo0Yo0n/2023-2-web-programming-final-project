<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="ko">
	<head>
		<meta charset="UTF-8" />
		<meta name="viewport" content="width=device-width, initial-scale=1.0" />
		<title>Main Page</title>
		<link rel="stylesheet" href="<%= request.getContextPath() %>/css/reset.css" />
		<link rel="stylesheet" href="<%= request.getContextPath() %>/css/main.css" />
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
						<a href="<%= request.getContextPath() %>/main">
							<img class="logo" src="<%= request.getContextPath() %>/img/logo.png" alt="logo" />
						</a>
						
						<%-- 세션에 userId가 있으면 로그인 상태라고 가정 --%>
						<% if(session.getAttribute("userId") != null) { %>
						<div class="menu">
							<a href="<%= request.getContextPath() %>/logout">로그아웃</a>
							<a href="<%= request.getContextPath() %>/mypage">마이페이지</a>
						</div>
						<% } else { %>
						
						<div class="menu">
							<a href="<%= request.getContextPath() %>/login">로그인</a>
							<a href="<%= request.getContextPath() %>/signup">회원가입</a>
						</div>
						<% } %>
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

			<div id="nav">
				<div class="container">
					<div class="nav-container">
						<a href="#" class="link1">건강검진</a>
						<a href="#" class="link2">예방접종</a>
						<a href="#" class="link3">중성화 수술</a>
						<a href="#" class="link4">슬개골 탈구</a>
					</div>
				</div>
			</div>

			<div id="contents">
				<div class="container">
					<div class="contents-container">
						<div class="cont cont1">
							<a href="<%= request.getContextPath() %>/hospital?hospitalId=1">
								<img src="<%= request.getContextPath() %>/img/maltese.jpg" alt="maltese" />
								<div class="desc">사랑 동물병원</div>
							</a>
						</div>

						<div class="cont cont2">
							<a href="<%= request.getContextPath() %>/hospital?hospitalId=2">
								<img src="<%= request.getContextPath() %>/img/poodle.jpg" alt="poodle" />
								<div class="desc">희망 동물병원</div>
							</a>
						</div>

						<div class="cont cont3">
							<a href="<%= request.getContextPath() %>/hospital?hospitalId=3">
								<img src="<%= request.getContextPath() %>/img/shiba.jpg" alt="shiba" />
								<div class="desc">평화 동물병원</div>
							</a>
						</div>

						<div class="cont cont4">
							<a href="<%= request.getContextPath() %>/hospital?hospitalId=4">
								<img src="<%= request.getContextPath() %>/img/maltese.jpg" alt="maltese" />
								<div class="desc">자유 동물병원</div>
							</a>
						</div>

						<div class="cont cont5">
							<a href="<%= request.getContextPath() %>/hospital?hospitalId=5">
								<img src="<%= request.getContextPath() %>/img/poodle.jpg" alt="poodle" />
								<div class="desc">평등 동물병원</div>
							</a>
						</div>

						<div class="cont cont6">
							<a href="<%= request.getContextPath() %>/hospital?hospitalId=6">
								<img src="<%= request.getContextPath() %>/img/shiba.jpg" alt="shiba" />
								<div class="desc">박애 동물병원</div>
							</a>
						</div>
					</div>
				</div>
			</div>
		</div>
	</body>
</html>

