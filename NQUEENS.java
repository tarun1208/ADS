import java.util.*;
public class NQueens {
    static int[] x;
   public static boolean isplace(int k, int i) {
        for (int j = 1; j < k; j++) {
            if (x[j] == i || Math.abs(x[j] - i) == Math.abs(j - k)) {
                return false;
            }
        }
        return true; 
    }
   public static void NQueens(int k, int n) {
        if (k > n) {
            for (int i = 1; i <= n; i++)
                System.out.print(x[i] + " ");
            System.out.println();
            return;
        }
       for (int i = 1; i <= n; i++) {
            if (isplace(k, i)) {
                x[k] = i;
                NQueens(k + 1, n); 
            }
        }
    }
   public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the number of Queens: ");
        int n = sc.nextInt();
        x = new int[n + 1]; 
        System.out.println("Solutions:");
        NQueens(1, n);
        sc.close();
    }
}
