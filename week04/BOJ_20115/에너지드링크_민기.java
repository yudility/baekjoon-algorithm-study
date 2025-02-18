package BOJ_20115;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class 에너지드링크_민기 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		//각 에너지드링크를 정렬하는게 좋을것 같아 priorityQueue 사용
		PriorityQueue<Double> pq = new PriorityQueue<>();

		for (int i = 0; i < st.countTokens(); i++) {
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
