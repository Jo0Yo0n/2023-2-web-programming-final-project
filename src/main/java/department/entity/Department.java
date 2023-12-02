package department.entity;

public class Department {
	private Long depratmentId;
	private Long hospitalId;
	private String departmentName;
	private Integer price;
	public Long getDepratmentId() {
		return depratmentId;
	}
	public Long getHospitalId() {
		return hospitalId;
	}
	public String getdepartmentName() {
		return departmentName;
	}
	public Integer getPrice() {
		return price;
	}

	public Department(Long depratmentId, Long hospitalId, String departmentName, Integer price) {
		this.depratmentId = depratmentId;
		this.hospitalId = hospitalId;
		this.departmentName = departmentName;
		this.price = price;
	}
	
	public Department() {
		
	}
	
}
