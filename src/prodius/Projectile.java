/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package prodius;

import processing.core.PApplet;
import processing.core.PVector;

/**
 *
 * @author Lehel
 */
public class Projectile extends _GameObject{

    public static int numberproj=0;
    public Projectile(PApplet p, PVector pos, float w, float h) {
        super(p, pos, w, h);
        this.sprite=new ProjSprite(p,pos);
        
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
        if(pos.x-w-100>p.width)
            this.silent_zombie=true;
    }
    
    @Override
    public void edges()
    {
        
    }

    @Override
    public boolean die() {
        numberproj-=1;
        return true;
    }
    
}
