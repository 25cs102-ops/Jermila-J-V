import java.util.*;

public class TwoDigitString {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String a = sc.next();
        String b = sc.next();

        int r = a.length();
        int c = b.length();

        int[] pa = new int[r + 1];
        int[] pb = new int[c + 1];

        for (int i = 1; i <= r; i++) {
            pa[i] = (pa[i - 1] + (a.charAt(i - 1) - '0')) % 10;
        }

        for (int i = 1; i <= c; i++) {
            pb[i] = (pb[i - 1] + (b.charAt(i - 1) - '0')) % 10;
        }

        if (pa[r] != pb[c]) {
            System.out.println(-1);
            return;
        }

        int[][] dp = new int[r + 1][c + 1];

        for (int row = 1; row <= r; row++) {
            for (int col = 1; col <= c; col++) {
                if (pa[row] == pb[col])
                    dp[row][col] = 1 + dp[row - 1][col - 1];
                else
                    dp[row][col] = Math.max(dp[row - 1][col], dp[row][col - 1]);
            }
        }

        System.out.println(dp[r][c]);

        sc.close();
    }
}