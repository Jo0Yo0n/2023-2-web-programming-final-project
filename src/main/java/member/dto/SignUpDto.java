package member.dto;

public class SignUpDto {
	private String nickName;
	private String loginId;
	private String password;
	public String getNickName() {
		return nickName;
	}
	public String getLoginId() {
		return loginId;
	}
	public String getPassword() {
		return password;
	}
	public SignUpDto(String nickName, String loginId, String password) {
		super();
		this.nickName = nickName;
		this.loginId = loginId;
		this.password = password;
	}
	
}
