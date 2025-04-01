package Refatorado;

import java.util.Random;

public class MatrizCampoMinado {

  public static final byte CASA_BOMBA = -1;

  private byte[][] tabuleiro;

  private final int comprimento;
  private final int quantidadeBombas;

  public MatrizCampoMinado(int comprimento, int quantidadeBombas) {
    this.quantidadeBombas = quantidadeBombas;
    this.comprimento = comprimento;
  }

  public void carregarTabuleiro(int primeiroX, int primeiroY) {
    limpar();
    carregarBombas(primeiroX, primeiroY);
    carregarNumeros();
  }

  private void carregarBombas(int primeiroX, int primeiroY) {
    Random r = new Random();
    int bombasRestantes = quantidadeBombas;

    while (bombasRestantes > 0) {
      int x = r.nextInt(comprimento);
      int y = r.nextInt(comprimento);

      if ((x == primeiroX && y == primeiroY) || isBomba(x, y)) {
        continue;
      }

      tabuleiro[x][y] = CASA_BOMBA;
      bombasRestantes--;
    }
  }

  private void carregarNumeros() {
    for (int i = 0; i < tabuleiro.length; i++) {
      for (int j = 0; j < tabuleiro[i].length; j++) {
        if (!isBomba(i, j)) {
          continue;
        }

        MatrizUtil.iterateAround(tabuleiro, i, j, (x, y) -> {
          if (!isBomba(x, y)) {
            tabuleiro[x][y]++;
          }
        });
      }
    }
  }

  private void limpar() {
    tabuleiro = new byte[comprimento][comprimento];
  }

  public boolean isBomba(int x, int y) {
    return tabuleiro[x][y] == CASA_BOMBA;
  }

  public int getCasa(int x, int y) {
    return tabuleiro[x][y];
  }

  public byte[][] getTabuleiro() {
    return tabuleiro;
  }
}
