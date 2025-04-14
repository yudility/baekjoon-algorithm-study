package BOJ_11399;

import java.util.*;
import java.io.*;

public class ATM_민기 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		// 사람 수 N 입력받기
		int N = Integer.parseInt(br.readLine());

		// 최종 결과를 저장할 변수 (모든 사람이 기다린 총 시간)
		int result = 0;

		// 최소 시간 순으로 정렬하기 위해 우선순위 큐(최소 힙) 사용
		PriorityQueue<Integer> pq = new PriorityQueue<>();

		// 두 번째 줄의 Pi 값을 읽어서 우선순위 큐에 삽입 (자동 정렬됨)
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			pq.offer(Integer.parseInt(st.nextToken()));
		}

		// 오름차순 정렬된 대기 시간을 저장할 리스트
		List<Integer> list = new ArrayList<>();

		// 우선순위 큐에서 하나씩 꺼내 리스트에 저장 (최소값부터 순서대로 정렬됨)
		while (!pq.isEmpty()) {
			list.add(pq.poll());
		}

		/*
		 * list = pq.stream().toList(); 를 사용하면 실패하는 이유:
		 *  - PriorityQueue의 stream()은 요소를 순서대로 반환할 것을 보장하지 않음.
		 *  - 따라서 우선순위 큐에서 직접 poll()하여 리스트에 저장하는 과정이 필요함.
		 */
		// 누적 합을 계산하여 최소 대기 시간을 구하는 과정
		for (int i = 0; i < N; i++) {
			for (int j = 0; j <= i; j++) {
				result += list.get(j); // i번째 사람이 기다리는 총 시간 계산
			}
		}

		// 최솟값 출력
		System.out.println(result);

	}
}
