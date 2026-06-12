import java.util.*;

public class Main {
    static final int MAX_TEMP = 200005;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int k = sc.nextInt();
        int q = sc.nextInt();

        int[] diff = new int[MAX_TEMP + 2];

        // Process intervals
        for (int i = 0; i < n; i++) {
            int l = sc.nextInt();
            int r = sc.nextInt();
            diff[l]++;
            diff[r + 1]--;
        }

        int[] prefAdmissible = new int[MAX_TEMP + 2];
        int currentRecipes = 0;

        // Build prefix sums of admissible counts
        for (int i = 1; i <= MAX_TEMP; i++) {
            currentRecipes += diff[i];
            int isAdmissible = (currentRecipes >= k) ? 1 : 0;
            prefAdmissible[i] = prefAdmissible[i - 1] + isAdmissible;
        }

        // Answer queries
        for (int i = 0; i < q; i++) {
            int a = sc.nextInt();
            int b = sc.nextInt();
            System.out.println(prefAdmissible[b] - prefAdmissible[a - 1]);
        }

        sc.close();
    }
}
