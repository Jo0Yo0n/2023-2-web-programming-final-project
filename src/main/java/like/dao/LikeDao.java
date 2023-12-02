package like.dao;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import jdbcUtil.DaoTemplate;
import like.entity.Like;
import review.dto.ReviewDto;

public class LikeDao extends DaoTemplate<Like> {

	public Like insertLike(Like like) {
		// like ID 가 없기 때문에 다른 것들과 insert 가 조금 다름.
        String sql = "INSERT INTO likeTbl (userId, hospitalId) VALUES (?, ?)";
        try (
        	PreparedStatement ps = connection.prepareStatement(sql)) {
            // 인자 바인딩
            
            ps.setObject(0, like.getUserId());
            ps.setObject(1, like.getHospitalId());
            
            ps.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return like;
	}
	
	public List<Like> getLikesByHospitalId(Long hospitalId) {
		String sql = "SELECT * FROM likeTbl WHERE hospitalId = ?";
		try {
			return queryForList(sql, rs -> {
			    return new Like(
				        rs.getLong("userId"),
				        rs.getLong("hospitalId")
				    );
			}, hospitalId);
		} catch (SQLException e) {
			e.printStackTrace();
			return new ArrayList<Like>();
		}
	}
	
	public List<Like> getLikesByUserId(Long userId) {
		String sql = "SELECT * FROM likeTbl WHERE userId = ?";
		try {
			return queryForList(sql, rs -> {
			    return new Like(
				        rs.getLong("userId"),
				        rs.getLong("hospitalId")
				    );
			}, userId);
		} catch (SQLException e) {
			e.printStackTrace();
			return new ArrayList<Like>();
		}
	}
}
