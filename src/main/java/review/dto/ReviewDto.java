package review.dto;

public class ReviewDto {
	private Long userId;
	private Long hospitalId;
	private String userNickName;
	private String content;
	public Long getUserId() {
		return userId;
	}
	public String getUserNickName() {
		return userNickName;
	}
	public String getContent() {
		return content;
	}
	public Long getHospitalId() {
		return hospitalId;
	}
	public ReviewDto(Long userId, String userNickName, String content) {
		this.userId = userId;
		this.userNickName = userNickName;
		this.content = content;
	}
	public ReviewDto(Long userId, Long hospitalId, String userNickName, String content) {
		this.userId = userId;
		this.hospitalId = hospitalId;
		this.userNickName = userNickName;
		this.content = content;
	}
	
	public ReviewDto() {
		
	}
	@Override
	public String toString() {
		return "ReviewDto [userId=" + userId + ", userNickName=" + userNickName + ", content=" + content + "]";
	}
	
}
