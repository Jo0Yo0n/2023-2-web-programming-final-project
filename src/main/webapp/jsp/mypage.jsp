<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="ko">
	<head>
		<meta charset="UTF-8" />
		<meta name="viewport" content="width=device-width, initial-scale=1.0" />
		<title>My Page</title>
		<link rel="stylesheet" href="<%= request.getContextPath() %>/css/reset.css" />
		<link rel="stylesheet" href="<%= request.getContextPath() %>/css/mypage.css" />
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

				<div id="contents">
					<div class="container">
						<div class="contents-container">
							<div class="user-name">

								<h1><%= session.getAttribute("userNickName") %>님</h1>
							</div>

							<div class="list">
								<a href="<%= request.getContextPath() %>/mypage/myReview?userId=<%=session.getAttribute("userId") %>">
									<div>작성한 리뷰</div>
								</a>

								<a href="<%= request.getContextPath() %>/mypage/likes?userId=<%=session.getAttribute("userId") %>">
									<div>찜한 병원</div>
								</a>

								<a href="<%= request.getContextPath() %>/logout">
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
