Classe Aljava 
=====

A classe Aljava permite a criação de pequenos jogos em Java a partir dos seguintes recursos:

* Desenho de formas geométricas;
* Alteração de cor e uso de transparência;
* Rotação da tela;
* Acesso ao Mouse;
* Acesso ao Teclado;

## Iniciando

A classe Aljava representa uma janela e possui métodos que permitem ao programador interagir com esta janela.
Cada novo objeto é uma nova janela.

Para iniciar com a classe Aljava basta criar um objeto a partir dela:

```java
Aljava alj = new Aljava();
```

opcionalmente, você pode informar a largura e altura da tela que será exibida ao criar a classe Aljava

```java
Aljava alj = new Aljava(800, 600);
```

Para exibir um retangulo na tela, basta usar:

```java
Aljava alj = new Aljava(800, 600);
alj.desenhaRetangulo(20, 20, 300, 300);
alj.mostraTela();
```

### Classe template

Principalmente para usuários do BlueJ, o objeto da classe Aljava deverá ser uma variável de instância da classe.
O template da classe pode ser o seguinte:

```java
public class MinhaClasse {
  //Suas outras variáveis de instânca
  Aljava alj;
  
  MinhaClasse(){
    //Inicialização das outras variáveis
    alj = new Aljava();
  }
  
  void desenho() {
    //exemplo de desenho
    alj.desenhaRetangulo(50, 50, 200, 200);
    alj.mostraTela();
  }
}
```

### Exemplos

A pasta exemplos no github contém diversos testes, pequenos jogos e animações que vão dar uma idéia geral do que a classe pode fazer.

### IDE - Ambiente de Programação

A classe Aljava vem em um único arquivo. Você pode incluí-la em seu projeto e começar a usá-la livremente. Qualquer ambiente de programação (Netbeans, Eclipse, JCreator, etc) pode ser utilizado. Para fins didáticos, recomendo o BlueJ.

## Uso da Classe

### Métodos de Desenho

#### Linha
#### Retangulo
#### Círculo
#### Triangulo
#### Polígonos
#### Imagens

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
