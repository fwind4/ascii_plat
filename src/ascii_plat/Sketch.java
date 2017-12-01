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
    Player player;
    ArrayList<Enemy1> e1s;
    ArrayList<Obstacle> obstacles;
    
    PImage[] playerImg;
    PImage[] obsImg;
    PImage[] eImg;

    PImage filter;
    
    public void settings() 
    {
        size(800, 600);
    }
    
    public void setup()
    {
        playerImg = new PImage[2];
        playerImg[0] = loadImage("gradius.png");
        playerImg[1] = loadImage("gradius_mask.png");
        obsImg = new PImage[2];
        obsImg[0] = loadImage("moai.png");
        obsImg[1] = null;
        eImg = new PImage[2];
        eImg[0] = loadImage("enemy.png");
        eImg[1] = null;
        filter = loadImage("3px.png");
        
        font = createFont("DroidSansMono.ttf", 14);
        textFont(font, 14);
        PVector pos = new PVector(width*0.5f, height*0.5f);
        player = new Player(this,pos,playerImg,40,15);
        obstacles = new ArrayList<>();
        e1s = new ArrayList<>();
        for(int i=0;i<5;++i)
        {
            PVector pos1 = new PVector(width*0.5f+i*50,height*0.5f);
            Enemy1 e1 = new Enemy1(this,pos1.copy(),eImg,25,25);
            e1.move();
            e1s.add(e1);
            pos1 = new PVector(random(0,width), random(0,height));
            Obstacle obs = new Obstacle(this,pos1,obsImg,30,70);
            obs.move();
            obstacles.add(obs);
        }
        
    }
    
    public void draw()
    {
        background(20);
        player.update();
        player.render();
        for(Enemy1 e1 : e1s)
        {
            e1.update();
            e1.render();
            e1.oscilate();
        }
        for(Obstacle obs : obstacles)
        {
            obs.update();
            obs.render();
        }
        
        image(filter,0,0);
    }

    @Override
    public void keyPressed() {
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
        player.stop();
    }
    
    public void mousePressed()
    {
        player.mouseFollow();
    }
    
    public void mouseReleased()
    {
        player.stop();
    }
}
