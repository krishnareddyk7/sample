package com.kkcr.spring.repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.stereotype.Repository;

@Repository
public class KkcrRepository {

	@Autowired
	JdbcTemplate jdbcTemplate;
	
	JSONArray kkcrArr = new JSONArray();
	
	public List<String> getAllNames() {
		List<String> kkcrList = new ArrayList<>();
		kkcrList.addAll(jdbcTemplate.queryForList("select name from kkcr.Person", String.class));
		return kkcrList;
	}

	public String getAll() {
		String Src  = null;
		 Src = jdbcTemplate.query("select * from kkcr.Person", new ResultSetExtractor<String>() {

			@Override
			public String extractData(ResultSet rs) throws SQLException, DataAccessException {
				while (rs.next()) {  
	            	JSONObject jObj = new JSONObject();
	            	jObj.put("id", rs.getInt("id"));
	            	jObj.put("Name", rs.getString("name"));
	            	jObj.put("Designation", rs.getString("designation"));
	            	jObj.put("Status", rs.getString("status"));
	            	kkcrArr.put(jObj);
	                
	            }  
				return  kkcrArr.toString();
			}
			
		});
		return Src;
	}

}
