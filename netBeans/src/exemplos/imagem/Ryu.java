
package exemplos.imagem;

import aljava.Alj;


public class Ryu {
  
  int graus;
  int x;
  int y;
  
  void gira(int _graus){
    graus += _graus;
  }
  
  void moveHorizontal(int distance){
    x += distance;
  }
  
  void moveVertical(int distance){
    y += distance;
  }
  
  public void desenha(){
    Alj.transforma.rotaciona(graus, 20+21, 20+41);
    Alj.desenha.imagem(x, y, "Ryu.png");
    Alj.transforma.limpaRotacao();
  }
}
