package BOJ_21919;

import java.util.*;

public class 소수최소공배수_김준우 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        Set<Integer> primes = new HashSet<>();

        int max = 0;
        while (n-- > 0) {
            int num = sc.nextInt();
            primes.add(num);
            max = Math.max(max, num);
        }

        boolean[] isPrime = prime(max);

        long answer = 1;

        for (int prime : primes) {
            if (!isPrime[prime]) {
                answer *= prime;
            }
        }

        System.out.println(answer == 1 ? -1 : answer);
    }

    // 에라토스테네스의 체를 이용해 소수 판별
    public static boolean[] prime(int n) {
        boolean[] isPrime = new boolean[n + 1];

        for (int i = 2; i * i <= n; i++) {
            if (!isPrime[i]) {
                for (int j = i * i; j <= n; j += i) {
                    isPrime[j] = true;
                }
            }
        }
        return isPrime;
    }
}