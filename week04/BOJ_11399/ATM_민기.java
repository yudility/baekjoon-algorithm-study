package BOJ_11399;

import java.util.*;
import java.io.*;

public class ATM_민기 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int result = 0;
		PriorityQueue<Integer> pq = new PriorityQueue<>();

		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i=0;i<N;i++) {
			pq.offer(Integer.parseInt(st.nextToken()));
		}

		List<Integer> list = new ArrayList<>();
		while(!pq.isEmpty()) {
			list.add(pq.poll());
		}

		//이거로 하면 순서 보장이 되지 않아 1,2,4,3,3으로 저장되어 실패
		//list = pq.stream().toList();

		for (int i=0;i<N;i++) {
			for (int j = 0; j <= i; j++) {
				result += list.get(j);
			}
		}
		System.out.println(result);

	}
}
