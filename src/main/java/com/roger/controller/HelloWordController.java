package com.roger.controller;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.roger.util.CalculateUtils;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.roger.annotation.PrintTime;
import com.roger.service.AnimalService;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.List;

@Controller
public class HelloWordController {

    @Resource(name="dogService")
    private AnimalService dogService;

    @Resource(name="catService")
    private AnimalService catService;

    @RequestMapping(value="/monitor",method={RequestMethod.GET,RequestMethod.POST})
    public String monitor(HttpServletRequest request,HttpServletResponse response,Model model){
        model.addAttribute("serviceMap", CalculateUtils.getServiceCallMap());
        return "/monitor";
    }

    @RequestMapping(value="/index")
    public String index(HttpServletRequest request,HttpServletResponse response,Model model){

        List<String> serviceName = new ArrayList<String>();
        serviceName.add("DogServiceImpl.doInit");
        serviceName.add("CatServiceImpl.doInit");
        serviceName.add("DogServiceImpl.getName");
        serviceName.add("CatServiceImpl.getName");
        serviceName.add("DogServiceImpl.setName");
        serviceName.add("CatServiceImpl.setName");
        serviceName.add("DogServiceImpl.findParent");
        serviceName.add("CatServiceImpl.findParent");

        model.addAttribute("services",serviceName);
        return "/index";
    }

    @RequestMapping(value="/DogServiceImpl/doInit")
    public String dogInit(HttpServletRequest request,HttpServletResponse response,Model model){
        dogService.doInit();
        return "/print";
    }

    @RequestMapping(value="/CatServiceImpl/doInit")
    public String catInit(HttpServletRequest request,HttpServletResponse response,Model model){
        catService.doInit();
        return "/print";
    }

    @RequestMapping(value="/DogServiceImpl/getName")
    public String dogGetName(HttpServletRequest request,HttpServletResponse response,Model model){
        dogService.getName();
        return "/print";
    }

    @RequestMapping(value="/CatServiceImpl/getName")
    public String catGetName(HttpServletRequest request,HttpServletResponse response,Model model){
        catService.getName();
        return "/print";
    }

    @RequestMapping(value="/DogServiceImpl/setName")
    public String dogSetName(HttpServletRequest request,HttpServletResponse response,Model model){
        dogService.setName("dog", 10);
        return "/print";
    }

    @RequestMapping(value="/CatServiceImpl/setName")
    public String catSetName(HttpServletRequest request,HttpServletResponse response,Model model){
        catService.setName("cat",20);
        return "/print";
    }

    @RequestMapping(value="/DogServiceImpl/findParent")
    public String dogFindParent(HttpServletRequest request,HttpServletResponse response,Model model){
        dogService.findParent(model);
        return "/print";
    }

    @RequestMapping(value="/CatServiceImpl/findParent")
    public String catFindParent(HttpServletRequest request,HttpServletResponse response,Model model){
        catService.findParent(model);
        return "/print";
    }

    @PrintTime(methodName = "testPrintTimeMethod", serviceName = "HelloWordController")
    public void testPrintTimeMethod(){
        System.out.println("doing testPrintTimeMethod....");
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}
