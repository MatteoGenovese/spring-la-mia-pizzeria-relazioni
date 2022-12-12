package org.generation.italy.demo;

import java.time.LocalDate;

import org.generation.italy.demo.pojo.Drink;
import org.generation.italy.demo.pojo.Pizza;
import org.generation.italy.demo.pojo.Promoting;
import org.generation.italy.demo.service.Drinkservice;
import org.generation.italy.demo.service.Pizzaservice;
import org.generation.italy.demo.service.PromotingService;
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
	
	@Autowired
	private PromotingService promotingService;
	
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
		
		Promoting pro1 = new Promoting("drink metà prezzo", LocalDate.now().toString(),"2022-12-16",p2);
		Promoting pro2 = new Promoting("pizza metà prezzo", LocalDate.now().toString(),"2022-12-16",p4);
		Promoting pro3 = new Promoting("pizza gratis solo per oggi", LocalDate.now().toString(),"2022-12-16",p3);


		promotingService.save(pro1);
		promotingService.save(pro2);
		promotingService.save(pro3);

		
		for (Promoting promotion : promotingService.findAll())
		{
			System.out.println(promotion);
		}
		
	}

}
