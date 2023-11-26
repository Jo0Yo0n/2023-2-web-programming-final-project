package test;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class UserController
 */
@WebServlet("/UserController")
public class UserController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private final UserService userService;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UserController() {
        super();
        userService = new UserService();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// URI를 가져옴
        String uri = request.getRequestURI();
        
        // URI에 따라 작업 수행
        if (uri.endsWith("/create")) {
        	userService.createUser(new UserDto(~~));
        }
        else if (uri.endsWith("/read")) {
            // /myServlet/action1에 대한 처리
            response.getWriter().write("Action 1 performed");
        } else if (uri.endsWith("/update")) {
            // /myServlet/action2에 대한 처리
            response.getWriter().write("Action 2 performed");
        } else if (uri.endsWith("/delete")){
        	
        }
        else {
            // 지원하지 않는 URI에 대한 처리
            response.getWriter().write("Unsupported action");
        }		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
