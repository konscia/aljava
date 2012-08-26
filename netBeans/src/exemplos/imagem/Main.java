/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package exemplos.imagem;

import aljava.Alj;

/**
 *
 * @author kaleu
 */
public class Main {
  public static void main(String args[]){
    
    Ryu ryu = new Ryu();
    
    while(true){
      
      Alj.tela.limpa();
      
      if( Alj.tecla.press("esquerda") ){
        ryu.moveHorizontal(-10);
      }
            
      if( Alj.tecla.press("direita") ){
        ryu.moveHorizontal(+10);
      }
      
      if( Alj.tecla.press("cima") ){
        ryu.moveVertical(-10);
      }
            
      if( Alj.tecla.press("baixo") ){
        ryu.moveVertical(+10);
      }
      
      ryu.desenha();      
      Alj.tela.exibe();
      Alj.util.espera(50);
    }
    
    
  }
}
