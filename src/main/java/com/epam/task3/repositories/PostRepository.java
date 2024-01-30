package com.epam.task3.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.epam.task3.entities.Post;

public interface PostRepository extends JpaRepository<Post, Long> {}