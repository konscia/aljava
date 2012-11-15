package aljava.jogo;

import aljava.Alj;
import aljava.util.Direcao;
import java.awt.Point;
import java.awt.Rectangle;

public class Retangulo {

    protected int x;
    protected int y;
    protected int largura;
    protected int altura;

    public Retangulo(int x, int y, int largura, int altura){
        this.x = x;
        this.y = y;
        this.largura = largura;
        this.altura = altura;
    }

    /** Acesso **/

    public int pegaX(){
        return x;
    }

    public int pegaY(){
        return y;
    }

    public int pegaAltura(){
        return altura;
    }

    public int pegaLargura(){
        return largura;
    }

    /** Modificadores **/

    public void alteraX(int novoX){
        x = novoX;
    }

    public void alteraY(int novoY){
        y = novoY;
    }

    public void alteraAltura(int novoAltura){
        altura = novoAltura;
    }

    public void alteraLargura(int novoLargura){
        largura = novoLargura;
    }

    public void moveX(int distancia){
        x += distancia;
    }

    public void moveY(int distancia){
        y += distancia;
    }

    /** Intersecção **/

    public Rectangle pegaRectangle(){
        return new Rectangle(x, y, largura, altura);
    }


    public boolean toca(Retangulo outroRetangulo){
        return this.pegaRectangle().intersects(outroRetangulo.pegaRectangle());
    }

    public boolean toca(int xPonto, int yPonto){
        return this.pegaRectangle().contains(new Point(xPonto, yPonto));
    }

    /**
     * Recupera o lado mais próximo do outro retangulo em relação a este.
     * Ou seja, se o lado do outro retangulo mais próximo é esquerda, direita, cima ou baixo.
     *
     * O cálculo é feito a partir do ponto central deste retangulo, em relacao aos pontos de cada lado.
     * @param outroRetangulo
     * @return Direcao
     */
    public Direcao pegaLadoMaisProximo(Retangulo outroRetangulo){

        Direcao menor = Direcao.ESQUERDA;
        int distanciaMenor = (int)pegaPontoCentral().distance( outroRetangulo.pegaPontoEsquerda());

        int distanciaDireita = (int)pegaPontoCentral().distance( outroRetangulo.pegaPontoDireita());
        int distanciaCima = (int)pegaPontoCentral().distance( outroRetangulo.pegaPontoCima());
        int distanciaBaixo = (int)pegaPontoCentral().distance( outroRetangulo.pegaPontoBaixo());

        if(distanciaDireita < distanciaMenor){
            menor = Direcao.DIREITA;
            distanciaMenor = distanciaDireita;
        }

        if(distanciaCima < distanciaMenor){
            menor = Direcao.CIMA;
            distanciaMenor = distanciaCima;
        }

        if(distanciaBaixo < distanciaMenor){
            menor = Direcao.BAIXO;
            distanciaMenor = distanciaBaixo;
        }

        return menor;
    }

    public Point pegaPontoMin(){
        return new Point(x, y);
    }

    public Point pegaPontoMax(){
        return new Point(x+largura, y+altura);
    }

    public Point pegaPontoCentral(){
        return new Point(x+(largura/2), y+(altura/2));
    }
    
    public Point pegaPontoEsquerda(){
        return new Point(x, y+(altura/2));
    }
    
    public Point pegaPontoDireita(){
        return new Point(x+largura, y+(altura/2));
    }
    
    public Point pegaPontoCima(){
        return new Point(x+(largura/2), y);
    }
    
    public Point pegaPontoBaixo(){
        return new Point(x+(largura/2), y+altura);
    }

    /** DEBUG **/

    /**
     * Este método desenha o retângulo e os 5 pontos associados a ele, o central, da esquerda, direita, cima e baixo.
     */
    public void desenha(){
        Alj.cor.nome("laranja");
        Alj.desenha.retanguloBorda(x, y, largura, altura);
        Alj.cor.nome("vermelho");
        
        Point p = pegaPontoCentral();
        Alj.desenha.oval((int)p.getX()-1, (int)p.getY()-1, 2, 2);
        
        p = pegaPontoBaixo();
        Alj.desenha.oval((int)p.getX()-1, (int)p.getY()-1, 2, 2);
        
        p = pegaPontoEsquerda();
        Alj.desenha.oval((int)p.getX()-1, (int)p.getY()-1, 2, 2);
        
        p = pegaPontoDireita();
        Alj.desenha.oval((int)p.getX()-1, (int)p.getY()-1, 2, 2);
        
        p = pegaPontoCima();
        Alj.desenha.oval((int)p.getX()-1, (int)p.getY()-1, 2, 2);
    }





}
