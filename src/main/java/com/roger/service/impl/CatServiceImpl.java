package com.roger.service.impl;

import com.roger.annotation.CalculateService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.roger.service.AnimalService;

import java.util.ArrayList;
import java.util.List;

@Service("catService")
public class CatServiceImpl implements AnimalService{

	public String getName() {
		return "Cat";
	}

	public void transfer() {
		System.out.println("do cat transfer!!!");
	}

    @Override
    @CalculateService()
    public void doInit() {
        try {
            Thread.sleep(150);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("do Init cat!!");
    }

    @Override
    public List<String> findParent(String name) {
        List<String> list = new ArrayList<String>();
        list.add("cat Mother");
        list.add("cat Father");
        return list;
    }

    @Transactional
    @CalculateService()
	public void setName(String name,Integer age) {
        try {
            Thread.sleep(60);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("catService name = "+name+" age = "+age);
	}

}
