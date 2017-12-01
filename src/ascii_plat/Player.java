/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ascii_plat;

import processing.core.*;

/**
 *
 * @author wind
 */
public class Player extends _GameObject
{
    
    public Player(PApplet p, PVector pos, PImage[] img, float w, float h) {
        super(p, pos, img, w, h);
        
        this.sprite = new PlayerSprite(img, p, pos);
        
        // ezekkel lehet jatszadozni hogy valtozzon a mozgas 
        this.frict = 0.1f;
        this.maxVel = 10f;
        this.force = 0.5f;
    }
    
    public void moveLeft()
    {
        this.acc.add(new PVector(-force,0));
    }
    
    public void moveRight()
    {
        this.acc.add(new PVector(force,0));
    }
    
    public void moveUp()
    {
        this.acc.add(new PVector(0,-force));
        this.sprite.anim(-1);
    }
    
    public void moveDown()
    {
        this.acc.add(new PVector(0,force));
        this.sprite.anim(1);
    }
    
    public void stop()
    {
        this.acc=(new PVector(0,0));
        this.sprite.anim(0);
    }
    
    public void mouseFollow()
    {
        PVector mpos = new PVector(p.mouseX, p.mouseY);
        PVector npos = new PVector();
        npos.x = mpos.x - pos.x;
        npos.y = mpos.y - pos.y;
        npos.normalize();
        npos.mult(force);
        this.acc = npos;
    }
}
