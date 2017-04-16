/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;
import java.util.*;
import java.io.*;
import javax.swing.SpringLayout;

/**
 *
 * @author invitado
 */
public class Banco {
    
    //-------------------------------------------------------------------------
    // ATRIBUTOS
    //-------------------------------------------------------------------------
    private HashMap clientesEnEspera;
    private HashMap clientesAceptados;
    private HashMap OFAC;
    private HashMap OFACaux;
    private HashMap empresas;
    
    //-------------------------------------------------------------------------
    // CONSTRUCTOR
    //-------------------------------------------------------------------------
    
    public Banco(){
        
        this.clientesEnEspera = new HashMap();
        this.clientesAceptados = new HashMap();
        //this.representantesEnEspera = new HashMap();
        //this.representantesAceptados = new HashMap();
        this.empresas = new HashMap();
    }
    
    public String agregarEmpresa(String ced, Empresa empresa){
        boolean encontrado = false;
        Set nits = empresas.keySet();
        Iterator i = nits.iterator();
        while(i.hasNext() && (encontrado == false)){
            String nit = (String) i.next();
            Empresa e = (Empresa) empresas.get(nit);
            if(e.getNit() == empresa.getNit()){
                encontrado = true;
            }
            else{
                encontrado = false;
            }
        }
        
        if(clientesAceptados.containsKey(ced)){
            Representante r = (Representante) clientesAceptados.get(ced);
            if(!r.verificarEmpresa(ced) && (encontrado == false)){
                r.agregarEmpresas(empresa);
                clientesAceptados.put(ced, r);
                empresas.put(empresa.getNit(), empresa);
                return "La empresa se adiciono con exito";
            }
            else{
                return "No se pudó agregar la empresa";
            }
        }else{
            if(clientesEnEspera.containsKey(ced)){
                Representante r = (Representante) clientesEnEspera.get(ced);
                if(!r.verificarEmpresa(ced) && (encontrado == false)){
                    r.agregarEmpresas(empresa);
                    clientesEnEspera.put(ced, r);
                    empresas.put(empresa.getNit(), empresa);
                    return "La empresa se adiciono con exito";
                }
                else{
                    return "No se pudó agregar la empresa";
                }
            }else{
                return "No se pudó agregar la empresa";
            }
        }
    }
    
    public boolean revisarReferenciasCliente(String ced){
        if(clientesEnEspera.containsKey(ced)){
            Cliente c = (Cliente) clientesEnEspera.get(ced);
            Representante r = (Representante) clientesEnEspera.get(ced);
            if(c.getPersona() == "Persona Natural"){
                return c.revisarReferencias();
            }else{
                return r.revisarReferencias();
            }
        }else{
            return false;
        }
    }
    
    public String agregarClientesEnEspera(boolean check, Representante r, Cliente c){
        if(!clientesEnEspera.containsKey(c.getCedula()) && !clientesEnEspera.containsKey(r.getCedula())){
            if (check = false){
                clientesEnEspera.put(c.getCedula(), c);
                return "cliente adicionado con exito";
            }else{
                clientesEnEspera.put(r.getCedula(), r);
                return "cliente adicionado con exito";
            }
        }else{
            return "No se pudo adicionar el cliente";
        }
    }
    
    public String agregarClientesAceptados(String ced){
        
        if(clientesEnEspera.containsKey(ced)){
            Cliente c = (Cliente) clientesEnEspera.get(ced);
            Representante r = (Representante) clientesEnEspera.get(ced);
            if((revisarReferenciasCliente(ced) == true) && !clientesAceptados.containsKey(c.getCedula()) && (c.getPersona() == "Persona Natural")){
                c.setEstado("Aceptado");
                clientesAceptados.put(c.getCedula(), c);
                clientesEnEspera.remove(ced);
                return "El cliente cumple los requisitos";
            }else{
                if((revisarReferenciasCliente(ced) == true) && !clientesAceptados.containsKey(r.getCedula()) && (c.getPersona() == "Representante Legal")){
                    r.setEstado("Aceptado");
                    clientesAceptados.put(r.getCedula(), r);
                    clientesEnEspera.remove(ced);
                    return "El cliente cumple los requisitos";
                }else{
                    return "No se pudo agregar al cliente";
                }
            }
        }else{
            return "No se pudo agregar al cliente";
        }
    }
    
    public String eliminarClientes(String cedula){
        if(clientesEnEspera.containsKey(cedula)){
                clientesEnEspera.remove(cedula);
            return "Cliente eliminado con exito";
        }else{
            if(clientesAceptados.containsKey(cedula)){
                clientesAceptados.remove(cedula);
                return "Cliente eliminado con exito";
            }else{
                return "El representante no se pudo eliminar";
            }
        }
    }
    
    public String modificarClientes(boolean check, String per, String est, String nom, String ape, String ced, String edad, String genero, String in, String eg, String act){
        
        if (clientesEnEspera.containsKey(ced)){
            Cliente c = (Cliente) clientesEnEspera.get(ced);
            if(c.getPersona() == "Persona Natural"){
                c.setPersona(per);
                c.setNombre(nom);
                c.setApellido(ape);
                c.setIngresos(in);
                c.setEgresos(eg);
                c.setEdad(edad);
                c.setGenero(genero);
                c.setActEconomica(act);
                clientesEnEspera.put(c.getCedula(), c);
                return "cliente modificado con exito";
            }else{
                Representante r = (Representante) clientesEnEspera.get(ced);
                r.setPersona(per);
                r.setNombre(nom);
                r.setApellido(ape);
                r.setIngresos(in);
                r.setEgresos(eg);
                r.setEdad(edad);
                r.setGenero(genero);
                r.setActEconomica(act);
                clientesEnEspera.put(r.getCedula(), r);
                return "cliente modificado con exito";
            }
        }else{
            if(clientesAceptados.containsKey(ced)){
                Cliente c = (Cliente) clientesAceptados.get(ced);
                if(c.getPersona() == "Persona Natural"){
                    c.setPersona(per);
                    c.setNombre(nom);
                    c.setApellido(ape);
                    c.setIngresos(in);
                    c.setEgresos(eg);
                    c.setEdad(edad);
                    c.setGenero(genero);
                    c.setActEconomica(act);
                    clientesAceptados.put(c.getCedula(), c);
                    return "cliente modificado con exito";
                }else{
                    Representante r = (Representante) clientesAceptados.get(ced);
                    r.setPersona(per);
                    r.setNombre(nom);
                    r.setApellido(ape);
                    r.setIngresos(in);
                    r.setEgresos(eg);
                    r.setEdad(edad);
                    r.setGenero(genero);
                    r.setActEconomica(act);
                    clientesAceptados.put(r.getCedula(), r);
                    return "cliente modificado con exito";
                }
            }else{
                return "El cliente no se pudó modificar";
            }
        }
    }
            
            
                
    
    public String consultarClientes(String cedula){
        if(clientesEnEspera.containsKey(cedula)){
            Cliente c = (Cliente) clientesEnEspera.get(cedula);
            if(c.getPersona() == "Persona Natural"){
                return  "Persona: " + c.getPersona() +
                        "\n" + "Estado: " + c.getEstado() +
                        "\n" + "Nombre: " + c.getNombre() +
                        "\n" + "Apellido: " + c.getApellido() +
                        "\n" + "Cedula: " + c.getCedula() +
                        "\n" + "Edad: " + c.getEdad() +
                        "\n" + "Genero: " + c.getGenero() +
                        "\n" + "Ingresos Mensuales: " + c.getIngresos() +
                        "\n" + "Egresos Mensuales: " + c.getEgresos() +
                        "\n" + "Actividad Economica: " + c.getActEconomica() +
                        "\n" + c.cedulasReferencias();
            }else{
                Representante r = (Representante) clientesEnEspera.get(cedula);
                return  "Persona: " + r.getPersona() +
                        "\n" + "Estado: " + r.getEstado() +
                        "\n" + "Nombre: " + r.getNombre() +
                        "\n" + "Apellido: " + r.getApellido() +
                        "\n" + "Cedula: " + r.getCedula() +
                        "\n" + "Edad: " + r.getEdad() +
                        "\n" + "Genero: " + r.getGenero() +
                        "\n" + "Ingresos Mensuales: " + r.getIngresos() +
                        "\n" + "Egresos Mensuales: " + r.getEgresos() +
                        "\n" + "Actividad Economica: " + r.getActEconomica() +
                        "\n" + r.cedulasReferencias() +
                        "\n" + r.consultarEmpresas();
            }
        }else{
            if(clientesAceptados.containsKey(cedula)){
                Cliente c = (Cliente) clientesAceptados.get(cedula);
                if(c.getPersona() == "Persona Natural"){
                return  "Persona: " + c.getPersona() +
                        "\n" + "Estado: " + c.getEstado() +
                        "\n" + "Nombre: " + c.getNombre() +
                        "\n" + "Apellido: " + c.getApellido() +
                        "\n" + "Cedula: " + c.getCedula() +
                        "\n" + "Edad: " + c.getEdad() +
                        "\n" + "Genero: " + c.getGenero() +
                        "\n" + "Ingresos Mensuales: " + c.getIngresos() +
                        "\n" + "Egresos Mensuales: " + c.getEgresos() +
                        "\n" + "Actividad Economica: " + c.getActEconomica() +
                        "\n" + c.cedulasReferencias();
            }else{
                Representante r = (Representante) clientesAceptados.get(cedula);
                return  "Persona: " + r.getPersona() +
                        "\n" + "Estado: " + r.getEstado() +
                        "\n" + "Nombre: " + r.getNombre() +
                        "\n" + "Apellido: " + r.getApellido() +
                        "\n" + "Cedula: " + r.getCedula() +
                        "\n" + "Edad: " + r.getEdad() +
                        "\n" + "Genero: " + r.getGenero() +
                        "\n" + "Ingresos Mensuales: " + r.getIngresos() +
                        "\n" + "Egresos Mensuales: " + r.getEgresos() +
                        "\n" + "Actividad Economica: " + r.getActEconomica() +
                        "\n" + r.cedulasReferencias() +
                        "\n" + r.consultarEmpresas();
            }
        }else{
                return "No se encontró el cliente";
            }
        }
    }
    
    public String adicionarReferencias(String ced, Referencia referencia){
        String salida;
        if(clientesEnEspera.containsKey(ced)){
            Cliente c = (Cliente) clientesEnEspera.get(ced);
            if(c.getPersona() == "Persona Natural"){
                salida = c.agregarReferencias(referencia);
                clientesEnEspera.put(ced, c);
            }else{
                Representante r = (Representante) clientesEnEspera.get(ced);
                salida = r.agregarReferencias(referencia);
                clientesEnEspera.put(ced, r);
            }
        }else{
            if(clientesAceptados.containsKey(ced)){
                Cliente c = (Cliente) clientesAceptados.get(ced);
                if(c.getPersona() == "Persona Natural"){
                    salida = c.agregarReferencias(referencia);
                    clientesAceptados.put(ced, c);
                }else{
                    Representante r = (Representante) clientesAceptados.get(ced);
                    salida = r.agregarReferencias(referencia);
                    clientesAceptados.put(ced, r);
                }
            }else{
                salida = "La referencia no se pudó agregar";
            }
        }
        return salida;
    }
    
    public String modificarReferencias(String ced, Referencia referencia){
        String salida;
        if(clientesEnEspera.containsKey(ced)){
            Cliente c = (Cliente) clientesEnEspera.get(ced);
            if(c.getPersona() == "Persona Natural"){
                salida = c.modificarReferencias(referencia);
                clientesEnEspera.put(ced, c);
            }else{
                Representante r = (Representante) clientesEnEspera.get(ced);
                salida = r.modificarReferencias(referencia);
                clientesEnEspera.put(ced, r);
            }
        }else{
            if(clientesAceptados.containsKey(ced)){
                Cliente c = (Cliente) clientesAceptados.get(ced);
                if(c.getPersona() == "Persona Natural"){
                    salida = c.modificarReferencias(referencia);
                    clientesAceptados.put(ced, c);
                }else{
                    Representante r = (Representante) clientesAceptados.get(ced);
                    salida = r.modificarReferencias(referencia);
                    clientesAceptados.put(ced, r);
                }
            }else{
                salida = "La referencia no se pudó modificar";
            }
        }
        return salida;
    }
    
    public String eliminarReferencias(String ced, String cedula){
       String salida;
        if(clientesEnEspera.containsKey(ced)){
            Cliente c = (Cliente) clientesEnEspera.get(ced);
            if(c.getPersona() == "Persona Natural"){
                salida = c.eliminarReferencias(cedula);
                clientesEnEspera.put(ced, c);
            }else{
                Representante r = (Representante) clientesEnEspera.get(ced);
                salida = r.eliminarReferencias(cedula);
                clientesEnEspera.put(ced, r);
            }
        }else{
            if(clientesAceptados.containsKey(ced)){
                Cliente c = (Cliente) clientesAceptados.get(ced);
                if(c.getPersona() == "Persona Natural"){
                    salida = c.eliminarReferencias(cedula);
                    clientesAceptados.put(ced, c);
                }else{
                    Representante r = (Representante) clientesAceptados.get(ced);
                    salida = r.eliminarReferencias(cedula);
                    clientesAceptados.put(ced, r);
                }
            }else{
                salida = "La referencia no se pudó eliminar";
            }
        }
        return salida;
    }
    
    public String consultarReferencias(String ced, String cedula){
        String salida;
        if(clientesEnEspera.containsKey(ced)){
            Cliente c = (Cliente) clientesEnEspera.get(ced);
            if(c.getPersona() == "Persona Natural"){
                salida = c.consultarReferencias(cedula);
            }else{
                Representante r = (Representante) clientesEnEspera.get(ced);
                salida = r.consultarReferencias(cedula);
            }
        }else{
            if(clientesAceptados.containsKey(ced)){
                Cliente c = (Cliente) clientesAceptados.get(ced);
                if(c.getPersona() == "Persona Natural"){
                    salida = c.consultarReferencias(cedula);
                }else{
                    Representante r = (Representante) clientesAceptados.get(ced);
                    salida = r.consultarReferencias(cedula);
                }
            }else{
                salida = "No se encontró la referencia";
            }
        }
        return salida;
    }
       
    //-------------------------------------------------------------------------
    // GETS AND SETS
    //-------------------------------------------------------------------------

    public HashMap getClientesEnEspera() {
        return clientesEnEspera;
    }
    public HashMap getClientesAceptados() {
        return clientesAceptados;
    }
    
    public void setClientesEnEspera(HashMap Clientes) {
        this.clientesEnEspera = Clientes;
    }

    public void setClientesAceptados(HashMap Clientes) {
        this.clientesAceptados = Clientes;
    } 
    
    public void cargarArchivo(){
        BufferedReader br;
        String lineaMasculina;
        String parrafoMachoPechoPeludo="";
        try{
            br= new BufferedReader(new FileReader("sdnlist.txt"));
            lineaMasculina = br.readLine();
            while(lineaMasculina != null){
                //System.out.println(lineaMasculina);
                if(lineaMasculina.isEmpty()){
                    //System.out.println("hay un salto");
                    if(parrafoMachoPechoPeludo.contains("(Colombia)")){
                        //System.out.println(parrafoMachoPechoPeludo);
                        // INSERTAR metodo para leer parrafos
                        parrafoMachoPechoPeludo = "";
                    }
                    else{
                        parrafoMachoPechoPeludo = "";
                    }
                    
                }
                else{
                    //System.out.println(lineaMasculina);
                    parrafoMachoPechoPeludo= parrafoMachoPechoPeludo + "\n" + lineaMasculina;
                    //System.out.println(parrafoMachoPechoPeludo);
                    
                }
                lineaMasculina = br.readLine();
                
            }
            br.close();
            
        }
        catch(FileNotFoundException e){
            System.out.println ("Archivo no encontrado");
        }
        catch(IOException e){
            System.out.println("Algo esta mal :c");
        }
        catch(Exception e){
            System.out.println("error");
        }
    }
    // Sin probar posible fallo
    // Para que esto funcione hay que habilitar OFAC para crear un Hash de OFACS
    // Puede que falte funcion para combinar estos metodos...
    public boolean analizarParrafo(String parrafo, String id){
        String[] almacenar;
        String aux;
        boolean aid = true;
        almacenar = parrafo.split(",");
        for (int i=0; i==almacenar.length; i++){
            aux = almacenar[i];
            if (aux.contains("(Colombia)")){
            break;
            }
            if (aux.contains("Cedula No.") || aux.contains("Matricula Mercantil No") || aux.contains("NIT #")){
                if (aux.contains(id)){
                    aid= false;
                    System.out.println("usuario no aceptado");
                }
            }
        }
        return aid;
    }
    
    public static void main(String[] args){
        Banco banco = new Banco();
        banco.cargarArchivo();
    }
  
}