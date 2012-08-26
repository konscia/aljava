/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package exemplos.cor;

import aljava.Alj;

/**
 *
 * @author kaleu
 */
public class CirculoComCor {
  int x, y, largura, altura; 
  
  int r=120, g=120, b=120;

  public CirculoComCor(int x, int y, int largura, int altura) {
    this.x = x;
    this.y = y;
    this.largura = largura;
    this.altura = altura;
  }
  
  public void maisVermelho(int quant){
    r += quant;
    if(r > 255){
      r = 255;
    }
    
    if(r < 0) {
      r = 0;
    }
  }
  
  public void maisAzul(int quant){
    b += quant;
    if(b > 255){
      b = 255;
    }
    
    if(b < 0) {
      b = 0;
    }
  }
  
  public void maisVerde(int quant){
    g += quant;
    if(g > 255){
      g = 255;
    }
    
    if(g < 0) {
      g = 0;
    }
  }
  
  public void desenha(){
    Alj.cor.rgb(r, g, b);
    Alj.desenha.oval(x, y, largura, altura);
  }
}
