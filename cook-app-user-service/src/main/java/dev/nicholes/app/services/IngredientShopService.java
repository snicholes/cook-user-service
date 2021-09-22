package dev.nicholes.app.services;

import java.util.List;

import dev.nicholes.app.beans.Ingredient;
import dev.nicholes.app.beans.Person;

public interface IngredientShopService {
	public List<Ingredient> getIngredients();
	public Ingredient getIngredientById(Integer id);
	public void purchaseIngredient(Ingredient ingredient, Person person);
}
