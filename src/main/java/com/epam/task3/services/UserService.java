package com.epam.task3.services;

import com.epam.task3.entities.User;

public interface UserService {
	User createUser(User user);
	void followUser(Long userId, Long targetId);
}
