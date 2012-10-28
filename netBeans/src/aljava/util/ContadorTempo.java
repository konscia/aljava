package aljava.util;

public class ContadorTempo {

    long milisegundosInicial;
    int limiteTempo;

    public ContadorTempo(int paraExibicaoEmXMilisegundos){
        milisegundosInicial = System.currentTimeMillis();
        limiteTempo = paraExibicaoEmXMilisegundos;
    }

    public boolean terminou(){
        return (  this.tempoPassado() > limiteTempo );
    }

    public void reinicia(){
        milisegundosInicial = System.currentTimeMillis();
    }

    public int tempoPassado(){
        return (int)(System.currentTimeMillis() - this.milisegundosInicial);
    }

}
