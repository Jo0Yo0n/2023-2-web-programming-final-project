<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.util.List" %>
<%@ page import="hospital.entity.Hospital" %>

<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <title>My Likes</title>
    <link rel="stylesheet" href="<%= request.getContextPath() %>/css/reset.css" />
    <link rel="stylesheet" href="<%= request.getContextPath() %>/css/myLikes.css" />
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

    <div id="likes">
        <div class="container">
            <div class="like-container">
                <!-- 사용자가 좋아요한 병원 목록을 동적으로 추가 -->
                <%
                    List<Hospital> hospitals = (List<Hospital>) request.getAttribute("hospitals");

                    if (hospitals != null && !hospitals.isEmpty()) {
                        for (Hospital hospital : hospitals) {
                %>
                <div class="hospital-info">
                    <div class="hospital-pic">
                        <a href="<%= request.getContextPath() %>/hospital?hospitalId=<%= hospital.getHospitalId() %>">
                            <img src="<%= request.getContextPath() %>/img/<%= hospital.getHosPic() %>" />
                        </a>
                    </div>

                    <div class="hospital-desc">
                        <div class="name">
                            <a href="<%= request.getContextPath() %>/hospital?hospitalId=<%= hospital.getHospitalId() %>">
                                <%= hospital.getHospitalName() %>
                            </a>
                        </div>
                        <!-- 추가적인 정보 표시 -->
                    </div>
                </div>
                <%
                    }
                } else {
                %>
                <div class="no-like">
                    <span>좋아요한 병원이 없습니다.</span>
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
