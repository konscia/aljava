package aljava.jogo;

import aljava.Alj;
import java.awt.Point;

public class Camera {

    private Cena cena;
    private Retangulo r;

    private int prevX;
    private int prevY;

    public Camera(Cena cena, Retangulo retangulo){
        this.cena = cena;
        this.r = retangulo;

        prevX = r.pegaX();
        prevY = r.pegaY();
    }


    public void processa(){
        processaHorizontal();
        processaVertical();
    }

    public void processaHorizontal(){
        //Movimento do Personagem
        int movedX = r.pegaX() - prevX;

        int xMin = (int)(Alj.tela.pegaLargura() * 0.3f);
        int xMax = (int)(Alj.tela.pegaLargura() * 0.7f);

        //Se está antes do xMinimo e está andando pra trás,
        //para o retangulo e movimenta apenas o cenário
        if(r.pegaX() < xMin && movedX < 0 && !cena.chegouInicioHorizontal()){
            //Move o cenário para frente, parecendo que o personagem está indo pra trás.
            //Lembrando que se o movimento do personagem é negativo, mudamos para positivo.
            cena.moveHorizontal(-movedX);
            //Para personagem
            r.moveX(-movedX);
            return;
        }


       //Se está depois do xMaximo e está andando pra frente,
        //para o retangulo e movimenta apenas o cenário
        if(r.pegaX() > xMax && movedX > 0 && !cena.chegouFinalHorizontal()){
            //Move o cenário para trás, parecendo que o personagem está indo pra frente.
            //Lembrando que se o movimento do personagem é positivo, mudamos para positivo.
            cena.moveHorizontal(-movedX);
            //Para personagem
            r.moveX(-movedX);
            return;
        }

        //Movimentou...
        prevX = r.pegaX();
    }

    public void processaVertical(){
        //Movimento do Personagem
        int movedY = r.pegaY() - prevY;

        int yMin = (int)(Alj.tela.pegaAltura() * 0.3f);
        int yMax = (int)(Alj.tela.pegaAltura() * 0.7f);

        //Se está antes do xMinimo e está andando pra trás,
        //para o retangulo e movimenta apenas o cenário
        if(r.pegaY() < yMin && movedY < 0 && !cena.chegouTopoVertical()){
            //Move o cenário para frente, parecendo que o personagem está indo pra trás.
            //Lembrando que se o movimento do personagem é negativo, mudamos para positivo.
            cena.moveVertical(-movedY);
            //Para personagem
            r.moveY(-movedY);
            return;
        }


       //Se está depois do xMaximo e está andando pra frente,
        //para o retangulo e movimenta apenas o cenário
        if(r.pegaY() > yMax && movedY > 0 && !cena.chegouBaseVertical()){
            //Move o cenário para trás, parecendo que o personagem está indo pra frente.
            //Lembrando que se o movimento do personagem é positivo, mudamos para positivo.
            cena.moveVertical(-movedY);
            //Para personagem
            r.moveY(-movedY);
            return;
        }

        //Movimentou...
        prevY = r.pegaY();
    }
}
