package search.service;

import java.util.List;

import department.dao.DepartmentDao;
import search.dto.SearchDto;

public class SearchService {
	private final DepartmentDao departmentDao = new DepartmentDao();

	public List<SearchDto> getResult(String keyword){
		List<SearchDto> result = departmentDao.getSearchResultByKeyword(keyword);
		for(SearchDto dto: result) {
			System.out.println(dto);
		}
		return result;
	}
}
