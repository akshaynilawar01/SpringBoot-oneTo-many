package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.UserModel;
import com.example.demo.repository.UserRepo;

@Service
public class UserService {
	
	@Autowired
	
	UserRepo userRepo;
	
	public List<UserModel> getAllUser()
	{
		return userRepo.findAll();
	}
	
	public UserModel addUSer(UserModel usermodel)
	{
		return userRepo.save(usermodel);
	}
	
	public void deleteUser(int id)
	{
		userRepo.deleteById(id);
	}
	
	
}
