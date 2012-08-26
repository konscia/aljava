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
public class Circulo {
  int x, y, largura, altura;  

  public Circulo(int x, int y, int largura, int altura) {
    super();
    this.x = x;
    this.y = y;
    this.largura = largura;
    this.altura = altura;
  }
  
  public void desenha(){
    Alj.desenha.oval(x, y, largura, altura);
  }
}
