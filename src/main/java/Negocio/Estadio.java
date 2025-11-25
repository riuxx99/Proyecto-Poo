/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package Negocio;
import java.time.LocalDate;
import java.time.LocalTime;
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
    private ArrayList<Boleta> myBoletas;
    
    //Defino el constructor
    
    public Estadio(){
        //Crear Tribunas
        this.myTribunas = new Tribuna[4];
        myTribunas[0] = new Tribuna(1,"Norte");
        myTribunas[1]= new Tribuna(2,"Sur");
        myTribunas[2] = new Tribuna(3,"Oriente");
        myTribunas[3] = new Tribuna(4,"Occidente");
        //Crear torneos
        this.myTorneos = new Torneo[4];
        this.myTorneos[0] =new Torneo("Liga BetPlay Dimayor primera A");
        this.myTorneos[1] =new Torneo("La primera B");
        this.myTorneos[2] =new Torneo("CONMEBOL Libertadores");
        this.myTorneos[3] =new Torneo("CONMEBOL Sudamericana");
        this.myPlanes = new ArrayList<Plan> ();
        this.myAficionados= new ArrayList<Aficionado> ();
        this.myBoletas = new ArrayList<>();
        
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
        int id =0 ;
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
        
        if(t.getMyPartidos().isEmpty()){
            id = 0;
        }else{
            id = t.getMyPartidos().size()+1;
        }
        t.añadirPartido(new Partido(id,fecha,hora,equipoLocal,equipoVisitante));
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
    public String actualizarTorneo(String torneo,String fechaInicio,String fechaFin,float valorBasico, int cantidadPartidos){
        String cad;
        Torneo t = this.buscarTorneo(torneo);
        t.setFechaInicio(fechaInicio);
        t.setFechaFin(fechaFin);
        t.setValorBoleta(valorBasico);
        t.setCantidadPartidos(cantidadPartidos);
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
        //validaciones
        if(t.getFechaFin() == null){
            return "No se puede vender un plan: el torneo no tiene fecha de fin registrada.";
        }
        if(a==null) return "No hay un aficionado con esta cedula";
        if(t.getMyPartidos().isEmpty()) return "No se puede vender un plan: el torneo aún no tiene partidos programados.";
 
        double precio = this.calcularValorPlan(planAComprar,torneo);
        String fechaCompra = LocalDate.now().toString();
        
        String fechaExpiracion = t.getFechaFin();
        PlanComprado plan = new PlanComprado(planAComprar, fechaCompra,  torneo,  fechaExpiracion, precio);
        a.añadirPlan(plan);
        return "Plan " + planAComprar + " comprado por $" + precio + "\nFecha de Expiracion: "+ fechaExpiracion;

    }
    private double calcularValorPlan(String plan,String torneo){
        Torneo t = this.buscarTorneo(torneo);
        double valor=t.getValorBoleta()*t.getCantidadPartidos();
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
    
        //Vender Boleta
    public String ventaBoleta(String torneo,int cedula,int idPartido, ArrayList<String> puestos){
        Aficionado a = this.validarCedula(cedula);
        if(a==null){
            return "No se ha encontrado un aficionado con esta cedula";
        }
        Torneo t = this.buscarTorneo(torneo);
        //Obtener datos del puesto
        Puesto p = null;
        double precioTotal = 0F;
        double precioBoleta = 0F;
        int idBoleta = 0;
        for(String myP :puestos){
            p= buscarPuesto(myP);
            precioBoleta = t.getValorBoleta()+this.calcularRecargo(torneo,p.getIdTribuna(),p.getNivel(),t.getValorBoleta());
            precioTotal += precioBoleta;
            if(!myBoletas.isEmpty()){
                idBoleta +=1 ;
            }
            myBoletas.add(new Boleta(a,t.buscarPartido(idPartido),idBoleta,LocalDate.now().toString(),LocalTime.now().withNano(0).toString(),precioBoleta));
            t.añadirPuestoVendidoPartido(t.buscarPartido(idPartido),p.getNumeroCompuesto());
        }
        if (puestos.size() >=4) {
           precioTotal *= 0.10;
        }
        return "Boletas vendidas exitosamente... Total A Pagar"+ precioTotal;
    }
    public Puesto buscarPuesto(String myP){
        Puesto p = null;
        for(Tribuna t:myTribunas){
            p = t.busquedaPuesto(myP);
        }
        return p;
    }
    //Calcular recargo boleta
    public double calcularRecargo(String torneo, int idTribuna, int nivel, double valorBoleta){
    double recargo = 0;

    // Liga BetPlay Dimayor primera A
    if(torneo.equals("Liga BetPlay Dimayor primera A")){
        if(idTribuna == 1 || idTribuna == 2){
            recargo = valorBoleta * 0.10;
        }else if(idTribuna == 3){
            if(nivel == 1 || nivel == 2) recargo = valorBoleta * 0.25;
            else if(nivel == 3) recargo = valorBoleta * 0.15;
            else if(nivel == 4) recargo = valorBoleta * 0.10;
        }else if(idTribuna == 4){
            if(nivel == 1) recargo = valorBoleta * 0.35;
            else if(nivel == 2 || nivel == 3) recargo = valorBoleta * 0.25;
            else if(nivel == 4) recargo = valorBoleta * 0.10;
        }
    }

    // La primera B
    else if(torneo.equals("La primera B")){
        if(idTribuna == 1 || idTribuna == 2 || idTribuna == 3){
            recargo = -(valorBoleta * 0.20);
        }else if(idTribuna == 4){
            recargo = -(valorBoleta * 0.10);
        }
    }

    // CONMEBOL Libertadores
    else if(torneo.equals("CONMEBOL Libertadores")){
        if(idTribuna == 1 || idTribuna == 2){
            recargo = valorBoleta * 0.20;
        }else if(idTribuna == 3){
            if(nivel == 1) recargo = valorBoleta * 0.35;
            else recargo = valorBoleta * 0.45;
        }else if(idTribuna == 4){
            recargo = valorBoleta * 0.55;
        }
    }

    // CONMEBOL Sudamericana
    else if(torneo.equals("CONMEBOL Sudamericana")){
        if(idTribuna == 1 || idTribuna == 2){
            recargo = valorBoleta * 0.20;
        }else if(idTribuna == 3){
            if(nivel == 1) recargo = valorBoleta * 0.35;
            else recargo = valorBoleta * 0.45;
        }else if(idTribuna == 4){
            recargo = valorBoleta * 0.55;
        }
    }

    return recargo;
}

    //Programacion partidos de un equipo
    public String programacionPartidosEquipo(String equipo){
        String cad="";
        for(Torneo t: this.myTorneos){
            if(!t.getMyPartidos().isEmpty() && t.cantidadPartidos(equipo)>0){
                cad += "Nombre Torneo: "+t.getNombre()+"\nId\tFecha Partido\tHora\tEquipo Local\tEquipo Visitante\tEstado";
                cad+= t.buscarPartidosEquipo(equipo)+"\n\n";
            }
        }
        return cad;
    }
    //Mostrar Partidos con mas ventas para un torneo
    public String mostrarPartidosConMasVenta(String torneo){
        String cad = "";
        Torneo t = this.buscarTorneo(torneo);
        if(t.getMyPartidos().isEmpty()){
            return "EL TORNEO NO TIENE PARTIDOS PROGRAMADOS";
        }
        cad += "Nombre Torneo: "+t.getNombre()+"\nId\tFecha Partido\tHora\tEquipo Local\tEquipo Visitante\tNumero Boletas Vendidas";
        cad += t.buscarPartidosConMasVentas();
        return cad;
    }
    //Partidos Disponibles
    public String programacionPartidosTorneo(String torneo){
        Torneo t = this.buscarTorneo(torneo);
        String cad="";
        if(t.getMyPartidos().isEmpty()){
            return "NO HAY PARTIDOS PROGRAMADOS PARA ESTE TORNEO";
        }
        cad += "Nombre Torneo: "+t.getNombre()+"\nId\tFecha Partido\tHora\tEquipo Local\tEquipo Visitante\tEstado";  
        cad += t.listarPartidosTorneo();
        return cad;
    }
}
