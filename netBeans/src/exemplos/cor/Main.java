package exemplos.cor;

import aljava.Alj;

public class Main {
  public static void main(String args[]){
    CirculoComCor   c = new CirculoComCor(200, 20, 40, 40);
    Circulo c2 = new Circulo(20, 20, 40, 40);       
        
    while(true){            
      Alj.tela.limpa();
      
      
      
       if(Alj.mouse.clickE()){
        c.maisVermelho(10);
      }
      
      if(Alj.mouse.clickD()){
        c.maisVermelho(-10);
      }
      
      c.desenha();
      
      Alj.cor.hexadecimal("#2266FF");
      c2.desenha();
      
      Alj.tela.exibe();      
      Alj.util.espera(50);
    }       
  }
}
