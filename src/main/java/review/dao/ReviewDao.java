package review.dao;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import jdbcUtil.DaoTemplate;
import review.entity.Review;
import review.dto.ReviewDto;

public class ReviewDao extends DaoTemplate<Review>{

	public Long insertReview(Review review) throws SQLException {
        String sql = "INSERT INTO review (reviewId, userId, hospitalId, content) VALUES (?, ?, ?, ?)";
        return insert(sql, review, review.getUserId(), review.getHospitalId(), review.getContent());
    }
	
	public List<ReviewDto> getReviewDtoByHospitalId(Long hospitalId){
		String sql = "SELECT user.userId, user.nickName, review.content FROM review JOIN user ON review.userId = user.userId WHERE review.hospitalId = ?";
		try {
			return joinQueryForList(sql, rs -> {
			    return new ReviewDto(
				        rs.getLong("userId"),
				        rs.getString("nickName"),
				        rs.getString("content")
				    );
			}, hospitalId);
		} catch (SQLException e) {
			e.printStackTrace();
			return new ArrayList<ReviewDto>();
		}
	}
	
}
