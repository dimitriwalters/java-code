public class Search {
  // just for debug
  public static void printCharMatrix(char[][] matrix) {
    for (int row=0; row<matrix.length; row++) {
      for (int col=0; col<matrix[row].length; col++) {
        System.out.print(matrix[row][col] + " ");
      }
      System.out.println();
    }
  }

  public static void searchWord(String word, char[][] matrix) {
    for (int row=0; row<matrix.length; row++) {
      for (int col=0; col<matrix[row].length; col++) {
        if (searchWordHelper(word, matrix, row, col)) {
          System.out.println("Word in matrix");
          return;
        }
      }
    }
    System.out.println("Word not in matrix");
  }

  public static boolean searchWordHelper(String word, char[][] matrix, int i, int j) {
    if (word.length() == 0) return true;
    if (i < 0 || i >= matrix.length) return false;
    if (j < 0 || j >= matrix[0].length) return false;
    if (word.charAt(0) != matrix[i][j]) return false;
    matrix[i][j] = '#';
    word = word.substring(1);
    return (
      searchWordHelper(word, matrix, i, j+1)
      || searchWordHelper(word, matrix, i+1, j)
      || searchWordHelper(word, matrix, i, j-1)
      || searchWordHelper(word, matrix, i-1, j)
    );
  }

  public static void main(String[] args) {
    char[][] matrix = {{'a', 'b', 'c'}, {'d', 'e', 'f'}, {'g', 'h', 'i'}};
    searchWord("bad", matrix);
  }
}
