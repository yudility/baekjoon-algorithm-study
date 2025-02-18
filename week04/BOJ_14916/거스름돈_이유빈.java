package BOJ_14916;

import java.io.*;

public class 거스름돈_이유빈 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());

        if (n < 5 && n % 2 != 0) {
            bw.write(-1+"");
        } else {
            int k = n / 5;
            int m = n % 5;

            if (m % 2 == 0) {
                bw.write((m/2 + k) + "");
            } else {
                bw.write(((k-1) + (m+5)/2) + "");
            }
        }

        br.close();
        bw.flush();
        bw.close();
    }
}
