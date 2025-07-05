package br.com.booksearch.booksearch.models;

import jakarta.persistence.*;

import java.util.List;
import java.util.stream.Collectors;

@Entity
@Table(name="autores")
public class Autor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
    private Integer anoNascimento;
    private Integer anoFalecimento;
    @OneToMany(mappedBy = "autor", cascade=CascadeType.ALL, fetch = FetchType.EAGER)
    private List<Livro> livro;

    public Autor() {}

    public Autor(AutorRecord dadosAutor) {
        this.nome = dadosAutor.nome();
        this.anoNascimento = dadosAutor.anoNascimento();
        this.anoFalecimento = dadosAutor.anoFalecimento();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public List<Livro> getLivro() {
        return livro;
    }

    public void setLivro(List<Livro> livro) {
        this.livro = livro;
    }

    public String getNome() {
        return nome;
    }

    public int getAnoNascimento() {
        return anoNascimento;
    }

    public int getAnoFalescimento() {
        return anoFalecimento;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setAnoNascimento(Integer anoNascimento) {
        this.anoNascimento = anoNascimento;
    }

    public void setAnoFalescimento(Integer anoFalescimento) {
        this.anoFalecimento = anoFalescimento;
    }

    public List<String> getTitulo() {
        return livro.stream()
                .map(l -> l.getTitulo())
                .collect(Collectors.toList());
    }

    @Override
    public String toString() {
        return  "\n" + nome +
                "\nNascimento: " + anoNascimento +
                "\nFalecimento: " + anoFalecimento +
                "\nLivros: " + getTitulo() + "\n";
    }
}

