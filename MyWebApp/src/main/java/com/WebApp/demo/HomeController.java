package com.WebApp.demo;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
//import org.springframework.web.bind.annotation.ResponseBody;
@Controller
public class HomeController {
	@RequestMapping("home")
	
//	public String home(HttpServletRequest req,HttpServletResponse res) {
//		
//		HttpSession session= req.getSession();
//		String name = req.getParameter("name");
//		System.out.println("hii "+name);
//		session.setAttribute("name", name);
//		return "home";
//		
//		
//	}
//public String home1(@RequestParam("name") String name,HttpSession session) {
//        
////        HttpSession session= req.getSession();
////        String name = req.getParameter("name"); 
//        System.out.println("hii sesison "+name);
//        session.setAttribute("name", name);
//        return "home";
//        
//        
//    }
//	public ModelAndView home(@RequestParam("name") String My_name) {
//		
//		ModelAndView mv=new ModelAndView();
//		mv.addObject("NameToPass",My_name);// can add multiple
//		mv.setViewName("home");
//		System.out.println("hii model "+My_name);
////		session.setAttribute("NameToPass", My_name);
//		return mv;
//		
//	}
//	public ModelAndView home(Alien alien) {
//		ModelAndView mv=new ModelAndView();
//		mv.addObject("NameToPass",alien);//multiple params
//		mv.setViewName("home");
//		System.out.println("hii alien (by object) "+alien.getAname());
////		session.setAttribute("NameToPass", My_name);
//		return mv;
//	}

}
