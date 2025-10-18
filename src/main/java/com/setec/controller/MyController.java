package com.setec.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.setec.entities.Booked;
import com.setec.repos.BookedRepo;
import com.setec.telegrambot.MyTelegramBot;



@Controller
public class MyController {	
	
	//http://localhost:8080/
	
	@GetMapping({"/","/home"})
	public String home(Model mod) {
		Booked booked = new Booked(
				1,"PLEUR",
				"099696435",
				"punleur@gmail.com",
				"09/09/2025",
				"9:09 PM",
				2	
			    );	 
		
		mod.addAttribute("booked", booked);		
		return "index";
	}
	
	@GetMapping("/about")
	public String about() {
		return "about";
	}
	
	@GetMapping("/service")
	public String service() {
		return "service";
	}
	
	@GetMapping("/menu")
	public String menu() {
		return "menu";
	}
	
	@GetMapping("/contact")
	public String contact() {
		return "contact";
	}
	
	@GetMapping("/reservation")
	public String reservation(Model mod) {
		Booked booked = new Booked(
				1,"LEURRR",
				"099696435",
				"punleur@gmail.com",
				"09/09/2025",
				"9:09 PM",
				4	
			    );	 
		
		mod.addAttribute("booked", booked);
		return "reservation";
	}
	
	@GetMapping("/testimonial")
	public String testimonial() {
		return "testimonial";
	}
	
	@Autowired
	private BookedRepo bookedRepo;
	
	@Autowired
	private MyTelegramBot bot;
	
	  @PostMapping({"/success"})
	  public String success(@ModelAttribute Booked booked) {
	    bookedRepo.save(booked);
	    bot.message(
	          "📌 *Booked*\n" +
	          "🆔 ID: " + booked.getId() + "\n" +
	          "👤 Name: " + booked.getName() + "\n" +
	          "📞 Phone: " + booked.getPhoneNumber() + "\n" +
	          "✉️ Email: " + booked.getEmail() + "\n" +
	          "📅 Date: " + booked.getDate() + "\n" +
	          "⏰ Time: " + booked.getTime() + "\n" +
	          "👥 Person: " + booked.getPerson()
	      );
	    return "success";
	  }
}

