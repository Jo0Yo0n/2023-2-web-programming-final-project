package review.dto;

public class MyReviewDto {
	private Long hospitalId;
	private Long reviewId;
	private String hosName;
	private String hosTel;
	private String hosAddress;
	private String hosPic;
	private String reviewContent;
	public Long getHospitalId() {
		return hospitalId;
	}
	public Long getReviewId() {
		return reviewId;
	}
	public String getHosName() {
		return hosName;
	}
	public String getHosTel() {
		return hosTel;
	}
	public String getHosAddress() {
		return hosAddress;
	}
	public String getHosPic() {
		return hosPic;
	}
	public String getReviewContent() {
		return reviewContent;
	}
	public MyReviewDto(Long hospitalId, Long reviewId, String hosName, String hosTel, String hosAddress, String hosPic,
			String reviewContent) {
		this.hospitalId = hospitalId;
		this.reviewId = reviewId;
		this.hosName = hosName;
		this.hosTel = hosTel;
		this.hosAddress = hosAddress;
		this.hosPic = hosPic;
		this.reviewContent = reviewContent;
	}
	
	
	
}
