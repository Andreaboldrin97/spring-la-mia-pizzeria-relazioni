package org.generation.italy.pizza.demo.pojo;

import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
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
	
	//costrutti 
	public Promotion() {}
	
	public Promotion(LocalDate starting_date, LocalDate end_date, String title) {
		
		setStarting_date(starting_date);
		setEnd_date(end_date);
		setTitle(title);
		
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
	
	
}
