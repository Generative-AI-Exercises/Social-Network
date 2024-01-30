package com.epam.task3.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.epam.task3.entities.User;

public interface UserRepository extends JpaRepository<User, Long> {}