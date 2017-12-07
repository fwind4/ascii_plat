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
 * @author Botond
 */
public class CsillagSprite extends _Sprite
{
    
    public CsillagSprite(PApplet p, PVector pos) {
        super(p, pos);
    }

    @Override
    void render(float w, float h) {

        p.stroke(255, 255, 255, 50);
        p.fill(252, 239, 209, 100);
        p.ellipse(pos.x-w,pos.y-h,w,h);
        p.fill(255);
    }
    
}
