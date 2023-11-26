package member.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import member.dto.LoginDto;
import member.entity.User;
import member.service.MemberService;

/**
 * Servlet implementation class LoginController
 */
@WebServlet("/login")
public class LoginController extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private final MemberService memberService = new MemberService();
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.sendRedirect(request.getContextPath()+"/jsp/login.jsp");
		RequestDispatcher dispatcher = request.getRequestDispatcher("/jsp/login.jsp");
	    dispatcher.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		LoginDto loginDto = new LoginDto(request.getParameter("userName"), request.getParameter("userPassword"));
		User user = memberService.login(loginDto).orElse(new User());
		if(user.getId() != null) {
			HttpSession session = request.getSession();
			// 로그인에 성공했다면 세션에 유저 아이디를 저장.
			session.setAttribute("userId", user.getId());
			response.sendRedirect(request.getContextPath()+"/main?login=true");
		} else {
			response.sendRedirect(request.getContextPath()+"/login?login=false");
		}
	}

}
