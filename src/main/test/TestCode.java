package test;

import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

public class TestCode {
	public static void main(String args[]) {
		// UserDao 객체 생성
        UserDao userDao = new UserDao();

        // 사용자 생성
        User user = new User(null, "JohnDoe", "johndoe@example.com", "password");

        try {
            // 사용자 추가
            Long userId = userDao.insertUser(user);
            System.out.println("Inserted user ID: " + userId);

            // 특정 사용자 조회
            Optional<User> fetchedUser = userDao.getUserById(userId);
            fetchedUser.ifPresent(u -> System.out.println("Fetched user: " + u));
            
            // 모든 사용자 조회
            List<User> allUsers = userDao.getAllUsers();
            System.out.println("All users: " + allUsers);

            // 사용자 업데이트
            user.setNickName("UpdatedNickName");
            userDao.updateUser(user);
            fetchedUser = userDao.getUserById(userId);
            fetchedUser.ifPresent(u -> System.out.println("Updated user: " + u));

            // 사용자 삭제
            userDao.deleteUser(userId);
            fetchedUser = userDao.getUserById(userId);
            fetchedUser.ifPresent(u -> System.out.println("delete err user: " + u));
            fetchedUser.orElse(null);
            
        } catch (SQLException e) {
            e.printStackTrace();
        }
	}
}
