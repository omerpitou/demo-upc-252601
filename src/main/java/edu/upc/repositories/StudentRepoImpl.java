package edu.upc.repositories;

import java.util.List;

import org.simpleflatmapper.jdbc.spring.JdbcTemplateMapperFactory;
import org.simpleflatmapper.jdbc.spring.ResultSetExtractorImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.simple.JdbcClient;
import org.springframework.stereotype.Repository;

import edu.upc.models.Student;
import io.micrometer.common.util.StringUtils;

@Repository
public class StudentRepoImpl implements StudentRepoCustom {
	
	@Autowired
	private JdbcClient jdbcClient;
	
	private static final ResultSetExtractorImpl<Student> rsExtr = JdbcTemplateMapperFactory.newInstance()
			.addKeys("id")
			.ignorePropertyNotFound()
			.newResultSetExtractor(Student.class);

	@Override
	public List<Student> get(String keyword) {
		String sql;
		Object[] params;
		
		if (StringUtils.isNotBlank(keyword)) {
			sql = "SELECT * FROM students WHERE ("
					+ "nom LIKE ? OR postnom LIKE ? OR prenom LIKE ?"
					+ ") ORDER BY nom";
			
			String _keyword = "%".concat(keyword).concat("%");
			
			params = new Object[] { _keyword, _keyword, _keyword };
	
		} else {
			sql = "SELECT * FROM students ORDER BY nom";
			
			params = new Object[] {};
		}
		
		return jdbcClient.sql(sql).params(params).query(rsExtr);
	}

}
