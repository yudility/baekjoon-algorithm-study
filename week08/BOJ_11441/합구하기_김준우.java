package BOJ_11441;

import java.util.Scanner;

public class 합구하기_김준우 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        int[] arr = new int[n + 1];
        arr[1] = sc.nextInt();
        for (int i = 2; i <= n; i++) {
            int a = sc.nextInt();
            arr[i] = arr[i - 1] + a;
        }
        int m = sc.nextInt();

        while (m-- > 0) {
            int start = sc.nextInt();
            int end = sc.nextInt();

            System.out.println(arr[end] - arr[start - 1]);
        }
    }
}
