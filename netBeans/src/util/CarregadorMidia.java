
package util;

import aljava.Alj;
import java.awt.Image;
import java.awt.MediaTracker;

public class CarregadorMidia {
    protected MediaTracker mt;
    protected int lastId;

    /** Singleton **/
    protected static CarregadorMidia instancia;
    public static CarregadorMidia instancia(){
        if(instancia == null){
            instancia = new CarregadorMidia();
        }

        return instancia;
    }
    /** Fim Singleton **/

    public CarregadorMidia(){
        mt = new MediaTracker(Alj.avancado.getCanvas());
        lastId = 0;
    }

    public void esperaCarregar(Image img){
        mt.addImage(img, lastId);
        try {
          mt.waitForID(lastId);
          lastId++;
        } catch (InterruptedException e) {
          System.err.println("Ocorreu um erro desconhecido ao carregar a imagem, desculpe.");
          e.printStackTrace();
        }
    }
}
