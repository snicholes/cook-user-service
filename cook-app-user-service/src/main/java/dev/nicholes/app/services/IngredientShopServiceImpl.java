package dev.nicholes.app.services;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import dev.nicholes.app.beans.Ingredient;
import dev.nicholes.app.beans.OwnedIngredient;
import dev.nicholes.app.beans.Person;
import dev.nicholes.app.data.IngredientRepository;
import dev.nicholes.app.data.PersonRepository;

@Service
public class IngredientShopServiceImpl implements IngredientShopService {
	private IngredientRepository ingredientDao;
	private PersonRepository personDao;
	
	@Autowired
	public IngredientShopServiceImpl(IngredientRepository ingredientDao,
			PersonRepository personDao) {
		this.ingredientDao = ingredientDao;
		this.personDao = personDao;
	}

	@Override
	public List<Ingredient> getIngredients() {
		return ingredientDao.findAll();
	}

	@Override
	public Ingredient getIngredientById(Integer id) {
		return ingredientDao.getOne(id);
	}

	@Override
	public void purchaseIngredient(Ingredient ingredient, Person person) {
		List<Ingredient> ownedIngredients = person.getIngredients()
				.stream()
				.map(owned -> owned.getIngredient())
				.collect(Collectors.toList());
		
		if (!ownedIngredients.contains(ingredient)) {
			OwnedIngredient newIngredient = new OwnedIngredient();
			newIngredient.setIngredient(ingredient);
			newIngredient.setQuantity(1);
			
			List<OwnedIngredient> ingredients = person.getIngredients();
			ingredients.add(newIngredient);
			person.setIngredients(ingredients);
		} else {
			person.setIngredients(
					person.getIngredients()
					.stream()
					.map(owned -> {
						if (owned.getIngredient().equals(ingredient)) {
							owned.setQuantity(owned.getQuantity()+1);
							return owned;
						} else {
							return owned;
						}
					})
					.collect(Collectors.toList()));
		}
		
		personDao.save(person);
	}

}
