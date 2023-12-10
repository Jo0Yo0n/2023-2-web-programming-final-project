<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="hospital.entity.Hospital" %>
<%@ page import="review.dto.ReviewDto" %>
<%@ page import="department.entity.Department" %>
<%@ page import="java.util.List" %>
<!DOCTYPE html>
<html lang="ko">
	<head>
		<meta charset="UTF-8" />
		<meta name="viewport" content="width=device-width, initial-scale=1.0" />
		<title>Hospital Description</title>
		<link rel="stylesheet" href="<%= request.getContextPath() %>/css/reset.css" />
		<link rel="stylesheet" href="<%= request.getContextPath() %>/css/hospital.css" />
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
			<% 
			Hospital hospital = (Hospital) request.getAttribute("hospital"); 
			List<ReviewDto> reviews = (List<ReviewDto>) request.getAttribute("reviews");
			
			//departments 변수 가져오기
			List<Department> departments = (List<Department>)request.getAttribute("departments");
			 %>
			<div id="desc">
				<div class="container">
					<div class="desc-container">
						<div class="hospital-info">
							<img src="<%= request.getContextPath() %>/img/<%= hospital.getHosPic() %>" />
							<div><%= hospital.getHospitalName() %></div>
							<div><%= hospital.getTel() %></div>
							<div><%= hospital.getAddress() %></div>
						</div>

						<div class="name-price">
						<% if(departments != null && !departments.isEmpty()) { %>
							<%
								for (Department department : departments) {
									String departmentName = department.getdepartmentName();
									Integer departmentPrice = department.getPrice();
							%>
							<div>
								<span class="name"><%= departmentName %> : </span>
								<span class="price"><%= departmentPrice %>원</span>
							</div>
							<%
								}
							%>
						<% } else { %>
							<div class="no-departments">
								<span>진료 과목이 없습니다.</span>
							</div>
						<% } %>
						</div>
					</div>
				</div>
				
				<div class="middle">
					<svg class="like" xmlns="http://www.w3.org/2000/svg" height="1em" viewBox="0 0 512 512">
						<path
							d="M47.6 300.4L228.3 469.1c7.5 7 17.4 10.9 27.7 10.9s20.2-3.9 27.7-10.9L464.4 300.4c30.4-28.3 47.6-68 47.6-109.5v-5.8c0-69.9-50.5-129.5-119.4-141C347 36.5 300.6 51.4 268 84L256 96 244 84c-32.6-32.6-79-47.5-124.6-39.9C50.5 55.6 0 115.2 0 185.1v5.8c0 41.5 17.2 81.2 47.6 109.5z"
						/>
					</svg>
				</div>

				<div id="review">
					<div class="container">
						<div class="review-container">
							<div class="title">리뷰</div>

							<div class="review-content">
								<%
								if (reviews != null && !reviews.isEmpty()){
									for(ReviewDto review : reviews){
								%>
									<div>
										<span class="user-name"><%= review.getUserNickName() %>님</span>
										<span class="user-review"><%= review.getContent() %></span>
									</div>
								<%
									}
								} else {
								%>
									<div>
										<span>리뷰가 없습니다.</span>
									</div>
								<%
								}
								%>
							</div>
						</div>
						
						<%-- 로그인된 경우에만 리뷰 작성 폼을 표시 --%>
						<% if(session.getAttribute("userId") != null) { %>
						<div id="review-form">
							<form action="<%= request.getContextPath() %>/review/create" method="post">
								<textarea name="content" rows="4" placeholder="리뷰를 작성해주세요"></textarea>
								<input type="hidden" name="userId" value="<%= session.getAttribute("userId") %>" />
								<input type="hidden" name="hospitalId" value="<%= hospital.getHospitalId() %>" />
								<input type="hidden" name="userNickName" value="<%= session.getAttribute("userNickName") %>" />
								<input type="submit" value="리뷰 작성" />
							</form>
						</div>
						<% } %>
					</div>
				</div>
			</div>
		</div>
		<script src="<%= request.getContextPath() %>/js/hospital.js"></script>
	</body>
</html>
