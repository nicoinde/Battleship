/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Logica;

/**
 *
 * @author Nico
 */
public class Celda {

    public enum estado {
        Nuevo,
        Agua,
        AguaForzosa,
        Barco,
        Tocado,
        Hundido,
    }
    
    private estado actual= estado.Nuevo;
    private boolean chosen;

    public Celda() {
        actual=estado.Agua;
        chosen=false;
    }
    public Celda(estado est) {
        actual=est; 
        chosen=false;
    }

    public boolean isChosen() {
        return chosen;
    }

    public void reset() {
        chosen = false;
        actual=actual.Nuevo;
    }

    public estado getActual() {
        return actual;
    }

    public void setActual(estado actual) {
        this.actual = actual;
    }
    
    public void setForzosa(){
        actual=estado.AguaForzosa;
    }
    
    public void setNuevo(){
        actual=estado.Nuevo;
    }
    
    public void setAgua(){
        actual=estado.Agua;
    }
    
    public void setHundido(){
        actual=estado.Hundido;
    }
    
    public void setTocado(){
        actual=estado.Tocado;
    }
    
    public void setBarco(){
        actual=estado.Barco;
    }
    
    
    
    
}
