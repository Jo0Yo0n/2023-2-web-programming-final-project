package member.service;

import java.sql.SQLException;
import java.util.Optional;

import member.dao.UserDao;
import member.dto.LoginDto;
import member.dto.SignUpDto;
import member.entity.User;

public class MemberService {
	private final UserDao userDao = new UserDao();
	public Optional<User> login(LoginDto loginDto) {
		Optional<User> optionalUser;
		try {
			optionalUser = userDao.getUserByLoginId(loginDto.getLoginId());
		} catch(SQLException e) {
			// login id가 db에 없는 경우 
			e.printStackTrace();
			return Optional.empty();
		}
		// 결과가 null 인 경우엔 비어있는 user 객체 
		User user = optionalUser.orElse(new User());
		
		if(user.getPassword() == null) {
			return Optional.empty();
		}
		// user 객체 비밀번호와 loginDto 비밀번호를 비교 
		if(user.getPassword().equals(loginDto.getPassword())) {
			return Optional.of(user);
		} else {
			return Optional.empty();
		}
		
	}
	public boolean signUp(SignUpDto signUpDto) {
		try {
			userDao.insertUser(new User(signUpDto));
			return true;
		} catch(SQLException e) {
			e.printStackTrace();
			return false;
		}
		
	}
}
