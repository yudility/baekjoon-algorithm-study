package BOJ_20115;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class 에너지드링크_한성지 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());    // 에너지 드링크 개수

        // java 15에서 사용 불가
//        // 에너지 드링크의 양을 내림차순 정렬하여 리스트로 저장
//        List<Integer> drink = Arrays.stream(br.readLine().split(" "))   // 배열을 stream으로 변환
//                .map(Integer::parseInt) // 배열 요소를 정수로 변환
//                .sorted(Comparator.reverseOrder())  // 내림차순 정렬
//                .toList();  // 불변 리스트 반환

        // .toList() -> new ArrayList<>()와 collect 사용
        List<Integer> drink = new ArrayList<>(Arrays.stream(br.readLine().split(" "))
                .map(Integer::parseInt)
                .sorted(Comparator.reverseOrder())
                .collect(Collectors.toList()));

        // java 15에서 사용 불가
//        double answer = drink.getFirst();   // answer에 가장 양 많은 음료 더함

        // getFirst() -> get(0)
        double answer = drink.get(0);

        // 다음 음료부터 절반씩 answer에 넣음
        for (int i = 1; i < N; i++) {
            answer += (double) drink.get(i) / 2;
        }

        System.out.println(answer);
    }
}