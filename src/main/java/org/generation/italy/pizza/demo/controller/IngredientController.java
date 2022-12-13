package org.generation.italy.pizza.demo.controller;

import java.util.List;

import org.generation.italy.pizza.demo.pojo.Ingredient;
import org.generation.italy.pizza.demo.service.IngredientService;
import org.generation.italy.pizza.demo.service.PizzaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class IngredientController {

	//indichiamo la dipendenza da iniettare
	@Autowired
	private PizzaService pizzaService;
	
	@Autowired
	private IngredientService ingredientService;
	
	//INDEX PROMOTION
	//Indichiamo a quale path fa riferimento questo metodo
	@GetMapping("/ingridient")
	public String getIngredients(Model model) {
		//assegnamo ad un lista i record del db
		List<Ingredient> ingredients = ingredientService.findAllPizza();
		
		model.addAttribute("ingredients", ingredients);
		
		//a quale view fa riferimento
		return "ingredientCRUD/index";
	}
}
