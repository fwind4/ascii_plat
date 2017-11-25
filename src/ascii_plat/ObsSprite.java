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
public class ObsSprite extends _Sprite{

    private String spstr; // ideglenes
    
    public ObsSprite(PImage[] img, PApplet p, PVector pos) 
    {
        super(img, p, pos);
    }
    
    public void render()
    {
        p.pushMatrix();
        p.fill(196, 79, 33);
	spstr =     "                         \n"+
                    "           *            \n"+
                    "         *****           \n"+
                    "        *******            \n"+
                    "         *****               \n"+
                    "           *            \n";
                
        p.text(spstr,pos.x,pos.y);
        //p.ellipse(pos.x,pos.y,r,r);
        p.popMatrix();
    }
}
