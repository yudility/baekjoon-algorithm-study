package BOJ_2839;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class 설탕배달_민기 {
	static int memo[];
	static int max=5001;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		memo = new int[N + 1];
		Arrays.fill(memo, -1);

		int result = dp(N);

		//만약 -1인 경우 생각
		System.out.println(result >= max ? -1 : result);
	}

	//bottom-up..?
	static int dp(int N) {
		//만약 N이 재귀를 통해 0을 만들었다면 또는 N<0이 된 경우
		if (N == 0) {
			return 0;
		}
		//음수가 되는 경우 max반환
		if(N<0){
			return max;
		}
		//이미 memo를 통해 계산을 한적이 있다면...?
		if (memo[N] != -1) {
			return memo[N];
		}

		// 3,5kg를 각각 배면서 재귀를 호출
		int from3 = dp(N - 3);
		int from5 = dp(N - 5);

		//지금까지 사용된 봉지 개수를 추가해야돼서 +1을 진행
		memo[N] = Math.min(from3+1, from5+1);

		return memo[N];
	}
}
