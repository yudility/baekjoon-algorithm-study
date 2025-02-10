package BOJ_2960;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class 에라토스테네스의체_김준우 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();
        List<Integer> list = new ArrayList<>();
        for (int i = 2; i <= n; i++) {
            list.add(i);
        }

        int count = 0;
        while (!list.isEmpty()) {
            int min = list.get(0);
            int multiplier = 1;
            int product = min * multiplier;
            while (product <= n) {
                if (list.contains(product)) {
                    list.remove((Integer) product); // 특정 값을 가진 요소를 제거하기 위해 캐스팅
                    count++;
                    if (count == k) {
                        System.out.println(product);
                        return;
                    }
                }
                multiplier++;
                product = min * multiplier;
            }
        }
    }
}
