package BOJ_2422;

import java.util.Scanner;

public class 한윤정_김준우 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();

        boolean[][] restricted = new boolean[n + 1][n + 1];

        for (int i = 0; i < m; i++) {
            int x = sc.nextInt();
            int y = sc.nextInt();

            restricted[x][y] = true;
            restricted[y][x] = true;
        }

        int count = 0;
        for (int i = 1; i <= n; i++) {
            for (int j = i + 1; j <= n ; j++) {
                if (restricted[i][j]) continue;
                for (int k = j + 1; k <= n; k++) {
                    if (!restricted[j][k] && !restricted[k][i]) count++;
                }
            }
        }
        System.out.println(count);
    }
}
