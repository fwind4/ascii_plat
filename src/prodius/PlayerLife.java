/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package prodius;

import processing.core.PFont;

/**
 *
 * @author Botond
 */
public class PlayerLife {
    private Sketch p;
    private Player pl;
    private PFont font;
    private Colider c;
    private boolean l =false;
    
     public PlayerLife(Sketch p, Player pl) {
        this.p=p;
        this.pl=pl;
        font=p.createFont("DroidSansMono.ttf", 14);
        p.textFont(font, 14);
    }
      public void drow(){
        p.fill(220);
        if(pl.life > 0)
        {
            
        //p.text("Life: "+pl.life, 50, 50);
          for(int i=0; i<pl.life;i++)
          {
              p.fill(255, 116, 20 );
              p.noStroke();
              p.rect(10+i*35,10,30,30);
              if(c.score % 100 == 0 && l==false && c.score!=0)
              {
                   l=true;
                  pl.life+=1;
                 
              }
              if (c.score %100 != 0)
              {
                  l=false;
              }
            
          }
       
        }
        else{
            p.state = p.GAMEOVER;
        //p.text("Game Over",50,50);
        }
        p.fill(255);
    }
    
}
