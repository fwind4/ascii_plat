/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ascii_plat;

import processing.core.PApplet;
import processing.core.PVector;

/**
 *
 * @author Lehel
 */
public class Enemy3 extends _GameObject{

    float c = 0;
    float cc = 1;
    int state = 1;
    
    public Enemy3(PApplet p, PVector pos, float w, float h) {
        super(p, pos, w, h);
        
        this.sprite = new Enemy3Spite(p, pos);
        
        this.frict = 0.1f;
        this.maxVel = 3f;
        this.force = 0.5f;
    }
    
    public void move()
    {
        this.acc.x =-force;
        
    }

    @Override
    public void oscilate() {
        this.pos.y += cc*p.cos(c);
        this.pos.x += cc*p.sin(c);
        c += 0.05;
        cc = state == 1 ? cc+0.01f : cc-0.01f;
        if (cc == 3)
            state = -1;
        else if (cc == 1)
            state = 1;
    }

    @Override
    public boolean die() {
        return true;
    }
    
    
}
