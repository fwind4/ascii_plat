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
    
    private PApplet p;
    private PFont font;
    private Colider c;
    public Score(PApplet p, Colider c) {
        this.p=p;
        this.c=c;
        font=p.createFont("DroidSansMono.ttf", 14);
        p.textFont(font, 14);
    }
    public void drow(){
        p.pushMatrix();
        p.fill(255,231, 255);
        p.text("score: "+c.score, p.width-100, 50);
        p.popMatrix();
    }
}
