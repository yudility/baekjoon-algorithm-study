package BOJ_11399;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

//43분
public class ATM_연예림 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String N = br.readLine();
        String[] strings = br.readLine().split(" ");
        long sum = 0;
        long pre = 0;

        // 정렬하고 작은 수 부터 더하면 됨.
        List<Integer> sortedList = Arrays.stream(strings)
                .map(s -> Integer.parseInt(s))
                .sorted()
                .collect(Collectors.toList());

        for (int n : sortedList) {
            pre += n;
            sum += pre;
        }
        System.out.println(sum);
    }
}
