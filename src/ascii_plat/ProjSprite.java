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
 * @author Lehel
 */
public class ProjSprite extends _Sprite{

    public ProjSprite(PImage[] img, PApplet p, PVector pos) {
        super(img, p, pos);
        
    }

    @Override
    void render(float w, float h) {
        p.ellipse(pos.x-w,pos.y-h,w,h);
    }
    
}
