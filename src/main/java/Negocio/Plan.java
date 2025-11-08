/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Negocio;

/**
 *
 * @author fabian
 */
public class Plan {
    
    //Defino los atributos
    private String nombre;
    private float precio;
    private String torneo;
    
    //Realizo el constructor
    public Plan(){
        
    }

    public Plan(String nombre, float precio, String torneo) {
        this.nombre = nombre;
        this.precio = precio;
        this.torneo = torneo;
    }
    
    //Defino los getters, setters y toString

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public float getPrecio() {
        return precio;
    }

    public void setPrecio(float precio) {
        this.precio = precio;
    }

    public String getTorneo() {
        return torneo;
    }

    public void setTorneo(String torneo) {
        this.torneo = torneo;
    }

    @Override
    public String toString() {
        return "Plan: \n nombre=" + nombre + "\n precio=" + precio + "\n torneo=" + torneo;
    }
    
}
