/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ascii_plat;
import java.util.ArrayList;
import processing.core.*;

/**
 *
 * @author wind
 */
public class Sketch extends PApplet
{
    PFont font;
    ArrayList<_GameObject> objs;
    Colider colider;
    
    PImage filter;
    
    public void settings() 
    {
        size(800, 600);
    }
    
    public void setup()
    {
        PImage[] playerImg = new PImage[2];
        playerImg[0] = loadImage("gradius.png");
        playerImg[1] = loadImage("gradius_mask.png");
        PImage[] obsImg = new PImage[2];
        obsImg[0] = loadImage("moai.png");
        obsImg[1] = null;
        PImage[] eImg = new PImage[2];
        eImg[0] = loadImage("enemy.png");
        eImg[1] = null;
        PImage[] exImg = new PImage[2];
        exImg[0] = loadImage("explosion.png");
        exImg[1] = null;
        filter = loadImage("3px.png");
        
        font = createFont("DroidSansMono.ttf", 14);
        textFont(font, 14);
        
        objs = new ArrayList<>();
        PVector pos = new PVector(50, 30);
        Player player = new Player(this,pos,playerImg,40,15);
        Explosion ex = new Explosion(this, new PVector(-150,-150), exImg, 960f/5f, 576f/3f);
        objs.add(player);
        objs.add(ex);
        for(int i=0;i<3;++i)
        {
            PVector pos1 = new PVector(width*0.5f+i*50,height*0.5f);
            Enemy1 e1 = new Enemy1(this,pos1.copy(),eImg,25,25);
            e1.move();
            objs.add(e1);
            pos1 = new PVector(random(0,width), height-70);
            Obstacle obs = new Obstacle(this,pos1,obsImg,30,70);
            obs.move();
            objs.add(obs);
        }
        
        colider = new Colider(this,objs,ex);
        
    }
    
    public void draw()
    {
        background(20);
        for(_GameObject obj : objs)
        {
            obj.update();
            obj.render();
        }
        
        image(filter,0,0);
        
        //could be intense
        colider.checkHit();
    }

    @Override
    public void keyPressed() {
        
        Player player = (Player) objs.get(0);
        switch (key) {
            case 'w':
            case 'W':
                player.moveUp();
                break;
            case 's':
            case 'S':
                player.moveDown();
                break;
            case 'a':
            case 'A':
                player.moveLeft();
                break;
            case 'd':
            case 'D':
                player.moveRight();
                break;
            default:
                break;
        }
    }
    
    public void keyReleased()
    {
        Player player = (Player) objs.get(0);
        player.stop();
    }
    
    public void mousePressed()
    {
        Player player = (Player) objs.get(0);
        player.mouseFollow();
    }
    
    public void mouseReleased()
    {
        Player player = (Player) objs.get(0);
        player.stop();
    }
}
