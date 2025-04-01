package Refatorado;

import java.util.Set;

public class App {

  private static final Set<String> DIFICULDADES_VALIDAS = Set.of("0", "1", "2", "3");

  private static Game game;
  private static UIGame uiGame;

  public static void main(String[] args) {
    String opcaoMenu;

    do {
      UIGame.writeMenuInicial();
      opcaoMenu = UIGame.readInput();

      switch (opcaoMenu) {
      case "1" -> iniciarGame();
      case "0" -> {
        continue;
      }
      default -> UIGame.writeln("-> Opção inválida");
      }
    } while (!opcaoMenu.equals("0"));
  }

  private static void iniciarGame() {
    prepararJogo();
    rodarGame();
    exibirResultado();
  }

  private static void prepararJogo() {
    String opcaoDificuldade;

    do {
      UIGame.writeMenuDificuldade();
      opcaoDificuldade = UIGame.readInput();

      if (!DIFICULDADES_VALIDAS.contains(opcaoDificuldade)) {
        UIGame.writeln("\n-> Dificuldade inválida");
      }
    } while (!DIFICULDADES_VALIDAS.contains(opcaoDificuldade));

    game = new Game(Integer.parseInt(opcaoDificuldade));
    uiGame = new UIGame(game);
  }

  private static void rodarGame() {
    executarPrimeiraJogada();

    do {
      rodarTurno();
    } while (game.isJogando());
  }

  private static void executarPrimeiraJogada() {
    Jogada jogada;

    do {
      uiGame.writeTabuleiro();

      jogada = processarJogada();
    } while (jogada == null);

    game.carregarTabuleiro(jogada.getX(), jogada.getY());
  }

  private static void rodarTurno() {
    uiGame.writeTabuleiro();

    Jogada jogada = processarJogada();

    if (jogada != null) {
      game.executarAcao(jogada);
    }
  }

  private static Jogada processarJogada() {
    String[] input = UIGame.readInput().split(" ");

    int x;
    int y;

    boolean isMarcarPosicao = false;

    try {
      switch (input.length) {
      case 2 -> {
        x = Integer.parseInt(input[0]) - 1;
        y = Integer.parseInt(input[1]) - 1;
      }
      case 3 -> {
        x = Integer.parseInt(input[1]) - 1;
        y = Integer.parseInt(input[2]) - 1;

        if (input[0].equals("!")) {
          isMarcarPosicao = true;
        }
      }
      default -> {
        UIGame.writeln("\n-> Coordenadas inválidas");
        return null;
      }
      }
    } catch (NumberFormatException e) {
      UIGame.writeln("\n-> Coordenadas inválidas");
      return null;
    }

    if (x < 0 || y < 0 || x >= game.getComprimento() || y >= game.getComprimento()) {
      UIGame.writeln("\n-> Coordenadas inválidas");
      return null;
    }

    return new Jogada(x, y, isMarcarPosicao);
  }

  private static void exibirResultado() {
    uiGame.writeTabuleiro(true);

    if (game.isGanhou()) {
      UIGame.writeln("-> Win");
    } else {
      UIGame.writeln("-> Game Over");
    }
  }
}
