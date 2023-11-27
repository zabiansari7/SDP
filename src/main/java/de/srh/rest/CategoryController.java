package de.srh.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import de.srh.models.Category;
import de.srh.services.CategoryService;

@RestController
@RequestMapping("/api/categories")
public class CategoryController {
	 private final CategoryService categoryService;

	    @Autowired
	    public CategoryController(CategoryService categoryService) {
	        this.categoryService = categoryService;
	    }

	    @PostMapping("/add")
	    public Category addCategory(@RequestBody Category category) {
	        return categoryService.addCategory(category);
	    }
}
