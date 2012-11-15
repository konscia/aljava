package aljava;

import aljava.saida.Tela;
import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Polygon;


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
    private static Aljava alj;

    public static void inicializa(int largura, int altura){
        if(alj != null){
          alj.getCanvas().setVisible(false);
        }
        
        alj = new Aljava(largura, altura);
        //Pausa para carregar a interface gráfica.
        Alj.util.espera(500);
    }

    /**
     * Pacote responsável por transformações gerais no desenho como aplicação de escala e rotação.
     */
    public static class transforma {
      
      public static void rotaciona(int angulo, int xCentral, int yCentral){
        Alj.avancado.getInstance().rotaciona(angulo, xCentral, yCentral);
      }

      public static void limpaRotacao(){
        Alj.avancado.getInstance().rotaciona(0, 0, 0);
      }
      
    }
          
      
    public static class cor {
      
      public static void rgb(int r, int g, int b){   
        Alj.avancado.getInstance().corRGB(r,g,b);
      }
      
      public static void nome(String cor){   
        Alj.avancado.getInstance().cor(cor);
      }
      
      public static void hexadecimal(String hexadecimal){
        Color cor = new Color(
            Integer.valueOf( hexadecimal.substring( 1, 3 ), 16 ),
            Integer.valueOf( hexadecimal.substring( 3, 5 ), 16 ),
            Integer.valueOf( hexadecimal.substring( 5, 7 ), 16 ) );
        Alj.avancado.getInstance().corObject(cor);
      }
      
      public static void objeto(Color cor){
        Alj.avancado.getInstance().corObject(cor);
      }
      
      public static void transparencia(int porcentagem){
        Alj.avancado.getInstance().corTransparencia(porcentagem);
      }
      
    }
    
    /**
     * Namespace contendo os métodos que desenham recursos na tela
     */
    public static class desenha {   
      
      public static void linha(int xInicial, int yInicial, int xFinal, int yFinal){   
        Alj.avancado.getInstance().desenhaLinha(xInicial, yInicial, xFinal, yFinal);
      }
      
      public static void retangulo(int x, int y, int largura, int altura){   
        Alj.avancado.getInstance().desenhaRetangulo(x, y, largura, altura);
      }

      public static void retanguloBorda(int x, int y, int largura, int altura){
        Alj.avancado.getInstance().desenhaRetanguloBorda(x, y, largura, altura);
      }
      
      public static void triangulo(int x, int y, int largura, int altura){   
        Alj.avancado.getInstance().desenhaTriangulo(x, y, largura, altura);
      }
      
      public static void oval(int x, int y, int largura, int altura){   
        Alj.avancado.getInstance().desenhaCirculo(x, y, largura, altura);
      }
      
      public static void poligono(Polygon p){   
        Alj.avancado.getInstance().desenhaPoligono(p);
      }
      
      public static void poligono(int x[], int y[]){   
        Polygon p = new Polygon(x, y, x.length);
        Alj.avancado.getInstance().desenhaPoligono(p);
      }
      
      public static void texto(int x, int y, String texto){
        int fonte = 12;
        Alj.avancado.getInstance().desenhaTexto(x, y, texto, fonte);
      }
      
      public static void texto(int x, int y, String texto, int tamanhoFonte){        
        Alj.avancado.getInstance().desenhaTexto(x, y, texto, tamanhoFonte);
      }      
      
      public static void imagem(int x, int y, String imgFileName){
        Alj.avancado.getInstance().desenhaImagem(x, y, imgFileName);
      }
    
    }
    

    public static class tela {
      
      public static void exibe(){
        Alj.avancado.getInstance().mostraTela();
      }

      public static void limpa(){
        Alj.avancado.getInstance().limpaTela();
      } 
      
      public static void tamanho(int largura, int altura){
        Alj.tela.exibeMensagem("O método tela.tamanho foi depreciado. Para redimensionar a janela use Alj.inicializa(int largura, int altura)");
      }

      public static int pegaAltura(){
          return Alj.avancado.getCanvas().getAltura();
      }

      public static int pegaLargura(){
          return Alj.avancado.getCanvas().getLargura();
      }

      public static void finaliza(){
        Alj.avancado.getInstance().finaliza();
      }

      public static void exibeMensagem(String msg){
        Alj.avancado.getInstance().exibeMensagem(msg);
      }

      public static String solicitaTexto(String msg){
        return Alj.avancado.getInstance().solicitaTexto(msg);
      }

      public static int solicitaNumero(String msg){
        return Alj.avancado.getInstance().solicitaNumero(msg);
      }
      
      public static double solicitaNumeroDouble(String msg){
        return Alj.avancado.getInstance().solicitaNumeroDouble(msg);
      }

      
    }
    
    public static class util {
      
      public static void espera(int milisegundos){
        Alj.avancado.getInstance().espera(milisegundos);
      }
      
      public static int sorteia(int min, int max){
        return Alj.avancado.getInstance().sorteiaNumero(min, max);
      }
      
      public static double sorteia(double min, double max){
        return Alj.avancado.getInstance().sorteiaNumero(min, max);
      }
    }

    public static class avancado {

      public static Graphics2D getGraphics(){
        return Alj.avancado.getInstance().getCanvas().getGraphics();
      }

      public static Tela getCanvas(){
        return Alj.avancado.getInstance().getCanvas();
      }

      public static Aljava getInstance(){
        if(alj == null) {
            Alj.inicializa(400, 400);
        }

        return alj;
      }

    }

    
    public static class mouse {
      
      public static int x(){
        return Alj.avancado.getInstance().mousePegaPosicaoClickX();
      }
      
      public static int y(){
        return Alj.avancado.getInstance().mousePegaPosicaoClickY();
      }
      
      public static boolean clickE(){
        return Alj.avancado.getInstance().mouseBotaoEsquerdoEstaPressionado();
      }

      public static boolean clickM(){
        return Alj.avancado.getInstance().mouseBotaoMeioEstaPressionado();
      }

      public static boolean clickD(){
        return Alj.avancado.getInstance().mouseBotaoDireitoEstaPressionado();
      }
      
    }
    
    public static class tecla{
      
      /**
       * As teclas que podem ser verificadas pelo texto, são:
         "enter", "espaco", "esquerda", "direita", "cima","baixo"
         "w", "a", "s", "d", "z", "x", "p"
       */
      public static boolean press(String tecla){
        return Alj.avancado.getInstance().teclaEstaPressionada(tecla);
      }

      /**
       * Você pode verificar se uma tecla está pressionada pelo código.
       * O código é numérico e existem alguns atalhos em KeyEvent.VK_
       */
      public static boolean press(int tecla){      
        return Alj.avancado.getInstance().teclaEstaPressionada(tecla);
      }
    
    }
 
}
