/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package exemplos.formasGeometricas;

import aljava.Alj;

/**
 *
 * @author kaleu
 */
public class Quadrado {
  int x, y, largura, altura;  

  public Quadrado(int x, int y, int largura, int altura) {
    this.x = x;
    this.y = y;
    this.largura = largura;
    this.altura = altura;
  }
  
  public void desenha(){
    Alj.desenha.retangulo(x, y, largura, altura);
  }
}
