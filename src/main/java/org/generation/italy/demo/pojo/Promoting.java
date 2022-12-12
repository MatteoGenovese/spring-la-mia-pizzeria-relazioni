package org.generation.italy.demo.pojo;

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
public class Promoting {
		
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@Column
	private String title;
	
	@Column
	@NotNull
	private LocalDate startDate;
	
	@Column
	@NotNull
	private LocalDate endDate;
	
	@ManyToOne
	@JoinColumn(nullable = false)
	private Pizza pizza;
	
	public Promoting() { }
	public Promoting(String title, String startDate,String endDate, Pizza pizza) {
		setTitle(title);
		setStartDate(startDate);
		setEndDate(endDate);
		setPizza(pizza);
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}


	public String getTitle() {
		return title;
	}


	public void setTitle(String title) {
		this.title = title;
	}


	public String getStartDate() {
		
		return startDate.toString();
	}


	public void setStartDate(String startDate) {

		this.startDate = LocalDate.parse(startDate);
	}


	public String getEndDate() {
		return endDate.toString();
	}


	public void setEndDate(String endDate) {
		this.endDate = LocalDate.parse(endDate);
	}
	
	
	
	public Pizza getPizza() {
		return pizza;
	}
	public void setPizza(Pizza pizza) {
		this.pizza = pizza;
	}
	@Override
	public String toString() {
		return "(" + 
				getId()+") "+ 
				getTitle() + " - " +
				getStartDate() + " - " +
				getEndDate() + " - " +
				getPizza();
	}
	
	
	
}
