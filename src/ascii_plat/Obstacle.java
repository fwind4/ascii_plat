/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ascii_plat;
import processing.core.*;
/**
 *
 * @author Lehel
 */
public class Obstacle extends _GameObject
{
    public Obstacle(PApplet p, PVector pos, PImage[] img, float r)
    {
        super(p, pos, img, r);
        
        this.sprite = new ObsSprite(img, p, pos);
        
        // ezekkel lehet jatszadozni hogy valtozzon a mozgas 
        this.frict = 0.05f;
        this.maxVel = 5f;
        this.force = 10f;
    }
    
    public void move()
    {
        float x  = p.random(-force,force);
        float y  = p.random(-force,force);
        this.maxVel = p.random(0,5);
        this.acc=(new PVector(x, y));
    }
}
