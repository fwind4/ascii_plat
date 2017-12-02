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
 * @author wind
 */
public class Enemy1 extends _GameObject
{
    float cc = 0.25f;
    
    public Enemy1(PApplet p, PVector pos, PImage[] img, float w, float h) {
        super(p, pos, img, w, h);
        
        this.sprite = new Enemy1Sprite(img, p, pos);
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
        this.pos.y = pos.y + 5*p.sin(cc*p.TWO_PI);
        cc += 0.01f;
    }

    @Override
    public boolean die() {
        return true;
    }
    
}
