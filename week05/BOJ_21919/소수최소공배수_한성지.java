package BOJ_21919;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class 소수최소공배수_한성지 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());    // 수열 길이
        long[] A = new long[N];   // 길이가 N인 수열
        // 답이 2^63 미만이기 때문에 int 사용 시 범위 초과로 틀림 -> long 사용

        // 수열 채우기
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            A[i] = Long.parseLong(st.nextToken());
        }

        long answer = -1;    // 출력할 정답

        // 소수 담을 Set - 중복 제거 위해 set 사용
        Set<Long> primeSet = new HashSet<>();

        // 소수 판별해서 set에 담음
        for (long a : A) {
            if (isPrime(a)) {
                primeSet.add(a);
            }
        }

        // 소수가 있다면
        if (!primeSet.isEmpty()) {
            answer = 1;
            for (long p : primeSet) {
                answer *= p;    // 각 소수를 answer에 곱함
            }
        }

        System.out.println(answer);
    }

    // 소수 판별
    static boolean isPrime(long num) {

        if (num == 2) { // 2는 소수
            return true;
        }

        if (num % 2 == 0) { // 짝수 걸러냄
            return false;
        }

        // num이 소수가 아니면 반드시 그 수의 약수 중 하나는 num의 제곱근보다 작음
        for (long i = 3; i * i <= num; i += 2) {  // 홀수만 검사
            if (num % i == 0) {
                return false;   // 소수가 아님
            }
        }
        return true;    // 소수 맞음
    }
}