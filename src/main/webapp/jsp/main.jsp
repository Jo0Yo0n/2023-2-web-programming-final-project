<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.List" %>
<%@ page import="java.util.Collections" %>
<%@ page import="hospital.entity.Hospital" %>
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
						<form action="<%= request.getContextPath() %>/search" id="search-form" method="get">
							<input class="search" type="text" name="keyword" placeholder="검색어 입력" />
							<input class="submit" type="submit" value="검색"/>
						</form>
					</div>
				</div>
			</div>

			<div id="nav">
				<div class="container">
					<div class="nav-container">
						<a href="<%= request.getContextPath() %>/search?keyword=건강검진" class="link1">건강검진</a>
						<a href="<%= request.getContextPath() %>/search?keyword=예방접종" class="link2">예방접종</a>
						<a href="<%= request.getContextPath() %>/search?keyword=중성화" class="link3">중성화</a>
						<a href="<%= request.getContextPath() %>/search?keyword=슬개골 탈구" class="link4">슬개골 탈구</a>
					</div>
				</div>
			</div>

			
			<div id="contents">
				<div class="container">
					<div class="contents-container">
                    	<%                   
                        Object attribute = request.getAttribute("hospitals");
                        if (attribute instanceof List) {
	                    	List<Hospital> hospitals = (List<Hospital>) attribute;
    	               		Collections.shuffle(hospitals);	// 매번 다른 순서
        	                int numberOfHospitalsToShow = 6;	//6개의 병원만 표시
            	            for (int i = 0; i < Math.min(numberOfHospitalsToShow, hospitals.size()); i++) { 
                	            Hospital hospital = hospitals.get(i);
                    	%>
                    	<div class="cont">
                        	<a href="<%= request.getContextPath() %>/hospital?hospitalId=<%= hospital.getId() %>">
                            	<img src="<%= request.getContextPath() %>/img/<%= hospital.getHosPic() %>" alt="<%= hospital.getHospitalName() %>" />
                            	<div class="desc"><%= hospital.getHospitalName() %></div>
                        	</a>
                    	</div> 
                    	<% 
                        	}
                      	}
                    	%>                 	                   
					</div>
				</div>
			</div>
		</div>
	</body>
</html>

