package org.generation.italy.demo;

import org.generation.italy.demo.pojo.Drink;
import org.generation.italy.demo.pojo.Pizza;
import org.generation.italy.demo.service.Drinkservice;
import org.generation.italy.demo.service.Pizzaservice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpringLaMiaPizzeriaCrudApplication implements CommandLineRunner {
	
	@Autowired
	private Pizzaservice pizzaService;
	
	@Autowired
	private Drinkservice drinkService;
	
	public static void main(String[] args) {
		SpringApplication.run(SpringLaMiaPizzeriaCrudApplication.class, args);
	}

	
	@Override
	public void run(String... args) throws Exception {
		

		Pizza p1 = new Pizza("Margherita", "Pomodoro e mozzarella", 7);
		Pizza p2 = new Pizza("Marco", "Pomodoro, burrata, pesto", 8);
		Pizza p3 = new Pizza("Prosciutto", "Pomodoro, prosciutto e mozzarella", 9);
		Pizza p4 = new Pizza("Salame", "Pomodoro, salame e mozzarella", 7);
		Pizza p5 = new Pizza("Diavola", "Pomodoro, salame piccante e mozzarella", 19);

		pizzaService.save(p1);
		pizzaService.save(p2);
		pizzaService.save(p3);
		pizzaService.save(p4);
		pizzaService.save(p5);
		
		Drink d1 = new Drink("Moscow Mule", "Vodka, Lime, Ginger, Ice", 11);
		Drink d2 = new Drink("Hugo", "prosecco, elderflower syrup, seltz and mint leaves", 12);
		Drink d3 = new Drink("Spritz", "vino bianco frizzante (solitamente prosecco), un bitter come Aperol, Campari", 15);
		Drink d4 = new Drink("Gin Tonic", "Gin, acqua tonica", 7);
		Drink d5 = new Drink("Gin Lemon", "Gin Mare, lemon", 13);

		drinkService.save(d1);
		drinkService.save(d2);
		drinkService.save(d3);
		drinkService.save(d4);
		drinkService.save(d5);
		
	}

}
