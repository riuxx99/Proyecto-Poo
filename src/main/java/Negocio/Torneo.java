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
    private int cantidadPartidos;
    private boolean bloqueado = false;
    //Realizo el constructor
    public Torneo(){
        
    }

    public Torneo(String nombre) {
        this.nombre = nombre;
        this.fechaInicio = null;
        this.fechaFin = null;
        this.myPartidos = new ArrayList<>(cantidadPartidos);
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
    public void setCantidadPartidos(int cantidadPartidos){
        this.cantidadPartidos = cantidadPartidos;
    }
    public int getCantidadPartidos(){
        return this.cantidadPartidos;
    }
    public boolean isBloqueado() {
        return bloqueado;
    }

    public void setBloqueado(boolean bloqueado) {
        this.bloqueado = bloqueado;
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
    //Metodo para verificar cuantos partidos estan activos en un torneo para poder vender los planes al precio correcto
    public int verificarPartidos(){
        int Contador = 0;
        Partido p = null;
        for(Partido t:myPartidos){
            if(t.getEstado().equalsIgnoreCase("Activo")){
                p = t;
                Contador++;
            }
        }
        return Contador;
    }
    public Partido buscarPartido(int idPartido){
        for(Partido p: myPartidos){
            if(p.getId()==idPartido){
                return p;
            }
        }
        return null;
    }
    //Añadir Puesto Vendido Partido
    public void añadirPuestoVendidoPartido(Partido p, String puesto){
        p.añadirVentaPuesto(puesto);
    }
    //Buscar partidos con mas ventas de un torneo
    public String buscarPartidosConMasVentas() {
        Partido[] masVendidos = new Partido[3];
        String cad ="";
        //Para el más vendido
        Partido masVendido = null;
        for(Partido p: this.myPartidos){
            if(masVendido == null){
                masVendido = p;
            }else if(p.getPuestosVendidos().size()>masVendido.getPuestosVendidos().size()){
                masVendido = p;
            }
        }
        //Para el 2do mas vendido
        Partido segundoMasVendido = null;
        for(Partido p: this.myPartidos){
            if(masVendido!=null){
                if(p.getPuestosVendidos().size()<masVendido.getPuestosVendidos().size() && segundoMasVendido == null){
                    segundoMasVendido = p;
                }else if(p.getPuestosVendidos().size()<masVendido.getPuestosVendidos().size()&&p.getPuestosVendidos().size()>segundoMasVendido.getPuestosVendidos().size()){
                    segundoMasVendido = p;
                }
            }
            
        }
        //Para el 3er mas vendido
        Partido tercerMasVendido= null;
        for(Partido p: this.myPartidos){
            if(masVendido!=null && segundoMasVendido !=null){
                if(p.getPuestosVendidos().size()<segundoMasVendido.getPuestosVendidos().size() && tercerMasVendido == null){
                    tercerMasVendido = p;
                }else if(p.getPuestosVendidos().size()<segundoMasVendido.getPuestosVendidos().size()&&p.getPuestosVendidos().size()>tercerMasVendido.getPuestosVendidos().size()){
                    tercerMasVendido = p;
                }
            }
            
        }
        for(Partido p: masVendidos){
            cad = p.toStringMasVendidos();
        }
        
        
       return cad;
    }
    //Listar Partidos Activos de un torneo
    public String listarPartidosTorneo(){
        String cad = "";
        
        for(Partido p:this.myPartidos){
            if(p.getEstado().equals("Activo")){
                cad += p.toString();
            }    
            
        }
        return cad;
    }
    @Override
    public String toString() {
        return "Torneo: \n nombre=" + nombre + "\n Fecha de Inicio=" + fechaInicio + "\n Fecha de Finalizacion=" + fechaFin + "\n Partidos=" + myPartidos;
    }
    
}
