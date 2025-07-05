package br.com.booksearch.booksearch.models;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public record ResultadosRecord(@JsonAlias("count") Integer conta,
                               @JsonAlias("results") List<LivroRecord> resultados){
}
