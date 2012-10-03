import aljava.Alj;

class Nave
{
    int x;
    int y;
    int largura;
    int altura;
    int velocidade;

    String nome;
    int pontos;
    
    Nave(){
        x = 140;
        y = 560;
        largura = 40;
        altura = 40;
        velocidade = 5;
        
        nome = Alj.tela.solicitaTexto("?Su nombre. guerreiro caliente?");
        pontos = 0;
    }
    
    void moveEsquerda(){
        x -= velocidade;
    }
    
    void moveDireita(){
        x += velocidade;
    }
    
    void moveCima(){
        y -= velocidade;
    }
    
    void moveBaixo(){
        y += velocidade;
    }
    
    void desenha(){
        //Alj.cor.rgb(250, 175, 175);
        //Alj.desenha.triangulo(x, y, largura, altura);
        Alj.desenha.imagem(x, y, "nave.png");
    }

    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
}
