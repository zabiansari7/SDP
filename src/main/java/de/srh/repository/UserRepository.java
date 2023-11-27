package de.srh.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import de.srh.models.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

}
