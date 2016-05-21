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

  public static void main(String[] args) {
    int[][] matrix1 = {{10, 11, 12}, {13, 14, 15}, {16, 17, 18}, {19, 20, 21}};
    printMatrix(matrix1);
    int[][] matrix2 = transpose(matrix1);
    printMatrix(matrix2);
    int[][] matrix3 = rotate90(matrix1);
    printMatrix(matrix3);
  }
}
