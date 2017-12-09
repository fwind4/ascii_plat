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
public class Score {
    
    private Sketch p;
    private Colider c;
    public Score(Sketch p, Colider c) {
        this.p=p;
        this.c=c;
    }
    public void drow(){
        p.fill(252, 158, 27);
        if(c.score > 0)
        {
        p.textFont(p.font, 18);
        p.text("Score: "+c.score, p.width*0.5f, 50);
        }
        p.fill(255);
    }
}
