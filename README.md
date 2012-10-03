Classe Aljava 
=====

Aljava é um conjunto de comandos que facilitam o desenvolvimento de jogos e Simulações em Java.
Os Comandos são divididos em 8 pacotes:

* **cor**: seleção da cor que está sendo utilizada para o desenho em diversos formatos e uso de transparência;
* **desenho**: Desenho de formas geométricas e imagens;
* **transforma**: Que permite o uso de rotações;
* **tela**: com comandos para solicitar informações ao usuário, tamanho da tela, etc;
* **som**: Permite o pré-carregamento, execução, pausa e loop de sons WAV;
* **mouse**: Acesso ao mouse;
* **tecla**: Acesso ao teclado;
* **util**: comandos utilitários como o sorteio de números aleatórios e espera.

## Início

### Instalação

Basta adicionar ao seu projeto o arquivo **Aljava.jar** que está na raiz do github. Ele tem tudo que é necessário.

### Execução

Para iniciar com a classe Aljava basta importá-la e executar alguns dos seus comandos. Ao importar a classe uma janela de 400x400 é criada para o jogo, todos os comandos são baseados nesta janela.

```java
import aljava.Alj;
```

**Obs:** Para facilitar a escrita o nome usado para acessar os comandos é Alj.*

```java
Alj.desenha.retangulo(0, 0, 400, 400);

Alj.cor.nome("verde");
Alj.desenha.texto(20, 200, "Aljava - Programação é massa.", 16);

Alj.tela.exibe();
```

### IDE - Ambiente de Programação

A lib Aljava está em um JAR. Você pode incluí-lo em seu projeto e começar a usá-lo livremente. Qualquer ambiente de programação (Netbeans, Eclipse, JCreator, etc) pode ser utilizado. Para fins didáticos, recomendo o BlueJ.

## Documentação - Comandos disponíveis

### desenho

Este pacote permite o desenho de diversas formas geométricas e imagens.

#### Linha
Uma linha representa a ligação entre dois pontos. 
Os parâmetros são o x, y do ponto inicial e o x, y do ponto final.

```java
//Alj.desenha.linha(x, y, xFinal, yFinal);

//Linha diagonal na tela
Alj.desenha.linha(0, 0, 400, 400);

//Linha horizontal no meio da tela
Alj.desenha.linha(0, 400, 200, 200);
```

#### Retângulo
Um retângulo inicia com o canto superior esquerdo em uma coordenada x, y e possui uma largura e uma altura.

```java
//Alj.desenha.retangulo(x, y, largura, altura);
Alj.desenha.retangulo(20, 20, 300, 100);
```

#### Oval
Uma oval inicia com o canto superior esquerdo em uma coordenada x, y e possui uma largura e uma altura.
Você pode fazer um círculo com a altura = largura.

```java
//Alj.desenha.oval(x, y, largura, altura);
Alj.desenha.oval(20, 20, 300, 100);
```

#### Triangulo
Uma triângulo inicia com o canto superior esquerdo em uma coordenada x, y e possui uma largura e uma altura.
Este triângulo sempre tem a ponta para cima. Para construir triângulos de lado ou para baixo, use-o em conjunto com o comando Alj.transforma.rotaciona( ... )

```java
//Alj.desenha.triangulo(x, y, largura, altura);
Alj.desenha.triangulo(20, 20, 300, 100);
```

#### Polígonos
Você pode desenhar qualquer forma geométrica usando polígonos.
Polígonos são sequencias de pontos. Para desenhar um polígono, basta passar um array de pontos x e um array de pontos y.

```java
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

#### Imagens
Uma imagem pode ser desenhada em um ponto x, y da tela.
As imagens devem estar na raiz do projeto. Sugiro que sempre use dentro da raiz uma pasta "imagens".

```java
Alj.desenha.imagem(x, y, "imagens/Ryu.png");
```

### cor

Todos os desenhos acima podem receber transparência ou uma cor(exceto imagens). Você pode mudar a cor de diversas formas, escolha a que preferir.

#### Mudar cor pelo nome
Existem alguns nomes de cores pré-definidos que podem ser usados como uma String. Isso é útil no início do aprendizado de programação, principalmente para os primeiros exercícios.

```java
Alj.cor.nome("vermelho");
```

As cores disponíveis são: "vermelho", "laranja", "ciano", "preto", "azul", "amarelo", "verde", "magenta" e "branco".

#### Mudar cor pelo RGB
Uma cor é formada por uma quantidade de vermelho (R), verde (G) e azul (B). Estes valores variam de 0 (mais escuro) até 255 (mais claro). Este comando tem três parâmetros, um para cada das três cores e é o mais útil para criar pequenas animações com cores.

```java
//Alj.cor.rgb(int r, int g, int b)
Alj.cor.rgb(200, 100, 78);
```
#### Hexadecimal #006699
Desenvolvedores que tenham conhecimento de web e estejam acostumados com o formato hexadecimal, podem usá-lo também.
Qualquer cor hexadecimal pode ser informada como uma String.

```java
//Alj.cor.hexadecimal(String hexadecimal);
Alj.cor.hexadecimal("#336699");
```

#### Objeto Color
Desenvolvedores mais avançados podem usar um objeto da classe Color do Java.

```java
Alj.cor.objeto( new Color(200,100,10) );
```

#### Alterar a transparência
Outro recurso útil é o uso de transparências. Você pode informat a transparência com uma porcentagem que varia de 0 até 100. Quanto maior o valor, maior a transparência.

```java
//Alj.cor.transparencia(int porcentagem);
Alj.cor.transparencia(50);
```

### transforma (Rotação)
A rotação é sempre aplicada diretamente ao ambiente de desenho. Desse modo, é sempre importante informar qual o eixo x, y que será utilizado para a rotação.

Se você quiser uma determinada forma geométrica rotacionada, precisará rotacionar a tela usando como eixo o centro da figura, e, após o desenho, limpar a rotação para que ela não afete os próximos desenhos.

Exemplo de um losango

```java
int xCentral = x + (largura / 2);
int yCentral = y + (altura / 2);

Alj.transforma.rotaciona(90, xCentral, yCentral);
Alj.desenha.retangulo(x, y, largura, altura);
Alj.transforma.limpaRotacao();
```

### tela
A Aljava é sempre baseada em uma tela. Os comandos deste pacote ajudam a trabalhar com ela e com entrada de dados que devem vir do usuário através de janelas pop-up.

#### Exibir a Tela
Todos os desenhos só serão exibidos na tela após a execução deste método. Antes disso, ficam em um buffer de desenho escondido. Isso evita que a tela fique "piscando".

```java
//Lembre-se de semrpe executar este método após desenhar qualquer coisa (que você queira ver na tela).
Alj.tela.exibe();
```

#### Limpar
Antes de iniciar o desenho de um novo frame da sua aplicação, você pode querer limpar a tela.
Basicamente limpar a tela é desenhar um retângulo branco por cima de tudo. Este método é um atalho para isso.

```java
Alj.tela.limpar();
```

#### Alterar o tamanho
A tela tem por padrão 400 pixels de largura por 400 de altura. Para alterar este tamanho, use:

```java
//Alj.tela.tamanho(int largura, int altura)
Alj.tela.tamanho(800, 600);
```

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

### som

Basicamente para trabalhar com sons é nessário tocá-los, pausá-los e repetí-los. É isso que estes comandos fazem.
Outro ponto importante é que os sons precisam ser carregados previamente e esse processo pode demorar alguns segundos.

É uma boa prática desenhar uma mensagem ou imagem informando que o som está sendo carregado, e só depois, mudar para a imagem do jogo.

Os sons devem estar sempre na pasta raiz da aplicação, exatamente igual as imagens.

**Obs**: a lib só aceita sons no formato WAV.

#### Carregando sons

Quando carrega um som para a memória você deve informar uma chave para esse som. Será por essa chave que você poderá acessá-lo para tocá-lo ou pausá-lo. O segundo parâmetro é o nome do arquivo de som.

```java
Alj.som.carrega("golpe", "sounds/golpe.wav");
Alj.som.carrega("golpe2", "sounds/golpe2.wav");
```

#### Executando sons

```java
Alj.som.toca("golpe");
```

Opcionalmente, você pode executar um som em loop

```java
Alj.som.loop("golpe2");
```

#### Pausando sons

```java
Alj.som.para("golpe2");
``` 

### mouse

O mouse é um dos recursos que possibilita maior interação com o usuário.
Sempre que necessário você pode pegar a posicão x, y do mouse com os métodos:

```java
int x = Alj.mouse.x();
int y = Alj.mouse.y();
```

E pode ver também se um dos dois botões foram pressionados

```java
if( Alj.mouse.clickE() ){
	Alj.tela.exibeMensagem("Você pressionou o botão esquerdo");
}

if( Alj.mouse.clickD() ){
	Alj.tela.exibeMensagem("Você pressionou o botão direito");
}
```

### tecla

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

As teclas disponíveis com String são: "enter", "espaco", "esquerda", "direita", "cima","baixo", "w", "a", "s", "d", "z", "x" e "p".

Alternativamente, você pode usar o código da tecla

```java
if( Alj.tecla.press( KeyEvent.VK_SPACE ) ){
	lancaEspecial();
}
```

### util

Reunião de comandos úteis que não se encaixam em nenhum dos pacotes anteriores.

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
