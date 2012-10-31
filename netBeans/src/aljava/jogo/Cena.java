/*
 * Cena
 */

package aljava.jogo;

import aljava.Alj;
import aljava.midia.Imagem;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Point;
import java.awt.Toolkit;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * @author VisionLab/PUC-Rio
 */
public class Cena
{
 //   private Image backDrop;
    private HashMap<Integer, Imagem> tiles;
    private ArrayList tileLayer;
    
    private int drawStartX = 0;
    private int drawStartY = 0;

    private int larguraTile = 32;
    private int alturaTile = 32;

    public Cena(String arquivoCena){
        try {

            tiles = new HashMap<Integer, Imagem>();
            carregaMapa(arquivoCena);

        } catch (InterruptedException ex) {
            Logger.getLogger(Cena.class.getName()).log(Level.SEVERE, null, ex);
        } catch (FileNotFoundException ex) {
            Logger.getLogger(Cena.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(Cena.class.getName()).log(Level.SEVERE, null, ex);
        } catch (Exception ex) {
            Logger.getLogger(Cena.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void configTile(int id, String img){
        tiles.put(id, new Imagem(img));
    }

    public void configTile(int id, Imagem img){
        tiles.put(id, img);
    }

    public void tamanhoTiles(int largura, int altura){
        Set<Integer> keys = tiles.keySet();
        Imagem img;
        alturaTile = altura;
        larguraTile = largura;
        for(int key: keys){ 
            img = tiles.get(key);
            img.alteraLargura( largura - img.pegaLargura());
            img.alteraAltura( altura - img.pegaLargura());
        }
    }

    private void carregaMapa(String sceneFile) throws InterruptedException, FileNotFoundException, IOException, Exception {
        tileLayer = new ArrayList();

        BufferedReader input = new BufferedReader(new FileReader(new File(sceneFile)));

        //first read the number of tile images
        String line = input.readLine();
        while(line != null && !line.equals(""))
        {
            ArrayList tileLine = new ArrayList();
            String[] tileIndices = line.split(",");

            for(int i = 0 ; i < tileIndices.length ; i++){
                tileLine.add(Integer.parseInt(tileIndices[i]));
            }

            tileLayer.add(tileLine);
            line = input.readLine();
        }
    } 

    public void moveHorizontal(int valor){
        drawStartX += valor;
    }
    
    public void setDrawStartPos(int drawStartX, int drawStartY)
    {
        this.drawStartX = drawStartX;
        this.drawStartY = drawStartY;
    }

    public void desenha(int x, int y)
    {  
        Alj.cor.objeto(Color.BLACK);

        //first draw the backdrop
        int startDrawX = x + drawStartX + Alj.avancado.getCanvas().getStartX();
        int startDrawY = y + drawStartY + Alj.avancado.getCanvas().getStartY();

        int line = 0;
        int drawY = startDrawY;

        do {
            ArrayList tileLine = (ArrayList)tileLayer.get(line);
            int drawX = startDrawX;
            Imagem img;
            for(int c = 0 ; c < tileLine.size() ; c++) {
                int idx = (Integer)tileLine.get(c);

                if(idx != 0){
                    img = tiles.get(idx);
                    img.desenha(drawX, drawY);
                }

                drawX += larguraTile;
            }

            drawY += alturaTile;
            line++;
        
        }while(line < tileLayer.size());
 
    }
/*
    public ArrayList<TileInfo> getTilesFromRect(Point min, Point max)
    {
        ArrayList<TileInfo> v = new ArrayList<TileInfo>();

       
        int startDrawX = drawStartX;
        int startDrawY =  drawStartY;

        int line = 0;
        int drawY = startDrawY;

        do
        {
            ArrayList tileLine = (ArrayList)tileLayer.get(line);

            int drawX = startDrawX;

            for(int c = 0 ; c < tileLine.size() ; c++, drawX += larguraTile)
            {
                TileInfo tile = new TileInfo();

                tile.id = (Integer)tileLine.get(c);
                tile.min.x = drawX ;
                tile.min.y = drawY ;
                tile.max.x = drawX + larguraTile-1;
                tile.max.y = drawY + alturaTile-1;

                if((min.x > tile.max.x) || (max.x < tile.min.x))  {
                    continue;
                }
                if((min.y > tile.max.y) || (max.y < tile.min.y)) {
                    continue;
                }
                
                v.add(tile);
            }

            drawY += alturaTile;
            line++;

        }while(line < tileLayer.size());

        return v;
    }
 *
 * */
}
