package jogos.davelha;

import aljava.Alj;

public class JogoDaVelha {

    boolean vezDoJogador1;
    Casinha[] casas;

    public JogoDaVelha() {
        Alj.tela.tamanho(300, 340);
        vezDoJogador1 = true;

        double numero = Alj.tela.solicitaNumeroDouble("Informe seu nome jogador 1.");
        System.out.println(numero);

        int numero2 = Alj.tela.solicitaNumero("Informe seu nome jogador 2.");
        System.out.println(numero2);

        casas = new Casinha[9];
        casas[0] = new Casinha(0, 41, 99, 99);
        casas[1] = new Casinha(101, 41, 99, 99);
        casas[2] = new Casinha(201, 41, 99, 99);

        casas[3] = new Casinha(0, 141, 99, 99);
        casas[4] = new Casinha(101, 141, 99, 99);
        casas[5] = new Casinha(201, 141, 99, 99);

        casas[6] = new Casinha(0, 241, 99, 99);
        casas[7] = new Casinha(101, 241, 99, 99);
        casas[8] = new Casinha(201, 241, 99, 99);

        desenha();
    }

    public void loopJogo() {
        while (true) {
            clickCasinhas();            
            desenha();
            Alj.tela.exibe();

            //Se alguém ganhou, só quero que apareça com tudo desenhado.
            verificaVitoria();

        }
    }

    public void clickCasinhas() {
        for (int i = 0; i < 9; i++) {
            if (casas[i].estaOcupada()) {
                continue; //Isso pula para o próximo loop
            }

            if (casas[i].mouseDentro() && Alj.mouse.clickE()) {
                ocupaCasa( casas[i] );
            }
        }
    }

    public void ocupaCasa(Casinha casinha){
        if (vezDoJogador1) {
            casinha.ocupaPlayer1();
            vezDoJogador1 = false;
        } else {
            casinha.ocupaPlayer2();
            vezDoJogador1 = true;
        }
    }

    public void verificaVitoria(){
        //Vitória 1a Linha Horizontal
        if(casas[0].estaOcupadaPlayer1() && casas[1].estaOcupadaPlayer1() && casas[2].estaOcupadaPlayer1()){
            vitoriaPlayer1();
        }

        if(casas[0].estaOcupadaPlayer2() && casas[1].estaOcupadaPlayer2() && casas[2].estaOcupadaPlayer2()){
            vitoriaPlayer2();
        }

        //Vitória 2a Linha Horizontal
        if(casas[3].estaOcupadaPlayer1() && casas[4].estaOcupadaPlayer1() && casas[5].estaOcupadaPlayer1()){
            vitoriaPlayer1();
        }

        if(casas[3].estaOcupadaPlayer2() && casas[4].estaOcupadaPlayer2() && casas[5].estaOcupadaPlayer2()){
            vitoriaPlayer2();
        }
    }

    public void vitoriaPlayer1(){
        Alj.tela.exibeMensagem("Parabéns Jogador 1. Você venceu.");
        Alj.tela.finaliza();
    }

    public void vitoriaPlayer2(){
        Alj.tela.exibeMensagem("Parabéns Jogador 2. Você venceu.");
        Alj.tela.finaliza();
    }

    public void desenha() {

        Alj.cor.nome("preto");
        Alj.desenha.retangulo(0, 0, 300, 40);

        Alj.desenha.linha(100, 40, 100, 340);
        Alj.desenha.linha(200, 40, 200, 340);
        Alj.desenha.linha(0, 140, 300, 140);
        Alj.desenha.linha(0, 240, 300, 240);

        Alj.cor.nome("branco");
        if (vezDoJogador1) {
            Alj.desenha.texto(20, 25, "Vez do Jogador 1", 14);
        } else {
            Alj.desenha.texto(20, 25, "Vez do Jogador 2", 14);
        }

        for (int i = 0; i < 9; i++) {
            casas[i].desenha();
        }

    }
}
