package aljava;

public class Gif extends Imagem {

    long milisegundosInicial;
    int limiteTempoExecucao;

    public Gif(String filename, int paraExibicaoEmXMilisegundos){
        super(filename);
        milisegundosInicial = System.currentTimeMillis();
        limiteTempoExecucao = paraExibicaoEmXMilisegundos;
    }

    public Gif(String filename){
        super(filename);
        milisegundosInicial = System.currentTimeMillis();
        limiteTempoExecucao = 0;
    }

    public boolean estaParado(){
        return ( (System.currentTimeMillis() - this.milisegundosInicial) > limiteTempoExecucao );
    }

    @Override
    public void desenha(int x, int y){
        if(limiteTempoExecucao == 0){
            super.desenha(x, y);
            return;
        }

        if( !estaParado() ){
            super.desenha(x, y);
        }
    }
}
