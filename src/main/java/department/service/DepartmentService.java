package department.service;

import java.util.List;

import department.dao.DepartmentDao;
import department.entity.Department;

public class DepartmentService {
	private final DepartmentDao departmentDao = new DepartmentDao();
	public List<Department> getDepartmentByHospitalId(Long hospitalId){
		return departmentDao.getDepartmentsByHospitalId(hospitalId);
	}
}
