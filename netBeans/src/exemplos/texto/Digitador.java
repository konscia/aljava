package exemplos.mouse;

import exemplos.linhagirando.*;
import aljava.Alj;

public class Digitador {
  public static void main(String args[]){
    
    String s = "Kaléu Caminha";
    
    int contador = 0;
    while(contador < s.length()){  
      contador++;
      Alj.tela.limpa();
      
      String letters = s.substring(0, contador);
      
      Alj.cor.nome("vermleho");
      Alj.desenha.texto(20, 20, letters, 20);
      
      Alj.tela.exibe();      
      Alj.util.espera(300);
    
    }       
  }
}
