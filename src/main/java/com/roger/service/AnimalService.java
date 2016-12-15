package com.roger.service;


import java.util.List;

public interface AnimalService {
	
	public String getName();
	
	public void setName(String name,Integer age);
	
	public void transfer();

    public void doInit();

    public List<String> findParent(String name);
}
