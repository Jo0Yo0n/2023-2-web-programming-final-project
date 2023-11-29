package like.entity;

public class Like {
	private Long userId;
	private Long hospitalId;
	public Long getUserId() {
		return userId;
	}
	public Long getHospitalId() {
		return hospitalId;
	}
	public Like(Long userId, Long hospitalId) {
		this.userId = userId;
		this.hospitalId = hospitalId;
	}
	public Like() {
		
	}
}
