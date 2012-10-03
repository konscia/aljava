package aljava;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;

public class Imagem2 {
    private Image image;
    private static int MAX_COUNT = 50;

    public Imagem2(String filename) throws Exception
    {
        image = Toolkit.getDefaultToolkit().getImage(filename);

        int count = 0;

        while(image.getWidth(null) == -1) {
            Thread.sleep(1);
            count++;

            if(count == MAX_COUNT) {
                throw new Exception("Imagem \""+filename+"\" nï¿½o pode ser carregada");
            }
        }        
    }

    // Gets the Width of this sprite
	public int pegaLargura() {
		return image.getWidth(null);
	}

	// Gets the Height of this sprite
	public int pegaAltura() {
		return image.getHeight(null);
	}

    // Allows easy drawing of this sprite at any position
	public void draw(int x, int y) {
            Alj.desenha.imagem(x, y, image);
	}


}
