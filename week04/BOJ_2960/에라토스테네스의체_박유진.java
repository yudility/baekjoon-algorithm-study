package BOJ_2960;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class 에라토스테네스의체_박유진 {

    public static void main(String[] args) throws IOException {
        Map<Integer, Boolean> map = new TreeMap<>();
        List<Integer> primes = new ArrayList<>();

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        for (int i = 2; i <= n; i++) {
            map.put(i, true);
            boolean isPrime = true;
            for (int j = 0; j < primes.size(); j++) {
                if (i % primes.get(j) == 0){
                    isPrime = false;
                    break;
                }
            }
            if (isPrime) {
                primes.add(i);
            }
        }

        int primeIdx = 0;

        while (k > 0) {
            int i = 1;
            while (primes.get(primeIdx) * i <= n) {
                if (map.get(primes.get(primeIdx) * i)) {
                    map.put(primes.get(primeIdx)*i, false);
                    k--;
                    if (k == 0) {
                        System.out.println(primes.get(primeIdx)*i);
                        break;
                    }
                }
                i++;
            }
            primeIdx++;
        }
    }
}
