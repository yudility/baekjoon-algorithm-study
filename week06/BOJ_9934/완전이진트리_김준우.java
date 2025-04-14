package BOJ_9934;

import java.util.*;

public class 완전이진트리_김준우 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int size = (int) Math.pow(2, n) - 1;
        int[] arr = new int[size];
        for (int i = 0; i < size; i++) {
            arr[i] = sc.nextInt();
        }

        StringBuilder[] result = new StringBuilder[n];
        for (int i = 0; i < n; i++) {
            result[i] = new StringBuilder();
        }

        printTree(arr, 0, size - 1, 0, result);

        for (StringBuilder stringBuilder : result) {
            System.out.println(stringBuilder);
        }

    }

    public static void printTree(int[] arr, int start, int end, int depth, StringBuilder[] result) {
        if (start > end) {
            return;
        }
        int mid = (start + end) / 2;
        result[depth].append(arr[mid]).append(" ");
        printTree(arr, start, mid - 1, depth + 1, result);
        printTree(arr, mid + 1, end, depth + 1, result);
    }
}
