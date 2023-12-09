package de.srh.toolify.controllers;

import java.time.Instant;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import de.srh.toolify.dto.ToolifyResponse;
import de.srh.toolify.entities.AddressEntity;
import de.srh.toolify.entities.ProductEntity;
import de.srh.toolify.services.AddressService;
import de.srh.toolify.validators.ValidatorUtil;

@RestController
@RequestMapping("/private/addresses")
public class AddressController {
	
	@Autowired
    private AddressService addressService;
	
	
	@GetMapping(value = "/{addressId}")
	    public Optional<AddressEntity> getAddressById(@PathVariable Long addressId) {
	        return addressService.getAddressById(addressId);
	    }
	
	@PostMapping
	 public ResponseEntity<ToolifyResponse> postAddress(@RequestBody final Map<String, Object> address) {
        AddressEntity addressEntity;
        try {
            addressEntity = (AddressEntity) ValidatorUtil.validate(address, AddressEntity.class);
        } catch (Exception e) {
            return new ResponseEntity<>(
                    new ToolifyResponse(
                            String.format(e.getCause().getLocalizedMessage()),
                            400,
                            HttpStatus.BAD_REQUEST
                    ),
                    HttpStatus.BAD_REQUEST);
        }
        Long newAddressId = addressService.saveAddress(addressEntity).getAddressID();
        return new ResponseEntity<>(
                new ToolifyResponse(
                        String.format("New Address with addressId '%d' created successfully.", newAddressId),
                        201,
                        HttpStatus.CREATED
                ),
                HttpStatus.CREATED);
    }
			
    
	
	@DeleteMapping(value = "/{addressId}")
    public void deleteAddress(@PathVariable Long addressId) {
        addressService.deleteAddress(addressId);
    }
	
	
	
	
}
