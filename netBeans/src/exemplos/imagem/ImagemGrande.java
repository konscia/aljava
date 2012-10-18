
package exemplos.imagem;

import aljava.Alj;
import aljava.Imagem;
import aljava.Imagem;
import java.util.logging.Level;
import java.util.logging.Logger;


public class ImagemGrande {

  Imagem img1;
  Imagem img2;

  ImagemGrande(){
    img1 = new Imagem("imagens/inicio.jpg");
        try {
            img2 = new Imagem("imagens/inicio.jpg");
        } catch (Exception ex) {
            Logger.getLogger(ImagemGrande.class.getName()).log(Level.SEVERE, null, ex);
        }
  }
  
  public void desenha(){
    //img.desenha(0, 0);
    img2.desenha(0, 0);
    img2.desenha(0, 0);
    img2.desenha(0, 0);
    img2.desenha(0, 0);
    img2.desenha(0, 0);
  }
}
