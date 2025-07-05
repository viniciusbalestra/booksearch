package br.com.booksearch.booksearch.models;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public record LivroRecord(
        @JsonAlias("id") Integer id,
        @JsonAlias("title") String titulo,
        @JsonAlias("authors") List<AutorRecord> autor,
        @JsonAlias("languages") List<String> idioma,
        @JsonAlias("download_count") Integer downloads){
}
