package aljava;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;

/**
 * eSTA CLASSE ENCAPSULA UMA BuferredImage e a desenha utilizando o Aljava.
 */
public class Imagem {

    BufferedImage image;

    public Imagem(String caminhoParaImagem){
        try {
            image = ImageIO.read(new File(caminhoParaImagem));
        } catch (IOException ex) {
           System.err.println("Erro na carga da imagem \""+caminhoParaImagem+"\". Verifique se o caminho informado está correto.");
           System.exit(0);
        } 
    }

    public void desenha(int x, int y){
        Alj.desenha.imagem(x, y, image);
    }

}
