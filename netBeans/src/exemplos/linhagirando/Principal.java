package exemplos.linhagirando;

import aljava.Alj;

public class Principal {
  
  public static void main(String args[]){
    LinhaGirando l1 = new LinhaGirando(100, 100, 200, 200);
    LinhaGirando l2 = new LinhaGirando(50, 50, 100, 100);
    LinhaGirando l3 = new LinhaGirando(220, 50, 50, 100);
    
    int contador = 0;
    while(contador < 360){
      contador += 1;   
      
      Alj.tela.limpa();
      
      l1.gira(2);
      l2.gira(1);
      l3.gira(5);
      
      l1.desenha();
      l2.desenha();
      l3.desenha();
                  
      Alj.tela.exibe();      
      Alj.util.espera(50);
    }       
  }
}
