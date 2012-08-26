package exemplos.mouse;

import exemplos.linhagirando.*;
import aljava.Alj;

public class Main {
  public static void main(String args[]){
    Rastreador r = new Rastreador();
    
    while(true){      
      r.rastreiaMouse();
      
      Alj.tela.exibe();      
      Alj.util.espera(50);
    }       
  }
}
