package aljava.jogo;

public class RetanguloGravidade extends Retangulo {

    public static int CHAO = 400;
    public static double GRAVIDADE = 1;
    
    protected double velocidade;
    boolean parado = false;

    public RetanguloGravidade(int _x, int _y, int _largura, int _altura){
        super(_x, _y, _largura, _altura);
        this.velocidade = 0;
    }

    public void processa(){
        if(parado){
            return;
        }
        velocidade -= RetanguloGravidade.GRAVIDADE;
        moveY( (int)-velocidade );
        
        if(chegouNoChao()){
            alteraY(pegaChaoReal());
            velocidade = 0;
        }
    }

    public boolean chegouNoChao(){
        return ((pegaY() >= pegaChaoReal()));
    }

    public int pegaChaoReal(){
        return (RetanguloGravidade.CHAO - altura);
    }

    public void pula(int forca){
        if(chegouNoChao() || parado){
            velocidade = forca;
            parado = false;
        }
    }

    public void paraSubida(){
        velocidade = 0;
    }

    public void para(){
        velocidade = 0;
        parado = true;
    }

    public void saiuDoChao(){
        parado = false;
    }

    public boolean estaSubindo(){
        return velocidade > 0;
    }

    public boolean estaDescendo(){
        return velocidade < 0;
    }

}
