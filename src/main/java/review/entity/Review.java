package review.entity;

public class Review {
	private Long reviewId;
	private Long userId;
	private Long hospitalId;
	private String content;
	public Long getReviewId() {
		return reviewId;
	}
	public Long getUserId() {
		return userId;
	}
	public Long getHospitalId() {
		return hospitalId;
	}
	public String getContent() {
		return content;
	}
	public Review(Long reviewId, Long userId, Long hospitalId, String content) {
		super();
		this.reviewId = reviewId;
		this.userId = userId;
		this.hospitalId = hospitalId;
		this.content = content;
	}
	
	public Review() {
		
	}
}
