package BOJ_1043;
import java.util.*;
import java.io.*;

public class 거짓말_박유진 {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());

    int n = Integer.parseInt(st.nextToken());
    int m = Integer.parseInt(st.nextToken());

    Set<Integer> knowsTruth = new HashSet<>(); // 진실을 아는 사람들

    // 진실을 아는 사람 입력 받아 저장
    st = new StringTokenizer(br.readLine());
    int truthKnowersCount = Integer.parseInt(st.nextToken());
    for(int i = 0; i < truthKnowersCount; i++) {
      knowsTruth.add(Integer.parseInt(st.nextToken()));
    }

    ArrayList<Set<Integer>> parties = new ArrayList<>();

    // 파티 정보 입력 받기
    for(int i = 0; i < m; i++) {
      parties.add(new HashSet<>());

      st = new StringTokenizer(br.readLine());
      int participantsCount = Integer.parseInt(st.nextToken());
      for(int j = 0; j < participantsCount; j++) {
        parties.get(i).add(Integer.parseInt(st.nextToken()));
      }
    }

    // 진실을 아는 사람이 더 이상 없을때 까지 반복
    boolean changed = true;
    while(changed) {
      changed = false;

      for(int i = 0; i < m; i++) {
        Set<Integer> party = parties.get(i);

        // 이 파티에 진실을 아는 사람이 있는지 확인
        boolean hasTruthKnower = false;

        for(int person : party) {
          if(knowsTruth.contains(person)) {
            hasTruthKnower = true;
            break;
          }
        }

        // 진실을 아는 사람이 있으면 모든 참가자가 진실을 알게 됨
        if(hasTruthKnower) {
          for(int person : party) {
            if(!knowsTruth.contains(person)) {
              knowsTruth.add(person);
              changed = true;
            }
          }
        }
      }
    }

    // 거짓말할 수 있는 파티의 개수 계산
    int count = 0;
    for(int i = 0; i < m; i++) {
      Set<Integer> party = parties.get(i);

      boolean canLie = true;

      for(int person : party) {
        if(knowsTruth.contains(person)) {
          canLie = false;
          break;
        }
      }

      if(canLie) {
        count++;
      }
    }

    System.out.println(count);
  }
}
