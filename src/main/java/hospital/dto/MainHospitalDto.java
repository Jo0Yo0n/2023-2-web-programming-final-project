package hospital.dto;

import hospital.entity.Hospital;

public class MainHospitalDto {
	private Long hospitalId;
	private String hospitalName;
	private String hosPic;
	public Long getHospitalId() {
		return hospitalId;
	}
	public String getHospitalName() {
		return hospitalName;
	}
	public String getImgRoute() {
		return hosPic;
	}
	public MainHospitalDto(Long hospitalId, String hospitalName, String hosPic) {
		super();
		this.hospitalId = hospitalId;
		this.hospitalName = hospitalName;
		this.hosPic = hosPic;
	}
	public MainHospitalDto(Hospital hospital) {
		this.hospitalId = hospital.getHospitalId();
		this.hospitalName = hospital.getHospitalName();
		this.hosPic = hospital.getHosPic();
	}
}
