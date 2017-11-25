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

    private int c = 0;
    private int state = 1;
    
    public ObsSprite(PImage[] img, PApplet p, PVector pos) 
    {
        super(img, p, pos);
        
        this.sprites = new PImage[5];
        int x = 8,y = 0, w = 42, h = 80;
        
        for (int i=0;i<sprites.length;i++)
        {
            this.sprites[i] = this.img.get(x+i*w, y, w, h);
            this.sprites[i].resize(w*2, h*2);
        }
    }
    
    public void render()
    {
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
        p.pushMatrix();
        //p.scale(state, 1);
        p.image(sprites[c],pos.x-23*2,pos.y-16*2);
        p.popMatrix();
    }
}
