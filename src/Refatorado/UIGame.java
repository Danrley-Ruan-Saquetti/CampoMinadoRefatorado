package Refatorado;

import java.util.Scanner;

public class UIGame {

  private final static Scanner SCAN = new Scanner(System.in);

  private final Game game;

  public UIGame(Game game) {
    this.game = game;
  }

  public static void writeMenuInicial() {
    write("""
        \n+- Campo Minado
        | 1 - Iniciar
        | 0 - Sair
        +-
        """);
  }

  public static void writeMenuDificuldade() {
    write("""
        \n+- Dificuldade
        | 0 - Partida Rápida
        | 1 - Fácil
        | 2 - Médio
        | 3 - Difícil
        +-
        """);
  }

  public static String readInput() {
    return readInput("");
  }

  public static String readInput(String inputName) {
    write("$ " + inputName);
    return SCAN.nextLine();
  }

  public void writeTabuleiro() {
    writeTabuleiro(false);
  }

  public void writeTabuleiro(boolean exibirCasaEscondida) {
    final int COL_WIDTH = 3;
    final String COL_SPACING = " ".repeat(COL_WIDTH);

    byte[][] campoMinado = game.getTabuleiroCampoMinado();

    int linhas = game.getComprimento();
    int colunas = game.getComprimento();

    String header = "  " + COL_SPACING;
    for (int i = 1; i <= colunas; i++) {
      header += String.format("%-" + COL_WIDTH + "d ", i);
    }

    writeln("\n" + header);

    for (int i = 0; i < linhas; i++) {
      writeln("   " + "-".repeat(colunas * 4 + 1));

      String linha = lpad(String.valueOf(i + 1), 2) + " |";

      for (int j = 0; j < colunas; j++) {
        String casa = COL_SPACING;

        if (game.isAberto(i, j) || exibirCasaEscondida) {
          casa = formatCasa(campoMinado[i][j]);
        } else if (game.isMarcado(i, j)) {
          casa = " ! ";
        }

        linha += casa + "|";
      }

      writeln(linha);
    }

    write("   " + "-".repeat(colunas * 4 + 1));
  }

  private static String formatCasa(int value) {
    String valueFormatted = switch (value) {
    case -1 -> "X";
    case 0 -> "_";
    default -> value + "";
    };

    return " " + valueFormatted + " ";
  }

  private static String lpad(String value, int length) {
    return String.format("%" + length + "s", value);
  }

  public static void write(String output) {
    System.out.print(output);
  }

  public static void writeln(String output) {
    System.out.println(output);
  }
}
