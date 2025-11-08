/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Negocio;

/**
 *
 * @author IAN
 */
public class Tribuna {
    
    //Defino los atributos de la clase
    private String id;
    private String nombre;
    private float precioBase;
    private Puesto myPuestos[];
    
    //Realizo el constructor
    public Tribuna(){
        
    }
    //Constructor con parametros
    public Tribuna(String id, String nombre, float precioBase) {
        this.id = id;
        this.nombre = nombre;
        this.precioBase = precioBase;
        this.myPuestos = new Puesto[80];
        
        for(int i=0; i<80;i++){
            myPuestos[i] = new Puesto(i+1,id,this.asignarNivel(i));
        }
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

    public Puesto[] getMyPuestos() {
        return myPuestos;
    }
    
    //metodo para asignar un nivel al puesto
    public int asignarNivel(int i){
        int nivel = 0;
        if(i>=1 && i<=20){
            nivel = 1;
        }else if(i>=21 && i<=40){
            nivel = 2;
        }else if(i>=41 && i<=60){
            nivel = 3;
        }else{
            nivel = 4;
        }
        return nivel;
    }

    @Override
    public String toString() {
        return "Tribuna: \n id=" + id + "\n nombre=" + nombre + "\n precioBase=" + precioBase;
    }
    
}
