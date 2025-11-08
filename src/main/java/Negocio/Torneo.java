/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Negocio;

/**
 *
 * @author fabian
 */
public class Torneo {
    //Defino los atributos de la clase
    private String nombre;
    private String fechaInicio;
    private String fechaFin;
    private Partido myPartidos;
    
    //Realizo el constructor
    public Torneo(){
        
    }

    public Torneo(String nombre, String fechaInicio, String fechaFin) {
        this.nombre = nombre;
        this.fechaInicio = fechaInicio;
        this.fechaFin = fechaFin;
    }
    
    //Defino los getters, setters y toString

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getFechaInicio() {
        return fechaInicio;
    }

    public void setFechaInicio(String fechaInicio) {
        this.fechaInicio = fechaInicio;
    }

    public String getFechaFin() {
        return fechaFin;
    }

    public void setFechaFin(String fechaFin) {
        this.fechaFin = fechaFin;
    }

    @Override
    public String toString() {
        return "Torneo: \n nombre=" + nombre + "\n Fecha de Inicio=" + fechaInicio + "\n Fecha de Finalizacion=" + fechaFin + "\n Partidos=" + myPartidos;
    }
    
}
