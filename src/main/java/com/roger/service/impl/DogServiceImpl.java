package com.roger.service.impl;

import com.roger.annotation.CacheMethod;
import com.roger.annotation.CalculateService;
import org.springframework.stereotype.Service;

import com.roger.annotation.PrintTime;
import com.roger.service.AnimalService;
import org.springframework.ui.Model;

import java.util.ArrayList;
import java.util.List;

@Service("dogService")
public class DogServiceImpl implements AnimalService{

    @Override
    public String getName() {
        try {
            Thread.sleep(130);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return "Dog";
    }

    public void transfer() {
        System.out.println("do dog transfer!!!");
    }

    @Override
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
    public List<String> findParent(Model model) {
        try {
            Thread.sleep(20);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        List<String> list = new ArrayList<String>();
        list.add("Dog Mother");
        list.add("Dog Father");
        return list;
    }

    @Override
    public void setName(String name,Integer age) {
        try {
            Thread.sleep(40);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("dogService name = "+name+" age = "+age);
    }

}
