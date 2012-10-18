package aljava;

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

    public int tempoPassado(){
        return (int)(System.currentTimeMillis() - this.milisegundosInicial);
    }

}
