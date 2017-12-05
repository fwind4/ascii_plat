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
 * @author Lehel
 */
public class Projectile extends _GameObject{

    public Projectile(PApplet p, PVector pos, PImage[] img, float w, float h) {
        super(p, pos, img, w, h);
        this.sprite=new ProjSprite(img,p,pos);
        
        this.frict = 0.05f;
        this.maxVel = 10f;
        this.force = 10f;
    }
    
    public void move()
    {
        this.acc.x=+force;
        
    }
    
    @Override
    public void oscilate() {
        if(pos.x-w-50>p.width)
            this.zombie=true;
    }
    
    @Override
    public void edges()
    {
        
    }

    @Override
    public boolean die() {
        return true;
    }
    
}
