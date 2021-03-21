package com.udemy28001.resource;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.udemy28001.entity.User;
@Repository
public interface UserRepository extends JpaRepository<User, Integer> {

	public User deleteById(int id);
	
}
