package org.generation.italy.pizza.demo.service;

import java.util.List;
import java.util.Optional;

import org.generation.italy.pizza.demo.pojo.Promotion;
import org.generation.italy.pizza.demo.repo.PromotionRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PromotionService {
	
	//indichiamo la dipendenza da iniettare
		@Autowired
		private PromotionRepo promotionRepo;
		
		//funzione per salvare/inserire un record
		public void save(Promotion promotion) {
			
			//grazie all'interfaccia JpaRepository possiamo usare il method save
			promotionRepo.save(promotion);
		}
		
		//funzione per prendere tutti i record
		public List<Promotion> findAll() {
			
			//ritorniamo una lista di record
			return promotionRepo.findAll();
		}
		
		//funzione per recuperare un record specifico in base all'id
			//utilizzeremo l'Optional<Pizza> per controllare se un valore è presente o non 
		public Optional<Promotion> findPizzaByID(int id){
			
			return promotionRepo.findById(id);
		}
		
		//funzione per l'elimanazione di un record
		public void delete(Promotion promotion) {
			//grazie all'interfaccia JpaRepository possiamo usare il method delete
			promotionRepo.delete(promotion);
		}
		
		
	}