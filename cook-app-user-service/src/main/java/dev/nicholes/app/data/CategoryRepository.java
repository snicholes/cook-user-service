package dev.nicholes.app.data;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import dev.nicholes.app.beans.Category;

@Repository
public interface CategoryRepository extends JpaRepository<Category, Integer> {

}
