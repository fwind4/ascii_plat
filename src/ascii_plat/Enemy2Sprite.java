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
public class Enemy2Sprite extends _Sprite
{

    private int c = 0;
    private int state = 1;
    
    public Enemy2Sprite(PImage[] img, PApplet p, PVector pos) 
    {
        super(img, p, pos);
        
        this.sprites = new PImage[8];
        int x = 8,y = 50, w = 35, h = 55;
        
        for (int i=0;i<sprites.length;i++)
        {
            this.sprites[i] = this.img.get(x+i*w, y, w, h);
            this.sprites[i].resize(w*2, h*2);
        }
    }
    
    public void render(float w, float h)
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
        p.image(sprites[c],pos.x-w-5,pos.y-h-35);
        p.popMatrix();
    }
    
}

