package com.example.apis.model;

public class Hotel {
    private Long id;              
    private String nomCliente;
    private String habitacion;
    private String fechEntrada;
    private String fechSalida;
    private String estado;

    public Hotel(Long id, String nomCliente, String habitacion, String fechEntrada, String fechSalida, String estado){
        this.id = id;
        this.nomCliente = nomCliente;
        this.habitacion = habitacion;
        this.fechEntrada = fechEntrada;
        this.fechSalida = fechSalida;
        this.estado = estado;
    }
    
// --------------------------------------------------
    public void setId(Long id) {
        this.id = id;
    }
    public Long getId() {
        return id;
    }
// --------------------------------------------------
    public void setNomCliente(String nomCliente){
        this.nomCliente = nomCliente;
    }  
    public String getNomCliente(){
        return nomCliente;
    }  
// --------------------------------------------------
    public void setHabitacion(String habitacion){
        this.habitacion = habitacion;
    }
    public String getHabitacion(){
        return habitacion;
    }
// --------------------------------------------------
    public void setFechEntrada(String fechEntrada){
        this.fechEntrada = fechEntrada;
    }
    public String getFechEntrada(){
        return fechEntrada;
    }

// --------------------------------------------------
    public void setFechSalida(String fechSalida){
        this.fechSalida = fechSalida;
    }
    public String getFechSalida(){
        return fechSalida;
    }
// --------------------------------------------------
    public void setEstado(String estado){
        this.estado = estado;
    }
    public String getEstado(){
        return estado;
    } 

}
