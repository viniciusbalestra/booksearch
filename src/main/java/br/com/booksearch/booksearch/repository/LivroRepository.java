package br.com.booksearch.booksearch.repository;

import br.com.booksearch.booksearch.models.Autor;
import br.com.booksearch.booksearch.models.IdiomaEnum;
import br.com.booksearch.booksearch.models.Livro;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface LivroRepository extends JpaRepository<Livro, Long> {
    @Query("SELECT a FROM Autor a WHERE a.anoNascimento <= :ano AND a.anoFalecimento >= :ano")
    List<Autor> findAutoresVivos(@Param("ano")Integer ano);

    List<Livro> findByIdioma(IdiomaEnum idioma);
}
