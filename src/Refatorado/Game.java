package Refatorado;

public class Game {

  private final MatrizCampoMinado matrizCampoMinado;
  private final MatrizJogador matrizJogador;

  private final int comprimento;
  private final int quantidadeBombas;

  private boolean jogando;
  private boolean ganhou;

  private int casasSegurasRestantes;

  public Game(int dificuldade) {
    comprimento = getComprimentoTabuleiroByDificuldade(dificuldade);
    quantidadeBombas = getQuantidadeBombasByDificuldade(dificuldade);

    matrizCampoMinado = new MatrizCampoMinado(comprimento, quantidadeBombas);
    matrizJogador = new MatrizJogador(comprimento);
  }

  private static int getComprimentoTabuleiroByDificuldade(int dificuldade) {
    return switch (dificuldade) {
    case 0 -> 5;
    case 1 -> 9;
    case 2 -> 16;
    case 3 -> 22;
    default -> 10;
    };
  }

  private static int getQuantidadeBombasByDificuldade(int dificuldade) {
    return switch (dificuldade) {
    case 0 -> 5;
    case 1 -> 10;
    case 2 -> 40;
    case 3 -> 90;
    default -> 10;
    };
  }

  public void carregarTabuleiro(int primeiroX, int primeiroY) {
    matrizCampoMinado.carregarTabuleiro(primeiroX, primeiroY);
    casasSegurasRestantes = calcularQuantidadeCasasSeguras();

    jogando = true;
    ganhou = false;

    abrirCasa(primeiroX, primeiroY);
  }

  public void executarAcao(Jogada jogada) {
    if (jogada.isMarcarPosicao()) {
      marcarDesmarcarCasa(jogada.getX(), jogada.getY());
    } else {
      abrirCasa(jogada.getX(), jogada.getY());
    }
  }

  private void abrirCasa(int x, int y) {
    if (!matrizJogador.isMarcado(x, y)) {
      return;
    }

    if (matrizCampoMinado.isBomba(x, y)) {
      exibirCasa(x, y);
      perder();
    } else {
      abrirCasas(x, y);

      if (isAllCasasVisiveis()) {
        ganhar();
      }
    }
  }

  private void abrirCasas(int x, int y) {
    if (!matrizJogador.isFechado(x, y)) {
      return;
    }

    exibirCasa(x, y);

    if (matrizCampoMinado.getCasa(x, y) <= 0) {
      return;
    }

    MatrizUtil.iterateAround(matrizJogador.getTabuleiroVisivel(), x, y, (i, j) -> {
      if (matrizJogador.isFechado(i, j)) {
        abrirCasas(i, j);
      }
    });
  }

  private void marcarDesmarcarCasa(int x, int y) {
    matrizJogador.marcarDesmarcarCasa(x, y);
  }

  private void exibirCasa(int x, int y) {
    matrizJogador.exibirCasa(x, y);
    casasSegurasRestantes--;
  }

  private boolean isAllCasasVisiveis() {
    return casasSegurasRestantes == 0;
  }

  private void ganhar() {
    jogando = false;
    ganhou = true;
  }

  private void perder() {
    jogando = false;
    ganhou = false;
  }

  public boolean isAberto(int x, int y) {
    return matrizJogador.isAberto(x, y);
  }

  public boolean isMarcado(int x, int y) {
    return matrizJogador.isMarcado(x, y);
  }

  public boolean isFechado(int x, int y) {
    return matrizJogador.isFechado(x, y);
  }

  public boolean isJogando() {
    return jogando;
  }

  public boolean isGanhou() {
    return ganhou;
  }

  public int calcularQuantidadeCasasSeguras() {
    return (comprimento * comprimento) - quantidadeBombas;
  }

  public byte[][] getTabuleiroVisivel() {
    return matrizJogador.getTabuleiroVisivel();
  }

  public byte[][] getTabuleiroCampoMinado() {
    return matrizCampoMinado.getTabuleiro();
  }

  public int getComprimento() {
    return comprimento;
  }
}
