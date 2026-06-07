import java.util.*;

public class MaxRowSum {
    static int maxSum = Integer.MIN_VALUE;

    // Recursive function to find maximum sum
    static void findMax(int[][] a, int row, boolean[] used, int sum) {
        int n = a.length;

        // Base case: all rows processed
        if (row == n) {
            maxSum = Math.max(maxSum, sum);
            return;
        }

        // Try each column in the current row
        for (int col = 0; col < n; col++) {
            if (!used[col]) {
                used[col] = true; // mark column used
                findMax(a, row + 1, used, sum + a[row][col]);
                used[col] = false; // backtrack
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
        findMax(a, 0, used, 0);
        System.out.println(maxSum);
    }
}
