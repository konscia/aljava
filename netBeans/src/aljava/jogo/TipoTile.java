package aljava.jogo;

import aljava.midia.Imagem;

public class TipoTile {

    private int id;
    private Imagem img;
    private boolean ehSolido;

    public TipoTile(int _id, Imagem _img, boolean _ehSolido){
        id = _id;
        img = _img;
        ehSolido = _ehSolido;
    }

    public boolean ehSolido() {
        return ehSolido;
    }

    public int pegaId() {
        return id;
    }

    public Imagem pegaImagem() {
        return img;
    }


}
