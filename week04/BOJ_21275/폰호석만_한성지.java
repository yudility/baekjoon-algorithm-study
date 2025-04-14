package BOJ_21275;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 폰호석만_한성지 {

    static String xA, xB, x, max;  // xA, xB: 입력받은 문자열, x: 결과값, max: 최대값
    static long a, b;       // a, b 진법
    static int count;       // 가능한 결과의 수
    static int[] arr;       // 각 문자값 저장 배열

    public static void main(String[] args) throws IOException {
        // 입력
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");

        xA = input[0];
        xB = input[1];

        // 0 ≤ X < 2^63
        max = String.valueOf(Math.pow(2, 63));

        // 1 ~ 36진법에 해당하는 숫자 저장
        arr = new int[123];
        for (int i = 0; i < 9; i++) {
            // '1'~'9' 문자를 숫자 1~9로 저장
            // arr[49~57] == 1~9
            arr[i + '1'] = i + 1;
        }
        for (int i = 0; i < 26; i++) {
            // 'a'~'z'를 숫자 10~35로 저장
            // arr[97 ~122] == a~z == 10~35
            arr['a' + i] = i + 10;
        }

        solve();
        
        if (count == 0) {
            System.out.println("Impossible");
        } else if (count == 1) {
            String toInteger = x.substring(0, x.length() - 2);
            System.out.println(toInteger + " " + a + " " + b);
        } else {
            System.out.println("Multiple");
        }
    }

    public static void solve() {
        // a진법
        for (int i = 1; i <= 36; i++) {
            // b진법
            for (int j = 1; j <= 36; j++) {
                // a =/= b이므로 i == j일 때 넘김
                if (i == j) {
                    continue;
                }

                // 두 진법에서 유효한 값인지 체크
                if (check(i, xA) && check(j, xB)) {
                    // 값이 같은지 체크
                    if (find(i, xA).equals(find(j, xB))) {
                        // 결과값이 최대값보다 크면 패스
                        if (find(i, xA).compareTo(max) >= 1) {
                            continue;
                        }

                        // 가능한 경우의 수 증가
                        count++;
                        
                        // 결과 저장
                        x = find(i, xA);
                        a = i;
                        b = j;
                    }
                }
            }
        }
    }

    // 주어진 진법에서 문자열을 숫자로 변환
    public static String find(int a, String s) {
        int temp = 0;
        double result = 0;

        // 문자열을 뒤에서부터 한 자리씩 계산
        for (int i = s.length() - 1; i >= 0; i--) {
            int t = arr[s.charAt(i)];   // 각 문자의 값 가져옴
            result += Math.pow(a,temp) * t; // 해당 진법에 맞게 계산
            temp++;
        }

        return  String.valueOf(result); // 결과를 문자열로 반환
    }

    // 해당 진법으로 변환 가능한지 확인
    public static boolean check(int a, String s) {
        // 문자열의 각 문자가 해당 진법에서 유효한지 확인
        for (int i = 0; i < s.length(); i++) {
            // 진법보다 큰 문자 있을 시 false 반환
            if (a <= arr[s.charAt(i)]) {
                return  false;
            }
        }

        return true;
    }
}
