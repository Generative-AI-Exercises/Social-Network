package com.epam.task3.services;

import com.epam.task3.entities.Post;

public interface PostService {
	Post createPost(Post post, Long userId);
	void likePost(Long userId, Long postId);
}
