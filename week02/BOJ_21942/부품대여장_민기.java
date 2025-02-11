package BOJ_21942;

import java.time.Duration;
import java.time.format.DateTimeFormatter;
import java.util.*;
import java.io.*;

import javax.swing.text.DateFormatter;

public class 부품대여장_민기 {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		//정보의 개수, 대여기간, 벌금
		int N = Integer.parseInt(st.nextToken());
		String L = st.nextToken();
		int F = Integer.parseInt(st.nextToken());

		//대여기간에서 dd,hh,mm으로 나눔 DDD형식이어서 day는 3자리로 받는경우도 있다
		int day = Integer.parseInt(L.substring(0, 3));
		int hour = Integer.parseInt(L.substring(4, 6));
		int minute = Integer.parseInt(L.substring(7, 9));

		//대여기간에 month는 들어가있지 않아 localdatetime은 사용이 불가능한 대신 duration으로 대여기간 표시
		Duration loanDuration = Duration.ofDays(day).plusHours(hour).plusMinutes(minute);

		//DateTimeFormatter를 정의 (모든 입력 년도는 2021년도 고정)
		DateTimeFormatter dft = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");

		//입력된 부품 대여장 로그를 저장해야된다
		List<String> logs = new ArrayList<>();
		for (int i = 0; i < N; i++) {
			logs.add(br.readLine());
		}

		//저장된 로그를 가져와 대여 시간과 반납 기한 계산
		for (String log : logs){

		}

		//벌금은 만약 같은 사람이 다른 종류의 물품을 대여했을경우 둘다 합쳐서 내야될것 같다
	}
}
