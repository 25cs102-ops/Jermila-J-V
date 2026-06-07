import java.util.*;

public class DynamicProgrammingColumn {
    static int maxSum = Integer.MIN_VALUE;

    // Recursive function to find maximum sum column-wise
    static void solve(int[][] a, int col, boolean[] used, int sum) {
        int n = a.length;

        // Base case: all columns processed
        if (col == n) {
            maxSum = Math.max(maxSum, sum);
            return;
        }

        // Try each row in the current column
        for (int row = 0; row < n; row++) {
            if (!used[row]) {
                used[row] = true; // mark row used
                solve(a, col + 1, used, sum + a[row][col]);
                used[row] = false; // backtrack
            }
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[][] a = new int[n][n];

        // Input matrix
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                a[i][j] = sc.nextInt();
            }
        }

        boolean[] used = new boolean[n];
        solve(a, 0, used, 0);
        System.out.println(maxSum);
    }
}
