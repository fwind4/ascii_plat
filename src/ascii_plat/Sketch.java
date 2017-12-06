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
{   int state = 0; //The current state
    final int MAIN_MENU = 0;
    final int GAME = 2;
    final int PAUSE = 3;
    PFont font;
    ArrayList<_GameObject> objs;
    ArrayList<_GameObject> csillok;

    Colider colider;
    PImage[] projImg;
    PImage filter;
    Score score;
    
    public void settings() 
    {
//        size(1200, 700);
        fullScreen();
    }
    
    public void setup()
    {   
        
        
        PImage[] playerImg = new PImage[2];
        playerImg[0] = loadImage("gradius.png");
        playerImg[1] = loadImage("gradius_mask.png");
        projImg = new PImage[2];
        projImg[0] = loadImage("viper.png");
        projImg[1] = null;
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
        csillok = new ArrayList<>();
        for(int i=0;i<=50;i++){
            PVector pos1= new PVector(random(0,width),random(0,height));
            float meret = random(5,20);
            Csillagok cs = new Csillagok(this,pos1,eImg, meret,meret);
            cs.move();
            csillok.add(cs);
        }
        
        PVector pos = new PVector(50, 30);
        Player player = new Player(this,pos,playerImg,40,15);
        Explosion ex = new Explosion(this, new PVector(-150,-150), exImg, 100, 100);
        objs.add(player);
        objs.add(ex);
        PVector pos2 = new PVector(width - 100, 100);
        Enemy2 e21 = new Enemy2(this,pos2.copy(),eImg,20,20,PI/2);
        e21.move();
        objs.add(e21);
        pos2 = new PVector(width -150, 100);
        Enemy2 e22 = new Enemy2(this,pos2,eImg,20,20,0);
        e22.move();
        objs.add(e22);
        PVector pos3 = new PVector(200, 200);
        Enemy3 e3 = new Enemy3(this, pos3, eImg, 30, 30);
        e3.move();
        objs.add(e3);
        for(int i=0;i<3;++i)
        {
            PVector pos1 = new PVector(width*0.5f+i*70,height*0.5f);
            Enemy1 e1 = new Enemy1(this,pos1,eImg,25,25);
            e1.move();
            objs.add(e1);
            pos1 = new PVector(i*170, height-50);
            Obstacle obs = new Obstacle(this,pos1,obsImg,30,70);
            obs.move();
            objs.add(obs);
        }
        
        colider = new Colider(this,objs,ex);
        
        score= new Score(this,colider);
        
        
        
    }
    
    public void draw()
    {
        
        background(20);
        //could be intense, UTKOZES
        colider.checkHit();
    
        switch(state) {
            case MAIN_MENU:
              //Main Menu Stuff
                
              break;
            case GAME:
                for(_GameObject ob : csillok)
                {
                    ob.update();
                    ob.render();
                }
                for(_GameObject obj : objs)
                {
                    obj.update();
                    obj.render();
                }
               
                
                score.drow();
              //Game Stuff
              break;
            case PAUSE:
              //Pause Stuff
            break;
        }  
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
            case 'p':
            case 'P':
                PVector pos = player.pos.copy();
                pos.x += 40;
                pos.y += 2;
                Projectile proj=new Projectile(this,pos,projImg,5,10);
                objs.add(proj);
                proj.move();
                break;
            case '1':
                state=MAIN_MENU;
                break;
            case '2':
                state=GAME;
                break;
            case '3':
                state=PAUSE;
                break;
	    case '`':
		for(_GameObject obj:objs)
		{
		    if(obj.debug)
			obj.debug = false;
		    else
			obj.debug = true;
		}
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
