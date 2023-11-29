package department.entity;

public class Department {
	private Long depratmentId;
	private Long hospitalId;
	private Long departName;
	private Integer price;
	public Long getDepratmentId() {
		return depratmentId;
	}
	public Long getHospitalId() {
		return hospitalId;
	}
	public Long getDepartName() {
		return departName;
	}
	public Integer getPrice() {
		return price;
	}

	public Department(Long depratmentId, Long hospitalId, Long departName, Integer price) {
		this.depratmentId = depratmentId;
		this.hospitalId = hospitalId;
		this.departName = departName;
		this.price = price;
	}
	
	public Department() {
		
	}
	
}
