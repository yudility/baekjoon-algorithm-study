package BOJ_21275;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
public class 폰호석만_연예림 {

    static String xA, xB, x, max; // x = 결과값
    static long a, b; // 진법
    static int count;
    static int[] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");

        xA = input[0];
        xB = input[1];

        // x의 최댓값
        max = String.valueOf(Math.pow(2, 63));

        // 값 저장 ( 값 확인이 쉽도록 아스키코드 값으로 설정)
        arr = new int[200];
        for (int i = 0; i < 9; i++) {
            arr[i + '1'] = i + 1; // "1" -> 49 , 아스키코드를 인덱스로 값 찾기
        }
        for (int i = 0; i < 26; i++) {
            arr[i + 'a'] = i + 10; //  "a" -> 97, a~z -> 10 ~ 35
        }

        solve();

        if (count == 0) {
            System.out.println("Impossible");
        } else if (count == 1) {
            String toInt = x.substring(0, x.length() - 2);
            System.out.println(toInt + " " + a + " " + b);
        } else {
            System.out.println("Multiple");
        }
    }

    static void solve() {
        // 1 ~ 36 진법 체크
        for (int i = 1; i <= 36; i++) {
            for (int j = 1; j <= 36; j++) {
                if (i == j) { // 진법이 같은 경우는 제외
                    continue;
                }

                // 해당 진법으로 변환이 가능한지 확인
                if (check(i, xA) && check(j, xB)) {
                    // 해당 진법으로 변환 후 십진수 x 비교
                    if (find(i, xA).equals(find(j, xB))) {
                        // 변환 값이 최대값을 넘으면 패스
                        if (find(i, xA).compareTo(max) >= 1) {
                            continue;
                        }

                        count++;
                        x = find(i, xA);
                        a = i; // 몇 진법인지 저장
                        b = j;
                    }
                }
            }
        }
    }

    // 진법 변환 ep (32 진수 일때) -> 14*32^1 + 25*32^0;
    static String find(int a, String s) {
        int temp = 0;
        double sum = 0;
        for (int i = s.length()-1; i >= 0; i--) {
            int num = arr[s.charAt(i)];
            sum += num * Math.pow(a, temp); // 각 자리마다 값 구해주기
            temp++;
        }
        return String.valueOf(sum);
    }

    static boolean check(int a, String s) {
        for (int i = 0; i < s.length(); i++) {
            // 최대 진법이 a 보다 큰 경우 (답 보면 크거나 같은 경우기는 함.)
            if (arr[s.charAt(i)] >= a){
                return false;
            }
        }
        return true;
    }
}
