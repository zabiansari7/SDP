package de.srh.toolify.services;

import java.time.Instant;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import de.srh.toolify.entities.AddressEntity;
import de.srh.toolify.entities.UserEntity;
import de.srh.toolify.repositories.AddressRepository;
import jakarta.validation.constraints.Email;

@Service
public class AddressService {
	@Autowired
	private AddressRepository addressRepository;
	@Autowired
	private UserRegistrationService userRegistrationService;

	public AddressEntity saveAddress(AddressEntity address) {
		address.setCreatedOn(Instant.now());
		String email = address.getUser().getEmail();
		UserEntity user = userRegistrationService.getUserByEmail(email);
		address.setUser(user);
		return addressRepository.save(address);
	}

	public void deleteAddress(Long addressid) {
		addressRepository.deleteById(addressid);
	}
	
	public Optional<AddressEntity> getAddressById(Long id) {
        return addressRepository.findById(id);
    }
	
	
	
}	