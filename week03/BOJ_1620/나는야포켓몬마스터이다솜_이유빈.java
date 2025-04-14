package BOJ_1620;

import java.io.*;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class 나는야포켓몬마스터이다솜_이유빈 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        Map<String, String> map1 = new HashMap<>();
        Map<String, String> map2 = new HashMap<>();

        for (int i=1; i<=n; i++) {
            String tmp;
            map1.put(tmp = br.readLine(), i+"");
            map2.put(i+"", tmp);
        }

        while (m-- > 0) {
            String input;
            if (map1.containsKey(input = br.readLine())) {
                bw.write(map1.get(input)+"\n");
            } else {
                bw.write(map2.get(input)+"\n");
            }
        }
        br.close();
        bw.flush();
        bw.close();

    }
}
