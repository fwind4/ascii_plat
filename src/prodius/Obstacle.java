/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package prodius;
import processing.core.*;
/**
 *
 * @author Lehel
 */
public class Obstacle extends _GameObject
{
    public Obstacle(PApplet p, PVector pos, float w, float h)
    {
        super(p, pos, w, h);
        
        this.sprite = new ObsSprite(p, pos);
        life=2;
        // ezekkel lehet jatszadozni hogy valtozzon a mozgas 
        this.frict = 0.05f;
        this.maxVel = 5f;
        this.force = 10f;
    }
    
    public void move()
    {
        float x  = -force;
        float y  = 0;
        this.acc=(new PVector(x, y));
    }

    @Override
    public void oscilate() {
        
    }
    
    @Override
    public boolean die() {
        if(life == 0)
        {
            life=2;
        return true;
        }
        else{
            zombie=false;
          silent_zombie=false;
          hide= false;
            life-=1;
            return false;
        }
        
    }
}
