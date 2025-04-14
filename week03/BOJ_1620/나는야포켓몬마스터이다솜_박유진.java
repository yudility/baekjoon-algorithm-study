package BOJ_1620;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class 나는야포켓몬마스터이다솜_박유진 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder("");

        Map<Integer, String> numName = new HashMap<>();
        Map<String, Integer> nameNum = new HashMap<>();

        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        for (
                int i = 1;
                i <= n; i++) {
            String name = br.readLine();
            numName.put(i, name);
            nameNum.put(name, i);
        }

        while (m-- > 0) {
            String input = br.readLine();
            boolean isNum = Character.isDigit(input.charAt(0));

            if (isNum) {
                sb.append(numName.get(Integer.parseInt(input))).append("\n");
            } else {
                sb.append(nameNum.get(input)).append("\n");
            }

        }
        System.out.println(sb);
    }
}
