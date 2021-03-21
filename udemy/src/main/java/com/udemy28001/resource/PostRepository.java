package com.udemy28001.resource;

import org.springframework.data.jpa.repository.JpaRepository;

import com.udemy28001.entity.Post;

public interface PostRepository extends JpaRepository<Post, Integer> {

}
