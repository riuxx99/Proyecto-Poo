/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Negocio;

/**
 *
 * @author fabian
 */
public class Boleta {
    //Definimos los atributos de la clase
    private Aficionado myAficionado;
    private Partido myPartido;
    private Puesto myPuesto;
    private int numeroBoleta;
    private String fechaVenta;
    private String horaVenta;
    private float precioBoleta;
    
    //Realizamos el constructor
    public Boleta(){
        
    }

    public Boleta(int numeroBoleta, String fechaVenta, String horaVenta, float precioBoleta) {
        this.numeroBoleta = numeroBoleta;
        this.fechaVenta = fechaVenta;
        this.horaVenta = horaVenta;
        this.precioBoleta = precioBoleta;
    }
    
    //Definimos los getters, setters y toString

    public int getNumeroBoleta() {
        return numeroBoleta;
    }

    public void setNumeroBoleta(int numeroBoleta) {
        this.numeroBoleta = numeroBoleta;
    }

    public String getFechaVenta() {
        return fechaVenta;
    }

    public void setFechaVenta(String fechaVenta) {
        this.fechaVenta = fechaVenta;
    }

    public String getHoraVenta() {
        return horaVenta;
    }

    public void setHoraVenta(String horaVenta) {
        this.horaVenta = horaVenta;
    }

    public float getPrecioBoleta() {
        return precioBoleta;
    }

    public void setPrecioBoleta(float precioBoleta) {
        this.precioBoleta = precioBoleta;
    }

    @Override
    public String toString() {
        return "Boleta: \n Aficionado=" + myAficionado + "\n Partido=" + myPartido + "\n Puesto=" + myPuesto + "\n Numero de Boleta=" + numeroBoleta + "\n Fecha de Venta=" + fechaVenta + 
                "\n Hora de Venta=" + horaVenta + "\n Precio de la Boleta=" + precioBoleta;
    }
    
    
}
