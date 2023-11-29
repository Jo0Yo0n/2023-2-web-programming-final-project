package hospital.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import hospital.entity.Hospital;
import hospital.service.HospitalService;
import review.dto.ReviewDto;
import review.service.ReviewService;

/**
 * Servlet implementation class HospitalController
 */
@WebServlet("/hospital")
public class HospitalController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private final HospitalService hospitalService = new HospitalService();
	private final ReviewService reviewService = new ReviewService();
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public HospitalController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher dispatcher = request.getRequestDispatcher("/jsp/hospital.jsp");
		
		// hospital data
		Long hospitalId = Long.parseLong(request.getParameter("hospitalId"));
		Hospital hospital = hospitalService.getHospitalById(hospitalId);
		request.setAttribute("hospital", hospital);
		
		// review
		List<ReviewDto> reviewDtos = reviewService.getReviewByHospitalId(hospitalId);
		request.setAttribute("hospital", hospital);

		System.out.println(reviewDtos.get(0));
		
		//List<Hospital> hospitals = hospitalService.getMainHospital();
	    dispatcher.forward(request, response);
	}


}
