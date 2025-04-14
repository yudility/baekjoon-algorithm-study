package BOJ_21919;

import java.util.*;
import java.io.*;

public class 소수최소공배수_민기 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());

		// 소수와 그 등장 횟수를 저장할 HashMap 생성
		// 키: 소수, 값: 등장 횟수 (여기서는 항상 1)
		Map<Integer, Integer> primeCount = new HashMap<>();

		// 최종 결과값을 저장할 변수 (소수들의 곱)
		// long 타입으로 선언하여 큰 수를 처리할 수 있게 함
		long result = 1;

		// N개의 정수를 순회하며 소수인지 확인
		for (int i = 0; i < N; i++) {
			// 현재 정수 파싱
			int num = Integer.parseInt(st.nextToken());

			// 소수 여부를 판단하는 플래그, 초기값은 true(소수라고 가정)
			boolean isPrime = true;

			// 2보다 작은 수는 소수가 아님
			if(num < 2) isPrime = false;

			// 2부터 num의 제곱근까지 순회하며 소수 판별
			// 제곱근까지만 확인해도 소수 판별 가능 (최적화)
			for(int j = 2; j * j <= num; j++) {
				// 나누어 떨어지면 소수가 아님
				if(num % j == 0) {
					isPrime = false;
					break;  // 더 이상 확인할 필요 없음
				}
			}

			// 소수로 판별된 경우 HashMap에 추가
			if(isPrime) {
				// 소수는 중복을 허용하지 않고, 각 소수는 한 번만 곱해야 하므로 값을 1로 설정
				// 이렇게 하면 같은 소수가 여러 번 등장해도 한 번만 계산됨
				primeCount.put(num, 1);
			}
		}

		// 소수가 하나도 없는 경우
		if(primeCount.isEmpty()) {
			System.out.println(-1);  // -1 출력
		} else {
			// 모든 소수를 곱하여 최소공배수 계산
			for(int prime : primeCount.keySet()) {
				result *= prime;  // 각 소수를 결과값에 곱함
			}
			System.out.println(result);  // 최종 결과 출력
		}
	}
}
