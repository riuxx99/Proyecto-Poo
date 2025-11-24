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
public class Partido {
    
    //Defino los atributos de la clase
    private int id;
    private String fecha;
    private String hora;
    private String equipoLocal;
    private String equipoVisitante;
    private String estado;
    private ArrayList<String> puestosVendidos;
    //Realizo los constructors
    public Partido(){
        
    }

    public Partido(int id,String fecha, String hora, String equipoLocal, String equipoVisitante) {
        this.id= id;
        this.fecha = fecha;
        this.hora = hora;
        this.equipoLocal = equipoLocal;
        this.equipoVisitante = equipoVisitante;
        this.estado = "Activo";
        this.puestosVendidos = new ArrayList<>();
    }
    //Setters y getters de la clase
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public String getHora() {
        return hora;
    }

    public void setHora(String hora) {
        this.hora = hora;
    }

    public String getEquipoLocal() {
        return equipoLocal;
    }

    public void setEquipoLocal(String equipoLocal) {
        this.equipoLocal = equipoLocal;
    }

    public String getEquipoVisitante() {
        return equipoVisitante;
    }

    public void setEquipoVisitante(String equipoVisitante) {
        this.equipoVisitante = equipoVisitante;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public ArrayList<String> getPuestosVendidos() {
        return puestosVendidos;
    }

    public void setPuestosVendidos(ArrayList<String> puestosVendidos) {
        this.puestosVendidos = puestosVendidos;
    }
    public void añadirVentaPuesto(String puesto){
        this.puestosVendidos.add(puesto);
    }

    @Override
    public String toString() {
        return "\n" +this.getId() +"\t"+ fecha + "\t" + hora + "\t" + equipoLocal + "\t" + equipoVisitante + "\t\t" + estado;
    }
    public String toStringMasVendidos() {
        return "\n" +this.getId() +"\t"+ fecha + "\t" + hora + "\t" + equipoLocal + "\t" + equipoVisitante + "\t\t" + puestosVendidos.size();
    }
    
}
