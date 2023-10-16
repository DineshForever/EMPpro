package com.pro.controller;




import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.pro.Dto.Dto;
import com.pro.serviceImpl.ServiceImpl;



@Controller
public class procontroller {
	@Autowired
	ServiceImpl service;

	@RequestMapping("/")
	public String welcome(){
		
		return "welcome";}
		
		@GetMapping("/index")
		public String index(){
			
			return "index";
			
		
	}
		@GetMapping("/employee")
		public String employee(){
			
			return "employee";}
		
		@GetMapping("/submit")
		public String processForm( Model model) {
			Dto dto=new Dto();
			model.addAttribute("dto", dto);
		   

		    return "submit";
		} 
		
		@PostMapping("/success")   
		 public String create(@ModelAttribute("dto") Dto dto) {
			 service.create(dto);
			return "employee";
			 
		 }
		@GetMapping("/admin")
		public String admin(){
			
			return "admin";}
		@GetMapping("/manage")
		public String manage(){
			
			return "manage";}
		
		 @GetMapping("/viewall")
		    public String viewAll(Model model) {
		        List<Dto> dtos = service.viewall();
		        model.addAttribute("dtos", dtos);
		        return "viewall"; 
		    }
		 @GetMapping("/viewid")
		    public String viewDetails() {
		       
		        return "viewid"; 
		    }
		 
		 
		 
		 @GetMapping("/view")
		    public String viewDetails(@RequestParam int id, Model model) {
		        Dto dto = service.byId(id); 
		        model.addAttribute("dto", dto);
		        return "view"; 
		    }
		 @GetMapping("/delete")
		    public String showDeleteForm() {
		        return "delete";
		    }

		 @PostMapping("/delete")
		    public String deletePerson(@RequestParam int id, Model model) {
		        service.delete(id);
		        return "admin";
		    }
		@GetMapping("/updateid")
		 public String updateid(Model model) {
			
	        return "updateid"; 
	    }
		 @PostMapping("/update")
		 public String updateData(@RequestParam int id, @ModelAttribute("dto") Dto dto, RedirectAttributes redirectAttributes) {
		       
		        service.update(dto, id);
				return "admin";

		
		 }
		    }
