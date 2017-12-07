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
    
    
    public ObsSprite(PApplet p, PVector pos) 
    {
        super(p, pos);
        
        this.img = p.loadImage("moai.png");
        this.sprites = new PImage[10];
        PImage[] psprites = new PImage[5];
        PImage[] rsprites = new PImage[5];
        int x = 8,y = 0, w = 42, h = 80;
        
        for (int i=0;i<psprites.length;i++)
        {
            psprites[i] = this.img.get(x+i*w, y, w, h);
            psprites[i].resize(w*2, h*2);
        }
        for (int i=psprites.length-1;i>=0;i--)
        {
            rsprites[i] = psprites[psprites.length-1-i].copy();
            rsprites[i].resize(w*2, h*2);
            PImage rsp = rsprites[i];
            rsp.loadPixels();
            int kw = rsp.width;
            int kh = rsp.height;
            
            for(int k=0; k<kw/2; k++)
            {
                //System.out.println("kshift");
                for(int kk = 0; kk<kh; kk++)
                {
                    //System.out.println((kw-k-1+kk*kw)+"<"+(k+(kw*kk)));
                    int temp = rsp.pixels[k+(kw*kk)];
                    rsp.pixels[k+(kw*kk)] = rsp.pixels[kw-k-1+kw*kk];
                    rsp.pixels[kw-k-1+kw*kk] = temp;
                }
            }
        }
        for(int i=0;i<psprites.length;i++)
        {
            sprites[i] = psprites[i];
            sprites[psprites.length+i] = rsprites[i];
        }
    }
    
    public void render(float w, float h)
    {
        if(c == sprites.length-1) state = -1;
        else if (c == 0) state = 1;
        if(p.frameCount % 10 == 0 && state == 1)
        {
            c++;
        }
        if(p.frameCount % 10 == 0 && state == -1)
        {
            c--;
        }
        p.pushMatrix();
        p.image(sprites[c],pos.x-w-10,pos.y-h-13);
        p.popMatrix();
    }
}
