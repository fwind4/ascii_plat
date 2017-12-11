/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ascii_plat;

import java.util.ArrayList;
import processing.core.PApplet;
import processing.core.PImage;
import processing.core.PVector;

/**
 *
 * @author wind
 */
public class Colider {
    
    private PApplet p;
    private ArrayList<_GameObject> objs;
    private ArrayList<_GameObject> zombies;
    private Explosion ex;
    public static int score=0;
    

    public Colider(PApplet p, ArrayList<_GameObject> objs, Explosion ex) {
        this.p = p;
        this.objs = objs;
        zombies = new ArrayList<>();
        this.ex = ex;
        //this.ex.hide = true;
    }
    
    public void checkHit()
    {
        for(_GameObject obj1 : objs)
        {
            for(_GameObject obj2 : objs)
            {
                if(     (obj1 instanceof Projectile && obj2 instanceof Player) ||
                        (obj2 instanceof Projectile && obj1 instanceof Player) ||
                        (obj2 instanceof Projectile && obj1 instanceof Projectile))
                    continue;
                if(obj1 != obj2 && obj1.checkColide(obj2))
                {
                    if(obj1.hittable && obj2.hittable)
                    {
                        obj2.zombie = true;
                        if(obj1 instanceof Projectile && obj2.isEnemy)
                        {
                            score+=1;
                            
                                
                        }
                        if(obj1 instanceof Player)
                        {
                            ((Player)obj1).life-=1;
                        }
                    }
                    //System.out.println(obj1.toString()+" hit "+obj2.toString());
                }
            }
        }
        
        this.destroyObjs();
    }
    
    private void destroyObjs()
    {
        zombies.clear();
        for (_GameObject obj : objs)
        {
            if(obj.zombie || obj.silent_zombie)
                zombies.add(obj);
        }
        for(_GameObject obj : zombies)
        {
            obj.hide = true;
            if(obj.zombie)
            {
                
                ex.pos.x = obj.pos.x;
                ex.pos.y = obj.pos.y;
                ex.setC(0);
            }
            if(obj.die() )
            {
                if(obj.spawn_c > 0 )
                    obj.spawn_c--;
                objs.remove(obj);
                //System.out.println("Removed: "+ obj.getClass().toString());
                
            }
        }
    }
}
