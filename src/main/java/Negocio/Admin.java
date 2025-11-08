/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Negocio;

/**
 *
 * @author fabian
 */
public class Admin extends Usuario{

    //Realizo el constructor
    public Admin(String username, String clave) {
        super(username, clave);
    }
    
    //Realizo el toString

    @Override
    public String toString() {
        return super.toString()+"Admin";
    }
}
