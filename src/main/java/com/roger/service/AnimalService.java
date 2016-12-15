package com.roger.service;


import org.springframework.ui.Model;

import java.util.List;

public interface AnimalService {
	
	public String getName();
	
	public void setName(String name,Integer age);
	
	public void transfer();

    public void doInit();

    public List<String> findParent(Model model);
}
