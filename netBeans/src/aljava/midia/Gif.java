package aljava.midia;

import aljava.util.ContadorTempo;

/**
 * Gerencia imagens GIF que devem parar a exibição após um determinado tempo.
 */
public class Gif extends Imagem {

    protected ContadorTempo contador;

    /**
     * Construtor para informar o tempo máximo no qual o GIF será executado.
     * Isso é útil em casos como explosões, cuja animação deve ser executada apenas uma vez.
     * @param caminhoArquivo nome do arquivo de imagem Ex: "imagens/explosao.gif"
     * @param tempoParaPararAnimacao
     */
    public Gif(String caminhoArquivo, int tempoParaPararAnimacao){
        super(caminhoArquivo);
        contador = new ContadorTempo(tempoParaPararAnimacao);
    }

    /**
     * Construtor que funciona igual a um objeto imagem normal.
     * @param caminhoArquivo nome do arquivo de imagem Ex: "imagens/personagem_caminhando.gif"
     */
    public Gif(String caminhoArquivo){
        super(caminhoArquivo);
    }

    /**
     * Informa se a animação já terminou.
     * @return boolean
     */
    public boolean terminou(){
        if(contador == null){
            return false;
        }

        return contador.terminou();
    }

    /**
     * Reinicia a animação
     */
    public void reinicia(){
        contador.reinicia();
    }

    @Override
    public void desenha(int x, int y){
        //Caso nenhum limite tenha sido informado, desenha sempre.
        if(contador == null){
            super.desenha(x, y);
            return;
        }

        if( !terminou() ){
            super.desenha(x, y);
        }
    }
}
