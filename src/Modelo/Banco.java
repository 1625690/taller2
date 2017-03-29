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
    
    private HashMap clientes;
    private HashMap representantes;
    
    public Banco(){
        
        this.clientes = new HashMap();
        this.representantes = new HashMap();
    }

    public HashMap getClientes() {
        return clientes;
    }

    public HashMap getRepresentantes() {
        return representantes;
    }

    public void setClientes(HashMap Clientes) {
        this.clientes = Clientes;
    }

    public void setRepresentantes(HashMap Representantes) {
        this.representantes = Representantes;
    }
    
    public void agregarClientes(Cliente cliente){
        clientes.put(cliente.getCedula(), cliente);
    }
    public void eliminarCliente(Cliente cliente){
        clientes.remove(cliente.getCedula());
    }
    public void modificarCliente(String nom, String ape, String ced, String edad, String genero, String in, String eg, String act){
        Cliente cliente;
        Referencia referencia;
        cliente = (Cliente) clientes.get(ced);
        cliente.setCedula(ced);
        cliente.setNombre(nom);
        cliente.setApellido(ape);
        cliente.setIngresos(in);
        cliente.setEgresos(eg);
        cliente.setEdad(edad);
        cliente.setActEconomica(act);
        //cliente.modificarReferencias(Referencia.COMERCIAL, nom, ape, ced, act);
    }
    
}
