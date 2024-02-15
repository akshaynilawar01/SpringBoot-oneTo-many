package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.UserModel;
import com.example.demo.service.UserService;

@RestController
public class UserController {

	
	@Autowired 
	
	UserService userService;
	
	@GetMapping("/")
	public List<UserModel> getAll()
	{
		return userService.getAllUser();
	}
	
	@DeleteMapping("/delete/{id}")
	public void deleted(@PathVariable int id)
	{
		userService.deleteUser(id);
	}
	
	@PostMapping("/added")
	public UserModel newSuer(@RequestBody UserModel usermodel)
	{
		return userService.addUSer(usermodel);
	}
}
