package search.dto;

import hospital.entity.Hospital;

public class SearchDto {
	private Hospital hospital;
	private String departmentName;
	private Integer price;
	public Hospital getHospital() {
		return hospital;
	}
	public String getDepartmentName() {
		return departmentName;
	}
	public Integer getPrice() {
		return price;
	}
	public SearchDto(Hospital hospital, String departmentName, Integer price) {
		this.hospital = hospital;
		this.departmentName = departmentName;
		this.price = price;
	}
	@Override
	public String toString() {
		return "SearchDto [hospital=" + hospital + ", departmentName=" + departmentName + ", price=" + price + "]";
	}
	
	
}
