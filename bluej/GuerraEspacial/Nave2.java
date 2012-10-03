import aljava.Alj;

class Nave2 {

    int x;
    int y;
    
    Nave2(){
        x = 140;
        y = 240;        
    }
    
    void moveE(){
        x -= 1;
    }
    
    void moveD(){
        x += 1;
    }
    
    void desenha(){
        Alj.desenha.triangulo(x, y, 20, 20);
        Alj.tela.exibe();
    }

}