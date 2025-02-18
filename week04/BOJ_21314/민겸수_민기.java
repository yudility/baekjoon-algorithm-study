package BOJ_21314;


import java.io.*;

public class 민겸수_민기 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String input = br.readLine();

		// 최댓값과 최솟값을 저장할 StringBuilder 원래는 배열로 저장한다음 *10씩 하면서 실제 숫자가 나오게 하려고 했지만
		//너무 올래 걸려서 Stringbuilder로 설정
		StringBuilder max = new StringBuilder();
		StringBuilder min = new StringBuilder();

		// 연속된 M의 개수를 세기 위한 변수
		int mCount = 0;

		// 최댓값 구하기
		for (int i = 0; i < input.length(); i++) {
			if (input.charAt(i) == 'M') {
				mCount++;
			} else {
				// K를 만났을 때
				// count를 통해 이전 M의 개수와 현재 K를 조합하여 가장 큰 수 만들기
				if (mCount > 0) {
					max.append("5");
					for (int j = 0; j < mCount; j++) {
						max.append("0");
					}
				} else {
					max.append("5");
				}
				mCount = 0;
			}

			// 문자열 끝에 M이 연속으로 왔을때(이 부분은 생각을 하지 못했다)
			if (i == input.length() - 1 && mCount > 0) {
				for (int j = 0; j < mCount; j++) {
					max.append("1");
				}
			}
		}

		// 최솟값 구하기
		mCount = 0;
		for (int i = 0; i < input.length(); i++) {
			if (input.charAt(i) == 'M') {
				mCount++;

				// 1. M 다음에 K가 오는 경우 -> 최소값이기때문에 미리 M을 1로 처리를 해야지 최소값에 유리
				// 2. 마지막 문자가 M인 경우 -> 더 이상 기다릴 필요 없이 바로 처리
				if (i == input.length() - 1 || input.charAt(i + 1) == 'K') {
					min.append("1");
					for (int j = 1; j < mCount; j++) {
						min.append("0");
					}
					mCount = 0;
				}
			} else { // K를 만났을 때
				min.append("5");
				for (int j = 0; j < mCount - 1; j++) {
					min.append("0");
				}
				mCount = 0;
			}
		}

		System.out.println(max.toString());
		System.out.println(min.toString());
	}
}
