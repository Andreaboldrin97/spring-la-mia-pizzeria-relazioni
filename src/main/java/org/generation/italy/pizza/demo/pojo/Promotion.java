package org.generation.italy.pizza.demo.pojo;

import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;

@Entity
@Table
public class Promotion {

	//variabili d'istanza
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	@NotNull
	private LocalDate starting_date;
	
	@NotNull
	private LocalDate end_date;
	
	@NotNull
	@Column(unique = true)
	private String title;
	
	
	//creiamo la relazione con le pizze
	@ManyToOne
	@JoinColumn(name = "pizza_id")
	private Pizza pizza;
	
	//costrutti 
	public Promotion() {}
	
	public Promotion(LocalDate starting_date, LocalDate end_date, String title, Pizza pizza) {
		
		setStarting_date(starting_date);
		setEnd_date(end_date);
		setTitle(title);
		setPizza(pizza);
	}

	//get & set
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}

	public LocalDate getStarting_date() {
		return starting_date;
	}
	public void setStarting_date(LocalDate starting_date) {
		this.starting_date = starting_date;
	}

	public LocalDate getEnd_date() {
		return end_date;
	}
	public void setEnd_date(LocalDate end_date) {
		this.end_date = end_date;
	}

	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	
	//get & set join

	public Pizza getPizza() {
		return pizza;
	}
	public void setPizza(Pizza pizza) {
		this.pizza = pizza;
	}
	
	
}
