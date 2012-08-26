package jogos.davelha;



import aljava.Alj;

/**
 *
 * @author kaleu
 */
public class Casinha {
  int x, y, largura, altura;
  //Se o valor for zero, a casa é vazia. 
  //Se o valor for 1, a casa é do jogador 1;
  //Se o valor for 2, a casa é do jogador 2;
  int valor;

  public Casinha(int x, int y, int largura, int altura) {
    this.x = x;
    this.y = y;
    this.largura = largura;
    this.altura = altura;
  }
  
  public boolean estaOcupada(){
    return valor > 0;
  }

  public boolean estaOcupadaPlayer1(){
    return valor == 1;
  }

  public boolean estaOcupadaPlayer2(){
    return valor == 2;
  }
  
  public void ocupaPlayer1(){
    valor = 1;
  }
  
  public void ocupaPlayer2(){
    valor = 2;
  }
  
  public boolean mouseDentro(){
    int xMouse = Alj.mouse.x();
    int yMouse = Alj.mouse.y();
    
    boolean estaDentroHorizontalmente = x < xMouse && xMouse < (x+largura);
    boolean estaDentroVerticalmente = y < yMouse && yMouse < (y+altura);
    
    if( estaDentroHorizontalmente && estaDentroVerticalmente ){
      return true;
    } else {
      return false;
    }
  }
  
  public void desenha(){
    if(valor == 0) {
      Alj.cor.nome("branco");
    } else if (valor == 1){
      Alj.cor.nome("vermelho");
    } else if( valor == 2){
      Alj.cor.nome("azul");
    }
    
    Alj.desenha.retangulo(x, y, largura, altura);
  }
}
