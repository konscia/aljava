package aljava;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;

import javax.sound.sampled.AudioFormat;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.DataLine;
import javax.sound.sampled.LineEvent;
import javax.sound.sampled.LineListener;

//Read more: http://javafree.uol.com.br/topic-879623-Executar-wav.html#ixzz24f7Flwpl
public class Som {

    public static void tocar(String filename, boolean repetir){
        try {
            InputStream file = (InputStream) new FileInputStream(filename);
            Som.tocar(file, repetir);
        } catch (FileNotFoundException ex) {
           ex.printStackTrace();
        }
    }

    // Toca um som
    public static void tocar(final InputStream arquivo, final boolean repetir) {
        try {
            // Obtém os dados sonoros
            final AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(arquivo);
            Clip clip = AudioSystem.getClip();
            clip.addLineListener(new LineListener() {

                // Evento do LineListener
                public void update(final LineEvent e) {
                    if (e.getType() == LineEvent.Type.STOP) {
                        e.getLine().close();
                    }
                }
            });
            clip.open(audioInputStream);

            // Toca o som
            if (repetir){
                clip.loop(Clip.LOOP_CONTINUOUSLY);
            } else {
                clip.loop(0);
            }
        } catch (final Exception e) {
            e.printStackTrace();
        }
    }
}


