package department.dao;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import department.entity.Department;
import hospital.entity.Hospital;
import jdbcUtil.DaoTemplate;
import search.dto.SearchDto;

public class DepartmentDao extends DaoTemplate<Department> {

	public List<Department> getDepartmentsByHospitalId(Long hospitalId) {
		String sql = "SELECT * FROM department WHERE hospitalId = ?";
		try {
			return queryForList(sql, rs -> {
			    return new Department(
				        rs.getLong("departmentId"),
				        rs.getLong("hospitalId"),
				        rs.getString("departName"),
				        Integer.parseInt(rs.getString("price"))
				    );
			}, hospitalId);
		} catch (SQLException e) {
			e.printStackTrace();
			return new ArrayList<Department>();
		}
	}
	public List<SearchDto> getSearchResultByKeyword(String keyword) {
		String sql = "SELECT hospital.hospitalId, hospital.tel, hospital.address, hospital.hosName, hosPic, "
				+ "department.departName, department.price "
				+ "FROM department INNER JOIN hospital ON department.hospitalId = hospital.hospitalId " 
				+ "WHERE department.departName = ?";
		try {
			return joinQueryForList(sql, rs -> {
			    return new SearchDto(
			    		new Hospital(
			    			rs.getLong("hospitalId"),
			    			rs.getString("tel"),
			    			rs.getString("address"),
			    			rs.getString("hosName"),
			    			rs.getString("hosPic")
			    				),
				        rs.getString("departName"),
				        rs.getInt("price")
				    );
			}, keyword);
		} catch (SQLException e) {
			e.printStackTrace();
			return new ArrayList<SearchDto>();
		}
	}
	
}
