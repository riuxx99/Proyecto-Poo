/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Negocio;

/**
 *
 * @author fabian
 */

public abstract class Usuario {
    //Definimos los atributos de la clase padre usuario
    private String username;
    private String clave;
    
    //Creamos el constructor

    public Usuario(String username, String clave) {
        this.username = username;
        this.clave = clave;
    }
    
    
    
    //Realizamos los getters, setters y el toString

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getClave() {
        return clave;
    }

    public void setClave(String clave) {
        this.clave = clave;
    }

    @Override
    public String toString() {
        return "Usuario \n username=" + username + "\n clave=" + clave;
    }
    
    
    
}
