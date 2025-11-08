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
    
    private Aficionado myAficionado;
    private Plan myPlan;
    private String fechaCompra;
    private String torneo;
    private String fechaExpiracion;
    private float precioVenta;
    
    //Realizo el constructor

    public PlanComprado() {
        
    }

    public PlanComprado(String fechaCompra, String torneo, String fechaExpiracion, float precioVenta) {
        this.fechaCompra = fechaCompra;
        this.torneo = torneo;
        this.fechaExpiracion = fechaExpiracion;
        this.precioVenta = precioVenta;
    }
    
    //Defino los getters, setters y toString

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

    public float getPrecioVenta() {
        return precioVenta;
    }

    public void setPrecioVenta(float precioVenta) {
        this.precioVenta = precioVenta;
    }

    @Override
    public String toString() {
        return "PlanComprado: \n Aficionado=" + myAficionado + "\n Plan=" + myPlan + "\n fechaCompra=" + fechaCompra + "\n torneo=" + torneo + "\n fechaExpiracion=" + fechaExpiracion + "\n precioVenta=" + precioVenta;
    }
    
    
}
