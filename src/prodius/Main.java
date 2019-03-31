/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package prodius;
/**
 *
 * @author wind
 */
import java.io.*;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        
        FileReader fr = null;
        try {
            File file = new File("highscore.txt");
            fr = new FileReader(file);
            char [] a = new char[50];
            try {
                fr.read(a);
            } catch (IOException ex) {
                Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
            }
            int x=0;
            int i=0;
            while(a[i]!='/'){
                x =(x*10)+Character.getNumericValue(a[i]);
                i++;
            }
            System.out.print(x);
             HighScore highscore = new HighScore();
            highscore.setHighscore(x);
            
            
           
        } catch (FileNotFoundException ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                fr.close();
            } catch (IOException ex) {
                Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        Sketch.main("ascii_plat.Sketch");
    }
    
}
