/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Negocio;

/**
 *
 * @author IAN
 */
public class Puesto {
    
    //Defino los atributos de la clase
    private int numero;
    private String idTribuna;
    private int nivel;
    private String numeroCompuesto;
    
    //Realizo el constructor
    public Puesto(){
        
    }

    public Puesto(int numero, String idTribuna, int nivel) {
        this.numero = numero;
        this.idTribuna = idTribuna;
        this.nivel = nivel;
        this.numeroCompuesto = idTribuna+"-"+numero;
    }
    
    //Defino los getters, setters y toString

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public String getIdTribuna() {
        return idTribuna;
    }

    public void setIdTribuna(String idTribuna) {
        this.idTribuna = idTribuna;
    }

    public int getNivel() {
        return nivel;
    }

    public void setNivel(int nivel) {
        this.nivel = nivel;
    }
    public String getNumeroCompuesto() {
        return numeroCompuesto;
    }

    @Override
    public String toString() {
        return "Puesto: \n numero=" + numero + "\n idTribuna=" + idTribuna + "\n nivel=" + nivel;
    }
    
}
