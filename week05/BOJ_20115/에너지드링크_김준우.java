package BOJ_20115;

import java.util.Scanner;
import java.util.Arrays;

public class 에너지드링크_김준우 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        double[] arr = new double[n];

        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        Arrays.sort(arr);
        double maxVal = arr[n - 1];

        for (int i = 0; i < n - 1; i++) {
            maxVal += arr[i] / 2;
        }

        if (maxVal == (int) maxVal) {
            System.out.println((int) maxVal);
        } else {
            System.out.println(maxVal);
        }
    }
}
