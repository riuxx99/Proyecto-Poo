/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Negocio;
import java.util.ArrayList;
/**
 *
 * @author fabian
 */
public class Torneo {
    //Defino los atributos de la clase
    private String nombre;
    private String fechaInicio;
    private String fechaFin;
    private ArrayList<Partido> myPartidos;
    
    //Realizo el constructor
    public Torneo(){
        
    }

    public Torneo(String nombre) {
        this.nombre = nombre;
        this.fechaInicio = null;
        this.fechaFin = null;
        this.myPartidos = new ArrayList<>();
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

    public ArrayList<Partido> getMyPartidos() {
        return myPartidos;
    }
    public void añadirPartido(Partido p){
        this.myPartidos.add(p);
    }

    @Override
    public String toString() {
        return "Torneo: \n nombre=" + nombre + "\n Fecha de Inicio=" + fechaInicio + "\n Fecha de Finalizacion=" + fechaFin + "\n Partidos=" + myPartidos;
    }
    
}
