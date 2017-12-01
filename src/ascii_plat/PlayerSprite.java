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
public class PlayerSprite extends _Sprite {
    
    private int fc = 0;
    private int counter = 3;
    private PImage[] flames;
    
    public PlayerSprite(PImage[] img, PApplet p, PVector pos) {
        super(img, p, pos);
        
        this.sprites = new PImage[9];
        this.flames = new PImage[4];
        int x = 46,y = 18, w = 23, h = 16, fw = 8;
        for (int i=0;i<flames.length;i++)
        {
            this.flames[i] = this.img.get(x-10-i*10, 4*y+2, fw, h);
            this.flames[i].resize(fw*4, h*4);
        }
        
        for (int i=0;i<sprites.length;i++)
        {
            this.sprites[i] = this.img.get(x, i*y+2, w, h);
            this.sprites[i].resize(w*4, h*4);
        }
    }
    
    public void render(float w, float h)
    {
        if(anim == -1 && counter != 0 && p.frameCount % 10 == 0)
        {
            counter--;
        }
        else if(anim == 1 && counter != sprites.length-1 && p.frameCount % 10 == 0)
        {
            counter++;
        }
        else if(anim == 0 && counter < p.floor((sprites.length-1)/2) && p.frameCount % 10 == 0)
        {
            counter++;
        }
        else if(anim == 0 && counter > p.floor((sprites.length-1)/2) && p.frameCount % 10 == 0)
        {
            counter--;
        }
        
        if(p.frameCount % 5 == 0)
        {
            fc++;
        }
        else if(fc == flames.length-1)
        {
            fc = 0;
        }
            
        p.image(sprites[counter],pos.x-23*2,pos.y-16*2);        
        p.image(flames[fc],pos.x-79,pos.y-16*2);

    }
    
}
