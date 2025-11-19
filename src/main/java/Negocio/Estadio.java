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
    private ArrayList<Aficionado> myAficionados;
   
    
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
        this.myAficionados= new ArrayList<Aficionado> ();
    }
    
    
    
    //Metodo para validar la cedula de un aficionado
    private Aficionado validarCedula(int cedula){
        Aficionado af = null;
        for(Aficionado a: this.myAficionados){
            if(a.getCedula()==cedula){
                af=a;
                break;
            }
        }
        return af;
    }
    
    //RF 1 permite registrar usuarios de clase aficionado
    public String registrarAficionado(int cedula, String nombre, String apellido, String correo, int telefono, String fechaNacimiento, String tipoAficionado){
        String cad;
        
        if(this.validarCedula(cedula) != null){
            return "Ya existe un usuario con esa cedula, intente de nuevo";
        }
        this.myAficionados.add(new Aficionado(cedula, nombre, apellido, correo, telefono, fechaNacimiento, tipoAficionado));
        cad = "USUARIO REGISTRADO EXITOSAMENTE";
        return cad;
    }
    
    //Registrar Partido
    public String registrarPartido(String torneo,String fecha, String hora, String equipoLocal, String equipoVisitante){
        String cad;
        Torneo t = buscarTorneo(torneo);
        if(t.getFechaInicio()==null){
            return "EL TORNEO NO TIENE FECHA DE INICIO...";
        }
        if(t.getFechaFin()==null){
            return "EL TORNEO NO TIENE FECHA DE FIN...";
        }
        if(!this.validarFechaPartidoTorneo(torneo,fecha)){
            return "FECHA FUERA DE RANGO...";
        }
        if(this.validarFecha(fecha)){
            return"YA HAY UN PARTIDO PARA LA FECHA INGRESADA...";
        }
        
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
    public String actualizarTorneo(String torneo,String fechaInicio,String fechaFin,float valorBasico){
        String cad;
        Torneo t = this.buscarTorneo(torneo);
        t.setFechaInicio(fechaInicio);
        t.setFechaFin(fechaFin);
        t.setValorBoleta(valorBasico);
        cad = "Se han actualizado los datos con exito";
        return cad;
    }
    
    //Validar que la fecha del partido a registrar esté dentro del rango de inicio/fin de un torneo
    private boolean validarFechaPartidoTorneo(String torneo,String fechaPartido){
        Torneo t = this.buscarTorneo(torneo);
        
        //pasar la fecha de los partidos a int
        int fechaInicioInt = Integer.parseInt(t.getFechaInicio().replace("-",""));  
        int fechaFinInt = Integer.parseInt(t.getFechaFin().replace("-",""));
        int fechaPartidoInt = Integer.parseInt(fechaPartido.replace("-",""));
        
        return fechaPartidoInt>=fechaInicioInt && fechaPartidoInt<=fechaFinInt;
    }
    //vender plan a aficionado
    public String venderPlan(String torneo, int cedula,String planAComprar){
        Torneo t = this.buscarTorneo(torneo);
        Aficionado a = this.validarCedula(cedula);
        double valorPlan = this.calcularValorPlan(planAComprar, torneo);
            
        return null;
    }
    private double calcularValorPlan(String plan,String torneo){
        Torneo t = this.buscarTorneo(torneo);
        double valor=t.getValorBoleta()*t.getMyPartidos().size();
        if(t.getNombre().equals("Liga BetPlay Dimayor primera A")||t.getNombre().equals("La primera B")){
          if(plan.equals("Basico")){
                valor *=0.90;
            }else if(plan.equals("Premium")){
                valor *=0.80;
            }  
        }
        if(t.getNombre().equals("CONMEBOL Libertadores")){
            if(plan.equals("Basico")){
                valor *=0.85;
            }else if(plan.equals("Premium")){
                valor *=0.75;
            } 
        }
        if(t.getNombre().equals("CONMEBOL Sudamericana")){
            if(plan.equals("Basico")){
                valor *=0.80;
            }else if(plan.equals("Premium")){
                valor *=0.70;
            } 
        }
        
        
        return valor;
    }
    
    //Programacion partidos de un equipo
    public String programacionPartidosEquipo(String equipo){
        String cad="";
        for(Torneo t: this.myTorneos){
            if(!t.getMyPartidos().isEmpty() && t.cantidadPartidos(equipo)>0){
                cad += "Nombre Torneo: "+t.getNombre()+"\nFecha Partido\tHora\tEquipo Local\tEquipo Visitante\tEstado";
                cad+= t.buscarPartidosEquipo(equipo)+"\n\n";
            }
        }
        return cad;
    }
}
