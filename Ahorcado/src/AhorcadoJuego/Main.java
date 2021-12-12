package AhorcadoJuego;

import java.io.IOException;

import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;

/**
 * @author Miguel Angel Lopez Torralba
 */
public class Main {

    /**
     * @param args the command line arguments
     * @throws UnsupportedAudioFileException 
     * @throws IOException 
     * @throws LineUnavailableException 
     */
    public static void main(String[] args) throws LineUnavailableException, IOException, UnsupportedAudioFileException {
    	
        new Interfaz().show();
    }

}
