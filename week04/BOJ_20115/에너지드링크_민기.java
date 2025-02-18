package BOJ_20115;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class 에너지드링크_민기 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		// 첫 번째 줄에서 N을 입력받음
		int N = Integer.parseInt(br.readLine());

		// 두 번째 줄의 에너지 드링크 양을 입력받음
		StringTokenizer st = new StringTokenizer(br.readLine());

		//각 에너지드링크를 정렬하는게 좋을것 같아 priorityQueue 사용
		PriorityQueue<Double> pq = new PriorityQueue<>(Collections.reverseOrder());

		// N번 만큼 반복하여 입력받음
		for (int i = 0; i < N; i++) {
			pq.add(Double.parseDouble(st.nextToken()));
		}

		//가장 작은 용량의 드링크를 꺼내서 초기값으로 넣는다
		double maxDrink = pq.poll();

		//현재 가지고 있는 양에 다음으로 작은 에너지 드링크의 절반을 더하면서 진행
		while(!pq.isEmpty()) {
			maxDrink += pq.poll() / 2;
		}

		System.out.println(maxDrink);
	}
}