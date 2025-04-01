package Old;

public class Algoritmo {

  private String tabelaJogador[][];
  private boolean tabelaBomba[][];
  private int tabelaNumero[][], tabelaBinario[][], encerrarJogo, numX[], numY[];

  public Algoritmo(boolean[][] tabelaBomba, int[][] tabelaNumero, int[][] tabelaBinario) {
    this.tabelaBomba = tabelaBomba;
    this.tabelaNumero = tabelaNumero;
    this.tabelaBinario = tabelaBinario;
    tabelaJogador = new String[tabelaBomba.length][tabelaBomba.length];
    encerrarJogo = 0;
    numX = new int[tabelaBomba.length];
    numY = new int[tabelaBomba.length];
  }

  public void cavarBloco(int x, int y) {
    if (getTabelaBomba()[x][y]) {
      setEncerrarJogo(2);
    } else {
      tabelaJogador[x][y] = "   ";
      if (getTabelaBinario()[x][y] == 0) {
        abrirEspaco(x, y);
      }
    }
  }

  public void abrirEspaco(int i, int j) {
    if ((i > 0) && (i < getTabelaBinario().length - 1)) {
      if ((j > 0) && (j < getTabelaBinario().length - 1)) {
        if (!"   ".equals(getTabelaJogador()[i - 1][j - 1])) {
          if (getTabelaBinario()[i - 1][j - 1] == 0) {
            tabelaJogador[i - 1][j - 1] = "   ";
            abrirEspaco(i - 1, j - 1);
          } else {
            tabelaJogador[i - 1][j - 1] = "   ";
          }
        }
        if (!"   ".equals(getTabelaJogador()[i - 1][j])) {
          if (getTabelaBinario()[i - 1][j] == 0) {
            tabelaJogador[i - 1][j] = "   ";
            abrirEspaco(i - 1, j);
          } else {
            tabelaJogador[i - 1][j] = "   ";
          }
        }
        if (!"   ".equals(getTabelaJogador()[i - 1][j + 1])) {
          if (getTabelaBinario()[i - 1][j + 1] == 0) {
            tabelaJogador[i - 1][j + 1] = "   ";
            abrirEspaco(i - 1, j + 1);
          } else {
            tabelaJogador[i - 1][j + 1] = "   ";
          }
        }
        if (!"   ".equals(getTabelaJogador()[i][j - 1])) {
          if (getTabelaBinario()[i][j - 1] == 0) {
            tabelaJogador[i][j - 1] = "   ";
            abrirEspaco(i, j - 1);
          } else {
            tabelaJogador[i][j - 1] = "   ";
          }
        }
        if (!"   ".equals(getTabelaJogador()[i][j + 1])) {
          if (getTabelaBinario()[i][j + 1] == 0) {
            tabelaJogador[i][j + 1] = "   ";
            abrirEspaco(i, j + 1);
          } else {
            tabelaJogador[i][j + 1] = "   ";
          }
        }
        if (!"   ".equals(getTabelaJogador()[i + 1][j - 1])) {
          if (getTabelaBinario()[i + 1][j - 1] == 0) {
            tabelaJogador[i + 1][j - 1] = "   ";
            abrirEspaco(i + 1, j - 1);
          } else {
            tabelaJogador[i + 1][j - 1] = "   ";
          }
        }
        if (!"   ".equals(getTabelaJogador()[i + 1][j])) {
          if (getTabelaBinario()[i + 1][j] == 0) {
            tabelaJogador[i + 1][j] = "   ";
            abrirEspaco(i + 1, j);
          } else {
            tabelaJogador[i + 1][j] = "   ";
          }
        }
        if (!"   ".equals(getTabelaJogador()[i + 1][j + 1])) {
          if (getTabelaBinario()[i + 1][j + 1] == 0) {
            tabelaJogador[i + 1][j + 1] = "   ";
            abrirEspaco(i + 1, j + 1);
          } else {
            tabelaJogador[i + 1][j + 1] = "   ";
          }
        }
      } else {
        if (j == 0) {
          if (!"   ".equals(getTabelaJogador()[i - 1][j])) {
            if (getTabelaBinario()[i - 1][j] == 0) {
              abrirEspaco(i - 1, j);
            } else {
              tabelaJogador[i - 1][j] = "   ";
            }

          }
          if (!"   ".equals(getTabelaJogador()[i - 1][j + 1])) {
            if (getTabelaBinario()[i - 1][j + 1] == 0) {
              tabelaJogador[i - 1][j + 1] = "   ";
              abrirEspaco(i - 1, j + 1);
            } else {
              tabelaJogador[i - 1][j + 1] = "   ";
            }

          }
          if (!"   ".equals(getTabelaJogador()[i][j + 1])) {
            if (getTabelaBinario()[i][j + 1] == 0) {
              tabelaJogador[i][j + 1] = "   ";
              abrirEspaco(i, j + 1);
            } else {
              tabelaJogador[i][j + 1] = "   ";
            }
          }
          if (!"   ".equals(getTabelaJogador()[i + 1][j])) {
            if (getTabelaBinario()[i + 1][j] == 0) {
              tabelaJogador[i + 1][j] = "   ";
              abrirEspaco(i + 1, j);
            } else {
              tabelaJogador[i + 1][j] = "   ";
            }
          }
          if (!"   ".equals(getTabelaJogador()[i + 1][j + 1])) {
            if (getTabelaBinario()[i + 1][j + 1] == 0) {
              tabelaJogador[i + 1][j + 1] = "   ";
              abrirEspaco(i + 1, j + 1);
            } else {
              tabelaJogador[i + 1][j + 1] = "   ";
            }
          }

        } else {
          if (!"   ".equals(getTabelaJogador()[i - 1][j - 1])) {
            if (getTabelaBinario()[i - 1][j - 1] == 0) {
              tabelaJogador[i - 1][j - 1] = "   ";
              abrirEspaco(i - 1, j - 1);
            } else {
              tabelaJogador[i - 1][j - 1] = "   ";
            }
          }
          if (!"   ".equals(getTabelaJogador()[i - 1][j])) {
            if (getTabelaBinario()[i - 1][j] == 0) {
              tabelaJogador[i - 1][j] = "   ";
              abrirEspaco(i - 1, j);
            } else {
              tabelaJogador[i - 1][j] = "   ";
            }
          }
          if (!"   ".equals(getTabelaJogador()[i][j - 1])) {
            if (getTabelaBinario()[i][j - 1] == 0) {
              tabelaJogador[i][j - 1] = "   ";
              abrirEspaco(i, j - 1);
            } else {
              tabelaJogador[i][j - 1] = "   ";
            }
          }
          if (!"   ".equals(getTabelaJogador()[i + 1][j - 1])) {
            if (getTabelaBinario()[i + 1][j - 1] == 0) {
              tabelaJogador[i + 1][j - 1] = "   ";
              abrirEspaco(i + 1, j - 1);
            } else {
              tabelaJogador[i + 1][j - 1] = "   ";
            }
          }
          if (!"   ".equals(getTabelaJogador()[i + 1][j])) {
            if (getTabelaBinario()[i + 1][j] == 0) {
              tabelaJogador[i + 1][j] = "   ";
              abrirEspaco(i + 1, j);
            } else {
              tabelaJogador[i + 1][j] = "   ";
            }
          }
        }
      }
    } else {
      if (i == 0) {
        if ((j > 0) && (j < getTabelaBinario().length - 1)) {
          if (!"   ".equals(getTabelaJogador()[i][j - 1])) {
            if (getTabelaBinario()[i][j - 1] == 0) {
              tabelaJogador[i][j - 1] = "   ";
              abrirEspaco(i, j - 1);
            } else {
              tabelaJogador[i][j - 1] = "   ";
            }
          }
          if (!"   ".equals(getTabelaJogador()[i][j + 1])) {
            if (getTabelaBinario()[i][j + 1] == 0) {
              tabelaJogador[i][j + 1] = "   ";
              abrirEspaco(i, j + 1);
            } else {
              tabelaJogador[i][j + 1] = "   ";
            }
          }
          if (!"   ".equals(getTabelaJogador()[i + 1][j - 1])) {
            if (getTabelaBinario()[i + 1][j - 1] == 0) {
              tabelaJogador[i + 1][j - 1] = "   ";
              abrirEspaco(i + 1, j - 1);
            } else {
              tabelaJogador[i + 1][j - 1] = "   ";
            }
          }
          if (!"   ".equals(getTabelaJogador()[i + 1][j])) {
            if (getTabelaBinario()[i + 1][j] == 0) {
              tabelaJogador[i + 1][j] = "   ";
              abrirEspaco(i + 1, j);
            } else {
              tabelaJogador[i + 1][j] = "   ";
            }
          }
          if (!"   ".equals(getTabelaJogador()[i + 1][j + 1])) {
            if (getTabelaBinario()[i + 1][j + 1] == 0) {
              tabelaJogador[i + 1][j + 1] = "   ";
              abrirEspaco(i + 1, j + 1);
            } else {
              tabelaJogador[i + 1][j + 1] = "   ";
            }
          }
        } else {
          if (j == 0) {
            if (!"   ".equals(getTabelaJogador()[i][j + 1])) {
              if (getTabelaBinario()[i][j + 1] == 0) {
                tabelaJogador[i][j + 1] = "   ";
                abrirEspaco(i, j + 1);
              } else {
                tabelaJogador[i][j + 1] = "   ";
              }
            }
            if (!"   ".equals(getTabelaJogador()[i + 1][j])) {
              if (getTabelaBinario()[i + 1][j] == 0) {
                tabelaJogador[i + 1][j] = "   ";
                abrirEspaco(i + 1, j);
              } else {
                tabelaJogador[i + 1][j] = "   ";
              }
            }
            if (!"   ".equals(getTabelaJogador()[i + 1][j + 1])) {
              if (getTabelaBinario()[i + 1][j + 1] == 0) {
                tabelaJogador[i + 1][j + 1] = "   ";
                abrirEspaco(i + 1, j + 1);
              } else {
                tabelaJogador[i + 1][j + 1] = "   ";
              }
            }
          } else {
            if (!"   ".equals(getTabelaJogador()[i][j - 1])) {
              if (getTabelaBinario()[i][j - 1] == 0) {
                tabelaJogador[i][j - 1] = "   ";
                abrirEspaco(i, j - 1);
              } else {
                tabelaJogador[i][j - 1] = "   ";
              }
            }
            if (!"   ".equals(getTabelaJogador()[i + 1][j - 1])) {
              if (getTabelaBinario()[i + 1][j - 1] == 0) {
                tabelaJogador[i + 1][j - 1] = "   ";
                abrirEspaco(i + 1, j - 1);
              } else {
                tabelaJogador[i + 1][j - 1] = "   ";
              }
            }
            if (!"   ".equals(getTabelaJogador()[i + 1][j])) {
              if (getTabelaBinario()[i + 1][j] == 0) {
                tabelaJogador[i + 1][j] = "   ";
                abrirEspaco(i + 1, j);
              } else {
                tabelaJogador[i + 1][j] = "   ";
              }
            }
          }
        }
      } else {
        if ((j > 0) && (j < getTabelaBinario().length - 1)) {
          if (!"   ".equals(getTabelaJogador()[i - 1][j - 1])) {
            if (getTabelaBinario()[i - 1][j - 1] == 0) {
              tabelaJogador[i - 1][j - 1] = "   ";
              abrirEspaco(i - 1, j - 1);
            } else {
              tabelaJogador[i - 1][j - 1] = "   ";
            }
          }
          if (!"   ".equals(getTabelaJogador()[i - 1][j])) {
            if (getTabelaBinario()[i - 1][j] == 0) {
              tabelaJogador[i - 1][j] = "   ";
              abrirEspaco(i - 1, j);
            } else {
              tabelaJogador[i - 1][j] = "   ";
            }
          }
          if (!"   ".equals(getTabelaJogador()[i][j - 1])) {
            if (getTabelaBinario()[i][j - 1] == 0) {
              tabelaJogador[i][j - 1] = "   ";
              abrirEspaco(i, j - 1);
            } else {
              tabelaJogador[i][j - 1] = "   ";
            }
          }
        } else {
          if (j == 0) {
            if (!"   ".equals(getTabelaJogador()[i - 1][j])) {
              if (getTabelaBinario()[i - 1][j] == 0) {
                tabelaJogador[i - 1][j] = "   ";
                abrirEspaco(i - 1, j);
              } else {
                tabelaJogador[i - 1][j] = "   ";
              }
            }
            if (!"   ".equals(getTabelaJogador()[i - 1][j + 1])) {
              if (getTabelaBinario()[i - 1][j + 1] == 0) {
                tabelaJogador[i - 1][j + 1] = "   ";
                abrirEspaco(i - 1, j + 1);
              } else {
                tabelaJogador[i - 1][j + 1] = "   ";
              }
            }
            if (!"   ".equals(getTabelaJogador()[i][j + 1])) {
              if (getTabelaBinario()[i][j + 1] == 0) {
                tabelaJogador[i][j + 1] = "   ";
                abrirEspaco(i, j + 1);
              } else {
                tabelaJogador[i][j + 1] = "   ";
              }
            }
          } else {
            if (!"   ".equals(getTabelaJogador()[i - 1][j - 1])) {
              if (getTabelaBinario()[i - 1][j - 1] == 0) {
                tabelaJogador[i - 1][j - 1] = "   ";
                abrirEspaco(i - 1, j - 1);
              } else {
                tabelaJogador[i - 1][j - 1] = "   ";
              }
            }
            if (!"   ".equals(getTabelaJogador()[i - 1][j])) {
              if (getTabelaBinario()[i - 1][j] == 0) {
                tabelaJogador[i - 1][j] = "   ";
                abrirEspaco(i - 1, j);
              } else {
                tabelaJogador[i - 1][j] = "   ";
              }
            }
            if (!"   ".equals(getTabelaJogador()[i][j - 1])) {
              if (getTabelaBinario()[i][j - 1] == 0) {
                tabelaJogador[i][j - 1] = "   ";
                abrirEspaco(i, j - 1);
              } else {
                tabelaJogador[i][j - 1] = "   ";
              }
            }
          }
        }
      }
    }
  }

  public String[][] getTabelaJogador() {
    return tabelaJogador;
  }

  public void setTabelaJogador(String[][] tabelaJogador) {
    this.tabelaJogador = tabelaJogador;
  }

  public boolean[][] getTabelaBomba() {
    return tabelaBomba;
  }

  public void setTabelaBomba(boolean[][] tabelaBomba) {
    this.tabelaBomba = tabelaBomba;
  }

  public int[][] getTabelaNumero() {
    return tabelaNumero;
  }

  public void setTabelaNumero(int[][] tabelaNumero) {
    this.tabelaNumero = tabelaNumero;
  }

  public int[][] getTabelaBinario() {
    return tabelaBinario;
  }

  public void setTabelaBinario(int[][] tabelaBinario) {
    this.tabelaBinario = tabelaBinario;
  }

  public int getEncerrarJogo() {
    return encerrarJogo;
  }

  public void setEncerrarJogo(int encerrarJogo) {
    this.encerrarJogo = encerrarJogo;
  }

  public int[] getNumX() {
    return numX;
  }

  public void setNumX(int[] numX) {
    this.numX = numX;
  }

  public int[] getNumY() {
    return numY;
  }

  public void setNumY(int[] numY) {
    this.numY = numY;
  }
}
