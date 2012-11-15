package aljava.jogo;

import aljava.jogo.Retangulo;

/**
 * @author VisionLab/PUC-Rio
 */
public class Tile extends Retangulo
{
    private int id;
    private TipoTile tipo;

    public Tile(int x, int y, int largura, int altura, TipoTile tipo) {
       super(x, y, largura, altura);
       this.tipo = tipo;
    }

    public int pegaId(){
        return id;
    }

    public TipoTile pegaTipo(){
        return tipo;
    }

}
