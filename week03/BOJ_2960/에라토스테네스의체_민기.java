package BOJ_2960;

import java.util.*;
import java.io.*;

public class 에라토스테네스의체_민기 {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int n = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());

		boolean[] isDeleted = new boolean[n+1]; //배열을 숫자처럼 사용하기 위해 +1로 구현
		int count = 0; //몇개가 삭제 되었는지 count

		for (int i = 2; i <=n; i++) {
			//만약 해당 숫자가 삭제가 안됐다면 default는 2
			if(!isDeleted[i]) {
				//p의 배수 삭제
				for (int j = i; j <= n; j+=i) {

					if (!isDeleted[j]) { // 이미 삭제된 숫자는 건너뛰기
						isDeleted[j] = true;
						count++;

						if (count == k) { // K번째 삭제된 수 찾기
							System.out.println(j);
							return;
						}
					}
				}
			}
		}
	}
}
