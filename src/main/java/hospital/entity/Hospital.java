package hospital.entity;

public class Hospital {
	private Long hospitalId;
	private String tel;
	private String address;
	private String hospitalName;
	private String hosPic;
	
	public Long getHospitalId() {
		return hospitalId;
	}
	public String getTel() {
		return tel;
	}
	public String getAddress() {
		return address;
	}
	public String getHospitalName() {
		return hospitalName;
	}
	public String getHosPic() {
		return hosPic;
	}
	public Hospital(Long hospitalId, String tel, String address, String hospitalName, String hosPic) {
		super();
		this.hospitalId = hospitalId;
		this.tel = tel;
		this.address = address;
		this.hospitalName = hospitalName;
		this.hosPic = hosPic;
	}
	
}
