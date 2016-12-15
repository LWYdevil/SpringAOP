package com.roger.service.impl;

import com.roger.annotation.CacheMethod;
import com.roger.annotation.CalculateService;
import org.springframework.stereotype.Service;

import com.roger.annotation.PrintTime;
import com.roger.service.AnimalService;

import java.util.ArrayList;
import java.util.List;

@Service("dogService")
public class DogServiceImpl implements AnimalService{

	public String getName() {
		return "Dog";
	}

	public void transfer() {
		System.out.println("do dog transfer!!!");
	}

    @Override
    @CalculateService()
    public void doInit() {
        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("do Init dog!!");
    }

    @Override
    @CacheMethod
    public List<String> findParent(String name) {
        List<String> list = new ArrayList<String>();
        list.add("Dog Mother");
        list.add("Dog Father");
        return list;
    }

    @CalculateService()
    public void setName(String name,Integer age) {
        try {
            Thread.sleep(40);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
		System.out.println("dogService name = "+name+" age = "+age);
	}

}
