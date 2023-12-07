package review.service;

import java.sql.SQLException;
import java.util.List;

import review.dao.ReviewDao;
import review.dto.MyReviewDto;
import review.dto.ReviewDto;
import review.entity.Review;

public class ReviewService {
	private final ReviewDao reviewDao = new ReviewDao();
	public List<ReviewDto> getReviewByHospitalId(Long hospitalId){
		return reviewDao.getReviewDtoByHospitalId(hospitalId);
	}
	public List<MyReviewDto> getReviewsByUserId(Long userId){
		return reviewDao.getMyReviewsByUserId(userId);
	}
	public boolean createNewReview(ReviewDto reviewDto) {
		try {
			reviewDao.insertReview(new Review(reviewDto));
			return true;
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
	}
}
