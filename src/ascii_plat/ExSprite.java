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
class ExSprite extends _Sprite {
    
    private Explosion ex;

    public ExSprite(PApplet p, PVector pos, Explosion ex) {
        super(p,pos);
        
        this.img = p.loadImage("explosion.png");
        this.ex = ex;
        this.sprites = new PImage[15];
        int x = 0,y = 0, w = 960/5, h = 576/3;
        
        for (int i=0;i<5;i++)
        {
            for (int j=0;j<3;j++)
            {
                this.sprites[i+5*j] = this.img.get(x+i*w, y+j*h, w, h);
                //this.sprites[i+5*j].resize(w*2, h*2);
            }
        }
    }

    @Override
    void render(float w, float h) {
            
        if(p.frameCount % 5 == 0 && c < sprites.length-1)
        {
            c++;
        }
        p.image(sprites[c],pos.x-w,pos.y-h);
        
    }
    
}
