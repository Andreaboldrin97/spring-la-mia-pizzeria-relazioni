package org.generation.italy.pizza.demo.controller;

import java.util.List;

import org.generation.italy.pizza.demo.pojo.Pizza;
import org.generation.italy.pizza.demo.pojo.Promotion;
import org.generation.italy.pizza.demo.service.PizzaService;
import org.generation.italy.pizza.demo.service.PromotionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;


@Controller
public class PromotionController {

	//indichiamo la dipendenza da iniettare
		//@Autowired
		//private PizzaService pizzaService;
		@Autowired
		private PromotionService promotionService;
		
		//INDEX PROMOTION
			//Indichiamo a quale path fa riferimento questo metodo
			@GetMapping("/promotion")
			public String getPromotions(Model model) {
				//assegnamo ad un lista i record del db
				List<Promotion> promotions = promotionService.findAllPizza();
				
				model.addAttribute("promotions", promotions);
				
				for( Promotion promotion : promotions) {		
					for (Pizza pizza : promotion.getAllPizza()) {
						model.addAttribute("pizzas", pizza);
					}
				}
				//a quale view fa riferimento
				return "promotionCRUD/index";
			}
}
