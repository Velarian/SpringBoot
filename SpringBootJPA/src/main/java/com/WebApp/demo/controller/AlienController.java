package com.WebApp.demo.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.WebApp.demo.dao.AlienRepo;
import com.WebApp.demo.model.Alien;

@Controller
@RestController
public class AlienController {
	@Autowired
	AlienRepo repo;
	@RequestMapping("/")
public String home() {
	return "home.jsp";
	
}
	@PostMapping("/addAlien")
	
	public Alien addAlien(@RequestBody Alien alien) {
		repo.save(alien);
		return  alien;		
	}
	@RequestMapping("/getAlien")
	public ModelAndView getAlien(@RequestParam int aid) {
		ModelAndView mv= new ModelAndView("ShowAlien.jsp");
		Alien alien=repo.findById(aid).orElse(new Alien());
		mv.addObject(alien);//
		System.out.println(repo.findBylanguage("java"));
		System.out.println(repo.findByaidGreaterThan(102));
		System.out.println(repo.findByaidLessThan(102));
		System.out.println(repo.findBylanguage("java"));
		return mv;	
		
	}
//	@RequestMapping(value = "/updateAlien/{aid}", method = RequestMethod.PUT)
//	public String updateAlien(int aid) {
//	    ModelAndView mav = new ModelAndView("edit_alien.jsp");
//	    Alien alien = service.get(id);// repo.save(product);
//	    mav.addObject("product", product);
//	    mav.setViewName(null) 
//	    return mav;
//	}
//	
	
//	@RequestMapping(value = "/updateAlien/{aid}", method = RequestMethod.PUT)
//	public String updateAlien(@RequestParam int aid){
//	    ModelAndView mv= new ModelAndView("edit_alien.jsp");
//	    Alien alien=repo.findById(aid).orElse(null);
//	   
//	    //Alien new_alien = repo.save(null)
//	    //code
//	    repo.delete(alien);
//        return null;    
//	}
//	public String set(Alien alien) {
//        repo.save(alien);
//        return  "home.jsp";     
//    }
//	`
	@RequestMapping(path  = "/getAliens")
	//@ResponseBody// no view... the response is expected
    public List<Alien> getAliens() {
       return repo.findAll();
    }
	
//	@PostMapping("/setalien")
//	public Alien setAlien(Alien alien) {
//      repo.save(alien);
//      return alien;    
//  }
	@GetMapping("/get")
 // @ResponseBody// no view... the response is expected
    public List<Alien> getAlien() {
       return repo.findAll();
    }
	@DeleteMapping("/delete/{aid}")
	public String deleteAlien(@PathVariable int aid) {
	    Alien alien=repo.getOne(aid);
        repo.delete(alien);
        return  "deleted";      
    }
	@PutMapping("/update")
	public Alien savAlien(@RequestBody Alien alien) {
        repo.save(alien);
        return  alien;      
    }
	
	
	
	
}
