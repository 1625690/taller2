/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;
import java.util.*;
/**
 *
 * @author invitado
 */
public class Banco {
    Cliente cliente;
    private HashMap clientesEnEspera;
    private HashMap clientesAceptados;
    private HashMap representantesEnEspera;
    private HashMap representantesAceptados;
    
    public Banco(){
        
        this.clientesEnEspera = new HashMap();
        this.clientesAceptados = new HashMap();
        this.representantesEnEspera = new HashMap();
        this.representantesAceptados = new HashMap();
    }

    public HashMap getClientesEnEspera() {
        return clientesEnEspera;
    }
    public HashMap getClientesAceptados() {
        return clientesAceptados;
    }

    public HashMap getRepresentantesEnEspera() {
        return representantesEnEspera;
    }
    public HashMap getRepresentantesAceptados() {
        return representantesAceptados;
    }
    public void setClientesEnEspera(HashMap Clientes) {
        this.clientesEnEspera = Clientes;
    }

    public void setClientesAceptados(HashMap Clientes) {
        this.clientesAceptados = Clientes;
    }    
    public void setRepresentantesEnEspera(HashMap Representantes) {
        this.representantesEnEspera = Representantes;
    }
    public boolean revisarReferenciasCliente(Cliente cliente){
        if (cliente.getReferenciasCom().size()>=1 & cliente.getReferenciasFam().size() >=1){
            return true;
        }else{return false;}
    }
    public boolean revisarReferenciasRepresentante(Representante representate){
        if (representate.getReferenciasCom().size()>=1 & representate.getReferenciasFam().size() >=1){
            return true;
        }else{return false;}
    }    
    public String agregarClientesEnEspera(Cliente cliente){
        if (!clientesEnEspera.containsKey(cliente.getCedula())){
                clientesEnEspera.put(cliente.getCedula(), cliente);
            return "cliente adicionado con exito";
        }else{
            return "Ya existe el usuario";
        }
    }
    public String agregarClientesAceptados(Cliente cliente){
        if (!clientesAceptados.containsKey(cliente.getCedula()) & revisarReferenciasCliente(cliente)){
                clientesAceptados.put(cliente.getCedula(), cliente);
            return "cliente adicionado con exito";
        }else{
            return "Ya existe el usuario";
        }
    }
    public String agregarRepresentantesEnEspera(Cliente cliente){
        if (!representantesEnEspera.containsKey(cliente.getCedula())){
                representantesEnEspera.put(cliente.getCedula(), cliente);
            return "Representante adicionado con exito";
        }else{
            return "Ya existe el Representante";
        }
    }
    public String agregarRepresentantesAceptados(Cliente cliente){
        if (!representantesAceptados.containsKey(cliente.getCedula()) & revisarReferenciasCliente(cliente)){
                representantesAceptados.put(cliente.getCedula(), cliente);
            return "Representante adicionado con exito";
        }else{
            return "Ya existe el Representante";
        }
    }
    public String eliminarClientesEnEspera(String cedula){
        if(clientesEnEspera.containsKey(cedula)){
                clientesEnEspera.remove(cedula);
            return "Representante eliminado con exito";
        }else{
            return "el cliente no Representante";
        }
    }
    public String eliminarClientesAceptados(String cedula){
        if(clientesAceptados.containsKey(cedula)){
                clientesAceptados.remove(cedula);
            return "Representante eliminado con exito";
        }else{
            return "el cliente no Representante";
        }
    }
    public String eliminarRepresentantesEnEspera(String cedula){
        if(representantesEnEspera.containsKey(cedula)){
                representantesEnEspera.remove(cedula);
            return "Representante eliminado con exito";
        }else{
            return "el cliente no Representante";
        }
    }
    public String eliminarRepresentantesAceptados(String cedula){
        if(representantesAceptados.containsKey(cedula)){
                representantesAceptados.remove(cedula);
            return "Representante eliminado con exito";
        }else{
            return "el cliente no Representante";
        }
    }
    public String modificarClientesEnEspera(String nom, String ape, String ced, String edad, String genero, String in, String eg, String act){
        if (clientesEnEspera.containsKey(ced)){
            Cliente client;
            //Referencia referencia;
            client = (Cliente) clientesEnEspera.get(ced);
            client.setCedula(ced);
            client.setNombre(nom);
            client.setApellido(ape);
            client.setIngresos(in);
            client.setEgresos(eg);
            client.setEdad(edad);
            client.setActEconomica(act);
            //cliente.modificarReferencias(Referencia.COMERCIAL, nom, ape, ced, act);
            return "cliente modificado con exito";
        }else{
            return "No se encontro el cliente";
                    }
    }
    public String modificarClientesAceptados(String nom, String ape, String ced, String edad, String genero, String in, String eg, String act){
        if (clientesAceptados.containsKey(ced)){
            Cliente client;
            //Referencia referencia;
            client = (Cliente) clientesAceptados.get(ced);
            client.setCedula(ced);
            client.setNombre(nom);
            client.setApellido(ape);
            client.setIngresos(in);
            client.setEgresos(eg);
            client.setEdad(edad);
            client.setActEconomica(act);
            //cliente.modificarReferencias(Referencia.COMERCIAL, nom, ape, ced, act);
            return "cliente modificado con exito";
        }else{
            return "No se encontro el cliente";
                    }
    }
    public String modificarRepresentantesEnEspera(String nom, String ape, String ced, String edad, String genero, String in, String eg, String act){
        if (representantesEnEspera.containsKey(ced)){
            Cliente client;
            //Referencia referencia;
            client = (Cliente) representantesEnEspera.get(ced);
            client.setCedula(ced);
            client.setNombre(nom);
            client.setApellido(ape);
            client.setIngresos(in);
            client.setEgresos(eg);
            client.setEdad(edad);
            client.setActEconomica(act);
            //cliente.modificarReferencias(Referencia.COMERCIAL, nom, ape, ced, act);
            return "cliente modificado con exito";
        }else{
            return "No se encontro el cliente";
                    }
    }
    public String modificarRepresentantesAceptados(String nom, String ape, String ced, String edad, String genero, String in, String eg, String act){
        if (representantesAceptados.containsKey(ced)){
            Cliente client;
            //Referencia referencia;
            client = (Cliente) representantesAceptados.get(ced);
            client.setCedula(ced);
            client.setNombre(nom);
            client.setApellido(ape);
            client.setIngresos(in);
            client.setEgresos(eg);
            client.setEdad(edad);
            client.setActEconomica(act);
            //cliente.modificarReferencias(Referencia.COMERCIAL, nom, ape, ced, act);
            return "cliente modificado con exito";
        }else{
            return "No se encontro el cliente";
                    }
    }
    public Cliente consultarClientesEnEspera(String cedula){
        Cliente client; 
        client = (Cliente) clientesEnEspera.get(cedula);
        return client;
    }
    public Cliente consultarClientesAceptados(String cedula){
        Cliente client; 
        cliente = (Cliente) clientesAceptados.get(cedula);
        return cliente;
    }
    public Cliente consultarRepresentantesEnEspera(String cedula){
        Cliente client; 
        cliente = (Cliente) representantesEnEspera.get(cedula);
        return cliente;
    }
    public Cliente consultarRepresentantesAceptados(String cedula){
        Cliente client; 
        cliente = (Cliente) representantesAceptados.get(cedula);
        return cliente;
    }
    public void modificarReferenciasFam(Cliente cliente, int tipo, String nombre, String apellido, String cedula, String numeroContacto){
        cliente.modificarReferenciasFam(tipo, nombre, apellido, cedula, numeroContacto);
    }
    public void eliminarReferenciasFam(Cliente cliente, String cedula){
        cliente.eliminarReferenciasFam(cedula);
    }
    public void adicionarReferenciasFam(Cliente cliente, Referencia referencia){
        cliente.agregarReferenciasFam(referencia);
    }
    public void modificarReferencias(Cliente cliente, int tipo, String nombre, String apellido, String cedula, String numeroContacto){
        cliente.modificarReferenciasCom(tipo, nombre, apellido, cedula, numeroContacto);
    }
    public void eliminarReferencias(Cliente cliente, String cedula){
        cliente.eliminarReferenciasCom(cedula);
    }
    public void adicionarReferenciasCom(Cliente cliente, Referencia referencia){
        cliente.agregarReferenciasCom(referencia);
    }
    public void modificarReferenciasFam(Representante representante, int tipo, String nombre, String apellido, String cedula, String numeroContacto){
        representante.modificarReferenciasFam(tipo, nombre, apellido, cedula, numeroContacto);
    }
    public void eliminarReferenciasFam(Representante representante, String cedula){
        representante.eliminarReferenciasFam(cedula);
    }
    public void adicionarReferenciasFam(Representante representante, Referencia referencia){
        representante.agregarReferenciasFam(referencia);
    }
    public void modificarReferencias(Representante representante, int tipo, String nombre, String apellido, String cedula, String numeroContacto){
        representante.modificarReferenciasCom(tipo, nombre, apellido, cedula, numeroContacto);
    }
    public void eliminarReferencias(Representante representante, String cedula){
        representante.eliminarReferenciasCom(cedula);
    }
    public void adicionarReferenciasCom(Representante representante, Referencia referencia){
        representante.agregarReferenciasCom(referencia);
    }    
  
}
