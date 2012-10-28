package aljava.entrada;

import java.awt.Component;
import java.awt.event.KeyEvent;
import java.util.HashMap;

public class Teclado {
    TecladoObserver observador;
    HashMap<String, Integer> teclasString;

    public Teclado(){
        observador = new TecladoObserver();
        teclasString = new HashMap<String, Integer>();

        teclasString.put("enter", KeyEvent.VK_ENTER);
        teclasString.put("espaco", KeyEvent.VK_SPACE);

        teclasString.put("esquerda", KeyEvent.VK_LEFT);
        teclasString.put("direita", KeyEvent.VK_RIGHT);
        teclasString.put("cima", KeyEvent.VK_UP);
        teclasString.put("baixo", KeyEvent.VK_DOWN);

        teclasString.put("a", KeyEvent.VK_A);
        teclasString.put("b", KeyEvent.VK_B);
        teclasString.put("c", KeyEvent.VK_C);
        teclasString.put("d", KeyEvent.VK_D);
        teclasString.put("e", KeyEvent.VK_E);
        teclasString.put("f", KeyEvent.VK_F);
        teclasString.put("g", KeyEvent.VK_G);
        teclasString.put("h", KeyEvent.VK_H);
        teclasString.put("i", KeyEvent.VK_I);
        teclasString.put("j", KeyEvent.VK_J);
        teclasString.put("k", KeyEvent.VK_K);
        teclasString.put("l", KeyEvent.VK_L);
        teclasString.put("m", KeyEvent.VK_M);
        teclasString.put("n", KeyEvent.VK_N);
        teclasString.put("o", KeyEvent.VK_O);
        teclasString.put("p", KeyEvent.VK_P);
        teclasString.put("q", KeyEvent.VK_Q);
        teclasString.put("r", KeyEvent.VK_R);
        teclasString.put("s", KeyEvent.VK_S);
        teclasString.put("t", KeyEvent.VK_T);
        teclasString.put("u", KeyEvent.VK_U);
        teclasString.put("v", KeyEvent.VK_V);
        teclasString.put("x", KeyEvent.VK_X);
        teclasString.put("z", KeyEvent.VK_Z);
        teclasString.put("w", KeyEvent.VK_W);
        teclasString.put("y", KeyEvent.VK_Y);

        teclasString.put("NUMPAD1", KeyEvent.VK_NUMPAD1);
        teclasString.put("NUMPAD2", KeyEvent.VK_NUMPAD2);
        teclasString.put("NUMPAD3", KeyEvent.VK_NUMPAD3);
        teclasString.put("NUMPAD4", KeyEvent.VK_NUMPAD4);
        teclasString.put("NUMPAD5", KeyEvent.VK_NUMPAD5);
        teclasString.put("NUMPAD6", KeyEvent.VK_NUMPAD6);
        teclasString.put("NUMPAD7", KeyEvent.VK_NUMPAD7);
        teclasString.put("NUMPAD8", KeyEvent.VK_NUMPAD8);
        teclasString.put("NUMPAD9", KeyEvent.VK_NUMPAD9);
        teclasString.put("NUMPAD0", KeyEvent.VK_NUMPAD0);

        teclasString.put("1", KeyEvent.VK_1);
        teclasString.put("2", KeyEvent.VK_2);
        teclasString.put("3", KeyEvent.VK_3);
        teclasString.put("4", KeyEvent.VK_4);
        teclasString.put("5", KeyEvent.VK_5);
        teclasString.put("6", KeyEvent.VK_6);
        teclasString.put("7", KeyEvent.VK_7);
        teclasString.put("8", KeyEvent.VK_8);
        teclasString.put("9", KeyEvent.VK_9);
        teclasString.put("0", KeyEvent.VK_0);
    }

    public void observa(Component c){
        c.addKeyListener(observador);
    }

    public boolean teclaPressionada(String tecla){
        if(teclasString.containsKey(tecla)){
            return teclaPressionada(teclasString.get(tecla));
        }

        System.err.println("A tecla \""+tecla+"\" não está configurada no Aljava. Tente usar as constantes da classe KeyEvent.");
        return false;
    }

    public boolean teclaPressionada(int tecla){
        return observador.pressionada(tecla);
    }
}
