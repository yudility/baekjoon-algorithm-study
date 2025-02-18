package BOJ_11399;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class ATM_한성지 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        // 소요 시간을 오름차순으로 정렬
        List<Integer> people = new ArrayList<>(Arrays.stream(br.readLine().split(" "))
                .map(Integer::parseInt)
                .sorted()
                .collect(Collectors.toList()));

        int answer = 0;

        // 각 사람의 기여도를 곱하는 방식
        // 예: 사람이 5명일 때 첫번째 사람은 5명(본인 포함)의 인출 시간에 영향 미침 - x5
            // 3번째 사람은 3명의 사람에게 영향 미침 - x3
        for (int i = 0; i < N; i++) {
            answer += people.get(i) * (N - i);
        }

        // 누적합을 더하는 방식
//        int sum = 0;
//        for (int i = 0; i < N; i++) {
//            sum += people.get(i);
//            answer += sum;
//        }

        System.out.println(answer);
    }
}