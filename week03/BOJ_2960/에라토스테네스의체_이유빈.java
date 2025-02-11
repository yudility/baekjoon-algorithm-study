package BOJ_2960;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class 에라토스테네스의체_이유빈 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        int cnt = 0;

        List<Integer> arr = new ArrayList<>();
        for (int i=2; i<=n; i++) {
            arr.add(i);
        }

        for (int i=2; i<=n; i++) {
            if (checkPrimeNum(i)) {
                for (int j=i; j<=n; j+=i) {
                    if (arr.remove(Integer.valueOf(j))) {
                        cnt++;
                        if (cnt == k) {
                            bw.write(String.valueOf(j));
                            break;
                        }
                    }
                }
            }
        }
        br.close();
        bw.flush();
        bw.close();
    }

    // TODO: 소수인지 확인 (소수면 true / false)
    static boolean checkPrimeNum(int p) {
        for (int i=2; i<=p/2; i++) {
            if (p % i == 0) {
                return false;
            }
        }
        return true;
    }
}
