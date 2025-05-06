package BOJ_2407;

import java.io.*;
import java.math.BigInteger;
import java.util.*;

public class 조합_민기 {

	//100까지라 101개의 이중 배열 생성
	static BigInteger[][] dp = new BigInteger[101][101];

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());

		// dp 배열 초기화
		for (int i = 0; i <= 100; i++) {
			for (int j = 0; j <= 100; j++) {
				dp[i][j] = BigInteger.valueOf(-1);
			}
		}

		System.out.println(combination(n, m));
	}

	// top-down 방식의 조합 계산
	static BigInteger combination(int n, int r) {
		// 기저 조건
		if (r == 0 || r == n) {
			return BigInteger.ONE;
		}

		// 이미 계산된 값이라면 바로 반환
		if (!dp[n][r].equals(BigInteger.valueOf(-1))) {
			return dp[n][r];
		}

		// 파스칼의 삼각형 1번 성질 활용
		dp[n][r] = combination(n-1, r-1).add(combination(n-1, r));
		return dp[n][r];
	}
}
