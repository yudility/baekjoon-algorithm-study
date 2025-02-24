package BOJ_21919;

import java.util.*;
import java.io.*;

public class 소수최소공배수_민기 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		Map<Integer, Integer> primeCount = new HashMap<>();  // 소수와 그 등장 횟수를 저장
		long result = 1;

		for (int i = 0; i < N; i++) {
			int num = Integer.parseInt(st.nextToken());
			boolean isPrime = true;

			if(num < 2) isPrime = false;
			for(int j = 2; j * j <= num; j++) {
				if(num % j == 0) {
					isPrime = false;
					break;
				}
			}

			if(isPrime) {
				primeCount.put(num, 1);  // 소수 등장 기록 중복이 되면 안되니 무조건 1로 지정해서 중복 제거
			}
		}

		if(primeCount.isEmpty()) {
			System.out.println(-1);
		} else {
			for(int prime : primeCount.keySet()) {
				result *= prime;
			}
			System.out.println(result);
		}
	}
}
