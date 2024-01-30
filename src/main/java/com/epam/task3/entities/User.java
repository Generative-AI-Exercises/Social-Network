package com.epam.task3.entities;

import jakarta.persistence.*;
import lombok.Data;

import java.util.Set;

@Data
@Entity
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String username;
    
    @OneToMany(mappedBy = "author")
    private Set<Post> posts;

    @ManyToMany
    @JoinTable(
        name = "user_follows",
        joinColumns = @JoinColumn(name = "user_id"),
        inverseJoinColumns = @JoinColumn(name="target_user_id")
    )
    private Set<User> following;

    // Getters and setters
}