package com.test.jdbc;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

@Component
public class CircleJdbc {

	@Autowired
	private DataSource dataSource;
	
	private JdbcTemplate template;
	
	public int getCircleCount(){
//		setDataSource(dataSource);
		return template.queryForObject("select count(*) from circle",null,Integer.class);
	}
	
	public CircleVO getCircleById(int id){
		String sql = "select * from circle where id=?";
		setDataSource(dataSource);
		return template.queryForObject(sql,new Object[]{id},new CircleMapper());
	}
	
	public List<CircleVO> getAllCircle(){
		String sql = "select * from circle";
		setDataSource(dataSource);
		return template.query(sql,new CircleMapper());
	}
		
	private static final class CircleMapper implements RowMapper<CircleVO> {

		@Override
		public CircleVO mapRow(ResultSet arg0, int arg1) throws SQLException {
			CircleVO circle = new CircleVO();
			circle.setId(arg0.getInt("id"));
			circle.setName(arg0.getString("name"));
			circle.setDescription(arg0.getString("description"));
			return circle;
		}
		
	}
	
	public DataSource getDataSource() {
		return dataSource;
	}

	public void setDataSource(DataSource dataSource) {
		System.out.println("setting data source...");
		this.template = new JdbcTemplate(dataSource);
	}
	
	
	
}
