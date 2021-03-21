package com.udemy28001.resource;

import java.net.URI;
import java.util.List;
import java.util.Optional;

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

import com.udemy28001.entity.Post;
import com.udemy28001.entity.User;


@RestController
public class UserJPAResource {
	
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private PostRepository postRepository;
//	@Autowired
//	private UserDaoService service;
	
	// get all users
	@GetMapping("/jpa/users")
	public List<User> retriveAll() {
		return userRepository.findAll();
		
	}
	
	
	//get user by id
	@GetMapping("/jpa/users/{id}")
	public Optional<User> getById(@PathVariable int id ){
		Optional<User> user=userRepository.findById(id);
		if(!user.isPresent()) {
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
	@PostMapping("/jpa/users")
	public ResponseEntity<Object> createUser(@Valid @RequestBody User user) {
		User savedUser=userRepository.save(user);
		URI location =ServletUriComponentsBuilder.
				fromCurrentRequest().
				path("/{id}").
				buildAndExpand(savedUser.getId()).toUri();
		return ResponseEntity.created(location).build();
		
	}
	
	@DeleteMapping("/jpa/users/{id}")
	public User deleteUser(@PathVariable int id) {
		User user=userRepository.deleteById(id);;
		if(user==null) {
			throw new UserNotFoundException("id-->"+ id);
		}
		return user;
	}
	
	@DeleteMapping("/jpaid/users/{id}")
	public void deleteUserById(@PathVariable int id) {
		userRepository.deleteById(id);;
		
	}
	
	@GetMapping("/jpa/users/{id}/posts")
	public List<Post> retrieveAllPosts(@PathVariable int id){
		Optional <User> userOptional =userRepository.findById(id);
		if(!userOptional.isPresent()) {
			throw new UserNotFoundException("id with "+ id+" is not found");
		}
		return userOptional.get().getPosts();
	}

	@PostMapping("/jpa/users/{id}/posts")
	public ResponseEntity<Object> createPost(@PathVariable int id,@RequestBody Post post) {
		
		Optional <User> userOptional =userRepository.findById(id);
		if(!userOptional.isPresent()) {
			throw new UserNotFoundException("id with "+ id+" is not found");
		}
		User user = userOptional.get();
		post.setUser(user);
		postRepository.save(post);

		URI location =ServletUriComponentsBuilder.
				fromCurrentRequest().
				path("/{id}").
				buildAndExpand(post.getId()).toUri();
		return ResponseEntity.created(location).build();
		
	}
	
}
