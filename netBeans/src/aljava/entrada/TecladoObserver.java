package aljava.entrada;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;
import java.util.HashMap;

/**
 * Classe responsável por gerenciar questões relacionadas ao Teclado
 */
package class TecladoObserver implements KeyListener
{
   // private HashMap<Integer, Integer> teclasPressionadas;
    private ArrayList<Integer> teclasPressionadas;

    public TecladoObserver() {
        teclasPressionadas = new ArrayList<Integer>();
    }

    public synchronized boolean pressionada(int keyCode) {
        return teclasPressionadas.contains(keyCode);
    }

    @Override
    public void keyTyped(KeyEvent e){}

    @Override
    public synchronized void keyPressed(KeyEvent e)
    {        
        if(teclasPressionadas.contains(e.getKeyCode()) == false) {
            teclasPressionadas.add(e.getKeyCode());
        }
    }

    @Override
    public synchronized void keyReleased(KeyEvent e){
        teclasPressionadas.remove( teclasPressionadas.indexOf(e.getKeyCode()) );
    }
}