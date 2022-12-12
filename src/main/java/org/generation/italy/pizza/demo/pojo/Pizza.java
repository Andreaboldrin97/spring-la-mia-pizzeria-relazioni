package org.generation.italy.pizza.demo.pojo;


import org.generation.italy.pizza.demo.pojo.inter.PriceableInterface;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.Lob;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;


@Entity
@Table
public class Pizza implements PriceableInterface {

	//Indichiamo le colonne presenti nella tabella ( variabili d'istanza )
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@NotNull
	@NotEmpty(message = "il nome deve contenere qualcosa")
	@Column(length = 50)
	private String name;
	
	@NotNull
	@NotEmpty(message = "la descrizione deve contenere qualcosa")
	@Column
	@Lob
	private String description;
	
	@Column
	@Min(value=0)
	private int price;
	
	//creiamo la relazione con la promozzioni
	@ManyToOne
	@JoinColumn(name="promotion_id", nullable = true)
	private Promotion promotion;
	
	// indichiamo il costruttore di default
	public Pizza() {};
	
	//creiamo il costruttore 
	public Pizza(String name, String description, int price, Promotion promotion) {

		setName(name);
		setDescription(description);
		setPrice(price);
		setPromotion(promotion);
	}

	//get & set
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}

	//get & set join
	public Promotion getPromotion() {
		return promotion;
	}

	public void setPromotion(Promotion promotion) {
		this.promotion = promotion;
	}
	
	//toString
	@Override
	public String toString() {

		return "Pizza : " + getId() + "-" + getName() + "-" + getDescription() + "-" + getPrice();
	}

	// interface method
		@Override
		public Integer getPrice() {
			// TODO Auto-generated method stub
			return price;
		}

		@Override
		public void setPrice(Integer price) {
			// TODO Auto-generated method stub
			this.price = price;
		}
	
}
