package Refatorado;

public class MatrizJogador {

  public static final byte CASA_VISIVEL_FECHADO = 0;
  public static final byte CASA_VISIVEL_ABERTO = 1;
  public static final byte CASA_VISIVEL_MARCADO = 2;

  private final byte[][] tabuleiroVisivel;

  public MatrizJogador(int comprimento) {
    tabuleiroVisivel = new byte[comprimento][comprimento];
  }

  public void marcarDesmarcarCasa(int x, int y) {
    if (isFechado(x, y)) {
      tabuleiroVisivel[x][y] = CASA_VISIVEL_MARCADO;
    } else if (isMarcado(x, y)) {
      tabuleiroVisivel[x][y] = CASA_VISIVEL_FECHADO;
    }
  }

  public void exibirCasa(int x, int y) {
    tabuleiroVisivel[x][y] = CASA_VISIVEL_ABERTO;
  }

  public boolean isAberto(int x, int y) {
    return tabuleiroVisivel[x][y] == CASA_VISIVEL_ABERTO;
  }

  public boolean isMarcado(int x, int y) {
    return tabuleiroVisivel[x][y] == CASA_VISIVEL_MARCADO;
  }

  public boolean isFechado(int x, int y) {
    return tabuleiroVisivel[x][y] == CASA_VISIVEL_FECHADO;
  }

  public byte[][] getTabuleiroVisivel() {
    return tabuleiroVisivel;
  }
}
