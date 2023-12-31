package hospital.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import department.entity.Department;
import department.service.DepartmentService;
import hospital.entity.Hospital;
import hospital.service.HospitalService;
import like.entity.Like;
import like.service.LikeService;
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
	private final LikeService likeService = new LikeService();
	private final DepartmentService departmentService = new DepartmentService();
       
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
		boolean isLike = false;
		
		// hospital data
		Long hospitalId = Long.parseLong(request.getParameter("hospitalId"));
		Hospital hospital = hospitalService.getHospitalById(hospitalId);
		request.setAttribute("hospital", hospital);
		// review
		List<ReviewDto> reviewDtos = reviewService.getReviewByHospitalId(hospitalId);
		request.setAttribute("reviews", reviewDtos);
		// likes
		List<Like> likes = likeService.getLikesByHospitalId(hospitalId);
		request.setAttribute("likes", likes);
		// department
		List<Department> departments = departmentService.getDepartmentByHospitalId(hospitalId);
		request.setAttribute("departments", departments);
		try {
			HttpSession session = request.getSession(false);
			if(session.getAttribute("userId") != null) {
				Long sessionUserId = (Long) session.getAttribute("userId");
				for(Like like: likes) {
					if(like.getUserId().equals(sessionUserId)) {
						isLike = true;
						break;
					}
				}
			}
		} catch (Exception e) {
			isLike = false;
		}
		request.setAttribute("isLike", isLike);
		
		//List<Hospital> hospitals = hospitalService.getMainHospital();
	    dispatcher.forward(request, response);
	}


}
