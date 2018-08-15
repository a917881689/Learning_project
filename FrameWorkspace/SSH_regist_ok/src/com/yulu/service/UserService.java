package com.yulu.service;

import com.yulu.entity.User;

public interface UserService {
	void register(User user);
	void login(User user);
}
