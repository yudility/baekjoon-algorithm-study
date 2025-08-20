package BOJ_1058;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 *https://www.acmicpc.net/problem/1058
 */
public class 친구_연예림 {

    static int MAX = 100;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        int[][] dist = new int[N][N];

        for(int i = 0; i < N; i++) {
            String row = br.readLine();
            for (int j = 0; j < N; j++) {
                if (i == j) {
                    dist[i][j] = 0;
                }else if (row.charAt(j) == 'Y') {
                    dist[i][j] = 1;
                } else {
                    dist[i][j] = MAX;
                }
            }
        }

        for (int k = 0; k < N; k++) {
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    if (dist[i][j] > dist[i][k] + dist[k][j]) {
                        dist[i][j] = dist[i][k] + dist[k][j];
                    }
                }
            }
        }

        int maxFriends = 0;
        for (int i = 0; i < N; i++) {
            int cnt = 0;
            for (int j = 0; j < N; j++) {
                if (i != j && dist[i][j] <= 2) {
                    cnt++;
                }
            }
            maxFriends = Math.max(maxFriends, cnt);
        }

        System.out.println(maxFriends);

    }
}
