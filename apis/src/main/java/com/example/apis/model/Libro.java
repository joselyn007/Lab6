package com.example.apis.model;

public class Libro {
    private Long id;
    private String titulo;
    private String autor;
    private String isbn;
    private Integer añopub;
    private String estado;

    public Libro(Long id, String titulo, String autor, String isbn, Integer añopub, String estado) {
        this.id = id;
        this.titulo = titulo;
        this.autor = autor;
        this.isbn = isbn;
        this.añopub = añopub;
        this.estado = estado;
        
    }
// ------------------------------------------------------------
    public void setId(Long id) {
        this.id = id;
    }
    public Long getId() {
        return id;
    }
// ------------------------------------------------------------
    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }
    public String getTitulo() {
        return titulo;
    }
// ------------------------------------------------------------
    public void setAutor(String autor) {
        this.autor = autor;
    }
    public String getAutor() {
        return autor;
    }
// ------------------------------------------------------------
    public void setIsbn(String isbn){
        this.isbn = isbn;
    }
    public String  getIsbn() {
        return isbn;
    }

// ------------------------------------------------------------
    public void setAñopub(Integer añopub) {
        this.añopub = añopub;
    }
    public Integer getAñopub() {
        return añopub;
    }
// ------------------------------------------------------------
    public void setEstado(String estado) {
        this.estado = estado;
    }
    public String getEstado() {
        return estado;
    }

}
