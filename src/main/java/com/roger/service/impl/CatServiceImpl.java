package com.roger.service.impl;

import com.roger.annotation.CalculateService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.roger.service.AnimalService;
import org.springframework.ui.Model;

import java.util.ArrayList;
import java.util.List;

@Service("catService")
public class CatServiceImpl implements AnimalService{

    @Override
    public String getName() {
        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return "Cat";
    }

    public void transfer() {
        System.out.println("do cat transfer!!!");
    }

    @Override
    public void doInit() {
        try {
            Thread.sleep(150);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("do Init cat!!");
    }

    @Override
    public List<String> findParent(Model model) {
        try {
            Thread.sleep(10);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        List<String> list = new ArrayList<String>();
        list.add("cat Mother");
        list.add("cat Father");
        return list;
    }

    @Transactional
    public void setName(String name,Integer age) {
        try {
            Thread.sleep(60);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("catService name = "+name+" age = "+age);
        System.out.println("aaa");
    }

}
