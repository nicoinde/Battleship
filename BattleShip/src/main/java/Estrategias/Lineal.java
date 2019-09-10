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
    public int[] siguientePunto(boolean impactoAnterior) {
        int[] coord =new int[2];
        if (!init) {
            coord[0]=0;
            coord[1]=0;
            init=true;
            oponente[coord[0]][coord[1]]=1;
            return coord;
        }
        
        if(lastShootY<sizeY-1){
            lastShootY++;
        } else{
            if(lastShootX<sizeX-1){
                lastShootX++;
                lastShootY=0;
            } else{
                done=true;
            }
            
        }
        coord[0]=lastShootX;
        coord[1]=lastShootY;
        oponente[coord[0]][coord[1]]=1;
        return coord;
    }
    
    
    
    
}
