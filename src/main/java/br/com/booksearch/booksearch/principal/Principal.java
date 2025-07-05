package br.com.booksearch.booksearch.principal;

import br.com.booksearch.booksearch.models.*;
import br.com.booksearch.booksearch.repository.LivroRepository;
import br.com.booksearch.booksearch.services.ConsomeApi;
import br.com.booksearch.booksearch.services.ConverteDados;


import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Principal {
    static Scanner leitura = new Scanner(System.in);
    private String LINK = "https://gutendex.com/books?search=";
    private ConsomeApi api= new ConsomeApi();
    private ConverteDados converteDados = new ConverteDados();
    private List resultados = new ArrayList<>();
    private LivroRepository livroRepository;

    public Principal(LivroRepository livroRepository) {

        this.livroRepository = livroRepository;
    }

    public void main() {
        int escolha = -1;
        var menu = """
                    ------- MENU -------
                    1 - Buscar livros
                    2 - Listar livros registrados
                    3 - Listar autores registrados
                    4 - Listar autores vivos em determinado ano
                    5 - Listar livros em um determinado idioma
                                    
                    0 - Sair                                 
                    """;


        while (escolha != 0) {
            System.out.println(menu);
            escolha = leitura.nextInt();
            leitura.nextLine();

            switch (escolha) {
                case 0:
                    System.out.println("Saindo...");
                case 1:
                    buscarLivro();
                    break;
                case 2:
                    listarLivrosRegistrados();
                    break;
                case 3:
                    listarAutoresRegistrados();
                    break;
                case 4:
                    listarAutoresVivos();
                    break;
                case 5:
                    listarLivrosPorIdioma();
                    break;
                default:
                    System.out.println("Opção inválida");
                    break;
            }

        }
    }

    private ResultadosRecord buscarWeb() {
        System.out.println("Digite o nome do livro ou autor(a):" );
        var pesquisa = leitura.nextLine().trim().toLowerCase();

        try{
            var json = api.obterDados(LINK + pesquisa.replace(" ", "+"));
            ResultadosRecord resultado = converteDados.obterDados(json, ResultadosRecord.class);
            return resultado;

        } catch (IndexOutOfBoundsException e) {
            System.out.println("Livro ou autor não encontrado, tente novamente.");
        }

        return null;
    }

    private void salvarLivros(Livro livro) {

        livroRepository.save(livro);
    }

    private void buscarLivro() {
        ResultadosRecord resultado = buscarWeb();

        if (resultado != null && !resultado.resultados().isEmpty()) {
            LivroRecord primeiroLivro = resultado.resultados().get(0);

            Livro livro = new Livro(primeiroLivro);
            salvarLivros(livro);
            System.out.println(livro);

        } else {
            System.out.println("Livro não encontrado");
        }
    }

    private void listarLivrosRegistrados() {
       var livros = livroRepository.findAll();

       if(livros.isEmpty()) {
           System.out.println("Nenhum livro encontrado.");
       } else {
           livros.forEach(System.out::println);
       }
    }

    private void listarAutoresRegistrados() {
        List<Livro> livros = livroRepository.findAll();

        if(livros.isEmpty()) {
            System.out.println("Nenhum autor registrado.");
        } else {
            livros.stream()
                    .map(Livro::getAutor)
                    .distinct()
                    .forEach(System.out::println);
        }
    }

    private void listarAutoresVivos() {
        System.out.println("\nDigite o ano: ");

        Integer ano = leitura.nextInt();
        leitura.nextLine();

        List<Autor> autores = livroRepository.findAutoresVivos(ano);

        if(autores.isEmpty()) {
            System.out.println("Nenhum autor vivo neste ano.");
        } else {
            autores.forEach(System.out::println);
        }
    }

    private void listarLivrosPorIdioma() {
        System.out.println("""
                Escolha o idioma: 
                - Espanhol
                - Inglês
                - Francês
                - Português
                """);

        var idioma = leitura.nextLine();
        IdiomaEnum idiomaEnum = IdiomaEnum.fromStringPortugues(idioma);

        List<Livro> livros = livroRepository.findByIdioma(idiomaEnum);

        if(livros.isEmpty()) {
            System.out.println("Nenhum livro para este idioma.");
        } else{
            livros.forEach(System.out::println);
        }
    }
}