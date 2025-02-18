package BOJ_21275;

import java.util.*;
import java.io.*;
public class 폰호석만_민기 {
	// X는 0 이상 2^63 미만이어야 하므로 한계를 2^63로 설정합니다.
	static final long LIMIT = (1L << 63); // 2^63

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		String A = st.nextToken();
		String B = st.nextToken();

		// 각 문자열 A, B에 대해 해당 숫자를 표현하기 위해 필요한 최소 진법을 계산합니다.
		// 예를 들어 "ep"의 경우, 최대 문자가 'p'이고 이는 25에 해당하므로 최소 진법은 25+1=26이 됩니다.
		int base1 = getMinBase(A);
		int base2 = getMinBase(B);

		// 해를 저장할 변수들 초기화: foundX는 찾은 10진수 값, foundBase1와 foundBase2는 각각 A와 B의 진법
		long foundX = -1;
		int foundBase1 = 0, foundBase2 = 0;
		// 여러 조합이 존재하는지 확인하기 위한 flag
		boolean multiple = false;

		// 두 수가 모두 0인 경우 즉시 Multiple 출력
		if (A.equals("0") && B.equals("0")) {
			System.out.println("Multiple");
			return;
		}

		// 길이가 70을 초과하는 경우 즉시 Impossible 출력
		if (A.length() > 70 || B.length() > 70) {
			System.out.println("Impossible");
			return;
		}

		// 가능한 모든 진법 후보를 두 루프로 탐색합니다. (각 루프는 최소 진법부터 36까지)
		for (int baseA = base1; baseA <= 36; baseA++) {
			// 문자열 A를 baseA 진법으로 10진수로 변환합니다.
			// 변환할 수 없거나 오버플로우가 발생 시 -1을 반환하도록 했습니다.
			long valueA = convertToDecimal(A, baseA);
			if (valueA == -1) continue;  // 유효하지 않은 경우 다음 진법으로 넘어갑니다.

			for (int baseB = base2; baseB <= 36; baseB++) {
				// 문제 조건에 따라 A와 B는 서로 다른 진법이어야 합니다.
				if (baseB == baseA) continue;

				// 문자열 B를 baseB 진법에서 10진수로 변환합니다.
				long valueB = convertToDecimal(B, baseB);
				if (valueB == -1) continue; // 유효하지 않은 경우 건너뜁니다.

				// 두 변환 값이 동일한 경우, 이는 동일한 10진수 X로 표현된 경우임을 의미합니다.
				if (valueA == valueB) {
					// 첫 번째로 만족하는 경우라면 결과를 저장합니다.
					if (foundX == -1) {
						foundX = valueA;
						foundBase1 = baseA;
						foundBase2 = baseB;
					} else {
						// 이미 한 번 해를 찾은 경우 추가 해가 존재하면 "Multiple" 조건이 충족됩니다.
						multiple = true;
						break;
					}
				}
			}
			// 내부 루프에서 Multiple 상태가 확정되면 바깥 루프도 종료합니다.
			if (multiple) {
				break;
			}
		}

		// 결과에 따라 출력합니다.
		if (multiple) {
			System.out.println("Multiple");
		} else if (foundX == -1) {
			System.out.println("Impossible");
		} else {
			System.out.println(foundX + " " + foundBase1 + " " + foundBase2);
		}
	}

	/**
	 * 문자열 s에 대해 해당 수를 표현할 수 있는 최소 진법을 계산하는 함수입니다.
	 * 각 문자를 숫자로 변환했을 때 최대값 maxDigit를 찾고, 최소 진법은 (maxDigit + 1)로 결정됩니다.
	 * 단, 최소 진법은 2 이상이어야 하므로 Math.max를 이용합니다.
	 *
	 * @param s 입력 문자열 (예: "ep")
	 * @return s를 표현하기 위한 최소 진법 값 (예: "ep"이면 최소 진법은 26)
	 */
	static int getMinBase(String s) {
		int maxBase = 0;
		// 문자열의 각 문자를 순회하여 최대 값의 digit을 찾습니다.
		for (int i = 0; i < s.length(); i++) {
			char c = s.charAt(i);
			int digit;
			if ('0' <= c && c <= '9') {
				// '0'부터 '9'는 그대로 정수 값으로 변환
				digit = c - '0';
			} else if ('a' <= c && c <= 'z') {
				// 소문자 'a'부터 'z'는 10부터 35에 해당
				digit = c - 'a' + 10;
			} else if ('A' <= c && c <= 'Z') {
				// 대문자 'A'부터 'Z'도 10부터 35에 해당
				digit = c - 'A' + 10;
			} else {
				digit = 0;
			}
			// 현재까지의 최대 digit 값을 갱신합니다.
			if (digit > maxBase) {
				maxBase = digit;
			}
		}
		// 최소 진법은 maxDigit+1이지만, 그 값이 2보다 작으면 2를 반환합니다.
		return Math.max(maxBase + 1, 2);
	}

	/**
	 * 문자열 s를 주어진 진법(base)을 사용하여 10진수로 변환하는 함수입니다.
	 * 변환 과정에서 잘못된 문자나 오버플로우가 발생하면 -1을 반환합니다.
	 *
	 * @param s 변환할 문자열 (예: "ep")
	 * @param base 사용하려는 진법 (예: 32)
	 * @return s를 해당 진법으로 변환한 10진수 값, 변환 불가능한 경우 -1
	 */
	static long convertToDecimal(String s, int base) {
		if (s.equals("0")) return 0; // 0인 경우 즉시 반환
		long result = 0;
		// 문자열의 각 자릿수를 순회하면서 왼쪽부터 오른쪽으로 10진수 값을 계산합니다.
		for (int i = 0; i < s.length(); i++) {
			char c = s.charAt(i);
			int digit;
			// 입력 문자를 digit 값으로 변환합니다.
			if (c >= '0' && c <= '9')
				digit = c - '0';
			else if (c >= 'a' && c <= 'z')
				digit = c - 'a' + 10;
			else if (c >= 'A' && c <= 'Z')
				digit = c - 'A' + 10;
			else
				return -1; // 잘못된 문자일 경우 -1 반환

			// 해당 진법에서 허용하는 숫자 범위보다 크면 올바른 수가 아님
			if (digit >= base)
				return -1;
			// 오버플로우 검사: result * base + digit가 LIMIT을 넘어서면 오버플로우 발생
			if (result > (LIMIT - digit) / base)
				return -1;
			// 결과값 갱신: 각 자릿수에 해당하는 값을 더함.
			result = result * base + digit;
		}
		return result;
	}
}
