import java.util.*;

public class Fact {
  public static void main (String[] args) {
    int num, res;
    Scanner input = new Scanner(System.in);
    while (true) {
      num = input.nextInt();
      res = 1;
      for (int i=1; i<=num; i++) {
        res *= i;
      }
      System.out.println(String.format("Factorial of %d is %d", num, res));
    }
  }
}
