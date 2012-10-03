import aljava.Alj;
public class GuerraEspacial
{
    Nave naveJogador1;
    
    GuerraEspacial()
    {
        Alj.tela.tamanho(300, 600);
        
        naveJogador1 = new Nave();
        
        Alj.util.espera(500);
        desenha();
    }

    void loop(){
        while(true){
            if( Alj.tecla.press("a")){
                naveJogador1.moveEsquerda();
            }
            
            if( Alj.tecla.press("d") ) {
                naveJogador1.moveDireita();
            }
            
            if( Alj.tecla.press("w") ) {
                naveJogador1.moveCima();
            }

            if( Alj.tecla.press("s") ) {
                naveJogador1.moveBaixo();
            }
            
            desenha();
        }
    }
    
    void desenha(){
        Alj.cor.rgb(0,0,0); 
        Alj.desenha.retangulo(0,0, 300, 600);
        
        naveJogador1.desenha();
        
        Alj.tela.exibe();
    }
}
