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
public abstract class Estrategia {
    
    //modo de busqueda 0->Seek; 1->Destroy
    int modo;
    int[][] oponente;
    int[][] miTablero;
    boolean lastShootHit, init;
    int lastShootX=0,lastShootY=0;
    public Estrategia(){
        lastShootHit=false;
        init=false;
        modo=0;
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                oponente[i][j]=0;
                miTablero[i][j]=0;
            }
        }
        
    }
    
    public abstract int[] siguiente();
    
    private void toSeek(){
        modo=0;
    }
    private void toDestroy(){
        modo=1;
    }
    
    
    
}
