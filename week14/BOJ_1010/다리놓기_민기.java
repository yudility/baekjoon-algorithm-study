package BOJ_1010;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 다리놓기_민기 {
	static int[][] dp = new int[30][30];
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int T = Integer.parseInt(br.readLine());

		StringTokenizer st;
		StringBuilder sb = new StringBuilder();

		//파스칼의 삼각형 2번 성질 이용 (n == r, r == 0)
		for (int i = 0; i < 30; i++) {
			dp[i][i]=1;
			dp[i][0]=1;
		}

		//파스칼의 삼각형 1번 성질
		for (int i = 2; i < 30; i++) {
			for (int j = 1; j < 30; j++) {
				dp[i][j] = dp[i - 1][j - 1] + dp[i - 1][j];
			}
		}

		//Bottom Up방식으로 문제 풀이
		for (int i = 0; i < T; i++) {
			st = new StringTokenizer(br.readLine(), " ");

			int N = Integer.parseInt(st.nextToken());
			int M = Integer.parseInt(st.nextToken());

			sb.append(dp[M][N]).append('\n');
		}

		System.out.println(sb);
	}
}

