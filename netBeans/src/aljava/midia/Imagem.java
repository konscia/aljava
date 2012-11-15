package aljava.midia;

import aljava.Alj;
import java.awt.Image;
import java.awt.Toolkit;
import aljava.util.CarregadorMidia;

public class Imagem {
    protected Image image;
    protected Image originalImage;
    protected boolean invertida = false;
    protected int largura;
    protected int altura;

    public Imagem(String filename) {
        image = Toolkit.getDefaultToolkit().getImage(filename);
        CarregadorMidia.instancia().esperaCarregar(image);
        if(image.getWidth(null) == -1){
            System.err.println("A imagem \""+filename+"\" não foi enocntrada.");
            System.exit(0);
        }
        originalImage = image;
    }

	public int pegaLargura() {
		return image.getWidth(null);
	}

    public void alteraLargura(int valor) {
        int novaLargura = pegaLargura() + valor;
        int novaAltura = pegaAltura();
		alteraTamanho(novaLargura, novaAltura);
	}

	public int pegaAltura() {
		return image.getHeight(null);
	}

    public void alteraAltura(int valor) {
        int novaLargura = pegaLargura();
        int novaAltura = pegaAltura() + valor;
		alteraTamanho(novaLargura, novaAltura);
	}

    public void inverte(){
        this.invertida = !this.invertida;
    }

    protected void alteraTamanho(int largura, int altura){
        if(largura <= 0){
            largura = 1;
        }

        if(altura <= 0){
            altura = 1;
        }
        image = originalImage.getScaledInstance(largura, altura, Image.SCALE_AREA_AVERAGING);
        CarregadorMidia.instancia().esperaCarregar(image);
    }
    
	public void desenha(int x, int y) {
        x += Alj.avancado.getCanvas().getStartX();
        y += Alj.avancado.getCanvas().getStartY();

        if(this.invertida){
            this.desenhaInvertida(x, y);
        } else {
            Alj.avancado.getGraphics().drawImage(image, x, y, null);
        }
	}

    public void desenhaInvertida(int x, int y) {
        x += Alj.avancado.getCanvas().getStartX();
        y += Alj.avancado.getCanvas().getStartY();
        
		Alj.avancado.getGraphics().drawImage(image, image.getWidth(null) + x, y, x,
				image.getHeight(null) + y, 0, 0, image.getWidth(null),
				image.getHeight(null), null);
	}
}
