package aljava;

import java.awt.Image;
import java.awt.Toolkit;
import java.awt.geom.AffineTransform;
import java.awt.geom.NoninvertibleTransformException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Imagem {
    private Image image;
    private boolean invertida = false;

    public Imagem(String filename)
    {
        image = Toolkit.getDefaultToolkit().getImage(filename);   
    }

	public int pegaLargura() {
		return image.getWidth(null);
	}

	public int pegaAltura() {
		return image.getHeight(null);
	}

    public void inverte(){
        this.invertida = !this.invertida;
    }

    public void alteraTamanho(int largura, int altura){
        image = image.getScaledInstance(largura, altura, Image.SCALE_DEFAULT);
    }
    
	public void desenha(int x, int y) {
        if(this.invertida){
            this.desenhaInvertida(x, y);
        } else {
            Alj.avancado.getGraphics().drawImage(image, x, y, null);
        }
	}

     public void desenhaInvertida(int x, int y) {
		Alj.avancado.getGraphics().drawImage(image, image.getWidth(null) + x, y, x,
				image.getHeight(null) + y, 0, 0, image.getWidth(null),
				image.getHeight(null), null);
	}


}
