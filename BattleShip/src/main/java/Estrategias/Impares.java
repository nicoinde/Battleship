/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Estrategias;

import java.util.ArrayList;

/**
 *
 * @author Nico
 */
public class Impares extends Estrategia{

    private ArrayList<int[]> puntosDeInteres=new ArrayList();

    public Impares() {
        super();
    }

    public Impares(int x, int y) {
        super(x, y);
    }
    
    
    @Override
    public int[] siguientePunto(boolean impactoAnterior) {
        int[] coord= new int [2];
        if(impactoAnterior){
            if(oponente[lastShootX-1][lastShootY]==0){
                coord[0]=lastShootX-1;
                coord[1]=lastShootY;
                puntosDeInteres.add(coord);
            }
            if(oponente[lastShootX+1][lastShootY]==0){
                coord[0]=lastShootX+1;
                coord[1]=lastShootY;
                puntosDeInteres.add(coord);
            }
            if(oponente[lastShootX][lastShootY-1]==0){
                coord[0]=lastShootX;
                coord[1]=lastShootY-1;
                puntosDeInteres.add(coord);
            }
            if(oponente[lastShootX][lastShootY+1]==0){
                coord[0]=lastShootX;
                coord[1]=lastShootY+1;
                puntosDeInteres.add(coord);
            }
        }
        
        if(puntosDeInteres.isEmpty()){
            int auxX = 0, auxY = 0;
        do {
            auxX = (int) (Math.random() * sizeX);
            auxY = (int) (Math.random() * sizeY);
        } while ((auxX+auxY)%2==0 && oponente[auxX][auxY] == 1);
        
        lastShootX=auxY;
        lastShootY=auxY;
        coord[0] = auxX;
        coord[1] = auxY;
        oponente[coord[0]][coord[1]] = 1;
        } else{
            coord=puntosDeInteres.remove(0);
            lastShootX=coord[0];
            lastShootY=coord[1];
            oponente[coord[0]][coord[1]] = 1;
        }
        
        return coord;
    }

}
