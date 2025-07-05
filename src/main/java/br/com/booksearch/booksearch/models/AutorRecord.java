package br.com.booksearch.booksearch.models;

import com.fasterxml.jackson.annotation.JsonAlias;

public record AutorRecord(@JsonAlias("name") String nome,
                          @JsonAlias("birth_year") Integer anoNascimento,
                          @JsonAlias("death_year") Integer anoFalecimento){

}
