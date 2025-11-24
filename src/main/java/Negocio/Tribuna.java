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
    private int id;
    private String nombre;
    private Puesto myPuestos[];
    
    //Realizo el constructor
    public Tribuna(){
        
    }
    //Constructor con parametros
    public Tribuna(int id, String nombre) {
        this.id = id;
        this.nombre = nombre;
        this.myPuestos = new Puesto[80];
        
        for(int i=0; i<80;i++){
            myPuestos[i] = new Puesto(i+1,id,this.asignarNivel(i));
        }
    }
    
    //Defino los getters, setters y toString

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
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
    //Busqueda de puesto
    public Puesto busquedaPuesto(String puesto){
        for(Puesto p: myPuestos){
            if(p.getNumeroCompuesto().equals(puesto)){
                return p;
            }
        }
        return null;
    }
    @Override
    public String toString() {
        return "Tribuna: \n id=" + id + "\n nombre=" + nombre;
    }
    
}
