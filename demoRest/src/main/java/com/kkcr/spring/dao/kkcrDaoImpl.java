package com.kkcr.spring.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

import com.kkcr.spring.Kkcr;

@Repository
public class kkcrDaoImpl implements KkcrDao {

	@Autowired JdbcTemplate JdbcTemplate;
	
	
	@Override
	public int createKkcr(Kkcr kkcr) {
		
		KeyHolder keyHolder = new GeneratedKeyHolder();
		
		JdbcTemplate.update((Connection Connection) -> {
			PreparedStatement preparedStatement;
			preparedStatement = Connection.prepareStatement("insert into kkcr(name,designation,status) values(?,?,?)", Statement.RETURN_GENERATED_KEYS);
			preparedStatement.setString(1, kkcr.getName());
			preparedStatement.setString(2, kkcr.getDesignation());
			preparedStatement.setString(3, kkcr.getStatus());
			return preparedStatement;
		},keyHolder);
		
		return keyHolder.getKey().intValue();
	}

	@Override
	public List<Kkcr> getKkcr() {
		List<Kkcr> kkcrList = new ArrayList<>();
		Collection<Map<String, Object>> rows = null;
		rows = JdbcTemplate.queryForList("select * from kkcr");
		
		
		rows.stream().map((row)-> {
			Kkcr k = new Kkcr();
			k.setId((int) row.get("id"));
			k.setName((String) row.get("name"));
			k.setDesignation((String) row.get("designation"));
			k.setStatus((String) row.get("status"));
			return k;
		}).forEach((k) -> {
			kkcrList.add(k);
		});
		
		return kkcrList;
	}

}
