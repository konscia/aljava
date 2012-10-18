
package exemplos.imagem;

import aljava.Alj;
import aljava.Imagem;


public class Ryu {

  Imagem img;
  int graus;
  int x;
  int y;

  public Ryu(){
      img = new Imagem("imagens/Ryu.png");
  }
  void gira(int _graus){
    graus += _graus;
  }
  
  void moveHorizontal(int distance){
    x += distance;
  }
  
  void moveVertical(int distance){
    y += distance;
  }

  void inverte(){
      img.inverte();
  }
  
  public void desenha(){
    Alj.transforma.rotaciona(graus, 20+21, 20+41);
    img.desenha(x, y);
    Alj.transforma.limpaRotacao();
  }
}
