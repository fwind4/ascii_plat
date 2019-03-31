/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package prodius;

import processing.core.PApplet;
import processing.core.PFont;
import processing.core.PImage;

/**
 *
 * @author Lehel
 */
public class Menu {
    
    private PApplet p;
    private PImage repulo;
    private PFont font;
    public int menuState=0;
    
    public Menu(PApplet p,PFont font) {
        this.p = p;
        repulo=p.loadImage("repulo.png");
        this.font=font;
        repulo.resize(repulo.width/2 ,repulo.height/2);
    }

    public void MainMenu()
    {
        p.image(repulo,p.width*0.11111f,p.height*0.2f);
        p.textFont(font, p.width*0.04f);
        p.fill(252, 158, 27);
        p.text("PRODIUS", p.width*0.5f, p.height*0.4f);
        p.textFont(font,p.width*0.02f);
        if(menuState == 0)
            p.fill(255);
        else
            p.fill(252, 158, 27);
        p.text("START",p.width*0.5f , p.height*0.5f);
        if(menuState == 1)
            p.fill(255);
        else
            p.fill(252, 158, 27);
        p.text("HOW TO PLAY",p.width*0.5f, p.height*0.57f);
        if(menuState == 2)
            p.fill(255);
        else
            p.fill(252, 158, 27);
        p.text("EXIT",p.width*0.5f, p.height*0.64f);
        p.fill(255);
    }
    
    public void menuUp()
    {
        
        if(menuState == 0)
            menuState = 2;
        else
            menuState--;
    }       
    
    public void menuDown()
    {
        
        if(menuState == 2)
            menuState = 0;
        else
            menuState++;
    } 
    
    public void instruction()
    {
        p.fill(252, 158, 27);
        p.textFont(font,p.width*0.02f);
        p.text("Movement: W A S D or Arrow Keys\n" +
               "Fire: Space\n"+
               "Pause: P", p.width*0.2f, p.height*0.3f);
        p.fill(255);
        p.text("ENTER return to main menu", p.width*0.2f, p.height*0.6f);
    }
}
