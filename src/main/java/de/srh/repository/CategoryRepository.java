package de.srh.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import de.srh.models.Category;

@Repository
public interface CategoryRepository extends JpaRepository<Category, Long> {
   
}
