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
    public PVector pos;
    protected PVector vel = new PVector(0,0);
    protected PVector acc = new PVector(0,0);
    public float w;
    public float h;
    public boolean hide = false;
    public boolean zombie = false;
    public boolean debug = false;
    protected _Sprite sprite;
    protected int spriteCounter = 0;
    
    protected float frict;
    protected float maxVel;
    protected float force;

    public _GameObject( PApplet p, PVector pos, PImage[] img, float w, float h)
    {
	this.pos = pos;
	this.p = p;
	this.w = w;
        this.h = h;
        
    }

    public void update()
    {
        this.vel.add(this.acc);
        this.vel.limit(maxVel);
	this.pos.add(this.vel);
	edges();
        
        float x = 0, y = 0;
        if(this.vel.x > frict || this.vel.x < -frict)
        {
            x = this.vel.x > 0 ? frict : -frict;
        }
        if(this.vel.y > frict || this.vel.y < -frict)
        {
            y = this.vel.y > 0 ? frict : -frict;
        }
        PVector fv = new PVector(x,y);
        this.vel.sub(fv);
        
        this.oscilate();
    }
    
    public abstract void oscilate();
    public abstract boolean die();
    
    public void edges()
    {
	if (pos.x > p.width + w)
	    pos.x = -w;
	else if (pos.x < -w)
	    pos.x = p.width + w;
	else if (pos.y > p.height + h)
	    pos.y = -h;
	else if (pos.y < -h)
	    pos.y = p.height + h;
    }
    
    public void render()
    {
        if(hide)
            return;
        
	sprite.render(w,h);
        //debug
	if(debug)
	{
	    p.pushMatrix();
	    p.noFill();
	    p.stroke(255);
	    p.rect(pos.x-w,pos.y-h,2*w,2*h);
	    p.popMatrix();
	}
    }
    
    public boolean checkColide(_GameObject that)
    {
        if(this.pos.x+this.w > that.pos.x-that.w &&
                this.pos.x-this.w < that.pos.x+that.w &&
                this.pos.y+this.h > that.pos.y-that.h &&
                this.pos.y-this.h < that.pos.y+that.h)
            return true;
        return false;
    }
    
 
}
