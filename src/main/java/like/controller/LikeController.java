package like.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import like.entity.Like;
import like.service.LikeService;

/**
 * Servlet implementation class LikeController
 */
@WebServlet("/like")
public class LikeController extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private final LikeService likeService = new LikeService();
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LikeController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Long userId = Long.parseLong(request.getParameter("userId"));
		Long hospitalId = Long.parseLong(request.getParameter("hospitalId"));
		likeService.updateLike(userId, hospitalId);
		List<Like> likes = likeService.getLikesByHospitalId(hospitalId);
		request.setAttribute("likes", likes);
	}

}
