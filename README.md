Classe Aljava 
=====

Aljava é um conjunto de comandos que facilitam o desenvolvimento de jogos e Simulações em Java.
Os Comandos são divididos em 8 pacotes:

* **cor**: seleção da cor que está sendo utilizada para o desenho em diversos formatos e uso de transparência;
* **desenho**: Desenho de formas geométricas e imagens;
* **transforma**: Que permite o uso de rotações;
* **tela**: com métodos para solicitar informações ao usuário, tamanho da tela, etc;
* **som**: Permite o pré-carregamento, execução, pausa e loop de sons WAV;
* **mouse**: Acesso ao mouse;
* **tecla**: Acesso ao teclado;
* **util**: Métodos utilitários como o sorteio de números aleatórios e espera.

## Início

### Instalação

Basta adicionar ao seu projeto o arquivo Aljava.jar na raiz do github. Ele tem tudo que é necessário.

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


### Métodos de Cor e Transparência

#### Mudar cor pelo nome
#### Mudar cor pelo RGB
#### Mudar cor com um objeto Color
#### Alterar a transparência

### Rotação de Tela

### Acesso ao Mouse

#### Click botão esquerdo
#### Click botão direito
#### Posicao do Click
#### Posicao do Mouse

### Acesso ao Teclado

#### Ver se tecla está pressionada pela String
#### Ver se a tecla está pressionada pelo código

## Inspiração e agradecimentos

À criatividade e disposição dos meus alunos que tem encarado comigo o desafio de aprender programação de um modo que vale a pena, divertido, voltado para aproveitar o máximo do potencial criativo que o computador pode nos oferecer.

Ao SENAI são José e à Márcia Cristina (coordenadora) pela confiança e pelo excepcional trabalho como coordenadora do curso técnico de programação articulado com o ensino médio.

Aos projetos BlueJ, Greenfoot e idraw.

Ao orientador do meu TCC, professor Ricardo Pereira e Silva, UFSC e aos demais professores do curso de Sistemas de Informação que contribuíram para o meu aprendizado e desenvolvimento.
