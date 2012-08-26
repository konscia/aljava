/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package exemplos.som;

import aljava.Alj;

/**
 *
 * @author KALEU
 */
public class Principal {

    public static void main(String args[]){
        System.out.println("Carregando Sons");
        Alj.som.carrega("golpe", "sounds/golpe.wav");
        Alj.som.carrega("golpe2", "sounds/golpe2.wav");
        Alj.som.carrega("comeon", "sounds/comeon.wav");

        System.out.println("Som 1");
        Alj.som.toca("golpe");
        Alj.util.espera(1000);

        System.out.println("Som 2");
        Alj.som.toca("golpe2");
        Alj.util.espera(1000);

        System.out.println("Som 3 - Loop");
        Alj.som.loop("comeon");
        Alj.util.espera(3000);

        System.out.println("Som 3 - Para");
        Alj.som.para("comeon");
    }
}
