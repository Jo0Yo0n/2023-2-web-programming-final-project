package review.service;

import java.util.List;

import review.dao.ReviewDao;
import review.dto.MyReviewDto;
import review.dto.ReviewDto;

public class ReviewService {
	private final ReviewDao reviewDao = new ReviewDao();
	public List<ReviewDto> getReviewByHospitalId(Long hospitalId){
		return reviewDao.getReviewDtoByHospitalId(hospitalId);
	}
	public List<MyReviewDto> getReviewsByUserId(Long userId){
		return reviewDao.getMyReviewsByUserId(userId);
	}
}
