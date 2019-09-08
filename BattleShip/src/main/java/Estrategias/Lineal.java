/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Estrategias;

/**
 *
 * @author Nico
 */
public class Lineal extends Estrategia{

    public Lineal() {
        super();
    }

    
    
    @Override
    public int[] siguiente() {
        int[] coord =new int[2];
        if (!init) {
            coord[0]=0;
            coord[1]=0;
        } else {
            
        }
        
        
        return coord;
    }
    
    
}
