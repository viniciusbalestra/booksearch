package br.com.booksearch.booksearch.models;

public enum IdiomaEnum {
    INGLES("en", "ingles"),
    PORTUGUES("pt", "portugues"),
    ALEMAO("de", "alemao"),
    FRANCES("fr", "frances"),
    ESPANHOL("es", "espanhol");

    private String idioma;
    private String idiomaPortugues;

    IdiomaEnum(String idioma, String idiomaPortugues) {
        this.idioma = idioma;
        this.idiomaPortugues = idiomaPortugues;
    }

    public static IdiomaEnum fromString(String text) {
        for (IdiomaEnum idiomaEnum : IdiomaEnum.values()) {
            if (idiomaEnum.idioma.equalsIgnoreCase(text)) {
                return idiomaEnum;
            }
        }

        throw new IllegalArgumentException("Nenhum idioma encontrado com a String fornecida: " + text);
    }

    public static IdiomaEnum fromStringPortugues(String text) {
        for (IdiomaEnum idiomaEnum : IdiomaEnum.values()) {
            if (idiomaEnum.idiomaPortugues.equalsIgnoreCase(text)) {
                return idiomaEnum;
            }
        }

        throw new IllegalArgumentException("Nenhum idioma encontrado com a String fornecida: " + text);
    }
}
