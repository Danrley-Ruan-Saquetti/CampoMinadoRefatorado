package Refatorado;

public class Jogada {
  private final int x;
  private final int y;
  private final boolean isMarcarPosicao;

  public Jogada(int x, int y, boolean isMarcarPosicao) {
    this.x = x;
    this.y = y;
    this.isMarcarPosicao = isMarcarPosicao;
  }

  public int getX() {
    return x;
  }

  public int getY() {
    return y;
  }

  public boolean isMarcarPosicao() {
    return isMarcarPosicao;
  }
}
