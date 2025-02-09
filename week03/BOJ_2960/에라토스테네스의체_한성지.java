package BOJ_2960;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class 에라토스테네스의체_한성지 {
    public static void main(String[] args) throws IOException {
        // 입력
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        List<Integer> list = new ArrayList<>();

        // list에 값 채움 (2~n)
        for (int i = 2; i <= n; i++) {
            list.add(i);
        }

        int cnt = 0;        // k와 동일한지 확인하기 위한 카운트
        int answer = -1;    // 출력용 변수


        loopOut:
        for (int i = 0; i < list.size(); i++) {

            // 현재 수
            int num = list.get(i);

            // 소수인 경우
            if (isPrime(num)) {
                // 카운트 +1하고 k와 같은 경우 중지
                if (++cnt == k) {
                    answer = num;
                    break;
                }

                // 리스트에서 해당 소수 삭제
                list.remove(i);
                i--;

                // num의 배수 삭제, cnt가 k가 되면 중지
                for (int j = 0; j < list.size(); j++) {
                    if (list.get(j) % num == 0) {
                        if (++cnt == k) {
                            answer = list.get(j);
                            break loopOut;
                        }

                        // list에서 배수 삭제
                        list.remove(j);
                        j--;
                    }
                }
            }
        }

        // 출력
        System.out.println(answer);
    }

    // 소수인지 판별
    public static boolean isPrime(int num) {

        for (int i = 2; i < num / 2; i++) {
            if (num % i == 0) {
                return false;
            }
        }

        return true;
    }
}
