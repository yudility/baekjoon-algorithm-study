package BOJ_14916;

import java.util.*;
import java.io.*;

public class 거스름돈_민기 {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int count =0;

		while (N >= 0) {
			if (N % 5 == 0) { // 5원으로 나누어 떨어지면 바로 출력
				count += N / 5;
				System.out.println(count);
				return;
			}
			N -= 2; // 5원으로 나누어 떨어질 때까지 2원짜리를 사용
			count++;
		}

		System.out.println(-1); // 거슬러 줄 수 없는 경우
	}
}
