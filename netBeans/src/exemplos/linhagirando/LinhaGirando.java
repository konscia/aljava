package exemplos.linhagirando;
import aljava.Aljava;
import aljava.Alj;

public class LinhaGirando{
  
  int x;
  int y;
  int xFinal;
  int yFinal;
  
  int graus;

  LinhaGirando(int _x, int _y, int _xFinal, int _yFinal){
    super();
    x = _x;
    y = _y;
    xFinal = _xFinal;
    yFinal = _yFinal;
    graus = 0;
  }
  
  void gira(int _graus){
    graus += _graus;
  }

  void desenha() {
    //Para rotacionar, uso o ponto central da linha
    int xCentral = (x + xFinal) / 2;
    int yCentral = (y + yFinal) / 2;
      
    Alj.transforma.rotaciona(graus, xCentral, yCentral);
    Alj.desenha.linha(x, y, xFinal, yFinal);
    Alj.transforma.limpaRotacao();
  }
    
}