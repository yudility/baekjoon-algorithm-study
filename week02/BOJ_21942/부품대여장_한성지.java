package BOJ_21942;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.StringTokenizer;

public class 부품대여장_한성지 {

    public static void main(String[] args) throws IOException, ParseException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());

        String l = st.nextToken();
        int ld = Integer.parseInt(l.substring(0, 3));
        int lh = Integer.parseInt(l.substring(4, 6));
        int lm = Integer.parseInt(l.substring(7));

        int range = ld * 24 * 60 + lm;
        int f = Integer.parseInt(st.nextToken());

        HashMap<String, String> map = new HashMap<>();
        HashMap<String, Long> fin = new HashMap<>();

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            String date = st.nextToken();
            String time = st.nextToken();
            String item = st.nextToken();
            String user = st.nextToken();
            String id = item + "_" + user;

            if (map.containsKey(id)) {
                String dateStr1 = map.get(id);
                String dateStr2 = date + " " + time;
                SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm");
                long d1 = format.parse(dateStr1).getTime();
                long d2 = format.parse(dateStr2).getTime();

                long diff = ((d2 - d1)) / (1000 * 60);
                if (diff > range) {
                    if (fin.containsKey(user)) {
                        fin.put(user, fin.get(user) + (diff - range) * f);
                    } else {
                        fin.put(user, (diff - range) * f);
                    }
                }

            } else {
                map.put(id, date + " " + time);
            }
        }

        List<String> list = new ArrayList<>(fin.keySet());
        list.sort((s1, s2) -> s1.compareTo(s2));
        if (fin.size() <= 0) {
            System.out.println(-1);
        } else {
            StringBuilder sb = new StringBuilder();
            for (String key : list) {
                sb.append(key + " " + fin.get(key)).append("\n");
            }

            System.out.println(sb);
        }
    }
}
