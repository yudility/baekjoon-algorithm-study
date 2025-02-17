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

		PriorityQueue<Double> pq = new PriorityQueue<>();

		for (int i = 0; i < st.countTokens(); i++) {
			pq.add(Double.parseDouble(st.nextToken()));
		}

		double maxDrink = pq.poll();

		while(!pq.isEmpty()) {
			maxDrink += pq.poll() / 2;
		}

		System.out.println(maxDrink);
	}
}
