package Refatorado;

public class MatrizUtil {

  @FunctionalInterface
  public interface CallbackIterateAround {
    void handler(int x, int y);
  }

  public static void iterateAround(byte[][] matriz, int x, int y, CallbackIterateAround callback) {
    int lengthX = matriz.length;
    int lengthY = matriz.length > 0 ? matriz[0].length : 0;

    iterateAround(lengthX, lengthY, x, y, callback);
  }

  public static void iterateAround(int lengthX, int lengthY, int x, int y, CallbackIterateAround callback) {
    for (int offsetX = -1; offsetX <= 1; offsetX++) {
      for (int offsetY = -1; offsetY <= 1; offsetY++) {
        if (offsetX == 0 && offsetY == offsetX) {
          continue;
        }

        int matrizX = x + offsetX;
        int matrizY = y + offsetY;

        if (matrizX < 0 || matrizY < 0 || matrizX >= lengthX || matrizY >= lengthY) {
          continue;
        }

        callback.handler(matrizX, matrizY);
      }
    }
  }
}
