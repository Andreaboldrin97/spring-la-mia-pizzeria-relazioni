package org.generation.italy.pizza.demo.repo;

import org.generation.italy.pizza.demo.pojo.Ingredient;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IngredientRepo extends JpaRepository< Ingredient, Integer> {

}
