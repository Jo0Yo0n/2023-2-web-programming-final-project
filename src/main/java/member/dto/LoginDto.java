package member.dto;

public class LoginDto {
	private String loginId;
	private String password;
	
	public String getLoginId() {
		return loginId;
	}
	
	public String getPassword() {
		return password;
	}
	public LoginDto(String loginId, String password) {
		this.loginId = loginId;
		this.password = password;
	}
}
