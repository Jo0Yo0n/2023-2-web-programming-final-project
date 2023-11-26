package hospital.dao;

import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

import hospital.entity.Hospital;
import jdbcUtil.DaoTemplate;
import member.entity.User;

public class HospitalDao extends DaoTemplate<Hospital> {
	public Long insertUser(Hospital hos) throws SQLException {
        String sql = "INSERT INTO hospital (hospitalId, tel, address, hosName, hosPic) VALUES (?, ?, ?, ?, ?)";
        return insert(sql, hos, hos.getHospitalId(), hos.getTel(), hos.getAddress(), hos.getHospitalName(), hos.getHosPic());
    }
	
	public Optional<Hospital> getHospitalById(Long hospitalId) throws SQLException {
        String sql = "SELECT * FROM hospital WHERE hospitalId = ?";
        return queryForObject(sql, rs -> {
            try {
				if (rs.next()) {
				    return Optional.of(new Hospital(
				        rs.getLong("hospitalId"),
				        rs.getString("tel"),
				        rs.getString("address"),
				        rs.getString("hosName"),
				        rs.getString("hosPic")
				    ));
				}else {
					return Optional.empty(); // 해당하는 row가 없으면 Optional.empty() 반환
				}
			} catch (SQLException e) {
				return Optional.empty(); // 에러가 발생했을 때 Optional.empty() 반환
			}
        }, hospitalId);
    }
	
	public List<Hospital> getAllHospital() throws SQLException {
        // DaoTemplate에서 구현된 queryForList 메서드를 사용하여 모든 사용자를 가져오는 쿼리를 실행할 수 있다.
        return queryForList("SELECT * FROM user", rs -> {
            return new Hospital(
			        rs.getLong("hospitalId"),
			        rs.getString("tel"),
			        rs.getString("address"),
			        rs.getString("hosName"),
			        rs.getString("hosPic")
			    );
        });
    }
	
	
	
	
}
