package aljava.jogo;

import aljava.Alj;
import aljava.util.Direcao;
import java.awt.Color;
import java.awt.Point;
import java.util.ArrayList;

public class CenaComColisao extends Cena {

    private ArrayList<Retangulo> objetos;

    public CenaComColisao(String sceneFile){
        super(sceneFile);
        this.objetos = new ArrayList<Retangulo>();
    }

    public void adicionaObjeto(Retangulo obj) {
        this.objetos.add(obj);
    }

    public void processa() {
        for (Retangulo obj : this.objetos) {
             if(obj instanceof RetanguloGravidade){
                 RetanguloGravidade r = (RetanguloGravidade)obj;
                 r.saiuDoChao();
             }
            this.verificaColisao(obj);
        }
    }

    public boolean temColisaoComTile(Retangulo obj, int idTile){
        ArrayList<Tile> tiles = this.pegaTilesComColisao(obj);
        for (Tile tile : tiles) {
            if ((tile.pegaId() == idTile) && obj.toca(tile)) {
                return true;
            }
        }
        return false;
    }

    public void desenhaDebug(Retangulo obj){            
            ArrayList<Tile> tiles = this.pegaTilesComColisao(obj);
            for (Tile tile : tiles) {
                if ((tile.pegaId() > 1) && obj.toca(tile)) {
                    Alj.cor.objeto(Color.red);

                    Alj.cor.nome("branco");
                    Alj.desenha.texto(tile.pegaX()+10, tile.pegaY()+10, ""+tile.pegaId(), 12);

                    Direcao d = obj.pegaLadoMaisProximo(tile);
                    Point p = null;
                    switch(d){
                        case ESQUERDA: p = tile.pegaPontoEsquerda(); break;
                        case DIREITA: p = tile.pegaPontoDireita(); break;
                        case CIMA: p = tile.pegaPontoCima(); break;
                        case BAIXO: p = tile.pegaPontoBaixo(); break;
                    }
                    Alj.cor.nome("azul");
                    Alj.desenha.linha(obj.pegaPontoCentral().x, obj.pegaPontoCentral().y, p.x, p.y);
                } else {
                    Alj.cor.objeto(Color.black);
                }
                Alj.desenha.retanguloBorda(tile.pegaX(), tile.pegaY(), 32, 32);
                
              
            }
        
    }

    private void verificaColisao(Retangulo obj) {
        ArrayList<Tile> tiles = this.pegaTilesComColisao(obj);
        Direcao direcao = null;
        for(Tile tile : tiles){
            if ( tile.pegaTipo().ehSolido() && obj.toca(tile)) {
                direcao = obj.pegaLadoMaisProximo(tile);
                this.realizaColisao(obj, tile, direcao);
            }
        }                
    }

    private void realizaColisao(Retangulo obj, Tile tile, Direcao direcao) {
        switch (direcao) {
            case CIMA:
                if(obj instanceof RetanguloGravidade){
                    RetanguloGravidade r = (RetanguloGravidade)obj;
                    if(r.estaSubindo()){
                        int base = obj.pegaY() + obj.pegaAltura();
                        if(base >= tile.pegaY() ){
                            r.para();
                            obj.alteraY(tile.pegaY() - obj.pegaAltura());
                        }
                    } else {
                        r.para();
                        obj.alteraY(tile.pegaY() - obj.pegaAltura());
                    }
                } else {
                    obj.alteraY(tile.pegaY() - obj.pegaAltura());
                }
               
                break;
            case BAIXO:
                
                obj.alteraY( tile.pegaY() + tile.pegaAltura() );
                if(obj instanceof RetanguloGravidade){
                    RetanguloGravidade r = (RetanguloGravidade)obj;
                    r.paraSubida();
                }
                break;
            case ESQUERDA:
                obj.alteraX( tile.pegaX() - obj.pegaLargura());
                
                break;
            case DIREITA:
                obj.alteraX(tile.pegaX() + tile.pegaLargura());
                break;
        }
    }
}
