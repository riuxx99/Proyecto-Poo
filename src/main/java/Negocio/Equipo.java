/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Negocio;

/**
 *
 * @author fabian
 */
public class Equipo {
    private String nombre;
    private boolean local = false;
    
    public Equipo(){
        
    }
    public Equipo(String nombre, boolean local){
        this.nombre = nombre;
        this.local = local;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public boolean isLocal() {
        return local;
    }

    public void setLocal(boolean local) {
        this.local = local;
    }

    @Override
    public String toString() {
        return "Equipo{" + "nombre=" + nombre + ", local=" + local + '}';
    }
    
    
}
