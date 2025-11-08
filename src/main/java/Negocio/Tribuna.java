/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Negocio;
import java.util.ArrayList;
/**
 *
 * @author IAN
 */
public class Tribuna {
    
    //Defino los atributos de la clase
    private String id;
    private String nombre;
    private float precioBase;
    private ArrayList<Puesto> myPuestos;
    
    //Realizo el constructor
    public Tribuna(){
        this.myPuestos = new ArrayList<Puesto> ();
    }

    public Tribuna(String id, String nombre, float precioBase) {
        this.id = id;
        this.nombre = nombre;
        this.precioBase = precioBase;
    }
    
    //Defino los getters, setters y toString

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public float getPrecioBase() {
        return precioBase;
    }

    public void setPrecioBase(float precioBase) {
        this.precioBase = precioBase;
    }

    public ArrayList<Puesto> getMyPuestos() {
        return myPuestos;
    }

    public void setMyPuestos(ArrayList<Puesto> myPuestos) {
        this.myPuestos = myPuestos;
    }

    @Override
    public String toString() {
        return "Tribuna: \n id=" + id + "\n nombre=" + nombre + "\n precioBase=" + precioBase;
    }
    
}
