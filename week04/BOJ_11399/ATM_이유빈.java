package BOJ_11399;

import java.io.*;
import java.util.Arrays;

public class ATM_이유빈 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        int[] arr = Arrays.stream(br.readLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();

        Arrays.sort(arr);

        int result = 0;

        for (int i=0; i<n; i++) {
            int tmp = 0;
            for (int k=0; k<=i; k++) {
                tmp += arr[k];
            }
            result += tmp;
        }
        bw.write(result + "");

        br.close();
        bw.flush();
        bw.close();
    }
}
