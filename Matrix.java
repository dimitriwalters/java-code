public class Matrix {
  public static void printMatrix(int[][] matrix) {
    System.out.println("Matrix output:");
    for (int row=0; row<matrix.length; row++) {
      for (int col=0; col<matrix[row].length; col++) {
        System.out.print(matrix[row][col] + " ");
      }
      System.out.println();
    }
  }

  public static int[][] copyMatrix(int[][] matrix) {
    int[][] newMatrix = new int[matrix.length][];
    for (int row=0; row<matrix.length; row++) {
      newMatrix[row] = new int[matrix[row].length];
      for (int col=0; col<matrix[row].length; col++) {
        newMatrix[row][col] = matrix[row][col];
      }
    }
    return newMatrix;
  }

  public static int[][] transpose(int[][] matrix) {
    int[][] newMatrix = new int[matrix[0].length][matrix.length];
    for (int row=0; row<matrix.length; row++) {
      for (int col=0; col<matrix[0].length; col++) {
        newMatrix[col][row] = matrix[row][col];
      }
    }
    return newMatrix;
  }

  public static int[][] rotate(int[][] matrix) {
    int[][] newMatrix = new int[matrix[0].length][matrix.length];
    for (int row=0; row<matrix.length; row++) {
      for (int col=0; col<matrix[0].length; col++) {
        newMatrix[col][matrix.length - 1 - row] = matrix[row][col];
      }
    }
    return newMatrix;
  }

  // in-place
  public static void reverseRows(int[][] matrix) {
    for (int row=0; row<matrix.length; row++) {
      for (int col=0; col<matrix[0].length/2; col++) {
        int temp = matrix[row][col];
        matrix[row][col] = matrix[row][matrix[0].length - 1 - col];
        matrix[row][matrix[0].length - 1 - col] = temp;
      }
    }
  }

  // in-place (N x N matrix)
  public static void transposeInPlace(int[][] matrix) {
    for (int row=0; row<matrix.length; row++) {
      for (int col=row+1; col<matrix.length; col++) {
        int temp = matrix[row][col];
        matrix[row][col] = matrix[col][row];
        matrix[col][row] = temp;
      }
    }
  }

  // in-place (N x N matrix)
  public static void rotateInPlace(int[][] matrix) {
    // method 1
    // transposeInPlace(matrix);
    // reverseRows(matrix);

    // method 2
    int n = matrix.length;
    for (int layer=0; layer<n/2; layer++) {
      int first = layer;
      int last = n - 1 - layer;
      for (int i=first; i<last; i++) {
        int top = matrix[first][i];
        int right = matrix[i][last];
        int bottom = matrix[last][last - i];
        int left = matrix[last - i][first];
        matrix[first][i] = left;
        matrix[i][last] = top;
        matrix[last][last - i] = right;
        matrix[last - i][first] = bottom;
      }
    }
  }

  public static void main(String[] args) {
    int[][] matrix1 = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
    printMatrix(matrix1);
    rotateInPlace(matrix1);
    printMatrix(matrix1);
  }
}
