package member.dto;

public class UserDto {
	private Long userId;
	private String nickName;
	private String email;

	
	public String getNickName() {
		return nickName;
	}

	public String getEmail() {
		return email;
	}

	public Long getUserId() {
		return userId;
	}
	
	public void setNickName(String nickName) {
		this.nickName = nickName;
	}

    public void setId(Long id) {
        this.userId = id;
    }
	public Long getId() {
		return userId;
	}
	/**
	 * 일반적인 경우에 사용
	 * @param nickName
	 * @param email
	 * @param password
	 */
	public UserDto(String nickName, String email) {
		this.nickName = nickName;
		this.email = email;
	}
	/**
	 * 일반적인 경우 사용 x
	 * id 값을 지정해줘야하는 특수한 경
	 * @param userId
	 * @param nickName
	 * @param email
	 * @param password
	 */
	public UserDto(Long userId, String nickName, String email ) {
		super();
		this.userId = userId;
		this.nickName = nickName;
		this.email = email;

	}
	public UserDto() {
		
	}

	@Override
	public String toString() {
		return "User [userId=" + userId + ", nickName=" + nickName + ", email=" + email
				+ "]";
	}
}
