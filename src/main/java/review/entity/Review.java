package review.entity;

import jdbcUtil.Identifiable;
import review.dto.ReviewDto;

public class Review implements Identifiable {
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
	public Review() {
		
	}
	public Review(Long reviewId, Long userId, Long hospitalId, String content) {
		super();
		this.reviewId = reviewId;
		this.userId = userId;
		this.hospitalId = hospitalId;
		this.content = content;
	}
	
	public Review(ReviewDto reviewDto) {
		this.userId = reviewDto.getUserId();
		this.hospitalId = reviewDto.getHospitalId();
		this.content = reviewDto.getContent();
	}
	@Override
	public Long getId() {
		return reviewId;
	}
	@Override
	public void setId(Long id) {
		this.reviewId = id;
	}
}
