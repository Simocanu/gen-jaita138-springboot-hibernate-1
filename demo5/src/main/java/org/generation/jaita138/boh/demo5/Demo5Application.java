package org.generation.jaita138.boh.demo5;

import java.util.List;

import org.generation.jaita138.boh.demo5.cli.CliManager;
import org.generation.jaita138.boh.demo5.db.entity.Role;
import org.generation.jaita138.boh.demo5.db.entity.Utente;
import org.generation.jaita138.boh.demo5.db.service.RoleService;
import org.generation.jaita138.boh.demo5.db.service.UtenteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Demo5Application implements CommandLineRunner {

	@Autowired
	private UtenteService utenteService;

	@Autowired
	private RoleService roleService;

	public static void main(String[] args) {
		SpringApplication.run(Demo5Application.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		new CliManager(utenteService, roleService);
	}

	private void test1() {

		System.out.println("Hello, World!");
		System.out.println("--------------------------------");

		Role adminRole = new Role();
		adminRole.setTitolo("ADMIN");
		adminRole.setDescrizione("Amministratore del sistema");
		roleService.save(adminRole);

		Role userRole = new Role();
		userRole.setTitolo("USER");
		userRole.setDescrizione("Utente standard");
		roleService.save(userRole);

		System.out.println("Ruoli inizializzati.");
		System.out.println("--------------------------------");

		Utente u1 = new Utente();
		u1.setNome("Utente 1");
		u1.setCognome("Cognome 1");
		u1.setUsername("utente1");
		u1.setPassword("password1");
		u1.setCredito(1000);
		u1.setRole(adminRole);

		System.out.println("U1 before save");
		System.out.println(u1);
		System.out.println("--------------------------------");

		utenteService.save(u1);

		System.out.println("U1 after save");
		System.out.println(u1);
		System.out.println("--------------------------------");

		List<Utente> utenti = utenteService.findAll();

		System.out.println("Lista utenti");
		System.out.println(utenti);
		System.out.println("--------------------------------");

		System.out.println("--------------------------------");
		System.out.println("The end");
	}
}
