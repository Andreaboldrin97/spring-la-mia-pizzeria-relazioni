package org.generation.italy.pizza.demo;


import java.time.LocalDate;
import java.util.List;

import org.generation.italy.pizza.demo.pojo.Drink;
import org.generation.italy.pizza.demo.pojo.Pizza;
import org.generation.italy.pizza.demo.pojo.Promotion;
import org.generation.italy.pizza.demo.service.DrinkService;
import org.generation.italy.pizza.demo.service.PizzaService;
import org.generation.italy.pizza.demo.service.PromotionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication							//IMPLEMENTIAMO
public class SpringLaMiaPizzeriaCrudApplication implements CommandLineRunner{

	
	public static void main(String[] args) {
		SpringApplication.run(SpringLaMiaPizzeriaCrudApplication.class, args);
	}

	//DIPENDENSE
	@Autowired
	private PizzaService pizzaServ;
	
	@Autowired
	private DrinkService drinkServ;
	
	@Autowired
	private PromotionService promotionService;
	
	//DATI FAKER
	@Override
	public void run(String... args) throws Exception {
		
		//promotions
		Promotion prom1 = new  Promotion(LocalDate.parse("2022-12-13"), LocalDate.parse("2022-12-31"), "rebix promotion");
		Promotion prom2 = new  Promotion(LocalDate.parse("2022-12-13"), LocalDate.parse("2022-12-31"), "rebix promotion2");
		
		promotionService.save(prom1);
		promotionService.save(prom2);
		
		// pizza
		Pizza p1 = new Pizza("pizza1", "my p1 desc", 10 , prom1);
		Pizza p2 = new Pizza("pizza2", "my p2 desc", 22, prom1);
		Pizza p3 = new Pizza("pizza3", "my p3 desc", 4, null);
		Pizza p4 = new Pizza("pizza4", "my p4 desc", 12, prom2);
	
		pizzaServ.save(p1);
		pizzaServ.save(p2);
		pizzaServ.save(p3);
		pizzaServ.save(p4);
		
		// drink
		Drink d1 = new Drink("drink 1", "desc drink 1", 10);
		Drink d2 = new Drink("drink 2", "desc drink 2", 12);
		Drink d3 = new Drink("drink 3", "desc drink 3", 10);
		Drink d4 = new Drink("drink 4", "desc drink 4", 20);
		
		drinkServ.save(d1);
		drinkServ.save(d2);
		drinkServ.save(d3);
		drinkServ.save(d4);
		
		// test 
		
		//test promozione delete 
//							//usiamo questo metedo per prendere l'elemento by id
//		promotionService.delete(promotionService.findPromotionByID(2).get());
//		//pizzaServ.delete(p4);
//		
//		//test pizza + promozione
//		System.err.println("-----------------------------------------------------------");
//		List<Pizza> allPizza = pizzaServ.findAll();
//		
//		for(Pizza pizza : allPizza) {
//			
//			System.out.println(pizza +"\n\t" + pizza.getPromotion());
//		}
//		System.err.println("-----------------------------------------------------------");
//		
//		//test promozione + pizza
//		System.err.println("-----------------------------------------------------------");
//		List<Promotion> promotions = promotionService.findAllPizza();
//		
//		for( Promotion promotion : promotions) {
//			
//			System.out.println(promotion);
//			
//			for (Pizza pizza : promotion.getAllPizza()) {
//				System.out.println("\t" + pizza);
//			}
//		}
//		System.err.println("-----------------------------------------------------------");
//		
		
	}
}
