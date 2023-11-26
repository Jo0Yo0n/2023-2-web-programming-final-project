package member.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import member.dto.SignUpDto;
import member.service.MemberService;

/**
 * Servlet implementation class SignUpController
 */
@WebServlet("/signup")
public class SignUpController extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private final MemberService memberService = new MemberService();

    /**
     * @see HttpServlet#HttpServlet()
     */
    public SignUpController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.sendRedirect(request.getContextPath()+"/login");
		RequestDispatcher dispatcher = request.getRequestDispatcher("/jsp/signup.jsp");
	    dispatcher.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		SignUpDto signUpDto = new SignUpDto(request.getParameter("userNickName"), request.getParameter("userEmail"), request.getParameter("userPassword"));
		// 회원가입 시도 
		if(memberService.signUp(signUpDto)) {
			// 회원가입 성공하면 성공했다는 팝업 + 로그인 페이지로 이동 
			response.sendRedirect(request.getContextPath()+"/login?signUp=true");
		} else {
			// 회원가입 실패하면 실패했다는 팝업 + 회원가입 페이지로 돌아감.
			response.sendRedirect(request.getContextPath()+"/signup?signUp=false");
		}
		
	}

}
