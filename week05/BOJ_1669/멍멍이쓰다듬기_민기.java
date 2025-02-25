package BOJ_1669;


import java.io.*;
import java.util.StringTokenizer;

public class 멍멍이쓰다듬기_민기 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int X = Integer.parseInt(st.nextToken());  // 원숭이 키
		int Y = Integer.parseInt(st.nextToken());  // 멍멍이 키
		int D = Y - X;  // 키 차이

		if (D <= 3) {
			System.out.println(D);
		} else {
			int n = (int)Math.sqrt(D);

			if (D == n*n) {
				System.out.println(2*n - 1);
			} else if (D <= n*n + n) {
				System.out.println(2*n);
			} else {
				System.out.println(2*n + 1);
			}
		}
	}
}

