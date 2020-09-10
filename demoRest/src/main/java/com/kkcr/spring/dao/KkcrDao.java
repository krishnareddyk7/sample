package com.kkcr.spring.dao;

import java.util.List;

import com.kkcr.spring.Kkcr;

public interface KkcrDao {
	
	public abstract int createKkcr(Kkcr kkcr);
	
	public abstract List<Kkcr> getKkcr();

}
