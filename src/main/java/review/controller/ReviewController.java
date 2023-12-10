package review.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import review.dto.ReviewDto;
import review.service.ReviewService;

/**
 * Servlet implementation class ReviewController
 */
@WebServlet("/review/create")
public class ReviewController extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private final ReviewService reviewService = new ReviewService();
    public ReviewController() {
        super();
        // TODO Auto-generated constructor stub
    }


	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");

		Long userId = Long.parseLong(request.getParameter("userId"));
		Long hospitalId = Long.parseLong(request.getParameter("hospitalId"));
		String userNickName = request.getParameter("userNickName");
		String content = request.getParameter("content");

		ReviewDto newReview = new ReviewDto(userId, hospitalId, userNickName, content);

		boolean result = reviewService.createNewReview(newReview);

		String returnPath = request.getContextPath()+"/hospital?hospitalId="+newReview.getHospitalId();
		if(result) {
			returnPath += "&review=true";
		}else {
			returnPath += "&review=false";
		}
		response.sendRedirect(returnPath);

	}

}
