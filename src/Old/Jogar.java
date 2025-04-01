package Old;

import java.util.Random;
import java.util.Scanner;

public class Jogar {

  public static void main(String[] args) {
    Scanner s = new Scanner(System.in);
    Random r = new Random();

    int menu;
    do { // Campo do menu
      do {
        System.out.print("\n+- MENU\n|1 - New Game\n|2 - Quit Game\n+-\n-> Executar comando: ");
        menu = s.nextInt();
        if ((menu != 1) && (menu != 2)) {
          System.out.println("SISTEMA: Valor inválido!");
        }
      } while ((menu != 1) && (menu != 2));
      if (menu == 1) {
        boolean tabBomba[][] = new boolean[1][1];
        int dificuldade, bombas = 0, xy = 0;
        String numeroColuna = "", linha = "";

        do {
          System.out.print("\n+-\n|1 - Partida Rápida\n|2 - Fácil\n|3 - Médio" + "\n|4 - Difícil\n+-\n-> Executar comando: ");
          dificuldade = s.nextInt();
          if ((dificuldade < 1) || (dificuldade > 4)) {
            System.out.println("SISTEMA: Valor inválido!");
          }
        } while ((dificuldade < 1) || (dificuldade > 4));

        switch (dificuldade) {
        case 1:
          numeroColuna = "  0   1   2   3   4  5";
          linha = "+---+---+---+---+---+---+";
          tabBomba = new boolean[6][6]; // 6 Bombas
          bombas = 6;
          xy = 5;
          break;
        case 2:
          numeroColuna = "  0   1   2   3   4   5   6   7";
          linha = "+---+---+---+---+---+---+---+---+";
          tabBomba = new boolean[8][8]; // 10 Bombas
          bombas = 10;
          xy = 7;
          break;
        case 3:
          numeroColuna = "  0   1   2   3   4   5   6   7   8   9  10  11  12  13";
          linha = "+---+---+---+---+---+---+---+---+---+---+---+---+---+---+";
          tabBomba = new boolean[14][14]; // 35 Bombas
          bombas = 35;
          xy = 13;
          break;
        case 4:
          numeroColuna = "  0   1   2   3   4   5   6   7   8   9  10  11  12  13  14  15  16  17";
          linha = "+---+---+---+---+---+---+---+---+---+---+---+---+---+---+---+---+---+---+";
          tabBomba = new boolean[18][18]; // 75 Bombas
          bombas = 75;
          xy = 17;
          break;
        }

        System.out.println("+- LEGENDA\n|[ ] - Bloco ainda não aberto\n|! - Perigo de bomba\n+-");

        int x = 0, y = 0;
        System.out.println("\n" + numeroColuna + "\n" + linha);
        for (int i = 0; i < tabBomba.length; i++) {
          for (int j = 0; j < tabBomba[i].length; j++) {
            System.out.print("|[ ]");
          }
          System.out.print("| " + i + "\n" + linha + "\n");
        }
        do {
          System.out.print("-> X: ");
          x = s.nextInt();
          if ((x < 0) || (x > xy)) {
            System.out.println("SISTEMA: Valor inválido!");
          }
        } while ((x < 0) || (x > xy));
        do {
          System.out.print("-> Y: ");
          y = s.nextInt();
          if ((y < 0) || (y > xy)) {
            System.out.println("SISTEMA: Valor inválido!");
          }
        } while ((y < 0) || (y > xy));

        do {
          int xB = 0, yB = 0;
          do {
            xB = r.nextInt(xy);
            yB = r.nextInt(xy);
          } while ((tabBomba[xB][yB]) || ((xB == x) && (yB == y)) || ((xB - 1 == x) && (yB - 1 == y)) || ((xB - 1 == x) && (yB == y)) || ((xB - 1 == x) && (yB + 1 == y))
              || ((xB == x) && (yB - 1 == y)) || ((xB == x) && (yB + 1 == y)) || ((xB + 1 == x) && (yB - 1 == y)) || ((xB + 1 == x) && (yB == y)) || ((xB + 1 == x) && (yB + 1 == y)));
          tabBomba[xB][yB] = true;
          bombas--;
        } while (bombas != 0);

        int tabNum[][] = new int[xy + 1][xy + 1], tabBi[][] = new int[xy + 1][xy + 1];
        for (int i = 0; i < tabNum.length; i++) {
          for (int j = 0; j < tabNum[i].length; j++) {
            int cont = 0;
            if ((i > 0) && (i < tabBomba.length - 1)) {
              if ((j > 0) && (j < tabBomba.length - 1)) {
                if (tabBomba[i - 1][j - 1]) {
                  cont++;
                }
                if (tabBomba[i - 1][j]) {
                  cont++;
                }
                if (tabBomba[i - 1][j + 1]) {
                  cont++;
                }
                if (tabBomba[i][j - 1]) {
                  cont++;
                }
                if (tabBomba[i][j + 1]) {
                  cont++;
                }
                if (tabBomba[i + 1][j - 1]) {
                  cont++;
                }
                if (tabBomba[i + 1][j]) {
                  cont++;
                }
                if (tabBomba[i + 1][j + 1]) {
                  cont++;
                }
              } else {
                if (j == 0) {
                  if (tabBomba[i - 1][j]) {
                    cont++;
                  }
                  if (tabBomba[i - 1][j + 1]) {
                    cont++;
                  }
                  if (tabBomba[i][j + 1]) {
                    cont++;
                  }
                  if (tabBomba[i + 1][j]) {
                    cont++;
                  }
                  if (tabBomba[i + 1][j + 1]) {
                    cont++;
                  }
                } else {
                  if (tabBomba[i - 1][j - 1]) {
                    cont++;
                  }
                  if (tabBomba[i - 1][j]) {
                    cont++;
                  }
                  if (tabBomba[i][j - 1]) {
                    cont++;
                  }
                  if (tabBomba[i + 1][j - 1]) {
                    cont++;
                  }
                  if (tabBomba[i + 1][j]) {
                    cont++;
                  }
                }
              }
            } else {
              if (i == 0) {
                if ((j > 0) && (j < tabBomba.length - 1)) {
                  if (tabBomba[i][j - 1]) {
                    cont++;
                  }
                  if (tabBomba[i][j + 1]) {
                    cont++;
                  }
                  if (tabBomba[i + 1][j - 1]) {
                    cont++;
                  }
                  if (tabBomba[i + 1][j]) {
                    cont++;
                  }
                  if (tabBomba[i + 1][j + 1]) {
                    cont++;
                  }
                } else {
                  if (j == 0) {
                    if (tabBomba[i][j + 1]) {
                      cont++;
                    }
                    if (tabBomba[i + 1][j]) {
                      cont++;
                    }
                    if (tabBomba[i + 1][j + 1]) {
                      cont++;
                    }
                  } else {
                    if (tabBomba[i][j - 1]) {
                      cont++;
                    }
                    if (tabBomba[i + 1][j - 1]) {
                      cont++;
                    }
                    if (tabBomba[i + 1][j]) {
                      cont++;
                    }
                  }
                }
              } else {
                if ((j > 0) && (j < tabBomba.length - 1)) {
                  if (tabBomba[i - 1][j - 1]) {
                    cont++;
                  }
                  if (tabBomba[i - 1][j]) {
                    cont++;
                  }
                  if (tabBomba[i][j - 1]) {
                    cont++;
                  }
                } else {
                  if (j == 0) {
                    if (tabBomba[i - 1][j]) {
                      cont++;
                    }
                    if (tabBomba[i - 1][j + 1]) {
                      cont++;
                    }
                    if (tabBomba[i][j + 1]) {
                      cont++;
                    }
                  } else {
                    if (tabBomba[i - 1][j - 1]) {
                      cont++;
                    }
                    if (tabBomba[i - 1][j]) {
                      cont++;
                    }
                    if (tabBomba[i][j - 1]) {
                      cont++;
                    }
                  }
                }
              }
            }
            tabNum[i][j] = cont;
            if (cont == 0) {
              tabBi[i][j] = 0;
            } else {
              tabBi[i][j] = 1;
            }
          }
        }

        Algoritmo alg = new Algoritmo(tabBomba, tabNum, tabBi);
        alg.cavarBloco(x, y);

        // Início da partida
        do {
          boolean ganhar = false;
          System.out.println("\n" + numeroColuna + "\n" + linha);
          for (int i = 0; i < alg.getTabelaJogador().length; i++) {
            for (int j = 0; j < alg.getTabelaJogador()[i].length; j++) {
              if (alg.getTabelaJogador()[i][j] != null) {
                if ("   ".equals(alg.getTabelaJogador()[i][j])) {
                  if (alg.getTabelaNumero()[i][j] != 0) {
                    System.out.print("| " + alg.getTabelaNumero()[i][j] + " ");
                  } else {
                    System.out.print("|   ");
                  }
                } else {
                  System.out.print("|" + alg.getTabelaJogador()[i][j]);
                }
              } else {
                System.out.print("|[ ]");
                if (!alg.getTabelaBomba()[i][j]) {
                  ganhar = true;
                }
              }
            }
            System.out.print("| " + i + "\n" + linha + "\n");
          }
          if (ganhar) {
            do {
              System.out.print("-> X: ");
              x = s.nextInt();
              if ((x < 0) || (x > xy)) {
                System.out.println("SISTEMA: Valor inválido!");
              }
            } while ((x < 0) || (x > xy));
            do {
              System.out.print("-> Y: ");
              y = s.nextInt();
              if ((y < 0) || (y > xy)) {
                System.out.println("SISTEMA: Valor inválido!");
              }
            } while ((y < 0) || (y > xy));
            alg.cavarBloco(x, y);
          } else {
            alg.setEncerrarJogo(1);
          }
        } while (alg.getEncerrarJogo() == 0);
        // Fim da partida
        switch (alg.getEncerrarJogo()) {
        case 1:
          System.out.println("SISTEMA: Parabéns! Você concluiu o campo minado!");
          break;
        case 2:
          System.out.println("\n+- LEGENDA\n|+ - Bombas\n+-");
          System.out.println("\n" + numeroColuna + "\n" + linha);
          for (int i = 0; i < alg.getTabelaBomba().length; i++) {
            for (int j = 0; j < alg.getTabelaBomba()[i].length; j++) {
              if (alg.getTabelaBomba()[i][j]) {
                System.out.print("| + ");
              } else {
                System.out.print("|   ");
              }
            }
            System.out.print("| " + i + "\n" + linha + "\n");
          }
          System.out.println("SISTEMA: Game Over!");
          break;
        }
      }
    } while (menu == 1);
  }
}
