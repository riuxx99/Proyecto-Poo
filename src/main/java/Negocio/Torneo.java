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
    private double valorBasicoBoleta;
    //Realizo el constructor
    public Torneo(){
        
    }

    public Torneo(String nombre) {
        this.nombre = nombre;
        this.fechaInicio = null;
        this.fechaFin = null;
        this.myPartidos = new ArrayList<>();
        this.valorBasicoBoleta = 0F;
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
    
    //Obtener valor boleta
    public double getValorBoleta(){
        return this.valorBasicoBoleta;
    }
    
    //Actualizar el valor de la boleta
    public void setValorBoleta(float valor){
        this.valorBasicoBoleta = valor;
    }
    public ArrayList<Partido> getMyPartidos() {
        return myPartidos;
    }
    public void añadirPartido(Partido p){
        this.myPartidos.add(p);
    }
    //ver si un equipo pertenece a un partido
    public String buscarPartidosEquipo(String equipo){
        String cad = "";
        equipo = equipo.toLowerCase();
        for(Partido p:this.myPartidos){
            if(p.getEquipoLocal().toLowerCase().equals(equipo)||p.getEquipoVisitante().toLowerCase().equals(equipo)){
                cad += p.toString();
            }
        }
        return cad;
    }
    //ver si un equipo tiene partidos para jugar
    public int cantidadPartidos(String equipo){
        int cant = 0;
        equipo = equipo.toLowerCase();
        for(Partido p:this.myPartidos){
            if(p.getEquipoLocal().toLowerCase().equals(equipo)||p.getEquipoVisitante().toLowerCase().equals(equipo)){
                cant +=1;
            }
        }
        return cant;
    }
    @Override
    public String toString() {
        return "Torneo: \n nombre=" + nombre + "\n Fecha de Inicio=" + fechaInicio + "\n Fecha de Finalizacion=" + fechaFin + "\n Partidos=" + myPartidos;
    }
    
}
