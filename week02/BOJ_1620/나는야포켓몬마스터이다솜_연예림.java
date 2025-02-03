package BOJ_1620;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.StringTokenizer;

public class 나는야포켓몬마스터이다솜_연예림 {
    public static void main(String[] args) throws IOException {
        // 입력
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        // 저장
        HashMap<String, Integer> map = new HashMap<>();
        List<String> list = new ArrayList<>();

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        // 도감 수록 n
        int n = Integer.parseInt(st.nextToken());
        // 문제 m
        int m = Integer.parseInt(st.nextToken());

        // 1 ~ n 영어
        for (int i = 1; i <= n; i++) {
            String name = br.readLine();
            map.put(name, i);
            list.add(name);
        }

        // m 번 퀴즈 : 영어 -> 숫자, 숫자 -> 영어
        for (int i = 0; i < m; i++) {
            String question = br.readLine();
            try {
                int num = Integer.parseInt(question);
                sb.append(list.get(num - 1)).append("\n");
            } catch (NumberFormatException e) {
                sb.append(map.get(question)).append("\n");
            }
        }
        System.out.println(sb);
        
        // Character.isLetter or Character.isDigit 로 가능 / 시간 두 배 차이
    }
}
