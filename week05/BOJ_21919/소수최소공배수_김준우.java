package BOJ_21919;

import java.util.*;

public class 소수최소공배수_김준우 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        Set<Integer> primes = new HashSet<>();

        while (n-- > 0) {
            int num = sc.nextInt();
            if (isPrime(num)) {
                primes.add(num);
            }
        }

        // 소수가 존재하면 곱셈, 없으면 -1 반환
        int answer = primes.stream()
                .reduce((a, b) -> a * b)
                .orElse(-1);

        System.out.println(answer);
    }

    public static boolean isPrime(int n) {
        if (n < 2) {
            return false;
        }
        if (n == 2) {
            return true;
        }

        for (int i = 2; i < n; i++) {
            if (n % i == 0) {
                return false;
            }
        }
        return true;
    }
}
