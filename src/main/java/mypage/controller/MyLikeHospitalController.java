package mypage.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import hospital.entity.Hospital;
import hospital.service.HospitalService;
import like.entity.Like;
import like.service.LikeService;

/**
 * Servlet implementation class MyLikeHospitalController
 */
@WebServlet("/mypage/likes")
public class MyLikeHospitalController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private final LikeService likeService = new LikeService();
	private final HospitalService hospitalService = new HospitalService();

    /**
     * @see HttpServlet#HttpServlet()
     */
    public MyLikeHospitalController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Long userId = Long.parseLong(request.getParameter("userId"));
		List<Like> likes = likeService.getLikesByUserId(userId);
		List<Hospital> hospitals = new ArrayList<Hospital>();
		for(Like like: likes) {
			hospitals.add(hospitalService.getHospitalById(like.getHospitalId()));
		}
		request.setAttribute("hospitals", hospitals);
		RequestDispatcher dispatcher = request.getRequestDispatcher("/jsp/myLikes.jsp");
	    dispatcher.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
