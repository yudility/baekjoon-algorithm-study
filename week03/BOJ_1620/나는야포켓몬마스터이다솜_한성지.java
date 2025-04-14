package BOJ_1620;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class 나는야포켓몬마스터이다솜_한성지 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        int n = Integer.parseInt(st.nextToken());   // 포켓몬 개수 n개
        int m = Integer.parseInt(st.nextToken());   // 문제 개수 m개

        // 시간 초과 문제로 Map 두가지 만듦
        Map<Integer, String> pokedexNum = new HashMap<>();   // 포켓몬 도감, 키가 포켓몬 번호
        Map<String, Integer> pokedexName = new HashMap<>();   // 포켓몬 도감, 키가 포켓몬 이름


        // 포켓몬 도감 채우기
        for (int i = 1; i <= n; i++) {
            String pokemonName = br.readLine();

            pokedexNum.put(i, pokemonName);
            pokedexName.put(pokemonName, i);
        }

        // 문제 맞추기
        for (int i = 0; i < m; i++) {
            String q = br.readLine();

            try {
                // q가 도감 번호일 경우
                int num = Integer.parseInt(q);
                sb.append(pokedexNum.get(num)).append("\n");
            } catch (NumberFormatException e) {
                // q가 포켓몬 이름일 경우
                sb.append(pokedexName.get(q)).append("\n");
            }
        }

        System.out.println(sb);
    }
}