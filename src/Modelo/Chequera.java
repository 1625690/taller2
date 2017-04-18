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
public class Chequera {
    private CuentaCorriente cuentaC;
    private String numeroChequera, cantidadCheques;
    private HashSet cheques;
    
    public Chequera(String numChequera){
        CuentaCorriente cc = this.cuentaC; 
        this.numeroChequera = numChequera;
        this.cantidadCheques = "0";
        this.cheques = new HashSet();
        this.cuentaC = null;
    }

    public String getNumeroChequera() {
        return numeroChequera;
    }

    public int getCantidadCheques() {
        return cheques.size();
    }

    public HashSet getCheques() {
        return cheques;
    }
    
    public void setNumeroChequera(String numeroChequera) {
        this.numeroChequera = numeroChequera;
    }

    public void setCantidadCheques(String cantidadCheques) {
        this.cantidadCheques = cantidadCheques;
    }

    public void setCheques(HashSet cheques) {
        this.cheques = cheques;
    }

    public CuentaCorriente getCuentaC() {
        return cuentaC;
    }

    public void setCuentaC(CuentaCorriente cuentaC) {
        this.cuentaC = cuentaC;
    }
    
    public void asociarCCorriente(CuentaCorriente cc){
        cuentaC = cc;
    }
    
    public boolean agregarCheque(Cheque cheque){
        return cheques.add(cheque);
    }
    
    public String consultarCheque(){
        String salida= "Cheques: \n";
        Iterator i = cheques.iterator();
        while(i.hasNext()){
            Cheque c = (Cheque)i.next();
            if(c.getEstado() == "Disponible"){
                salida +=  "Estado: "+ c.getEstado() +
                           "\n ********************************* \n";
            }else{
                if(c.getCruzado() == false){
                    salida +=  "Estado: "+ c.getEstado() +
                                "\n" + "Valor girado: " + c.getValorGirado() +
                                "\n" + "Beneficiario del cheque: " + c.getBeneficiario() +
                                "\n" + "Fecha en que fue girado: " + c.getValorGirado() +
                                "\n" + "Banco donde fue cobrado: " + c.getSedeDeCobro() +
                                "\n" + "Cruzado: " + c.getCruzado() +
                                "\n ********************************* \n";
                }else{
                    salida +=  "Estado: "+ c.getEstado() +
                                "\n" + "Valor girado: " + c.getValorGirado() +
                                "\n" + "Beneficiario del cheque: " + c.getBeneficiario() +
                                "\n" + "Fecha en que fue girado: " + c.getValorGirado() +
                                "\n" + "Banco donde fue cobrado: " + c.getSedeDeCobro() +
                                "\n" + "Cruzado: " + c.getCruzado() +
                                "\n" + "Fecha para la que fue cruzado: " + c.getFechaDeCruce() +
                                "\n ********************************* \n";
                }
                
            }
        }
        return salida;
    }
    
}
