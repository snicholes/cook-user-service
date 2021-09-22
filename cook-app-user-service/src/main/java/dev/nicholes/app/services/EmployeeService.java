package dev.nicholes.app.services;

import java.util.List;

import dev.nicholes.app.beans.Category;
import dev.nicholes.app.beans.Ingredient;

public interface EmployeeService {
	public List<Category> getAllCategories();
	public Integer addIngredient(Ingredient ingredient);
	public void editIngredient(Ingredient ingredient);
	public void deleteIngredient(Ingredient ingredient);
}
