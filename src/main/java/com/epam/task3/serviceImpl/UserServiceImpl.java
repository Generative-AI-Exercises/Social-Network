package com.epam.task3.serviceImpl;
import org.springframework.stereotype.Service;

import com.epam.task3.entities.User;
import com.epam.task3.repositories.UserRepository;
import com.epam.task3.services.UserService;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class UserServiceImpl implements UserService{
	private final UserRepository userRepository;

	@Override
	public User createUser(User user) {
		return userRepository.save(user);
	}

	@Override
	public void followUser(Long userId, Long targetId) {
	    User user = userRepository.findById(userId).orElseThrow(() -> new UserNotFoundException(userId));
	    User target = userRepository.findById(targetId).orElseThrow(() -> new UserNotFoundException(targetId));
	    user.getFollowing().add(target);
	    userRepository.save(user);		
	}
}
