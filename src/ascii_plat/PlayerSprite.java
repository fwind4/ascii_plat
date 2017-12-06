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
    private PImage[] rflames;
    private PImage[] hflames;
    private PImage[] dflames;
    private final int regw;
    private final int regh;
    private final int dw;
    private final int dh;
    private final int hw;
    private final int hh;
    private int cw;
    private int ch;
    
    public PlayerSprite(PApplet p, PVector pos) {
        super(p, pos);
        
        this.img = p.loadImage("gradius.png");
        this.img.mask(p.loadImage("gradius_mask.png"));
        this.sprites = new PImage[9];
        this.flames = new PImage[4];
        this.rflames = new PImage[4];
        this.hflames = new PImage[4];
        this.dflames = new PImage[4];
        int x = 46,y = 18, w = 23, h = 16, fw = 8;
        for (int i=0;i<flames.length;i++)
        {
            this.flames[i] = this.img.get(x-10-i*10, 4*y+2, fw, h);
            this.flames[i].resize(fw*4, h*4);
            this.rflames[i] = this.flames[i].copy();
            this.hflames[i] = this.flames[i].copy();
            this.hflames[i].resize(flames[i].width/2, flames[i].height/2);
            this.dflames[i] = this.flames[i].copy();
            this.dflames[i].resize(flames[i].width*2, flames[i].height*2);
        }
        
        for (int i=0;i<sprites.length;i++)
        {
            this.sprites[i] = this.img.get(x, i*y+2, w, h);
            this.sprites[i].resize(w*4, h*4);
        }
        
        regw = flames[0].width;
        regh = flames[0].height;
        dw = regw*2;
        dh = regh*2;
        hw = regw/2;
        hh = regh/2;
        
        ch = regh;
        cw = regw;
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
        else if(anim == 0 && p.frameCount % 15 == 0)
        {
            for (int i=0;i<flames.length;i++)
            {
                this.flames[i] = this.rflames[i];
            }
            ch = regh;
            cw = regw;
        }
        else if(anim == 2 && p.frameCount % 20 == 0)
        {
            for (int i=0;i<flames.length;i++)
            {
                this.flames[i] = this.dflames[i];
            }
            ch = dh-25;
            cw = dw;
        }
        else if(anim == -2 && p.frameCount % 20 == 0)
        {
            for (int i=0;i<flames.length;i++)
            {
                this.flames[i] = this.hflames[i];
            }
            ch = hh+15;
            cw = hw;
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
        p.image(flames[fc],pos.x-cw-50,pos.y-ch+30);

    }
    
}
