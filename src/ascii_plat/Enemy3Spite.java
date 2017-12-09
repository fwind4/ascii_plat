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
public class Enemy3Spite extends _Sprite{

    public Enemy3Spite(PApplet p, PVector pos) {
        super(p, pos);
        
        this.img = p.loadImage("enemy.png");
        this.sprites = new PImage[1];
        int x = 25,y = 550, w =110 , h = 70;
        
        
            this.sprites[0] = this.img.get(x, y, w, h);
            this.sprites[0].resize(w*2, h*2);
    }

    @Override
    void render(float w, float h) {
        p.image(sprites[0],pos.x-w,pos.y-h);
    }
    
}
