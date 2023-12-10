package review.dao;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import jdbcUtil.DaoTemplate;
import review.entity.Review;
import review.dto.MyReviewDto;
import review.dto.ReviewDto;

public class ReviewDao extends DaoTemplate<Review>{

	public Long insertReview(Review review) throws SQLException {
        String sql = "INSERT INTO review (userId, hospitalId, content) VALUES (?, ?, ?)";
        return insert(sql, review, review.getUserId(), review.getHospitalId(), review.getContent());
    }
	
	public List<ReviewDto> getReviewDtoByHospitalId(Long hospitalId){
		String sql = "SELECT user.userId, user.nickName, review.content FROM review JOIN user ON review.userId = user.userId WHERE review.hospitalId = ?";
		try {
			return joinQueryForList(sql, rs -> {
			    return new ReviewDto(
				        rs.getLong("userId"),
				        hospitalId,
				        rs.getString("nickName"),
				        rs.getString("content")
				    );
			}, hospitalId);
		} catch (SQLException e) {
			e.printStackTrace();
			return new ArrayList<ReviewDto>();
		}
	}
	public List<MyReviewDto> getMyReviewsByUserId(Long userId){
		String sql = "SELECT hospital.hospitalId, hospital.tel, hospital.address, hospital.hosName, hospital.hosPic, review.content, review.reviewId FROM review JOIN hospital ON review.userId = ? AND hospital.hospitalId = review.hospitalId";
		try {
			return joinQueryForList(sql, rs -> {
			    return new MyReviewDto(
				        rs.getLong("hospitalId"),
				        rs.getLong("reviewId"),
				        rs.getString("hosName"),
				        rs.getString("tel"),
				        rs.getString("address"),
				        rs.getString("hosPic"),
				        rs.getString("content")
				    );
			}, userId);
		} catch (SQLException e) {
			e.printStackTrace();
			return new ArrayList<MyReviewDto>();
		}
	}
}
