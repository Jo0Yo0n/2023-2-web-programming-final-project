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
		ReviewDto newReview = (ReviewDto)request.getAttribute("newReview");
		boolean result = reviewService.createNewReview(newReview);
		String returnPath = request.getContextPath()+"/hospital?hospitalId="+newReview.getHospitalId();
		if(result == true) {
			returnPath += "&review=true";
		}else {
			returnPath += "&review=false";
		}
		response.sendRedirect(returnPath);

	}

}
