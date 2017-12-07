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
 * @author wind
 */
class Explosion extends _GameObject{

    public Explosion(PApplet p, PVector pos, float w, float h) {
        super(p, pos, w, h);
        this.sprite = new ExSprite(p, pos, this);
        
        // ezekkel lehet jatszadozni hogy valtozzon a mozgas 
        this.frict = 0.1f;
        this.maxVel = 5f;
        this.force = 0.5f;
    }

    @Override
    public void oscilate() {
        
    }

    @Override
    public boolean die() {
        return true;
    }
    
    public void setC(int c)
    {
        sprite.c = c;
    }
    
    @Override
    public boolean checkColide(_GameObject obj)
    {
        return false;
    }
    
}
