
package aljava.entrada;

import java.awt.Component;

public class Mouse {

    MouseObserver observador;

    public Mouse(){
        observador = new MouseObserver();
    }

    public void observa(Component c){
        c.addMouseListener(observador);
        c.addMouseMotionListener(observador);
    }

    public int pegaX(){
        return observador.getMousePos().x;
    }

    public int pegaY(){
        return observador.getMousePos().y;
    }

    public boolean botaoEsquerdoPressionado(){
        return observador.isLeftButtonPressed();
    }

    public boolean botaoDireitoPressionado(){
        return observador.isRightButtonPressed();
    }

    public boolean botaoMeioPressionado(){
        return observador.isMiddleButtonPressed();
    }
}
