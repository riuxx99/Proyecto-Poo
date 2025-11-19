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
    private String fecha;
    private String hora;
    private String equipoLocal;
    private String equipoVisitante;
    private String estado;
   
    //Realizo los constructors
    public Partido(){
        
    }

    public Partido(String fecha, String hora, String equipoLocal, String equipoVisitante) {
        this.fecha = fecha;
        this.hora = hora;
        this.equipoLocal = equipoLocal;
        this.equipoVisitante = equipoVisitante;
        this.estado = "Activo";
    }
    
    //Defino los getters, setters y toString

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
    

    @Override
    public String toString() {
        return "\n" + this.getFecha() + "\t" + hora + "\t" + equipoLocal + "\t" + equipoVisitante + "\t\t" + estado;
    }
    
}
