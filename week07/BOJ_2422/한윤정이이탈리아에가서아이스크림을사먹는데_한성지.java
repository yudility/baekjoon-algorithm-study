package BOJ_2422;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 한윤정이이탈리아에가서아이스크림을사먹는데_한성지 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());   // 아이스크램 종류
        int M = Integer.parseInt(st.nextToken());   // 불가능한 조합 개수
        int answer = 0;

        boolean[][] checked = new boolean[N + 1][N + 1];    // 불가능한 조합 체크

        // 불가능한 조합 확인
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());

            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            checked[a][b] = true;
            checked[b][a] = true;
        }
    
        // 모든 조합 확인
        for (int i = 1; i <= N; i++) {
            for (int j = i + 1; j <= N; j++) {
                if (!checked[i][j]) {
                    for (int k = j + 1; k <= N; k++) {
                        if (!checked[i][k] && !checked[j][k]) {
                            answer++;
                        }
                    }
                }
            }
        }
        
        System.out.println(answer);
    }
}
