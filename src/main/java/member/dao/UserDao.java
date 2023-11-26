package member.dao;

import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

import jdbcUtil.DaoTemplate;
import member.entity.User;
/**
 * DaoTemplate을 상속받고 사용할 객체를 제네릭을 이용해 입력
 */
public class UserDao extends DaoTemplate<User> {
	
	public Long insertUser(User user) throws SQLException {
        String sql = "INSERT INTO user (nickName, email, password) VALUES (?, ?, ?)";
        return insert(sql, user, user.getNickName(), user.getEmail(), user.getPassword());
    }
    
    public Long deleteUser(Long userId) throws SQLException {
        String sql = "DELETE FROM user WHERE userId = ?";
        return delete(sql, userId);
    }
    
    /**
     * 내부에 queryForObject 메소드의 mapper.apply 에 의해 호출될 람다 함수를 작성해야함.
     * @param userId
     * @return
     * @throws SQLException
     */
    public Optional<User> getUserById(Long userId) throws SQLException {
        String sql = "SELECT * FROM user WHERE userId = ?";
        return queryForObject(sql, rs -> {
            try {
				if (rs.next()) {
				    return Optional.of(new User(
				        rs.getLong("userId"),
				        rs.getString("nickName"),
				        rs.getString("email"),
				        rs.getString("password")
				    ));
				}else {
					return Optional.empty(); // 해당하는 row가 없으면 Optional.empty() 반환
				}
			} catch (SQLException e) {
				return Optional.empty(); // 에러가 발생했을 때 Optional.empty() 반환
			}
        }, userId);
    }
    
    public List<User> getAllUsers() throws SQLException {
        // DaoTemplate에서 구현된 queryForList 메서드를 사용하여 모든 사용자를 가져오는 쿼리를 실행할 수 있다.
        return queryForList("SELECT * FROM user", rs -> {
            return new User(rs.getLong("userId"), rs.getString("nickName"), rs.getString("email"), rs.getString("password"));
        });
    }

    /**
     * member id를 리턴
     * @param user
     * @return
     * @throws SQLException
     */
    public Long updateUser(User user) throws SQLException {
        String sql = "UPDATE user SET nickName = ?, email = ?, password = ? WHERE userId = ?";
        return update(sql, user.getNickName(), user.getEmail(), user.getPassword(), user.getUserId());
    }
}