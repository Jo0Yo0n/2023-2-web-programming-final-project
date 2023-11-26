package test;


public class UserService {
	UserDao userDao = new UserDao();
	
	public User createUser(UserDto userDto) {
		User user = new User(userDto);
		try {
			Long userId = userDao.insertUser(user);	
		} catch(Exception e) {
			e.printStackTrace();
		}
		
		return user;
	}

}
