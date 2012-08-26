package exemplos.tela;

import exemplos.texto.*;
import exemplos.linhagirando.*;
import aljava.Alj;

public class Tela {
  public static void main(String args[]){       
    
    int contador = 0;
    while(contador < 200){  
      contador++;
                  
      Alj.tela.tamanho(300+contador, 300+contador);
      Alj.tela.limpa();
      Alj.tela.exibe();      
      
      Alj.util.espera(50);
    
    }       
  }
}
