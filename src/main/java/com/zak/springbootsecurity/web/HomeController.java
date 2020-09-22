package com.zak.springbootsecurity.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import org.springframework.security.core.Authentication;

import com.zak.springbootsecurity.entities.Message;
import com.zak.springbootsecurity.repositories.MessageRepository;

/**
 * @author Zakaria El Badri
 *
 */
@Controller
public class HomeController
{
	@Autowired
	private MessageRepository messageRepository;
	
	@GetMapping("/home")
	public String home(Model model)
	{
		model.addAttribute("msgs", messageRepository.findAll());		
		return "userhome";
	}
	
	@PostMapping("/messages")
	public String saveMessage(Message message)
	{
		messageRepository.save(message);
		return "redirect:/home";
	}
	
	@GetMapping("/profile")
	public String currentRoleUser(Model model, Authentication authentication) {
		model.addAttribute("userName", authentication.getName());
		model.addAttribute("userRoles", authentication.getAuthorities());		

		return "userprofile";
	}
	
	@GetMapping("/chat")
	public String chatUser(Model model, Authentication authentication) {
		model.addAttribute("userName", authentication.getName());
		model.addAttribute("userRoles", authentication.getAuthorities());		

		return "chat";
	}
	
	@GetMapping("/accessDenied")
	public String accessDenied() {
		return "accessDenied";
	}
}