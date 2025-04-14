package BOJ_20115;

import java.io.*;
import java.util.Arrays;
import java.util.Collections;

public class 에너지드링크_이유빈 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        Double[] arr = Arrays.stream(br.readLine().split(" ")).mapToDouble(Double::parseDouble).boxed().toArray(Double[]::new);
        Arrays.sort(arr, Collections.reverseOrder());

        double result = arr[0];
        for (int i=1; i<n; i++) {
            result += arr[i]/2;
        }
        bw.write(result+"");
        br.close();
        bw.flush();
        bw.close();
    }
}
