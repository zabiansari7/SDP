package de.srh.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import de.srh.models.User;
import de.srh.repository.UserRepository;


@Service
public class UserService {
	
	private final UserRepository userRepository;
	
    @Autowired
	public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }
    
    public User saveUser(User user) {
        // Implement any additional logic before adding the user, if needed
    	
        return userRepository.save(user);
    }
	
}