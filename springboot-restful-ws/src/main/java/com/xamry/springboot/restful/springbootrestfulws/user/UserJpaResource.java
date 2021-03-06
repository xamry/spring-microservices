package com.xamry.springboot.restful.springbootrestfulws.user;

import java.net.URI;
import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.server.mvc.ControllerLinkBuilder;
import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

@RestController
public class UserJpaResource {

	@Autowired
	private UserRepository userRepository;
	
	//users
	//retrieveAllUsers
	@GetMapping(path = "/jpa/users")
	public List<User> retrieveAllUsers() {
		return userRepository.findAll();
	}
	
	//GET /user/{id}
	@GetMapping(path = "/jpa/users/{id}")
	public User retrieveUser(@PathVariable Integer id) {
		Optional<User> user = userRepository.findById(id);
		if(! user.isPresent()) {
			throw new UserNotFoundException("id: " + id);
		}	
		
		return user.get();
	}
	
	// GET /user/{id}
	@GetMapping(path = "/jpa/user/{id}")
	public EntityModel<User>  retrieveUserWithLink(@PathVariable Integer id) {
		Optional<User> user = userRepository.findById(id);
		if (! user.isPresent()) {
			throw new UserNotFoundException("id: " + id);
		}		

		// HATEOAS (Hypermedia As The Engine Of Application State)
		// Send link to retrieve all users along with this specific user.
		EntityModel<User> model = new EntityModel<>(user.get());
		 
		WebMvcLinkBuilder linkTo = WebMvcLinkBuilder.linkTo(ControllerLinkBuilder.methodOn(this.getClass()).retrieveAllUsers());
	 
		model.add(linkTo.withRel("all-users"));
	 
		return model;
		
	}
	
	//POST /users
	
	@PostMapping(path = "/jpa/users")
	public ResponseEntity<User> createUser(@Valid @RequestBody User user) {
		User savedUser = userRepository.save(user);
		
		//Return CREATED and uri of the saved user (Best practice)
		
		//Create URI
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(savedUser.getId()).toUri();
		return ResponseEntity.created(uri).build();
	}
	
	// DELETE /user/{id}
	@DeleteMapping(path = "/jpa/users/{id}")
	public void deleteUser(@PathVariable Integer id) {
		userRepository.deleteById(id);
		
	}	
	
}
