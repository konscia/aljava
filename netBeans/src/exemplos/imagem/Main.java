/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package exemplos.imagem;

import aljava.Alj;
import aljava.ContadorTempo;
import aljava.Gif;
import aljava.Imagem;

/**
 *
 * @author kaleu
 */
public class Main {
  public static void main(String args[]){
    
    Ryu ryu = new Ryu();
    ImagemGrande img = new ImagemGrande();
    Gif gifPausa = new Gif("imagens/eletrico.gif", 2000);
    Imagem gifContinuo = new Imagem("imagens/MoveDireita.gif");
    ContadorTempo contador = new ContadorTempo(4000);
    

    int fps = 0;
    int contFrames = 0;
    long milisegundos = System.currentTimeMillis();

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

      if( Alj.tecla.press("espaco") ){
        ryu.inverte();
      }

      img.desenha();
      ryu.desenha();

      gifPausa.desenha(100,100);
      gifContinuo.desenha(50,50);

      if(contador.terminou()){
          Alj.tela.exibeMensagem("Fim");
          Alj.tela.finaliza();
      }
      

      contFrames++;
      long currentTime = System.currentTimeMillis();
      if((currentTime - milisegundos) > 1000){
        fps = contFrames;
        contFrames = 0;
        milisegundos = currentTime;
      }

      Alj.cor.rgb(0, 0, 0);
      Alj.desenha.texto(200, 20, "FPS: "+fps, 20);
      Alj.tela.exibe();
    }
    
    
  }
}
