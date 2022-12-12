
package org.generation.italy.demo.controller;

import java.util.List;
import java.util.Optional;

import org.generation.italy.demo.pojo.Promoting;
import org.generation.italy.demo.service.PromotingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import jakarta.validation.Valid;


@Controller
@RequestMapping("/promoting")
public class PromotingController {
	
	@Autowired
	private PromotingService promotingService;
	
	@GetMapping
	public String getPromotingList(Model model) {
		
		List<Promoting> promotingList = promotingService.findAll();
		model.addAttribute("promotingList", promotingList);
		
		return "promoting/index";
	}
	
	@GetMapping("/{id}")
	public String getPromotingById(@PathVariable("id") int id, Model model)
	{
		Optional<Promoting> optPromoting = promotingService.getPromotingById(id);
		
		Promoting promoting =optPromoting.get();
		
		model.addAttribute("promoting", promoting);
		
		return "promoting/show";
	}
	
	
	@GetMapping("/create")
	public String createPromoting( Model model)
	{

		
		Promoting promoting = new Promoting();
		
		model.addAttribute("promoting", promoting);
		model.addAttribute("type", "create");
		model.addAttribute("h1text", "Create a new promoting for the list:");
		
		return "promoting/form";
	}
	
	@PostMapping("/create")
	public String storePromoting(@Valid @ModelAttribute("promoting") Promoting promoting)
	{
		promotingService.save(promoting);
		
		return "redirect:/promoting";
	}
	
	@GetMapping("/edit/{id}")
	public String editPromoting(@PathVariable("id") int id, Model model, Error e, BindingResult bindingResult, RedirectAttributes redirectAttributes)
	{

		if (bindingResult.hasErrors()) {
			
			System.err.println("ERROR ------------------------------------------");
			System.err.println(bindingResult.getAllErrors());
			System.err.println("------------------------------------------------");
			
			redirectAttributes.addFlashAttribute("errors", bindingResult.getAllErrors());
			
			return "redirect:/promoting/create";
		}
		
		Optional<Promoting> optPromoting = promotingService.getPromotingById(id);
		
		Promoting promoting =optPromoting.get();
		
		model.addAttribute("promoting", promoting);
		
		model.addAttribute("type", "edit");
		model.addAttribute("h1text", "Update promoting:");
		
		
		return "promoting/form";
	}
	
	@PostMapping("/edit")
	public String updatePromoting(@Valid @ModelAttribute("promoting") Promoting promoting, BindingResult bindingResult, RedirectAttributes redirectAttributes)
	{
		if (bindingResult.hasErrors()) {
			
			System.err.println("ERROR ------------------------------------------");
			System.err.println(bindingResult.getAllErrors());
			System.err.println("------------------------------------------------");
			
			redirectAttributes.addFlashAttribute("errors", bindingResult.getAllErrors());
			
			return "redirect:/promoting/create";
		}
		promotingService.save(promoting);
		
		return "redirect:/promoting";
	}
	
	@GetMapping("/delete/{id}")
	public String deleteBook(@PathVariable("id") int id) {
		
		promotingService.delete(id);
		return "redirect:/promoting";
	}
	
	@GetMapping("/search")
	public String searchByName(Model model, 
			@RequestParam(name = "q", required = false) String query) {
		

		List<Promoting> promotingList = query == null 
							? promotingService.findAll()
							: promotingService.findPromotionByTitle(query); 
		
		model.addAttribute("promotingList", promotingList);
		model.addAttribute("query", query);
		
		return "promoting/search";
	}

}
