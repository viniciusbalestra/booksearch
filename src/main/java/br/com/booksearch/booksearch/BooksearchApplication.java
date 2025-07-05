package br.com.booksearch.booksearch;

import br.com.booksearch.booksearch.principal.Principal;
import br.com.booksearch.booksearch.repository.LivroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


@SpringBootApplication
public class BooksearchApplication implements CommandLineRunner{


	@Autowired
	private LivroRepository livroRepository;

	public static void main(String[] args){
		SpringApplication.run(BooksearchApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		Principal principal = new Principal(livroRepository);
		principal.main();
	}

}
