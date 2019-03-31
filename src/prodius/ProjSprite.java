/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package prodius;

import processing.core.PApplet;
import processing.core.PImage;
import processing.core.PVector;

/**
 *
 * @author Lehel
 */
public class ProjSprite extends _Sprite{
    
    private int state = 1;

    public ProjSprite(PApplet p, PVector pos) {
        super(p, pos);
        
        this.img = p.loadImage("viper.png");
        this.sprites = new PImage[8];
        int x = 8,y = 70, w = 5, h = 10;
        
        for (int i=0;i<sprites.length;i++)
        {
            this.sprites[i] = this.img.get(x+i*w, y, w, h);
            this.sprites[i].resize(w*2, h*2);
        }
    }

    @Override
    void render(float w, float h) {
        if(c == 0) state = 1;
        else if(c == sprites.length-1) state = -1;
        if(p.frameCount % 10 == 0 && state == 1)
        {
            c++;
        }
        else if(p.frameCount % 10 == 0 && state == -1)
        {
            c--;
        }
        p.image(sprites[c],pos.x-w,pos.y-h);
    }
    
}
