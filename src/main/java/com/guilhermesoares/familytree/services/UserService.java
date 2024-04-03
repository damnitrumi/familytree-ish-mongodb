package com.guilhermesoares.familytree.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.guilhermesoares.familytree.domain.User;
import com.guilhermesoares.familytree.dto.FamilyDTO;
import com.guilhermesoares.familytree.dto.UserDTO;
import com.guilhermesoares.familytree.repository.UserRepository;
import com.guilhermesoares.familytree.services.exception.ObjectNotFoundException;

@Service
public class UserService {
	
	@Autowired
	private UserRepository repo;
	
	public List<User> findAll(){
		return repo.findAll();
	}
	
	public User findById(String id) {
		Optional<User> obj = repo.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException("Object Not Found"));
	}
	
	public User insert(User obj) {
		return repo.insert(obj);
	}
	
	public User fromDto(UserDTO objDto) {
		return new User(objDto.getId(), objDto.getName(), objDto.getAge());
	}
	
	public void addFamily(String id, FamilyDTO family) {
		User user = repo.findById(id).orElseThrow(() -> new ObjectNotFoundException("Object Not Found"));
		user.getFamily().add(family);
		repo.save(user);
	}
	
	public void delete(String id) {
		//Esse find by id é literalmente só para verificar se o elemento com o id existe, por isso não retornamos para variável nenhuma, se não existir o erro ObjectNotFoundException é lançado, se existir simplesmente continua a execução
		findById(id);
		repo.deleteById(id);
	}
	
	public void update(String id, UserDTO jsonUserDto) {
		User dtbUser = findById(id);
		updateData(dtbUser, jsonUserDto);
		repo.save(dtbUser);
	}
	
	public void updateData(User dtbUser, UserDTO userDto) {
		dtbUser.setName(userDto.getName());
		dtbUser.setAge(userDto.getAge());
	}
}
