package BOJ_20006;

import java.util.*;
import java.io.*;

public class 랭킹전대기열_연예림
{

  // 정원
  static int M;

  // 사람 수
  static int P;

  // 방
  private static List<Room> rooms;

  // 사람
  private static List<Person> persons;

  public static void main(String[] args) throws IOException {

    // 입력
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st;

    // 인원, 정원
    st = new StringTokenizer(br.readLine());

    P = Integer.parseInt(st.nextToken());
    M = Integer.parseInt(st.nextToken());

    persons = new ArrayList<>();
    rooms = new ArrayList<>();

    // 레벨, 닉네임 (for 인원)
    for (int i = 0; i < P; i++) {
      st = new StringTokenizer(br.readLine());

      int level = Integer.parseInt(st.nextToken());
      String name = st.nextToken();

      persons.add(new Person(level, name));
    }

    // 처리
    inRoom();

    // 정답 (방 정보를 출력)
    StringBuilder sb = new StringBuilder();
    for (Room room : rooms) {
      if (room.isFull()) {
        sb.append("Started!").append("\n");
      } else {
        sb.append("Waiting!").append("\n");
      }

      room.members.stream()
        .sorted()
        .forEach(p -> sb.append(p.level).append(' ').append(p.name).append('\n'));

    }
    System.out.println(sb);
  }

  public static void inRoom() {
    // 모든 인원 반복
    for (Person person : persons) {

      boolean in = false;

      for (int j = 0; j < rooms.size(); j++) {
        Room room = rooms.get(j);

        if (room.checkLevel(person) && !room.isFull()) {

          room.addMember(person);

          in = true;
          break;
        }
      }

      if (in) {
        continue;
      }

      // 입장가능한 방이 없거나 레벨에 맞는 방이 없으면 방을 생성
      Room newRoom = new Room(person);
      rooms.add(newRoom);
    }

  }

  static class Room {

    int total = 0;
    int min;
    int max;
    List<Person> members = new ArrayList<>();

    public Room(Person person) {
      min = person.level - 10;
      max = person.level + 10;
      members.add(person);
    }

    public boolean checkLevel(Person person) {
      return person.level >= min && person.level <= max;
    }

    public void addMember(Person person) {
      members.add(person);
    }

    public boolean isFull() {
      return members.size() == M;
    }

  }

  static class Person implements Comparable<Person> {

    int level;
    String name;

    public Person(int level, String name) {
      this.level = level;
      this.name = name;
    }

    public int compareTo(Person other) {
      return this.name.compareTo(other.name);
    }

  }
}

