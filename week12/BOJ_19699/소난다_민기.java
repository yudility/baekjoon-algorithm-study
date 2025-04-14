package BOJ_19699;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class 소난다_민기 {
	static int N, M;
	static HashSet<Integer> hs = new HashSet<>(); // 중복 방지용 HashSet
	static ArrayList<Integer> cows = new ArrayList<>(); // 소들의 몸무게 리스트

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken()); // 소의 수
		M = Integer.parseInt(st.nextToken()); // 선택할 소의 수

		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			cows.add(Integer.parseInt(st.nextToken())); // 소들의 몸무게 저장
		}

		// 백트래킹을 이용해 M마리의 소를 선택하고 합이 소수인 경우 저장
		combi(0, 0, 0);

		// 결과 출력
		if (hs.isEmpty()) {
			System.out.println(-1);
		} else {
			ArrayList<Integer> result = new ArrayList<>(hs);
			Collections.sort(result);

			// 공백 없이 출력 처리
			for (int i = 0; i < result.size(); i++) {
				if (i > 0) System.out.print(" ");
				System.out.print(result.get(i));
			}
			System.out.println();
		}
	}

	// 백트래킹을 이용한 조합 생성
	static void combi(int idx, int cnt, int sum) {
		if (cnt == M) { // M마리를 선택한 경우
			if (isPrime(sum)) { // 합이 소수라면 저장
				hs.add(sum);
			}
			return;
		}

		// idx부터 N까지 반복하며, 각 소를 하나씩 선택
		// i가 idx부터 시작하는 이유는 중복을 방지하고 순서를 유지하기 위함
		for (int i = idx; i < N; i++) {
			combi(i + 1, cnt + 1, sum + cows.get(i)); // 다음 소 선택
		}
	}

	// 소수 판별 함수
	static boolean isPrime(int num) {
		if (num < 2) return false;
		for (int i = 2; i * i <= num; i++) {
			if (num % i == 0) return false;
		}
		return true;
	}
}
