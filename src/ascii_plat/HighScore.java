package ascii_plat;

import java.io.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import processing.core.PApplet;
import processing.core.PFont;

class HighScore{
    
    private PApplet p;
    private Colider c;
    private PFont font;
    private static int per= 47;
    private static int highscore;
    public HighScore(){
        
    }
    public HighScore(PApplet p, Colider c) {
        this.p=p;
        this.c=c;
       
        font=p.createFont("DroidSansMono.ttf", 14);
        p.textFont(font, 14);
    }
    public void draw(){
        p.fill(252, 158, 27);
        if(c.score > highscore)
        {
            overwriteHighScore(c.score);
            p.text("HighScore: "+c.score,  p.width*0.4f, 70);
        }
        else   
        p.text("HighScore: "+highscore,  p.width*0.4f, 70); 
        
       
        p.fill(255);
    }

    public void setHighscore(int highscore) {
        this.highscore =highscore;
        
        
    }
    public void overwriteHighScore(int score){
            if(c.score > highscore)
            {
                highscore=c.score;
                char a='/';
//      
             BufferedWriter bufferedWriter = null;
                    try {
                        String strContent ="";
                        strContent+=Integer.toString(highscore)+a;
                         File myFile = new File("highscore.txt");
                     // check if file exist, otherwise create the file before writing
                        if (!myFile.exists()) {
                myFile.createNewFile();
            }
            Writer writer = new FileWriter(myFile);
            bufferedWriter = new BufferedWriter(writer);
            bufferedWriter.write(strContent);
        } catch (IOException e) {
            e.printStackTrace();
        } finally{
            try{
                if(bufferedWriter != null) bufferedWriter.close();
            } catch(Exception ex){
                 
            }
        }
            }
      
    }
}
