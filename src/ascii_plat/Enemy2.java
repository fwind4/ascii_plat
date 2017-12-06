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
public class Enemy2 extends _GameObject
{
    float cc = 0.25f;
    float fi = 0;
    
    public Enemy2(PApplet p, PVector pos, float w, float h, float fi) {
        super(p, pos, w, h);
        
        this.fi = fi;
        
        this.sprite = new Enemy2Sprite(p, pos);
        cc = p.map(pos.x, 0, p.width, 0, 0.5f);
        
        // ezekkel lehet jatszadozni hogy valtozzon a mozgas 
        this.frict = 0.1f;
        this.maxVel = 5f;
        this.force = 0.5f;
    }
    
    public void move()
    {
        float x  = -force;
        float y  = 0;
        this.acc=(new PVector(x, y));
    }
    
    public void oscilate()
    {
        this.pos.y = pos.y + 5*p.sin(cc*p.TWO_PI+fi);
        cc += 0.01f;
    }

    @Override
    public boolean die() {
        return true;
    }
    
}      
    


