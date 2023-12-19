<%@ page import="search.dto.SearchDto" %>
<%@ page import="java.util.List" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html lang="ko">
<head>
    <meta charset="UTF-8"/>
    <meta name="viewport" content="width=device-width, initial-scale=1.0"/>
    <title>Search Result</title>
    <link rel="stylesheet" href="<%= request.getContextPath() %>/css/reset.css"/>
    <link rel="stylesheet" href="<%= request.getContextPath() %>/css/search-result.css"/>
    <!-- 폰트 -->
    <link rel="preconnect" href="https://fonts.googleapis.com"/>
    <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin/>
    <link href="https://fonts.googleapis.com/css2?family=Nanum+Gothic&display=swap" rel="stylesheet"/>
</head>
<body>
<div id="wrap">
    <div id="header">
        <div class="container">
            <div class="header-container">
                <a href="<%= request.getContextPath() %>/main">
                    <img class="logo" src="<%= request.getContextPath() %>/img/logo.png" alt="logo"/>
                </a>

                <%-- 세션에 userId가 있으면 로그인 상태라고 가정 --%>
                <% if (session.getAttribute("userId") != null) { %>
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
                    <input class="search" type="text" name="keyword" value="<%= request.getParameter("keyword") %>"
                           placeholder="검색어 입력"/>
                    <input class="submit" type="submit" value="검색"/>
                </form>
            </div>
        </div>
    </div>

    <div id="contents">
        <div class="container">
            <div class="contents-container">
                <!-- 검색 결과를 동적으로 출력 -->
                <% List<SearchDto> searchResult = (List<SearchDto>) request.getAttribute("searchResult"); %>

                <% if (searchResult != null && !searchResult.isEmpty()) { %>
                <h2 class="search-result"><%= request.getParameter("keyword")%>에 대한 검색 결과</h2>
                <% for (SearchDto result : searchResult) { %>
                <div class="hospital-info">
                    <a href="<%=request.getContextPath()%>/hospital?hospitalId=<%= result.getHospital().getHospitalId()%>">
                        <div class="hospital-pic">
                            <img src="<%= request.getContextPath() %>/img/<%= result.getHospital().getHosPic() %>"
                                 alt="<%= result.getHospital().getHospitalName() %>"/>
                        </div>
                        <div class="hospital-name"><%=result.getHospital().getHospitalName()%></div>
                        <div class="location"><%=result.getHospital().getAddress()%></div>
                        <div class="department price"><%=result.getDepartmentName() %> : <%=result.getPrice()%></div>
                    </a>
                </div>
                <% } %>
                <% } else { %>
                <h2 class="no-result">검색 결과가 없습니다.</h2>
                <% } %>
            </div>
        </div>
    </div>
</div>
</body>
</html>