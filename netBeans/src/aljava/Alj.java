package aljava;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Polygon;
import java.awt.image.BufferedImage;


/**
 * Esta classe contém diversos métodos para auxiliar
 * o desenvolvimento inicial de jogos 2D.
 * 
 * Esta classe tem fins unicamente didáticos,
 * não sendo adequada para projetos finais pois
 * agrega uma grande quantidade de responsabilidades.
 * 
 * Em um projeto real as classes internas deverão ser 
 * desacopladas.
 * 
 * @author Kaléu Caminha <kaleu.caminha@gmail.com>
 * 
 * Obs: O nome aljava se refere ao instrumento no qual
 *      os arqueiros guardam as suas flechas.
 *      
 *      A idéia é que esta classe e o respectivo framework sejam
 *      um conjunto de flechas que podem ser usadas em diversas situações
 *      de uma batalha, para diversão ou desenvolvimento pessoal.
 *      
 * Obs2: As classes privadas auxiliares são baseadas no framework javaPlay criado por @author VisionLab/PUC-Rio
 */
public class Alj
{
    private static Aljava alj = new Aljava(400, 400);       

    public static class transforma {
      
      public static void rotaciona(int angulo, int xCentral, int yCentral){
        alj.rotaciona(angulo, xCentral, yCentral);
      }

      public static void limpaRotacao(){
        alj.rotaciona(0, 0, 0);
      }
      
    }
          
      
    public static class cor {
      
      public static void rgb(int r, int g, int b){   
        alj.corRGB(r,g,b);
      }
      
      public static void nome(String cor){   
        alj.cor(cor);
      }
      
      public static void hexadecimal(String hexadecimal){
        Color cor = new Color(
            Integer.valueOf( hexadecimal.substring( 1, 3 ), 16 ),
            Integer.valueOf( hexadecimal.substring( 3, 5 ), 16 ),
            Integer.valueOf( hexadecimal.substring( 5, 7 ), 16 ) );
        alj.corObject(cor);
      }
      
      public static void objeto(Color cor){
        alj.corObject(cor);
      }
      
      public static void transparencia(int porcentagem){
        alj.corTransparencia(porcentagem);
      }
      
    }
    
    /**
     * Namespace contendo os métodos que desenham recursos na tela
     */
    public static class desenha {   
      
      public static void linha(int xInicial, int yInicial, int xFinal, int yFinal){   
        alj.desenhaLinha(xInicial, yInicial, xFinal, yFinal);
      }
      
      public static void retangulo(int x, int y, int largura, int altura){   
        alj.desenhaRetangulo(x, y, largura, altura);
      }
      
      public static void triangulo(int x, int y, int largura, int altura){   
        alj.desenhaTriangulo(x, y, largura, altura);
      }
      
      public static void oval(int x, int y, int largura, int altura){   
        alj.desenhaCirculo(x, y, largura, altura);
      }
      
      public static void poligono(Polygon p){   
        alj.desenhaPoligono(p);
      }
      
      public static void poligono(int x[], int y[]){   
        Polygon p = new Polygon(x, y, x.length);
        alj.desenhaPoligono(p);
      }
      
      public static void texto(int x, int y, String texto){
        int fonte = 12;
        alj.desenhaTexto(x, y, texto, fonte);
      }
      
      public static void texto(int x, int y, String texto, int tamanhoFonte){        
        alj.desenhaTexto(x, y, texto, tamanhoFonte);
      }      
      
      public static void imagem(int x, int y, String imgFileName){
        alj.desenhaImagem(x, y, imgFileName);
      }
    
    }
    

    public static class tela {
      
      public static void exibe(){
        alj.mostraTela();
      }

      public static void limpa(){
        alj.limpaTela();
      } 
      
      public static void tamanho(int largura, int altura){
        alj.alteraTamanho(largura, altura);
      }

      public static void finaliza(){
        alj.finaliza();
      }

      public static void exibeMensagem(String msg){
        alj.exibeMensagem(msg);
      }

      public static String solicitaTexto(String msg){
        return alj.solicitaTexto(msg);
      }

      public static int solicitaNumero(String msg){
        return alj.solicitaNumero(msg);
      }
      
      public static double solicitaNumeroDouble(String msg){
        return alj.solicitaNumeroDouble(msg);
      }

      
    }
    
    public static class util {
      
      public static void espera(int milisegundos){
        alj.espera(milisegundos);
      }
      
      public static int sorteia(int min, int max){
        return alj.sorteiaNumero(min, max);
      }
      
      public static double sorteia(double min, double max){
        return alj.sorteiaNumero(min, max);
      }
    }

    public static class avancado {

      public static Graphics2D getGraphics(){
        return alj.getCanvas().getGameGraphics();
      }

      public static Canvas getCanvas(){
        return alj.getCanvas();
      }

    }

    
    public static class mouse {
      
      public static int x(){
        return alj.mousePegaPosicaoClickX();
      }
      
      public static int y(){
        return alj.mousePegaPosicaoClickY();
      }
      
      public static boolean clickE(){
        return alj.mouseBotaoEsquerdoEstaPressionado();
      }
      
      public static boolean clickD(){
        return alj.mouseBotaoDireitoEstaPressionado();
      }
      
    }
    
    public static class tecla{
      
      /**
       * As teclas que podem ser verificadas pelo texto, são:
         "enter", "espaco", "esquerda", "direita", "cima","baixo"
         "w", "a", "s", "d", "z", "x", "p"
       */
      public static boolean press(String tecla){
        return alj.teclaEstaPressionada(tecla);
      }

      /**
       * Você pode verificar se uma tecla está pressionada pelo código.
       * O código é numérico e existem alguns atalhos em KeyEvent.VK_
       */
      public static boolean press(int tecla){      
        return alj.teclaEstaPressionada(tecla);
      }
    
    }
 
}
