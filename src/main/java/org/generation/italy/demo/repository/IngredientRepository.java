package org.generation.italy.demo.repository;

import org.generation.italy.demo.pojo.Ingredient;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IngredientRepository extends JpaRepository<Ingredient, Integer>{

}
