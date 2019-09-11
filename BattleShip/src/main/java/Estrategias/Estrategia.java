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
    int sizeX,sizeY;
    int[][] oponente;
    boolean lastShootHit, init,done=false;;
    int lastShootX=0,lastShootY=0;
    public Estrategia(){
        lastShootHit=false;
        init=false;
        sizeX=100;
        sizeY=100;
        
        oponente=new int[sizeX][sizeY];

        for (int i = 0; i < 100; i++) {
            for (int j = 0; j < 100; j++) {
                oponente[i][j]=0;

            }
        }
        
    }
    public Estrategia(int x, int y){
        lastShootHit=false;
        init=false;
        oponente=new int[x][y];
        for (int i = 0; i < x; i++) {
            for (int j = 0; j < y; j++) {
                oponente[i][j]=0;
            }
        }
        
    }
    
    public abstract int[] siguientePunto(boolean impactoAnterior);
   
    
    public boolean isDone(){
        return done;
    }
    
    public void done(){
        done=true;
    }
    
    
}
