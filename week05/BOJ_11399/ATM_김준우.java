package BOJ_11399;

import java.util.Arrays;
import java.util.Scanner;

public class ATM_김준우 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        Arrays.sort(arr);

        int result = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j <= i; j++) {
                result += arr[j];
            }
        }
        System.out.println(result);
    }
}
