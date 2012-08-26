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
public class Triangulo {
  int x, y, largura, altura;  

  public Triangulo(int x, int y, int largura, int altura) {
    this.x = x;
    this.y = y;
    this.largura = largura;
    this.altura = altura;
  }
  
  public void desenha(){
    Alj.desenha.triangulo(x, y, largura, altura);
  }
}
