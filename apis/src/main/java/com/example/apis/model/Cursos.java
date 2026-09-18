package com.example.apis.model;

public class Cursos {
    private Long id;
    private String nombre;
    private String codigo;
    private Integer creditos;
    private String estado;

    public Cursos(Long id, String nombre, String codigo, Integer creditos, String estado) {
        this.id = id;
        this.nombre = nombre;
        this.codigo = codigo;
        this.creditos = creditos;
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
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public String getNombre() {
        return nombre;
    }
// ------------------------------------------------------------
    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }
    public String getCodigo() {
        return codigo;
    }
// ------------------------------------------------------------
    public void setCreditos(Integer creditos) {
        this.creditos = creditos;
    }
    public Integer getCreditos() {
        return creditos;
    }
// ------------------------------------------------------------
    public void setEstado(String estado) {
        this.estado = estado;
    }
    public String getEstado() {
        return estado;
    }

}
