/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import java.util.*;

/**
 * Clase del representante legal de una empresa
 * Hereda los atributos y metodos de cliente
 * @author invitado
 */
public class Representante extends Cliente{

    //-------------------------------------------------------------------------
    // ATRIBUTOS
    //-------------------------------------------------------------------------
    private HashMap empresas;
    //private HashMap referencias;
    //-------------------------------------------------------------------------
    // CONSTRUCTOR
    //-------------------------------------------------------------------------
    
    /**
     * Constructor de Representante
     * @param nom - Nombre del cliente
     * @param ape - Apellido del cliente
     * @param ced - Cedula del cliente
     * @param edad -  Edad del cliente
     * @param genero - Genero del cliente
     * @param in - Ingresos del cliente
     * @param eg - Egresos del cliente
     * @param act - Actividad económica
     */
    public Representante(String per, String est, String nom, String ape, String ced, String edad, String genero, String in, String eg, String act) {
        super(per, est, nom, ape, ced, edad, genero, in, eg, act);
        this.empresas = new HashMap();
    }

    public HashMap getEmpresa() {
        return empresas;
    }
    
    public void setEmpresa(HashMap empresa) {
        this.empresas = empresa;
    }
    
    public String agregarEmpresas(Empresa empresa){
        if (!empresas.containsKey(empresa.getNit())){
                empresas.put(empresa.getNit(), empresa);
            return "La empresa se agregó exitosamente";
        }else{
            return "La empresa no se pudó agregar";
        }
    }
    
    public boolean verificarEmpresa(String nit){
        if(empresas.containsKey(nit)){
            return true;
        }else{
            return false;
        }
    }
    
    public String consultarEmpresas(){
        String salida = "Empresas: ";
        Set nits = empresas.keySet();
        Iterator i = nits.iterator();
        while(i.hasNext()){
            String nit = (String) i.next();
            Empresa e = (Empresa) empresas.get(nit);
            salida += e.getNit() + ", " + e.getRazonSocial() + "\n";
        }
        return salida;
    }
}
    
   
 

