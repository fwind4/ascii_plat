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
public abstract class _Sprite {
    
    protected PImage img;
    protected PImage[] sprites;
    protected PApplet p;
    protected PVector pos;
    
    protected int anim = 0;
    
    public _Sprite(PImage[] img, PApplet p, PVector pos)
    {
        this.p = p;
        this.pos = pos;
        this.img = img[0];
        if(img[1] != null) this.img.mask(img[1]);
        
    }
    
    abstract void render(float w, float h);
    
    public void anim(int anim)
    {
        this.anim = anim;
    }
    
}
