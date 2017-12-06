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
 * @author Botond
 */
public class CsillagSprite extends _Sprite
{

    public CsillagSprite(PImage[] img, PApplet p, PVector pos) {
        super(img, p, pos);
    }

    @Override
    void render(float w, float h) {
        p.pushMatrix();
        p.ellipse(pos.x-w,pos.y-h,w,h);
        p.popMatrix();
    }
    
}
