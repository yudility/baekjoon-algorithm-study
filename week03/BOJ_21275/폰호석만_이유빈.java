package BOJ_21275;

import java.io.*;
import java.util.StringTokenizer;

public class 폰호석만_이유빈 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        String a = st.nextToken();
        String b = st.nextToken();

        int cnt = 0;
        long correctX = 0;
        int correctA = 0, correctB = 0;

        for (int A=2; A<=36; A++) {
            for (int B=2; B<=36; B++) {
                if (A == B) continue;

                long xA = toDecimal(a, A);
                if (xA == -1) continue;

                long xB = toDecimal(b, B);
                if (xB == -1) continue;

                if (xA == xB) {
                    cnt++;
                    correctX = xA;
                    correctA = A;
                    correctB = B;
                }
            }
        }

        if (cnt == 1) {
            System.out.println(correctX + " " + correctA + " " + correctB);
        } else if (cnt > 1) {
            System.out.println("Multiple");
        } else {
            System.out.println("Impossible");
        }
        br.close();
    }

    static int charToInt(char ch) {
        if (ch >= '0' && ch <= '9') {
            return ch - '0';
        } else if (ch >= 'a' && ch <= 'z') {
            return ch - 'a' + 10;
        }
        return -1;
    }

    static long toDecimal(String str, int base) {
        long result = 0;
        for (int i=0; i<str.length(); i++) {
            int digit = charToInt(str.charAt(i));
            if (digit >= base) return -1;
            result = result * base + digit;
        }
        return result;
    }
}
