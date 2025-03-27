import java.util.Scanner;

public class Nqueens1 {
    private static int[] x; 

    public static boolean Place(int k, int i) {
        for (int j = 1; j < k; j++) {
            if (x[j] == i || Math.abs(x[j] - i) == Math.abs(j - k)) {
                return false;
            }
        }
        return true;
    }

    public static void nqueens(int k, int n) {
        if (k > n) {
            for (int i = 1; i <= n; i++) {
                System.out.print(x[i] + " ");
            }
            System.out.println();
        } else {
            for (int i = 1; i <= n; i++) {
                if (Place(k, i)) {
                    x[k] = i;
                    nqueens(k + 1, n);
                }
            }
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the number of queens: ");
        int n = sc.nextInt();
        sc.close();

        x = new int[n + 1];
        nqueens(1, n);
    }
}
