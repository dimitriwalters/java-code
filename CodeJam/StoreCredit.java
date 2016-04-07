import java.util.*;

public class StoreCredit {
  public static void main(String[] args) {
    int N, C, I, done;
    int[] P;
    Scanner input = new Scanner(System.in);
    N = input.nextInt();
    for (int n=0; n<N; n++) {
      C = input.nextInt();
      I = input.nextInt();
      P = new int[I];
      for (int i=0; i<I; i++) {
        P[i] = input.nextInt();
      }
      done = 0;
      for (int i1=0; i1<I; i1++) {
        for (int i2=i1; i2<I; i2++) {
          if ((P[i1] + P[i2]) == C && i1 != i2) {
            System.out.println(String.format("Case #%d: %d %d", n+1, i1+1, i2+1));
            done = 1;
            break;
          }
        }
        if (done == 1) break;
      }
    }
  }
}
