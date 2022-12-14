package org.generation.italy.pizza.demo.controller;

import java.util.List;
import java.util.Optional;

import org.generation.italy.pizza.demo.pojo.Ingredient;
import org.generation.italy.pizza.demo.pojo.Pizza;
import org.generation.italy.pizza.demo.pojo.Promotion;
import org.generation.italy.pizza.demo.service.IngredientService;
import org.generation.italy.pizza.demo.service.PizzaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import jakarta.validation.Valid;

@Controller
public class IngredientController {

	//indichiamo la dipendenza da iniettare
	@Autowired
	private PizzaService pizzaService;
	
	@Autowired
	private IngredientService ingredientService;
	
	//INDEX INGREDIENT
	//Indichiamo a quale path fa riferimento questo metodo
	@GetMapping("/ingredient")
	public String getIngredients(Model model) {
		//assegnamo ad un lista i record del db
		List<Ingredient> ingredients = ingredientService.findAllPizza();
		
		model.addAttribute("ingredients", ingredients);
		
		//a quale view fa riferimento
		return "ingredientCRUD/index";
	}
	
	//CREATE INGREDIENT
	@GetMapping("/ingredient/create")
	public String createIngredient(Model model) {
		
		Ingredient ingredient = new Ingredient();
		model.addAttribute("ingredient", ingredient);
		
		List<Pizza> pizzas = pizzaService.findAll();
		model.addAttribute("pizzas", pizzas);
		
		return "ingredientCRUD/create";
	}
	@PostMapping("/ingredient/store")
	public String storeIngredient(@Valid @ModelAttribute("ingredient") Ingredient ingredient,
			//Intergaccia per la registrazione degli errori 
			BindingResult bindingResult, 
			//Interfaccia secondaria di Model per passare attributi
			RedirectAttributes redirectAttributes) {

		//veriafichiamo la presenza di errori nella compilazione dei campi del form
		//hasErrors() ci ritorna un valore booleano sulla presenza o no di errori
		if(bindingResult.hasErrors()) {
		
			//riportiamo gli errori all'interno della view indicata
			redirectAttributes.addFlashAttribute("errors", bindingResult.getAllErrors());
			
			//ritorniamo al form con gli errori se i dati sono errati
			return "/ingredient/create";
		
		}
		//metodo per otterere le pizze inserite
		List<Pizza> allPizzaChoise = ingredient.getPizza();
		for (Pizza pizza : allPizzaChoise ) {
			//inserisco le pizze da salvare
			pizza.getIngredients().add(ingredient);
			
		}
		
		//metodo per salvare un record
		ingredientService.save(ingredient);
		
		//a quale view ritorna
		return "redirect:/ingredient";
	}
	
	//UPDATE INGREDIENT
		@GetMapping("/ingredient/edit/{id}")
		public String editIngredient(@PathVariable("id") int id, Model model) {
			
			// selezioniamo il record con quell'id
			Optional<Ingredient> optIngredient = ingredientService.findIngredientByID(id);
			Ingredient ingredient  = optIngredient.get();
			model.addAttribute("ingredient", ingredient);
			
			List<Pizza> pizzas = pizzaService.findAll();
			model.addAttribute("pizzas", pizzas);
			
			return "ingredientCRUD/update";
		}
		@PostMapping("/ingredient/update")
		public String updateIngredient(@Valid @ModelAttribute("ingredient") Ingredient ingredient,
				//Intergaccia per la registrazione degli errori 
				BindingResult bindingResult, 
				//Interfaccia secondaria di Model per passare attributi
				RedirectAttributes redirectAttributes) {

			//veriafichiamo la presenza di errori nella compilazione dei campi del form
			//hasErrors() ci ritorna un valore booleano sulla presenza o no di errori
			if(bindingResult.hasErrors()) {
			
				//riportiamo gli errori all'interno della view indicata
				redirectAttributes.addFlashAttribute("errors", bindingResult.getAllErrors());
				
				//ritorniamo al form con gli errori se i dati sono errati
				return "/ingredient/update";
			
			}
			//metodo per otterere le pizze inserite
			List<Pizza> allPizzaChoise = ingredient.getPizza();
			for (Pizza pizza : allPizzaChoise ) {
				//inserisco le pizze da salvare
				pizza.getIngredients().add(ingredient);
				
			}
			
			//metodo per salvare un record
			ingredientService.save(ingredient);
			
			//a quale view ritorna
			return "redirect:/ingredient";
		}
		
		//Indichiamo a quale path fa riferimento questo metodo
				@GetMapping("/ingredient/delete/{id}")
				public String deleteIngredient(@PathVariable("id") int id) {
					
					// selezioniamo il record con quell'id
					Optional<Ingredient> optIngredient = ingredientService.findIngredientByID(id);
					Ingredient ingredient  = optIngredient.get();
					
					//metodo per eliminare un record
					ingredientService.delete(ingredient);
					
					//a quale view ritorna
					return  "redirect:/ingredient";
				}
}
