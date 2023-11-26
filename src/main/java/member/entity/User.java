package member.entity;

import jdbcUtil.Identifiable;
import member.dto.*;

public class User implements Identifiable {
	private Long userId;
	private String nickName;
	private String email;
	private String password;
	
	public String getNickName() {
		return nickName;
	}

	public String getEmail() {
		return email;
	}

	public String getPassword() {
		return password;
	}

	public Long getUserId() {
		return userId;
	}
	
	public void setNickName(String nickName) {
		this.nickName = nickName;
	}

	@Override
    public void setId(Long id) {
        this.userId = id;
    }
	@Override
	public Long getId() {
		return userId;
	}
	/**
	 * 일반적인 경우에 사용
	 * @param nickName
	 * @param email
	 * @param password
	 */
	public User(String nickName, String email, String password) {
		super();
		this.nickName = nickName;
		this.email = email;
		this.password = password;
	}
	/**
	 * 일반적인 경우 사용 x
	 * id 값을 지정해줘야하는 특수한 경
	 * @param userId
	 * @param nickName
	 * @param email
	 * @param password
	 */
	public User(Long userId, String nickName, String email, String password) {
		super();
		this.userId = userId;
		this.nickName = nickName;
		this.email = email;
		this.password = password;
	}
	public User(UserDto userDto) {
		this.userId = userDto.getId();
		this.nickName = userDto.getNickName();
		this.email = userDto.getEmail();
	}
	public User(SignUpDto signUpDto) {
		this.nickName = signUpDto.getNickName();
		this.email = signUpDto.getLoginId();
		this.password = signUpDto.getPassword();
	}
	public User() {
		this.userId = null;
		this.email = null;
		this.password = null;
		this.nickName = null;
	}

	@Override
	public String toString() {
		return "User [userId=" + userId + ", nickName=" + nickName + ", email=" + email + ", password=" + password
				+ "]";
	}
	
}