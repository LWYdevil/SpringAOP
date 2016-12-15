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

@Controller
public class HelloWordController {
	
	@Resource(name="dogService")
	private AnimalService dogService;
	
	@Resource(name="catService")
	private AnimalService catService;
	
	@RequestMapping(value="/monitor",method={RequestMethod.GET,RequestMethod.POST})
	@PrintTime(methodName = "index", serviceName = "HelloWordController")
	public String monitor(HttpServletRequest request,HttpServletResponse response,Model model){
        model.addAttribute("serviceMap", CalculateUtils.getServiceCallMap());
		return "/monitor";
	}
	
	@RequestMapping(value="/index")
	public String index(HttpServletRequest request,HttpServletResponse response,Model model){
        model.addAttribute("user", "roger");

        dogService.doInit();
        dogService.doInit();
        catService.doInit();

        dogService.getName();
        catService.getName();

        dogService.findParent("dog");
        catService.findParent("cat");

        dogService.setName("dog",10);
        catService.setName("cat",20);

		return "/index";
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
