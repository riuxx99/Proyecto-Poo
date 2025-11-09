/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package Negocio;
import java.util.ArrayList;
/**
 *
 * @author IAN
 */
public class Estadio {
    //Defino los ArrayList de las clases que se van a usar
    private ArrayList<Tribuna> myTribunas;
    private ArrayList<Plan> myPlanes;
    private ArrayList<Torneo> myTorneos;
    private ArrayList<Usuario> myUsuarios;
    
    //Defino el constructor
    
    public Estadio(){
        //Inicializo los ArrayList
        this.myTribunas = new ArrayList<Tribuna> ();
        this.myPlanes = new ArrayList<Plan> ();
        this.myTorneos = new ArrayList<Torneo> ();
        this.myUsuarios = new ArrayList<Usuario> ();
    }
    
    //Realizo metodos para validar los nombres de usuario y las contraseñas
    private Usuario validarUsername(String username){
        Usuario u = null;
        for(Usuario us: this.myUsuarios){
            if(us.getUsername().equals(username)){
                u=us;
                break;
            }
        }
        return u;
    }
    
    private Usuario validarClave(String clave){
        Usuario u = null;
        for(Usuario us: this.myUsuarios){
            if(us.getClave().equals(clave)){
                u=us;
                break;
            }
        }
        return u;
    }
    
    //RF 1 permite registrar usuarios de clase aficionado
    private String registrarUsuarioAficionado(String username, String clave, int cedula, String nombre, String apellido, String correo, int telefono, String fechaNacimiento, String tipoAficionado){
        
        if(this.validarUsername(username) != null){
            return "Ya existe un usuario con ese nombre, por favor elija otro nombre";
        }
        if(this.validarClave(clave) != null){
            return "Ya existe un usuario con esa clave, por favor digite otra clave";
        }
        this.myUsuarios.add(new Aficionado(cedula, nombre, apellido, correo, telefono, fechaNacimiento, tipoAficionado, username, clave));
        String cad= ((Aficionado)this.myUsuarios.getLast()).toString();
        return "Usuario registrado exitosamente \n"+ cad;
    }
    
    /*private String registrarUsuarioAdministrador(String username, String clave){
        
        if(this.validarUsername(username) != null){
            return "Ya existe un usuario con ese nombre, por favor elija otro nombre";
        }
        if(this.validarClave(clave) != null){
            return "Ya existe un usuario con esa clave, por favor digite otra clave";
        }
        this.myUsuarios.add(new Admin(username, clave));
        String cad= ((Admin)this.myUsuarios.getLast()).toString();
        return "Usuario registrado exitosamente \n"+ cad;
    }*/

    public static void main(String args[]) {
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
