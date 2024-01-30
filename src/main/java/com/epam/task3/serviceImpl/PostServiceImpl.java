package com.epam.task3.serviceImpl;

import org.springframework.stereotype.Service;

import com.epam.task3.entities.Post;
import com.epam.task3.repositories.PostRepository;
import com.epam.task3.services.PostService;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class PostServiceImpl implements PostService{
	
	private final PostRepository postRepository;
	
	@Override
	public Post createPost(Post post, Long userId) {
	    User user = userRepository.findById(userId).orElseThrow(() -> new UserNotFoundException(userId));
	    post.setAuthor(user);
	    return postRepository.save(post);
	}

	@Override
	public void likePost(Long userId, Long postId) {
	    User user = userRepository.findById(userId).orElseThrow(() -> new UserNotFoundException(userId));
	    Post post = postRepository.findById(postId).orElseThrow(() -> new PostNotFoundException(postId));
	    post.getLikes().add(user);
	    postRepository.save(post);		
	}

}
