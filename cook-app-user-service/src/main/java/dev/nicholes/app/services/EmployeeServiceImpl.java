package dev.nicholes.app.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import dev.nicholes.app.beans.Category;
import dev.nicholes.app.beans.Ingredient;
import dev.nicholes.app.data.CategoryRepository;
import dev.nicholes.app.data.IngredientRepository;

@Service
public class EmployeeServiceImpl implements EmployeeService {
	private CategoryRepository categoryDao;
	private IngredientRepository ingredientDao;
	
	@Autowired
	public EmployeeServiceImpl(CategoryRepository categoryDao, IngredientRepository ingredientDao) {
		this.categoryDao = categoryDao;
		this.ingredientDao = ingredientDao;
	}

	@Override
	public List<Category> getAllCategories() {
		return categoryDao.findAll();
	}

	@Override
	public Integer addIngredient(Ingredient ingredient) {
		return ingredientDao.save(ingredient).getId();
	}

	@Override
	public void editIngredient(Ingredient ingredient) {
		ingredientDao.save(ingredient);
	}

	@Override
	public void deleteIngredient(Ingredient ingredient) {
		ingredientDao.delete(ingredient);
	}

}
