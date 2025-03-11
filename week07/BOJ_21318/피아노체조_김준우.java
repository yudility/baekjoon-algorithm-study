package BOJ_21318;

import java.io.*;
import java.util.StringTokenizer;

public class 피아노체조_김준우 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());

        int[] arr = new int[n + 1];
        int[] prefix = new int[n + 1];

        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        for (int i = 2; i <= n; i++) {
            prefix[i] = prefix[i - 1] + (arr[i] < arr[i - 1] ? 1 : 0);
        }

        int q = Integer.parseInt(br.readLine());
        while (q-- > 0) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());

            System.out.println(prefix[end] - prefix[start]);
        }
    }
}
