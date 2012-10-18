/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package exemplos.som;

import aljava.Alj;
import aljava.Som;

/**
 *
 * @author KALEU
 */
public class Principal {

    public static void main(String args[]){
        System.out.println("Carregando Sons");
        Som golpe = new Som("sons/som4.wav");

        while(true){
            if(Alj.mouse.clickE()){
                Som golpeTemp = new Som("sons/som4.wav");
                golpeTemp.toca();

                //golpe.toca();
                Alj.util.espera(200);
            }

            if(Alj.mouse.clickD()){
                 System.exit(0);
            }


        }
    }
}
