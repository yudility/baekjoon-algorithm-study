package BOJ_20006;

import java.util.*;
    import java.io.*;

public class 랭킹전대기열_박유진 {
  static int p;
  static int m;

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    StringTokenizer st = new StringTokenizer(br.readLine());
    p = Integer.parseInt(st.nextToken());
    m = Integer.parseInt(st.nextToken());

    ArrayList<Room> rooms = new ArrayList<>();

    st = new StringTokenizer(br.readLine());
    int level = Integer.parseInt(st.nextToken());
    String nickname = st.nextToken();

    rooms.add(new Room(new Player(level, nickname)));

    for(int i=1; i<p; i++){
      st = new StringTokenizer(br.readLine());
      level = Integer.parseInt(st.nextToken());
      nickname = st.nextToken();

      Player newPlayer = new Player(level, nickname);

      boolean joined = false;

      for(int j = 0; j < rooms.size(); j++) {
        if(rooms.get(j).join(newPlayer, m)) {
          joined = true;
          break;
        }
      }
      if(!joined) {
        rooms.add(new Room(newPlayer));
      }
    }

    for(int i=0; i<rooms.size(); i++){
      if(rooms.get(i).players.size()<m){
        bw.write("Waiting!" + "\n");
      }else{
        bw.write("Started!"+ "\n");
      }
      Collections.sort(rooms.get(i).players);
      for(Player player : rooms.get(i).players){
        bw.write(player.level + " "+ player.nickname+ "\n");
      }
    }
    bw.flush();
    bw.close();
  }
}

class Room{
  ArrayList<Player> players;

  public Room(Player newPlayer){
    players = new ArrayList<>();
    players.add(newPlayer);
  }

  public boolean join(Player newPlayer, int m){
    if(players.get(0).level - 10 > newPlayer.level || players.get(0).level + 10 < newPlayer.level || players.size() >= m){
      return false;
    }
    players.add(newPlayer);
    return true;
  }
}

class Player implements Comparable<Player>{
  int level;
  String nickname;

  public Player(int level, String nickname){
    this.level = level;
    this.nickname = nickname;
  }

  public int compareTo(Player other){
    return this.nickname.compareTo(other.nickname);
  }
}

