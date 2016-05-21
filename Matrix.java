public class Matrix {
  public static void printMatrix(int[][] matrix) {
    System.out.println("Matrix output:");
    for (int row=0; row<matrix.length; row++) {
      for (int column=0; column<matrix[row].length; column++) {
        System.out.print(matrix[row][column] + " ");
      }
      System.out.println();
    }
  }

  public static int[][] copyMatrix(int[][] matrix) {
    int[][] newMatrix = new int[matrix.length][];
    for (int row=0; row<matrix.length; row++) {
      newMatrix[row] = new int[matrix[row].length];
      for (int column=0; column<matrix[row].length; column++) {
        newMatrix[row][column] = matrix[row][column];
      }
    }
    return newMatrix;
  }

  public static int[][] transpose(int[][] matrix) {
    int[][] newMatrix = new int[matrix[0].length][matrix.length];
    for (int row=0; row<matrix.length; row++) {
      for (int column=0; column<matrix[0].length; column++) {
        newMatrix[column][row] = matrix[row][column];
      }
    }
    return newMatrix;
  }

  public static int[][] rotate90(int[][] matrix) {
    int[][] newMatrix = new int[matrix[0].length][matrix.length];
    for (int row=0; row<matrix.length; row++) {
      for (int column=0; column<matrix[0].length; column++) {
        newMatrix[column][matrix.length - 1 - row] = matrix[row][column];
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
