package com.udemy28001.resource;

import java.net.URI;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.udemy28001.entity.Users;
import com.udemy28001.service.UserDaoService;

@RestController
public class UserResource {
	
	@Autowired
	private UserDaoService service;
	
	// get all users
	@GetMapping("/users")
	public List<Users> retriveAll() {
		return service.findAll();
		
	}
	
	
	//get user by id
	@GetMapping("/users/{id}")
	public Users getById(@PathVariable int id ){
		Users user=service.findById(id);
		if(user==null) {
			throw new UserNotFoundException("id--- "+ id);
		}
		//HATEOAS--- HIPERMEDIA AS THE ENGINE OF APPLICAITON STATE
		
		
		return user;
	}
	
//		@GetMapping("/user/{id}")
//		public Resource<Users> retrieveUser(@PathVariable int id){
//			Users user=service.findById(id);
//			if(user==null) {
//				throw new UserNotFoundException("id---"+ id);
//			}
//			Resource <User> resource = new Resource<User>(user);
//			BasicLinkBuilder linkTo=linkTo(((Object) methodOn(this.getClass())).retrieveAll());
//			resource.add(linkTo.withRel("all-users"));
//			return resource;
//			
//		}
	
	
	
	
//	private Object methodOn(Class<? extends UserResource> class1) {
//			// TODO Auto-generated method stub
//			return null;
//		}


	//Created
	//input details of the user
	//output -created $return the created URI
	@PostMapping("/users")
	public ResponseEntity<Object> createUser(@Valid @RequestBody Users user) {
		Users savedUser=service.save(user);
		URI location =ServletUriComponentsBuilder.
				fromCurrentRequest().
				path("/{id}").
				buildAndExpand(savedUser.getId()).toUri();
		return ResponseEntity.created(location).build();
		
	}
	
	@DeleteMapping("/users/{id}")
	public void deleteUser(@PathVariable int id) {
		Users user=service.deleteById(id);
		if(user==null) {
			throw new UserNotFoundException("id-->"+ id);
		}
		
	}

}
