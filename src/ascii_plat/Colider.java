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
    private Explosion ex;
    public int score=0;

    public Colider(PApplet p, ArrayList<_GameObject> objs, Explosion ex) {
        this.p = p;
        this.objs = objs;
        this.ex = ex;
        //this.ex.hide = true;
    }
    
    public void checkHit()
    {
        for(_GameObject obj1 : objs)
        {
            if(obj1 instanceof Explosion)
                continue;
            for(_GameObject obj2 : objs)
            {
                if(obj2 instanceof Explosion || 
                        (obj1 instanceof Projectile && obj2 instanceof Player) ||
                        (obj2 instanceof Projectile && obj1 instanceof Player) ||
                        (obj2 instanceof Projectile && obj1 instanceof Projectile))
                    continue;
                if(obj1 != obj2 && obj1.checkColide(obj2))
                {
                    obj2.zombie = true;
                    if(obj1 instanceof Projectile && obj2 instanceof Enemy1)
                        score+=1;
                    //System.out.println(obj1.toString()+" hit "+obj2.toString());
                }
            }
        }
        this.destroyObjs();
    }
    
    private void destroyObjs()
    {
        ArrayList<_GameObject> zombies = new ArrayList<>();
       
        for (_GameObject obj : objs)
        {
            if(obj.zombie)
                zombies.add(obj);
        }
        for(_GameObject obj : zombies)
        {
            obj.hide = true;
            ex.pos.x = obj.pos.x;
            ex.pos.y = obj.pos.y;
            ex.setC(0);
            if(obj.die())
            {
                objs.remove(obj);
            }
        }
    }
}
