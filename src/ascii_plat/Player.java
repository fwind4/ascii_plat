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
    public boolean hasDied = false;
    public boolean blink = false;
    
    private Colider c;
    
    public Player(PApplet p, PVector pos, float w, float h) {
        super(p, pos, w, h);
        
        life=3;
        if(c.score>5)
            life+=1;
        this.sprite = new PlayerSprite(p, pos);
        
        // ezekkel lehet jatszadozni hogy valtozzon a mozgas 
        this.frict = 0.1f;
        this.maxVel = 10f;
        this.force = 0.5f;
    }
    
    public void moveLeft()
    {
        this.acc.x = -force;
        this.sprite.anim(-2);
    }
    
    public void moveRight()
    {
        this.acc.x = force;
        this.sprite.anim(2);
    }
    
    public void moveUp()
    {
        this.acc.y = -force;
        this.sprite.anim(-1);
    }
    
    public void moveDown()
    {
        this.acc.y = force;
        this.sprite.anim(1);
    }
    
    void stopLeftRight() 
    {
        this.acc.x = 0;
        this.sprite.anim(0);
    }

    void stopUpDown()
    {
        this.acc.y = 0;
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

    @Override
    public void oscilate() {
        if(p.frameCount % 120 == 0 && hasDied)
        {
            this.pos.x = 50;
            this.pos.y = p.height*0.5f;
            hide = false;
            hasDied = false;
            blink = true;
            ((PlayerSprite)sprite).blink = 10;
        }
        else if(p.frameCount % 180 == 0 && blink)
        {
            blink = false;
            hittable = true;
            ((PlayerSprite)sprite).blink = 1;
        }
    }
    
    @Override
    public boolean die() {
        this.pos.y = -1000;
        zombie = false;
        hittable = false;
        hasDied = true;
        return false;
    }
    
    @Override
    public void edges()
    {
        if (pos.y > p.height - h)
	    pos.y = p.height - h;
	else if (pos.y < h)
	    pos.y = h;
        else if(pos.x > p.width-w)
            pos.x = p.width-w;
        else if(pos.x < w)
            pos.x = w;
    }
   

}
