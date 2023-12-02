package department.dao;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import department.entity.Department;
import jdbcUtil.DaoTemplate;

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
	
}
