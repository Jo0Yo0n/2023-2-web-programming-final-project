package review.dto;

public class ReviewDto {
	private Long userId;
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
	public ReviewDto(Long userId, String userNickName, String content) {
		super();
		this.userId = userId;
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
