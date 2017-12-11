/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ascii_plat;

 
import java.io.File;
import javax.media.Manager;
import javax.media.Player;


/**
 *
 * @author Botond
 */
public class Sound {
    static Player audioPlayer = null;
    
    public Sound() {
		 try {
             Manager.createRealizedPlayer(new File("sound.mp3").toURL()).start();
                 } catch (Exception ex) { ex.printStackTrace();  }
                }

	



    
    
}
