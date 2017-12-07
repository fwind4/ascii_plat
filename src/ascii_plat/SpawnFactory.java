/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ascii_plat;

import java.util.ArrayList;
import java.util.HashMap;
import processing.core.PApplet;
import static processing.core.PConstants.PI;
import processing.core.PVector;

/**
 *
 * @author wind
 */
public class SpawnFactory {
    
    private PApplet p;
    private ArrayList<_GameObject> objs;
    private ArrayList<_GameObject> enemies;
    private HashMap<String, _GameObject> e_init;
    private int spawnType;

    public SpawnFactory(PApplet p, ArrayList<_GameObject> objs) {
        this.p = p;
        this.objs = objs;
        this.enemies = new ArrayList<>();
        this.e_init = new HashMap<>();
        
        PVector pos = new PVector(50, p.height*0.5f);
        Player player = new Player(p,pos,40,15);
        objs.add(player);
        
        for(int c = 0; c<5; ++c)
        {
            Obstacle obs = new Obstacle(p,pos.copy(),30,70);
            obs.move();
            obs.isEnemy = true;
            obs.zombie = true;
            e_init.put("obs"+c, obs);
            Enemy3 e3 = new Enemy3(p, pos.copy(), 30, 30);
            e3.move();
            e3.isEnemy = true;
            e3.zombie = true;
            e_init.put("e3"+c, e3);
            for(int i=0; i<5; ++i)
            {
                Enemy1 e1 = new Enemy1(p,pos.copy(),25,25);
                e1.move();
                e1.isEnemy = true;
                e1.zombie = true;
                e_init.put("e1_"+i+Integer.toString(c), e1);
            }
            for(int i=0; i<2; ++i)
            {
                Enemy2 e21 = new Enemy2(p,pos.copy(),20,20,PI/2);
                e21.move();
                e21.isEnemy = true;
                e21.zombie= true;
                Enemy2 e22 = new Enemy2(p,pos.copy(),20,20,0);
                e22.move();
                e22.isEnemy = true;
                e22.zombie = true;
                e_init.put("e21_"+i+Integer.toString(c), e21);
                e_init.put("e22_"+i+Integer.toString(c), e22);

            }
        }
        
    }
    
    public void spawn()
    {
        spawnType = p.round(p.random(0, 3));
        _GameObject en = null;
        for(_GameObject e : enemies)
        {
            if(e.zombie || e.silent_zombie)
            {
                en = e;
                break;
            }
        }
        if(en != null)
        {
            enemies.remove(en);
        }
        
        _GameObject obj;
        if(enemies.size() < 5 && p.frameCount % 10 == 0)
        {
            switch (spawnType)
            {
                case 0:
                    obj = e_init.get("obs"+Obstacle.spawn_c);
                    if(!obj.zombie && !obj.silent_zombie)
                    {
                        if(Obstacle.spawn_c == 4)
                            break;
                        Obstacle.spawn_c++;
                        break;
                    }
                    obj.pos.x = p.width+300;
                    obj.pos.y = p.height-50;
                    obj.hide = false;
                    obj.zombie = false;
                    obj.silent_zombie = false;
                    enemies.add(obj);
                    objs.add(obj);
                    break;
                case 1:
                    float h = p.random(0,1);
                    for(int i=0;i<5;++i)
                    {
                        obj = e_init.get("e1_"+i+Integer.toString(Enemy1.spawn_c));
                        if(!obj.zombie && !obj.silent_zombie)
                        {
                            if(Enemy1.spawn_c == 4)
                                break;
                            Enemy1.spawn_c++;
                            break;
                        }
                        obj.pos.x = p.width+50+i*70;
                        obj.pos.y = p.height*h;
                        obj.hide = false;
                        obj.zombie = false;
                        obj.silent_zombie = false;
                        objs.add(obj);
                        enemies.add(obj);
                    }
                    break;
                case 2:
                    float hh = p.random(0,1);
                    for(int i=0;i<2;++i)
                    {
                        obj = e_init.get("e21_"+i+Integer.toString(Enemy2.spawn_c));
                        if(!obj.zombie && !obj.silent_zombie)
                        {
                            if(Enemy2.spawn_c == 4)
                                break;
                            Enemy2.spawn_c++;
                            break;
                        }
                        obj.pos.x = p.width + 200 + 50*i;
                        obj.pos.y = p.height*hh;
                        obj.hide = false;
                        obj.zombie = false;
                        obj.silent_zombie = false;
                        enemies.add(obj);
                        objs.add(obj);
                        obj = e_init.get("e22_"+i+Integer.toString(Enemy2.spawn_c));
                        if(!obj.zombie && !obj.silent_zombie)
                        {
                            if(Enemy2.spawn_c == 4)
                                break;
                            Enemy2.spawn_c++;
                            break;
                        }
                        obj.pos.x = p.width + 150 + 50*i;
                        obj.pos.y = p.height*hh;
                        obj.hide = false;
                        obj.zombie = false;
                        obj.silent_zombie = false;
                        enemies.add(obj);
                        objs.add(obj);
                    }
                    break;
                case 3:
                    obj = e_init.get("e3"+Enemy3.spawn_c);
                    if(!obj.zombie && !obj.silent_zombie)
                    {
                        if(Enemy3.spawn_c == 4)
                            break;
                        Enemy3.spawn_c++;
                        break;
                    }
                    obj.pos.x = p.width+400;
                    obj.pos.y = 200;
                    obj.hide = false;
                    obj.zombie = false;
                    obj.silent_zombie = false;
                    enemies.add(obj);
                    objs.add(obj);
                    break;
                default:
                    break;
            }
        }
    }
    
}
