/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ascii_plat;

import processing.core.PApplet;
import processing.core.PFont;

/**
 *
 * @author Botond
 */
public class PlayerLife {
    private PApplet p;
    private Colider c;
    private PFont font;
    
     public PlayerLife(PApplet p, Colider c) {
        this.p=p;
        this.c=c;
        font=p.createFont("DroidSansMono.ttf", 14);
        p.textFont(font, 14);
    }
      public void drow(){
        p.fill(220);
        if(c.life > 0)
        {
        p.text("Life: "+c.life, 50, 50);
        }
        else{
        p.text("Game Over",50,50);
        }
        p.fill(255);
    }
    
}
