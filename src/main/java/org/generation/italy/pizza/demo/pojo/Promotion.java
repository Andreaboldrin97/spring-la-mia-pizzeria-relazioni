package org.generation.italy.pizza.demo.pojo;

import java.time.LocalDate;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
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
	
	
	@OneToMany(mappedBy = "promotion", cascade = CascadeType.ALL)
	private List<Pizza> allPizza;
	
	//costrutti 
	public Promotion() {}
	
	public Promotion(LocalDate starting_date, LocalDate end_date, String title) {
		
		setStartingDate(starting_date);
		setEndDate(end_date);
		setTitle(title);
	}

	//get & set
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}

	public LocalDate getStartingDate() {
		return starting_date;
	}
	public void setStartingDate(LocalDate starting_date) {
		this.starting_date = starting_date;
	}

	public LocalDate getEndDate() {
		return end_date;
	}
	public void setEndDate(LocalDate end_date) {
		this.end_date = end_date;
	}

	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	
	//get & set join
	public List<Pizza> getAllPizza() {
		return allPizza;
	}

	public void setAllPizza(List<Pizza> allPizza) {
		this.allPizza = allPizza;
	}
	
	@Override
	public String toString() {
		return "(" + getId() + ")" + " " + getTitle() + " - " + getStartingDate() + " " + getEndDate();
	}
	
}
