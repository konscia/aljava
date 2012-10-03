package aljava;

import java.awt.Color;
import java.awt.Polygon;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.io.IOException;
import java.awt.GraphicsConfiguration;
import java.awt.GraphicsDevice;
import java.awt.GraphicsEnvironment;
import java.awt.Image;
import java.util.*;

import java.awt.event.KeyEvent;

import java.awt.image.BufferedImage;
import java.io.File;
import javax.imageio.ImageIO;
import javax.swing.JOptionPane;
import javax.swing.SwingUtilities;

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
public class Aljava
{
    private Canvas canvas;
    private Mouse mouse;
    private Keyboard keyboard;
    
    private Color cor;
    private int transparencia = 0;
    
    private int rotacionaXCentral = 0;
    private int rotacionaYCentral = 0;
    private int rotacionaAngulo = 0;
    
    /** Inicialização **/
    
    public Aljava() {
        this(300,300);
    }
    
    public Aljava(int width, int height)
    {
        super();
        initSafe(width, height);
    }
    
    public void initSafe(final int width, final int height){
        try {
            //http://javarevisited.blogspot.com.br/2011/09/invokeandwait-invokelater-swing-example.html
            //http://docs.oracle.com/javase/tutorial/uiswing/concurrency/initial.html
            SwingUtilities.invokeAndWait(new Runnable() {

                public void run() {
                    init(width, height);
                }
            });
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
    /**
     * Construtor
     */
    public void init(int width, int height) 
    {
        GraphicsEnvironment graphEnv = GraphicsEnvironment.getLocalGraphicsEnvironment();
        GraphicsDevice graphDevice = graphEnv.getDefaultScreenDevice();
        GraphicsConfiguration graphicConf = graphDevice.getDefaultConfiguration();

        canvas = new Canvas(graphicConf, width, height);

        mouse = new Mouse();
        keyboard = new Keyboard();

        canvas.addMouseListener(mouse);
        canvas.addMouseMotionListener(mouse);
        canvas.addKeyListener(keyboard);
        
        cor = Color.black;
        
        limpaTela();
        mostraTela();
    }
    
    /************************/
    /** Métodos de Desenho **/
    /************************/
   
    private void antesDeDesenhar(Graphics2D g2d){
      g2d.setColor(cor);
      execRotate(g2d);
    }
    
    private void depoisDeDesenhar(Graphics2D g2d){
      eraseRotate(g2d);
    }
    
    public void desenhaLinha(int xInicial, int yInicial, int xFinal, int yFinal){   
        xInicial = canvas.getStartX() + xInicial;
        yInicial = canvas.getStartY() + yInicial;
        xFinal = canvas.getStartX() + xFinal;
        yFinal = canvas.getStartY() + yFinal;
        
        Graphics2D g2d = canvas.getGameGraphics();
        antesDeDesenhar(g2d);
        
        g2d.drawLine(xInicial, yInicial, xFinal, yFinal);
        
        depoisDeDesenhar(g2d);
    }
    
    public void desenhaCirculo(int x, int y, int largura, int altura){  
        x = canvas.getStartX() + x;
        y = canvas.getStartY() + y;
        Graphics g = canvas.getGameGraphics();
        Graphics2D g2d = (Graphics2D)g;
        execRotate(g2d);
        g.setColor(cor);
        g.fillOval(x, y, largura, altura);
        eraseRotate(g2d);
    }
    
    public void desenhaRetangulo(int x, int y, int largura, int altura){   
        x = canvas.getStartX() + x;
        y = canvas.getStartY() + y;
        Graphics g = canvas.getGameGraphics();
        Graphics2D g2d = (Graphics2D)g;
        execRotate(g2d);
        g2d.setColor(cor);
        g2d.fillRect(x, y, largura, altura);
        eraseRotate(g2d);
    }
    
    public void desenhaTriangulo(int x, int y, int largura, int altura){  
        x = canvas.getStartX() + x;
        y = canvas.getStartY() + y;
        Polygon triangulo = new Polygon();
        triangulo.addPoint(x, y+altura);
        triangulo.addPoint(x+largura, y+altura);
        triangulo.addPoint(x+(largura/2), y);
        triangulo.addPoint(x, y+altura);
        desenhaPoligono(triangulo);
    }
    
    public void desenhaPoligono(Polygon poligono){   
        Graphics g = canvas.getGameGraphics();
        Graphics2D g2d = (Graphics2D)g;
        execRotate(g2d);
        g2d.setColor(cor);
        g2d.fillPolygon(poligono);
        eraseRotate(g2d);
    }
    
    public void desenhaTexto(int x, int y, String texto, int tamanhoFonte){  
        x = canvas.getStartX() + x;
        y = canvas.getStartY() + y;
        
        Graphics g = canvas.getGameGraphics();
        Graphics2D g2d = (Graphics2D)g;
        g2d.setColor(cor);
        
        Font f = new Font("Helvetica", Font.PLAIN, tamanhoFonte);       
        g2d.setFont(f);
        execRotate(g2d);
        g2d.drawString(texto, x, y);
        eraseRotate(g2d);
    }
    
    public void desenhaImagem(int x, int y, String imgFileName) {
      try {

        BufferedImage image = ImageIO.read(new File(imgFileName));
        x = canvas.getStartX() + x;
        y = canvas.getStartY() + y;

        Graphics2D g2d = canvas.getGameGraphics();        
        antesDeDesenhar(g2d);
        g2d.drawImage(image, x, y, null); 
        depoisDeDesenhar(g2d);

      } catch (IOException ex) {
        System.err.println("Erro na carga da imagem \""+imgFileName+"\". Verifique se o caminho informado está correto.");
        System.exit(0);
      }
    }

    public void desenhaImagem(int x, int y, Image image) {
        x = canvas.getStartX() + x;
        y = canvas.getStartY() + y;

        Graphics2D g2d = canvas.getGameGraphics();
        antesDeDesenhar(g2d);
        g2d.drawImage(image, x, y, null);
        depoisDeDesenhar(g2d);
    }
    
    public void rotaciona(int angulo, int xCentral, int yCentral){ 
        this.rotacionaAngulo = angulo;
        this.rotacionaXCentral = canvas.getStartX()+xCentral;
        this.rotacionaYCentral = canvas.getStartY()+yCentral;
    }    
    
    private void execRotate(Graphics2D g2d){
        g2d.rotate(Math.toRadians(this.rotacionaAngulo), this.rotacionaXCentral, this.rotacionaYCentral);
    }
     
    private void eraseRotate(Graphics2D g2d){
        g2d.rotate(-Math.toRadians(this.rotacionaAngulo), this.rotacionaXCentral, this.rotacionaYCentral);
    }
    
    /**********************/
    /** Métodos do Mouse **/
    /**********************/
    
    public boolean mouseBotaoEsquerdoEstaPressionado(){        
        return mouse.isLeftButtonPressed();
    }
    
    public boolean mouseBotaoDireitoEstaPressionado(){
        return mouse.isRightButtonPressed();
    }
    
    public int mousePegaPosicaoClickX(){
        return (int)(mouse.getMousePos().getX()-canvas.getStartX());
    }
    
    public int mousePegaPosicaoClickY(){
        return (int)(mouse.getMousePos().getY()-canvas.getStartY());
    }
    
    /*************/
    /** keyboard **/
    /*************/
    
    public boolean teclaEstaPressionada(String tecla){
        int keyCode = 0;
        if(tecla.equals("enter")){
            keyCode = KeyEvent.VK_ENTER;
        } else if(tecla.equals("espaco")){
            keyCode = KeyEvent.VK_SPACE;
        } else if(tecla.equals("esquerda")){
            keyCode = KeyEvent.VK_LEFT;
        } else if(tecla.equals("direita")){
            keyCode = KeyEvent.VK_RIGHT;
        } else if(tecla.equals("cima")){
            keyCode = KeyEvent.VK_UP;
        } else if(tecla.equals("baixo")){
            keyCode = KeyEvent.VK_DOWN;
        } else if(tecla.equals("a")){
            keyCode = KeyEvent.VK_A;
        } else if(tecla.equals("s")){
            keyCode = KeyEvent.VK_S;
        } else if(tecla.equals("d")){
            keyCode = KeyEvent.VK_D;
        } else if(tecla.equals("w")){
            keyCode = KeyEvent.VK_W;
        } else if(tecla.equals("p")){
            keyCode = KeyEvent.VK_P;
        } else if(tecla.equals("x")){
            keyCode = KeyEvent.VK_X;
        } else if(tecla.equals("z")){
            keyCode = KeyEvent.VK_Z;
        }else {
            System.err.println("Tecla: \""+tecla+"\" nao reconhecida. as teclas permitidas sao:");
            System.err.println("\"enter\", \"espaco\", \"esquerda\", \"direita\", \"cima\" e \"baixo\"");
            System.err.println("\"w\", \"a\", \"s\", \"d\", \"z\", \"x\", \"p\"");
            return false;
        }
        return keyboard.keyDown(keyCode);
    }
    
    public boolean teclaEstaPressionada(int code){
      return keyboard.keyDown(code);              
    }
    
    /**************************************/
    /** Métodos aplicados sobre as Cores **/
    /**************************************/
    
    /**
     * Altera a cor do desenho.
     * As cores disponíveis são: 
     * "vermelho", "laranja", "ciano", "preto", "azul", "amarelo", "verde", "magenta" e "branco".
     */
    public void cor(String colorString){
        if(colorString.equals("vermelho")) {
            cor = Color.red;
        }else if(colorString.equals("laranja")) {
            cor = Color.orange;
        }else if(colorString.equals("ciano")) {
            cor = Color.cyan;
        }else if(colorString.equals("preto")) {
            cor = Color.black;
        }else if(colorString.equals("azul")) {
            cor = Color.blue;
        }else if(colorString.equals("amarelo")) {
            cor = Color.yellow;
        }else if(colorString.equals("verde")) {
            cor = Color.green;
        }else if(colorString.equals("magenta")) {
            cor = Color.magenta;
        }else if(colorString.equals("branco")) {
            cor = Color.white;
        }else {
            cor = Color.black;
        }
        corTransparencia(transparencia);
    }  
    
    public void corRGB(int r, int g, int b){
        cor = new Color(r, g, b);
        corTransparencia(transparencia);
    }
    
    public void corObject(Color novaCor){
        cor = novaCor;
        corTransparencia(transparencia);
    }
    
    
    /**
     * Altera a transparência da cor.
     * Deve ser um valor entre 0 (opaco) e 100 (transparente)
     */
    public void corTransparencia(int porcentagem){
        if(porcentagem > 100){
            porcentagem = 100;
        }
        if(porcentagem < 0){
            porcentagem = 0;
        }
        
        int rgbalpha;
        if(porcentagem == 0){
            rgbalpha = 255; //OPACO, sem transparência
        } else {
            double percent = porcentagem / 100.00;
            double alpha = percent * 255.00; 
            rgbalpha = (int)(255 - alpha); //inverte pois quanto maior a porcentagem, menor o alpha
        }        
        Color novaCor = new Color(cor.getRed(), cor.getGreen(), cor.getBlue(), rgbalpha);
        cor = novaCor;
        transparencia = porcentagem;
    }
    
    /************************/
    /** Métodos Auxiliares **/
    /************************/
    
    public void limpaTela(){
        int x = canvas.getStartX();
        int y = canvas.getStartY();
        Graphics g = canvas.getGameGraphics();
        g.setColor(Color.white);
        g.fillRect(x, y, canvas.getLargura(), canvas.getAltura());
    }
    
    /**
     * Em programação, existem questões técnicas que diferem do mundo real.
     * Para desenhar são usadas duas canvass, 
     * isso serve para evitar um erro que ocorre da canvas ficar piscando 
     * quando desenhamos vários objetos.
     * 
     * Uma das canvass é exibida enquanto os desenhos sãso feitos na outra.
     * Quando este método é executado, os desenhos feitos são exibidos e 
     * a canvas que estapa sendo visualizada fica aguardando novos desenhos.
     */
    public void mostraTela(){    
        canvas.swapBuffers();
    }
    
    public void alteraTamanho(int largura, int altura){
      canvas.tamanho(largura, altura);
    }
    
    public int sorteiaNumero(int min, int max){
        Random sorteador = new Random();
        return min + sorteador.nextInt(max);
    }
    
    public double sorteiaNumero(double min, double max){
        Random sorteador = new Random();
        return min + (sorteador.nextDouble()*max);
    }
    
    /**
     * Para a execução do programa por um determinado tempo.
     * @param  milisegundos o tempo de pausa Ex: 1000 equivale a um segundo
     */
    public void espera(int milisegundos)
    {
        try{
            Thread.sleep(milisegundos);
        } 
        catch (Exception e){
            // exceção ignorada por enquanto
        }
    }

    void finaliza() {
        System.exit(0);
    }

    void exibeMensagem(String msg) {
        JOptionPane.showMessageDialog(canvas, msg);
    }

    String solicitaTexto(String msg) {
        return JOptionPane.showInputDialog(canvas, msg);
    }

    int solicitaNumero(String msg) {
        String resposta = JOptionPane.showInputDialog(canvas, msg);
        try{
            int numero = Integer.parseInt(resposta);
            return numero;
        } catch(NumberFormatException e){
            exibeMensagem("Por favor, informe um número.");
            return solicitaNumero(msg);
        }
    }

    double solicitaNumeroDouble(String msg) {
        String resposta = JOptionPane.showInputDialog(canvas, msg);
        try{
            double numero = Double.parseDouble(resposta);
            return numero;
        } catch(NumberFormatException e){
            exibeMensagem("Por favor, informe um número. Use ponto para separar as casas decimais.");
            return solicitaNumeroDouble(msg);
        }
    }
    
   









    
}
