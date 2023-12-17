<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.util.List" %>
<%@ page import="review.dto.MyReviewDto" %>

<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <title>My Review</title>
    <link rel="stylesheet" href="<%= request.getContextPath() %>/css/reset.css" />
    <link rel="stylesheet" href="<%= request.getContextPath() %>/css/myReview.css" />
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
                <a href="<%= request.getContextPath() %>/">
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

    <div id="reviews">
        <div class="container">
            <div class="review-container">
                <!-- 사용자의 리뷰 목록을 동적으로 추가 -->
                <%
                    List<MyReviewDto> reviews = (List<MyReviewDto>) request.getAttribute("reviews");

                    if (reviews != null && !reviews.isEmpty()) {
                        for (MyReviewDto review : reviews) {
                %>
                            <div class="hospital-info">
                                <div class="hospital-pic">
                                    <a href="<%= request.getContextPath() %>/hospital?hospitalId=<%= review.getHospitalId() %>">
                                        <img src="<%= request.getContextPath() %>/img/<%= review.getHosPic() %>" />
                                    </a>
                                </div>

                                <div class="hospital-desc">
                                    <div class="name">
                                        <a href="<%= request.getContextPath() %>/hospital?hospitalId=<%= review.getHospitalId() %>">
                                            <%= review.getHosName() %>
                                        </a>
                                    </div>
                                    <div class="review">
                                        <%= review.getReviewContent() %>
                                    </div>
                                </div>
                            </div>
                <%
                        }
                    } else {
                %>
                        <div class="no-review">
                            <span>리뷰가 없습니다.</span>
                        </div>
                <%
                    }
                %>
            </div>
        </div>
    </div>
</div>
</body>
</html>
