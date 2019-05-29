package com.springboot.app.models.service;

import com.springboot.app.models.entity.User;

public interface UserService {

	public void saveUser(User user);
	
	public boolean isUserAlreadyPresent(User user);
}
