package ascii_plat;

import processing.core.PApplet;
import processing.core.PImage;
import processing.core.PVector;

/**
 *
 * @author Wind
 */
public abstract class _GameObject
{
    protected PApplet p;
    protected PVector pos;
    protected PVector vel = new PVector(0,0);
    protected PVector acc = new PVector(0,0);
    protected float r;
    protected _Sprite sprite;
    protected int spriteCounter = 0;
    
    protected float frict;
    protected float maxVel;
    protected float force;

    public _GameObject( PApplet p, PVector pos, PImage[] img, float r)
    {
	this.pos = pos;
	this.p = p;
	this.r = r;
        
    }

    public void update()
    {
        this.vel.add(this.acc);
        this.vel.limit(maxVel);
	this.pos.add(this.vel);
	edges();
        
        if(this.vel.x != 0)
        {
            this.vel.x = this.vel.x > 0 ? this.vel.x - frict : this.vel.x + frict;
        }
        if(this.vel.y != 0)
        {
            this.vel.y = this.vel.y > 0 ? this.vel.y - frict : this.vel.y + frict;
        }
        
    }
    
    public void edges()
    {
	if (pos.x > p.width + r)
	    pos.x = -r;
	else if (pos.x < -r)
	    pos.x = p.width + r;
	else if (pos.y > p.height + r)
	    pos.y = -r;
	else if (pos.y < -r)
	    pos.y = p.height + r;
    }
    
    public void render()
    {
	sprite.render();
    }
 
}
