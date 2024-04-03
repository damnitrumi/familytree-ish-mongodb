package com.guilhermesoares.familytree.resources;

import java.net.URI;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.guilhermesoares.familytree.domain.User;
import com.guilhermesoares.familytree.dto.FamilyDTO;
import com.guilhermesoares.familytree.dto.UserDTO;
import com.guilhermesoares.familytree.resources.exception.InvalidUserException;
import com.guilhermesoares.familytree.services.UserService;

@RestController
@RequestMapping(value="/users")
public class UserResource {
	
	@Autowired
	private UserService service;

	@GetMapping
	public ResponseEntity<List<UserDTO>> findAll(){
		List<User> list = service.findAll();
		List<UserDTO> listDto = list.stream().map(x -> new UserDTO(x)).collect(Collectors.toList());
		return ResponseEntity.ok().body(listDto);
	}
	
	@GetMapping(value="/{id}")
	public ResponseEntity<UserDTO> findById(@PathVariable String id){
		UserDTO userDto = new UserDTO(service.findById(id));
		return ResponseEntity.ok().body(userDto);
	}
	
	@PostMapping
	public ResponseEntity<Void> insert(@RequestBody UserDTO userDto){
		User obj = service.fromDto(userDto);
		obj = service.insert(obj);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(obj.getId()).toUri();
		return ResponseEntity.created(uri).build();
	}
	
	@PostMapping(value = "/family/{id}")
	public ResponseEntity<Void> insertFamily(@PathVariable String id, @RequestBody FamilyDTO familyDTO){
		if (familyDTO == null || familyDTO.getName() == null || familyDTO.getAge() == null) {
	        throw new InvalidUserException("Invalid Family Object");
	    };
		service.addFamily(id, familyDTO);
		return ResponseEntity.status(HttpStatus.CREATED).build();
	}
	
	@DeleteMapping(value="/{id}")
	public ResponseEntity<Void> delete(@PathVariable String id){
		service.delete(id);
		return ResponseEntity.noContent().build();
	}
	
	@PutMapping(value = "/{id}")
	public ResponseEntity<Void> update(@PathVariable String id, @RequestBody UserDTO userDTO){
		if (userDTO == null || userDTO.getName() == null || userDTO.getAge() == null) {
	        throw new InvalidUserException("Invalid User Object");
	    };
		service.update(id, userDTO);
		return ResponseEntity.noContent().build();
	}
}
