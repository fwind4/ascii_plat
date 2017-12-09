/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ascii_plat;

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
        repulo=p.loadImage("repulo.jpg");
        this.font=font;
        repulo.resize(repulo.width/2 ,repulo.height/2);
    }

    public void MainMenu()
    {
        p.image(repulo,300,200);
        p.textFont(font, 100);
        p.fill(252, 158, 27);
        p.text("PRODIUS", 850, 450);
        p.textFont(font,50);
        if(menuState == 0)
            p.fill(255);
        else
            p.fill(252, 158, 27);
        p.text("START",850 , 650);
        if(menuState == 1)
            p.fill(255);
        else
            p.fill(252, 158, 27);
        p.text("HOW TO PLAY",850 , 750);
        if(menuState == 2)
            p.fill(255);
        else
            p.fill(252, 158, 27);
        p.text("EXIT",850 , 850);
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
        p.textFont(font,50);
        p.text("Movement: W A S D or Arrow Keys\n" +
               "Fire: Space\n"+
               "Pause: P", 200, 300);
        p.fill(255);
        p.text("ENTER return to main menu", 200, 500);
    }
}
