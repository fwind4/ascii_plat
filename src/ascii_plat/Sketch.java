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
{   public int state = 2; //The current state
    public final int MAIN_MENU = 0;
    public final int GAME = 2;
    public final int PAUSE = 3;
    public final int GAMEOVER = 4;
    int c = 20;
    boolean st = false;
    PFont font;
    ArrayList<_GameObject> objs;
    ArrayList<_GameObject> csillok;
    
    Player player;
    Colider colider;
    SpawnFactory sf;
    Explosion ex;
    Score score;
    PlayerLife life;
    
    public void settings() 
    {
        //size(1200, 700);
        fullScreen();
    }
    
    public void setup()
    {   
        font=createFont("prstartk.ttf", 18);
        
        objs = new ArrayList<>();
        csillok = new ArrayList<>();
        for(int i=0;i<=50;i++){
            PVector pos1= new PVector(random(0,width),random(0,height));
            Csillagok cs = new Csillagok(this, pos1, 20, 2);
            cs.move();
            csillok.add(cs);
        }
        
        ex = new Explosion(this, new PVector(-150,-150), 100, 100);
        colider = new Colider(this,objs,ex);
        sf = new SpawnFactory(this, objs);
        score= new Score(this,colider);
        life = new PlayerLife(this,(Player)objs.get(0));
        player = (Player) objs.get(0);
        //objs.add(ex);
        
    }
    
    public void draw()
    {
        
        background(13, 21, 33);
        
        //could be intense, UTKOZES
        colider.checkHit();
        sf.spawn();
    
        switch(state) {
            case MAIN_MENU:
              //Main Menu Stuff
                
              break;
            case GAMEOVER:
                if(c == 50)
                    st = true;
                else if (c == 20)
                    st = false;
                if(st && frameCount % 3 == 0)
                    c--;
                else if(!st && frameCount % 3 == 0)
                    c++;
                fill(252, 158, 27);
                textFont(font,c);
                text(     "     Game Over\n"
                        + "Press 'R' to retry.",
                        width*0.5f-150-c*5,height*0.5f+30);
                fill(255);
                player.hide = true;
                objs.remove(player);
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
                ex.render();
                ex.update();
                
                score.drow();
                life.drow();
                //Game Stuff
                break;
            case PAUSE:
              //Pause Stuff
                break;
            default:
                break;
                
        }  
    }

    @Override
    public void keyPressed() {
        
        if(key == CODED)
        {
            switch(keyCode)
            {
                case UP:
                    player.moveUp();
                    break;
                case DOWN:
                    player.moveDown();
                    break;
                case LEFT:
                    player.moveLeft();
                    break;
                case RIGHT:
                    player.moveRight();
                    break;
                default:
                    break;
            }
        }
        else
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
                if(Projectile.numberproj < 3)
                {
                    PVector pos = player.pos.copy();
                    pos.x += 40;
                    pos.y += 2;
                    Projectile proj=new Projectile(this,pos,5,10);
                    objs.add(proj);
                    proj.move();
                    Projectile.numberproj+=1;
                }
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
            case 'r':
                player.life = 3;
                player.hide = false;
                player.pos.y = height*0.5f;
                player.pos.x = 70;
                objs.add(0, player);
                c = 20;
                state = 2;
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
        if(key == CODED)
        {
            switch(keyCode)
            {
                case UP:
                case DOWN:
                    player.stopUpDown();
                    break;
                case LEFT:
                case RIGHT:
                    player.stopLeftRight();
                    break;
                default:
                    break;
            }
        }
        else
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
    
//    public void mousePressed()
//    {
//        Player player = (Player) objs.get(0);
//        player.mouseFollow();
//    }
//    
//    public void mouseReleased()
//    {
//        Player player = (Player) objs.get(0);
//    }
}
