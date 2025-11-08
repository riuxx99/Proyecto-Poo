/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package Negocio;

/**
 *
 * @author IAN
 */
public class Estadio {
    public static void main(String args[]){
        Tribuna myT = new Tribuna("1","Norte",2000);
        Tribuna myT2 = new Tribuna("2","Sur",2000);
        Tribuna myT3 = new Tribuna("3","Oriente",2000);
        Tribuna myT4 = new Tribuna("4","Occidente",2000);
        Puesto puestos[] = myT.getMyPuestos();
        Puesto puestos2[] = myT2.getMyPuestos();
        System.out.println(myT.getNombre());
        
        for(Puesto p: puestos){
            System.out.println(p.getNumeroCompuesto());
            if (p.getNumero() == 10) System.out.println(p.getNivel());
            if (p.getNumero() == 25) System.out.println(p.getNivel());
            if (p.getNumero() == 50) System.out.println(p.getNivel());
            if (p.getNumero() == 62) System.out.println(p.getNivel());
        
        
        
        }
        System.out.println(myT2.getNombre());
        for(Puesto p: puestos2){
            System.out.println(p.getNumeroCompuesto());
        }
    }
}
