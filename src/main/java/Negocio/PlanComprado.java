/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Negocio;

/**
 *
 * @author fabian
 */
public class PlanComprado {
    //Defino los atributos de la clase
    private String nombrePlan;
    private String fechaCompra;
    private String torneo;
    private String fechaExpiracion;
    private double precio;
    
    //Realizo el constructor

    public PlanComprado() {
        
    }

    public PlanComprado(String nombrePlan,String fechaCompra, String torneo, String fechaExpiracion, double precio) {
        this.nombrePlan = nombrePlan;
        this.fechaCompra = fechaCompra;
        this.torneo = torneo;
        this.fechaExpiracion = fechaExpiracion;
        this.precio = precio;
    }
    
    //Defino los getters, setters y toString

    public String getNombrePlan() {
        return nombrePlan;
    }

    public void setNombrePlan(String nombrePlan) {
        this.nombrePlan = nombrePlan;
    }

    
    public String getFechaCompra() {
        return fechaCompra;
    }

    public void setFechaCompra(String fechaCompra) {
        this.fechaCompra = fechaCompra;
    }

    public String getTorneo() {
        return torneo;
    }

    public void setTorneo(String torneo) {
        this.torneo = torneo;
    }

    public String getFechaExpiracion() {
        return fechaExpiracion;
    }

    public void setFechaExpiracion(String fechaExpiracion) {
        this.fechaExpiracion = fechaExpiracion;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    @Override
    public String toString() {
        return "PlanComprado{" + "nombrePlan=" + nombrePlan + ", fechaCompra=" + fechaCompra + ", torneo=" + torneo + ", fechaExpiracion=" + fechaExpiracion + ", precio=" + precio + '}';
    }

   
    
}
