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
public class Aficionado{
    
    //Declaramos los atributos de la clase Aficionado
    private int cedula;
    private String nombre;
    private String apellido;
    private String correo;
    private int telefono;
    private String fechaNacimiento;
    private String tipoAficionado;
    private ArrayList<PlanComprado> myPlanesComprados;
    
    //Realizamos el constructor
    public Aficionado(){
        
    }
    public Aficionado(int cedula, String nombre, String apellido, String correo, int telefono, String fechaNacimiento, String tipoAficionado) {
        
        this.cedula = cedula;
        this.nombre = nombre;
        this.apellido = apellido;
        this.correo = correo;
        this.telefono = telefono;
        this.fechaNacimiento = fechaNacimiento;
        this.tipoAficionado = tipoAficionado;
        this.myPlanesComprados = new ArrayList<PlanComprado>();
    }
    
    //Declaramos los gettters, los setters y el toString

    public int getCedula() {
        return cedula;
    }

    public void setCedula(int cedula) {
        this.cedula = cedula;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public int getTelefono() {
        return telefono;
    }

    public void setTelefono(int telefono) {
        this.telefono = telefono;
    }

    public String getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(String fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    public String getTipoAficionado() {
        return tipoAficionado;
    }

    public void setTipoAficionado(String tipoAficionado) {
        this.tipoAficionado = tipoAficionado;
    }
    //Añadir Plan Comprado a aficionado
    public void añadirPlan(PlanComprado plan){
        this.myPlanesComprados.add(plan);
    }

    @Override
    public String toString() {
        return "Aficionado: \n cedula=" + cedula + "\n nombre=" + nombre + "\n apellido=" + apellido + "\n correo=" + correo + "\n telefono=" + telefono + "\n Fecha de Nacimiento=" + fechaNacimiento + 
                "\n Tipo de Aficionado=" + tipoAficionado + "\n Planes comprados= " + myPlanesComprados;
    }
    
    
    
}
