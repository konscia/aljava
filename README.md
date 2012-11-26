Livro de Receitas Aljava 
=====

Aljava é um framework Java desenvolvido para o ensino de Orientação a Obejtos tendo como foco o desenvolvimento de jogos.
O Framework também pode ser usado como uma biblioteca de classes úteis que dentre outras coisas realizam o desenho de formas geométricas, imagens, execução de sons e colisões envolvendo Retângulos.

O framework pode ser dividido nas seguintes seções

* **Desenho, Tela e Utilitáros**: Métodos usados para desenhar formas geométricas utilizando diversas cores, recursos de transparência e colisão, além de métodos para recuperar textos e números informados pelos usuários. Outros métodos utilitários como um sorteador de números também estão disponíveis; 
* **Mídia**: Classes para desenho de imagens, animações e execução de sons;
* **Elementos de Jogo**: Classes para construção de cenários, realização de colisão, tratamento de gravidade;
* **Framework**: Uso das quatro classes responsáveis por transformar o Aljava em um mini Framework para o desenvolvimento de jogos.

## Início

Esta seção descreve questões iniciais básicas para o uso do Aljava nos seus projetos.

### Instalação

Basta adicionar ao seu projeto o arquivo **Aljava.jar** que está disponível [aqui](https://github.com/kaleucaminha/aljava/blob/master/Aljava.jar). Ele tem tudo que é necessário.

### Execução

Para iniciar com a classe Alj basta importá-la e executar alguns dos seus comandos. Ao importar a classe uma janela de 400x400 é criada para o jogo, todos os comandos são baseados nesta janela.

```java
import aljava.Alj;
```

Segue abaixo alguns exemplos de comandos disponíveis na classe Alj.

```java
Alj.desenha.retangulo(0, 0, 400, 400);

Alj.cor.nome("verde");
Alj.desenha.texto(20, 200, "Aljava - Programação é massa.", 16);

Alj.tela.exibe();
```

**Obs:** Para que um desenho efetivamente seja exibido na tela, o método __Alj.tela.exibe()__ deve ser executado.

Além dos comandos da classe "Alj" existem diversas outras classes que podem ser utilizadas conforme documentado nas seções abaixo.

### IDE - Ambiente de Programação

A lib Aljava está em um JAR. Você pode incluí-lo em seu projeto e começar a usá-lo livremente. Qualquer ambiente de programação (Netbeans, Eclipse, JCreator, etc) pode ser utilizado. Para fins didáticos, recomenda-se o BlueJ.

No BlueJ, eventualmente ocorre um erro ao tentar exibir uma janela em função de erros de acesso ao contexto gráfico. Para evitá-los, basta resetar a máquina virtual sempre antes de executar um código novamente.

## Desenho, Tela e Utilitáros

Toda esta seção está disponível através de comandos acessados a partir da classe "Alj". Os comandos estão divididos em grupos conforme descrição abaixo:

**desenho**: Desenho de formas geométricas básicas (retângulos, triângulos, ovais, linhas e polígonos). Também é possível desenhar textos com tamanhos de fonte variados;
**cor**: comandos que alteram a cor que está sendo utilizada para o desenho. A cor pode ser alterada usando valores hexadecimais, RGB ou mesmo através de algumas Strings padronizadas. Também é possível informar o nível de transparência de uma cor;
**transforma**: Comandos que permitem o uso de rotações nas imagens desenhadas;
**tela**: Comandos para solicitar informações ao usuário e demais operações ligadas a janela principal do jogo;
**mouse**: Métodos de acesso ao mouse;
**tecla**: Métodos de acesso ao teclado;
**util**: comandos utilitários como o sorteio de números aleatórios.

### Desenho

Todos os métodos de desenho utilizam a cor que foi definida. Inicialmente a cor definida é preto, para alterá-la, veja a seção "Cores".

#### Linhas
Uma linha representa a ligação entre dois pontos. 
Os parâmetros são o x, y do ponto inicial e o x, y do ponto final.

```java
//assinatura do método
Alj.desenha.linha(int x, int y, int xFinal, int yFinal);

//Linha diagonal na tela
Alj.desenha.linha(0, 0, 400, 400);

//Linha horizontal no meio da tela
Alj.desenha.linha(0, 400, 200, 200);
```

#### Retângulos
Um retângulo inicia com o canto superior esquerdo em uma coordenada x, y e possui uma largura e uma altura.

```java
//assinatura do método
Alj.desenha.retangulo(int x, int y, int largura, int altura);

//Um retângulo de 300 de largura por 100 de altura no ponto 20, 20
Alj.desenha.retangulo(20, 20, 300, 100);
```

#### Borda dos Retângulos
Também é possível desenhar somente o contorno da borda do retângulo. Os parâmetros são os mesmos.

```java
//assinatura do método
Alj.desenha.retanguloBorda(int x, int y, int largura, int altura);

//Um retângulo de 300 de largura por 100 de altura no ponto 20, 20
Alj.desenha.retanguloBorda(20, 20, 300, 100);
```

#### Oval
Uma oval inicia com o canto superior esquerdo em uma coordenada x, y e possui uma largura e uma altura.

```java
//assinatura do método
Alj.desenha.oval(int x, int y, int largura, int altura);

//Uma oval de 300 de largura por 100 de altura no ponto 20, 20
Alj.desenha.oval(20, 20, 300, 100);
```

#### Triangulo
Uma triângulo inicia com o canto superior esquerdo em uma coordenada x, y e possui uma largura e uma altura. Este triângulo sempre tem a ponta para cima. Para construir triângulos de lado ou para baixo, use-o em conjunto com o comando Alj.transforma.rotaciona( ... ) apresentado na seção "Transformações".

```java
//assinatura do método
Alj.desenha.trinagulo(int x, int y, int largura, int altura);

//Uma triângulo de 300 de largura por 100 de altura no ponto 20, 20
Alj.desenha.triangulo(20, 20, 300, 100);
```

#### Polígonos
Você pode desenhar qualquer forma geométrica usando polígonos.
Polígonos são sequencias de pontos. Para desenhar um polígono, basta passar um array de pontos x e um array de pontos y.

```java
//Assinatura do método
//Alj.desenha.poligono(int x[], int y[]);

int xs[] = {100, 200, 300, 150, 100};
int ys[] = {100, 100, 200, 150, 100};
Alj.desenha.poligono(xs, ys);
```

Alternativamente, você pode usar um objeto da classe Polygon.

```java
//não esqueça de importar a classe Polygon para usá-la
//Ex: import java.awt.Polygon;

Polygon pol = new Polygon();
pol.addPoint(100, 100);
pol.addPoint(400, 350);
pol.addPoint(200, 150);
pol.addPoint(100, 100);
Alj.desenha.poligono(pol);
```

#### Textos

Textos podem ser desenhados em qualquer posição X, Y da tela. Alternativamente, você pode informar um quarto parâmetro para o tamanho da fonte. Não é possível mudar a fonte dos textos e a quebra de linha também não é feita pelo método.

```java
//Assinatura do método 
Alj.desenha.texto(int x, int y, String texto);
//ou
Alj.desenha.texto(int x, int y, String texto, int tamanhoFonte);

Alj.desenha.texto(20, 200, "Aljava - Programação que vale o esforço.", 16);
```

### Cores

Todos os desenhos acima podem receber transparência ou uma cor. Você pode mudar a cor de diversas formas, escolha a que preferir.

#### Mudar cor pelo nome
Existem alguns nomes de cores pré-definidos que podem ser usados como uma String. Isso é útil no início do aprendizado de programação, principalmente para os primeiros exercícios.

```java
//Assinatura do método
Alj.cor.nome(String nomeCor);

//Usando a cor vermelha
Alj.cor.nome("vermelho");
```

As cores disponíveis são: "vermelho", "laranja", "ciano", "preto", "azul", "amarelo", "verde", "magenta" e "branco".

#### Mudar cor pelo RGB
Uma cor é formada por uma quantidade de vermelho (R), verde (G) e azul (B). Estes valores variam de 0 (mais escuro) até 255 (mais claro). Este comando tem três parâmetros, um para cada das três cores e é o mais útil para criar pequenas animações com cores.

```java
//Assinatura do método
Alj.cor.rgb(int r, int g, int b)

//Inforando uma cor com alta quantidade de vermelho
Alj.cor.rgb(200, 100, 10);
```

#### Hexadecimal #006699
Desenvolvedores que tenham conhecimento de web e estejam acostumados com o formato hexadecimal, podem usá-lo também. Qualquer cor hexadecimal pode ser informada como uma String.

```java
//Assinatura do método
Alj.cor.hexadecimal(String hexadecimal);

//Exemplo de uma cor tendendo para o verde
Alj.cor.hexadecimal("#336699");
```

#### Objeto Color
Desenvolvedores mais avançados podem usar um objeto da classe Color do Java.

```java
//Assinatura do método
Alj.cor.objeto(Color cor);

//Exemplo da mesma cor informada pelo formato RGB
Alj.cor.objeto( new Color(200,100,10) );
```

#### Alterar a transparência
Outro recurso útil é o uso de transparências. Você pode informar a transparência com uma porcentagem que varia de 0 até 100. Quanto maior o valor, maior a transparência.

```java
//Assinatura do método
Alj.cor.transparencia(int porcentagem);

//Exemplo de 50% de transparência
Alj.cor.transparencia(50);
```

### Transformação

O objetivo deste grupo de comandos e poder realizar transformações como escala e rotação nos desenhos, por hora, somente rotação está disponível.

#### Rotação
A rotação é sempre aplicada diretamente ao ambiente de desenho. Desse modo, é sempre importante informar qual o eixo x, y que será utilizado para a rotação.

```java
//Assinatura do método
Alj.transforma.rotaciona(int angulo, int xCentra, int yCentral);
```

Se você quiser uma determinada forma geométrica seja rotacionada, precisará rotacionar a tela usando como eixo o centro da figura, e, após o desenho, limpar a rotação para que ela não afete os próximos desenhos.

Exemplo de um losango (Quadrado rotacionado em 90 graus).

```java
//Define x e y da posição central da rotação
int xCentral = x + (largura / 2);
int yCentral = y + (altura / 2);

//Executa Rotação
Alj.transforma.rotaciona(90, xCentral, yCentral);
//Faz o desenho
Alj.desenha.retangulo(x, y, largura, altura);
//Limpa a rotação para que os próximos desenhos não sejam afetados.
Alj.transforma.limpaRotacao();
```

### Tela
A Aljava é sempre baseada em uma tela. Os comandos deste pacote ajudam a trabalhar com ela e com entrada de dados que devem vir do usuário através de janelas pop-up.

#### Exibir a Tela
Todos os desenhos só serão exibidos na tela após a execução deste método. Antes disso, ficam em um buffer de desenho escondido. Isso evita que a tela fique "piscando".

```java
//Lembre-se de sempre executar este método após desenhar qualquer coisa (que você queira ver na tela).
Alj.tela.exibe();
```

#### Limpar
Antes de iniciar o desenho de um novo frame da sua aplicação, você pode querer limpar a tela. Basicamente limpar a tela é desenhar um retângulo branco por cima de tudo. Este método é um atalho para isso.

```java
Alj.tela.limpar();
```

#### Alterar o tamanho
A tela tem por padrão 400 pixels de largura por 400 de altura. Para alterar este tamanho, use:

```java
//Alj.inicializa(int largura, int altura)
Alj.inicializa(800, 600);
```

__OBS__: Este método não usa o grupo "tela" na assinatura pois a intenção é no futuro transformá-lo em um inicializador da janela.  

#### Finalizar
Para encerrar o programa e fechar a janela, execute:

```java
Alj.tela.finalizar();
```

#### Exibir Mensagem
Frequentemente é útil exibir mensagens ao usuário como "Parabéns, você venceu.". Para isto, use:

```java
Alj.tela.exibeMensagem("Parabéns, você venceu.\n\nTente novamente.")
```

**Obs:** use \n para quebra de linha na janela.

#### Solicitar Texto ao usuário
Você também pode solicitar que o usuário lhe informe um texto qualquer, como por exemplo, o seu nome.

```java
String nome = Alj.tela.solicitaTexto("Por favor, informe seu nome.");
```

#### Solicitar Números ao usuário
Você também pode solicitar que o usuário lhe informe um número qualquer, como por exemplo, para um par ou ímpar.

```java
int numero = Alj.tela.solicitaNumero("1, 2, 3 e já...");
```

Alternativamente, você pode solicitar um double

```java
double numero = Alj.tela.solicitaNumeroDouble("Informe o preço do produto:");
```

### Mouse

O mouse é um dos recursos que possibilitam maior interação com o usuário.
Sempre que necessário você pode pegar a posicão x, y do mouse com os métodos:

```java
int x = Alj.mouse.x();
int y = Alj.mouse.y();
```

E pode ver também se um dos três botões do mouse foram pressionados

```java
if( Alj.mouse.clickE() ){
    Alj.tela.exibeMensagem("Você pressionou o botão esquerdo");
}

if( Alj.mouse.clickM() ){
	Alj.tela.exibeMensagem("Você pressionou o botão do meio");
}

if( Alj.mouse.clickD() ){
	Alj.tela.exibeMensagem("Você pressionou o botão direito");
}
```

### Teclado

Por enquanto a Aljava só permite saber se em um dado momento, uma tecla está ou não pressionada.

```java
if( Alj.tecla.press("esquerda") ){
	moveHorizontal(-10);
}
	
if( Alj.tecla.press("direita") ){
	moveHorizontal(+10);
}

if( Alj.tecla.press("cima") ){
	moveVertical(-10);
}
	
if( Alj.tecla.press("baixo") ){
	moveVertical(+10);
}
```

As teclas disponíveis com String são: "enter", "espaco", "esquerda", "direita", "cima","baixo", todas as letras de "a" até "z", todos os números de 0 até 9 e todos os números do "NUMPAD" através das Strings "NUMPAD0", "NUMPAD2", etc.

Alternativamente, você pode usar o código da tecla com as constantes da classe KeyEvent do Java.

```java
if( Alj.tecla.press( KeyEvent.VK_TAB ) ){
	executaEspecial();
}

```

### Utilitários

Neste grupo estão alguns comandos utilitários que não se encaixam em nenhum dos grupos anteriores.

#### Espera

Em jogos, é muito comum precisarmos pedir para o computador esperar alguns instantes antes de executar uma ação ou partir para o frame seguinte do jogo. Podemos fazer isso, esperando alguns milisegundos com:

```java
Alj.util.espera(500);
```

#### Números aleatórios

Você pode sortear um número entre um mínimo e um máximo. 

```java
int num = Alj.util.sorteia(1, 10);
```

Alternativamente, você pode sortear um double passando valores double como parâmetros

```java
double num = Alj.util.sorteia(1.5, 3.5);
```

## Exemplos Completos Parte 1

Encerramos o detalhamento dos comandos com os utilitários. Agora, seguem alguns exemplos utilizando comandos de diferentes pacotes. 

### Cores + Desenho

```java
	//Cria uma variável para o valor da trasnparência. 
    //Inicialmente os desenhos começarão transparentes
    int transparencia = 100;
    
    //Inicia loop que irá desenhar as formas geométricas uma vez para cda valor inteiro entre 100 e 0.
    while(transparencia > 0){
      transparencia -= 1;

      //Limpa telae e configura cor laranja
      Alj.tela.limpa();
      Alj.cor.rgb(255, 200, 100);

      //Desenha um texto informando o valor da transparência com uma linha abaixo para dar um estilo visual agradável. Este texto deve estar sempre exibido, portanto, sua transparência é 0
      Alj.cor.transparencia(0);
      Alj.desenha.texto(10, 28, "Transparência: "+transparencia, 20);
      Alj.desenha.linha(10, 42, 290, 42);

      //Desenha as três formas geométricas mais básicas com o valor da transparência conforme a variável "transparência"
      Alj.cor.transparencia(transparencia);
      Alj.desenha.retangulo(20, 170, 40, 40);
      Alj.desenha.oval(200, 60, 40, 40);
      Alj.desenha.triangulo(100, 120, 40, 40);

	  //Desenha um polígono usando 5 pontos
      //Coordenadas x e y do polígono, Ex: 100,100 -> 200, 100 -> 300, 200, etc...
      int xs[] = {100, 200, 300, 150, 100};
      int ys[] = {100, 100, 200, 150, 100};
      Alj.desenha.poligono(xs, ys);
      
      //Exibe os desenhos
      Alj.tela.exibe(); 
      //Faz uma pausa para demosntrar o efeito da animação
      Alj.util.espera(50);
    }       
```

### Mini Paint

```java
while(true){      
        int xMouse = Alj.mouse.x();
        int yMouse = Alj.mouse.y();

		//Sempre desenha um pequeno círculo na posição do mouse
        Alj.desenha.oval(xMouse - 1, yMouse - 1, 2, 2);

		//Se o botão esquerdo estiver pressionado,
        //desenha um círculo vermelho maior
        if (Alj.mouse.clickE()) {
            Alj.cor.rgb(255, 0, 0);
            Alj.desenha.oval(xMouse - 10, yMouse - 10, 20, 20);
        }

		//Se o botão do meio estiver pressionado
        //desenha um círculo verde maior
        if (Alj.mouse.clickM()) {
            Alj.cor.rgb(0, 255, 0);
            Alj.desenha.oval(xMouse - 10, yMouse - 10, 20, 20);
        }

		//Se o botão do direito estiver pressionado
        //desenha um círculo azul maior
        if (Alj.mouse.clickD()) {
            Alj.cor.rgb(0, 0, 255);
            Alj.desenha.oval(xMouse - 10, yMouse - 10, 20, 20);
        }
      
        Alj.tela.exibe();   
}  
```

### Teclado e Tela

```java
Alj.tela.exibeMensagem("Olá. Pressione Enter para mudar a largura e altura da janela.");
//Inicializa uma janela com a largura e altura padrão    
int largura = 740;
int altura = 180;
String textoQualquer = "Aqui vai um texto que você informar";  
Alj.inicializa(largura, altura);
//Entra no loop para esperar o usuário pressionar enter
while(true){            
      Alj.tela.limpa();  
      //Quando o enter for pressionado, pega uma nova largura, uma nova altura e o texto a ser exibido
      if(Alj.tecla.press("enter")){
        largura = Alj.tela.solicitaNumero("Informe a largura:");
        altura = Alj.tela.solicitaNumero("Informe a altura:");
        textoQualquer = Alj.tela.solicitaTexto("Ïnforme um texto qualquer:");
        //e re-inicializa a janela com a altura especificada
        Alj.inicializa(largura, altura);
      }
      
	  //Desenha a largura e a altura da janela
      String tamanhoTela = largura+" x "+altura;
      Alj.desenha.texto(20, 60, tamanhoTela, 40);
      //Desenha o texto informado
      Alj.desenha.texto(20, 100, textoQualquer, 40);

      //Exibe
      Alj.tela.exibe();
      Alj.util.espera(50);
    } 
```

## Mídia

Por hora, podem ser usadas mídias para imagens e sons. Cada arquivo de mídia é representado por um objeto de uma classe. Todos os arquivos utilizados devem estar na pasta raiz do projeto.

### Imagem

Uma imagem representa um arquivo que pode estar nos formatos "png", "jpg" ou "gif". 
Uma imagem possui métodos para desenhá-la, alterar largura, altura ou invertê-la. 

```java
Imagem img;
//...
img = new Imagem("pasta/nomeimagem.jpg");

//Método para desenhar a imagem em uma posição na tela
//img.desenha(int x, int y);
img.desenha(20, 20); 

//Métodos de acesso à largura e altura da imagem
int largura = img.pegaLargura();
int altura = img.pegaAltura();

//Métodos que modificam a largura e altura
img.alteraLargura( 1 ); //Aumenta em 1 pixel a largura da imagem
img.alteraAltura( -1 ); //Diminui em um pixel a altura da imagem

//img.alteraTamanho(int novaLargura, int nova Altura)
img.alteraTamanho(48, 48); //Redimensiona a imagem para os valores especificados

//Inverte a imagem
img.inverte();
```

### Gif

Um objeto da classe Gif é uma extensão da classe Imagem e tem como única finalidade permitir que um objeto Gif pare de ser desenhado após certo período de tempo. Este recurso é útil por exemplo, em Gif's de explosões que devem parar de ser exibidos após alguns milissegundos.

```java
//new Gif(String caminhoImagem, int tempoParaSumirEmMilissegundos);
Gif explosao = new Gif("explosao.gif", 2000);

//Além dos métodos de imagem, há um método disponível para saber se o tempo já terminou
if( explosao.temrinou() ){
   //faz alguma coisa..
}

//Outro método útil é o reinicia, que permite reiniciar o contador de tempo do Gif
explosao.reinicia();
```

### Animação

Uma animação corresponde a um conjunto de imagens, cada qual representando um quadro, sendo exibidas uma após a outra com um certo intervalo de tempo. Por ser uma coleção de imagens, estão disponíveis alguns métodos que alteram todas as imagens da animação.

```java
//Cria um objeto da classe Animação informando o tempo em milissegundos de intervalo entre as imagens
 Animacao animacao = new Animacao(200);
 //Adiciona diferentes imagens para a animação
 animacao.addImagem("imagens/ryu/chute.png");
 animacao.addImagem("imagens/ryu/chute2.png");
 animacao.addImagem("imagens/ryu/chute.png");
 animacao.addImagem("imagens/ryu/soco_direita.png");
 animacao.addImagem("imagens/ryu/soco_esquerda.png");
 animacao.addImagem("imagens/ryu/haduken.png");
 //Inicia execução da animação em loop, ou seja, quando chegar ao final, recomeça
 //Uma forma alternativa é usar o método inicia() apenas.
 animacao.iniciaEmLoop();
    
 //Para demonstrar os demais recursos fazemos um loop que altera a animação conforme as teclas digitadas pelo usuário   
 while(true){ 
      Alj.tela.limpa();

      if( Alj.tecla.press("esquerda") ){
        //Diminui em 10 pixels a largura de todas as imagens da animação
        animacao.alteraLargura(-10);
      }

      if( Alj.tecla.press("direita") ){
        //Aumenta em 10 pixels a largura de todas as imagens da animação
        animacao.alteraLargura(10);
      }

      if( Alj.tecla.press("cima") ){
      	//Aumenta em 10 pixels a altura de todas as imagens da animação
        animacao.alteraAltura(10);
      }
            
      if( Alj.tecla.press("baixo") ){
      	//Diminui em 10 pixels a altura de todas as imagens da animação
        animacao.alteraAltura(-10);
      }

      if( Alj.tecla.press("espaco") ){
      	//Inverte todas as imagens da animação
        animacao.inverte();
      }
      //Processa a animação para realizar a troca do quadro
      animacao.processa();
      //Desenha a imagem atual da animação no ponto 50, 50 da tela
      animacao.desenha(50, 50);

      Alj.tela.exibe();
    }
```


### Sons

Um som pode ser executado, parado, reiniciado e executado em loop. Somente estão disponíveis sons no formato Wav. Segue abaixo exemplo de como controlar uma música via comandos do teclado.

```java
//Cria objeto que representa uma música
Som musica = new Som("recursos/aljava.exemplos.som/mario.wav");
while(true){
	Alj.tela.limpa();
    
	Alj.desenha.texto(20, 20, "Pressione t -> Toca a Musica");
	if(Alj.tecla.press("t")){
	   musica.toca();
       //se preferir, inicie em loop
       //musica.loop();
	}

	Alj.desenha.texto(20, 40, "Pressione p -> Pausa a Musica");
	if(Alj.tecla.press("p")) {
		musica.pausa();
	}

	Alj.desenha.texto(20, 60, "Pressione r -> Reinicia a Musica");
	if(Alj.tecla.press("r")) {
		musica.reinicia();
	}

	Alj.tela.exibe();
}
```
Outro uso é como sons de notas musicais para simular um violão ou guitarra por exemplo.
Neste exemplo, para cada tecla digitada um objeto som é criado e executado, assim, uma mesma tecla pode ser pressionada várias vezes para criar diversos objetos do mesmo som.

Variáveis booleanas são utilizadas para garantir que a tecla só pode ser pressionada novamente após ser solta.

```java
         while(true){
            Alj.tela.limpa();

            //Tecla Ré
            Alj.desenha.texto(20, 40, "Pressione s -> Ré");
            if(Alj.tecla.press("s") && sLiberado){
                sLiberado = false;
                Som som = new Som("recursos/aljava.exemplos.som/re_piano.wav");
                som.toca();
            }

            if(!Alj.tecla.press("s")) {
                sLiberado = true;
            }

            //Tecla Ré
            Alj.desenha.texto(20, 60, "Pressione d -> Fá");
            if(Alj.tecla.press("d") && dLiberado){
                dLiberado = false;
                Som som = new Som("recursos/aljava.exemplos.som/fa_piano.wav");
                som.toca();
            }

            if(!Alj.tecla.press("d")) {
                dLiberado = true;
            }

           
            Alj.tela.exibe();
        }
```


## Conclusão

Ao todo, são 37 comandos. Todos com o mesmo objetivo de tornar a programação em java um pouco mais divertida e prazerosa ara quem está começando.

Assim, nossos primeiros programas podem ganhar um pouco mais de vida e dinamismo e o ensino fica melhor também para o professor que pode ir muito além do tradicional.

E tudo isso, ainda usando Java, uma linguagem poderosa e profissional.
Espero que gostem.

## Inspiração e agradecimentos

À criatividade e disposição dos meus alunos que tem encarado comigo o desafio de aprender programação de um modo que vale a pena, divertido, voltado para aproveitar o máximo do potencial criativo que o computador pode nos oferecer.

Ao SENAI são José e à Márcia Cristina (coordenadora) pela confiança e pelo excepcional trabalho como coordenadora do curso técnico de programação articulado com o ensino médio.

Aos projetos BlueJ, Greenfoot, idraw e Processing.

Ao orientador do meu TCC, professor Ricardo Pereira e Silva, UFSC e aos demais professores do curso de Sistemas de Informação que contribuíram para o meu aprendizado e desenvolvimento.

Por fim, à minha amada família, Suélen e Kainan, simplesmente pelo que são.!
