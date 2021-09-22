package dev.nicholes.app.data;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import dev.nicholes.app.beans.Category;
import dev.nicholes.app.beans.Ingredient;

@Repository
public interface IngredientRepository extends JpaRepository<Ingredient, Integer> {
	public List<Ingredient> findByCategory(Category category);
}
