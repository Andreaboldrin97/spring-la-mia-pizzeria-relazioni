package org.generation.italy.pizza.demo.service;

import java.util.List;
import java.util.Optional;

import org.generation.italy.pizza.demo.pojo.Ingredient;
import org.generation.italy.pizza.demo.repo.IngredientRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class IngredientService {

	//indichiamo la dipendenza da iniettare
	@Autowired
	private IngredientRepo ingredientRepo;
	
	//funzione per salvare/inserire un record
			public void save(Ingredient  ingredient) {
				
				//grazie all'interfaccia JpaRepository possiamo usare il method save
				ingredientRepo.save(ingredient);
			}
			
			//funzione per prendere tutti i record
			public List<Ingredient> findAll() {
				
				//ritorniamo una lista di record
				return ingredientRepo.findAll();
			}
			
			//funzione per recuperare un record specifico in base all'id
				//utilizzeremo l'Optional<Pizza> per controllare se un valore è presente o non 
			public Optional<Ingredient> findPromotionByID(int id){
				
				return ingredientRepo.findById(id);
			}
			
			//funzione per l'elimanazione di un record
			public void delete(Ingredient ingredient) {
				//grazie all'interfaccia JpaRepository possiamo usare il method delete
				ingredientRepo.delete(ingredient);
			}
}
