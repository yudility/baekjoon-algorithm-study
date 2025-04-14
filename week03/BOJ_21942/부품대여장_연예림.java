package BOJ_21942;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class 부품대여장_연예림 {
    static int[] days = calDays();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        // 정보개수
        int n = Integer.parseInt(st.nextToken());
        // 대여기간 -> DDD/hh:mm
        String[] rt = st.nextToken().split("[:/]");
        int rentM = (Integer.parseInt(rt[0])*24*60) + (Integer.parseInt(rt[1])*60) + Integer.parseInt(rt[2]);
        // 분당 벌금
        int f = Integer.parseInt(st.nextToken());

        Map<String, Long> rentList = new HashMap<>();
        Map<String, Long> money = new TreeMap<>();

        // 2021-MM-dd hh:mm 부품이름 닉네임
        while (n-- > 0) {
            st = new StringTokenizer(br.readLine());

            // 시간 변환
            long current = toMinutes(st.nextToken(), st.nextToken());

            String product = st.nextToken();
            String name = st.nextToken();
            String id = String.join("_", product, name);

            if (rentList.containsKey(id)){ // 반납
                long gap = current - (rentList.remove(id) + rentM);
                if (gap > 0) { // 지각한 경우
                    money.put(name, money.getOrDefault(name,0L) + (gap * f));
                }
            } else {
                rentList.put(id, current);
            }
        }

        // 벌금 내야하는 사람들을 사전순으로 닉네임과 벌금 출력
        if (money.isEmpty()) {
            System.out.println(-1);
        } else {
            for (String id : money.keySet()) {
                System.out.println(id + " " +money.get(id));
            }
        }
    }

    static long toMinutes(String date, String time) {
        String[] datelt = date.split("-");
        String[] timelt = time.split(":");

        long total = 0;

        total += days[Integer.parseInt(datelt[1])] * 24 * 60;  // 이전 월들 -> 분
        total += Integer.parseInt(datelt[2]) * 24 * 60; // 일 -> 분
        total += Integer.parseInt(timelt[0]) * 60; // 시간 -> 분
        total += Integer.parseInt(timelt[1]); // 분

        return total;
    }

    static int[] calDays() {
        int[] days = {0, 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
        int[] result = new int[days.length];
        for (int i = 2; i < days.length; i++) {
            result[i] = result[i-1] + days[i-1];
        }
        return result;
    }
}
