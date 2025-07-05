package br.com.booksearch.booksearch.models;

import jakarta.persistence.*;
import java.util.stream.Collectors;

@Entity
@Table(name="Livros")
public class Livro {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String titulo;
    @ManyToOne(cascade=CascadeType.PERSIST)
    private Autor autor;
    @Enumerated(EnumType.STRING)
    private IdiomaEnum idioma;
    private Integer downloads;

    public Livro() {}

    public Livro(LivroRecord dadosLivro) {
        this.titulo = dadosLivro.titulo();
        this.autor = dadosLivro.autor()
                .stream()
                .map(Autor::new) // Para cada AutorRecord, cria um novo Autor
                .collect(Collectors.toList())
                .get(0);
        this.downloads = dadosLivro.downloads();
        this.idioma = IdiomaEnum.fromString(dadosLivro.idioma().get(0));
    }

    public void setDownloads(Integer downloads) {
        this.downloads = downloads;
    }

    public void setIdioma(IdiomaEnum idioma) {
        this.idioma = idioma;
    }

    public void setAutor(Autor autor) {
        this.autor = autor;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitulo() {
        return titulo;
    }

    public Autor getAutor() {
        return autor;
    }

    public IdiomaEnum getIdioma() {
        return idioma;
    }

    public int getDownloads() {
        return downloads;
    }


    @Override
    public String toString() {
        return  "\nTítulo: " + titulo + '\n' +
                "Autor: " + autor.getNome() + '\n' +
                "Idioma: " + idioma + '\n' +
                "Downloads: " + downloads
                + "\n----------------------";

    }
}
