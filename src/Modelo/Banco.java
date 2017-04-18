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
    private HashMap empresas;
    private HashMap empresasConRepresentante;
    private HashMap cuentasCorriente;
    private HashMap cuentasDeAhorros;
    private HashMap tarjetasDeCredito;
    private HashMap chequeras;
    
    //-------------------------------------------------------------------------
    // CONSTRUCTOR
    //-------------------------------------------------------------------------
    
    public Banco(){
        
        this.clientesEnEspera = new HashMap();
        this.clientesAceptados = new HashMap();
        this.OFAC = new HashMap();
        this.empresas = new HashMap();
        this.empresasConRepresentante = new HashMap();
    }
    
    public String adicionarEmpresa(Empresa empresa){
        if (!empresas.containsKey(empresa.getNit())){
                empresas.put(empresa.getNit(), empresa);
            return "La empresa se agregó exitosamente";
        }else{
            return "La empresa no se pudó agregar";
        }
    }
    
    public String agregarEmpresa(String ced, String nit){
        if(!empresasConRepresentante.containsKey(nit)){
            if(clientesEnEspera.containsKey(ced) && empresas.containsKey(nit)){
            Representante r = (Representante) clientesEnEspera.get(ced);
            Empresa e = (Empresa) empresas.get(nit);
            if(r.getPersona() == "Representante Legal"){
                empresasConRepresentante.put(nit, e);
                return r.agregarEmpresas(e);
            }else{
                return "La empresa no se pudó agregar";
            }
        }else{
            if(clientesAceptados.containsKey(ced) && empresas.containsKey(nit)){
                Representante r = (Representante) clientesAceptados.get(ced);
                Empresa e = (Empresa) empresas.get(nit);
                if(r.getPersona() == "Representante Legal"){
                    empresasConRepresentante.put(nit, e);
                    return r.agregarEmpresas(e);
                }else{
                    return "La empresa no se pudó agregar";
                }
            }else{
                return "La empresa no se pudó agregar";
            }
        }
        }else{
            return "La empresa no se pudó agregar";
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
                CuentaCorriente cc = c.getCuentaCorriente();
                CuentaDeAhorros ca = c.getCuentaDeAhorros();
                TarjetaDeCredito tc = c.getTarjetaC();
                TarjetaDebito td = c.getTarjetaD();
                Chequera che = c.getChequera();
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
                        "\n" + c.cedulasReferencias() +
                        "\n" + "Cuenta corriente: " + cc.getNumeroCuenta() +
                        "\n" + "Cuenta de ahorros: " + ca.getNumeroCuenta() +
                        "\n" + "Tarjeta de credito: " + tc.getNumeroTarjeta() +
                        "\n" + "Tarjeta debito: " + td.getEstado() +
                        "\n" + "Chequera: " + che.getNumeroChequera();
            }else{
                Representante r = (Representante) clientesEnEspera.get(cedula);
                CuentaCorriente cc = r.getCuentaCorriente();
                CuentaDeAhorros ca = r.getCuentaDeAhorros();
                TarjetaDeCredito tc = r.getTarjetaC();
                TarjetaDebito td = r.getTarjetaD();
                Chequera che = r.getChequera();
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
                        "\n" + r.consultarEmpresas() +
                        "\n" + "Cuenta corriente: " + cc.getNumeroCuenta() +
                        "\n" + "Cuenta de ahorros: " + ca.getNumeroCuenta() +
                        "\n" + "Tarjeta de credito: " + tc.getNumeroTarjeta() +
                        "\n" + "Tarjeta debito: " + td.getEstado() +
                        "\n" + "Chequera: " + che.getNumeroChequera();
            }
        }else{
            if(clientesAceptados.containsKey(cedula)){
                Cliente c = (Cliente) clientesAceptados.get(cedula);
                if(c.getPersona() == "Persona Natural"){
                CuentaCorriente cc = c.getCuentaCorriente();
                CuentaDeAhorros ca = c.getCuentaDeAhorros();
                TarjetaDeCredito tc = c.getTarjetaC();
                TarjetaDebito td = c.getTarjetaD();
                Chequera che = c.getChequera();
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
                        "\n" + c.cedulasReferencias() +
                        "\n" + "Cuenta corriente: " + cc.getNumeroCuenta() +
                        "\n" + "Cuenta de ahorros: " + ca.getNumeroCuenta() +
                        "\n" + "Tarjeta de credito: " + tc.getNumeroTarjeta() +
                        "\n" + "Tarjeta debito: " + td.getEstado() +
                        "\n" + "Chequera: " + che.getNumeroChequera();    
            }else{
                Representante r = (Representante) clientesAceptados.get(cedula);
                CuentaCorriente cc = r.getCuentaCorriente();
                CuentaDeAhorros ca = r.getCuentaDeAhorros();
                TarjetaDeCredito tc = r.getTarjetaC();
                TarjetaDebito td = r.getTarjetaD();
                Chequera che = r.getChequera();
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
                        "\n" + r.consultarEmpresas() +
                        "\n" + "Cuenta corriente: " + cc.getNumeroCuenta() +
                        "\n" + "Cuenta de ahorros: " + ca.getNumeroCuenta() +
                        "\n" + "Tarjeta de credito: " + tc.getNumeroTarjeta() +
                        "\n" + "Tarjeta debito: " + td.getEstado() +
                        "\n" + "Chequera: " + che.getNumeroChequera();
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
    
    public String agregarCuentaCorriente(String cedula, String num, String saldo, String DS, String IRM){
        String salida = "";
        if(!cuentasCorriente.containsKey(num)){
        if(clientesEnEspera.containsKey(cedula)){
            Cliente c = (Cliente) clientesEnEspera.get(cedula);
            if(c.getPersona() == "Persona Natural"){
                c.crearCCorriente(num, saldo, DS, IRM);
                CuentaCorriente cc = new CuentaCorriente(num, saldo, DS, IRM);
                cuentasCorriente.put(num, cc);
                salida = "La Cuente se agrego exitosamente";
                clientesEnEspera.put(cedula, c);
            }else{
                Representante r = (Representante) clientesEnEspera.get(cedula);
                r.crearCCorriente(num, saldo, DS, IRM);
                CuentaCorriente cc = new CuentaCorriente(num, saldo, DS, IRM);
                cuentasCorriente.put(num, cc);
                salida = "La Cuente se agrego exitosamente";
                clientesEnEspera.put(cedula, r);
            }
        }else{
            if(clientesAceptados.containsKey(cedula)){
                Cliente c = (Cliente) clientesAceptados.get(cedula);
                if(c.getPersona() == "Persona Natural"){
                    c.crearCCorriente(num, saldo, DS, IRM);
                    CuentaCorriente cc = new CuentaCorriente(num, saldo, DS, IRM);
                    cuentasCorriente.put(num, cc);
                    salida = "La Cuente se agrego exitosamente";
                    clientesAceptados.put(cedula, c);
                }else{
                    Representante r = (Representante) clientesAceptados.get(cedula);
                    r.crearCCorriente(num, saldo, DS, IRM);
                    CuentaCorriente cc = new CuentaCorriente(num, saldo, DS, IRM);
                    cuentasCorriente.put(num, cc);
                    salida = "La Cuente se agrego exitosamente";
                    clientesAceptados.put(cedula, r);
                }
            }else{
                salida = "La cuenta no se pudó agregar";
            }
        }
        }else{
            salida = "La cuenta no se pudó agregar";
        }
        return salida;
    }
    
    public String agregarCuentaAhorros(String cedula, String num, String saldo, String IRM){
        String salida = "";
        if(!cuentasDeAhorros.containsKey(num)){
        if(clientesEnEspera.containsKey(cedula)){
            Cliente c = (Cliente) clientesEnEspera.get(cedula);
            if(c.getPersona() == "Persona Natural"){
                c.crearCAhorros(num, saldo, IRM);
                CuentaDeAhorros ca = new CuentaDeAhorros(num, saldo, IRM);
                cuentasDeAhorros.put(num, ca);
                salida = "La Cuente se agrego exitosamente";
                clientesEnEspera.put(cedula, c);
            }else{
                Representante r = (Representante) clientesEnEspera.get(cedula);
                r.crearCAhorros(num, saldo, IRM);
                CuentaDeAhorros ca = new CuentaDeAhorros(num, saldo, IRM);
                cuentasDeAhorros.put(num, ca);
                salida = "La Cuente se agrego exitosamente";
                clientesEnEspera.put(cedula, r);
            }
        }else{
            if(clientesAceptados.containsKey(cedula)){
                Cliente c = (Cliente) clientesAceptados.get(cedula);
                if(c.getPersona() == "Persona Natural"){
                    c.crearCAhorros(num, saldo, IRM);
                    CuentaDeAhorros ca = new CuentaDeAhorros(num, saldo, IRM);
                    cuentasDeAhorros.put(num, ca);
                    salida = "La Cuente se agrego exitosamente";
                    clientesAceptados.put(cedula, c);
                }else{
                    Representante r = (Representante) clientesAceptados.get(cedula);
                    r.crearCAhorros(num, saldo, IRM);
                    CuentaDeAhorros ca = new CuentaDeAhorros(num, saldo, IRM);
                    cuentasDeAhorros.put(num, ca);
                    salida = "La Cuente se agrego exitosamente";
                    clientesAceptados.put(cedula, r);
                }
            }else{
                salida = "La cuenta no se pudó agregar";
            }
        }
        }else{
            salida = "La cuenta no se pudó agregar";
        }
        return salida;
    }
    
    public String agregarTCredito(String cedula, String numTarjeta, String numSeguridad, String cupoT, String gastoT, String cupoA, String expedicion, String vencimiento, String contraseña){
        String salida = "";
        if(!tarjetasDeCredito.containsKey(numTarjeta)){
        if(clientesEnEspera.containsKey(cedula)){
            Cliente c = (Cliente) clientesEnEspera.get(cedula);
            if(c.getPersona() == "Persona Natural"){
                c.crearTCredito(numTarjeta, numSeguridad, cupoT, gastoT, cupoA, expedicion, vencimiento, contraseña);
                TarjetaDeCredito tC = new TarjetaDeCredito(numTarjeta, numSeguridad, cupoT, gastoT, cupoA, expedicion, vencimiento, contraseña);
                tarjetasDeCredito.put(numTarjeta, tC);
                salida = "La tarjeta se agrego exitosamente";
                clientesEnEspera.put(cedula, c);
            }else{
                Representante r = (Representante) clientesEnEspera.get(cedula);
                r.crearTCredito(numTarjeta, numSeguridad, cupoT, gastoT, cupoA, expedicion, vencimiento, contraseña);
                TarjetaDeCredito tC = new TarjetaDeCredito(numTarjeta, numSeguridad, cupoT, gastoT, cupoA, expedicion, vencimiento, contraseña);
                tarjetasDeCredito.put(numTarjeta, tC);
                salida = "La tarjeta se agrego exitosamente";
                clientesEnEspera.put(cedula, r);
            }
        }else{
            if(clientesAceptados.containsKey(cedula)){
                Cliente c = (Cliente) clientesAceptados.get(cedula);
                if(c.getPersona() == "Persona Natural"){
                    c.crearTCredito(numTarjeta, numSeguridad, cupoT, gastoT, cupoA, expedicion, vencimiento, contraseña);
                    TarjetaDeCredito tC = new TarjetaDeCredito(numTarjeta, numSeguridad, cupoT, gastoT, cupoA, expedicion, vencimiento, contraseña);
                    tarjetasDeCredito.put(numTarjeta, tC);
                    salida = "La tarjeta se agrego exitosamente";
                    clientesAceptados.put(cedula, c);
                }else{
                    Representante r = (Representante) clientesAceptados.get(cedula);
                    r.crearTCredito(numTarjeta, numSeguridad, cupoT, gastoT, cupoA, expedicion, vencimiento, contraseña);
                    TarjetaDeCredito tC = new TarjetaDeCredito(numTarjeta, numSeguridad, cupoT, gastoT, cupoA, expedicion, vencimiento, contraseña);
                    tarjetasDeCredito.put(numTarjeta, tC);
                    salida = "La tarjeta se agrego exitosamente";
                    clientesAceptados.put(cedula, r);
                }
            }else{
                salida = "La tarjeta no se pudó agregar";
            }
        }
        }else{
            salida = "La tarjeta no se pudó agregar";
        }
        return salida;
    }
    
    public String agregarTDebito(String cedula, String expedicion, String estado){
        String salida = "";
        if(clientesEnEspera.containsKey(cedula)){
            Cliente c = (Cliente) clientesEnEspera.get(cedula);
            if(c.getPersona() == "Persona Natural"){
                c.crearTDebito(expedicion, estado);
                salida = "La tarjeta se agrego exitosamente";
                clientesEnEspera.put(cedula, c);
            }else{
                Representante r = (Representante) clientesEnEspera.get(cedula);
                r.crearTDebito(expedicion, estado);
                salida = "La tarjeta se agrego exitosamente";
                clientesEnEspera.put(cedula, r);
            }
        }else{
            if(clientesAceptados.containsKey(cedula)){
                Cliente c = (Cliente) clientesAceptados.get(cedula);
                if(c.getPersona() == "Persona Natural"){
                    c.crearTDebito(expedicion, estado);
                    salida = "La tarjeta se agrego exitosamente";
                    clientesAceptados.put(cedula, c);
                }else{
                    Representante r = (Representante) clientesAceptados.get(cedula);
                    r.crearTDebito(expedicion, estado);
                    salida = "La tarjeta se agrego exitosamente";
                    clientesAceptados.put(cedula, r);
                }
            }else{
                salida = "La tarjeta no se pudó agregar";
            }
        }
        return salida;
    }
    
    public String agregarChequera(String cedula, String numChequera){
        String salida = "";
        if(!tarjetasDeCredito.containsKey(numChequera)){
        if(clientesEnEspera.containsKey(cedula)){
            Cliente c = (Cliente) clientesEnEspera.get(cedula);
            if(c.getPersona() == "Persona Natural"){
                c.crearChequera(numChequera);
                Chequera che = new Chequera(numChequera);
                chequeras.put(numChequera, che);
                salida = "La tarjeta se agrego exitosamente";
                clientesEnEspera.put(cedula, c);
            }else{
                Representante r = (Representante) clientesEnEspera.get(cedula);
                r.crearChequera(numChequera);
                Chequera che = new Chequera(numChequera);
                chequeras.put(numChequera, che);
                salida = "La tarjeta se agrego exitosamente";
                clientesEnEspera.put(cedula, r);
            }
        }else{
            if(clientesAceptados.containsKey(cedula)){
                Cliente c = (Cliente) clientesAceptados.get(cedula);
                if(c.getPersona() == "Persona Natural"){
                    c.crearChequera(numChequera);
                    Chequera che = new Chequera(numChequera);
                    chequeras.put(numChequera, che);
                    salida = "La tarjeta se agrego exitosamente";
                    clientesAceptados.put(cedula, c);
                }else{
                    Representante r = (Representante) clientesAceptados.get(cedula);
                    r.crearChequera(numChequera);
                    Chequera che = new Chequera(numChequera);
                    chequeras.put(numChequera, che);
                    salida = "La tarjeta se agrego exitosamente";
                    clientesAceptados.put(cedula, r);
                }
            }else{
                salida = "La tarjeta no se pudó agregar";
            }
        }
        }else{
            salida = "La tarjeta no se pudó agregar";
        }
        return salida;
    }
    
    public String consultarCuentaCorriente(String ced){
        String salida;
        if(clientesEnEspera.containsKey(ced)){
            Cliente c = (Cliente) clientesEnEspera.get(ced);
            if(c.getPersona() == "Persona Natural"){
                salida = c.consultarCCorriente();
            }else{
                Representante r = (Representante) clientesEnEspera.get(ced);
                salida = r.consultarCCorriente();
            }
        }else{
            if(clientesAceptados.containsKey(ced)){
                Cliente c = (Cliente) clientesAceptados.get(ced);
                if(c.getPersona() == "Persona Natural"){
                    salida = c.consultarCCorriente();
                }else{
                    Representante r = (Representante) clientesAceptados.get(ced);
                    salida = r.consultarCCorriente();
                }
            }else{
                salida = "No se encontró la cuenta corriente";
            }
        }
        return salida;
    }
    
    public String consultarCuentaAhorros(String ced){
        String salida;
        if(clientesEnEspera.containsKey(ced)){
            Cliente c = (Cliente) clientesEnEspera.get(ced);
            if(c.getPersona() == "Persona Natural"){
                salida = c.consultarCAhorros();
            }else{
                Representante r = (Representante) clientesEnEspera.get(ced);
                salida = r.consultarCAhorros();
            }
        }else{
            if(clientesAceptados.containsKey(ced)){
                Cliente c = (Cliente) clientesAceptados.get(ced);
                if(c.getPersona() == "Persona Natural"){
                    salida = c.consultarCAhorros();
                }else{
                    Representante r = (Representante) clientesAceptados.get(ced);
                    salida = r.consultarCAhorros();
                }
            }else{
                salida = "No se encontró la cuenta corriente";
            }
        }
        return salida;
    }
    
    public String consultarTCredito(String ced){
        String salida;
        if(clientesEnEspera.containsKey(ced)){
            Cliente c = (Cliente) clientesEnEspera.get(ced);
            if(c.getPersona() == "Persona Natural"){
                salida = c.consultarTCredito();
            }else{
                Representante r = (Representante) clientesEnEspera.get(ced);
                salida = r.consultarTCredito();
            }
        }else{
            if(clientesAceptados.containsKey(ced)){
                Cliente c = (Cliente) clientesAceptados.get(ced);
                if(c.getPersona() == "Persona Natural"){
                    salida = c.consultarTCredito();
                }else{
                    Representante r = (Representante) clientesAceptados.get(ced);
                    salida = r.consultarTCredito();
                }
            }else{
                salida = "No se encontró la cuenta corriente";
            }
        }
        return salida;
    }
    
    public String consultarTDebito(String ced){
        String salida;
        if(clientesEnEspera.containsKey(ced)){
            Cliente c = (Cliente) clientesEnEspera.get(ced);
            if(c.getPersona() == "Persona Natural"){
                salida = c.consultarTDebito();
            }else{
                Representante r = (Representante) clientesEnEspera.get(ced);
                salida = r.consultarTDebito();
            }
        }else{
            if(clientesAceptados.containsKey(ced)){
                Cliente c = (Cliente) clientesAceptados.get(ced);
                if(c.getPersona() == "Persona Natural"){
                    salida = c.consultarTDebito();
                }else{
                    Representante r = (Representante) clientesAceptados.get(ced);
                    salida = r.consultarTDebito();
                }
            }else{
                salida = "No se encontró la cuenta corriente";
            }
        }
        return salida;
    }
    
    public String consultarChequera(String ced){
        String salida;
        if(clientesEnEspera.containsKey(ced)){
            Cliente c = (Cliente) clientesEnEspera.get(ced);
            if(c.getPersona() == "Persona Natural"){
                salida = c.consultarChequera();
            }else{
                Representante r = (Representante) clientesEnEspera.get(ced);
                salida = r.consultarChequera();
            }
        }else{
            if(clientesAceptados.containsKey(ced)){
                Cliente c = (Cliente) clientesAceptados.get(ced);
                if(c.getPersona() == "Persona Natural"){
                    salida = c.consultarChequera();
                }else{
                    Representante r = (Representante) clientesAceptados.get(ced);
                    salida = r.consultarChequera();
                }
            }else{
                salida = "No se encontró la cuenta corriente";
            }
        }
        return salida;
    }
    
    public String asociarCCTDevito(String ced){
        String salida;
        if(clientesEnEspera.containsKey(ced)){
            Cliente c = (Cliente) clientesEnEspera.get(ced);
            if(c.getPersona() == "Persona Natural"){
                c.asociarCCTDevito();
                salida = "Asociación exitosa";
                clientesEnEspera.put(ced, c);
            }else{
                Representante r = (Representante) clientesEnEspera.get(ced);
                r.asociarCCTDevito();
                salida = "Asociación exitosa";
                clientesEnEspera.put(ced, r);
            }
        }else{
            if(clientesAceptados.containsKey(ced)){
                Cliente c = (Cliente) clientesAceptados.get(ced);
                if(c.getPersona() == "Persona Natural"){
                    c.asociarCCTDevito();
                    salida = "Asociación exitosa";
                    clientesAceptados.put(ced, c);
                }else{
                    Representante r = (Representante) clientesAceptados.get(ced);
                    r.asociarCCTDevito();
                    salida = "Asociación exitosa";
                    clientesAceptados.put(ced, r);
                }
            }else{
                salida = "No se pudó asociar";
            }
        }
        return salida;
    }
    
    public String asociarCATDevito(String ced){
        String salida;
        if(clientesEnEspera.containsKey(ced)){
            Cliente c = (Cliente) clientesEnEspera.get(ced);
            if(c.getPersona() == "Persona Natural"){
                c.asociarCATDevito();
                salida = "Asociación exitosa";
                clientesEnEspera.put(ced, c);
            }else{
                Representante r = (Representante) clientesEnEspera.get(ced);
                r.asociarCATDevito();
                salida = "Asociación exitosa";
                clientesEnEspera.put(ced, r);
            }
        }else{
            if(clientesAceptados.containsKey(ced)){
                Cliente c = (Cliente) clientesAceptados.get(ced);
                if(c.getPersona() == "Persona Natural"){
                    c.asociarCATDevito();
                    salida = "Asociación exitosa";
                    clientesAceptados.put(ced, c);
                }else{
                    Representante r = (Representante) clientesAceptados.get(ced);
                    r.asociarCATDevito();
                    salida = "Asociación exitosa";
                    clientesAceptados.put(ced, r);
                }
            }else{
                salida = "No se pudó asociar";
            }
        }
        return salida;
    }
    
    public String asociarCCChequera(String ced){
        String salida;
        if(clientesEnEspera.containsKey(ced)){
            Cliente c = (Cliente) clientesEnEspera.get(ced);
            if(c.getPersona() == "Persona Natural"){
                c.asociarCCChequera();
                salida = "Asociación exitosa";
                clientesEnEspera.put(ced, c);
            }else{
                Representante r = (Representante) clientesEnEspera.get(ced);
                r.asociarCCChequera();
                salida = "Asociación exitosa";
                clientesEnEspera.put(ced, r);
            }
        }else{
            if(clientesAceptados.containsKey(ced)){
                Cliente c = (Cliente) clientesAceptados.get(ced);
                if(c.getPersona() == "Persona Natural"){
                    c.asociarCCChequera();
                    salida = "Asociación exitosa";
                    clientesAceptados.put(ced, c);
                }else{
                    Representante r = (Representante) clientesAceptados.get(ced);
                    r.asociarCCChequera();
                    salida = "Asociación exitosa";
                    clientesAceptados.put(ced, r);
                }
            }else{
                salida = "No se pudó asociar";
            }
        }
        return salida;
    }
    
    public String agregarCheque(String ced, String estado, String valor, String beneficiario, String fechaG, String sede, boolean cruzado, String fechaC){
        String salida;
        if(clientesEnEspera.containsKey(ced)){
            Cliente c = (Cliente) clientesEnEspera.get(ced);
            if(c.getPersona() == "Persona Natural"){
                Cheque cheque = new Cheque(estado, valor, beneficiario, fechaG, sede, cruzado, fechaC);
                c.agregarCheque(cheque);
                salida = "Asociación exitosa";
                clientesEnEspera.put(ced, c);
            }else{
                Representante r = (Representante) clientesEnEspera.get(ced);
                Cheque cheque = new Cheque(estado, valor, beneficiario, fechaG, sede, cruzado, fechaC);
                r.agregarCheque(cheque);
                salida = "Asociación exitosa";
                clientesEnEspera.put(ced, r);
            }
        }else{
            if(clientesAceptados.containsKey(ced)){
                Cliente c = (Cliente) clientesAceptados.get(ced);
                if(c.getPersona() == "Persona Natural"){
                    Cheque cheque = new Cheque(estado, valor, beneficiario, fechaG, sede, cruzado, fechaC);
                    c.agregarCheque(cheque);
                    salida = "Asociación exitosa";
                    clientesAceptados.put(ced, c);
                }else{
                    Representante r = (Representante) clientesAceptados.get(ced);
                    Cheque cheque = new Cheque(estado, valor, beneficiario, fechaG, sede, cruzado, fechaC);
                    r.agregarCheque(cheque);
                    salida = "Asociación exitosa";
                    clientesAceptados.put(ced, r);
                }
            }else{
                salida = "No se pudó asociar";
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