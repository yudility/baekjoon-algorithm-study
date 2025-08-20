package BOJ_20444;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * https://www.acmicpc.net/problem/20444
 */

public class 색종이와가위_연예림 {

    static long cut;
    static long target;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        cut = Long.parseLong(st.nextToken());
        target = Long.parseLong(st.nextToken());

        System.out.println(binarySearch(0, cut));

    }

    public static String binarySearch(long start, long end) {

        while (start <= end) {

            long mid = (start + end) / 2;
            long result = (mid + 1) * (cut - mid + 1);

            if (result == target) {
                return "YES";
            } else if (result > target) {
                end = mid - 1;
            } else {
                start = mid + 1;
            }

        }

        return "NO";

    }

}
