/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import java.util.*;
/**
 * Representa un cliente dentro de la entidad bancaria
 * @author invitado
 */
public class Cliente {
    
    //-------------------------------------------------------------------------
    // ATRIBUTOS
    //-------------------------------------------------------------------------
    
    /**
     * Atributos 
     */
    private String persona, estado, nombre, apellido, cedula, edad, genero, ingresos, egresos, actEconomica;
    
    /**
     * Coleccion con las referencias del cliente
     */
    private HashMap referencias;
    private CuentaCorriente cuentaCorriente;
    private CuentaDeAhorros cuentaDeAhorros;
    private TarjetaDeCredito tarjetaC;
    private TarjetaDebito tarjetaD;
    private Chequera chequera;
    
    
    //-------------------------------------------------------------------------
    // CONSTRUCTOR
    //-------------------------------------------------------------------------
    
    /**
     * Constructor de Cliente
     * @param nom - Nombre del cliente
     * @param ape - Apellido del cliente
     * @param ced - Cedula del cliente
     * @param edad -  Edad del cliente
     * @param genero - Genero del cliente
     * @param in - Ingresos del cliente
     * @param eg - Egresos del cliente
     * @param act - Actividad económica
     */
    public Cliente(String per, String est, String nom, String ape, String ced, String edad, String genero, String in, String eg, String act){
        this.persona = per;
        this.estado = est;
        this.nombre = nom;
        this.apellido = ape;
        this.cedula = ced;  
        this.edad = edad;
        this.genero = genero;
        this.ingresos = in;
        this.egresos = eg;
        this.actEconomica = act;
        this.referencias = new HashMap();
        this.cuentaCorriente = null;
        this.cuentaDeAhorros = null;
        this.tarjetaC = null;
        this.tarjetaD = null;
        this.chequera = null;
    }
    
    //-------------------------------------------------------------------------
    // GETS & SETS
    //-------------------------------------------------------------------------

    public String getPersona() {
        return persona;
    }

    public String getEstado() {
        return estado;
    }
    
    public String getNombre() {
        return nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public String getCedula() {
        return cedula;
    }

    public String getEdad() {
        return edad;
    }

    public String getGenero() {
        return genero;
    }

    public String getIngresos() {
        return ingresos;
    }

    public String getEgresos() {
        return egresos;
    }

    public String getActEconomica() {
        return actEconomica;
    }

    public HashMap getReferencias() {
        return referencias;
    }  

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setPersona(String persona) {
        this.persona = persona;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public void setCedula(String cedula) {
        this.cedula = cedula;
    }

    public void setEdad(String edad) {
        this.edad = edad;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public void setIngresos(String ingresos) {
        this.ingresos = ingresos;
    }

    public void setEgresos(String egresos) {
        this.egresos = egresos;
    }

    public void setActEconomica(String actEconomica) {
        this.actEconomica = actEconomica;
    }

    public void setReferencias(HashMap referencias) {
        this.referencias = referencias;
    }

    public CuentaCorriente getCuentaCorriente() {
        return cuentaCorriente;
    }

    public CuentaDeAhorros getCuentaDeAhorros() {
        return cuentaDeAhorros;
    }

    public TarjetaDeCredito getTarjetaC() {
        return tarjetaC;
    }

    public TarjetaDebito getTarjetaD() {
        return tarjetaD;
    }

    public Chequera getChequera() {
        return chequera;
    }

    public void setCuentaCorriente(CuentaCorriente cuentaCorriente) {
        this.cuentaCorriente = cuentaCorriente;
    }

    public void setCuentaDeAhorros(CuentaDeAhorros cuentaDeAhorros) {
        this.cuentaDeAhorros = cuentaDeAhorros;
    }

    public void setTarjetaC(TarjetaDeCredito tarjetaC) {
        this.tarjetaC = tarjetaC;
    }

    public void setTarjetaD(TarjetaDebito tarjetaD) {
        this.tarjetaD = tarjetaD;
    }

    public void setChequera(Chequera chequera) {
        this.chequera = chequera;
    }
    
    
    
    public String agregarReferencias(Referencia referencia){
        if (!referencias.containsKey(referencia.getCedula())){
                referencias.put(referencia.getCedula(), referencia);
            return "La referencia se agregó con exito";
        }else{
            return "No se pudó agregar la referencia";
        }
    }
    public String eliminarReferencias(String cedula){
        if(referencias.containsKey(cedula)){
                referencias.remove(cedula);
            return "La referencia se ha eliminado exitosamente";
        }else{
            return "La referencia no se pudó eliminar";
        }
    }
    
    public String modificarReferencias(Referencia referencia){
        if(referencias.containsKey(referencia.getCedula())){
            referencias.put(referencia.getCedula(), referencia);
            return "Referencia modificada correctamente";
        }else{
            return "No exite la referencia a modificar";
        }
    }
    
    public String consultarReferencias(String cedula){
        if(referencias.containsKey(cedula)){
            Referencia ref = (Referencia) referencias.get(cedula);
            return  "Tipo: "+ ref.getTipo() +
                    "\n" + "Nombre: " + ref.getNombre() +
                    "\n" + "Apellido: " + ref.getApellido() +
                    "\n" + "Cedula: " + ref.getCedula() +
                    "\n" + "# de Contacto: " + ref.getNumeroContacto();
        }else{
            return "No se encontro la referencia";
        }
    }
    
    public String cedulasReferencias(){
        String salida = "Referencias: ";
        Set cedulas = referencias.keySet();
        Iterator i = cedulas.iterator();
        while(i.hasNext()){
            String ced = (String) i.next();
            Referencia ref = (Referencia) referencias.get(ced);
            salida += ref.getCedula() + "\n";
        }
        return salida;
    }
    
    public boolean revisarReferencias(){
        boolean hayRefFam = false;
        boolean hayRefCom = false;
        boolean estanAmbas = false;
        
        Set cedulas = referencias.keySet();
        Iterator i = cedulas.iterator();
        while(i.hasNext() && (hayRefFam == false)){
            String ced = (String) i.next();
            Referencia ref = (Referencia) referencias.get(ced);
            if(ref.getTipo() == "Referencia Familiar"){
                hayRefFam = true;
            }else{
                hayRefFam = false;
            }
        }
        while(i.hasNext() && (hayRefCom == false)){
            String ced = (String) i.next();
            Referencia ref = (Referencia) referencias.get(ced);
            if(ref.getTipo() == "Referencia Comercial"){
                hayRefCom = true;
            }else{
                hayRefCom = false;
            }
        }
        
        if((hayRefFam == true) && (hayRefCom == true)){
            estanAmbas = true;
        }else{
            estanAmbas = false;
        }
        return estanAmbas;
    }
    
    public void crearCCorriente(String num, String saldo, String DS, String IRM){
        cuentaCorriente = new CuentaCorriente(num, saldo, DS, IRM);
    }
    
    public String consultarCCorriente(){
        if(cuentaCorriente != null){
        return  "Número de cuenta: "+ cuentaCorriente.getNumeroCuenta() +
                "\n" + "Saldo: " + cuentaCorriente.getSaldo() +
                "\n" + "Disponibilidad de sobregiro: " + cuentaCorriente.getDisponibilidadDeSobregiro() +
                "\n" + "Interés de rentabilidad mensual: " + cuentaCorriente.getInteresDeRentabilidadMensual();
        }else{
            return "No se encontro cuenta";
        }
    }
    
    public void crearCAhorros(String num, String saldo, String IRM){
        cuentaDeAhorros = new CuentaDeAhorros(num, saldo, IRM);
    }
    
    public String consultarCAhorros(){
        return  "Número de cuenta: "+ cuentaDeAhorros.getNumeroCuenta() +
                "\n" + "Saldo: " + cuentaDeAhorros.getSaldo() +
                "\n" + "Interés de rentabilidad mensual: " + cuentaDeAhorros.getInteresDeRentabilidadMensual();
    }
    
    public void crearTCredito(String numTarjeta, String numSeguridad, String cupoT, String gastoT, String cupoA, String expedicion, String vencimiento, String contraseña){
        tarjetaC = new TarjetaDeCredito(numTarjeta, numSeguridad, cupoT, gastoT, cupoA, expedicion, vencimiento, contraseña);
    }
    
    public String consultarTCredito(){
        return  "Número de tarjeta: "+ tarjetaC.getNumeroTarjeta() +
                "\n" + "Número de seguridad: " + tarjetaC.getNumeroSeguridad() +
                "\n" + "Cupo Total: " + tarjetaC.getCupoTotal() +
                "\n" + "Gasto Total: " + tarjetaC.getGastoTotal() +
                "\n" + "Cupo para avances: " + tarjetaC.getCupoAvances() +
                "\n" + "Fecha expedición: " + tarjetaC.getFechaExpedicion() +
                "\n" + "Fecha vencimiento: " + tarjetaC.getFechaDeVencimiento() +
                "\n" + "Contraseña para avances: " + tarjetaC.getCupoTotal();
    }
    
    public void crearTDebito(String expedicion, String estado){
        tarjetaD = new TarjetaDebito(expedicion, estado);
    }
    
    public String consultarTDebito(){
        return  "Fecha de expedición: "+ tarjetaD.getFechaDeExpedicion() +
                "\n" + "Estado: " + tarjetaD.getEstado() +
                "\n" + "Cuenta de ahorros: " + tarjetaD.numeroCA() +
                "\n" + "Cuenta Corriente: " + tarjetaD.numeroCC();
    }
    
    public void crearChequera(String numChequera){
        chequera = new Chequera(numChequera);
    }
    
    public String consultarChequera(){
        return "Número de chequera: "+ chequera.getNumeroChequera() +
                "\n" + "Cantidad de cheques: " + chequera.getCantidadCheques() +
                "\n" + chequera.consultarCheque();
    }
    
    public void asociarCCTDevito(){
        CuentaCorriente cc = cuentaCorriente;
        tarjetaD.asociarCCorriente(cc);
    }
    
    public void asociarCATDevito(){
        CuentaDeAhorros ca = cuentaDeAhorros;
        tarjetaD.asociarCAhorros(ca);
    }
    
    public void asociarCCChequera(){
        CuentaCorriente cc = cuentaCorriente;
        chequera.asociarCCorriente(cc);
    }
    
    public void agregarCheque(Cheque cheque){
        chequera.agregarCheque(cheque);
    }
    
   public String numeroCuentaC(){
       if(cuentaCorriente != null){
           return cuentaCorriente.getNumeroCuenta();
       }else{
           return "No tiene";
       }
   }
}

        
    
        
    