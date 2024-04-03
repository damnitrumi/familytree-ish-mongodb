package com.guilhermesoares.familytree.config;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import com.guilhermesoares.familytree.domain.User;
import com.guilhermesoares.familytree.dto.FamilyDTO;
import com.guilhermesoares.familytree.dto.UserDTO;
import com.guilhermesoares.familytree.repository.UserRepository;

@Configuration
public class Instantiation implements CommandLineRunner{
	
	@Autowired
	private UserRepository userRepository;

	@Override
	public void run(String... args) throws Exception {
		
		userRepository.deleteAll();
		
		User guilherme = new User(null, "Guilherme", 28);
		User luiz = new User(null, "Luiz", 28);
		
		userRepository.saveAll(Arrays.asList(guilherme, luiz));
		
		FamilyDTO p1 = new FamilyDTO(new UserDTO("Jurandir", 64));
		FamilyDTO p2 = new FamilyDTO(new UserDTO("Célia", 46));
		FamilyDTO p3 = new FamilyDTO(new UserDTO("Mavih", 17));
		
		guilherme.getFamily().addAll(Arrays.asList(p1, p2, p3));
		userRepository.save(guilherme);
	}

}
