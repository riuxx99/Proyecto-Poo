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
    private Tribuna[] myTribunas;
    private ArrayList<Plan> myPlanes;
    private Torneo[] myTorneos;
    private ArrayList<Usuario> myUsuarios;
    private float valorBoleta;
    
    
    //Defino el constructor
    
    public Estadio(){
        //Crear Tribunas
        this.myTribunas = new Tribuna[4];
        myTribunas[0] = new Tribuna("1","Norte",2000);
        myTribunas[1]= new Tribuna("2","Sur",2000);
        myTribunas[2] = new Tribuna("3","Oriente",2000);
        myTribunas[3] = new Tribuna("4","Occidente",2000);
        //Crear torneos
        this.myTorneos = new Torneo[4];
        this.myTorneos[0] =new Torneo("Liga BetPlay Dimayor primera A");
        this.myTorneos[1] =new Torneo("La primera B");
        this.myTorneos[2] =new Torneo("CONMEBOL Libertadores");
        this.myTorneos[3] =new Torneo("CONMEBOL Sudamericana");
        this.myPlanes = new ArrayList<Plan> ();
        this.myUsuarios = new ArrayList<Usuario> ();
        this.valorBoleta = 0;
         
    }
    //Obtener valor boleta
    public float getValorBoleta(){
        return this.valorBoleta;
    }
    //Actualizar el valor de la boleta
    public void setValorBoleta(float valor){
        this.valorBoleta = valor;
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
    private Usuario validarCedula(int cedula){
        Usuario u = null;
        for(Usuario us: this.myUsuarios){
            Aficionado a = (Aficionado) us;
            if(a.getCedula()==cedula){
                u=a;
                break;
            }
        }
        return u;
    }
    
    //RF 1 permite registrar usuarios de clase aficionado
    public String registrarAficionado(String username, String clave, int cedula, String nombre, String apellido, String correo, int telefono, String fechaNacimiento, String tipoAficionado){
        String cad;
        if(this.validarUsername(username) != null){
            return "Ya existe un usuario con ese nombre, por favor elija otro nombre";
        }
        if(this.validarCedula(cedula) != null){
            return "Ya existe un usuario con esa cedula, intente de nuevo";
        }
        this.myUsuarios.add(new Aficionado(cedula, nombre, apellido, correo, telefono, fechaNacimiento, tipoAficionado, username, clave));
        cad = "USUARIO REGISTRADO EXITOSAMENTE";
        return cad;
    }
    
    //Registrar Partido
    public String registrarPartido(String torneo,String fecha, String hora, String equipoLocal, String equipoVisitante){
        String cad;
        if(this.validarFecha(fecha)){
            return"YA HAY UN PARTIDO PARA LA FECHA INGRESADA...";
        }
        Torneo t = buscarTorneo(torneo);
        t.añadirPartido(new Partido(fecha,hora,equipoLocal,equipoVisitante));
        cad="PARTIDO REGISTRADO CON EXITO";
        return cad;
    }
    //Validar que no halla un partido en la fecha ingresada
    private boolean validarFecha(String fecha){
        for(Torneo t: this.myTorneos){
            for(Partido p: t.getMyPartidos()){
                if(p.getFecha().equals(fecha)){
                    return true;
                }
            }
        }
        
        return false;
    }
    
    //Devuelve un torneo
    private Torneo buscarTorneo(String torneo){
        for(Torneo t :this.myTorneos){
            if(t.getNombre().equals(torneo)){
                return t;
            }
        }
        return null;
    }
    
    //Dar Fecha de inicio y fin a un torneo
    public String establecerFechas(String torneo,String fechaInicio,String fechaFin){
        String cad;
        Torneo t = this.buscarTorneo(torneo);
        t.setFechaInicio(fechaInicio);
        t.setFechaFin(fechaFin);
        cad = "Se han actualizado las fechas con exito";
        return cad;
    }
    public boolean iniciarSesion(String usuario, String clave){
        
        for(Usuario u:this.myUsuarios){
            if(u.getUsername().equals(usuario)&& u.getClave().equals(clave)){
                return true;
            }
        }
        return false;
    }

    
}
