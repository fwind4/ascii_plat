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
    SpawnFactory sf;
    Score score;
    PlayerLife life;
    
    public void settings() 
    {
        //size(1200, 700);
        fullScreen();
    }
    
    public void setup()
    {   
        
        objs = new ArrayList<>();
        csillok = new ArrayList<>();
        for(int i=0;i<=50;i++){
            PVector pos1= new PVector(random(0,width),random(0,height));
            Csillagok cs = new Csillagok(this, pos1, 20, 2);
            cs.move();
            csillok.add(cs);
        }
        
        Explosion ex = new Explosion(this, new PVector(-150,-150), 100, 100);
        colider = new Colider(this,objs,ex);
        sf = new SpawnFactory(this, objs);
        score= new Score(this,colider);
        life = new PlayerLife(this,colider);
        objs.add(ex);
        
    }
    
    public void draw()
    {
        
        background(4, 21, 48);
        //could be intense, UTKOZES
        colider.checkHit();
        sf.spawn();
        switch(state) {
            case MAIN_MENU:
            
              
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
                life.drow();
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
            case 32:
                PVector pos = player.pos.copy();
                pos.x += 40;
                pos.y += 2;
                Projectile proj=new Projectile(this,pos,5,10);
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
        switch(key)
        {
            case 'w':
            case 'W':
            case 's':
            case 'S':
                player.stopUpDown();
                break;
            case 'a':
            case 'A':
            case 'd':
            case 'D':
                player.stopLeftRight();
                break;
            default:
                break;
        }
    }
    
    public void mousePressed()
    {
        Player player = (Player) objs.get(0);
        player.mouseFollow();
    }
    
    public void mouseReleased()
    {
        Player player = (Player) objs.get(0);
    }
}
