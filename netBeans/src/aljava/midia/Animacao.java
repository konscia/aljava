package aljava.midia;

import java.util.LinkedList;
import aljava.util.ContadorTempo;

/**
 * Uma animação consiste em uma sequencia de imagens executadas com um intervalo de tempo definido pelo usuário.
 */
public class Animacao {

    protected LinkedList<Imagem> imagens;
    protected ContadorTempo contador;
    protected int imagemAtual;
    protected boolean emExecucao;
    protected boolean emLoop;

    public Animacao(int intervalo){
        contador = new ContadorTempo(intervalo);
        imagens = new LinkedList<Imagem>();
        imagemAtual = 0;
        emExecucao = false;
        emLoop = false;
    }

    public void addImagem(String caminhoImagem){
        addImagem(new Imagem(caminhoImagem));
    }

    public void addImagem(Imagem novaImagem){
        imagens.add(novaImagem);
    }

     /** Transformacao das Imagems **/

    public void inverte(){
        for(Imagem i : imagens){
            i.inverte();
        }
    }

    public void alteraLargura(int valor){
        for(Imagem i : imagens){
            i.alteraLargura(valor);
        }
    }

    public void alteraAltura(int valor){
        for(Imagem i : imagens){
            i.alteraAltura(valor);
        }
    }

     /** Controle da Animação **/

    public void inicia(){
        emExecucao = true;
        imagemAtual = 0;
    }

    public void iniciaEmLoop(){
        inicia();
        emLoop = true;
    }

    public void para(){
        emExecucao = false;
        emLoop = false;
    }

    public boolean temProximaImagem(){
        return ( (imagens.size()-1) > imagemAtual);
    }

    /**
     * Executa processo de troca das imagens da animação.
     * Deve ser executado a cada rodada do jogo.
     */
    public void processa(){
        if(!emExecucao){
            return;
        }

        //Se o contador não terminou, ainda não é hora de passar para a próxima imagem
        if(!contador.terminou()){
            return;
        } else {
            //Se já terminou, aproveita para reiniciá-lo.
            contador.reinicia();
        }
        
        if(temProximaImagem()){
           imagemAtual++;
        } else {
           if(emLoop){
               imagemAtual = 0;
           } else {
               para();
           }
        }
    }

    /** Desenho **/

    public void desenha(int x, int y){
        if(emExecucao){
            imagens.get(imagemAtual).desenha(x, y);
        }
    }
}
