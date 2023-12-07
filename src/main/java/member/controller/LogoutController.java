package member.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class LogoutController
 */
@WebServlet("/logout")
public class LogoutController extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public LogoutController() {
        super();
        // TODO Auto-generated constructor stub
    }
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession(false);
		if(session != null) {
			session.removeAttribute("userId");
			Cookie[] cookies = request.getCookies();
		    if (cookies != null) {
		        for (Cookie cookie : cookies) {
		            if (cookie.getName().equals("JSESSIONID") || cookie.getName().equals("userNickName")) {
		                cookie.setMaxAge(0); // 쿠키 유효기간을 0으로 설정하여 삭제
		                cookie.setPath("/"); // 쿠키의 경로
		                response.addCookie(cookie); // 응답에 쿠키를 추가하여 삭제
		            }
		        }
		    }
		}
		response.sendRedirect(request.getContextPath()+"/main");

	}

    


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession(false);
		if(session != null) {
			session.removeAttribute("userId");
			Cookie[] cookies = request.getCookies();
		    if (cookies != null) {
		        for (Cookie cookie : cookies) {
		            if (cookie.getName().equals("JSESSIONID") || cookie.getName().equals("userNickName")) {
		                cookie.setMaxAge(0); // 쿠키 유효기간을 0으로 설정하여 삭제
		                cookie.setPath("/"); // 쿠키의 경로
		                response.addCookie(cookie); // 응답에 쿠키를 추가하여 삭제
		            }
		        }
		    }
		    response.sendRedirect(request.getContextPath()+"/main");
		}
	}
}
