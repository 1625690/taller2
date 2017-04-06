/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

/**
 *
 * @author invitado
 */
public class Cheque {
    private String valorGirado;
    private String beneficiario;
    private String fechaDeGiro;
    private String sedeBanco;;
    private String fechaDeCruze;
    // Cheque disponible
    public Cheque(){
        valorGirado = "";
        beneficiario ="";
        fechaDeGiro="";
        sedeBanco="";
        fechaDeCruze="";
    }
    //Cheque utilizado
    public Cheque(String valGirado, String benef, String fechaGiro, String sedeBank){
        this.valorGirado=valGirado;
        this.beneficiario=benef;
        this.fechaDeGiro=fechaGiro;
        this.sedeBanco=sedeBank;
        fechaDeCruze="";        
    
    }
    //Cheque cruzado
    public Cheque(String valGirado, String benef, String fechaGiro, String sedeBank, String fechaCruze){
        this.valorGirado=valGirado;
        this.beneficiario=benef;
        this.fechaDeGiro=fechaGiro;
        this.sedeBanco=sedeBank;
        this.fechaDeCruze=fechaCruze;
    }
}
