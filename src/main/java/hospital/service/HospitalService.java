package hospital.service;

import java.sql.SQLException;
import java.util.List;

import hospital.dao.HospitalDao;
import hospital.entity.Hospital;
import like.dao.LikeDao;

public class HospitalService {
	private final HospitalDao hospitalDao = new HospitalDao();
	public List<Hospital> getMainHospital(){
		try {
			return hospitalDao.getAllHospital();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
	public Hospital getHospitalById(Long hospitalId){
		try {
			return hospitalDao.getHospitalById(hospitalId).orElse(new Hospital());
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
	
}
