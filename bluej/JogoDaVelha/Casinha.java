import aljava.Alj;

/**
 * Representa uma casinha do jogo da Velha.
 */
class Casinha {

    int x, y, largura, altura;
    //Se o valor for zero, a casa é vazia.
    //Se o valor for 1, a casa é do jogador 1;
    //Se o valor for 2, a casa é do jogador 2;
    int valor;

    Casinha(int x, int y) {
        this.x = x;
        this.y = y;
        this.largura = 99;
        this.altura = 99;
    }

    boolean estaOcupada() {
        return valor > 0;
    }

    boolean estaOcupadaPlayer1() {
        return valor == 1;
    }

    boolean estaOcupadaPlayer2() {
        return valor == 2;
    }

    void ocupaPlayer1() {
        valor = 1;
    }

    void ocupaPlayer2() {
        valor = 2;
    }

    boolean mouseDentro() {
        int xMouse = Alj.mouse.x();
        int yMouse = Alj.mouse.y();

        boolean dentroHorizontal = x < xMouse && xMouse < (x + largura);
        boolean dentroVertical = y < yMouse && yMouse < (y + altura);

        if (dentroHorizontal && dentroVertical) {
            return true;
        } else {
            return false;
        }
    }

    void desenha() {
        if (valor == 0) {
            Alj.cor.nome("branco");
        } else if (valor == 1) {
            Alj.cor.nome("vermelho");
        } else if (valor == 2) {
            Alj.cor.nome("azul");
        }

        Alj.desenha.retangulo(x, y, largura, altura);

        if(valor > 0){
            Alj.desenha.imagem(x+18, y+18, "imagens/x.png");
        }
        
    }
}
