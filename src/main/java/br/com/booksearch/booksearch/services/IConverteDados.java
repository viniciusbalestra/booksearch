package br.com.booksearch.booksearch.services;

public interface IConverteDados {
    <T> T obterDados(String json, Class<T> classe);
}


