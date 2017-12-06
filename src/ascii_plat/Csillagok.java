/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ascii_plat;

import processing.core.PApplet;
import processing.core.PImage;
import processing.core.PVector;

/**
 *
 * @author Botond
 */
public class Csillagok extends _GameObject{

    public Csillagok(PApplet p, PVector pos, PImage[] img, float w, float h) {
        super(p, pos, img, w, h);
        this.sprite = new CsillagSprite(img ,p,pos);
        
        this.frict = 0.1f;
        this.maxVel = 3f;
        this.force = 0.5f;
    }
    
    public void move()
    {
        this.acc.x=-force;
        this.maxVel=p.random(1,10);
        
    }

    @Override
    public void oscilate() {
        
    }

    @Override
    public boolean die() {
        return true;
    }
    
}
