package aljava.jogo;

import aljava.Alj;
import aljava.util.Direction;
import java.awt.Point;
import java.awt.Rectangle;

public class RetanguloGravidade extends Retangulo {

    public static int CHAO = 400;
    public static double GRAVIDADE = 1;
    
    protected double velocidade;

    public RetanguloGravidade(int _x, int _y, int _largura, int _altura){
        super(_x, _y, _largura, _altura);
        this.velocidade = 0;
    }

    public void processa(){
        velocidade -= RetanguloGravidade.GRAVIDADE;
        moveY( (int)-velocidade );
        
        if(chegouNoChao()){
            alteraY(pegaChaoReal());
            velocidade = 0;
        }
    }

    public boolean chegouNoChao(){
        return (pegaY() >= pegaChaoReal());
    }

    public int pegaChaoReal(){
        return (RetanguloGravidade.CHAO - altura);
    }

    public void pula(int forca){
        if(chegouNoChao()){
            velocidade = forca;
        }
    }

}
