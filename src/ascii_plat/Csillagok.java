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
 * @author Botond
 */
public class Csillagok extends _GameObject{

    public Csillagok(PApplet p, PVector pos, float w, float h) {
        super(p, pos, w, h);
        this.sprite = new CsillagSprite(p,pos);
        
        this.frict = 0f;
        this.maxVel = 3f;
        this.force = 0.1f;
    }
    
    public void move()
    {
        this.acc.x=-force;
        this.maxVel=p.random(1,20);
        
    }

    @Override
    public void oscilate() {
        
        this.w = p.map((float)Math.pow(Math.E,-vel.x), 1, 4.94165184E8f, 2, 100);
    }

    @Override
    public boolean die() {
        return true;
    }
    
    public void edges()
    {
	if (pos.x < -w)
        {
            pos.x = p.width + w;
            pos.y = p.random(0, p.height);
            this.acc.x=-force;
            acc = acc.mult(10);
            maxVel = p.random(1,20);
        }
    }
    
}
