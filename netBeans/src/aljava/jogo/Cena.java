/*
 * Cena
 */

package aljava.jogo;

import aljava.Alj;
import aljava.midia.Imagem;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Set;

/**
 * @author VisionLab/PUC-Rio
 */
public class Cena
{
 //   private Image backDrop;
    private HashMap<Integer, TipoTile> tiles;
    private ArrayList tileLayer;
    
    private int drawStartX = 0;
    private int drawStartY = 0;

    private int larguraTile = 32;
    private int alturaTile = 32;

    private int numLinhas = 0;
    private int numColunas = 0;

    private ArrayList<Retangulo> objetos;

    public Cena(String arquivoCena){
        objetos = new ArrayList<Retangulo>();
        tiles = new HashMap<Integer, TipoTile>();
        try {
            carregaMapa(arquivoCena);
        } catch (InterruptedException ex) {
            System.out.println(ex);
            System.exit(0);
        } catch (FileNotFoundException ex) {
            System.out.println(ex);
            System.exit(0);
        } catch (IOException ex) {
            System.out.println(ex);
            System.exit(0);
        } catch (Exception ex) {
            System.out.println(ex);
            System.exit(0);
        }
    }

    private void carregaMapa(String sceneFile) throws InterruptedException, FileNotFoundException, IOException, Exception {
        tileLayer = new ArrayList();

        BufferedReader input = new BufferedReader(new FileReader(new File(sceneFile)));

        //first read the number of tile images
        String line = input.readLine();
        while(line != null && !line.equals(""))
        {
            numLinhas++;
            ArrayList tileLine = new ArrayList();
            String[] tileIndices = line.split(",");

            numColunas = tileIndices.length;
            for(int i = 0 ; i < tileIndices.length ; i++){
                tileLine.add(Integer.parseInt(tileIndices[i]));
            }

            tileLayer.add(tileLine);
            line = input.readLine();
        }
    }

    public void moveComCenario(Retangulo r){
        objetos.add(r);
    }

    public void configTile(int id, String img){
        configTile(id, img, false);
    }
    
    public void configTile(int id, String img, boolean solidez){
        configTile(id, new Imagem(img), solidez);
    }

    public void configTile(int id, Imagem img){
        configTile(id, img, false);
    }

    public void configTile(int id, Imagem img, boolean solidez){
        tiles.put(id, new TipoTile(id, img, solidez));
        tamanhoTile(img);
    }

    

    public void tamanhoTiles(int largura, int altura){
        Set<Integer> keys = tiles.keySet();
        Imagem img;
        alturaTile = altura;
        larguraTile = largura;
        for(int key: keys){ 
            img = tiles.get(key).pegaImagem();
            tamanhoTile(img);
        }
    }

    private void tamanhoTile(Imagem img){
        img.alteraLargura( larguraTile - img.pegaLargura());
        img.alteraAltura( alturaTile - img.pegaAltura());
    }

    public void moveVertical(int valor){
        int valorMovimentoObjetos = valor;
        drawStartY += valor;

        int yMinimo = -((alturaTile * numLinhas) - Alj.avancado.getCanvas().getAltura());
        int yMaximo = 0;

        if(drawStartY < yMinimo){
            drawStartY = yMinimo;
            int diferenca = yMinimo - drawStartY;
            valorMovimentoObjetos = diferenca;
        } else if (drawStartY > yMaximo){
            drawStartY = yMaximo;
            int diferenca = yMaximo - drawStartY;
            valorMovimentoObjetos = diferenca;
        }

        for(Retangulo r : objetos){
            r.moveY(valorMovimentoObjetos);
        }
    }

    public boolean chegouInicioHorizontal(){
        int xMaximo = 0;
        return drawStartX >= xMaximo;
    }

    public boolean chegouFinalHorizontal(){
        int xMinimo = -((larguraTile * numColunas) - Alj.avancado.getCanvas().getLargura());
        return (drawStartX == xMinimo);
    }

    public boolean chegouTopoVertical(){
        int yMaximo = 0;
        return (drawStartY == yMaximo);
    }

    public boolean chegouBaseVertical(){
        int yMinimo = -((alturaTile * numLinhas) - Alj.avancado.getCanvas().getAltura());
        return drawStartY <= yMinimo;
    }
    

    public void moveHorizontal(int valor){
        int valorMovimentoObjetos = valor;
        drawStartX += valor;

        int xMinimo = -((larguraTile * numColunas) - Alj.avancado.getCanvas().getLargura());
        int xMaximo = 0;

        if(drawStartX < xMinimo){
            drawStartX = xMinimo;
            int diferenca = xMinimo - drawStartX;
            valorMovimentoObjetos = diferenca;
        } else if (drawStartX > xMaximo){
            drawStartX = xMaximo;
            int diferenca = xMaximo - drawStartX;
            valorMovimentoObjetos = diferenca;
        }

        for(Retangulo r : objetos){
            r.moveX(valorMovimentoObjetos);
        }
    }
    
    public void setDrawStartPos(int drawStartX, int drawStartY)
    {
        this.drawStartX = drawStartX;
        this.drawStartY = drawStartY;
    }

    public void desenha()
    {  
        int startDrawX = drawStartX;
        int startDrawY = drawStartY;

        int line = 0;
        int drawY = startDrawY;

        do {
            ArrayList tileLine = (ArrayList)tileLayer.get(line);
            int drawX = startDrawX;
            Imagem img;
            for(int c = 0 ; c < tileLine.size() ; c++) {
                int idx = (Integer)tileLine.get(c);

                if(idx != 0){
                    if(tiles.get(idx) == null){
                        System.err.println("Tile "+idx+" não foi associado a nenhuma imagem.");
                        System.exit(0);
                    }

                    img = tiles.get(idx).pegaImagem();

                    img.desenha(drawX, drawY);
                }

                drawX += larguraTile;
            }

            drawY += alturaTile;
            line++;
        
        }while(line < tileLayer.size());
 
    }

    public ArrayList<Tile> pegaTilesComColisao(Retangulo retangulo)
    {
        ArrayList<Tile> v = new ArrayList<Tile>();
    
        int startDrawX = drawStartX;
        int startDrawY = drawStartY;

        //Pega de baixo pra cima
        int line = tileLayer.size()-1;
        int drawY = startDrawY + (line*alturaTile);

        do
        {
            ArrayList tileLine = (ArrayList)tileLayer.get(line);
            int drawX = startDrawX;

            for(int c = 0 ; c < tileLine.size() ; c++, drawX += larguraTile)
            {
                int idTile = (Integer)tileLine.get(c);
                if(idTile == 0){
                    continue;
                }
                
                Tile tile = new Tile(drawX, drawY, larguraTile, alturaTile, tiles.get(idTile));

                if((tile.toca(retangulo)))  {
                    v.add(tile);
                }
            }

            drawY -= alturaTile;
            line--;

        }while(line >= 0);

        return v;
    }

}
